import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

class StudentPersistenceTest {

    private StudentManager manager;
    private Student alice;
    private Student bob;
    private Student charlie;
    private String testFile = "test_students.csv";

    @BeforeEach
    void setUp() {
        manager = new StudentManager();

        alice = new Student(101, "Alice Johnson");
        alice.addGrade(95.0);
        alice.addGrade(88.5);
        alice.addGrade(92.0);

        bob = new Student(102, "Bob Smith");
        bob.addGrade(78.0);
        bob.addGrade(85.5);

        charlie = new Student(103, "Charlie Davis");
        // No grades for Charlie

        manager.addStudent(alice);
        manager.addStudent(bob);
        manager.addStudent(charlie);
    }

    @AfterEach
    void cleanup() {
        // Clean up test file after each test
        try {
            Files.deleteIfExists(Paths.get(testFile));
        } catch (IOException e) {
            // Ignore cleanup errors
        }
    }

    // Test: Save to File
    @Test
    void testSaveToFile() throws IOException {
        StudentPersistence.saveToFile(manager, testFile);

        // Verify file exists
        assertTrue(Files.exists(Paths.get(testFile)));

        // Verify file content
        String content = new String(Files.readAllBytes(Paths.get(testFile)));
        assertTrue(content.contains("101"));
        assertTrue(content.contains("Alice Johnson"));
        assertTrue(content.contains("102"));
        assertTrue(content.contains("Bob Smith"));
        assertTrue(content.contains("103"));
        assertTrue(content.contains("Charlie Davis"));
    }

    @Test
    void testSaveToFileWithGrades() throws IOException {
        StudentPersistence.saveToFile(manager, testFile);

        String content = new String(Files.readAllBytes(Paths.get(testFile)));
        assertTrue(content.contains("95.0"));
        assertTrue(content.contains("88.5"));
        assertTrue(content.contains("92.0"));
        assertTrue(content.contains("78.0"));
        assertTrue(content.contains("85.5"));
    }

    @Test
    void testSaveToFileFormat() throws IOException {
        StudentPersistence.saveToFile(manager, testFile);

        // Read and verify format
        BufferedReader reader = new BufferedReader(new FileReader(testFile));
        String line1 = reader.readLine();
        String line2 = reader.readLine();
        String line3 = reader.readLine();
        reader.close();

        // Line should start with id,name
        assertTrue(line1.startsWith("101,Alice Johnson"));
        assertTrue(line2.startsWith("102,Bob Smith"));
        assertTrue(line3.startsWith("103,Charlie Davis"));

        // Grades should be semicolon-separated
        assertTrue(line1.contains(";"));
        assertTrue(line2.contains(";"));
    }

    @Test
    void testSaveEmptyManager() throws IOException {
        StudentManager emptyManager = new StudentManager();
        StudentPersistence.saveToFile(emptyManager, testFile);

        assertTrue(Files.exists(Paths.get(testFile)));

        String content = new String(Files.readAllBytes(Paths.get(testFile)));
        assertTrue(content.isEmpty() || content.trim().isEmpty());
    }

    // Test: Load from File
    @Test
    void testLoadFromFile() throws IOException {
        // First save the data
        StudentPersistence.saveToFile(manager, testFile);

        // Then load it back
        StudentManager loadedManager = StudentPersistence.loadFromFile(testFile);

        assertNotNull(loadedManager);
        assertEquals(3, loadedManager.getStudents().size());
    }

    @Test
    void testLoadFromFileStudentData() throws IOException {
        StudentPersistence.saveToFile(manager, testFile);
        StudentManager loadedManager = StudentPersistence.loadFromFile(testFile);

        Student loadedAlice = loadedManager.findStudent(101);
        assertNotNull(loadedAlice);
        assertEquals("Alice Johnson", loadedAlice.getName());
        assertEquals(3, loadedAlice.getGrades().size());
        assertEquals(95.0, loadedAlice.getGrades().get(0), 0.01);
        assertEquals(88.5, loadedAlice.getGrades().get(1), 0.01);
        assertEquals(92.0, loadedAlice.getGrades().get(2), 0.01);
    }

