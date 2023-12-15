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

/** Indicates that the workflow platform must support inline Javascript expressions.
If this requirement is not present, the workflow platform must not perform expression
interpolatation.
 */
@org.apache.avro.specific.AvroGenerated
public class InlineJavascriptRequirement extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8975452497586869038L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"InlineJavascriptRequirement\",\"namespace\":\"io.cwl.avro\",\"doc\":\"Indicates that the workflow platform must support inline Javascript expressions.\\nIf this requirement is not present, the workflow platform must not perform expression\\ninterpolatation.\\n\",\"fields\":[{\"name\":\"class\",\"type\":\"string\",\"doc\":\"Always 'InlineJavascriptRequirement'\",\"jsonldPredicate\":{\"_id\":\"@type\",\"_type\":\"@vocab\"}},{\"name\":\"expressionLib\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"string\"}],\"doc\":\"Additional code fragments that will also be inserted\\nbefore executing the expression code.  Allows for function definitions that may\\nbe called from CWL expressions.\\n\"}],\"extends\":\"https://w3id.org/cwl/cwl#ProcessRequirement\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<InlineJavascriptRequirement> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<InlineJavascriptRequirement> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<InlineJavascriptRequirement> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<InlineJavascriptRequirement> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<InlineJavascriptRequirement> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this InlineJavascriptRequirement to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a InlineJavascriptRequirement from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a InlineJavascriptRequirement instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static InlineJavascriptRequirement fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Always 'InlineJavascriptRequirement' */
  public java.lang.CharSequence class$;
  /** Additional code fragments that will also be inserted
before executing the expression code.  Allows for function definitions that may
be called from CWL expressions.
 */
  public java.util.List<java.lang.CharSequence> expressionLib;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public InlineJavascriptRequirement() {}

  /**
   * All-args constructor.
   * @param class$ Always 'InlineJavascriptRequirement'
   * @param expressionLib Additional code fragments that will also be inserted
before executing the expression code.  Allows for function definitions that may
be called from CWL expressions.

   */
  public InlineJavascriptRequirement(java.lang.CharSequence class$, java.util.List<java.lang.CharSequence> expressionLib) {
    this.class$ = class$;
    this.expressionLib = expressionLib;
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
    case 1: return expressionLib;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: class$ = (java.lang.CharSequence)value$; break;
    case 1: expressionLib = (java.util.List<java.lang.CharSequence>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'class$' field.
   * @return Always 'InlineJavascriptRequirement'
   */
  public java.lang.CharSequence getClass$() {
    return class$;
  }


  /**
   * Sets the value of the 'class$' field.
   * Always 'InlineJavascriptRequirement'
   * @param value the value to set.
   */
  public void setClass$(java.lang.CharSequence value) {
    this.class$ = value;
  }

  /**
   * Gets the value of the 'expressionLib' field.
   * @return Additional code fragments that will also be inserted
before executing the expression code.  Allows for function definitions that may
be called from CWL expressions.

   */
  public java.util.List<java.lang.CharSequence> getExpressionLib() {
    return expressionLib;
  }


  /**
   * Sets the value of the 'expressionLib' field.
   * Additional code fragments that will also be inserted
before executing the expression code.  Allows for function definitions that may
be called from CWL expressions.

   * @param value the value to set.
   */
  public void setExpressionLib(java.util.List<java.lang.CharSequence> value) {
    this.expressionLib = value;
  }

  /**
   * Creates a new InlineJavascriptRequirement RecordBuilder.
   * @return A new InlineJavascriptRequirement RecordBuilder
   */
  public static io.cwl.avro.InlineJavascriptRequirement.Builder newBuilder() {
    return new io.cwl.avro.InlineJavascriptRequirement.Builder();
  }

  /**
   * Creates a new InlineJavascriptRequirement RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new InlineJavascriptRequirement RecordBuilder
   */
  public static io.cwl.avro.InlineJavascriptRequirement.Builder newBuilder(io.cwl.avro.InlineJavascriptRequirement.Builder other) {
    if (other == null) {
      return new io.cwl.avro.InlineJavascriptRequirement.Builder();
    } else {
      return new io.cwl.avro.InlineJavascriptRequirement.Builder(other);
    }
  }

  /**
   * Creates a new InlineJavascriptRequirement RecordBuilder by copying an existing InlineJavascriptRequirement instance.
   * @param other The existing instance to copy.
   * @return A new InlineJavascriptRequirement RecordBuilder
   */
  public static io.cwl.avro.InlineJavascriptRequirement.Builder newBuilder(io.cwl.avro.InlineJavascriptRequirement other) {
    if (other == null) {
      return new io.cwl.avro.InlineJavascriptRequirement.Builder();
    } else {
      return new io.cwl.avro.InlineJavascriptRequirement.Builder(other);
    }
  }

  /**
   * RecordBuilder for InlineJavascriptRequirement instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<InlineJavascriptRequirement>
    implements org.apache.avro.data.RecordBuilder<InlineJavascriptRequirement> {

    /** Always 'InlineJavascriptRequirement' */
    private java.lang.CharSequence class$;
    /** Additional code fragments that will also be inserted
before executing the expression code.  Allows for function definitions that may
be called from CWL expressions.
 */
    private java.util.List<java.lang.CharSequence> expressionLib;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.cwl.avro.InlineJavascriptRequirement.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.expressionLib)) {
        this.expressionLib = data().deepCopy(fields()[1].schema(), other.expressionLib);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing InlineJavascriptRequirement instance
     * @param other The existing instance to copy.
     */
    private Builder(io.cwl.avro.InlineJavascriptRequirement other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.expressionLib)) {
        this.expressionLib = data().deepCopy(fields()[1].schema(), other.expressionLib);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'class$' field.
      * Always 'InlineJavascriptRequirement'
      * @return The value.
      */
    public java.lang.CharSequence getClass$() {
      return class$;
    }


    /**
      * Sets the value of the 'class$' field.
      * Always 'InlineJavascriptRequirement'
      * @param value The value of 'class$'.
      * @return This builder.
      */
    public io.cwl.avro.InlineJavascriptRequirement.Builder setClass$(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.class$ = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'class$' field has been set.
      * Always 'InlineJavascriptRequirement'
      * @return True if the 'class$' field has been set, false otherwise.
      */
    public boolean hasClass$() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'class$' field.
      * Always 'InlineJavascriptRequirement'
      * @return This builder.
      */
    public io.cwl.avro.InlineJavascriptRequirement.Builder clearClass$() {
      class$ = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'expressionLib' field.
      * Additional code fragments that will also be inserted
before executing the expression code.  Allows for function definitions that may
be called from CWL expressions.

      * @return The value.
      */
    public java.util.List<java.lang.CharSequence> getExpressionLib() {
      return expressionLib;
    }


    /**
      * Sets the value of the 'expressionLib' field.
      * Additional code fragments that will also be inserted
before executing the expression code.  Allows for function definitions that may
be called from CWL expressions.

      * @param value The value of 'expressionLib'.
      * @return This builder.
      */
    public io.cwl.avro.InlineJavascriptRequirement.Builder setExpressionLib(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[1], value);
      this.expressionLib = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'expressionLib' field has been set.
      * Additional code fragments that will also be inserted
before executing the expression code.  Allows for function definitions that may
be called from CWL expressions.

      * @return True if the 'expressionLib' field has been set, false otherwise.
      */
    public boolean hasExpressionLib() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'expressionLib' field.
      * Additional code fragments that will also be inserted
before executing the expression code.  Allows for function definitions that may
be called from CWL expressions.

      * @return This builder.
      */
    public io.cwl.avro.InlineJavascriptRequirement.Builder clearExpressionLib() {
      expressionLib = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public InlineJavascriptRequirement build() {
      try {
        InlineJavascriptRequirement record = new InlineJavascriptRequirement();
        record.class$ = fieldSetFlags()[0] ? this.class$ : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.expressionLib = fieldSetFlags()[1] ? this.expressionLib : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[1]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<InlineJavascriptRequirement>
    WRITER$ = (org.apache.avro.io.DatumWriter<InlineJavascriptRequirement>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<InlineJavascriptRequirement>
    READER$ = (org.apache.avro.io.DatumReader<InlineJavascriptRequirement>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.class$);

    if (this.expressionLib == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      long size0 = this.expressionLib.size();
      out.writeArrayStart();
      out.setItemCount(size0);
      long actualSize0 = 0;
      for (java.lang.CharSequence e0: this.expressionLib) {
        actualSize0++;
        out.startItem();
        out.writeString(e0);
      }
      out.writeArrayEnd();
      if (actualSize0 != size0)
        throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.class$ = in.readString(this.class$ instanceof Utf8 ? (Utf8)this.class$ : null);

      if (in.readIndex() != 1) {
        in.readNull();
        this.expressionLib = null;
      } else {
        long size0 = in.readArrayStart();
        java.util.List<java.lang.CharSequence> a0 = this.expressionLib;
        if (a0 == null) {
          a0 = new SpecificData.Array<java.lang.CharSequence>((int)size0, SCHEMA$.getField("expressionLib").schema().getTypes().get(1));
          this.expressionLib = a0;
        } else a0.clear();
        SpecificData.Array<java.lang.CharSequence> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a0 : null);
        for ( ; 0 < size0; size0 = in.arrayNext()) {
          for ( ; size0 != 0; size0--) {
            java.lang.CharSequence e0 = (ga0 != null ? ga0.peek() : null);
            e0 = in.readString(e0 instanceof Utf8 ? (Utf8)e0 : null);
            a0.add(e0);
          }
        }
      }

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.class$ = in.readString(this.class$ instanceof Utf8 ? (Utf8)this.class$ : null);
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.expressionLib = null;
          } else {
            long size0 = in.readArrayStart();
            java.util.List<java.lang.CharSequence> a0 = this.expressionLib;
            if (a0 == null) {
              a0 = new SpecificData.Array<java.lang.CharSequence>((int)size0, SCHEMA$.getField("expressionLib").schema().getTypes().get(1));
              this.expressionLib = a0;
            } else a0.clear();
            SpecificData.Array<java.lang.CharSequence> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<java.lang.CharSequence>)a0 : null);
            for ( ; 0 < size0; size0 = in.arrayNext()) {
              for ( ; size0 != 0; size0--) {
                java.lang.CharSequence e0 = (ga0 != null ? ga0.peek() : null);
                e0 = in.readString(e0 instanceof Utf8 ? (Utf8)e0 : null);
                a0.add(e0);
              }
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










