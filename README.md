[![Build Status](https://travis-ci.org/common-workflow-language/cwlavro.svg)](https://travis-ci.org/common-workflow-language/cwlavro)
[![Dependency Status](https://dependencyci.com/github/common-workflow-language/cwlavro/badge)](https://dependencyci.com/github/common-workflow-language/cwlavro)

CWL Avro Project 
================

This project demonstrates how to take advantage of the Avro schema for CWL in order to
auto-generate classes to work in other languages. Due to familiarity, we're starting with
Java here, but other languages are encouraged.  

All comments and recommendations are welcome.

Releases starting with v1.0 support CWL v1.0 and require CWLtool as a dependency
Releases starting with v2.0 will support CWL v1.0 and require Rabix bunny or cwltool as a dependency

This depends on cwltool to parse CWL documents into avro (before this takes avro documents and transforms them 
into Java objects). 

Install it with the following commands (may differ depending on your distribution of Linux). 

    pip install --user setuptools==28.8.0
    pip install --user cwl-runner cwltool==1.0.20170217172322 schema-salad==2.2.20170222151604 avro==1.8.1

# CWL Java SDK

This demonstrates how to auto-generate Java classes from the CWL specification.
Dependencies are the schema-salad project (used to convert the CWL specification into a standard Avro schema)
and the cwltool project (used to convert yml-based CWL documents into json). 

## Instantiate CWL documents as Java objects

Run the following command in an environment with Maven 3 and Java 8 to demonstrate how to instantiate and work with CWL documents as Java objects. This includes tests that have a dependency on cwltool.

    mvn clean install

To generate Javadoc 

    mvn javadoc:javadoc
    
The javadoc is pre-generated and currently lives at https://common-workflow-language.github.io/cwlavro/

## Generate Avro Schema

The process for generating the Java classes in the first place from the CWL specification involves the following considerations. 

### Background:

The CWL specification is defined in something similar to but not entirely like Avro
Use the schema salad project to convert to an avro-ish schema document
Generate the Java classes for the schema
We cannot use these classes directly since CWL documents are not json or avro binaries, use cwl-tool to convert to json and then gson to convert from json due to some incompatibilities between CWL avro and normal avro.

### To regenerate:

1. Get schema salad from the common-workflow-language organization and run `python -mschema_salad --print-avro ~/common-workflow-language/v1.0/CommonWorkflowLanguage.yml > cwl.avsc`
2. Edit the allowed symbols for CWL versions. The draft3 specification generates symbols like "draft-3.dev1" which the avro parser will reject with the error "Exception in thread \"main\" org.apache.avro.SchemaParseException: Illegal character in: draft-3.dev1". You can safety delete all the symbols which are designated "draft" versions. 
3. Get the avro tools jar and CWL avsc and call `java -jar avro-tools-1.8.1.jar compile schema cwl.avsc cwl`
4. Change the `Any` `enum` type Object and delete the class. The odd creation of Any as an enum otherwise block attempts to instantiate these values.
5. Copy them to the appropriate directory in dockstore-client (you will need to refactor to insert package names)

Since this is kinda involved, a travis-CI build is provided which demos the process at https://travis-ci.org/common-workflow-language/cwlavro

## Individual Contributors

* Denis Yuen <denis.yuen@oicr.on.ca>
* Peter Amstutz <peter.amstutz@curoverse.com>

