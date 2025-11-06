
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TextAnalyzerTest {

    // Helper method to create temp test files
    private File createTempFile(String content) throws IOException {
        File file = File.createTempFile("test_", ".txt");
        file.deleteOnExit();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
        return file;
    }

    @Test
    public void testCountWordsSimple() throws IOException {
        File file = createTempFile("Hello world");
        int result = TextAnalyzer.countWords(file.getAbsolutePath());
        assertEquals(2, result, "Should count 2 words");
    }

    @Test
    public void testCountWordsMultiple() throws IOException {
        File file = createTempFile("The quick brown fox jumps over the lazy dog");
        int result = TextAnalyzer.countWords(file.getAbsolutePath());
        assertEquals(9, result, "Should count 9 words");
    }

    @Test
    public void testCountWordsEmpty() throws IOException {
        File file = createTempFile("");
        int result = TextAnalyzer.countWords(file.getAbsolutePath());
        assertEquals(0, result, "Should count 0 words in empty file");
    }

    @Test
    public void testCountLinesSimple() throws IOException {
        File file = createTempFile("Line 1\nLine 2\nLine 3");
        int result = TextAnalyzer.countLines(file.getAbsolutePath());
        assertEquals(3, result, "Should count 3 lines");
    }

    @Test
    public void testCountLinesSingleLine() throws IOException {
        File file = createTempFile("Just one line");
        int result = TextAnalyzer.countLines(file.getAbsolutePath());
        assertEquals(1, result, "Should count 1 line");
    }

    @Test
    public void testCountSentencesSimple() throws IOException {
        File file = createTempFile("Hello world. How are you?");
        int result = TextAnalyzer.countSentences(file.getAbsolutePath());
        assertEquals(2, result, "Should count 2 sentences");
    }

    @Test
    public void testCountSentencesMultiple() throws IOException {
        File file = createTempFile("First. Second! Third? Fourth.");
        int result = TextAnalyzer.countSentences(file.getAbsolutePath());
        assertEquals(4, result, "Should count 4 sentences");
    }

    @Test
    public void testCountCharactersSimple() throws IOException {
        File file = createTempFile("abc");
        int result = TextAnalyzer.countCharacters(file.getAbsolutePath());
        assertEquals(3, result, "Should count 3 characters (excluding whitespace)");
    }

    @Test
    public void testCountCharactersIgnoresWhitespace() throws IOException {
        File file = createTempFile("a b c");
        int result = TextAnalyzer.countCharacters(file.getAbsolutePath());
        assertEquals(3, result, "Should count only non-whitespace characters");
    }

    @Test
    public void testIsValidFileTrue() {
        // Use a known existing file
        File file = new File("pom.xml");
        if (file.exists()) {
            assertTrue(TextAnalyzer.isValidFile("pom.xml"), "pom.xml should be valid");
        }
    }

    @Test
    public void testIsValidFileFalse() {
        assertFalse(TextAnalyzer.isValidFile("/nonexistent/path/file.txt"),
                "Non-existent file should be invalid");
    }

    @Test
    public void testReadFileContent() throws IOException {
        File file = createTempFile("Test content");
        String content = TextAnalyzer.readFile(file.getAbsolutePath());
        assertTrue(content.contains("Test content"), "Should read file content");
    }

    @Test
    public void testAnalyzeFileIntegration() throws IOException {
        File file = createTempFile("Hello world. This is a test!");
        // This method should not throw an exception
        TextAnalyzer.analyzeFile(file.getAbsolutePath());
        assertTrue(true, "analyzeFile() should complete without errors");
    }
}
