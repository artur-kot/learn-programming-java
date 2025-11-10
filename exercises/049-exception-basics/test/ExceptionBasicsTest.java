import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;

@DisplayName("Exception Basics Tests")
public class ExceptionBasicsTest {

    @Test
    @DisplayName("safeDivide() returns correct result for valid division")
    public void testSafeDivideValid() {
        assertEquals(5, ExceptionBasics.safeDivide(10, 2));
        assertEquals(3, ExceptionBasics.safeDivide(15, 5));
        assertEquals(-4, ExceptionBasics.safeDivide(20, -5));
        assertEquals(0, ExceptionBasics.safeDivide(0, 5));
    }

    @Test
    @DisplayName("safeDivide() handles division by zero")
    public void testSafeDivideDivisionByZero() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        int result = ExceptionBasics.safeDivide(10, 0);

        assertEquals(0, result);
        assertTrue(output.toString().contains("Cannot divide by zero") ||
                   output.toString().contains("Error"));

        System.setOut(System.out);
    }

    @Test
    @DisplayName("parseIntSafely() returns correct value for valid input")
    public void testParseIntSafelyValid() {
        assertEquals(42, ExceptionBasics.parseIntSafely("42"));
        assertEquals(-15, ExceptionBasics.parseIntSafely("-15"));
        assertEquals(0, ExceptionBasics.parseIntSafely("0"));
        assertEquals(999, ExceptionBasics.parseIntSafely("999"));
    }

    @Test
    @DisplayName("parseIntSafely() handles invalid number format")
    public void testParseIntSafelyInvalid() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        int result1 = ExceptionBasics.parseIntSafely("abc");
        int result2 = ExceptionBasics.parseIntSafely("12.5");
        int result3 = ExceptionBasics.parseIntSafely("");

        assertEquals(0, result1);
        assertEquals(0, result2);
        assertEquals(0, result3);

        String outputStr = output.toString();
        assertTrue(outputStr.contains("Invalid number format") ||
                   outputStr.contains("Error"));

        System.setOut(System.out);
    }

    @Test
    @DisplayName("readFileContent() reads existing file correctly")
    public void testReadFileContentValid(@TempDir Path tempDir) throws Exception {
        File testFile = tempDir.resolve("test.txt").toFile();
        try (FileWriter writer = new FileWriter(testFile)) {
            writer.write("Hello World\n");
            writer.write("Java Exception Handling");
        }

        String content = ExceptionBasics.readFileContent(testFile.getAbsolutePath());

        assertTrue(content.contains("Hello World"));
        assertTrue(content.contains("Java Exception Handling"));
    }

    @Test
    @DisplayName("readFileContent() handles non-existent file")
    public void testReadFileContentNonExistent() {
        String content = ExceptionBasics.readFileContent("non_existent_file_12345.txt");

        assertTrue(content.contains("Error") || content.contains("not found"));
    }

    @Test
    @DisplayName("demonstrateFinally() executes finally blocks")
    public void testDemonstrateFinally() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ExceptionBasics.demonstrateFinally();

        String outputStr = output.toString();

        // Check that finally block messages are present
        assertTrue(outputStr.contains("Finally") || outputStr.contains("finally"));

        // Check that all scenarios are demonstrated
        assertTrue(outputStr.contains("Scenario 1") || outputStr.contains("No exception"));
        assertTrue(outputStr.contains("Scenario 2") || outputStr.contains("Exception caught"));
        assertTrue(outputStr.contains("Scenario 3") || outputStr.contains("Return"));

        System.setOut(System.out);
    }

    @Test
    @DisplayName("safeDivide() handles negative numbers")
    public void testSafeDivideNegative() {
        assertEquals(-2, ExceptionBasics.safeDivide(-10, 5));
        assertEquals(2, ExceptionBasics.safeDivide(-10, -5));
    }

    @Test
    @DisplayName("parseIntSafely() handles whitespace")
    public void testParseIntSafelyWhitespace() {
        // Depending on implementation, trimming might be included
        int result = ExceptionBasics.parseIntSafely("  ");
        assertEquals(0, result);
    }

    @Test
    @DisplayName("readFileContent() handles empty file")
    public void testReadFileContentEmpty(@TempDir Path tempDir) throws Exception {
        File testFile = tempDir.resolve("empty.txt").toFile();
        testFile.createNewFile();

        String content = ExceptionBasics.readFileContent(testFile.getAbsolutePath());

        // Empty file should return empty string or blank content
        assertNotNull(content);
    }
}
