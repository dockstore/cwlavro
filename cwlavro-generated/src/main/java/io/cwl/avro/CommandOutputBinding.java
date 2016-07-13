package io.cwl.avro;
/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */

import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
/** Describes how to generate an output parameter based on the files produced
by a CommandLineTool.

The output parameter is generated by applying these operations in
the following order:

  - glob
  - loadContents
  - outputEval
 */
@org.apache.avro.specific.AvroGenerated
public class CommandOutputBinding extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 5591033144818648536L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CommandOutputBinding\",\"doc\":\"Describes how to generate an output parameter based on the files produced\\nby a CommandLineTool.\\n\\nThe output parameter is generated by applying these operations in\\nthe following order:\\n\\n  - glob\\n  - loadContents\\n  - outputEval\\n\",\"fields\":[{\"name\":\"glob\",\"type\":[\"null\",\"string\",{\"type\":\"enum\",\"name\":\"Expression\",\"doc\":\"'Expression' is not a real type.  It indicates that a field must allow\\nruntime parameter references.  If [InlineJavascriptRequirement](#InlineJavascriptRequirement)\\nis declared and supported by the platform, the field must also allow\\nJavascript expressions.\\n\",\"symbols\":[\"ExpressionPlaceholder\"]},{\"type\":\"array\",\"items\":\"string\"}],\"doc\":\"Find files relative to the output directory, using POSIX glob(3)\\npathname matching.  If an array is provided, find files that match any\\npattern in the array.  If an expression is provided, the expression must\\nreturn a string or an array of strings, which will then be evaluated as\\none or more glob patterns.  Must only match and return files which\\nactually exist.\\n\"},{\"name\":\"loadContents\",\"type\":[\"null\",\"boolean\"],\"doc\":\"For each file matched in `glob`, read up to\\nthe first 64 KiB of text from the file and place it in the `contents`\\nfield of the file object for manipulation by `outputEval`.\\n\",\"jsonldPredicate\":\"cwl:loadContents\"},{\"name\":\"outputEval\",\"type\":[\"null\",\"string\",\"Expression\"],\"doc\":\"Evaluate an expression to generate the output value.  If `glob` was\\nspecified, the value of `self` must be an array containing file objects\\nthat were matched.  If no files were matched, `self` must be a zero\\nlength array; if a single file was matched, the value of `self` is an\\narray of a single element.  Additionally, if `loadContents` is `true`,\\nthe File objects must include up to the first 64 KiB of file contents\\nin the `contents` field.\\n\"}],\"extends\":\"https://w3id.org/cwl/cwl#OutputBinding\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  /** Find files relative to the output directory, using POSIX glob(3)
pathname matching.  If an array is provided, find files that match any
pattern in the array.  If an expression is provided, the expression must
return a string or an array of strings, which will then be evaluated as
one or more glob patterns.  Must only match and return files which
actually exist.
 */
  @Deprecated public java.lang.Object glob;
  /** For each file matched in `glob`, read up to
the first 64 KiB of text from the file and place it in the `contents`
field of the file object for manipulation by `outputEval`.
 */
  @Deprecated public java.lang.Boolean loadContents;
  /** Evaluate an expression to generate the output value.  If `glob` was
specified, the value of `self` must be an array containing file objects
that were matched.  If no files were matched, `self` must be a zero
length array; if a single file was matched, the value of `self` is an
array of a single element.  Additionally, if `loadContents` is `true`,
the File objects must include up to the first 64 KiB of file contents
in the `contents` field.
 */
  @Deprecated public java.lang.Object outputEval;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CommandOutputBinding() {}

  /**
   * All-args constructor.
   * @param glob Find files relative to the output directory, using POSIX glob(3)
pathname matching.  If an array is provided, find files that match any
pattern in the array.  If an expression is provided, the expression must
return a string or an array of strings, which will then be evaluated as
one or more glob patterns.  Must only match and return files which
actually exist.

   * @param loadContents For each file matched in `glob`, read up to
the first 64 KiB of text from the file and place it in the `contents`
field of the file object for manipulation by `outputEval`.

   * @param outputEval Evaluate an expression to generate the output value.  If `glob` was
specified, the value of `self` must be an array containing file objects
that were matched.  If no files were matched, `self` must be a zero
length array; if a single file was matched, the value of `self` is an
array of a single element.  Additionally, if `loadContents` is `true`,
the File objects must include up to the first 64 KiB of file contents
in the `contents` field.

   */
  public CommandOutputBinding(java.lang.Object glob, java.lang.Boolean loadContents, java.lang.Object outputEval) {
    this.glob = glob;
    this.loadContents = loadContents;
    this.outputEval = outputEval;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return glob;
    case 1: return loadContents;
    case 2: return outputEval;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: glob = (java.lang.Object)value$; break;
    case 1: loadContents = (java.lang.Boolean)value$; break;
    case 2: outputEval = (java.lang.Object)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'glob' field.
   * @return Find files relative to the output directory, using POSIX glob(3)
pathname matching.  If an array is provided, find files that match any
pattern in the array.  If an expression is provided, the expression must
return a string or an array of strings, which will then be evaluated as
one or more glob patterns.  Must only match and return files which
actually exist.

   */
  public java.lang.Object getGlob() {
    return glob;
  }

  /**
   * Sets the value of the 'glob' field.
   * Find files relative to the output directory, using POSIX glob(3)
pathname matching.  If an array is provided, find files that match any
pattern in the array.  If an expression is provided, the expression must
return a string or an array of strings, which will then be evaluated as
one or more glob patterns.  Must only match and return files which
actually exist.

   * @param value the value to set.
   */
  public void setGlob(java.lang.Object value) {
    this.glob = value;
  }

  /**
   * Gets the value of the 'loadContents' field.
   * @return For each file matched in `glob`, read up to
the first 64 KiB of text from the file and place it in the `contents`
field of the file object for manipulation by `outputEval`.

   */
  public java.lang.Boolean getLoadContents() {
    return loadContents;
  }

  /**
   * Sets the value of the 'loadContents' field.
   * For each file matched in `glob`, read up to
the first 64 KiB of text from the file and place it in the `contents`
field of the file object for manipulation by `outputEval`.

   * @param value the value to set.
   */
  public void setLoadContents(java.lang.Boolean value) {
    this.loadContents = value;
  }

  /**
   * Gets the value of the 'outputEval' field.
   * @return Evaluate an expression to generate the output value.  If `glob` was
specified, the value of `self` must be an array containing file objects
that were matched.  If no files were matched, `self` must be a zero
length array; if a single file was matched, the value of `self` is an
array of a single element.  Additionally, if `loadContents` is `true`,
the File objects must include up to the first 64 KiB of file contents
in the `contents` field.

   */
  public java.lang.Object getOutputEval() {
    return outputEval;
  }

  /**
   * Sets the value of the 'outputEval' field.
   * Evaluate an expression to generate the output value.  If `glob` was
specified, the value of `self` must be an array containing file objects
that were matched.  If no files were matched, `self` must be a zero
length array; if a single file was matched, the value of `self` is an
array of a single element.  Additionally, if `loadContents` is `true`,
the File objects must include up to the first 64 KiB of file contents
in the `contents` field.

   * @param value the value to set.
   */
  public void setOutputEval(java.lang.Object value) {
    this.outputEval = value;
  }

  /**
   * Creates a new CommandOutputBinding RecordBuilder.
   * @return A new CommandOutputBinding RecordBuilder
   */
  public static CommandOutputBinding.Builder newBuilder() {
    return new CommandOutputBinding.Builder();
  }

  /**
   * Creates a new CommandOutputBinding RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CommandOutputBinding RecordBuilder
   */
  public static CommandOutputBinding.Builder newBuilder(CommandOutputBinding.Builder other) {
    return new CommandOutputBinding.Builder(other);
  }

  /**
   * Creates a new CommandOutputBinding RecordBuilder by copying an existing CommandOutputBinding instance.
   * @param other The existing instance to copy.
   * @return A new CommandOutputBinding RecordBuilder
   */
  public static CommandOutputBinding.Builder newBuilder(CommandOutputBinding other) {
    return new CommandOutputBinding.Builder(other);
  }

  /**
   * RecordBuilder for CommandOutputBinding instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CommandOutputBinding>
    implements org.apache.avro.data.RecordBuilder<CommandOutputBinding> {

    /** Find files relative to the output directory, using POSIX glob(3)
pathname matching.  If an array is provided, find files that match any
pattern in the array.  If an expression is provided, the expression must
return a string or an array of strings, which will then be evaluated as
one or more glob patterns.  Must only match and return files which
actually exist.
 */
    private java.lang.Object glob;
    /** For each file matched in `glob`, read up to
the first 64 KiB of text from the file and place it in the `contents`
field of the file object for manipulation by `outputEval`.
 */
    private java.lang.Boolean loadContents;
    /** Evaluate an expression to generate the output value.  If `glob` was
specified, the value of `self` must be an array containing file objects
that were matched.  If no files were matched, `self` must be a zero
length array; if a single file was matched, the value of `self` is an
array of a single element.  Additionally, if `loadContents` is `true`,
the File objects must include up to the first 64 KiB of file contents
in the `contents` field.
 */
    private java.lang.Object outputEval;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(CommandOutputBinding.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.glob)) {
        this.glob = data().deepCopy(fields()[0].schema(), other.glob);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.loadContents)) {
        this.loadContents = data().deepCopy(fields()[1].schema(), other.loadContents);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.outputEval)) {
        this.outputEval = data().deepCopy(fields()[2].schema(), other.outputEval);
        fieldSetFlags()[2] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing CommandOutputBinding instance
     * @param other The existing instance to copy.
     */
    private Builder(CommandOutputBinding other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.glob)) {
        this.glob = data().deepCopy(fields()[0].schema(), other.glob);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.loadContents)) {
        this.loadContents = data().deepCopy(fields()[1].schema(), other.loadContents);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.outputEval)) {
        this.outputEval = data().deepCopy(fields()[2].schema(), other.outputEval);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'glob' field.
      * Find files relative to the output directory, using POSIX glob(3)
pathname matching.  If an array is provided, find files that match any
pattern in the array.  If an expression is provided, the expression must
return a string or an array of strings, which will then be evaluated as
one or more glob patterns.  Must only match and return files which
actually exist.

      * @return The value.
      */
    public java.lang.Object getGlob() {
      return glob;
    }

    /**
      * Sets the value of the 'glob' field.
      * Find files relative to the output directory, using POSIX glob(3)
pathname matching.  If an array is provided, find files that match any
pattern in the array.  If an expression is provided, the expression must
return a string or an array of strings, which will then be evaluated as
one or more glob patterns.  Must only match and return files which
actually exist.

      * @param value The value of 'glob'.
      * @return This builder.
      */
    public CommandOutputBinding.Builder setGlob(java.lang.Object value) {
      validate(fields()[0], value);
      this.glob = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'glob' field has been set.
      * Find files relative to the output directory, using POSIX glob(3)
pathname matching.  If an array is provided, find files that match any
pattern in the array.  If an expression is provided, the expression must
return a string or an array of strings, which will then be evaluated as
one or more glob patterns.  Must only match and return files which
actually exist.

      * @return True if the 'glob' field has been set, false otherwise.
      */
    public boolean hasGlob() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'glob' field.
      * Find files relative to the output directory, using POSIX glob(3)
pathname matching.  If an array is provided, find files that match any
pattern in the array.  If an expression is provided, the expression must
return a string or an array of strings, which will then be evaluated as
one or more glob patterns.  Must only match and return files which
actually exist.

      * @return This builder.
      */
    public CommandOutputBinding.Builder clearGlob() {
      glob = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'loadContents' field.
      * For each file matched in `glob`, read up to
the first 64 KiB of text from the file and place it in the `contents`
field of the file object for manipulation by `outputEval`.

      * @return The value.
      */
    public java.lang.Boolean getLoadContents() {
      return loadContents;
    }

    /**
      * Sets the value of the 'loadContents' field.
      * For each file matched in `glob`, read up to
the first 64 KiB of text from the file and place it in the `contents`
field of the file object for manipulation by `outputEval`.

      * @param value The value of 'loadContents'.
      * @return This builder.
      */
    public CommandOutputBinding.Builder setLoadContents(java.lang.Boolean value) {
      validate(fields()[1], value);
      this.loadContents = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'loadContents' field has been set.
      * For each file matched in `glob`, read up to
the first 64 KiB of text from the file and place it in the `contents`
field of the file object for manipulation by `outputEval`.

      * @return True if the 'loadContents' field has been set, false otherwise.
      */
    public boolean hasLoadContents() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'loadContents' field.
      * For each file matched in `glob`, read up to
the first 64 KiB of text from the file and place it in the `contents`
field of the file object for manipulation by `outputEval`.

      * @return This builder.
      */
    public CommandOutputBinding.Builder clearLoadContents() {
      loadContents = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'outputEval' field.
      * Evaluate an expression to generate the output value.  If `glob` was
specified, the value of `self` must be an array containing file objects
that were matched.  If no files were matched, `self` must be a zero
length array; if a single file was matched, the value of `self` is an
array of a single element.  Additionally, if `loadContents` is `true`,
the File objects must include up to the first 64 KiB of file contents
in the `contents` field.

      * @return The value.
      */
    public java.lang.Object getOutputEval() {
      return outputEval;
    }

    /**
      * Sets the value of the 'outputEval' field.
      * Evaluate an expression to generate the output value.  If `glob` was
specified, the value of `self` must be an array containing file objects
that were matched.  If no files were matched, `self` must be a zero
length array; if a single file was matched, the value of `self` is an
array of a single element.  Additionally, if `loadContents` is `true`,
the File objects must include up to the first 64 KiB of file contents
in the `contents` field.

      * @param value The value of 'outputEval'.
      * @return This builder.
      */
    public CommandOutputBinding.Builder setOutputEval(java.lang.Object value) {
      validate(fields()[2], value);
      this.outputEval = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'outputEval' field has been set.
      * Evaluate an expression to generate the output value.  If `glob` was
specified, the value of `self` must be an array containing file objects
that were matched.  If no files were matched, `self` must be a zero
length array; if a single file was matched, the value of `self` is an
array of a single element.  Additionally, if `loadContents` is `true`,
the File objects must include up to the first 64 KiB of file contents
in the `contents` field.

      * @return True if the 'outputEval' field has been set, false otherwise.
      */
    public boolean hasOutputEval() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'outputEval' field.
      * Evaluate an expression to generate the output value.  If `glob` was
specified, the value of `self` must be an array containing file objects
that were matched.  If no files were matched, `self` must be a zero
length array; if a single file was matched, the value of `self` is an
array of a single element.  Additionally, if `loadContents` is `true`,
the File objects must include up to the first 64 KiB of file contents
in the `contents` field.

      * @return This builder.
      */
    public CommandOutputBinding.Builder clearOutputEval() {
      outputEval = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public CommandOutputBinding build() {
      try {
        CommandOutputBinding record = new CommandOutputBinding();
        record.glob = fieldSetFlags()[0] ? this.glob : (java.lang.Object) defaultValue(fields()[0]);
        record.loadContents = fieldSetFlags()[1] ? this.loadContents : (java.lang.Boolean) defaultValue(fields()[1]);
        record.outputEval = fieldSetFlags()[2] ? this.outputEval : (java.lang.Object) defaultValue(fields()[2]);
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