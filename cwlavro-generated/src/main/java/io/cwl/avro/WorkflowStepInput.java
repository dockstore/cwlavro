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

/** The input of a workflow step connects an upstream parameter (from the
workflow inputs, or the outputs of other workflows steps) with the input
parameters of the underlying step.

## Input object

A WorkflowStepInput object must contain an `id` field in the form
`#fieldname` or `#prefix/fieldname`.  When the `id` field contains a slash
`/` the field name consists of the characters following the final slash
(the prefix portion may contain one or more slashes to indicate scope).
This defines a field of the workflow step input object with the value of
the `source` parameter(s).

## Merging

To merge multiple inbound data links,
[MultipleInputFeatureRequirement](#MultipleInputFeatureRequirement) must be specified
in the workflow or workflow step requirements.

If the sink parameter is an array, or named in a [workflow
scatter](#WorkflowStep) operation, there may be multiple inbound data links
listed in the `source` field.  The values from the input links are merged
depending on the method specified in the `linkMerge` field.  If not
specified, the default method is "merge_nested".

* **merge_nested**

  The input must be an array consisting of exactly one entry for each
  input link.  If "merge_nested" is specified with a single link, the value
  from the link must be wrapped in a single-item list.

* **merge_flattened**

  1. The source and sink parameters must be compatible types, or the source
     type must be compatible with single element from the "items" type of
     the destination array parameter.
  2. Source parameters which are arrays are concatenated.
     Source parameters which are single element types are appended as
     single elements.
 */
