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

/** Modify the behavior of CommandLineTool to generate a single string
containing a shell command line.  Each item in the argument list must be
joined into a string separated by single spaces and quoted to prevent
intepretation by the shell, unless `CommandLineBinding` for that argument
contains `shellQuote: false`.  If `shellQuote: false` is specified, the
argument is joined into the command string without quoting, which allows
the use of shell metacharacters such as `|` for pipes.
 */
@org.apache.avro.specific.AvroGenerated
public class ShellCommandRequirement extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5998670742469921099L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ShellCommandRequirement\",\"namespace\":\"io.cwl.avro\",\"doc\":\"Modify the behavior of CommandLineTool to generate a single string\\ncontaining a shell command line.  Each item in the argument list must be\\njoined into a string separated by single spaces and quoted to prevent\\nintepretation by the shell, unless `CommandLineBinding` for that argument\\ncontains `shellQuote: false`.  If `shellQuote: false` is specified, the\\nargument is joined into the command string without quoting, which allows\\nthe use of shell metacharacters such as `|` for pipes.\\n\",\"fields\":[{\"name\":\"class\",\"type\":\"string\",\"doc\":\"Always 'ShellCommandRequirement'\",\"jsonldPredicate\":{\"_id\":\"@type\",\"_type\":\"@vocab\"}}],\"extends\":\"https://w3id.org/cwl/cwl#ProcessRequirement\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ShellCommandRequirement> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ShellCommandRequirement> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ShellCommandRequirement> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ShellCommandRequirement> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ShellCommandRequirement> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ShellCommandRequirement to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ShellCommandRequirement from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ShellCommandRequirement instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ShellCommandRequirement fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Always 'ShellCommandRequirement' */
  public java.lang.CharSequence class$;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ShellCommandRequirement() {}

  /**
   * All-args constructor.
   * @param class$ Always 'ShellCommandRequirement'
   */
  public ShellCommandRequirement(java.lang.CharSequence class$) {
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
   * @return Always 'ShellCommandRequirement'
   */
  public java.lang.CharSequence getClass$() {
    return class$;
  }


  /**
   * Sets the value of the 'class$' field.
   * Always 'ShellCommandRequirement'
   * @param value the value to set.
   */
  public void setClass$(java.lang.CharSequence value) {
    this.class$ = value;
  }

  /**
   * Creates a new ShellCommandRequirement RecordBuilder.
   * @return A new ShellCommandRequirement RecordBuilder
   */
  public static io.cwl.avro.ShellCommandRequirement.Builder newBuilder() {
    return new io.cwl.avro.ShellCommandRequirement.Builder();
  }

  /**
   * Creates a new ShellCommandRequirement RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ShellCommandRequirement RecordBuilder
   */
  public static io.cwl.avro.ShellCommandRequirement.Builder newBuilder(io.cwl.avro.ShellCommandRequirement.Builder other) {
    if (other == null) {
      return new io.cwl.avro.ShellCommandRequirement.Builder();
    } else {
      return new io.cwl.avro.ShellCommandRequirement.Builder(other);
    }
  }

  /**
   * Creates a new ShellCommandRequirement RecordBuilder by copying an existing ShellCommandRequirement instance.
   * @param other The existing instance to copy.
   * @return A new ShellCommandRequirement RecordBuilder
   */
  public static io.cwl.avro.ShellCommandRequirement.Builder newBuilder(io.cwl.avro.ShellCommandRequirement other) {
    if (other == null) {
      return new io.cwl.avro.ShellCommandRequirement.Builder();
    } else {
      return new io.cwl.avro.ShellCommandRequirement.Builder(other);
    }
  }

  /**
   * RecordBuilder for ShellCommandRequirement instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ShellCommandRequirement>
    implements org.apache.avro.data.RecordBuilder<ShellCommandRequirement> {

    /** Always 'ShellCommandRequirement' */
    private java.lang.CharSequence class$;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.cwl.avro.ShellCommandRequirement.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing ShellCommandRequirement instance
     * @param other The existing instance to copy.
     */
    private Builder(io.cwl.avro.ShellCommandRequirement other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'class$' field.
      * Always 'ShellCommandRequirement'
      * @return The value.
      */
    public java.lang.CharSequence getClass$() {
      return class$;
    }


    /**
      * Sets the value of the 'class$' field.
      * Always 'ShellCommandRequirement'
      * @param value The value of 'class$'.
      * @return This builder.
      */
    public io.cwl.avro.ShellCommandRequirement.Builder setClass$(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.class$ = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'class$' field has been set.
      * Always 'ShellCommandRequirement'
      * @return True if the 'class$' field has been set, false otherwise.
      */
    public boolean hasClass$() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'class$' field.
      * Always 'ShellCommandRequirement'
      * @return This builder.
      */
    public io.cwl.avro.ShellCommandRequirement.Builder clearClass$() {
      class$ = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ShellCommandRequirement build() {
      try {
        ShellCommandRequirement record = new ShellCommandRequirement();
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
  private static final org.apache.avro.io.DatumWriter<ShellCommandRequirement>
    WRITER$ = (org.apache.avro.io.DatumWriter<ShellCommandRequirement>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ShellCommandRequirement>
    READER$ = (org.apache.avro.io.DatumReader<ShellCommandRequirement>)MODEL$.createDatumReader(SCHEMA$);

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










