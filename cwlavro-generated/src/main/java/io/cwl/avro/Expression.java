/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.cwl.avro;
/** 'Expression' is not a real type.  It indicates that a field must allow
runtime parameter references.  If [InlineJavascriptRequirement](#InlineJavascriptRequirement)
is declared and supported by the platform, the field must also allow
Javascript expressions.
 */
@org.apache.avro.specific.AvroGenerated
public enum Expression implements org.apache.avro.generic.GenericEnumSymbol<Expression> {
  ExpressionPlaceholder  ;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"enum\",\"name\":\"Expression\",\"namespace\":\"io.cwl.avro\",\"doc\":\"'Expression' is not a real type.  It indicates that a field must allow\\nruntime parameter references.  If [InlineJavascriptRequirement](#InlineJavascriptRequirement)\\nis declared and supported by the platform, the field must also allow\\nJavascript expressions.\\n\",\"symbols\":[\"ExpressionPlaceholder\"]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
}
