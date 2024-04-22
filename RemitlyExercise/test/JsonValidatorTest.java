import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * This class contains test cases for the JsonValidator class.
 * It uses JUnit4 testing framework to test various scenarios of the JsonValidator class.
 */
public class JsonValidatorTest {

    /**
     * Test case to validate JSON content containing an asterisk in the Resource field.
     * Expects the validateJson method to return false.
     */
    @Test
    public void testValidateJson_ContainingAsterisk_ReturnsFalse() {
        String filepath = "input.json";
        boolean isValid = JsonValidator.validateJson(filepath);
        // Assert that the result is false as the Resource field does contain an asterisk
        assertFalse(isValid);
    }

    /**
     * Test case to validate JSON content without containing an asterisk in the Resource field.
     * Expects the validateJson method to return true.
     */
    @Test
    public void testValidateJson_NotContainingAsterisk_ReturnTrue(){
        String filepath = "no_asterisk.json";
        boolean isValid = JsonValidator.validateJson(filepath);

        assertTrue(isValid);
    }

    /**
     * Test case to validate JSON structure with missing PolicyDocument field.
     * Expects a RuntimeException to be thrown with the message "PolicyDocument field is missing or empty".
     */
    @Test
    public void testValidateStructure_MissingPolicyDocument() {
        // Load the JSON file
        JSONObject jsonObject = loadJsonFromFile("no_policy.json");

        // Test if the RuntimeException is thrown with correct message
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            JsonValidator.validateStructure(jsonObject);
        });
        assertEquals("PolicyDocument field is missing or empty", exception.getMessage());
    }



    /**
     * Test case to validate JSON structure with missing Statement array.
     * Expects a RuntimeException to be thrown with the message "Statement array is missing or empty".
     */
    @Test
    public void testValidateStructure_MissingStatementArray() {
        // Load the JSON file
        JSONObject jsonObject = loadJsonFromFile("no_statement.json");

        // Test if the RuntimeException is thrown with correct message
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            JsonValidator.validateStructure(jsonObject);
        });
        assertEquals("Statement array is missing or empty", exception.getMessage());
    }

    /**
     * Test case to validate JSON structure with missing Resource field in the first Statement.
     * Expects a RuntimeException to be thrown with the message "Resource field is missing or empty in the first Statement".
     */
    @Test
    public void testValidateStructure_MissingResource() {
        // Load the JSON file
        JSONObject jsonObject = loadJsonFromFile("no_resource.json");

        // Test if the RuntimeException is thrown with correct message
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            JsonValidator.validateStructure(jsonObject);
        });
        assertEquals("Resource field is missing or empty in the first Statement", exception.getMessage());
    }



    /**
     * Helper method to load JSON content from a file and parse it into a JSONObject.
     *
     * @param filename relative path to the specific JSON file.
     * @return the JSONObject parsed from the JSON file
     * @throws RuntimeException if an error occurs while loading or parsing the JSON file
     */
    private JSONObject loadJsonFromFile(String filename) {
        try {
            File inputFile = new File(filename);
            FileReader reader = new FileReader(inputFile);
            JSONParser parser = new JSONParser();
            return (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            throw new RuntimeException("Error loading JSON file: " + filename, e);
        }
    }
}


