
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class JsonValidator {
    /**
     * Reads JSON content from a file and returns it as a string.
     * @param filename Relative path to the specific JSON file.
     * @return The content of the JSON file as a string.
     */
    public static String getJsonFromFile(String filename) {
        StringBuilder jsonTextBuilder = new StringBuilder();
        try {
            // Open the JSON file for reading
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            String line;
            // Read each line from the file and append it to the StringBuilder
            while ((line = bufferedReader.readLine()) != null) {
                jsonTextBuilder.append(line).append("\n");
            }
            // Close the BufferedReader
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return the JSON content as a string
        return jsonTextBuilder.toString();
    }

    /**
     * Validates the structure of a JSON object.
     * @param jsonObject The JSON object to validate.
     * @throws RuntimeException if the structure is invalid.
     */
    public static void validateStructure(JSONObject jsonObject) {
        // Extract the PolicyDocument from the JSON object
        JSONObject policyDocument = (JSONObject) jsonObject.get("PolicyDocument");
        // Check if PolicyDocument is missing or empty
        if (policyDocument == null || policyDocument.isEmpty()) {
            throw new RuntimeException("PolicyDocument field is missing or empty");
        }
        // Extract the Statement array from the PolicyDocument
        JSONArray statementArray = (JSONArray) policyDocument.get("Statement");
        // Check if Statement array is missing or empty
        if (statementArray == null || statementArray.isEmpty()) {
            throw new RuntimeException("Statement array is missing or empty");
        }
        // Extract the first Statement from the array
        JSONObject firstStatement = (JSONObject) statementArray.get(0);
        // Extract the Resource field from the first Statement
        String resource = (String) firstStatement.get("Resource");
        // Check if Resource field is missing or empty
        if (resource == null || resource.isEmpty()) {
            throw new RuntimeException("Resource field is missing or empty in the first Statement");
        }
    }

    /**
     * Validates the JSON content of a file.
     * @param filename Relative path to the specific JSON file.
     * @return false if the JSON content is valid, true otherwise.
     */
    public static boolean validateJson(String filename){
        // Read the JSON content from the file
        String strJson = getJsonFromFile(filename);


        try {
            // Parse the JSON content into a JSONObject
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(strJson);

            // Validate the structure of the JSONObject
            validateStructure(jsonObject);
            // read the PolicyDocument field
            JSONObject policyDocument = (JSONObject) jsonObject.get("PolicyDocument");

            // read the Statemant array
            JSONArray statementArray = (JSONArray) policyDocument.get("Statement");

            // read the first element of Statement array
            JSONObject statement = (JSONObject) statementArray.get(0);

            // read the Resource field from Statement object
            String resource = (String) statement.get("Resource");

            // validate if Resources: "*"
            return !resource.equals("*");


        } catch (Exception e) {
            // Print stack trace if an Exception occurs
            e.printStackTrace();
            // Return true if an exception occurs (considered as validation failure)
            return true;
        }

    }
    /**
     * Entry point of the application.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Define the path to the JSON file
        String filepath = "input.json";
        // Create a File object from the filepath
        File inputFile = new File(filepath);
        // Check if the input file exists
        if (!inputFile.exists()) {
            System.err.println("Input JSON file not found");
            return;
        }
        try {
            boolean isValid = validateJson(filepath);
            System.out.println(isValid);
        } catch (Exception e) {
            // Print stack trace if an exception occurs during validation
            e.printStackTrace();
        }


    }
}