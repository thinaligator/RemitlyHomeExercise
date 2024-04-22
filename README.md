## Table of contents
* [General info](#general-info)
* [Content](#content)
* [How to run - INSTRUCTION](#how-to-run---instruction)

## General info
The JsonValidator class is responsible for verifying the structure and content of a JSON file to ensure that it meets specific criteria. It checks whether the JSON file contains a valid structure with required fields and verifies if the "Resource" field does contain a single asterisk '*'. The class contains a static method validateJson(String filename) that when called returns false if the file contains a single 'asterisk' in Resource field and true if it contains any other content. Method throws a Runtime Exception if the file doesn't follow the AWS::IAM::Role Policy structure.

TASK:
Write a method verifying the input JSON data. Input data format is defined as AWS::IAM::Role Policy. Input JSON might be read from a file.
Method shall return logical false if an input JSON Resource field contains a single asterisk and true in any other case. 

## Content
The repository contains a project directory which includes the `JsonValidator class`, the `JsonValidatorTest test class`, and various `JSON` files with contents necessary for conducting tests.

## How to run - INSTRUCTION
  
