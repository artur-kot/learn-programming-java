import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;

@DisplayName("File Operations Basics Tests")
public class FileBasicsTest {

    private static final String TEST_FILE = "test_file.txt";

    @AfterEach
    public void cleanup() {
        // Clean up test files after each test
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    @DisplayName("writeToFile() creates file with content")
    public void testWriteToFile() {
        FileBasics.writeToFile(TEST_FILE, "Test content");

        assertTrue(new File(TEST_FILE).exists(), "File should be created");
        String content = FileBasics.readFromFile(TEST_FILE);
        assertEquals("Test content", content, "File should contain the written content");
    }

    @Test
    @DisplayName("writeToFile() overwrites existing content")
    public void testWriteOverwrites() {
        FileBasics.writeToFile(TEST_FILE, "First content");
        FileBasics.writeToFile(TEST_FILE, "Second content");

        String content = FileBasics.readFromFile(TEST_FILE);
        assertEquals("Second content", content, "File should contain only the new content");
    }

    @Test
    @DisplayName("readFromFile() returns content correctly")
    public void testReadFromFile() {
        FileBasics.writeToFile(TEST_FILE, "Hello, World!");

        String content = FileBasics.readFromFile(TEST_FILE);
        assertEquals("Hello, World!", content);
    }

    @Test
    @DisplayName("readFromFile() handles multi-line content")
    public void testReadMultiLine() {
        String multiLine = "Line 1\nLine 2\nLine 3";
        FileBasics.writeToFile(TEST_FILE, multiLine);

        String content = FileBasics.readFromFile(TEST_FILE);
        assertTrue(content.contains("Line 1"), "Should contain Line 1");
        assertTrue(content.contains("Line 2"), "Should contain Line 2");
        assertTrue(content.contains("Line 3"), "Should contain Line 3");
    }

    @Test
    @DisplayName("readFromFile() returns empty string for non-existent file")
    public void testReadNonExistentFile() {
        String content = FileBasics.readFromFile("nonexistent_file.txt");
        assertEquals("", content, "Should return empty string for non-existent file");
    }

    @Test
    @DisplayName("appendToFile() adds content to existing file")
    public void testAppendToFile() {
        FileBasics.writeToFile(TEST_FILE, "First line");
        FileBasics.appendToFile(TEST_FILE, "\nSecond line");

        String content = FileBasics.readFromFile(TEST_FILE);
        assertTrue(content.contains("First line"), "Should contain first line");
        assertTrue(content.contains("Second line"), "Should contain second line");
    }

    @Test
    @DisplayName("appendToFile() preserves existing content")
    public void testAppendPreservesContent() {
        FileBasics.writeToFile(TEST_FILE, "Original");
        FileBasics.appendToFile(TEST_FILE, " Added");

        String content = FileBasics.readFromFile(TEST_FILE);
        assertTrue(content.startsWith("Original"), "Should start with original content");
        assertTrue(content.contains("Added"), "Should contain appended content");
    }

    @Test
    @DisplayName("fileExists() returns true for existing file")
    public void testFileExistsTrue() {
        FileBasics.writeToFile(TEST_FILE, "Content");

        assertTrue(FileBasics.fileExists(TEST_FILE), "Should return true for existing file");
    }

    @Test
    @DisplayName("fileExists() returns false for non-existent file")
    public void testFileExistsFalse() {
        assertFalse(FileBasics.fileExists("nonexistent_file.txt"),
                   "Should return false for non-existent file");
    }

    @Test
    @DisplayName("Multiple operations work together correctly")
    public void testMultipleOperations() {
        // Write initial content
        FileBasics.writeToFile(TEST_FILE, "Start");
        assertTrue(FileBasics.fileExists(TEST_FILE));

        // Append more content
        FileBasics.appendToFile(TEST_FILE, "\nMiddle");
        FileBasics.appendToFile(TEST_FILE, "\nEnd");

        // Read everything back
        String content = FileBasics.readFromFile(TEST_FILE);
        assertTrue(content.contains("Start"));
        assertTrue(content.contains("Middle"));
        assertTrue(content.contains("End"));
    }
}
