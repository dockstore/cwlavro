package io.cwl.avro;
/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** Indicates that the workflow platform must support nested workflows in
the `run` field of [WorkflowStep](#WorkflowStep).
 */
@org.apache.avro.specific.AvroGenerated
public class SubworkflowFeatureRequirement extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -6320136361001010310L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"SubworkflowFeatureRequirement\",\"doc\":\"Indicates that the workflow platform must support nested workflows in\\nthe `run` field of [WorkflowStep](#WorkflowStep).\\n\",\"fields\":[{\"name\":\"class\",\"type\":\"string\",\"doc\":\"Always 'SubworkflowFeatureRequirement'\",\"jsonldPredicate\":{\"_type\":\"@vocab\",\"_id\":\"@type\"}}],\"extends\":\"https://w3id.org/cwl/cwl#ProcessRequirement\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** Always 'SubworkflowFeatureRequirement' */
  @Deprecated public java.lang.CharSequence class$;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public SubworkflowFeatureRequirement() {}

  /**
   * All-args constructor.
   * @param class$ Always 'SubworkflowFeatureRequirement'
   */
  public SubworkflowFeatureRequirement(java.lang.CharSequence class$) {
    this.class$ = class$;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return class$;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: class$ = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'class$' field.
   * @return Always 'SubworkflowFeatureRequirement'
   */
  public java.lang.CharSequence getClass$() {
    return class$;
  }

  /**
   * Sets the value of the 'class$' field.
   * Always 'SubworkflowFeatureRequirement'
   * @param value the value to set.
   */
  public void setClass$(java.lang.CharSequence value) {
    this.class$ = value;
  }

  /**
   * Creates a new SubworkflowFeatureRequirement RecordBuilder.
   * @return A new SubworkflowFeatureRequirement RecordBuilder
   */
  public static SubworkflowFeatureRequirement.Builder newBuilder() {
    return new SubworkflowFeatureRequirement.Builder();
  }

  /**
   * Creates a new SubworkflowFeatureRequirement RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new SubworkflowFeatureRequirement RecordBuilder
   */
  public static SubworkflowFeatureRequirement.Builder newBuilder(SubworkflowFeatureRequirement.Builder other) {
    return new SubworkflowFeatureRequirement.Builder(other);
  }

  /**
   * Creates a new SubworkflowFeatureRequirement RecordBuilder by copying an existing SubworkflowFeatureRequirement instance.
   * @param other The existing instance to copy.
   * @return A new SubworkflowFeatureRequirement RecordBuilder
   */
  public static SubworkflowFeatureRequirement.Builder newBuilder(SubworkflowFeatureRequirement other) {
    return new SubworkflowFeatureRequirement.Builder(other);
  }

  /**
   * RecordBuilder for SubworkflowFeatureRequirement instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<SubworkflowFeatureRequirement>
    implements org.apache.avro.data.RecordBuilder<SubworkflowFeatureRequirement> {

    /** Always 'SubworkflowFeatureRequirement' */
    private java.lang.CharSequence class$;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(SubworkflowFeatureRequirement.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing SubworkflowFeatureRequirement instance
     * @param other The existing instance to copy.
     */
    private Builder(SubworkflowFeatureRequirement other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'class$' field.
      * Always 'SubworkflowFeatureRequirement'
      * @return The value.
      */
    public java.lang.CharSequence getClass$() {
      return class$;
    }

    /**
      * Sets the value of the 'class$' field.
      * Always 'SubworkflowFeatureRequirement'
      * @param value The value of 'class$'.
      * @return This builder.
      */
    public SubworkflowFeatureRequirement.Builder setClass$(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.class$ = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'class$' field has been set.
      * Always 'SubworkflowFeatureRequirement'
      * @return True if the 'class$' field has been set, false otherwise.
      */
    public boolean hasClass$() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'class$' field.
      * Always 'SubworkflowFeatureRequirement'
      * @return This builder.
      */
    public SubworkflowFeatureRequirement.Builder clearClass$() {
      class$ = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    public SubworkflowFeatureRequirement build() {
      try {
        SubworkflowFeatureRequirement record = new SubworkflowFeatureRequirement();
        record.class$ = fieldSetFlags()[0] ? this.class$ : (java.lang.CharSequence) defaultValue(fields()[0]);
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