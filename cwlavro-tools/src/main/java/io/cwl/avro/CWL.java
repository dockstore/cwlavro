package io.cwl.avro;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class that performs utility functions relating to CWL parsing and manipulation.
 *
 * @author dyuen
 */
public class CWL {

    private static final String DEFAULT_BUNNY_VERSION = "1.0.3";

    private final Gson gson;
    private static final Logger LOG = LoggerFactory.getLogger(CWL.class);
    private final boolean useBunny;

    private final String localBunnyPath;

    public CWL() {
        this(false, null);
    }

    public CWL(boolean useBunny, INIConfiguration configuration) throws GsonBuildException, JsonParseException {
        gson = getTypeSafeCWLToolDocument();

        String bunnyVersion = DEFAULT_BUNNY_VERSION;
        if (configuration != null) {
            bunnyVersion = configuration.getString("bunny-version", DEFAULT_BUNNY_VERSION);
            if (!Objects.equals(DEFAULT_BUNNY_VERSION, bunnyVersion)) {
                LOG.warn("Running with Bunny " + bunnyVersion + " , Dockstore tests with " + DEFAULT_BUNNY_VERSION);
            }
        }
        String trimmedBunnyVersion = bunnyVersion.substring(0,5);
        String bunnyGithubVersion =
            "https://github.com/rabix/bunny/releases/download/v" + bunnyVersion + "/rabix-" + trimmedBunnyVersion + ".tar.gz";
        this.localBunnyPath =
            ".dockstore/libraries/rabix-" + trimmedBunnyVersion + "/rabix-cli-" + trimmedBunnyVersion + "/rabix";


        this.useBunny = useBunny;
        if (useBunny) {
            // grab rabix
            String libraryLocation =
                    System.getProperty("user.home") + java.io.File.separator + ".dockstore" + java.io.File.separator + "libraries"
                            + java.io.File.separator;
            URL rabixURL;
            String rabixFilename;
            try {
                rabixURL = new URL(bunnyGithubVersion);
                rabixFilename = new java.io.File(rabixURL.toURI().getPath()).getName();
            } catch (MalformedURLException | URISyntaxException e) {
                throw new RuntimeException("Could not create rabix location", e);
            }
            String rabixTarget = libraryLocation + rabixFilename;
            java.io.File rabixTargetFile = new java.io.File(rabixTarget);
            if (!rabixTargetFile.exists()) {
                try {
                    FileUtils.copyURLToFile(rabixURL, rabixTargetFile);
                    //TODO: version this path so it properly handles upgrade events

                    File tarFile = CompressionUtilities.unGzip(rabixTargetFile, rabixTargetFile.getParentFile());
                    File rabixDirectory = new File(FilenameUtils.removeExtension(tarFile.getAbsolutePath()));
                    FileUtils.forceMkdir(rabixDirectory);
                    CompressionUtilities.unTar(tarFile, rabixDirectory);
                } catch (IOException e) {
                    throw new RuntimeException("Could not download or uncompress rabix bunny", e);
                } catch (ArchiveException e) {
                    throw new RuntimeException("Could not uncompress rabix bunny", e);
                }
            }

            try {
                Path path = Paths.get(System.getProperty("user.home"), localBunnyPath);
                HashSet<PosixFilePermission> posixFilePermissions = Sets
                        .newHashSet(PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_EXECUTE);
                Files.setPosixFilePermissions(path, posixFilePermissions);
            } catch (IOException e) {
                throw new RuntimeException("Could not set permissions on rabix bunny", e);
            }
        }
    }

    /**
     * Convert a String representation of a CWL file to a run json
     *
     * @param output
     * @return
     */
    public Map<String, Object> extractRunJson(final String output) {
        final CommandLineTool commandLineTool = gson.fromJson(output, CommandLineTool.class);
        final Map<String, Object> runJson = new HashMap<>();

        final String fullToolId = commandLineTool.getId().toString();
        final String toolId = fullToolId.substring(fullToolId.lastIndexOf('#') + 1);

        for (final CommandInputParameter inputParam : commandLineTool.getInputs()) {
            final String idString = inputParam.getId().toString();
            final Object stub = getStub(inputParam.getType(),
                    inputParam.getDefault$() != null ? inputParam.getDefault$().toString() : null);
            // transfer over a format value as well
            if (inputParam.getFormat() != null) {
                ((Map)stub).put("format", inputParam.getFormat());
            }
            final String partialIdString = idString.substring(idString.lastIndexOf('#') + 1);
            runJson.put(partialIdString.replaceFirst(toolId, ""), stub);
        }
        for (final CommandOutputParameter outParam : commandLineTool.getOutputs()) {
            final String idString = outParam.getId().toString();
            final Object stub = getStub(outParam.getType(), null);
            final String partialIdString = idString.substring(idString.lastIndexOf('#') + 1);
            runJson.put(partialIdString.replaceFirst(toolId, ""), stub);
        }
        return runJson;
    }

