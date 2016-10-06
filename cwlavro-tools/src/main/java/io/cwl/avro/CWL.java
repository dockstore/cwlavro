package io.cwl.avro;

import com.github.jsonldjava.core.JsonLdError;
import com.github.jsonldjava.core.JsonLdOptions;
import com.github.jsonldjava.core.JsonLdProcessor;
import com.github.jsonldjava.utils.JsonUtils;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Helper class that performs utility functions relating to CWL parsing and manipulation.
 * @author dyuen
 */
public class CWL {

    private final Gson gson;
    private static final Logger log = LoggerFactory.getLogger(CWL.class);

    public CWL() throws GsonBuildException, JsonParseException {
        gson = getTypeSafeCWLToolDocument();
    }

    /**
     * Convert a String representation of a CWL file to a run json
     * @param output
     * @return
     */
    public Map<String, Object> extractRunJson(final String output) {
        final CommandLineTool commandLineTool = gson.fromJson(output, CommandLineTool.class);
        final Map<String, Object> runJson = new HashMap<>();

        for(final CommandInputParameter inputParam : commandLineTool.getInputs()){
            final String idString = inputParam.getId().toString();
            final Object stub = getStub(inputParam.getType(), null);
            runJson.put(idString.substring(idString.lastIndexOf('#') + 1), stub);
        }
        for(final CommandOutputParameter outParam : commandLineTool.getOutputs()){
            final String idString = outParam.getId().toString();
            final Object stub = getStub(outParam.getType(), null);
            runJson.put(idString.substring(idString.lastIndexOf('#') + 1), stub);
        }
        return runJson;
    }

    public Map<String, String> extractCWLTypes(final String output){
        final CommandLineTool commandLineTool = gson.fromJson(output, CommandLineTool.class);
        final Map<String, String> typeJson = new HashMap<>();

        for(final CommandInputParameter inputParam : commandLineTool.getInputs()){
            final String idString = inputParam.getId().toString();
            String type = convertCWLType(inputParam.getType());
            typeJson.put(idString.substring(idString.lastIndexOf('#') + 1), type);
        }
        for(final CommandOutputParameter outParam : commandLineTool.getOutputs()){
            final String idString = outParam.getId().toString();
            String type = convertCWLType(outParam.getType());
            typeJson.put(idString.substring(idString.lastIndexOf('#') + 1), outParam.getType().toString());
        }
        return typeJson;
    }

    private String convertCWLType(Object cwlType) {
        String type = null;
        if (cwlType instanceof List){
            for(final Object entry : (Iterable) cwlType){
                if (entry != null){
                    type = entry.toString();
                }
            }
            if (type == null) {
                throw new RuntimeException("CWL format unknown");
            }
        } else{
            type = cwlType.toString();
        }
        return type;
    }

    /**
     * This is an ugly mapping between CWL's primitives and Java primitives
     * @param type the CWL type
     * @param value
     * @return a stub Java object corresponding to type
     */
    public static Object getStub(final Object type, final String value) {
        Object stub = value == null? "fill me in" : value;
        if (type instanceof List){
            // if its a list, call recursively and return first non-stub entry
            for(final Object entry : (Iterable) type){
                final Object arrayStub = getStub(entry, value);
                if (!Objects.equals(arrayStub, stub)){
                    return arrayStub;
                }
            }
            return stub;
        }
        final String strType = type.toString();
        switch (strType) {
        case "File":
            final Map<String, String> file = new HashMap<>();
            file.put("class", "File");
            file.put("path", value != null ? value : "fill me in");
            stub = file;
            break;
        case "boolean":
            stub = value != null? Boolean.parseBoolean(value) : Boolean.FALSE;
            break;
        case "int":
            stub = value != null? Integer.parseInt(value) :0;
            break;
        case "long":
            stub = value != null? Long.parseLong(value) :0L;
            break;
        case "float":
            stub = value != null? Float.parseFloat(value) :0.0;
            break;
        case "double":
            stub = value != null? Double.parseDouble(value) : Double.MAX_VALUE;
            break;
        default:
            break;
        }
        return stub;
    }

