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

/** Associate an output parameter of the underlying process with a workflow
parameter.  The workflow parameter (given in the `id` field) be may be used
as a `source` to connect with input parameters of other workflow steps, or
with an output parameter of the process.
 */
@org.apache.avro.specific.AvroGenerated
public class WorkflowStepOutput extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7694812703366937612L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WorkflowStepOutput\",\"namespace\":\"io.cwl.avro\",\"doc\":\"Associate an output parameter of the underlying process with a workflow\\nparameter.  The workflow parameter (given in the `id` field) be may be used\\nas a `source` to connect with input parameters of other workflow steps, or\\nwith an output parameter of the process.\\n\",\"fields\":[{\"name\":\"id\",\"type\":\"string\",\"doc\":\"A unique identifier for this workflow output parameter.  This is the\\nidentifier to use in the `source` field of `WorkflowStepInput` to\\nconnect the output value to downstream parameters.\\n\",\"jsonldPredicate\":\"@id\"}],\"docParent\":\"https://w3id.org/cwl/cwl#WorkflowStep\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<WorkflowStepOutput> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<WorkflowStepOutput> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<WorkflowStepOutput> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<WorkflowStepOutput> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<WorkflowStepOutput> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this WorkflowStepOutput to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a WorkflowStepOutput from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a WorkflowStepOutput instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static WorkflowStepOutput fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** A unique identifier for this workflow output parameter.  This is the
identifier to use in the `source` field of `WorkflowStepInput` to
connect the output value to downstream parameters.
 */
  public java.lang.CharSequence id;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public WorkflowStepOutput() {}

  /**
   * All-args constructor.
   * @param id A unique identifier for this workflow output parameter.  This is the
identifier to use in the `source` field of `WorkflowStepInput` to
connect the output value to downstream parameters.

   */
  public WorkflowStepOutput(java.lang.CharSequence id) {
    this.id = id;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return A unique identifier for this workflow output parameter.  This is the
identifier to use in the `source` field of `WorkflowStepInput` to
connect the output value to downstream parameters.

   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * A unique identifier for this workflow output parameter.  This is the
identifier to use in the `source` field of `WorkflowStepInput` to
connect the output value to downstream parameters.

   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Creates a new WorkflowStepOutput RecordBuilder.
   * @return A new WorkflowStepOutput RecordBuilder
   */
  public static io.cwl.avro.WorkflowStepOutput.Builder newBuilder() {
    return new io.cwl.avro.WorkflowStepOutput.Builder();
  }

  /**
   * Creates a new WorkflowStepOutput RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new WorkflowStepOutput RecordBuilder
   */
  public static io.cwl.avro.WorkflowStepOutput.Builder newBuilder(io.cwl.avro.WorkflowStepOutput.Builder other) {
    if (other == null) {
      return new io.cwl.avro.WorkflowStepOutput.Builder();
    } else {
      return new io.cwl.avro.WorkflowStepOutput.Builder(other);
    }
  }

  /**
   * Creates a new WorkflowStepOutput RecordBuilder by copying an existing WorkflowStepOutput instance.
   * @param other The existing instance to copy.
   * @return A new WorkflowStepOutput RecordBuilder
   */
  public static io.cwl.avro.WorkflowStepOutput.Builder newBuilder(io.cwl.avro.WorkflowStepOutput other) {
    if (other == null) {
      return new io.cwl.avro.WorkflowStepOutput.Builder();
    } else {
      return new io.cwl.avro.WorkflowStepOutput.Builder(other);
    }
  }

  /**
   * RecordBuilder for WorkflowStepOutput instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<WorkflowStepOutput>
    implements org.apache.avro.data.RecordBuilder<WorkflowStepOutput> {

    /** A unique identifier for this workflow output parameter.  This is the
identifier to use in the `source` field of `WorkflowStepInput` to
connect the output value to downstream parameters.
 */
    private java.lang.CharSequence id;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.cwl.avro.WorkflowStepOutput.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing WorkflowStepOutput instance
     * @param other The existing instance to copy.
     */
    private Builder(io.cwl.avro.WorkflowStepOutput other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * A unique identifier for this workflow output parameter.  This is the
identifier to use in the `source` field of `WorkflowStepInput` to
connect the output value to downstream parameters.

      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * A unique identifier for this workflow output parameter.  This is the
identifier to use in the `source` field of `WorkflowStepInput` to
connect the output value to downstream parameters.

      * @param value The value of 'id'.
      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepOutput.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * A unique identifier for this workflow output parameter.  This is the
identifier to use in the `source` field of `WorkflowStepInput` to
connect the output value to downstream parameters.

      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * A unique identifier for this workflow output parameter.  This is the
identifier to use in the `source` field of `WorkflowStepInput` to
connect the output value to downstream parameters.

      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepOutput.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public WorkflowStepOutput build() {
      try {
        WorkflowStepOutput record = new WorkflowStepOutput();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<WorkflowStepOutput>
    WRITER$ = (org.apache.avro.io.DatumWriter<WorkflowStepOutput>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<WorkflowStepOutput>
    READER$ = (org.apache.avro.io.DatumReader<WorkflowStepOutput>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