    public Map<String, String> extractCWLTypes(final String output) {
        final CommandLineTool commandLineTool = gson.fromJson(output, CommandLineTool.class);
        final Map<String, String> typeJson = new HashMap<>();

        for (final CommandInputParameter inputParam : commandLineTool.getInputs()) {
            final String idString = inputParam.getId().toString();
            String type = convertCWLType(inputParam.getType());
            typeJson.put(idString.substring(idString.lastIndexOf('#') + 1), type);
        }
        for (final CommandOutputParameter outParam : commandLineTool.getOutputs()) {
            final String idString = outParam.getId().toString();
            String type = convertCWLType(outParam.getType());
            typeJson.put(idString.substring(idString.lastIndexOf('#') + 1), outParam.getType().toString());
        }
        return typeJson;
    }

    private String convertCWLType(Object cwlType) {
        String type = null;
        if (cwlType instanceof List) {
            for (final Object entry : (Iterable)cwlType) {
                if (entry != null) {
                    type = entry.toString();
                }
            }
            if (type == null) {
                throw new RuntimeException("CWL format unknown");
            }
        } else {
            type = cwlType.toString();
        }
        return type;
    }

    /**
     * Returns a stub Object for one item
     *
     * @param strType     the CWL type
     * @param defaultStub a default value for stub, ex. "fill me in"
     * @param value       to be assigned to stub
     * @return
     */
    private static Object getStubForItem(final String strType, final Object defaultStub, final String value) {
        final Map<String, String> file = new HashMap<>();
        Object stub = defaultStub;

        switch (strType) {
        case "File":
            file.put("class", "File");
            file.put("path", value != null ? value : "/tmp/fill_me_in.txt");
            stub = file;
            break;
        case "Directory":
            file.put("class", "Directory");
            file.put("path", value != null ? value : "/tmp/fill_directory_in");
            stub = file;
            break;
        case "boolean":
            stub = value != null ? Boolean.parseBoolean(value) : Boolean.FALSE;
            break;
        case "int":
            stub = value != null ? Integer.parseInt(value) : 0;
            break;
        case "long":
            stub = value != null ? Long.parseLong(value) : 0L;
            break;
        case "float":
            stub = value != null ? Float.parseFloat(value) : 0.0;
            break;
        case "double":
            stub = value != null ? Double.parseDouble(value) : Double.MAX_VALUE;
            break;
        default:
            break;
        }
        return stub;
    }

    /**
     * Returns the appropriate stub Object for arrays
     *
     * @param strType     the CWL type
     * @param defaultStub a default value for stub, ex. "fill me in"
     * @param value       to be assigned to stub
     * @return
     */
    private static Object getStubForArray(final String strType, final Object defaultStub, final String value) {
        final List<Object> list = new ArrayList<>();
        Object itemStub;

        switch (strType) {
        case "File":
            if (value == null) {
                itemStub = getStubForItem(strType, defaultStub, "/tmp/fill_me_in_a.txt");
                list.add(itemStub);
                itemStub = getStubForItem(strType, defaultStub, "/tmp/fill_me_in_b.txt");
                list.add(itemStub);
            }
            break;
        case "Directory":
            if (value == null) {
                itemStub = getStubForItem(strType, defaultStub, "/tmp/fill_directory_in_a");
                list.add(itemStub);
                itemStub = getStubForItem(strType, defaultStub, "/tmp/fill_directory_in_b");
                list.add(itemStub);
            }
            break;
        default:
            itemStub = getStubForItem(strType, defaultStub, value);
            list.add(itemStub);
            list.add(itemStub);
            break;

        }
        return list;
    }

