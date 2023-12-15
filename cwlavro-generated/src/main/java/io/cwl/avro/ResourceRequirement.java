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

/** Specify basic hardware resource requirements.

"min" is the minimum amount of a resource that must be reserved to schedule
a job. If "min" cannot be satisfied, the job should not be run.

"max" is the maximum amount of a resource that the job shall be permitted
to use. If a node has sufficient resources, multiple jobs may be scheduled
on a single node provided each job's "max" resource requirements are
met. If a job attempts to exceed its "max" resource allocation, an
implementation may deny additional resources, which may result in job
failure.

If "min" is specified but "max" is not, then "max" == "min"
If "max" is specified by "min" is not, then "min" == "max".

It is an error if max < min.

It is an error if the value of any of these fields is negative.

If neither "min" nor "max" is specified for a resource, an implementation may provide a default.
 */
@org.apache.avro.specific.AvroGenerated
public class ResourceRequirement extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7736034166448298098L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ResourceRequirement\",\"namespace\":\"io.cwl.avro\",\"doc\":\"Specify basic hardware resource requirements.\\n\\n\\\"min\\\" is the minimum amount of a resource that must be reserved to schedule\\na job. If \\\"min\\\" cannot be satisfied, the job should not be run.\\n\\n\\\"max\\\" is the maximum amount of a resource that the job shall be permitted\\nto use. If a node has sufficient resources, multiple jobs may be scheduled\\non a single node provided each job's \\\"max\\\" resource requirements are\\nmet. If a job attempts to exceed its \\\"max\\\" resource allocation, an\\nimplementation may deny additional resources, which may result in job\\nfailure.\\n\\nIf \\\"min\\\" is specified but \\\"max\\\" is not, then \\\"max\\\" == \\\"min\\\"\\nIf \\\"max\\\" is specified by \\\"min\\\" is not, then \\\"min\\\" == \\\"max\\\".\\n\\nIt is an error if max < min.\\n\\nIt is an error if the value of any of these fields is negative.\\n\\nIf neither \\\"min\\\" nor \\\"max\\\" is specified for a resource, an implementation may provide a default.\\n\",\"fields\":[{\"name\":\"class\",\"type\":\"string\",\"doc\":\"Always 'ResourceRequirement'\",\"jsonldPredicate\":{\"_id\":\"@type\",\"_type\":\"@vocab\"}},{\"name\":\"coresMin\",\"type\":[\"null\",\"long\",\"string\",{\"type\":\"enum\",\"name\":\"Expression\",\"doc\":\"'Expression' is not a real type.  It indicates that a field must allow\\nruntime parameter references.  If [InlineJavascriptRequirement](#InlineJavascriptRequirement)\\nis declared and supported by the platform, the field must also allow\\nJavascript expressions.\\n\",\"symbols\":[\"ExpressionPlaceholder\"]}],\"doc\":\"Minimum reserved number of CPU cores\"},{\"name\":\"coresMax\",\"type\":[\"null\",\"int\",\"string\",\"Expression\"],\"doc\":\"Maximum reserved number of CPU cores\"},{\"name\":\"ramMin\",\"type\":[\"null\",\"long\",\"string\",\"Expression\"],\"doc\":\"Minimum reserved RAM in mebibytes (2**20)\"},{\"name\":\"ramMax\",\"type\":[\"null\",\"long\",\"string\",\"Expression\"],\"doc\":\"Maximum reserved RAM in mebibytes (2**20)\"},{\"name\":\"tmpdirMin\",\"type\":[\"null\",\"long\",\"string\",\"Expression\"],\"doc\":\"Minimum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)\"},{\"name\":\"tmpdirMax\",\"type\":[\"null\",\"long\",\"string\",\"Expression\"],\"doc\":\"Maximum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)\"},{\"name\":\"outdirMin\",\"type\":[\"null\",\"long\",\"string\",\"Expression\"],\"doc\":\"Minimum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)\"},{\"name\":\"outdirMax\",\"type\":[\"null\",\"long\",\"string\",\"Expression\"],\"doc\":\"Maximum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)\"}],\"extends\":\"https://w3id.org/cwl/cwl#ProcessRequirement\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<ResourceRequirement> ENCODER =
      new BinaryMessageEncoder<ResourceRequirement>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<ResourceRequirement> DECODER =
      new BinaryMessageDecoder<ResourceRequirement>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<ResourceRequirement> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<ResourceRequirement> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<ResourceRequirement> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<ResourceRequirement>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this ResourceRequirement to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a ResourceRequirement from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a ResourceRequirement instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static ResourceRequirement fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Always 'ResourceRequirement' */
   private java.lang.CharSequence class$;
  /** Minimum reserved number of CPU cores */
   private java.lang.Object coresMin;
  /** Maximum reserved number of CPU cores */
   private java.lang.Object coresMax;
  /** Minimum reserved RAM in mebibytes (2**20) */
   private java.lang.Object ramMin;
  /** Maximum reserved RAM in mebibytes (2**20) */
   private java.lang.Object ramMax;
  /** Minimum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20) */
   private java.lang.Object tmpdirMin;
  /** Maximum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20) */
   private java.lang.Object tmpdirMax;
  /** Minimum reserved filesystem based storage for the designated output directory, in mebibytes (2**20) */
   private java.lang.Object outdirMin;
  /** Maximum reserved filesystem based storage for the designated output directory, in mebibytes (2**20) */
   private java.lang.Object outdirMax;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public ResourceRequirement() {}

  /**
   * All-args constructor.
   * @param class$ Always 'ResourceRequirement'
   * @param coresMin Minimum reserved number of CPU cores
   * @param coresMax Maximum reserved number of CPU cores
   * @param ramMin Minimum reserved RAM in mebibytes (2**20)
   * @param ramMax Maximum reserved RAM in mebibytes (2**20)
   * @param tmpdirMin Minimum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
   * @param tmpdirMax Maximum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
   * @param outdirMin Minimum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
   * @param outdirMax Maximum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
   */
  public ResourceRequirement(java.lang.CharSequence class$, java.lang.Object coresMin, java.lang.Object coresMax, java.lang.Object ramMin, java.lang.Object ramMax, java.lang.Object tmpdirMin, java.lang.Object tmpdirMax, java.lang.Object outdirMin, java.lang.Object outdirMax) {
    this.class$ = class$;
    this.coresMin = coresMin;
    this.coresMax = coresMax;
    this.ramMin = ramMin;
    this.ramMax = ramMax;
    this.tmpdirMin = tmpdirMin;
    this.tmpdirMax = tmpdirMax;
    this.outdirMin = outdirMin;
    this.outdirMax = outdirMax;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return class$;
    case 1: return coresMin;
    case 2: return coresMax;
    case 3: return ramMin;
    case 4: return ramMax;
    case 5: return tmpdirMin;
    case 6: return tmpdirMax;
    case 7: return outdirMin;
    case 8: return outdirMax;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: class$ = (java.lang.CharSequence)value$; break;
    case 1: coresMin = value$; break;
    case 2: coresMax = value$; break;
    case 3: ramMin = value$; break;
    case 4: ramMax = value$; break;
    case 5: tmpdirMin = value$; break;
    case 6: tmpdirMax = value$; break;
    case 7: outdirMin = value$; break;
    case 8: outdirMax = value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'class$' field.
   * @return Always 'ResourceRequirement'
   */
  public java.lang.CharSequence getClass$() {
    return class$;
  }


  /**
   * Sets the value of the 'class$' field.
   * Always 'ResourceRequirement'
   * @param value the value to set.
   */
  public void setClass$(java.lang.CharSequence value) {
    this.class$ = value;
  }

  /**
   * Gets the value of the 'coresMin' field.
   * @return Minimum reserved number of CPU cores
   */
  public java.lang.Object getCoresMin() {
    return coresMin;
  }


  /**
   * Sets the value of the 'coresMin' field.
   * Minimum reserved number of CPU cores
   * @param value the value to set.
   */
  public void setCoresMin(java.lang.Object value) {
    this.coresMin = value;
  }

  /**
   * Gets the value of the 'coresMax' field.
   * @return Maximum reserved number of CPU cores
   */
  public java.lang.Object getCoresMax() {
    return coresMax;
  }


  /**
   * Sets the value of the 'coresMax' field.
   * Maximum reserved number of CPU cores
   * @param value the value to set.
   */
  public void setCoresMax(java.lang.Object value) {
    this.coresMax = value;
  }

  /**
   * Gets the value of the 'ramMin' field.
   * @return Minimum reserved RAM in mebibytes (2**20)
   */
  public java.lang.Object getRamMin() {
    return ramMin;
  }


  /**
   * Sets the value of the 'ramMin' field.
   * Minimum reserved RAM in mebibytes (2**20)
   * @param value the value to set.
   */
  public void setRamMin(java.lang.Object value) {
    this.ramMin = value;
  }

  /**
   * Gets the value of the 'ramMax' field.
   * @return Maximum reserved RAM in mebibytes (2**20)
   */
  public java.lang.Object getRamMax() {
    return ramMax;
  }


  /**
   * Sets the value of the 'ramMax' field.
   * Maximum reserved RAM in mebibytes (2**20)
   * @param value the value to set.
   */
  public void setRamMax(java.lang.Object value) {
    this.ramMax = value;
  }

  /**
   * Gets the value of the 'tmpdirMin' field.
   * @return Minimum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
   */
  public java.lang.Object getTmpdirMin() {
    return tmpdirMin;
  }


  /**
   * Sets the value of the 'tmpdirMin' field.
   * Minimum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
   * @param value the value to set.
   */
  public void setTmpdirMin(java.lang.Object value) {
    this.tmpdirMin = value;
  }

  /**
   * Gets the value of the 'tmpdirMax' field.
   * @return Maximum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
   */
  public java.lang.Object getTmpdirMax() {
    return tmpdirMax;
  }


  /**
   * Sets the value of the 'tmpdirMax' field.
   * Maximum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
   * @param value the value to set.
   */
  public void setTmpdirMax(java.lang.Object value) {
    this.tmpdirMax = value;
  }

  /**
   * Gets the value of the 'outdirMin' field.
   * @return Minimum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
   */
  public java.lang.Object getOutdirMin() {
    return outdirMin;
  }


  /**
   * Sets the value of the 'outdirMin' field.
   * Minimum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
   * @param value the value to set.
   */
  public void setOutdirMin(java.lang.Object value) {
    this.outdirMin = value;
  }

  /**
   * Gets the value of the 'outdirMax' field.
   * @return Maximum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
   */
  public java.lang.Object getOutdirMax() {
    return outdirMax;
  }


  /**
   * Sets the value of the 'outdirMax' field.
   * Maximum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
   * @param value the value to set.
   */
  public void setOutdirMax(java.lang.Object value) {
    this.outdirMax = value;
  }

  /**
   * Creates a new ResourceRequirement RecordBuilder.
   * @return A new ResourceRequirement RecordBuilder
   */
  public static io.cwl.avro.ResourceRequirement.Builder newBuilder() {
    return new io.cwl.avro.ResourceRequirement.Builder();
  }

  /**
   * Creates a new ResourceRequirement RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ResourceRequirement RecordBuilder
   */
  public static io.cwl.avro.ResourceRequirement.Builder newBuilder(io.cwl.avro.ResourceRequirement.Builder other) {
    if (other == null) {
      return new io.cwl.avro.ResourceRequirement.Builder();
    } else {
      return new io.cwl.avro.ResourceRequirement.Builder(other);
    }
  }

  /**
   * Creates a new ResourceRequirement RecordBuilder by copying an existing ResourceRequirement instance.
   * @param other The existing instance to copy.
   * @return A new ResourceRequirement RecordBuilder
   */
  public static io.cwl.avro.ResourceRequirement.Builder newBuilder(io.cwl.avro.ResourceRequirement other) {
    if (other == null) {
      return new io.cwl.avro.ResourceRequirement.Builder();
    } else {
      return new io.cwl.avro.ResourceRequirement.Builder(other);
    }
  }

  /**
   * RecordBuilder for ResourceRequirement instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ResourceRequirement>
    implements org.apache.avro.data.RecordBuilder<ResourceRequirement> {

    /** Always 'ResourceRequirement' */
    private java.lang.CharSequence class$;
    /** Minimum reserved number of CPU cores */
    private java.lang.Object coresMin;
    /** Maximum reserved number of CPU cores */
    private java.lang.Object coresMax;
    /** Minimum reserved RAM in mebibytes (2**20) */
    private java.lang.Object ramMin;
    /** Maximum reserved RAM in mebibytes (2**20) */
    private java.lang.Object ramMax;
    /** Minimum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20) */
    private java.lang.Object tmpdirMin;
    /** Maximum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20) */
    private java.lang.Object tmpdirMax;
    /** Minimum reserved filesystem based storage for the designated output directory, in mebibytes (2**20) */
    private java.lang.Object outdirMin;
    /** Maximum reserved filesystem based storage for the designated output directory, in mebibytes (2**20) */
    private java.lang.Object outdirMax;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.cwl.avro.ResourceRequirement.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.coresMin)) {
        this.coresMin = data().deepCopy(fields()[1].schema(), other.coresMin);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.coresMax)) {
        this.coresMax = data().deepCopy(fields()[2].schema(), other.coresMax);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.ramMin)) {
        this.ramMin = data().deepCopy(fields()[3].schema(), other.ramMin);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.ramMax)) {
        this.ramMax = data().deepCopy(fields()[4].schema(), other.ramMax);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.tmpdirMin)) {
        this.tmpdirMin = data().deepCopy(fields()[5].schema(), other.tmpdirMin);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.tmpdirMax)) {
        this.tmpdirMax = data().deepCopy(fields()[6].schema(), other.tmpdirMax);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.outdirMin)) {
        this.outdirMin = data().deepCopy(fields()[7].schema(), other.outdirMin);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
      if (isValidValue(fields()[8], other.outdirMax)) {
        this.outdirMax = data().deepCopy(fields()[8].schema(), other.outdirMax);
        fieldSetFlags()[8] = other.fieldSetFlags()[8];
      }
    }

    /**
     * Creates a Builder by copying an existing ResourceRequirement instance
     * @param other The existing instance to copy.
     */
    private Builder(io.cwl.avro.ResourceRequirement other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.coresMin)) {
        this.coresMin = data().deepCopy(fields()[1].schema(), other.coresMin);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.coresMax)) {
        this.coresMax = data().deepCopy(fields()[2].schema(), other.coresMax);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.ramMin)) {
        this.ramMin = data().deepCopy(fields()[3].schema(), other.ramMin);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.ramMax)) {
        this.ramMax = data().deepCopy(fields()[4].schema(), other.ramMax);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.tmpdirMin)) {
        this.tmpdirMin = data().deepCopy(fields()[5].schema(), other.tmpdirMin);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.tmpdirMax)) {
        this.tmpdirMax = data().deepCopy(fields()[6].schema(), other.tmpdirMax);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.outdirMin)) {
        this.outdirMin = data().deepCopy(fields()[7].schema(), other.outdirMin);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.outdirMax)) {
        this.outdirMax = data().deepCopy(fields()[8].schema(), other.outdirMax);
        fieldSetFlags()[8] = true;
      }
    }

    /**
      * Gets the value of the 'class$' field.
      * Always 'ResourceRequirement'
      * @return The value.
      */
    public java.lang.CharSequence getClass$() {
      return class$;
    }


    /**
      * Sets the value of the 'class$' field.
      * Always 'ResourceRequirement'
      * @param value The value of 'class$'.
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder setClass$(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.class$ = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'class$' field has been set.
      * Always 'ResourceRequirement'
      * @return True if the 'class$' field has been set, false otherwise.
      */
    public boolean hasClass$() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'class$' field.
      * Always 'ResourceRequirement'
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder clearClass$() {
      class$ = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'coresMin' field.
      * Minimum reserved number of CPU cores
      * @return The value.
      */
    public java.lang.Object getCoresMin() {
      return coresMin;
    }


    /**
      * Sets the value of the 'coresMin' field.
      * Minimum reserved number of CPU cores
      * @param value The value of 'coresMin'.
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder setCoresMin(java.lang.Object value) {
      validate(fields()[1], value);
      this.coresMin = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'coresMin' field has been set.
      * Minimum reserved number of CPU cores
      * @return True if the 'coresMin' field has been set, false otherwise.
      */
    public boolean hasCoresMin() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'coresMin' field.
      * Minimum reserved number of CPU cores
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder clearCoresMin() {
      coresMin = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'coresMax' field.
      * Maximum reserved number of CPU cores
      * @return The value.
      */
    public java.lang.Object getCoresMax() {
      return coresMax;
    }


    /**
      * Sets the value of the 'coresMax' field.
      * Maximum reserved number of CPU cores
      * @param value The value of 'coresMax'.
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder setCoresMax(java.lang.Object value) {
      validate(fields()[2], value);
      this.coresMax = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'coresMax' field has been set.
      * Maximum reserved number of CPU cores
      * @return True if the 'coresMax' field has been set, false otherwise.
      */
    public boolean hasCoresMax() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'coresMax' field.
      * Maximum reserved number of CPU cores
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder clearCoresMax() {
      coresMax = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'ramMin' field.
      * Minimum reserved RAM in mebibytes (2**20)
      * @return The value.
      */
    public java.lang.Object getRamMin() {
      return ramMin;
    }


    /**
      * Sets the value of the 'ramMin' field.
      * Minimum reserved RAM in mebibytes (2**20)
      * @param value The value of 'ramMin'.
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder setRamMin(java.lang.Object value) {
      validate(fields()[3], value);
      this.ramMin = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'ramMin' field has been set.
      * Minimum reserved RAM in mebibytes (2**20)
      * @return True if the 'ramMin' field has been set, false otherwise.
      */
    public boolean hasRamMin() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'ramMin' field.
      * Minimum reserved RAM in mebibytes (2**20)
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder clearRamMin() {
      ramMin = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'ramMax' field.
      * Maximum reserved RAM in mebibytes (2**20)
      * @return The value.
      */
    public java.lang.Object getRamMax() {
      return ramMax;
    }


    /**
      * Sets the value of the 'ramMax' field.
      * Maximum reserved RAM in mebibytes (2**20)
      * @param value The value of 'ramMax'.
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder setRamMax(java.lang.Object value) {
      validate(fields()[4], value);
      this.ramMax = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'ramMax' field has been set.
      * Maximum reserved RAM in mebibytes (2**20)
      * @return True if the 'ramMax' field has been set, false otherwise.
      */
    public boolean hasRamMax() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'ramMax' field.
      * Maximum reserved RAM in mebibytes (2**20)
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder clearRamMax() {
      ramMax = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'tmpdirMin' field.
      * Minimum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
      * @return The value.
      */
    public java.lang.Object getTmpdirMin() {
      return tmpdirMin;
    }


    /**
      * Sets the value of the 'tmpdirMin' field.
      * Minimum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
      * @param value The value of 'tmpdirMin'.
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder setTmpdirMin(java.lang.Object value) {
      validate(fields()[5], value);
      this.tmpdirMin = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'tmpdirMin' field has been set.
      * Minimum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
      * @return True if the 'tmpdirMin' field has been set, false otherwise.
      */
    public boolean hasTmpdirMin() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'tmpdirMin' field.
      * Minimum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder clearTmpdirMin() {
      tmpdirMin = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'tmpdirMax' field.
      * Maximum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
      * @return The value.
      */
    public java.lang.Object getTmpdirMax() {
      return tmpdirMax;
    }


    /**
      * Sets the value of the 'tmpdirMax' field.
      * Maximum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
      * @param value The value of 'tmpdirMax'.
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder setTmpdirMax(java.lang.Object value) {
      validate(fields()[6], value);
      this.tmpdirMax = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'tmpdirMax' field has been set.
      * Maximum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
      * @return True if the 'tmpdirMax' field has been set, false otherwise.
      */
    public boolean hasTmpdirMax() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'tmpdirMax' field.
      * Maximum reserved filesystem based storage for the designated temporary directory, in mebibytes (2**20)
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder clearTmpdirMax() {
      tmpdirMax = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'outdirMin' field.
      * Minimum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
      * @return The value.
      */
    public java.lang.Object getOutdirMin() {
      return outdirMin;
    }


    /**
      * Sets the value of the 'outdirMin' field.
      * Minimum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
      * @param value The value of 'outdirMin'.
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder setOutdirMin(java.lang.Object value) {
      validate(fields()[7], value);
      this.outdirMin = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'outdirMin' field has been set.
      * Minimum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
      * @return True if the 'outdirMin' field has been set, false otherwise.
      */
    public boolean hasOutdirMin() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'outdirMin' field.
      * Minimum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder clearOutdirMin() {
      outdirMin = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'outdirMax' field.
      * Maximum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
      * @return The value.
      */
    public java.lang.Object getOutdirMax() {
      return outdirMax;
    }


    /**
      * Sets the value of the 'outdirMax' field.
      * Maximum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
      * @param value The value of 'outdirMax'.
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder setOutdirMax(java.lang.Object value) {
      validate(fields()[8], value);
      this.outdirMax = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'outdirMax' field has been set.
      * Maximum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
      * @return True if the 'outdirMax' field has been set, false otherwise.
      */
    public boolean hasOutdirMax() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'outdirMax' field.
      * Maximum reserved filesystem based storage for the designated output directory, in mebibytes (2**20)
      * @return This builder.
      */
    public io.cwl.avro.ResourceRequirement.Builder clearOutdirMax() {
      outdirMax = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ResourceRequirement build() {
      try {
        ResourceRequirement record = new ResourceRequirement();
        record.class$ = fieldSetFlags()[0] ? this.class$ : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.coresMin = fieldSetFlags()[1] ? this.coresMin :  defaultValue(fields()[1]);
        record.coresMax = fieldSetFlags()[2] ? this.coresMax :  defaultValue(fields()[2]);
        record.ramMin = fieldSetFlags()[3] ? this.ramMin :  defaultValue(fields()[3]);
        record.ramMax = fieldSetFlags()[4] ? this.ramMax :  defaultValue(fields()[4]);
        record.tmpdirMin = fieldSetFlags()[5] ? this.tmpdirMin :  defaultValue(fields()[5]);
        record.tmpdirMax = fieldSetFlags()[6] ? this.tmpdirMax :  defaultValue(fields()[6]);
        record.outdirMin = fieldSetFlags()[7] ? this.outdirMin :  defaultValue(fields()[7]);
        record.outdirMax = fieldSetFlags()[8] ? this.outdirMax :  defaultValue(fields()[8]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<ResourceRequirement>
    WRITER$ = (org.apache.avro.io.DatumWriter<ResourceRequirement>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<ResourceRequirement>
    READER$ = (org.apache.avro.io.DatumReader<ResourceRequirement>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










