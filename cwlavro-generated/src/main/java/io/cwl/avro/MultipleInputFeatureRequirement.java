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

/** Indicates that the workflow platform must support multiple inbound data links
listed in the `source` field of [WorkflowStepInput](#WorkflowStepInput).
 */
@org.apache.avro.specific.AvroGenerated
public class MultipleInputFeatureRequirement extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4405232228079378159L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"MultipleInputFeatureRequirement\",\"namespace\":\"io.cwl.avro\",\"doc\":\"Indicates that the workflow platform must support multiple inbound data links\\nlisted in the `source` field of [WorkflowStepInput](#WorkflowStepInput).\\n\",\"fields\":[{\"name\":\"class\",\"type\":\"string\",\"doc\":\"Always 'MultipleInputFeatureRequirement'\",\"jsonldPredicate\":{\"_id\":\"@type\",\"_type\":\"@vocab\"}}],\"extends\":\"https://w3id.org/cwl/cwl#ProcessRequirement\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<MultipleInputFeatureRequirement> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<MultipleInputFeatureRequirement> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<MultipleInputFeatureRequirement> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<MultipleInputFeatureRequirement> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<MultipleInputFeatureRequirement> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this MultipleInputFeatureRequirement to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a MultipleInputFeatureRequirement from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a MultipleInputFeatureRequirement instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static MultipleInputFeatureRequirement fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Always 'MultipleInputFeatureRequirement' */
  public java.lang.CharSequence class$;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public MultipleInputFeatureRequirement() {}

  /**
   * All-args constructor.
   * @param class$ Always 'MultipleInputFeatureRequirement'
   */
  public MultipleInputFeatureRequirement(java.lang.CharSequence class$) {
    this.class$ = class$;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return class$;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: class$ = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'class$' field.
   * @return Always 'MultipleInputFeatureRequirement'
   */
  public java.lang.CharSequence getClass$() {
    return class$;
  }


  /**
   * Sets the value of the 'class$' field.
   * Always 'MultipleInputFeatureRequirement'
   * @param value the value to set.
   */
  public void setClass$(java.lang.CharSequence value) {
    this.class$ = value;
  }

  /**
   * Creates a new MultipleInputFeatureRequirement RecordBuilder.
   * @return A new MultipleInputFeatureRequirement RecordBuilder
   */
  public static io.cwl.avro.MultipleInputFeatureRequirement.Builder newBuilder() {
    return new io.cwl.avro.MultipleInputFeatureRequirement.Builder();
  }

  /**
   * Creates a new MultipleInputFeatureRequirement RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new MultipleInputFeatureRequirement RecordBuilder
   */
  public static io.cwl.avro.MultipleInputFeatureRequirement.Builder newBuilder(io.cwl.avro.MultipleInputFeatureRequirement.Builder other) {
    if (other == null) {
      return new io.cwl.avro.MultipleInputFeatureRequirement.Builder();
    } else {
      return new io.cwl.avro.MultipleInputFeatureRequirement.Builder(other);
    }
  }

  /**
   * Creates a new MultipleInputFeatureRequirement RecordBuilder by copying an existing MultipleInputFeatureRequirement instance.
   * @param other The existing instance to copy.
   * @return A new MultipleInputFeatureRequirement RecordBuilder
   */
  public static io.cwl.avro.MultipleInputFeatureRequirement.Builder newBuilder(io.cwl.avro.MultipleInputFeatureRequirement other) {
    if (other == null) {
      return new io.cwl.avro.MultipleInputFeatureRequirement.Builder();
    } else {
      return new io.cwl.avro.MultipleInputFeatureRequirement.Builder(other);
    }
  }

  /**
   * RecordBuilder for MultipleInputFeatureRequirement instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<MultipleInputFeatureRequirement>
    implements org.apache.avro.data.RecordBuilder<MultipleInputFeatureRequirement> {

    /** Always 'MultipleInputFeatureRequirement' */
    private java.lang.CharSequence class$;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.cwl.avro.MultipleInputFeatureRequirement.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing MultipleInputFeatureRequirement instance
     * @param other The existing instance to copy.
     */
    private Builder(io.cwl.avro.MultipleInputFeatureRequirement other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'class$' field.
      * Always 'MultipleInputFeatureRequirement'
      * @return The value.
      */
    public java.lang.CharSequence getClass$() {
      return class$;
    }


    /**
      * Sets the value of the 'class$' field.
      * Always 'MultipleInputFeatureRequirement'
      * @param value The value of 'class$'.
      * @return This builder.
      */
    public io.cwl.avro.MultipleInputFeatureRequirement.Builder setClass$(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.class$ = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'class$' field has been set.
      * Always 'MultipleInputFeatureRequirement'
      * @return True if the 'class$' field has been set, false otherwise.
      */
    public boolean hasClass$() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'class$' field.
      * Always 'MultipleInputFeatureRequirement'
      * @return This builder.
      */
    public io.cwl.avro.MultipleInputFeatureRequirement.Builder clearClass$() {
      class$ = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public MultipleInputFeatureRequirement build() {
      try {
        MultipleInputFeatureRequirement record = new MultipleInputFeatureRequirement();
        record.class$ = fieldSetFlags()[0] ? this.class$ : (java.lang.CharSequence) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<MultipleInputFeatureRequirement>
    WRITER$ = (org.apache.avro.io.DatumWriter<MultipleInputFeatureRequirement>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<MultipleInputFeatureRequirement>
    READER$ = (org.apache.avro.io.DatumReader<MultipleInputFeatureRequirement>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.class$);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.class$ = in.readString(this.class$ instanceof Utf8 ? (Utf8)this.class$ : null);

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.class$ = in.readString(this.class$ instanceof Utf8 ? (Utf8)this.class$ : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










