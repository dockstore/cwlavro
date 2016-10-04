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
import com.google.gson.reflect.TypeToken;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
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
    private final Logger log = LoggerFactory.getLogger(CWL.class);

    public CWL(){
        gson =  getTypeSafeCWLToolDocument();
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
    public static Gson getTypeSafeCWLToolDocument() {
        final java.lang.reflect.Type hintType = new TypeToken<List<Any>>() {}.getType();
        final java.lang.reflect.Type commandInputParameterType = new TypeToken<List<CommandInputParameter>>() {}.getType();
        final java.lang.reflect.Type commandOutputParameterType = new TypeToken<List<CommandOutputParameter>>() {}.getType();
        final java.lang.reflect.Type inputParameterType = new TypeToken<List<InputParameter>>() {}.getType();
        final java.lang.reflect.Type expressionToolOutputParameterType = new TypeToken<List<ExpressionToolOutputParameter>>() {}.getType();
        final java.lang.reflect.Type workflowOutputParameterType = new TypeToken<List<WorkflowOutputParameter>>() {}.getType();
        final java.lang.reflect.Type workflowStepInputType = new TypeToken<List<WorkflowStepInput>>() {}.getType();

        final Gson sequenceSafeGson = new GsonBuilder().registerTypeAdapter(CharSequence.class,
                (JsonDeserializer<CharSequence>) (json, typeOfT, context) -> json.getAsString()).create();

        return new GsonBuilder().registerTypeAdapter(CharSequence.class,
                (JsonDeserializer<CharSequence>) (json, typeOfT, context) -> json.getAsString())
                .registerTypeAdapter(hintType, (JsonDeserializer) (json, typeOfT, context) -> {
                    Collection<Object> hints = new ArrayList<>();
                    for (final JsonElement jsonElement : json.getAsJsonArray()) {
                        final Object o = sequenceSafeGson.fromJson(jsonElement, Object.class);
                        hints.add(o);
                    }
                    return hints;

                }).registerTypeAdapter(commandInputParameterType, (JsonDeserializer) (json, typeOfT, context) -> {
                    Collection<Object> commandInputParameter = new ArrayList<>();
                    if (json.isJsonArray()) {
                        for (final JsonElement jsonElement : json.getAsJsonArray()) {
                            final Object o = sequenceSafeGson.fromJson(jsonElement, CommandInputParameter.class);
                            commandInputParameter.add(o);
                        }
                        return commandInputParameter;
                    } else if (json.isJsonObject()){
                        // store object as a map
                        Map<String, Object> map = sequenceSafeGson.fromJson(json.getAsJsonObject(), new TypeToken<Map<String,Object>>() {}.getType());

                        // Iterate over keys, add to collection
                        CommandInputParameter inParam;
                        for (Map.Entry<String, Object> inputParameterObj : map.entrySet()) {
                            if (inputParameterObj.getValue() instanceof Map) {
                                String inputParameterJson = sequenceSafeGson.toJson(inputParameterObj.getValue());
                                inParam = sequenceSafeGson.fromJson(inputParameterJson, CommandInputParameter.class);
                            } else {
                                inParam = new CommandInputParameter();
                                inParam.setType(inputParameterObj.getValue());
                            }
                            inParam.setId(inputParameterObj.getKey());
                            commandInputParameter.add(inParam);
                        }
                        return commandInputParameter;

                    } else{
                        throw new RuntimeException("unexpected JSON entry");
                    }
                }).registerTypeAdapter(commandOutputParameterType, (JsonDeserializer) (json, typeOfT, context) -> {
                    Collection<Object> commandOutputParameter = new ArrayList<>();
                    if (json.isJsonArray()) {
                        for (final JsonElement jsonElement : json.getAsJsonArray()) {
                            final Object o = sequenceSafeGson.fromJson(jsonElement, CommandOutputParameter.class);
                            commandOutputParameter.add(o);
                        }
                        return commandOutputParameter;
                    } else if (json.isJsonObject()){
                        // store object as a map
                        Map<String, Object> map = sequenceSafeGson.fromJson(json.getAsJsonObject(), new TypeToken<Map<String,Object>>() {}.getType());

                        // Iterate over keys, add to collection
                        CommandOutputParameter outParam;
                        for (Map.Entry<String, Object> outputParameterObj : map.entrySet()) {
                            if (outputParameterObj.getValue() instanceof Map) {
                                String outputParameterJson = sequenceSafeGson.toJson(outputParameterObj.getValue());
                                outParam = sequenceSafeGson.fromJson(outputParameterJson, CommandOutputParameter.class);
                            } else {
                                outParam = new CommandOutputParameter();
                                outParam.setType(outputParameterObj.getValue());
                            }
                            outParam.setId(outputParameterObj.getKey());
                            commandOutputParameter.add(outParam);
                        }
                        return commandOutputParameter;

                    } else{
                        throw new RuntimeException("unexpected JSON entry");
                    }
                }).registerTypeAdapter(inputParameterType, (JsonDeserializer) (json, typeOfT, context) -> {
                    Collection<Object> inputParameter = new ArrayList<>();
                    if (json.isJsonArray()) {
                        for (final JsonElement jsonElement : json.getAsJsonArray()) {
                            final Object o = sequenceSafeGson.fromJson(jsonElement, InputParameter.class);
                            inputParameter.add(o);
                        }
                        return inputParameter;
                    } else if (json.isJsonObject()){
                        // store object as a map
                        Map<String, Object> map = sequenceSafeGson.fromJson(json.getAsJsonObject(), new TypeToken<Map<String,Object>>() {}.getType());

                        // Iterate over keys, add to collection
                        InputParameter inParam;
                        for (Map.Entry<String, Object> inputParameterObj : map.entrySet()) {
                            if (inputParameterObj.getValue() instanceof Map) {
                                String inputParameterJson = sequenceSafeGson.toJson(inputParameterObj.getValue());
                                inParam = sequenceSafeGson.fromJson(inputParameterJson, InputParameter.class);
                            } else {
                                inParam = new InputParameter();
                                inParam.setType(inputParameterObj.getValue());
                            }
                            inParam.setId(inputParameterObj.getKey());
                            inputParameter.add(inParam);
                        }
                        return inputParameter;

                    } else{
                        throw new RuntimeException("unexpected JSON entry");
                    }
                }).registerTypeAdapter(expressionToolOutputParameterType, (JsonDeserializer) (json, typeOfT, context) -> {
                    Collection<Object> expressionToolOutputParameter = new ArrayList<>();
                    if (json.isJsonArray()) {
                        for (final JsonElement jsonElement : json.getAsJsonArray()) {
                            final Object o = sequenceSafeGson.fromJson(jsonElement, ExpressionToolOutputParameter.class);
                            expressionToolOutputParameter.add(o);
                        }
                        return expressionToolOutputParameter;
                    } else if (json.isJsonObject()){
                        // store object as a map
                        Map<String, Object> map = sequenceSafeGson.fromJson(json.getAsJsonObject(), new TypeToken<Map<String,Object>>() {}.getType());

                        // Iterate over keys, add to collection
                        ExpressionToolOutputParameter expressionToolOutputParam;
                        for (Map.Entry<String, Object> expressionToolOutputParameterObj : map.entrySet()) {
                            if (expressionToolOutputParameterObj.getValue() instanceof Map) {
                                String expressionToolOutputParameterJson = sequenceSafeGson.toJson(expressionToolOutputParameterObj.getValue());
                                expressionToolOutputParam = sequenceSafeGson.fromJson(expressionToolOutputParameterJson, ExpressionToolOutputParameter.class);
                            } else {
                                expressionToolOutputParam = new ExpressionToolOutputParameter();
                                expressionToolOutputParam.setType(expressionToolOutputParameterObj.getValue());
                            }
                            expressionToolOutputParam.setId(expressionToolOutputParameterObj.getKey());
                            expressionToolOutputParameter.add(expressionToolOutputParam);
                        }
                        return expressionToolOutputParameter;

                    } else{
                        throw new RuntimeException("unexpected JSON entry");
                    }
                }).registerTypeAdapter(workflowOutputParameterType, (JsonDeserializer) (json, typeOfT, context) -> {
                    Collection<Object> workflowOutputParameter = new ArrayList<>();
                    if (json.isJsonArray()) {
                        for (final JsonElement jsonElement : json.getAsJsonArray()) {
                            final Object o = sequenceSafeGson.fromJson(jsonElement, WorkflowOutputParameter.class);
                            workflowOutputParameter.add(o);
                        }
                        return workflowOutputParameter;

                    } else if (json.isJsonObject()){
                        // store object as a map
                        Map<String, WorkflowOutputParameter> map = sequenceSafeGson.fromJson(json.getAsJsonObject(), new TypeToken<Map<String,WorkflowOutputParameter>>() {}.getType());

                        // Iterate over keys, add to collection
                        for (Map.Entry<String, WorkflowOutputParameter> workflowOutputParameterObj : map.entrySet()) {
                            WorkflowOutputParameter outParam = workflowOutputParameterObj.getValue();
                            outParam.setId(workflowOutputParameterObj.getKey());
                            workflowOutputParameter.add(outParam);
                        }
                        return workflowOutputParameter;

                    } else{
                        throw new RuntimeException("unexpected JSON entry");
                    }
                }).registerTypeAdapter(workflowStepInputType, (JsonDeserializer) (json, typeOfT, context) -> {
                    Collection<Object> workflowStepInput = new ArrayList<>();
                    if (json.isJsonArray()) {
                        for (final JsonElement jsonElement : json.getAsJsonArray()) {
                            final Object o = sequenceSafeGson.fromJson(jsonElement, WorkflowStepInput.class);
                            workflowStepInput.add(o);
                        }
                        return workflowStepInput;
                    } else if (json.isJsonObject()){
                        // store object as a map
                        Map<String, Object> map = sequenceSafeGson.fromJson(json.getAsJsonObject(), new TypeToken<Map<String,Object>>() {}.getType());

                        // Iterate over keys, add to collection
                        WorkflowStepInput wsInput;
                        for (Map.Entry<String, Object> workflowStepInputObj : map.entrySet()) {
                            if (workflowStepInputObj.getValue() instanceof Map) {
                                String workflowStepInputJson = sequenceSafeGson.toJson(workflowStepInputObj.getValue());
                                wsInput = sequenceSafeGson.fromJson(workflowStepInputJson, WorkflowStepInput.class);
                            } else {
                                wsInput = new WorkflowStepInput();
                                wsInput.setSource(workflowStepInputObj.getValue());
                            }
                            wsInput.setId(workflowStepInputObj.getKey());
                            workflowStepInput.add(wsInput);
                        }
                        return workflowStepInput;

                    } else{
                        throw new RuntimeException("unexpected JSON entry");
                    }
                })
                .serializeNulls().setPrettyPrinting()
                .create();
    }


    private static Object getCWLObject(Gson gson1, JsonElement jsonElement) {
        final String elementClass = jsonElement.getAsJsonObject().get("class").getAsString();
        Class<SpecificRecordBase> anyClass;
        try {
            anyClass = (Class<SpecificRecordBase>) Class.forName("io.cwl.avro." + elementClass);
        } catch (ClassNotFoundException e) {
            //TODO: this should be a log
            e.printStackTrace();
            anyClass = null;
        }
        return gson1.fromJson(jsonElement, anyClass);
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