    @Test
    void testLoadFromFilePreservesGrades() throws IOException {
        StudentPersistence.saveToFile(manager, testFile);
        StudentManager loadedManager = StudentPersistence.loadFromFile(testFile);

        Student loadedBob = loadedManager.findStudent(102);
        assertNotNull(loadedBob);
        assertEquals(2, loadedBob.getGrades().size());
        assertEquals(78.0, loadedBob.getGrades().get(0), 0.01);
        assertEquals(85.5, loadedBob.getGrades().get(1), 0.01);
    }

    @Test
    void testLoadFromFileStudentWithNoGrades() throws IOException {
        StudentPersistence.saveToFile(manager, testFile);
        StudentManager loadedManager = StudentPersistence.loadFromFile(testFile);

        Student loadedCharlie = loadedManager.findStudent(103);
        assertNotNull(loadedCharlie);
        assertEquals("Charlie Davis", loadedCharlie.getName());
        assertEquals(0, loadedCharlie.getGrades().size());
    }

    @Test
    void testLoadFromNonExistentFile() {
        StudentManager loadedManager = StudentPersistence.loadFromFile("nonexistent.csv");

        // Should return empty manager or null, not crash
        assertTrue(loadedManager == null || loadedManager.getStudents().isEmpty());
    }

    @Test
    void testSaveAndLoadRoundTrip() throws IOException {
        // Save original data
        StudentPersistence.saveToFile(manager, testFile);

        // Load it back
        StudentManager loadedManager = StudentPersistence.loadFromFile(testFile);

        // Verify all data matches
        assertEquals(3, loadedManager.getStudents().size());

        Student loadedAlice = loadedManager.findStudent(101);
        Student loadedBob = loadedManager.findStudent(102);
        Student loadedCharlie = loadedManager.findStudent(103);

        assertNotNull(loadedAlice);
        assertNotNull(loadedBob);
        assertNotNull(loadedCharlie);

        assertEquals("Alice Johnson", loadedAlice.getName());
        assertEquals("Bob Smith", loadedBob.getName());
        assertEquals("Charlie Davis", loadedCharlie.getName());

        assertEquals(3, loadedAlice.getGrades().size());
        assertEquals(2, loadedBob.getGrades().size());
        assertEquals(0, loadedCharlie.getGrades().size());
    }

    @Test
    void testSaveToFileCreatesNewFile() throws IOException {
        Files.deleteIfExists(Paths.get(testFile));
        assertFalse(Files.exists(Paths.get(testFile)));

        StudentPersistence.saveToFile(manager, testFile);

        assertTrue(Files.exists(Paths.get(testFile)));
    }

    @Test
    void testSaveToFileOverwritesExisting() throws IOException {
        // Create initial file with different content
        Files.write(Paths.get(testFile), "old content".getBytes());

        StudentPersistence.saveToFile(manager, testFile);

        String content = new String(Files.readAllBytes(Paths.get(testFile)));
        assertFalse(content.contains("old content"));
        assertTrue(content.contains("Alice Johnson"));
    }

    @Test
    void testLoadFromFileWithDifferentData() throws IOException {
        // Create a CSV file manually
        String csvContent = "201,Test Student,90.0;85.0\n202,Another Student,75.5\n";
        Files.write(Paths.get(testFile), csvContent.getBytes());

        StudentManager loadedManager = StudentPersistence.loadFromFile(testFile);

        assertEquals(2, loadedManager.getStudents().size());

        Student student1 = loadedManager.findStudent(201);
        assertNotNull(student1);
        assertEquals("Test Student", student1.getName());
        assertEquals(2, student1.getGrades().size());

        Student student2 = loadedManager.findStudent(202);
        assertNotNull(student2);
        assertEquals("Another Student", student2.getName());
        assertEquals(1, student2.getGrades().size());
    }

    // Test: File Error Handling
    @Test
    void testSaveToInvalidPath() {
        // Try to save to an invalid path (should handle gracefully)
        String invalidPath = "/invalid/path/that/does/not/exist/file.csv";

        // Should not throw exception, should handle gracefully
        assertDoesNotThrow(() -> StudentPersistence.saveToFile(manager, invalidPath));
    }

    @Test
    void testLoadEmptyFile() throws IOException {
        // Create empty file
        Files.write(Paths.get(testFile), "".getBytes());

        StudentManager loadedManager = StudentPersistence.loadFromFile(testFile);

        assertNotNull(loadedManager);
        assertEquals(0, loadedManager.getStudents().size());
    }
}