@org.apache.avro.specific.AvroGenerated
public class WorkflowStepInput extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 34589740441855809L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WorkflowStepInput\",\"namespace\":\"io.cwl.avro\",\"doc\":\"The input of a workflow step connects an upstream parameter (from the\\nworkflow inputs, or the outputs of other workflows steps) with the input\\nparameters of the underlying step.\\n\\n## Input object\\n\\nA WorkflowStepInput object must contain an `id` field in the form\\n`#fieldname` or `#prefix/fieldname`.  When the `id` field contains a slash\\n`/` the field name consists of the characters following the final slash\\n(the prefix portion may contain one or more slashes to indicate scope).\\nThis defines a field of the workflow step input object with the value of\\nthe `source` parameter(s).\\n\\n## Merging\\n\\nTo merge multiple inbound data links,\\n[MultipleInputFeatureRequirement](#MultipleInputFeatureRequirement) must be specified\\nin the workflow or workflow step requirements.\\n\\nIf the sink parameter is an array, or named in a [workflow\\nscatter](#WorkflowStep) operation, there may be multiple inbound data links\\nlisted in the `source` field.  The values from the input links are merged\\ndepending on the method specified in the `linkMerge` field.  If not\\nspecified, the default method is \\\"merge_nested\\\".\\n\\n* **merge_nested**\\n\\n  The input must be an array consisting of exactly one entry for each\\n  input link.  If \\\"merge_nested\\\" is specified with a single link, the value\\n  from the link must be wrapped in a single-item list.\\n\\n* **merge_flattened**\\n\\n  1. The source and sink parameters must be compatible types, or the source\\n     type must be compatible with single element from the \\\"items\\\" type of\\n     the destination array parameter.\\n  2. Source parameters which are arrays are concatenated.\\n     Source parameters which are single element types are appended as\\n     single elements.\\n\",\"fields\":[{\"name\":\"source\",\"type\":[\"null\",\"string\",{\"type\":\"array\",\"items\":\"string\"}],\"doc\":\"Specifies one or more workflow parameters that will provide input to\\nthe underlying step parameter.\\n\",\"jsonldPredicate\":{\"_id\":\"https://w3id.org/cwl/cwl#source\",\"_type\":\"@id\",\"refScope\":2},\"inherited_from\":\"https://w3id.org/cwl/cwl#Sink\"},{\"name\":\"linkMerge\",\"type\":[\"null\",{\"type\":\"enum\",\"name\":\"LinkMergeMethod\",\"doc\":\"The input link merge method, described in [WorkflowStepInput](#WorkflowStepInput).\",\"symbols\":[\"merge_nested\",\"merge_flattened\"],\"docParent\":\"https://w3id.org/cwl/cwl#WorkflowStepInput\"}],\"doc\":\"The method to use to merge multiple inbound links into a single array.\\nIf not specified, the default method is \\\"merge_nested\\\".\\n\",\"jsonldPredicate\":\"cwl:linkMerge\",\"inherited_from\":\"https://w3id.org/cwl/cwl#Sink\"},{\"name\":\"id\",\"type\":\"string\",\"doc\":\"A unique identifier for this workflow input parameter.\",\"jsonldPredicate\":\"@id\"},{\"name\":\"default\",\"type\":[\"null\",{\"type\":\"enum\",\"name\":\"Any\",\"doc\":\"The **Any** type validates for any non-null value.\\n\",\"symbols\":[\"Any\"],\"docAfter\":\"https://w3id.org/cwl/salad#PrimitiveType\"}],\"doc\":\"The default value for this parameter to use if either there is no\\n`source` field, or the value produced by the `source` is `null`.  The\\ndefault must be applied prior to scattering or evaluating `valueFrom`.\\n\",\"jsonldPredicate\":{\"_id\":\"https://w3id.org/cwl/cwl#default\",\"noLinkCheck\":true}},{\"name\":\"valueFrom\",\"type\":[\"null\",\"string\",{\"type\":\"enum\",\"name\":\"Expression\",\"doc\":\"'Expression' is not a real type.  It indicates that a field must allow\\nruntime parameter references.  If [InlineJavascriptRequirement](#InlineJavascriptRequirement)\\nis declared and supported by the platform, the field must also allow\\nJavascript expressions.\\n\",\"symbols\":[\"ExpressionPlaceholder\"]}],\"doc\":\"To use valueFrom, [StepInputExpressionRequirement](#StepInputExpressionRequirement) must\\nbe specified in the workflow or workflow step requirements.\\n\\nIf `valueFrom` is a constant string value, use this as the value for\\nthis input parameter.\\n\\nIf `valueFrom` is a parameter reference or expression, it must be\\nevaluated to yield the actual value to be assiged to the input field.\\n\\nThe `self` value in the parameter reference or expression must be\\n1. `null` if there is no `source` field\\n2. the value of the parameter(s) specified in the `source` field when this\\nworkflow input parameter **is not** specified in this workflow step's `scatter` field.\\n3. an element of the parameter specified in the `source` field when this workflow input \\nparameter **is** specified in this workflow step's `scatter` field.\\n\\nThe value of `inputs` in the parameter reference or expression must be\\nthe input object to the workflow step after assigning the `source`\\nvalues, applying `default`, and then scattering.  The order of\\nevaluating `valueFrom` among step input parameters is undefined and the\\nresult of evaluating `valueFrom` on a parameter must not be visible to\\nevaluation of `valueFrom` on other parameters.\\n\",\"jsonldPredicate\":\"cwl:valueFrom\"}],\"extends\":\"https://w3id.org/cwl/cwl#Sink\",\"docParent\":\"https://w3id.org/cwl/cwl#WorkflowStep\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<WorkflowStepInput> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<WorkflowStepInput> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<WorkflowStepInput> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<WorkflowStepInput> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<WorkflowStepInput> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this WorkflowStepInput to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a WorkflowStepInput from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a WorkflowStepInput instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static WorkflowStepInput fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Specifies one or more workflow parameters that will provide input to
the underlying step parameter.
 */
  public java.lang.Object source;
  /** The method to use to merge multiple inbound links into a single array.
If not specified, the default method is "merge_nested".
 */
  public io.cwl.avro.LinkMergeMethod linkMerge;
  /** A unique identifier for this workflow input parameter. */
  public java.lang.CharSequence id;
  /** The default value for this parameter to use if either there is no
`source` field, or the value produced by the `source` is `null`.  The
default must be applied prior to scattering or evaluating `valueFrom`.
 */
  public Object default$;
  /** To use valueFrom, [StepInputExpressionRequirement](#StepInputExpressionRequirement) must
be specified in the workflow or workflow step requirements.

If `valueFrom` is a constant string value, use this as the value for
this input parameter.

If `valueFrom` is a parameter reference or expression, it must be
evaluated to yield the actual value to be assiged to the input field.

The `self` value in the parameter reference or expression must be
1. `null` if there is no `source` field
2. the value of the parameter(s) specified in the `source` field when this
workflow input parameter **is not** specified in this workflow step's `scatter` field.
3. an element of the parameter specified in the `source` field when this workflow input 
parameter **is** specified in this workflow step's `scatter` field.

The value of `inputs` in the parameter reference or expression must be
the input object to the workflow step after assigning the `source`
values, applying `default`, and then scattering.  The order of
evaluating `valueFrom` among step input parameters is undefined and the
result of evaluating `valueFrom` on a parameter must not be visible to
evaluation of `valueFrom` on other parameters.
 */
  public java.lang.Object valueFrom;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public WorkflowStepInput() {}

  /**
   * All-args constructor.
   * @param source Specifies one or more workflow parameters that will provide input to
the underlying step parameter.

   * @param linkMerge The method to use to merge multiple inbound links into a single array.
If not specified, the default method is "merge_nested".

   * @param id A unique identifier for this workflow input parameter.
   * @param default$ The default value for this parameter to use if either there is no
`source` field, or the value produced by the `source` is `null`.  The
default must be applied prior to scattering or evaluating `valueFrom`.

   * @param valueFrom To use valueFrom, [StepInputExpressionRequirement](#StepInputExpressionRequirement) must
be specified in the workflow or workflow step requirements.

If `valueFrom` is a constant string value, use this as the value for
this input parameter.

If `valueFrom` is a parameter reference or expression, it must be
evaluated to yield the actual value to be assiged to the input field.

The `self` value in the parameter reference or expression must be
1. `null` if there is no `source` field
2. the value of the parameter(s) specified in the `source` field when this
workflow input parameter **is not** specified in this workflow step's `scatter` field.
3. an element of the parameter specified in the `source` field when this workflow input 
parameter **is** specified in this workflow step's `scatter` field.

The value of `inputs` in the parameter reference or expression must be
the input object to the workflow step after assigning the `source`
values, applying `default`, and then scattering.  The order of
evaluating `valueFrom` among step input parameters is undefined and the
result of evaluating `valueFrom` on a parameter must not be visible to
evaluation of `valueFrom` on other parameters.

   */
  public WorkflowStepInput(java.lang.Object source, io.cwl.avro.LinkMergeMethod linkMerge, java.lang.CharSequence id, Object default$, java.lang.Object valueFrom) {
    this.source = source;
    this.linkMerge = linkMerge;
    this.id = id;
    this.default$ = default$;
    this.valueFrom = valueFrom;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return source;
    case 1: return linkMerge;
    case 2: return id;
    case 3: return default$;
    case 4: return valueFrom;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: source = value$; break;
    case 1: linkMerge = (io.cwl.avro.LinkMergeMethod)value$; break;
    case 2: id = (java.lang.CharSequence)value$; break;
    case 3: default$ = (Object)value$; break;
    case 4: valueFrom = value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'source' field.
   * @return Specifies one or more workflow parameters that will provide input to
the underlying step parameter.

   */
  public java.lang.Object getSource() {
    return source;
  }


  /**
   * Sets the value of the 'source' field.
   * Specifies one or more workflow parameters that will provide input to
the underlying step parameter.

   * @param value the value to set.
   */
  public void setSource(java.lang.Object value) {
    this.source = value;
  }

  /**
   * Gets the value of the 'linkMerge' field.
   * @return The method to use to merge multiple inbound links into a single array.
If not specified, the default method is "merge_nested".

   */
  public io.cwl.avro.LinkMergeMethod getLinkMerge() {
    return linkMerge;
  }


  /**
   * Sets the value of the 'linkMerge' field.
   * The method to use to merge multiple inbound links into a single array.
If not specified, the default method is "merge_nested".

   * @param value the value to set.
   */
  public void setLinkMerge(io.cwl.avro.LinkMergeMethod value) {
    this.linkMerge = value;
  }

  /**
   * Gets the value of the 'id' field.
   * @return A unique identifier for this workflow input parameter.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * A unique identifier for this workflow input parameter.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'default$' field.
   * @return The default value for this parameter to use if either there is no
`source` field, or the value produced by the `source` is `null`.  The
default must be applied prior to scattering or evaluating `valueFrom`.

   */
  public Object getDefault$() {
    return default$;
  }


  /**
   * Sets the value of the 'default$' field.
   * The default value for this parameter to use if either there is no
`source` field, or the value produced by the `source` is `null`.  The
default must be applied prior to scattering or evaluating `valueFrom`.

   * @param value the value to set.
   */
  public void setDefault$(Object value) {
    this.default$ = value;
  }

  /**
   * Gets the value of the 'valueFrom' field.
   * @return To use valueFrom, [StepInputExpressionRequirement](#StepInputExpressionRequirement) must
be specified in the workflow or workflow step requirements.

If `valueFrom` is a constant string value, use this as the value for
this input parameter.

If `valueFrom` is a parameter reference or expression, it must be
evaluated to yield the actual value to be assiged to the input field.

The `self` value in the parameter reference or expression must be
1. `null` if there is no `source` field
2. the value of the parameter(s) specified in the `source` field when this
workflow input parameter **is not** specified in this workflow step's `scatter` field.
3. an element of the parameter specified in the `source` field when this workflow input 
parameter **is** specified in this workflow step's `scatter` field.

The value of `inputs` in the parameter reference or expression must be
the input object to the workflow step after assigning the `source`
values, applying `default`, and then scattering.  The order of
evaluating `valueFrom` among step input parameters is undefined and the
result of evaluating `valueFrom` on a parameter must not be visible to
evaluation of `valueFrom` on other parameters.

   */
  public java.lang.Object getValueFrom() {
    return valueFrom;
  }


  /**
   * Sets the value of the 'valueFrom' field.
   * To use valueFrom, [StepInputExpressionRequirement](#StepInputExpressionRequirement) must
be specified in the workflow or workflow step requirements.

If `valueFrom` is a constant string value, use this as the value for
this input parameter.

If `valueFrom` is a parameter reference or expression, it must be
evaluated to yield the actual value to be assiged to the input field.

The `self` value in the parameter reference or expression must be
1. `null` if there is no `source` field
2. the value of the parameter(s) specified in the `source` field when this
workflow input parameter **is not** specified in this workflow step's `scatter` field.
3. an element of the parameter specified in the `source` field when this workflow input 
parameter **is** specified in this workflow step's `scatter` field.

The value of `inputs` in the parameter reference or expression must be
the input object to the workflow step after assigning the `source`
values, applying `default`, and then scattering.  The order of
evaluating `valueFrom` among step input parameters is undefined and the
result of evaluating `valueFrom` on a parameter must not be visible to
evaluation of `valueFrom` on other parameters.

   * @param value the value to set.
   */
  public void setValueFrom(java.lang.Object value) {
    this.valueFrom = value;
  }

  /**
   * Creates a new WorkflowStepInput RecordBuilder.
   * @return A new WorkflowStepInput RecordBuilder
   */
  public static io.cwl.avro.WorkflowStepInput.Builder newBuilder() {
    return new io.cwl.avro.WorkflowStepInput.Builder();
  }

  /**
   * Creates a new WorkflowStepInput RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new WorkflowStepInput RecordBuilder
   */
  public static io.cwl.avro.WorkflowStepInput.Builder newBuilder(io.cwl.avro.WorkflowStepInput.Builder other) {
    if (other == null) {
      return new io.cwl.avro.WorkflowStepInput.Builder();
    } else {
      return new io.cwl.avro.WorkflowStepInput.Builder(other);
    }
  }

  /**
   * Creates a new WorkflowStepInput RecordBuilder by copying an existing WorkflowStepInput instance.
   * @param other The existing instance to copy.
   * @return A new WorkflowStepInput RecordBuilder
   */
  public static io.cwl.avro.WorkflowStepInput.Builder newBuilder(io.cwl.avro.WorkflowStepInput other) {
    if (other == null) {
      return new io.cwl.avro.WorkflowStepInput.Builder();
    } else {
      return new io.cwl.avro.WorkflowStepInput.Builder(other);
    }
  }

  /**
   * RecordBuilder for WorkflowStepInput instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<WorkflowStepInput>
    implements org.apache.avro.data.RecordBuilder<WorkflowStepInput> {

    /** Specifies one or more workflow parameters that will provide input to
the underlying step parameter.
 */
    private java.lang.Object source;
    /** The method to use to merge multiple inbound links into a single array.
If not specified, the default method is "merge_nested".
 */
    private io.cwl.avro.LinkMergeMethod linkMerge;
    /** A unique identifier for this workflow input parameter. */
    private java.lang.CharSequence id;
    /** The default value for this parameter to use if either there is no
`source` field, or the value produced by the `source` is `null`.  The
default must be applied prior to scattering or evaluating `valueFrom`.
 */
    private Object default$;
    /** To use valueFrom, [StepInputExpressionRequirement](#StepInputExpressionRequirement) must
be specified in the workflow or workflow step requirements.

If `valueFrom` is a constant string value, use this as the value for
this input parameter.

If `valueFrom` is a parameter reference or expression, it must be
evaluated to yield the actual value to be assiged to the input field.

The `self` value in the parameter reference or expression must be
1. `null` if there is no `source` field
2. the value of the parameter(s) specified in the `source` field when this
workflow input parameter **is not** specified in this workflow step's `scatter` field.
3. an element of the parameter specified in the `source` field when this workflow input 
parameter **is** specified in this workflow step's `scatter` field.

The value of `inputs` in the parameter reference or expression must be
the input object to the workflow step after assigning the `source`
values, applying `default`, and then scattering.  The order of
evaluating `valueFrom` among step input parameters is undefined and the
result of evaluating `valueFrom` on a parameter must not be visible to
evaluation of `valueFrom` on other parameters.
 */
    private java.lang.Object valueFrom;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.cwl.avro.WorkflowStepInput.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.source)) {
        this.source = data().deepCopy(fields()[0].schema(), other.source);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.linkMerge)) {
        this.linkMerge = data().deepCopy(fields()[1].schema(), other.linkMerge);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.id)) {
        this.id = data().deepCopy(fields()[2].schema(), other.id);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.default$)) {
        this.default$ = data().deepCopy(fields()[3].schema(), other.default$);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.valueFrom)) {
        this.valueFrom = data().deepCopy(fields()[4].schema(), other.valueFrom);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing WorkflowStepInput instance
     * @param other The existing instance to copy.
     */
    private Builder(io.cwl.avro.WorkflowStepInput other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.source)) {
        this.source = data().deepCopy(fields()[0].schema(), other.source);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.linkMerge)) {
        this.linkMerge = data().deepCopy(fields()[1].schema(), other.linkMerge);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.id)) {
        this.id = data().deepCopy(fields()[2].schema(), other.id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.default$)) {
        this.default$ = data().deepCopy(fields()[3].schema(), other.default$);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.valueFrom)) {
        this.valueFrom = data().deepCopy(fields()[4].schema(), other.valueFrom);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'source' field.
      * Specifies one or more workflow parameters that will provide input to
the underlying step parameter.

      * @return The value.
      */
    public java.lang.Object getSource() {
      return source;
    }


    /**
      * Sets the value of the 'source' field.
      * Specifies one or more workflow parameters that will provide input to
the underlying step parameter.

      * @param value The value of 'source'.
      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepInput.Builder setSource(java.lang.Object value) {
      validate(fields()[0], value);
      this.source = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'source' field has been set.
      * Specifies one or more workflow parameters that will provide input to
the underlying step parameter.

      * @return True if the 'source' field has been set, false otherwise.
      */
    public boolean hasSource() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'source' field.
      * Specifies one or more workflow parameters that will provide input to
the underlying step parameter.

      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepInput.Builder clearSource() {
      source = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'linkMerge' field.
      * The method to use to merge multiple inbound links into a single array.
If not specified, the default method is "merge_nested".

      * @return The value.
      */
    public io.cwl.avro.LinkMergeMethod getLinkMerge() {
      return linkMerge;
    }


    /**
      * Sets the value of the 'linkMerge' field.
      * The method to use to merge multiple inbound links into a single array.
If not specified, the default method is "merge_nested".

      * @param value The value of 'linkMerge'.
      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepInput.Builder setLinkMerge(io.cwl.avro.LinkMergeMethod value) {
      validate(fields()[1], value);
      this.linkMerge = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'linkMerge' field has been set.
      * The method to use to merge multiple inbound links into a single array.
If not specified, the default method is "merge_nested".

      * @return True if the 'linkMerge' field has been set, false otherwise.
      */
    public boolean hasLinkMerge() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'linkMerge' field.
      * The method to use to merge multiple inbound links into a single array.
If not specified, the default method is "merge_nested".

      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepInput.Builder clearLinkMerge() {
      linkMerge = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'id' field.
      * A unique identifier for this workflow input parameter.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * A unique identifier for this workflow input parameter.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepInput.Builder setId(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.id = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * A unique identifier for this workflow input parameter.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'id' field.
      * A unique identifier for this workflow input parameter.
      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepInput.Builder clearId() {
      id = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'default$' field.
      * The default value for this parameter to use if either there is no
`source` field, or the value produced by the `source` is `null`.  The
default must be applied prior to scattering or evaluating `valueFrom`.

      * @return The value.
      */
    public Object getDefault$() {
      return default$;
    }


    /**
      * Sets the value of the 'default$' field.
      * The default value for this parameter to use if either there is no
`source` field, or the value produced by the `source` is `null`.  The
default must be applied prior to scattering or evaluating `valueFrom`.

      * @param value The value of 'default$'.
      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepInput.Builder setDefault$(Object value) {
      validate(fields()[3], value);
      this.default$ = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'default$' field has been set.
      * The default value for this parameter to use if either there is no
`source` field, or the value produced by the `source` is `null`.  The
default must be applied prior to scattering or evaluating `valueFrom`.

      * @return True if the 'default$' field has been set, false otherwise.
      */
    public boolean hasDefault$() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'default$' field.
      * The default value for this parameter to use if either there is no
`source` field, or the value produced by the `source` is `null`.  The
default must be applied prior to scattering or evaluating `valueFrom`.

      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepInput.Builder clearDefault$() {
      default$ = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'valueFrom' field.
      * To use valueFrom, [StepInputExpressionRequirement](#StepInputExpressionRequirement) must
be specified in the workflow or workflow step requirements.

If `valueFrom` is a constant string value, use this as the value for
this input parameter.

If `valueFrom` is a parameter reference or expression, it must be
evaluated to yield the actual value to be assiged to the input field.

The `self` value in the parameter reference or expression must be
1. `null` if there is no `source` field
2. the value of the parameter(s) specified in the `source` field when this
workflow input parameter **is not** specified in this workflow step's `scatter` field.
3. an element of the parameter specified in the `source` field when this workflow input 
parameter **is** specified in this workflow step's `scatter` field.

The value of `inputs` in the parameter reference or expression must be
the input object to the workflow step after assigning the `source`
values, applying `default`, and then scattering.  The order of
evaluating `valueFrom` among step input parameters is undefined and the
result of evaluating `valueFrom` on a parameter must not be visible to
evaluation of `valueFrom` on other parameters.

      * @return The value.
      */
    public java.lang.Object getValueFrom() {
      return valueFrom;
    }


    /**
      * Sets the value of the 'valueFrom' field.
      * To use valueFrom, [StepInputExpressionRequirement](#StepInputExpressionRequirement) must
be specified in the workflow or workflow step requirements.

If `valueFrom` is a constant string value, use this as the value for
this input parameter.

If `valueFrom` is a parameter reference or expression, it must be
evaluated to yield the actual value to be assiged to the input field.

The `self` value in the parameter reference or expression must be
1. `null` if there is no `source` field
2. the value of the parameter(s) specified in the `source` field when this
workflow input parameter **is not** specified in this workflow step's `scatter` field.
3. an element of the parameter specified in the `source` field when this workflow input 
parameter **is** specified in this workflow step's `scatter` field.

The value of `inputs` in the parameter reference or expression must be
the input object to the workflow step after assigning the `source`
values, applying `default`, and then scattering.  The order of
evaluating `valueFrom` among step input parameters is undefined and the
result of evaluating `valueFrom` on a parameter must not be visible to
evaluation of `valueFrom` on other parameters.

      * @param value The value of 'valueFrom'.
      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepInput.Builder setValueFrom(java.lang.Object value) {
      validate(fields()[4], value);
      this.valueFrom = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'valueFrom' field has been set.
      * To use valueFrom, [StepInputExpressionRequirement](#StepInputExpressionRequirement) must
be specified in the workflow or workflow step requirements.

If `valueFrom` is a constant string value, use this as the value for
this input parameter.

If `valueFrom` is a parameter reference or expression, it must be
evaluated to yield the actual value to be assiged to the input field.

The `self` value in the parameter reference or expression must be
1. `null` if there is no `source` field
2. the value of the parameter(s) specified in the `source` field when this
workflow input parameter **is not** specified in this workflow step's `scatter` field.
3. an element of the parameter specified in the `source` field when this workflow input 
parameter **is** specified in this workflow step's `scatter` field.

The value of `inputs` in the parameter reference or expression must be
the input object to the workflow step after assigning the `source`
values, applying `default`, and then scattering.  The order of
evaluating `valueFrom` among step input parameters is undefined and the
result of evaluating `valueFrom` on a parameter must not be visible to
evaluation of `valueFrom` on other parameters.

      * @return True if the 'valueFrom' field has been set, false otherwise.
      */
    public boolean hasValueFrom() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'valueFrom' field.
      * To use valueFrom, [StepInputExpressionRequirement](#StepInputExpressionRequirement) must
be specified in the workflow or workflow step requirements.

If `valueFrom` is a constant string value, use this as the value for
this input parameter.

If `valueFrom` is a parameter reference or expression, it must be
evaluated to yield the actual value to be assiged to the input field.

The `self` value in the parameter reference or expression must be
1. `null` if there is no `source` field
2. the value of the parameter(s) specified in the `source` field when this
workflow input parameter **is not** specified in this workflow step's `scatter` field.
3. an element of the parameter specified in the `source` field when this workflow input 
parameter **is** specified in this workflow step's `scatter` field.

The value of `inputs` in the parameter reference or expression must be
the input object to the workflow step after assigning the `source`
values, applying `default`, and then scattering.  The order of
evaluating `valueFrom` among step input parameters is undefined and the
result of evaluating `valueFrom` on a parameter must not be visible to
evaluation of `valueFrom` on other parameters.

      * @return This builder.
      */
    public io.cwl.avro.WorkflowStepInput.Builder clearValueFrom() {
      valueFrom = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public WorkflowStepInput build() {
      try {
        WorkflowStepInput record = new WorkflowStepInput();
        record.source = fieldSetFlags()[0] ? this.source :  defaultValue(fields()[0]);
        record.linkMerge = fieldSetFlags()[1] ? this.linkMerge : (io.cwl.avro.LinkMergeMethod) defaultValue(fields()[1]);
        record.id = fieldSetFlags()[2] ? this.id : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.default$ = fieldSetFlags()[3] ? this.default$ : (Object) defaultValue(fields()[3]);
        record.valueFrom = fieldSetFlags()[4] ? this.valueFrom :  defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<WorkflowStepInput>
    WRITER$ = (org.apache.avro.io.DatumWriter<WorkflowStepInput>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<WorkflowStepInput>
    READER$ = (org.apache.avro.io.DatumReader<WorkflowStepInput>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