    /**
     * This is an ugly mapping between CWL's primitives and Java primitives
     *
     * @param type  the CWL type
     * @param value a default value
     * @return a stub Java object corresponding to type
     */
    public static Object getStub(final Object type, final String value) {
        Object stub = value == null ? "fill me in" : value;
        if (type instanceof List) {
            // if its a list, call recursively and return first non-stub entry
            for (final Object entry : (Iterable)type) {
                final Object arrayStub = getStub(entry, value);
                if (!Objects.equals(arrayStub, stub)) {
                    return arrayStub;
                }
            }
            return stub;
        } else if (type instanceof Map) {
            // TODO: this is pretty messy, find a better solution
            String nestedItems = (String)((Map)type).get("items");
            String nestedType = (String)((Map)type).get("type");
            return getStub(nestedItems + (nestedType.equals("array") ? "[]" : ""), value);
        }
        final String strType = type.toString();

        if (strType.contains("type=array")) {
            // this is how cwltool returns array types
            // expected strType format: {type=array, items=File} in some arbitrary order
            Matcher insideBraces = Pattern.compile("\\{(.*?)\\}").matcher(strType);
            if (insideBraces.find()) {
                String[] properties = insideBraces.group(1).split(",");
                String itemsType = "";
                for (String property : properties) {
                    if (property.contains("items=")) {
                        itemsType = property.split("=")[1];
                    }
                }
                return getStubForArray(itemsType, stub, value);
            }
            return stub;
        } else if (strType.endsWith("[]")) {
            // this is one way how bunny handles array types
            String itemsType = StringUtils.stripEnd(strType, "[]");
            return getStubForArray(itemsType, stub, value);
        } else {
            return getStubForItem(strType, stub, value);
        }
    }

