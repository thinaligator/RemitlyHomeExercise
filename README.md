## Table of contents
* [General info](#general-info)
* [Content](#content)
* [How to run - INSTRUCTION](#how-to-run---instruction)

## General info
The JsonResourceChecker class is responsible for verifying the structure and content of a JSON file to ensure that it meets specific criteria. It checks whether the JSON file contains a valid structure with required fields and verifies that the "Resource" field does not contain a single asterisk '*'. The class contains a static method verifyInputJson(File inputFile) that when called returns false if the File contains a single 'asterisk' in Resource field and true if it contains any other content. Method throws a Runtime Exception if the file doesn't follow the AWS::IAM::Role Policy structure.

TASK:
Write a method verifying the input JSON data. Input data format is defined as AWS::IAM::Role Policy. Input JSON might be read from a file.

## Content

## How to run - INSTRUCTION
  
