/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.cwl.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class InputRecordSchema extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7666013640544454576L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"InputRecordSchema\",\"namespace\":\"io.cwl.avro\",\"fields\":[{\"name\":\"fields\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"InputRecordField\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"The name of the field\\n\",\"jsonldPredicate\":\"@id\",\"inherited_from\":\"https://w3id.org/cwl/salad#RecordField\"},{\"name\":\"doc\",\"type\":[\"null\",\"string\"],\"doc\":\"A documentation string for this field\\n\",\"jsonldPredicate\":\"rdfs:comment\",\"inherited_from\":\"https://w3id.org/cwl/salad#RecordField\"},{\"name\":\"type\",\"type\":[{\"type\":\"enum\",\"name\":\"CWLType\",\"symbols\":[\"null\",\"boolean\",\"int\",\"long\",\"float\",\"double\",\"string\",\"File\",\"Directory\"],\"extends\":\"https://w3id.org/cwl/salad#PrimitiveType\"},\"InputRecordSchema\",{\"type\":\"record\",\"name\":\"InputEnumSchema\",\"fields\":[{\"name\":\"symbols\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"doc\":\"Defines the set of valid symbols.\",\"jsonldPredicate\":{\"_id\":\"https://w3id.org/cwl/salad#symbols\",\"_type\":\"@id\",\"identity\":true},\"inherited_from\":\"https://w3id.org/cwl/salad#EnumSchema\"},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"Enum_symbol\",\"namespace\":\"io.cwl.avro.EnumSchemaPackage.type\",\"symbols\":[\"enum\"]},\"doc\":\"Must be `enum`\",\"jsonldPredicate\":{\"_id\":\"https://w3id.org/cwl/salad#type\",\"_type\":\"@vocab\",\"typeDSL\":true,\"refScope\":2},\"inherited_from\":\"https://w3id.org/cwl/salad#EnumSchema\"},{\"name\":\"label\",\"type\":[\"null\",\"string\"],\"doc\":\"A short, human-readable label of this object.\",\"jsonldPredicate\":\"rdfs:label\",\"inherited_from\":\"https://w3id.org/cwl/cwl#SchemaBase\"},{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"jsonldPredicate\":\"@id\"},{\"name\":\"inputBinding\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"CommandLineBinding\",\"doc\":\"\\nWhen listed under `inputBinding` in the input schema, the term\\n\\\"value\\\" refers to the the corresponding value in the input object.  For\\nbinding objects listed in `CommandLineTool.arguments`, the term \\\"value\\\"\\nrefers to the effective value after evaluating `valueFrom`.\\n\\nThe binding behavior when building the command line depends on the data\\ntype of the value.  If there is a mismatch between the type described by\\nthe input schema and the effective value, such as resulting from an\\nexpression evaluation, an implementation must use the data type of the\\neffective value.\\n\\n  - **string**: Add `prefix` and the string to the command line.\\n\\n  - **number**: Add `prefix` and decimal representation to command line.\\n\\n  - **boolean**: If true, add `prefix` to the command line.  If false, add\\n      nothing.\\n\\n  - **File**: Add `prefix` and the value of\\n    [`File.path`](#File) to the command line.\\n\\n  - **Directory**: Add `prefix` and the value of\\n    [`Directory.path`](#Directory) to the command line.\\n\\n  - **array**: If `itemSeparator` is specified, add `prefix` and the join\\n      the array into a single string with `itemSeparator` separating the\\n      items.  Otherwise first add `prefix`, then recursively process\\n      individual elements.\\n      If the array is empty, it does not add anything to command line.\\n\\n  - **object**: Add `prefix` only, and recursively add object fields for\\n      which `inputBinding` is specified.\\n\\n  - **null**: Add nothing.\\n\",\"fields\":[{\"name\":\"loadContents\",\"type\":[\"null\",\"boolean\"],\"doc\":\"Only valid when `type: File` or is an array of `items: File`.\\n\\nRead up to the first 64 KiB of text from the file and place it in the\\n\\\"contents\\\" field of the file object for use by expressions.\\n\",\"jsonldPredicate\":\"cwl:loadContents\",\"inherited_from\":\"https://w3id.org/cwl/cwl#InputBinding\"},{\"name\":\"position\",\"type\":[\"null\",\"int\"],\"doc\":\"The sorting key.  Default position is 0.\"},{\"name\":\"prefix\",\"type\":[\"null\",\"string\"],\"doc\":\"Command line prefix to add before the value.\"},{\"name\":\"separate\",\"type\":[\"null\",\"boolean\"],\"doc\":\"If true (default), then the prefix and value must be added as separate\\ncommand line arguments; if false, prefix and value must be concatenated\\ninto a single command line argument.\\n\"},{\"name\":\"itemSeparator\",\"type\":[\"null\",\"string\"],\"doc\":\"Join the array elements into a single string with the elements\\nseparated by by `itemSeparator`.\\n\"},{\"name\":\"valueFrom\",\"type\":[\"null\",\"string\",{\"type\":\"enum\",\"name\":\"Expression\",\"doc\":\"'Expression' is not a real type.  It indicates that a field must allow\\nruntime parameter references.  If [InlineJavascriptRequirement](#InlineJavascriptRequirement)\\nis declared and supported by the platform, the field must also allow\\nJavascript expressions.\\n\",\"symbols\":[\"ExpressionPlaceholder\"]}],\"doc\":\"If `valueFrom` is a constant string value, use this as the value and\\napply the binding rules above.\\n\\nIf `valueFrom` is an expression, evaluate the expression to yield the\\nactual value to use to build the command line and apply the binding\\nrules above.  If the inputBinding is associated with an input\\nparameter, the value of `self` in the expression will be the value of\\nthe input parameter.  Input parameter defaults (as specified by the\\n`InputParameter.default` field) must be applied before evaluating the\\nexpression.\\n\\nWhen a binding is part of the `CommandLineTool.arguments` field,\\nthe `valueFrom` field is required.\\n\",\"jsonldPredicate\":\"cwl:valueFrom\"},{\"name\":\"shellQuote\",\"type\":[\"null\",\"boolean\"],\"doc\":\"If `ShellCommandRequirement` is in the requirements for the current command,\\nthis controls whether the value is quoted on the command line (default is true).\\nUse `shellQuote: false` to inject metacharacters for operations such as pipes.\\n\\nIf `shellQuote` is true or not provided, the implementation must not\\npermit interpretation of any shell metacharacters or directives.\\n\"}],\"extends\":\"https://w3id.org/cwl/cwl#InputBinding\"}],\"jsonldPredicate\":\"cwl:inputBinding\"}],\"extends\":[\"https://w3id.org/cwl/salad#EnumSchema\",\"https://w3id.org/cwl/cwl#InputSchema\"]},{\"type\":\"record\",\"name\":\"InputArraySchema\",\"fields\":[{\"name\":\"items\",\"type\":[\"CWLType\",\"InputRecordSchema\",\"InputEnumSchema\",\"InputArraySchema\",\"string\",{\"type\":\"array\",\"items\":[\"CWLType\",\"InputRecordSchema\",\"InputEnumSchema\",\"InputArraySchema\",\"string\"]}],\"doc\":\"Defines the type of the array elements.\",\"jsonldPredicate\":{\"_id\":\"https://w3id.org/cwl/salad#items\",\"_type\":\"@vocab\",\"refScope\":2},\"inherited_from\":\"https://w3id.org/cwl/salad#ArraySchema\"},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"Array_symbol\",\"namespace\":\"io.cwl.avro.ArraySchemaPackage.type\",\"symbols\":[\"array\"]},\"doc\":\"Must be `array`\",\"jsonldPredicate\":{\"_id\":\"https://w3id.org/cwl/salad#type\",\"_type\":\"@vocab\",\"typeDSL\":true,\"refScope\":2},\"inherited_from\":\"https://w3id.org/cwl/salad#ArraySchema\"},{\"name\":\"label\",\"type\":[\"null\",\"string\"],\"doc\":\"A short, human-readable label of this object.\",\"jsonldPredicate\":\"rdfs:label\",\"inherited_from\":\"https://w3id.org/cwl/cwl#SchemaBase\"},{\"name\":\"inputBinding\",\"type\":[\"null\",\"CommandLineBinding\"],\"jsonldPredicate\":\"cwl:inputBinding\"}],\"extends\":[\"https://w3id.org/cwl/salad#ArraySchema\",\"https://w3id.org/cwl/cwl#InputSchema\"],\"specialize\":[{\"specializeFrom\":\"https://w3id.org/cwl/salad#RecordSchema\",\"specializeTo\":\"https://w3id.org/cwl/cwl#InputRecordSchema\"},{\"specializeFrom\":\"https://w3id.org/cwl/salad#EnumSchema\",\"specializeTo\":\"https://w3id.org/cwl/cwl#InputEnumSchema\"},{\"specializeFrom\":\"https://w3id.org/cwl/salad#ArraySchema\",\"specializeTo\":\"https://w3id.org/cwl/cwl#InputArraySchema\"},{\"specializeFrom\":\"https://w3id.org/cwl/salad#PrimitiveType\",\"specializeTo\":\"https://w3id.org/cwl/cwl#CWLType\"}]},\"string\",{\"type\":\"array\",\"items\":[\"CWLType\",\"InputRecordSchema\",\"InputEnumSchema\",\"InputArraySchema\",\"string\"]}],\"doc\":\"The field type\\n\",\"jsonldPredicate\":{\"_id\":\"https://w3id.org/cwl/salad#type\",\"_type\":\"@vocab\",\"typeDSL\":true,\"refScope\":2},\"inherited_from\":\"https://w3id.org/cwl/salad#RecordField\"},{\"name\":\"inputBinding\",\"type\":[\"null\",\"CommandLineBinding\"],\"jsonldPredicate\":\"cwl:inputBinding\"},{\"name\":\"label\",\"type\":[\"null\",\"string\"],\"doc\":\"A short, human-readable label of this process object.\",\"jsonldPredicate\":\"rdfs:label\"}],\"extends\":\"https://w3id.org/cwl/salad#RecordField\",\"specialize\":[{\"specializeFrom\":\"https://w3id.org/cwl/salad#RecordSchema\",\"specializeTo\":\"https://w3id.org/cwl/cwl#InputRecordSchema\"},{\"specializeFrom\":\"https://w3id.org/cwl/sa","lad#EnumSchema\",\"specializeTo\":\"https://w3id.org/cwl/cwl#InputEnumSchema\"},{\"specializeFrom\":\"https://w3id.org/cwl/salad#ArraySchema\",\"specializeTo\":\"https://w3id.org/cwl/cwl#InputArraySchema\"},{\"specializeFrom\":\"https://w3id.org/cwl/salad#PrimitiveType\",\"specializeTo\":\"https://w3id.org/cwl/cwl#CWLType\"}]}}],\"doc\":\"Defines the fields of the record.\",\"jsonldPredicate\":{\"_id\":\"https://w3id.org/cwl/salad#fields\",\"mapSubject\":\"name\",\"mapPredicate\":\"type\"},\"inherited_from\":\"https://w3id.org/cwl/salad#RecordSchema\"},{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"Record_symbol\",\"namespace\":\"io.cwl.avro.RecordSchemaPackage.type\",\"symbols\":[\"record\"]},\"doc\":\"Must be `record`\",\"jsonldPredicate\":{\"_id\":\"https://w3id.org/cwl/salad#type\",\"_type\":\"@vocab\",\"typeDSL\":true,\"refScope\":2},\"inherited_from\":\"https://w3id.org/cwl/salad#RecordSchema\"},{\"name\":\"label\",\"type\":[\"null\",\"string\"],\"doc\":\"A short, human-readable label of this object.\",\"jsonldPredicate\":\"rdfs:label\",\"inherited_from\":\"https://w3id.org/cwl/cwl#SchemaBase\"},{\"name\":\"name\",\"type\":[\"null\",\"string\"],\"jsonldPredicate\":\"@id\"}],\"extends\":[\"https://w3id.org/cwl/salad#RecordSchema\",\"https://w3id.org/cwl/cwl#InputSchema\"],\"specialize\":[{\"specializeFrom\":\"https://w3id.org/cwl/salad#RecordField\",\"specializeTo\":\"https://w3id.org/cwl/cwl#InputRecordField\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<InputRecordSchema> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<InputRecordSchema> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<InputRecordSchema> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<InputRecordSchema> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<InputRecordSchema> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this InputRecordSchema to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a InputRecordSchema from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a InputRecordSchema instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static InputRecordSchema fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Defines the fields of the record. */
  public java.util.List<io.cwl.avro.InputRecordField> fields;
  /** Must be `record` */
  public io.cwl.avro.RecordSchemaPackage.type.Record_symbol type;
  /** A short, human-readable label of this object. */
  public java.lang.CharSequence label;
  public java.lang.CharSequence name;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public InputRecordSchema() {}

  /**
   * All-args constructor.
   * @param fields Defines the fields of the record.
   * @param type Must be `record`
   * @param label A short, human-readable label of this object.
   * @param name The new value for name
   */
  public InputRecordSchema(java.util.List<io.cwl.avro.InputRecordField> fields, io.cwl.avro.RecordSchemaPackage.type.Record_symbol type, java.lang.CharSequence label, java.lang.CharSequence name) {
    this.fields = fields;
    this.type = type;
    this.label = label;
    this.name = name;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return fields;
    case 1: return type;
    case 2: return label;
    case 3: return name;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: fields = (java.util.List<io.cwl.avro.InputRecordField>)value$; break;
    case 1: type = (io.cwl.avro.RecordSchemaPackage.type.Record_symbol)value$; break;
    case 2: label = (java.lang.CharSequence)value$; break;
    case 3: name = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'fields' field.
   * @return Defines the fields of the record.
   */
  public java.util.List<io.cwl.avro.InputRecordField> getFields() {
    return fields;
  }


  /**
   * Sets the value of the 'fields' field.
   * Defines the fields of the record.
   * @param value the value to set.
   */
  public void setFields(java.util.List<io.cwl.avro.InputRecordField> value) {
    this.fields = value;
  }

  /**
   * Gets the value of the 'type' field.
   * @return Must be `record`
   */
  public io.cwl.avro.RecordSchemaPackage.type.Record_symbol getType() {
    return type;
  }


  /**
   * Sets the value of the 'type' field.
   * Must be `record`
   * @param value the value to set.
   */
  public void setType(io.cwl.avro.RecordSchemaPackage.type.Record_symbol value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'label' field.
   * @return A short, human-readable label of this object.
   */
  public java.lang.CharSequence getLabel() {
    return label;
  }


  /**
   * Sets the value of the 'label' field.
   * A short, human-readable label of this object.
   * @param value the value to set.
   */
  public void setLabel(java.lang.CharSequence value) {
    this.label = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Creates a new InputRecordSchema RecordBuilder.
   * @return A new InputRecordSchema RecordBuilder
   */
  public static io.cwl.avro.InputRecordSchema.Builder newBuilder() {
    return new io.cwl.avro.InputRecordSchema.Builder();
  }

  /**
   * Creates a new InputRecordSchema RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new InputRecordSchema RecordBuilder
   */
  public static io.cwl.avro.InputRecordSchema.Builder newBuilder(io.cwl.avro.InputRecordSchema.Builder other) {
    if (other == null) {
      return new io.cwl.avro.InputRecordSchema.Builder();
    } else {
      return new io.cwl.avro.InputRecordSchema.Builder(other);
    }
  }

  /**
   * Creates a new InputRecordSchema RecordBuilder by copying an existing InputRecordSchema instance.
   * @param other The existing instance to copy.
   * @return A new InputRecordSchema RecordBuilder
   */
  public static io.cwl.avro.InputRecordSchema.Builder newBuilder(io.cwl.avro.InputRecordSchema other) {
    if (other == null) {
      return new io.cwl.avro.InputRecordSchema.Builder();
    } else {
      return new io.cwl.avro.InputRecordSchema.Builder(other);
    }
  }

  /**
   * RecordBuilder for InputRecordSchema instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<InputRecordSchema>
    implements org.apache.avro.data.RecordBuilder<InputRecordSchema> {

    /** Defines the fields of the record. */
    private java.util.List<io.cwl.avro.InputRecordField> fields;
    /** Must be `record` */
    private io.cwl.avro.RecordSchemaPackage.type.Record_symbol type;
    /** A short, human-readable label of this object. */
    private java.lang.CharSequence label;
    private java.lang.CharSequence name;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.cwl.avro.InputRecordSchema.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.fields)) {
        this.fields = data().deepCopy(fields()[0].schema(), other.fields);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.type)) {
        this.type = data().deepCopy(fields()[1].schema(), other.type);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.label)) {
        this.label = data().deepCopy(fields()[2].schema(), other.label);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.name)) {
        this.name = data().deepCopy(fields()[3].schema(), other.name);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing InputRecordSchema instance
     * @param other The existing instance to copy.
     */
    private Builder(io.cwl.avro.InputRecordSchema other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.fields)) {
        this.fields = data().deepCopy(fields()[0].schema(), other.fields);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.type)) {
        this.type = data().deepCopy(fields()[1].schema(), other.type);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.label)) {
        this.label = data().deepCopy(fields()[2].schema(), other.label);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.name)) {
        this.name = data().deepCopy(fields()[3].schema(), other.name);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'fields' field.
      * Defines the fields of the record.
      * @return The value.
      */
    public java.util.List<io.cwl.avro.InputRecordField> getFields() {
      return fields;
    }


    /**
      * Sets the value of the 'fields' field.
      * Defines the fields of the record.
      * @param value The value of 'fields'.
      * @return This builder.
      */
    public io.cwl.avro.InputRecordSchema.Builder setFields(java.util.List<io.cwl.avro.InputRecordField> value) {
      validate(fields()[0], value);
      this.fields = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'fields' field has been set.
      * Defines the fields of the record.
      * @return True if the 'fields' field has been set, false otherwise.
      */
    public boolean hasFields() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'fields' field.
      * Defines the fields of the record.
      * @return This builder.
      */
    public io.cwl.avro.InputRecordSchema.Builder clearFields() {
      fields = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'type' field.
      * Must be `record`
      * @return The value.
      */
    public io.cwl.avro.RecordSchemaPackage.type.Record_symbol getType() {
      return type;
    }


    /**
      * Sets the value of the 'type' field.
      * Must be `record`
      * @param value The value of 'type'.
      * @return This builder.
      */
    public io.cwl.avro.InputRecordSchema.Builder setType(io.cwl.avro.RecordSchemaPackage.type.Record_symbol value) {
      validate(fields()[1], value);
      this.type = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'type' field has been set.
      * Must be `record`
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'type' field.
      * Must be `record`
      * @return This builder.
      */
    public io.cwl.avro.InputRecordSchema.Builder clearType() {
      type = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'label' field.
      * A short, human-readable label of this object.
      * @return The value.
      */
    public java.lang.CharSequence getLabel() {
      return label;
    }


    /**
      * Sets the value of the 'label' field.
      * A short, human-readable label of this object.
      * @param value The value of 'label'.
      * @return This builder.
      */
    public io.cwl.avro.InputRecordSchema.Builder setLabel(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.label = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'label' field has been set.
      * A short, human-readable label of this object.
      * @return True if the 'label' field has been set, false otherwise.
      */
    public boolean hasLabel() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'label' field.
      * A short, human-readable label of this object.
      * @return This builder.
      */
    public io.cwl.avro.InputRecordSchema.Builder clearLabel() {
      label = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public io.cwl.avro.InputRecordSchema.Builder setName(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.name = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public io.cwl.avro.InputRecordSchema.Builder clearName() {
      name = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public InputRecordSchema build() {
      try {
        InputRecordSchema record = new InputRecordSchema();
        record.fields = fieldSetFlags()[0] ? this.fields : (java.util.List<io.cwl.avro.InputRecordField>) defaultValue(fields()[0]);
        record.type = fieldSetFlags()[1] ? this.type : (io.cwl.avro.RecordSchemaPackage.type.Record_symbol) defaultValue(fields()[1]);
        record.label = fieldSetFlags()[2] ? this.label : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.name = fieldSetFlags()[3] ? this.name : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<InputRecordSchema>
    WRITER$ = (org.apache.avro.io.DatumWriter<InputRecordSchema>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<InputRecordSchema>
    READER$ = (org.apache.avro.io.DatumReader<InputRecordSchema>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