    /**
     * @return a gson instance that can properly convert CWL tools into a typesafe Java object
     */
    public static Gson getTypeSafeCWLToolDocument() throws GsonBuildException, JsonParseException {
        final Type hintType = new TypeToken<List<Object>>() {
        }.getType();
        final Type commandInputParameterType = new TypeToken<List<CommandInputParameter>>() {
        }.getType();
        final Type commandOutputParameterType = new TypeToken<List<CommandOutputParameter>>() {
        }.getType();
        final Type inputParameterType = new TypeToken<List<InputParameter>>() {
        }.getType();
        final Type expressionToolOutputParameterType = new TypeToken<List<ExpressionToolOutputParameter>>() {
        }.getType();
        final Type workflowOutputParameterType = new TypeToken<List<WorkflowOutputParameter>>() {
        }.getType();
        final Type workflowStepInputType = new TypeToken<List<WorkflowStepInput>>() {
        }.getType();

        final Gson sequenceSafeGson = new GsonBuilder()
                .registerTypeAdapter(CharSequence.class, (JsonDeserializer<CharSequence>)(json, typeOfT, context) -> json.getAsString())
                .create();

        return new GsonBuilder()
                .registerTypeAdapter(CharSequence.class, (JsonDeserializer<CharSequence>)(json, typeOfT, context) -> json.getAsString())
                .registerTypeAdapter(hintType, (JsonDeserializer)(json, typeOfT, context) -> {
                    Collection<Object> hints = new ArrayList<>();
                    for (final JsonElement jsonElement : json.getAsJsonArray()) {
                        final Object o = sequenceSafeGson.fromJson(jsonElement, Object.class);
                        hints.add(o);
                    }
                    return hints;

                }).enableComplexMapKeySerialization()
                .registerTypeAdapter(commandInputParameterType, (JsonDeserializer)(json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, CommandInputParameter.class, true);
                }).registerTypeAdapter(commandOutputParameterType, (JsonDeserializer)(json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, CommandOutputParameter.class, true);
                }).registerTypeAdapter(inputParameterType, (JsonDeserializer)(json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, InputParameter.class, true);
                }).registerTypeAdapter(expressionToolOutputParameterType, (JsonDeserializer)(json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, ExpressionToolOutputParameter.class, true);
                }).registerTypeAdapter(workflowOutputParameterType, (JsonDeserializer)(json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, WorkflowOutputParameter.class, true);
                }).registerTypeAdapter(workflowStepInputType, (JsonDeserializer)(json, typeOfT, context) -> {
                    return gsonBuilderHelper(json, sequenceSafeGson, WorkflowStepInput.class, false);
                }).serializeNulls().setPrettyPrinting().create();

    }

    /**
     * Helper for storing CWL JSON elements into Collections of objects, as expected by CWL Avro classes
     *
     * @param json
     * @param sequenceSafeGson
     * @param c
     * @param objectType
     * @return Collection of objects of Class c
     */
    private static Collection<Object> gsonBuilderHelper(JsonElement json, Gson sequenceSafeGson, Class c, boolean objectType)
            throws GsonBuildException, JsonParseException {
        Collection<Object> objectCollection = new ArrayList<>();
        if (json.isJsonArray()) {
            for (final JsonElement jsonElement : json.getAsJsonArray()) {
                final Object o = sequenceSafeGson.fromJson(jsonElement, c);
                // hack to transfer over defaults
                if (jsonElement instanceof JsonObject && ((JsonObject)jsonElement).has("default")) {
                    JsonElement defaultJsonElement = ((JsonObject)jsonElement).get("default");
                    if (defaultJsonElement instanceof JsonObject) {
                        final JsonObject defaultValue = ((JsonObject) jsonElement).getAsJsonObject("default");
                        if (o instanceof CommandInputParameter) {
                            ((CommandInputParameter)o).setDefault$(defaultValue);
                        }
                    }
                    if (defaultJsonElement instanceof JsonPrimitive) {
                        final JsonPrimitive defaultValue = ((JsonObject) jsonElement).getAsJsonPrimitive("default");
                        if (o instanceof CommandInputParameter){
                            String defaultVal= defaultValue.toString().replaceAll("^\"|\"$", "");
                            ((CommandInputParameter)o).setDefault$(defaultVal);
                        }
                    }
                    if (defaultJsonElement instanceof JsonNull) {
                        if (o instanceof CommandInputParameter){
                            ((CommandInputParameter)o).setDefault$(null);
                        }
                    }
                    if (defaultJsonElement instanceof JsonNull) {
                        if (o instanceof CommandInputParameter){
                            ((CommandInputParameter)o).setDefault$(null);
                        }
                    }
                }

                objectCollection.add(o);
            }
            return objectCollection;
        } else if (json.isJsonObject()) {
            Map<String, Object> map = sequenceSafeGson.fromJson(json.getAsJsonObject(), new TypeToken<Map<String, Object>>() {
            }.getType());

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
                LOG.error("The given class " + c.getName() + " could not be instantiated.", ex);
                throw new GsonBuildException("Error casting to class " + c.getName());
            } catch (IllegalAccessException ex) {
                LOG.error("The given class " + c.getName() + " could not be instantiated due to access privileges.", ex);
                throw new GsonBuildException("Error casting to class " + c.getName());
            } catch (NoSuchMethodException ex) {
                LOG.error("The given class " + c.getName()
                        + " was expected to have the methods setId and one of setType and setSource, but no such method exists.", ex);
                throw new GsonBuildException("No matching methods for class " + c.getName());
            } catch (InvocationTargetException ex) {
                LOG.error("There was an exception during the running of a method for class " + c.getName() + ".", ex);
                throw new GsonBuildException("Error running method for class " + c.getName());
            }

            return objectCollection;

        } else {
            throw new JsonParseException("Invalid JSON entry.");
        }
    }

    public String getLocalBunnyPath() {
        return localBunnyPath;
    }

    public static class GsonBuildException extends RuntimeException {
        public GsonBuildException(String message) {
            super(message);
        }
    }

    public ImmutablePair<String, String> parseCWL(final String cwlFile) {
        if (useBunny) {
            String libraryLocation = System.getProperty("user.home") + java.io.File.separator + localBunnyPath;
            final String[] s = { libraryLocation, "--resolve-app", cwlFile };
            final ImmutablePair<String, String> execute = io.cwl.avro.Utilities
                    .executeCommand(Joiner.on(" ").join(Arrays.asList(s)), false, Optional.absent(), Optional.absent());
            return execute;
        } else {
            // update seems to just output the JSON version without checking file links
            final String[] s = { "cwltool", "--non-strict", "--print-pre", cwlFile };
            final ImmutablePair<String, String> execute = io.cwl.avro.Utilities
                    .executeCommand(Joiner.on(" ").join(Arrays.asList(s)), false, Optional.absent(), Optional.absent());
            return execute;
        }
    }
}
