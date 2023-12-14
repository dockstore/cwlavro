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

/** Define a file or subdirectory that must be placed in the designated output
directory prior to executing the command line tool.  May be the result of
executing an expression, such as building a configuration file from a
template.
 */
@org.apache.avro.specific.AvroGenerated
public class Dirent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5499099540509567238L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Dirent\",\"namespace\":\"io.cwl.avro\",\"doc\":\"Define a file or subdirectory that must be placed in the designated output\\ndirectory prior to executing the command line tool.  May be the result of\\nexecuting an expression, such as building a configuration file from a\\ntemplate.\\n\",\"fields\":[{\"name\":\"entryname\",\"type\":[\"null\",\"string\",{\"type\":\"enum\",\"name\":\"Expression\",\"doc\":\"'Expression' is not a real type.  It indicates that a field must allow\\nruntime parameter references.  If [InlineJavascriptRequirement](#InlineJavascriptRequirement)\\nis declared and supported by the platform, the field must also allow\\nJavascript expressions.\\n\",\"symbols\":[\"ExpressionPlaceholder\"]}],\"doc\":\"The name of the file or subdirectory to create in the output directory.\\nIf `entry` is a File or Directory, the `entryname` field overrides the value\\nof `basename` of the File or Directory object.  Optional.\\n\",\"jsonldPredicate\":{\"_id\":\"https://w3id.org/cwl/cwl#entryname\"}},{\"name\":\"entry\",\"type\":[\"string\",\"Expression\"],\"doc\":\"If the value is a string literal or an expression which evaluates to a\\nstring, a new file must be created with the string as the file contents.\\n\\nIf the value is an expression that evaluates to a `File` object, this\\nindicates the referenced file should be added to the designated output\\ndirectory prior to executing the tool.\\n\\nIf the value is an expression that evaluates to a `Dirent` object, this\\nindicates that the File or Directory in `entry` should be added to the\\ndesignated output directory with the name in `entryname`.\\n\\nIf `writable` is false, the file may be made available using a bind\\nmount or file system link to avoid unnecessary copying of the input\\nfile.\\n\",\"jsonldPredicate\":{\"_id\":\"https://w3id.org/cwl/cwl#entry\"}},{\"name\":\"writable\",\"type\":[\"null\",\"boolean\"],\"doc\":\"If true, the file or directory must be writable by the tool.  Changes\\nto the file or directory must be isolated and not visible by any other\\nCommandLineTool process.  This may be implemented by making a copy of\\nthe original file or directory.  Default false (files and directories\\nread-only by default).\\n\\nA directory marked as `writable: true` implies that all files and\\nsubdirectories are recursively writable as well.\\n\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Dirent> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Dirent> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Dirent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Dirent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Dirent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Dirent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Dirent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Dirent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Dirent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** The name of the file or subdirectory to create in the output directory.
If `entry` is a File or Directory, the `entryname` field overrides the value
of `basename` of the File or Directory object.  Optional.
 */
  private java.lang.Object entryname;
  /** If the value is a string literal or an expression which evaluates to a
string, a new file must be created with the string as the file contents.

If the value is an expression that evaluates to a `File` object, this
indicates the referenced file should be added to the designated output
directory prior to executing the tool.

If the value is an expression that evaluates to a `Dirent` object, this
indicates that the File or Directory in `entry` should be added to the
designated output directory with the name in `entryname`.

If `writable` is false, the file may be made available using a bind
mount or file system link to avoid unnecessary copying of the input
file.
 */
  private java.lang.Object entry;
  /** If true, the file or directory must be writable by the tool.  Changes
to the file or directory must be isolated and not visible by any other
CommandLineTool process.  This may be implemented by making a copy of
the original file or directory.  Default false (files and directories
read-only by default).

A directory marked as `writable: true` implies that all files and
subdirectories are recursively writable as well.
 */
  private java.lang.Boolean writable;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Dirent() {}

  /**
   * All-args constructor.
   * @param entryname The name of the file or subdirectory to create in the output directory.
If `entry` is a File or Directory, the `entryname` field overrides the value
of `basename` of the File or Directory object.  Optional.

   * @param entry If the value is a string literal or an expression which evaluates to a
string, a new file must be created with the string as the file contents.

If the value is an expression that evaluates to a `File` object, this
indicates the referenced file should be added to the designated output
directory prior to executing the tool.

If the value is an expression that evaluates to a `Dirent` object, this
indicates that the File or Directory in `entry` should be added to the
designated output directory with the name in `entryname`.

If `writable` is false, the file may be made available using a bind
mount or file system link to avoid unnecessary copying of the input
file.

   * @param writable If true, the file or directory must be writable by the tool.  Changes
to the file or directory must be isolated and not visible by any other
CommandLineTool process.  This may be implemented by making a copy of
the original file or directory.  Default false (files and directories
read-only by default).

A directory marked as `writable: true` implies that all files and
subdirectories are recursively writable as well.

   */
  public Dirent(java.lang.Object entryname, java.lang.Object entry, java.lang.Boolean writable) {
    this.entryname = entryname;
    this.entry = entry;
    this.writable = writable;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return entryname;
    case 1: return entry;
    case 2: return writable;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: entryname = value$; break;
    case 1: entry = value$; break;
    case 2: writable = (java.lang.Boolean)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'entryname' field.
   * @return The name of the file or subdirectory to create in the output directory.
If `entry` is a File or Directory, the `entryname` field overrides the value
of `basename` of the File or Directory object.  Optional.

   */
  public java.lang.Object getEntryname() {
    return entryname;
  }


  /**
   * Sets the value of the 'entryname' field.
   * The name of the file or subdirectory to create in the output directory.
If `entry` is a File or Directory, the `entryname` field overrides the value
of `basename` of the File or Directory object.  Optional.

   * @param value the value to set.
   */
  public void setEntryname(java.lang.Object value) {
    this.entryname = value;
  }

  /**
   * Gets the value of the 'entry' field.
   * @return If the value is a string literal or an expression which evaluates to a
string, a new file must be created with the string as the file contents.

If the value is an expression that evaluates to a `File` object, this
indicates the referenced file should be added to the designated output
directory prior to executing the tool.

If the value is an expression that evaluates to a `Dirent` object, this
indicates that the File or Directory in `entry` should be added to the
designated output directory with the name in `entryname`.

If `writable` is false, the file may be made available using a bind
mount or file system link to avoid unnecessary copying of the input
file.

   */
  public java.lang.Object getEntry() {
    return entry;
  }


  /**
   * Sets the value of the 'entry' field.
   * If the value is a string literal or an expression which evaluates to a
string, a new file must be created with the string as the file contents.

If the value is an expression that evaluates to a `File` object, this
indicates the referenced file should be added to the designated output
directory prior to executing the tool.

If the value is an expression that evaluates to a `Dirent` object, this
indicates that the File or Directory in `entry` should be added to the
designated output directory with the name in `entryname`.

If `writable` is false, the file may be made available using a bind
mount or file system link to avoid unnecessary copying of the input
file.

   * @param value the value to set.
   */
  public void setEntry(java.lang.Object value) {
    this.entry = value;
  }

  /**
   * Gets the value of the 'writable' field.
   * @return If true, the file or directory must be writable by the tool.  Changes
to the file or directory must be isolated and not visible by any other
CommandLineTool process.  This may be implemented by making a copy of
the original file or directory.  Default false (files and directories
read-only by default).

A directory marked as `writable: true` implies that all files and
subdirectories are recursively writable as well.

   */
  public java.lang.Boolean getWritable() {
    return writable;
  }


  /**
   * Sets the value of the 'writable' field.
   * If true, the file or directory must be writable by the tool.  Changes
to the file or directory must be isolated and not visible by any other
CommandLineTool process.  This may be implemented by making a copy of
the original file or directory.  Default false (files and directories
read-only by default).

A directory marked as `writable: true` implies that all files and
subdirectories are recursively writable as well.

   * @param value the value to set.
   */
  public void setWritable(java.lang.Boolean value) {
    this.writable = value;
  }

  /**
   * Creates a new Dirent RecordBuilder.
   * @return A new Dirent RecordBuilder
   */
  public static io.cwl.avro.Dirent.Builder newBuilder() {
    return new io.cwl.avro.Dirent.Builder();
  }

  /**
   * Creates a new Dirent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Dirent RecordBuilder
   */
  public static io.cwl.avro.Dirent.Builder newBuilder(io.cwl.avro.Dirent.Builder other) {
    if (other == null) {
      return new io.cwl.avro.Dirent.Builder();
    } else {
      return new io.cwl.avro.Dirent.Builder(other);
    }
  }

  /**
   * Creates a new Dirent RecordBuilder by copying an existing Dirent instance.
   * @param other The existing instance to copy.
   * @return A new Dirent RecordBuilder
   */
  public static io.cwl.avro.Dirent.Builder newBuilder(io.cwl.avro.Dirent other) {
    if (other == null) {
      return new io.cwl.avro.Dirent.Builder();
    } else {
      return new io.cwl.avro.Dirent.Builder(other);
    }
  }

  /**
   * RecordBuilder for Dirent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Dirent>
    implements org.apache.avro.data.RecordBuilder<Dirent> {

    /** The name of the file or subdirectory to create in the output directory.
If `entry` is a File or Directory, the `entryname` field overrides the value
of `basename` of the File or Directory object.  Optional.
 */
    private java.lang.Object entryname;
    /** If the value is a string literal or an expression which evaluates to a
string, a new file must be created with the string as the file contents.

If the value is an expression that evaluates to a `File` object, this
indicates the referenced file should be added to the designated output
directory prior to executing the tool.

If the value is an expression that evaluates to a `Dirent` object, this
indicates that the File or Directory in `entry` should be added to the
designated output directory with the name in `entryname`.

If `writable` is false, the file may be made available using a bind
mount or file system link to avoid unnecessary copying of the input
file.
 */
    private java.lang.Object entry;
    /** If true, the file or directory must be writable by the tool.  Changes
to the file or directory must be isolated and not visible by any other
CommandLineTool process.  This may be implemented by making a copy of
the original file or directory.  Default false (files and directories
read-only by default).

A directory marked as `writable: true` implies that all files and
subdirectories are recursively writable as well.
 */
    private java.lang.Boolean writable;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.cwl.avro.Dirent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.entryname)) {
        this.entryname = data().deepCopy(fields()[0].schema(), other.entryname);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.entry)) {
        this.entry = data().deepCopy(fields()[1].schema(), other.entry);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.writable)) {
        this.writable = data().deepCopy(fields()[2].schema(), other.writable);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing Dirent instance
     * @param other The existing instance to copy.
     */
    private Builder(io.cwl.avro.Dirent other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.entryname)) {
        this.entryname = data().deepCopy(fields()[0].schema(), other.entryname);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.entry)) {
        this.entry = data().deepCopy(fields()[1].schema(), other.entry);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.writable)) {
        this.writable = data().deepCopy(fields()[2].schema(), other.writable);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'entryname' field.
      * The name of the file or subdirectory to create in the output directory.
If `entry` is a File or Directory, the `entryname` field overrides the value
of `basename` of the File or Directory object.  Optional.

      * @return The value.
      */
    public java.lang.Object getEntryname() {
      return entryname;
    }


    /**
      * Sets the value of the 'entryname' field.
      * The name of the file or subdirectory to create in the output directory.
If `entry` is a File or Directory, the `entryname` field overrides the value
of `basename` of the File or Directory object.  Optional.

      * @param value The value of 'entryname'.
      * @return This builder.
      */
    public io.cwl.avro.Dirent.Builder setEntryname(java.lang.Object value) {
      validate(fields()[0], value);
      this.entryname = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'entryname' field has been set.
      * The name of the file or subdirectory to create in the output directory.
If `entry` is a File or Directory, the `entryname` field overrides the value
of `basename` of the File or Directory object.  Optional.

      * @return True if the 'entryname' field has been set, false otherwise.
      */
    public boolean hasEntryname() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'entryname' field.
      * The name of the file or subdirectory to create in the output directory.
If `entry` is a File or Directory, the `entryname` field overrides the value
of `basename` of the File or Directory object.  Optional.

      * @return This builder.
      */
    public io.cwl.avro.Dirent.Builder clearEntryname() {
      entryname = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'entry' field.
      * If the value is a string literal or an expression which evaluates to a
string, a new file must be created with the string as the file contents.

If the value is an expression that evaluates to a `File` object, this
indicates the referenced file should be added to the designated output
directory prior to executing the tool.

If the value is an expression that evaluates to a `Dirent` object, this
indicates that the File or Directory in `entry` should be added to the
designated output directory with the name in `entryname`.

If `writable` is false, the file may be made available using a bind
mount or file system link to avoid unnecessary copying of the input
file.

      * @return The value.
      */
    public java.lang.Object getEntry() {
      return entry;
    }


    /**
      * Sets the value of the 'entry' field.
      * If the value is a string literal or an expression which evaluates to a
string, a new file must be created with the string as the file contents.

If the value is an expression that evaluates to a `File` object, this
indicates the referenced file should be added to the designated output
directory prior to executing the tool.

If the value is an expression that evaluates to a `Dirent` object, this
indicates that the File or Directory in `entry` should be added to the
designated output directory with the name in `entryname`.

If `writable` is false, the file may be made available using a bind
mount or file system link to avoid unnecessary copying of the input
file.

      * @param value The value of 'entry'.
      * @return This builder.
      */
    public io.cwl.avro.Dirent.Builder setEntry(java.lang.Object value) {
      validate(fields()[1], value);
      this.entry = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'entry' field has been set.
      * If the value is a string literal or an expression which evaluates to a
string, a new file must be created with the string as the file contents.

If the value is an expression that evaluates to a `File` object, this
indicates the referenced file should be added to the designated output
directory prior to executing the tool.

If the value is an expression that evaluates to a `Dirent` object, this
indicates that the File or Directory in `entry` should be added to the
designated output directory with the name in `entryname`.

If `writable` is false, the file may be made available using a bind
mount or file system link to avoid unnecessary copying of the input
file.

      * @return True if the 'entry' field has been set, false otherwise.
      */
    public boolean hasEntry() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'entry' field.
      * If the value is a string literal or an expression which evaluates to a
string, a new file must be created with the string as the file contents.

If the value is an expression that evaluates to a `File` object, this
indicates the referenced file should be added to the designated output
directory prior to executing the tool.

If the value is an expression that evaluates to a `Dirent` object, this
indicates that the File or Directory in `entry` should be added to the
designated output directory with the name in `entryname`.

If `writable` is false, the file may be made available using a bind
mount or file system link to avoid unnecessary copying of the input
file.

      * @return This builder.
      */
    public io.cwl.avro.Dirent.Builder clearEntry() {
      entry = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'writable' field.
      * If true, the file or directory must be writable by the tool.  Changes
to the file or directory must be isolated and not visible by any other
CommandLineTool process.  This may be implemented by making a copy of
the original file or directory.  Default false (files and directories
read-only by default).

A directory marked as `writable: true` implies that all files and
subdirectories are recursively writable as well.

      * @return The value.
      */
    public java.lang.Boolean getWritable() {
      return writable;
    }


    /**
      * Sets the value of the 'writable' field.
      * If true, the file or directory must be writable by the tool.  Changes
to the file or directory must be isolated and not visible by any other
CommandLineTool process.  This may be implemented by making a copy of
the original file or directory.  Default false (files and directories
read-only by default).

A directory marked as `writable: true` implies that all files and
subdirectories are recursively writable as well.

      * @param value The value of 'writable'.
      * @return This builder.
      */
    public io.cwl.avro.Dirent.Builder setWritable(java.lang.Boolean value) {
      validate(fields()[2], value);
      this.writable = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'writable' field has been set.
      * If true, the file or directory must be writable by the tool.  Changes
to the file or directory must be isolated and not visible by any other
CommandLineTool process.  This may be implemented by making a copy of
the original file or directory.  Default false (files and directories
read-only by default).

A directory marked as `writable: true` implies that all files and
subdirectories are recursively writable as well.

      * @return True if the 'writable' field has been set, false otherwise.
      */
    public boolean hasWritable() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'writable' field.
      * If true, the file or directory must be writable by the tool.  Changes
to the file or directory must be isolated and not visible by any other
CommandLineTool process.  This may be implemented by making a copy of
the original file or directory.  Default false (files and directories
read-only by default).

A directory marked as `writable: true` implies that all files and
subdirectories are recursively writable as well.

      * @return This builder.
      */
    public io.cwl.avro.Dirent.Builder clearWritable() {
      writable = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Dirent build() {
      try {
        Dirent record = new Dirent();
        record.entryname = fieldSetFlags()[0] ? this.entryname :  defaultValue(fields()[0]);
        record.entry = fieldSetFlags()[1] ? this.entry :  defaultValue(fields()[1]);
        record.writable = fieldSetFlags()[2] ? this.writable : (java.lang.Boolean) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Dirent>
    WRITER$ = (org.apache.avro.io.DatumWriter<Dirent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Dirent>
    READER$ = (org.apache.avro.io.DatumReader<Dirent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










