package io.cwl.avro;
/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
@SuppressWarnings("all")
/** 'Expression' is not a real type.  It indicates that a field must allow
runtime parameter references.  If [InlineJavascriptRequirement](#InlineJavascriptRequirement)
is declared and supported by the platform, the field must also allow
Javascript expressions.
 */
@org.apache.avro.specific.AvroGenerated
public enum Expression {
  ExpressionPlaceholder  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Expression\",\"doc\":\"'Expression' is not a real type.  It indicates that a field must allow\\nruntime parameter references.  If [InlineJavascriptRequirement](#InlineJavascriptRequirement)\\nis declared and supported by the platform, the field must also allow\\nJavascript expressions.\\n\",\"symbols\":[\"ExpressionPlaceholder\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
}