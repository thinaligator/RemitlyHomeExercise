## Table of contents
* [General info](#general-info)
* [Content](#content)
* [How to run - INSTRUCTION](#how-to-run---instruction)

## General info
The `JsonValidator` class is responsible for verifying the structure and content of a JSON file to ensure that it meets specific criteria. It checks whether the JSON file contains a valid structure with required fields and verifies if the "Resource" field does contain a single asterisk '*'. The class contains a static method `validateJson(String filename)` that when called returns false if the file contains a single 'asterisk' in Resource field and true if it contains any other content. Method throws a `Runtime Exception` if the file doesn't follow the AWS::IAM::Role Policy structure.

TASK:
Write a method verifying the input JSON data. Input data format is defined as AWS::IAM::Role Policy. Input JSON might be read from a file.
Method shall return logical false if an input JSON Resource field contains a single asterisk and true in any other case. 

## Content
The repository contains a project directory which includes the `JsonValidator` class, the `JsonValidatorTest` test class, and various `JSON` files with contents necessary for conducting tests.

## How to run - INSTRUCTION
* Usage
To use the `JsonValidator` class, follow there steps:

1. Clone the Repository containing the `JsonValidator` class into your local environment.

2. Place your input JSON file (`input.json`) within the project directory, exactly as it is done on this GitHub.

3. Open the `JsonValidator` class in your preffered Java development environment.

4. Execute the `main` method in the `JsonValidator` class. This will load the input JSON file, verify it's structure and content, and print the result to the console.

* Running the Program
You can run the `RemitlyExercise` program by executing the `main` method in the `JsonValidator` class. Ensure that your project setup includes the required libraries (e.g., JSON-simple for JSON processing, make sure the library is correctly configured in your project).

* Instructions
1. Ensure the input JSON file (`input.json`) is located in the project directory, exactly as it is done on this GitHub.

2. Run the `main` method in the `JsonValidator` class.

3. Check the console output to see if the "Resource" field in the JSON file meets the required criteria.

  
