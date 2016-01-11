package cwl;
/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class OutputRecordSchema extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OutputRecordSchema\",\"fields\":[{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"Record_symbol\",\"symbols\":[\"record\"]},\"doc\":\"Must be `record`\",\"jsonldPredicate\":{\"_type\":\"@vocab\",\"_id\":\"https://w3id.org/cwl/salad#type\"},\"inherited_from\":\"https://w3id.org/cwl/salad#RecordSchema\"},{\"name\":\"fields\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"OutputRecordField\",\"fields\":[{\"name\":\"type\",\"type\":\"Record_symbol\",\"doc\":\"Must be `record`\",\"jsonldPredicate\":{\"_type\":\"@vocab\",\"_id\":\"https://w3id.org/cwl/salad#type\"},\"inherited_from\":\"https://w3id.org/cwl/salad#RecordSchema\"},{\"name\":\"fields\",\"type\":[\"null\",{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"RecordField\",\"doc\":\"A field of a record.\",\"fields\":[{\"name\":\"name\",\"type\":\"string\",\"doc\":\"The name of the field\\n\",\"jsonldPredicate\":\"@id\"},{\"name\":\"doc\",\"type\":[\"null\",\"string\"],\"doc\":\"A documentation string for this field\\n\",\"jsonldPredicate\":\"sld:doc\"},{\"name\":\"type\",\"type\":[{\"type\":\"enum\",\"name\":\"PrimitiveType\",\"symbols\":[\"null\",\"boolean\",\"int\",\"long\",\"float\",\"double\",\"string\"]},{\"type\":\"record\",\"name\":\"RecordSchema\",\"fields\":[{\"name\":\"type\",\"type\":\"Record_symbol\",\"doc\":\"Must be `record`\",\"jsonldPredicate\":{\"_type\":\"@vocab\",\"_id\":\"https://w3id.org/cwl/salad#type\"}},{\"name\":\"fields\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"RecordField\"}],\"doc\":\"Defines the fields of the record.\",\"jsonldPredicate\":\"sld:fields\"}]},{\"type\":\"record\",\"name\":\"EnumSchema\",\"doc\":\"Define an enumerated type.\\n\",\"fields\":[{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"Enum_symbol\",\"symbols\":[\"enum\"]},\"doc\":\"Must be `enum`\",\"jsonldPredicate\":{\"_type\":\"@vocab\",\"_id\":\"https://w3id.org/cwl/salad#type\"}},{\"name\":\"symbols\",\"type\":[{\"type\":\"array\",\"items\":\"string\"}],\"doc\":\"Defines the set of valid symbols.\",\"jsonldPredicate\":{\"_type\":\"@id\",\"_id\":\"https://w3id.org/cwl/salad#symbols\",\"identity\":true}}]},{\"type\":\"record\",\"name\":\"ArraySchema\",\"fields\":[{\"name\":\"type\",\"type\":{\"type\":\"enum\",\"name\":\"Array_symbol\",\"symbols\":[\"array\"]},\"doc\":\"Must be `array`\",\"jsonldPredicate\":{\"_type\":\"@vocab\",\"_id\":\"https://w3id.org/cwl/salad#type\"}},{\"name\":\"items\",\"type\":[\"PrimitiveType\",\"RecordSchema\",\"EnumSchema\",\"ArraySchema\",\"string\",{\"type\":\"array\",\"items\":[\"PrimitiveType\",\"RecordSchema\",\"EnumSchema\",\"ArraySchema\",\"string\"]}],\"doc\":\"Defines the type of the array elements.\",\"jsonldPredicate\":{\"_type\":\"@vocab\",\"_id\":\"https://w3id.org/cwl/salad#items\"}}]},\"string\",{\"type\":\"array\",\"items\":[\"PrimitiveType\",\"RecordSchema\",\"EnumSchema\",\"ArraySchema\",\"string\"]}],\"doc\":\"The field type\\n\",\"jsonldPredicate\":{\"_type\":\"@vocab\",\"_id\":\"https://w3id.org/cwl/salad#type\"}}]}}],\"doc\":\"Defines the fields of the record.\",\"jsonldPredicate\":\"sld:fields\",\"inherited_from\":\"https://w3id.org/cwl/salad#RecordSchema\"},{\"name\":\"outputBinding\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"CommandLineBinding\",\"doc\":\"\\nWhen listed under `inputBinding` in the input schema, the term\\n\\\"value\\\" refers to the the corresponding value in the input object.  For\\nbinding objects listed in `CommandLineTool.arguments`, the term \\\"value\\\"\\nrefers to the effective value after evaluating `valueFrom`.\\n\\nThe binding behavior when building the command line depends on the data\\ntype of the value.  If there is a mismatch between the type described by\\nthe input schema and the effective value, such as resulting from an\\nexpression evaluation, an implementation must use the data type of the\\neffective value.\\n\\n  - **string**: Add `prefix` and the string to the command line.\\n\\n  - **number**: Add `prefix` and decimal representation to command line.\\n\\n  - **boolean**: If true, add `prefix` to the command line.  If false, add\\n      nothing.\\n\\n  - **File**: Add `prefix` and the value of\\n    [`File.path`](#File) to the command line.\\n\\n  - **array**: If `itemSeparator` is specified, add `prefix` and the join\\n      the array into a single string with `itemSeparator` separating the\\n      items.  Otherwise first add `prefix`, then recursively process\\n      individual elements.\\n\\n  - **object**: Add `prefix` only, and recursively add object fields for\\n      which `inputBinding` is specified.\\n\\n  - **null**: Add nothing.\\n\",\"fields\":[{\"name\":\"loadContents\",\"type\":[\"null\",\"boolean\"],\"doc\":\"Only applies when `type` is `File`.  Read up to the first 64 KiB of text from the file and place it in the\\n\\\"contents\\\" field of the file object for manipulation by expressions.\\n\",\"inherited_from\":\"https://w3id.org/cwl/cwl#Binding\"},{\"name\":\"secondaryFiles\",\"type\":[\"null\",\"string\",{\"type\":\"enum\",\"name\":\"Expression\",\"doc\":\"Not a real type.  Indicates that a field must allow expressions.\\n\",\"symbols\":[\"ExpressionPlaceholder\"]},{\"type\":\"array\",\"items\":[\"string\",\"Expression\"]}],\"doc\":\"Only applies when `type` is `File`.  Describes files that must be\\nincluded alongside the primary file.\\n\\nIf the value is an expression, the context of the expression is the input\\nor output File parameter to which this binding applies.\\n\\nIf the value is a string, it specifies that the following pattern\\nshould be applied to the primary file:\\n\\n  1. If string begins with one or more caret `^` characters, for each\\n    caret, remove the last file extension from the path (the last\\n    period `.` and all following characters).  If there are no file\\n    extensions, the path is unchanged.\\n  2. Append the remainder of the string to the end of the file path.\\n\",\"jsonldPredicate\":\"cwl:secondaryFiles\",\"inherited_from\":\"https://w3id.org/cwl/cwl#Binding\"},{\"name\":\"position\",\"type\":[\"null\",\"int\"],\"doc\":\"The sorting key.  Default position is 0.\"},{\"name\":\"prefix\",\"type\":[\"null\",\"string\"],\"doc\":\"Command line prefix to add before the value.\"},{\"name\":\"separate\",\"type\":[\"null\",\"boolean\"],\"doc\":\"If true (default), then the prefix and value must be added as separate\\ncommand line arguments; if false, prefix and value must be concatenated\\ninto a single command line argument.\\n\"},{\"name\":\"itemSeparator\",\"type\":[\"null\",\"string\"],\"doc\":\"Join the array elements into a single string with the elements\\nseparated by by `itemSeparator`.\\n\"},{\"name\":\"valueFrom\",\"type\":[\"null\",\"string\",\"Expression\"],\"doc\":\"If `valueFrom` is a constant string value, use this as the value and\\napply the binding rules above.\\n\\nIf `valueFrom` is an expression, evaluate the expression to yield the\\nactual value to use to build the command line and apply the binding\\nrules above.  If the inputBinding is associated with an input\\nparameter, the \\\"context\\\" of the expression will be the value of the\\ninput parameter.\\n\\nWhen a binding is part of the `CommandLineTool.arguments` field,\\nthe `valueFrom` field is required.\\n\",\"jsonldPredicate\":\"cwl:valueFrom\"},{\"name\":\"shellQuote\",\"type\":[\"null\",\"boolean\"],\"doc\":\"If `ShellCommandRequirement` is in the requirements for the current command,\\nthis controls whether the value is quoted on the command line (default is true).\\nUse `shellQuote: false` to inject metacharacters for operations such as pipes.\\n\"}],\"extends\":\"https://w3id.org/cwl/cwl#Binding\"},{\"type\":\"record\",\"name\":\"CommandOutputBinding\",\"doc\":\"Describes how to generate an output parameter based on the files produced\\nby a CommandLineTool.\\n\\nThe output parameter is generated by applying these operations in\\nthe following order:\\n\\n  - glob\\n  - loadContents\\n  - outputEval\\n\",\"fields\":[{\"name\":\"loadContents\",\"type\":[\"null\",\"boolean\"],\"doc\":\"Only applies when `type` is `File`.  Read up to the first 64 KiB of text from the file and place it in the\\n\\\"contents\\\" field of the file object for manipulation by expressions.\\n\",\"inherited_from\":\"https://w3id.org/cwl/cwl#Binding\"},{\"name\":\"secondaryFiles\",\"type\":[\"null\",\"string\",\"Expression\",{\"type\":\"array\",\"items\":[\"string\",\"Expression\"]}],\"doc\":\"Only applies when `type` is `File`.  Describes files that must be\\nincluded alongside the primary file.\\n\\nIf the value is an expression, the context of the expression is the input\\nor output File parameter to which this binding applies.\\n\\nIf the value is a string, it specifies that the following pattern\\nshould be applied to the primary file:\\n\\n  1. If string begins with one or more caret `^` characters, for each\\n    caret, remove the last file extension fro","m the path (the last\\n    period `.` and all following characters).  If there are no file\\n    extensions, the path is unchanged.\\n  2. Append the remainder of the string to the end of the file path.\\n\",\"jsonldPredicate\":\"cwl:secondaryFiles\",\"inherited_from\":\"https://w3id.org/cwl/cwl#Binding\"},{\"name\":\"glob\",\"type\":[\"null\",\"string\",\"Expression\",{\"type\":\"array\",\"items\":\"string\"}],\"doc\":\"Find files relative to the output directory, using POSIX glob(3)\\npathname matching.  If provided an array, find files that match any\\npattern in the array.  If provided an expression, the expression must\\nreturn a string or an array of strings, which will then be evaluated as\\none or more glob patterns.  Only files which actually exist will be\\nmatched and returned.\\n\"},{\"name\":\"outputEval\",\"type\":[\"null\",\"string\",\"Expression\"],\"doc\":\"Evaluate an expression to generate the output value.  If `glob` was\\nspecified, the script `context` will be an array containing any files that were\\nmatched.  Additionally, if `loadContents` is `true`, the File objects\\nwill include up to the first 64 KiB of file contents in the `contents` field.\\n\"}],\"extends\":\"https://w3id.org/cwl/cwl#Binding\"}],\"jsonldPredicate\":\"cwl:outputBinding\"}],\"docParent\":\"https://w3id.org/cwl/cwl#OutputParameter\",\"extends\":\"https://w3id.org/cwl/salad#RecordSchema\",\"specialize\":[{\"specializeFrom\":\"https://w3id.org/cwl/salad#RecordSchema\",\"specializeTo\":\"https://w3id.org/cwl/cwl#OutputRecordSchema\"},{\"specializeFrom\":\"https://w3id.org/cwl/salad#EnumSchema\",\"specializeTo\":\"https://w3id.org/cwl/cwl#OutputEnumSchema\"},{\"specializeFrom\":\"https://w3id.org/cwl/salad#ArraySchema\",\"specializeTo\":\"https://w3id.org/cwl/cwl#OutputArraySchema\"}]}}],\"doc\":\"Defines the fields of the record.\",\"jsonldPredicate\":\"sld:fields\",\"inherited_from\":\"https://w3id.org/cwl/salad#RecordSchema\"}],\"docParent\":\"https://w3id.org/cwl/cwl#OutputParameter\",\"extends\":\"https://w3id.org/cwl/salad#RecordSchema\",\"specialize\":[{\"specializeFrom\":\"https://w3id.org/cwl/salad#RecordField\",\"specializeTo\":\"https://w3id.org/cwl/cwl#OutputRecordField\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** Must be `record` */
  @Deprecated public Record_symbol type;
  /** Defines the fields of the record. */
  @Deprecated public java.util.List<OutputRecordField> fields;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public OutputRecordSchema() {}

  /**
   * All-args constructor.
   */
  public OutputRecordSchema(Record_symbol type, java.util.List<OutputRecordField> fields) {
    this.type = type;
    this.fields = fields;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return type;
    case 1: return fields;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: type = (Record_symbol)value$; break;
    case 1: fields = (java.util.List<OutputRecordField>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'type' field.
   * Must be `record`   */
  public Record_symbol getType() {
    return type;
  }

  /**
   * Sets the value of the 'type' field.
   * Must be `record`   * @param value the value to set.
   */
  public void setType(Record_symbol value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'fields' field.
   * Defines the fields of the record.   */
  public java.util.List<OutputRecordField> getFields() {
    return fields;
  }

  /**
   * Sets the value of the 'fields' field.
   * Defines the fields of the record.   * @param value the value to set.
   */
  public void setFields(java.util.List<OutputRecordField> value) {
    this.fields = value;
  }

  /** Creates a new OutputRecordSchema RecordBuilder */
  public static OutputRecordSchema.Builder newBuilder() {
    return new OutputRecordSchema.Builder();
  }
  
  /** Creates a new OutputRecordSchema RecordBuilder by copying an existing Builder */
  public static OutputRecordSchema.Builder newBuilder(OutputRecordSchema.Builder other) {
    return new OutputRecordSchema.Builder(other);
  }
  
  /** Creates a new OutputRecordSchema RecordBuilder by copying an existing OutputRecordSchema instance */
  public static OutputRecordSchema.Builder newBuilder(OutputRecordSchema other) {
    return new OutputRecordSchema.Builder(other);
  }
  
  /**
   * RecordBuilder for OutputRecordSchema instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OutputRecordSchema>
    implements org.apache.avro.data.RecordBuilder<OutputRecordSchema> {

    private Record_symbol type;
    private java.util.List<OutputRecordField> fields;

    /** Creates a new Builder */
    private Builder() {
      super(OutputRecordSchema.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(OutputRecordSchema.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.type)) {
        this.type = data().deepCopy(fields()[0].schema(), other.type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.fields)) {
        this.fields = data().deepCopy(fields()[1].schema(), other.fields);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing OutputRecordSchema instance */
    private Builder(OutputRecordSchema other) {
            super(OutputRecordSchema.SCHEMA$);
      if (isValidValue(fields()[0], other.type)) {
        this.type = data().deepCopy(fields()[0].schema(), other.type);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.fields)) {
        this.fields = data().deepCopy(fields()[1].schema(), other.fields);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'type' field */
    public Record_symbol getType() {
      return type;
    }
    
    /** Sets the value of the 'type' field */
    public OutputRecordSchema.Builder setType(Record_symbol value) {
      validate(fields()[0], value);
      this.type = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'type' field has been set */
    public boolean hasType() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'type' field */
    public OutputRecordSchema.Builder clearType() {
      type = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'fields' field */
    public java.util.List<OutputRecordField> getFields() {
      return fields;
    }
    
    /** Sets the value of the 'fields' field */
    public OutputRecordSchema.Builder setFields(java.util.List<OutputRecordField> value) {
      validate(fields()[1], value);
      this.fields = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'fields' field has been set */
    public boolean hasFields() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'fields' field */
    public OutputRecordSchema.Builder clearFields() {
      fields = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public OutputRecordSchema build() {
      try {
        OutputRecordSchema record = new OutputRecordSchema();
        record.type = fieldSetFlags()[0] ? this.type : (Record_symbol) defaultValue(fields()[0]);
        record.fields = fieldSetFlags()[1] ? this.fields : (java.util.List<OutputRecordField>) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