    /**
     * @return a gson instance that can properly convert CWL tools into a typesafe Java object
     */
    public static Gson getTypeSafeCWLToolDocument() throws GsonBuildException, JsonParseException {
        final Type hintType = new TypeToken<List<Any>>() {}.getType();
        final Type commandInputParameterType = new TypeToken<List<CommandInputParameter>>() {}.getType();
        final Type commandOutputParameterType = new TypeToken<List<CommandOutputParameter>>() {}.getType();
        final Type inputParameterType = new TypeToken<List<InputParameter>>() {}.getType();
        final Type expressionToolOutputParameterType = new TypeToken<List<ExpressionToolOutputParameter>>() {}.getType();
        final Type workflowOutputParameterType = new TypeToken<List<WorkflowOutputParameter>>() {}.getType();
        final Type workflowStepInputType = new TypeToken<List<WorkflowStepInput>>() {}.getType();

        final Gson sequenceSafeGson = new GsonBuilder().registerTypeAdapter(CharSequence.class,
                (JsonDeserializer<CharSequence>) (json, typeOfT, context) -> json.getAsString()).create();

        return new GsonBuilder().registerTypeAdapter(CharSequence.class, (JsonDeserializer<CharSequence>) (json, typeOfT, context) -> json.getAsString())
                .registerTypeAdapter(hintType, (JsonDeserializer) (json, typeOfT, context) -> {
                    Collection<Object> hints = new ArrayList<>();
                    for (final JsonElement jsonElement : json.getAsJsonArray()) {
                        final Object o = sequenceSafeGson.fromJson(jsonElement, Object.class);
                        hints.add(o);
                    }
                    return hints;

                }).registerTypeAdapter(commandInputParameterType, (JsonDeserializer) (json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, CommandInputParameter.class, true);
                }).registerTypeAdapter(commandOutputParameterType, (JsonDeserializer) (json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, CommandOutputParameter.class, true);
                }).registerTypeAdapter(inputParameterType, (JsonDeserializer) (json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, InputParameter.class, true);
                }).registerTypeAdapter(expressionToolOutputParameterType, (JsonDeserializer) (json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, ExpressionToolOutputParameter.class, true);
                }).registerTypeAdapter(workflowOutputParameterType, (JsonDeserializer) (json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, WorkflowOutputParameter.class, true);
                }).registerTypeAdapter(workflowStepInputType, (JsonDeserializer) (json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, WorkflowStepInput.class, false);
                }).serializeNulls().setPrettyPrinting().create();

    }

    /**
     * Helper for storing CWL JSON elements into Collections of objects, as expected by CWL Avro classes
     * @param json
     * @param sequenceSafeGson
     * @param c
     * @param objectType
         * @return Collection of objects of Class c
         */
    private static Collection<Object> gsonBuilderHelper(JsonElement json, Gson sequenceSafeGson, Class c, boolean objectType) throws
            GsonBuildException, JsonParseException {
        Collection<Object> objectCollection = new ArrayList<>();
        if (json.isJsonArray()) {
            for (final JsonElement jsonElement : json.getAsJsonArray()) {
                final Object o = sequenceSafeGson.fromJson(jsonElement, c);
                objectCollection.add(o);
            }
            return objectCollection;
        } else if (json.isJsonObject()){
            Map<String, Object> map = sequenceSafeGson.fromJson(json.getAsJsonObject(), new TypeToken<Map<String,Object>>() {}.getType());

            try {
                Object item;
                Method setId;
                Method setSource = null;
                Method setType = null;
                setId = c.getMethod("setId", CharSequence.class);
                if (objectType) {
                    setType = c.getMethod("setType", Object.class);
                } else {
                    setSource = c.getMethod("setSource", Object.class);
                }
                for (Map.Entry<String, Object> itemObj : map.entrySet()) {
                    if (itemObj.getValue() instanceof Map) {
                        String itemJson = sequenceSafeGson.toJson(itemObj.getValue());
                        item = sequenceSafeGson.fromJson(itemJson, c);
                    } else {
                        item = c.newInstance();
                        if (objectType) {
                            setType.invoke(item, itemObj.getValue());
                        } else {
                            setSource.invoke(item, itemObj.getValue());
                        }
                    }
                    setId.invoke(item, itemObj.getKey());
                    objectCollection.add(item);
                }
            } catch (InstantiationException ex) {
                log.error("The given class " + c.getName() + " could not be instantiated.", ex);
                throw new GsonBuildException("Error casting to class " + c.getName());
            } catch (IllegalAccessException ex) {
                log.error("The given class " + c.getName() + " could not be instantiated due to access privileges.", ex);
                throw new GsonBuildException("Error casting to class " + c.getName());
            } catch (NoSuchMethodException ex) {
                log.error("The given class " + c.getName() + " was expected to have the methods setId and one of setType and setSource, but no such method exists.", ex);
                throw new GsonBuildException("No matching methods for class " + c.getName());
            } catch (InvocationTargetException ex) {
                log.error("There was an exception during the running of a method for class " + c.getName() + ".", ex);
                throw new GsonBuildException("Error running method for class " + c.getName());
            }

            return objectCollection;

        } else{
            throw new JsonParseException("Invalid JSON entry.");
        }
    }

    public static class GsonBuildException extends RuntimeException {
        public GsonBuildException(String message) {
            super(message);
        }
    }

    public ImmutablePair<String, String> parseCWL(final String cwlFile) {
        // update seems to just output the JSON version without checking file links
        final String[] s = { "cwltool", "--non-strict", "--print-pre", cwlFile };
        final ImmutablePair<String, String> execute = io.cwl.avro.Utilities
                .executeCommand(Joiner.on(" ").join(Arrays.asList(s)), false,  Optional.absent(), Optional.absent());
        return execute;
    }

    public Map cwlJson2Map(final String cwljson) {
        Map jsonObject;
        try {
            jsonObject = (Map) JsonUtils.fromString(cwljson);
            // Create a context JSON map containing prefixes and definitions
            Map context = new HashMap();
            // Customise context...
            // Create an instance of JsonLdOptions with the standard JSON-LD options
            JsonLdOptions options = new JsonLdOptions();
            // Customise options...
            // Call whichever JSONLD function you want! (e.g. compact)
            Map compact = (Map) JsonLdProcessor.compact(jsonObject, context, options);
            return compact;
        } catch (IOException | JsonLdError e) {
            throw new RuntimeException(e);
        }
    }
}
