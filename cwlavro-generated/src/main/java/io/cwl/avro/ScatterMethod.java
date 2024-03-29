/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.cwl.avro;
/** The scatter method, as described in [workflow step scatter](#WorkflowStep). */
@org.apache.avro.specific.AvroGenerated
public enum ScatterMethod implements org.apache.avro.generic.GenericEnumSymbol<ScatterMethod> {
  dotproduct, nested_crossproduct, flat_crossproduct  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"ScatterMethod\",\"namespace\":\"io.cwl.avro\",\"doc\":\"The scatter method, as described in [workflow step scatter](#WorkflowStep).\",\"symbols\":[\"dotproduct\",\"nested_crossproduct\",\"flat_crossproduct\"],\"docParent\":\"https://w3id.org/cwl/cwl#WorkflowStep\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
