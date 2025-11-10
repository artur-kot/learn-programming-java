import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class StudentManagerTest {

    private StudentManager manager;
    private Student student1;
    private Student student2;
    private Student student3;

    @BeforeEach
    void setUp() {
        manager = new StudentManager();
        student1 = new Student(101, "Alice Johnson");
        student2 = new Student(102, "Bob Smith");
        student3 = new Student(103, "Charlie Davis");

        student1.addGrade(95.0);
        student1.addGrade(88.5);
        student1.addGrade(92.0);

        student2.addGrade(78.0);
        student2.addGrade(85.5);
    }

    // Test: Student Class
    @Test
    void testStudentCreation() {
        assertEquals(101, student1.getId());
        assertEquals("Alice Johnson", student1.getName());
        assertNotNull(student1.getGrades());
    }

    @Test
    void testStudentAddGrade() {
        Student student = new Student(104, "Test Student");
        student.addGrade(90.0);
        student.addGrade(85.0);

        assertEquals(2, student.getGrades().size());
        assertEquals(90.0, student.getGrades().get(0));
        assertEquals(85.0, student.getGrades().get(1));
    }

    @Test
    void testStudentToString() {
        String result = student1.toString();
        assertTrue(result.contains("101"));
        assertTrue(result.contains("Alice Johnson"));
        assertTrue(result.contains("95.0"));
    }

    @Test
    void testStudentWithNoGrades() {
        Student student = new Student(105, "No Grades");
        assertEquals(0, student.getGrades().size());
    }

    // Test: Adding Students
    @Test
    void testAddSingleStudent() {
        manager.addStudent(student1);
        assertEquals(1, manager.getStudents().size());
        assertEquals(student1, manager.getStudents().get(0));
    }

    @Test
    void testAddMultipleStudents() {
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        assertEquals(3, manager.getStudents().size());
    }

    @Test
    void testAddStudentMaintainsOrder() {
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        assertEquals(student1, manager.getStudents().get(0));
        assertEquals(student2, manager.getStudents().get(1));
        assertEquals(student3, manager.getStudents().get(2));
    }

    // Test: Finding Students
    @Test
    void testFindExistingStudent() {
        manager.addStudent(student1);
        manager.addStudent(student2);

        Student found = manager.findStudent(101);
        assertNotNull(found);
        assertEquals("Alice Johnson", found.getName());
    }

    @Test
    void testFindNonExistingStudent() {
        manager.addStudent(student1);
        manager.addStudent(student2);

        Student found = manager.findStudent(999);
        assertNull(found);
    }

    @Test
    void testFindInEmptyManager() {
        Student found = manager.findStudent(101);
        assertNull(found);
    }

    @Test
    void testFindStudentById() {
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        assertEquals(student2, manager.findStudent(102));
        assertEquals(student3, manager.findStudent(103));
    }

    // Test: Removing Students
    @Test
    void testRemoveExistingStudent() {
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        boolean removed = manager.removeStudent(102);

        assertTrue(removed);
        assertEquals(2, manager.getStudents().size());
        assertNull(manager.findStudent(102));
    }

    @Test
    void testRemoveNonExistingStudent() {
        manager.addStudent(student1);

        boolean removed = manager.removeStudent(999);

        assertFalse(removed);
        assertEquals(1, manager.getStudents().size());
    }

    @Test
    void testRemoveFromEmptyManager() {
        boolean removed = manager.removeStudent(101);
        assertFalse(removed);
    }

    @Test
    void testRemoveFirstStudent() {
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        manager.removeStudent(101);

        assertEquals(2, manager.getStudents().size());
        assertEquals(student2, manager.getStudents().get(0));
    }

    @Test
    void testRemoveLastStudent() {
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        manager.removeStudent(103);

        assertEquals(2, manager.getStudents().size());
        assertEquals(student2, manager.getStudents().get(1));
    }

    @Test
    void testRemoveAllStudents() {
        manager.addStudent(student1);
        manager.addStudent(student2);

        manager.removeStudent(101);
        manager.removeStudent(102);

        assertEquals(0, manager.getStudents().size());
    }

    // Test: Listing Students
    @Test
    void testListEmptyManager() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        manager.listAllStudents();
        String output = outputStream.toString().trim();

        assertEquals("No students in the system", output);
        System.setOut(System.out);
    }

    @Test
    void testListSingleStudent() {
        manager.addStudent(student1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        manager.listAllStudents();
        String output = outputStream.toString().trim();

        assertTrue(output.contains("1."));
        assertTrue(output.contains("Alice Johnson"));
        assertTrue(output.contains("101"));

        System.setOut(System.out);
    }

    @Test
    void testListMultipleStudents() {
        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        manager.listAllStudents();
        String output = outputStream.toString().trim();

        String[] lines = output.split(System.lineSeparator());
        assertEquals(3, lines.length);
        assertTrue(lines[0].startsWith("1."));
        assertTrue(lines[1].startsWith("2."));
        assertTrue(lines[2].startsWith("3."));

        System.setOut(System.out);
    }

    @Test
    void testListDisplaysGrades() {
        manager.addStudent(student1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        manager.listAllStudents();
        String output = outputStream.toString().trim();

        assertTrue(output.contains("95.0"));
        assertTrue(output.contains("88.5"));

        System.setOut(System.out);
    }
}
