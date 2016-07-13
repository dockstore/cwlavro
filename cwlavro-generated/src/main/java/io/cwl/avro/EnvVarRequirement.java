package io.cwl.avro;
/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** Define a list of environment variables which will be set in the
execution environment of the tool.  See `EnvironmentDef` for details.
 */
@org.apache.avro.specific.AvroGenerated
public class EnvVarRequirement extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6530429486976933860L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"EnvVarRequirement\",\"doc\":\"Define a list of environment variables which will be set in the\\nexecution environment of the tool.  See `EnvironmentDef` for details.\\n\",\"fields\":[{\"name\":\"class\",\"type\":\"string\",\"doc\":\"Always 'EnvVarRequirement'\",\"jsonldPredicate\":{\"_type\":\"@vocab\",\"_id\":\"@type\"}},{\"name\":\"envDef\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"EnvironmentDef\",\"doc\":\"Define an environment variable that will be set in the runtime environment\\nby the workflow platform when executing the command line tool.  May be the\\nresult of executing an expression, such as getting a parameter from input.\\n\",\"fields\":[{\"name\":\"envName\",\"type\":\"string\",\"doc\":\"The environment variable name\"},{\"name\":\"envValue\",\"type\":[\"string\",{\"type\":\"enum\",\"name\":\"Expression\",\"doc\":\"'Expression' is not a real type.  It indicates that a field must allow\\nruntime parameter references.  If [InlineJavascriptRequirement](#InlineJavascriptRequirement)\\nis declared and supported by the platform, the field must also allow\\nJavascript expressions.\\n\",\"symbols\":[\"ExpressionPlaceholder\"]}],\"doc\":\"The environment variable value\"}]}},\"doc\":\"The list of environment variables.\",\"jsonldPredicate\":{\"mapSubject\":\"envName\",\"mapPredicate\":\"envValue\"}}],\"extends\":\"https://w3id.org/cwl/cwl#ProcessRequirement\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** Always 'EnvVarRequirement' */
  @Deprecated public java.lang.CharSequence class$;
  /** The list of environment variables. */
  @Deprecated public java.util.List<EnvironmentDef> envDef;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public EnvVarRequirement() {}

  /**
   * All-args constructor.
   * @param class$ Always 'EnvVarRequirement'
   * @param envDef The list of environment variables.
   */
  public EnvVarRequirement(java.lang.CharSequence class$, java.util.List<EnvironmentDef> envDef) {
    this.class$ = class$;
    this.envDef = envDef;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return class$;
    case 1: return envDef;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: class$ = (java.lang.CharSequence)value$; break;
    case 1: envDef = (java.util.List<EnvironmentDef>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'class$' field.
   * @return Always 'EnvVarRequirement'
   */
  public java.lang.CharSequence getClass$() {
    return class$;
  }

  /**
   * Sets the value of the 'class$' field.
   * Always 'EnvVarRequirement'
   * @param value the value to set.
   */
  public void setClass$(java.lang.CharSequence value) {
    this.class$ = value;
  }

  /**
   * Gets the value of the 'envDef' field.
   * @return The list of environment variables.
   */
  public java.util.List<EnvironmentDef> getEnvDef() {
    return envDef;
  }

  /**
   * Sets the value of the 'envDef' field.
   * The list of environment variables.
   * @param value the value to set.
   */
  public void setEnvDef(java.util.List<EnvironmentDef> value) {
    this.envDef = value;
  }

  /**
   * Creates a new EnvVarRequirement RecordBuilder.
   * @return A new EnvVarRequirement RecordBuilder
   */
  public static EnvVarRequirement.Builder newBuilder() {
    return new EnvVarRequirement.Builder();
  }

  /**
   * Creates a new EnvVarRequirement RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new EnvVarRequirement RecordBuilder
   */
  public static EnvVarRequirement.Builder newBuilder(EnvVarRequirement.Builder other) {
    return new EnvVarRequirement.Builder(other);
  }

  /**
   * Creates a new EnvVarRequirement RecordBuilder by copying an existing EnvVarRequirement instance.
   * @param other The existing instance to copy.
   * @return A new EnvVarRequirement RecordBuilder
   */
  public static EnvVarRequirement.Builder newBuilder(EnvVarRequirement other) {
    return new EnvVarRequirement.Builder(other);
  }

  /**
   * RecordBuilder for EnvVarRequirement instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<EnvVarRequirement>
    implements org.apache.avro.data.RecordBuilder<EnvVarRequirement> {

    /** Always 'EnvVarRequirement' */
    private java.lang.CharSequence class$;
    /** The list of environment variables. */
    private java.util.List<EnvironmentDef> envDef;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(EnvVarRequirement.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.envDef)) {
        this.envDef = data().deepCopy(fields()[1].schema(), other.envDef);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing EnvVarRequirement instance
     * @param other The existing instance to copy.
     */
    private Builder(EnvVarRequirement other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.envDef)) {
        this.envDef = data().deepCopy(fields()[1].schema(), other.envDef);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'class$' field.
      * Always 'EnvVarRequirement'
      * @return The value.
      */
    public java.lang.CharSequence getClass$() {
      return class$;
    }

    /**
      * Sets the value of the 'class$' field.
      * Always 'EnvVarRequirement'
      * @param value The value of 'class$'.
      * @return This builder.
      */
    public EnvVarRequirement.Builder setClass$(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.class$ = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'class$' field has been set.
      * Always 'EnvVarRequirement'
      * @return True if the 'class$' field has been set, false otherwise.
      */
    public boolean hasClass$() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'class$' field.
      * Always 'EnvVarRequirement'
      * @return This builder.
      */
    public EnvVarRequirement.Builder clearClass$() {
      class$ = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'envDef' field.
      * The list of environment variables.
      * @return The value.
      */
    public java.util.List<EnvironmentDef> getEnvDef() {
      return envDef;
    }

    /**
      * Sets the value of the 'envDef' field.
      * The list of environment variables.
      * @param value The value of 'envDef'.
      * @return This builder.
      */
    public EnvVarRequirement.Builder setEnvDef(java.util.List<EnvironmentDef> value) {
      validate(fields()[1], value);
      this.envDef = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'envDef' field has been set.
      * The list of environment variables.
      * @return True if the 'envDef' field has been set, false otherwise.
      */
    public boolean hasEnvDef() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'envDef' field.
      * The list of environment variables.
      * @return This builder.
      */
    public EnvVarRequirement.Builder clearEnvDef() {
      envDef = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public EnvVarRequirement build() {
      try {
        EnvVarRequirement record = new EnvVarRequirement();
        record.class$ = fieldSetFlags()[0] ? this.class$ : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.envDef = fieldSetFlags()[1] ? this.envDef : (java.util.List<EnvironmentDef>) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}