import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Exception Basics - Learn to handle errors gracefully
 *
 * Your task: Implement methods that safely handle various types of exceptions.
 *
 * Concepts you'll practice:
 * - Try-catch blocks
 * - Multiple catch blocks
 * - Finally blocks
 * - Try-with-resources
 * - Common exception types (ArithmeticException, NumberFormatException, IOException)
 */
public class ExceptionBasics {

    // TODO: Implement safeDivide method
    // Method signature: public static int safeDivide(int a, int b)
    // This method should:
    // 1. Try to divide a by b
    // 2. Catch ArithmeticException if b is zero
    // 3. Print "Error: Cannot divide by zero" if exception occurs
    // 4. Return the result on success, or 0 on error

    public static int safeDivide(int a, int b) {
        // TODO: Implement try-catch block for division
        return 0;
    }

    // TODO: Implement parseIntSafely method
    // Method signature: public static int parseIntSafely(String str)
    // This method should:
    // 1. Try to parse the string as an integer using Integer.parseInt()
    // 2. Catch NumberFormatException if parsing fails
    // 3. Print "Error: Invalid number format - " + str if exception occurs
    // 4. Return the parsed integer on success, or 0 on error

    public static int parseIntSafely(String str) {
        // TODO: Implement try-catch block for parsing
        return 0;
    }

    // TODO: Implement readFileContent method
    // Method signature: public static String readFileContent(String filename)
    // This method should:
    // 1. Use try-with-resources to open a BufferedReader
    // 2. Read all lines from the file and combine them
    // 3. Catch IOException if file doesn't exist or can't be read
    // 4. Return the file contents on success
    // 5. Return "Error: File not found - " + filename if FileNotFoundException
    // 6. Return "Error: Could not read file - " + filename for other IOExceptions

    public static String readFileContent(String filename) {
        // TODO: Implement try-with-resources and multiple catch blocks
        return "";
    }

    // TODO: Implement demonstrateFinally method
    // Method signature: public static void demonstrateFinally()
    // This method should demonstrate that finally blocks always execute
    // Create three scenarios:
    // 1. Scenario with no exception
    // 2. Scenario with caught exception
    // 3. Scenario with return statement in try block
    // Each should have a finally block that prints a message
    // Print messages to show the execution flow

    public static void demonstrateFinally() {
        System.out.println("=== Finally Block Demonstration ===");

        // Scenario 1: No exception
        System.out.println("\nScenario 1: No exception");
        try {
            System.out.println("Try block: executing normally");
            // No exception thrown
        } catch (Exception e) {
            System.out.println("Catch block: not executed");
        } finally {
            // TODO: Add finally block that prints "Finally block: always executes (no exception)"
        }

        // Scenario 2: Exception caught
        System.out.println("\nScenario 2: Exception caught");
        try {
            System.out.println("Try block: about to throw exception");
            // TODO: Throw an exception (e.g., divide by zero or throw new RuntimeException())
        } catch (Exception e) {
            System.out.println("Catch block: exception caught");
        } finally {
            // TODO: Add finally block that prints "Finally block: always executes (exception caught)"
        }

        // Scenario 3: Return in try block
        System.out.println("\nScenario 3: Return in try block");
        demonstrateFinallyWithReturn();
    }

    // Helper method to demonstrate finally with return
    private static int demonstrateFinallyWithReturn() {
        try {
            System.out.println("Try block: returning value");
            return 42;
        } finally {
            // TODO: Add finally block that prints "Finally block: executes even with return"
        }
    }

    public static void main(String[] args) {
        // TODO: Test all your methods here
        // Call safeDivide with valid and invalid inputs
        // Call parseIntSafely with valid and invalid strings
        // Call readFileContent with existing and non-existing files
        // Call demonstrateFinally to see finally block behavior

        System.out.println("=== Testing Safe Division ===");
        // Test safeDivide

        System.out.println("\n=== Testing Safe Parsing ===");
        // Test parseIntSafely

        System.out.println("\n=== Testing File Reading ===");
        // Test readFileContent

        System.out.println("\n=== Testing Finally Blocks ===");
        // Call demonstrateFinally
    }
}
