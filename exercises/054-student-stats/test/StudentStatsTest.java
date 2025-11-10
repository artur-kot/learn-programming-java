import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class StudentStatsTest {

    private StudentManager manager;
    private Student alice;
    private Student bob;
    private Student charlie;
    private Student diana;
    private Student eva;

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
        charlie.addGrade(88.0);
        charlie.addGrade(91.0);
        charlie.addGrade(87.5);

        diana = new Student(104, "Diana Prince");
        diana.addGrade(72.0);
        diana.addGrade(68.5);
        diana.addGrade(75.0);

        eva = new Student(105, "Eva Williams");
        // No grades for Eva

        manager.addStudent(alice);
        manager.addStudent(bob);
        manager.addStudent(charlie);
        manager.addStudent(diana);
        manager.addStudent(eva);
    }

    // Test: Average Grade Calculation
    @Test
    void testAverageGradeWithMultipleGrades() {
        double average = StudentStats.getAverageGrade(alice);
        assertEquals(91.83, average, 0.01);
    }

    @Test
    void testAverageGradeWithTwoGrades() {
        double average = StudentStats.getAverageGrade(bob);
        assertEquals(81.75, average, 0.01);
    }

    @Test
    void testAverageGradeWithNoGrades() {
        double average = StudentStats.getAverageGrade(eva);
        assertEquals(0.0, average, 0.01);
    }

    @Test
    void testAverageGradeWithSingleGrade() {
        Student student = new Student(106, "Test");
        student.addGrade(90.0);
        double average = StudentStats.getAverageGrade(student);
        assertEquals(90.0, average, 0.01);
    }

    @Test
    void testAverageGradeExactCalculation() {
        double average = StudentStats.getAverageGrade(charlie);
        assertEquals(88.83, average, 0.01);
    }

    // Test: Top Students
    @Test
    void testTopThreeStudents() {
        ArrayList<Student> topStudents = StudentStats.getTopStudents(manager, 3);

        assertEquals(3, topStudents.size());
        assertEquals("Alice Johnson", topStudents.get(0).getName());
        assertEquals("Charlie Davis", topStudents.get(1).getName());
        assertEquals("Bob Smith", topStudents.get(2).getName());
    }

    @Test
    void testTopOneStudent() {
        ArrayList<Student> topStudents = StudentStats.getTopStudents(manager, 1);

        assertEquals(1, topStudents.size());
        assertEquals("Alice Johnson", topStudents.get(0).getName());
    }

    @Test
    void testTopStudentsMoreThanAvailable() {
        ArrayList<Student> topStudents = StudentStats.getTopStudents(manager, 10);

        assertEquals(5, topStudents.size());
        assertEquals("Alice Johnson", topStudents.get(0).getName());
    }

    @Test
    void testTopStudentsOrder() {
        ArrayList<Student> topStudents = StudentStats.getTopStudents(manager, 5);

        assertTrue(StudentStats.getAverageGrade(topStudents.get(0)) >=
                   StudentStats.getAverageGrade(topStudents.get(1)));
        assertTrue(StudentStats.getAverageGrade(topStudents.get(1)) >=
                   StudentStats.getAverageGrade(topStudents.get(2)));
        assertTrue(StudentStats.getAverageGrade(topStudents.get(2)) >=
                   StudentStats.getAverageGrade(topStudents.get(3)));
    }

    @Test
    void testTopStudentsWithEmptyManager() {
        StudentManager emptyManager = new StudentManager();
        ArrayList<Student> topStudents = StudentStats.getTopStudents(emptyManager, 3);

        assertNotNull(topStudents);
        assertEquals(0, topStudents.size());
    }

    // Test: Class Average
    @Test
    void testClassAverageWithMultipleStudents() {
        double classAvg = StudentStats.getClassAverage(manager);
        assertEquals(66.48, classAvg, 0.5); // Approximately, since Eva has 0
    }

    @Test
    void testClassAverageExcludingStudentsWithNoGrades() {
        manager.removeStudent(105); // Remove Eva who has no grades
        double classAvg = StudentStats.getClassAverage(manager);
        assertEquals(83.10, classAvg, 0.5);
    }

    @Test
    void testClassAverageWithOneStudent() {
        StudentManager singleManager = new StudentManager();
        singleManager.addStudent(alice);

        double classAvg = StudentStats.getClassAverage(singleManager);
        assertEquals(91.83, classAvg, 0.01);
    }

    @Test
    void testClassAverageWithEmptyManager() {
        StudentManager emptyManager = new StudentManager();
        double classAvg = StudentStats.getClassAverage(emptyManager);
        assertEquals(0.0, classAvg, 0.01);
    }

    // Test: Student Report
    @Test
    void testStudentReportContainsKey Information() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StudentStats.generateStudentReport(alice);
        String output = outputStream.toString();

        assertTrue(output.contains("Alice Johnson"));
        assertTrue(output.contains("101"));
        assertTrue(output.contains("91.83"));
        assertTrue(output.contains("Excellent") || output.contains("excellent"));
        assertTrue(output.contains("95.0"));

        System.setOut(System.out);
    }

    @Test
    void testStudentReportFormatting() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StudentStats.generateStudentReport(bob);
        String output = outputStream.toString();

        assertTrue(output.contains("===="));
        assertTrue(output.contains("Bob Smith"));
        assertTrue(output.contains("102"));

        System.setOut(System.out);
    }

    @Test
    void testStudentReportWithNoGrades() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StudentStats.generateStudentReport(eva);
        String output = outputStream.toString();

        assertTrue(output.contains("Eva Williams"));
        assertTrue(output.contains("No Grades") || output.contains("no grades"));

        System.setOut(System.out);
    }

    // Test: Class Report
    @Test
    void testClassReportContainsKeyMetrics() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StudentStats.generateClassReport(manager);
        String output = outputStream.toString();

        assertTrue(output.contains("Total Students"));
        assertTrue(output.contains("5") || output.contains("Class Average"));
        assertTrue(output.contains("Highest Average"));
        assertTrue(output.contains("Lowest Average"));
        assertTrue(output.contains("Alice Johnson")); // Highest

        System.setOut(System.out);
    }

    @Test
    void testClassReportFormatting() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StudentStats.generateClassReport(manager);
        String output = outputStream.toString();

        assertTrue(output.contains("===="));
        assertTrue(output.contains("Class Statistics Report") ||
                   output.contains("Class Report"));

        System.setOut(System.out);
    }

    @Test
    void testClassReportCategoryCounts() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StudentStats.generateClassReport(manager);
        String output = outputStream.toString();

        assertTrue(output.contains("90+") || output.contains("A average"));
        assertTrue(output.contains("80-89") || output.contains("80") || output.contains("B average"));

        System.setOut(System.out);
    }

    @Test
    void testClassReportWithEmptyManager() {
        StudentManager emptyManager = new StudentManager();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        StudentStats.generateClassReport(emptyManager);
        String output = outputStream.toString();

        assertTrue(output.contains("Total Students") || output.contains("0"));

        System.setOut(System.out);
    }
}
