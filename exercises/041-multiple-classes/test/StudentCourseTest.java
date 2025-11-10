
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class StudentCourseTest {

    @Test
    public void testStudentConstructorValid() {
        Student student = new Student("Alice", "S001");

        assertEquals("Alice", student.getName(),
            "Constructor should set name");
        assertEquals("S001", student.getStudentId(),
            "Constructor should set student ID");
        assertEquals(0, student.getCourseCount(),
            "New student should have 0 enrolled courses");
    }

    @Test
    public void testStudentConstructorInvalidName() {
        Student student1 = new Student(null, "S001");
        Student student2 = new Student("", "S002");

        assertEquals("Unknown", student1.getName(),
            "Constructor should set name to 'Unknown' when null");
        assertEquals("Unknown", student2.getName(),
            "Constructor should set name to 'Unknown' when empty");
    }

    @Test
    public void testStudentConstructorInvalidId() {
        Student student1 = new Student("Bob", null);
        Student student2 = new Student("Charlie", "");

        assertEquals("ID000", student1.getStudentId(),
            "Constructor should set ID to 'ID000' when null");
        assertEquals("ID000", student2.getStudentId(),
            "Constructor should set ID to 'ID000' when empty");
    }

    @Test
    public void testCourseConstructorValid() {
        Course course = new Course("Java Programming", "CS101");

        assertEquals("Java Programming", course.getCourseName(),
            "Constructor should set course name");
        assertEquals("CS101", course.getCourseCode(),
            "Constructor should set course code");
        assertEquals(0, course.getStudentCount(),
            "New course should have 0 enrolled students");
    }

    @Test
    public void testCourseConstructorInvalidName() {
        Course course1 = new Course(null, "CS101");
        Course course2 = new Course("", "CS102");

        assertEquals("Untitled Course", course1.getCourseName(),
            "Constructor should set name to 'Untitled Course' when null");
        assertEquals("Untitled Course", course2.getCourseName(),
            "Constructor should set name to 'Untitled Course' when empty");
    }

    @Test
    public void testCourseConstructorInvalidCode() {
        Course course1 = new Course("Python", null);
        Course course2 = new Course("JavaScript", "");

        assertEquals("CODE000", course1.getCourseCode(),
            "Constructor should set code to 'CODE000' when null");
        assertEquals("CODE000", course2.getCourseCode(),
            "Constructor should set code to 'CODE000' when empty");
    }

    @Test
    public void testEnrollStudentSingleStudent() {
        Student alice = new Student("Alice", "S001");
        Course java = new Course("Java Programming", "CS101");

        java.enrollStudent(alice);

        assertEquals(1, java.getStudentCount(),
            "Course should have 1 enrolled student");
        assertEquals(1, alice.getCourseCount(),
            "Student should be enrolled in 1 course");
    }

    @Test
    public void testEnrollStudentBidirectional() {
        Student bob = new Student("Bob", "S002");
        Course python = new Course("Python Basics", "CS102");

        python.enrollStudent(bob);

        // Check from course perspective
        assertTrue(python.isStudentEnrolled(bob),
            "Course should show student is enrolled");

        // Check from student perspective
        assertTrue(bob.isEnrolledIn(python),
            "Student should show enrolled in course");

        // Check lists
        ArrayList<Student> students = python.getEnrolledStudents();
        assertTrue(students.contains(bob),
            "Course's student list should contain student");

        ArrayList<Course> courses = bob.getEnrolledCourses();
        assertTrue(courses.contains(python),
            "Student's course list should contain course");
    }

    @Test
    public void testEnrollMultipleStudents() {
        Student alice = new Student("Alice", "S001");
        Student bob = new Student("Bob", "S002");
        Student charlie = new Student("Charlie", "S003");

        Course java = new Course("Java Programming", "CS101");

        java.enrollStudent(alice);
        java.enrollStudent(bob);
        java.enrollStudent(charlie);

        assertEquals(3, java.getStudentCount(),
            "Course should have 3 enrolled students");

        assertTrue(java.isStudentEnrolled(alice));
        assertTrue(java.isStudentEnrolled(bob));
        assertTrue(java.isStudentEnrolled(charlie));
    }

    @Test
    public void testStudentEnrollMultipleCourses() {
        Student diana = new Student("Diana", "S004");

        Course java = new Course("Java Programming", "CS101");
        Course python = new Course("Python Basics", "CS102");
        Course web = new Course("Web Development", "CS103");

        java.enrollStudent(diana);
        python.enrollStudent(diana);
        web.enrollStudent(diana);

        assertEquals(3, diana.getCourseCount(),
            "Student should be enrolled in 3 courses");

        assertTrue(diana.isEnrolledIn(java));
        assertTrue(diana.isEnrolledIn(python));
        assertTrue(diana.isEnrolledIn(web));
    }

    @Test
    public void testPreventDuplicateEnrollment() {
        Student eve = new Student("Eve", "S005");
        Course java = new Course("Java Programming", "CS101");

        java.enrollStudent(eve);
        java.enrollStudent(eve);  // Try to enroll again
        java.enrollStudent(eve);  // And again

        assertEquals(1, java.getStudentCount(),
            "Student should only be enrolled once despite multiple enrollStudent() calls");
        assertEquals(1, eve.getCourseCount(),
            "Student's course count should be 1 despite multiple enrollments");
    }

    @Test
    public void testEnrollNullStudent() {
        Course course = new Course("Java Programming", "CS101");

        course.enrollStudent(null);

        assertEquals(0, course.getStudentCount(),
            "Enrolling null student should not increase count");
    }

    @Test
    public void testAddNullCourse() {
        Student student = new Student("Frank", "S006");

        student.addCourse(null);

        assertEquals(0, student.getCourseCount(),
            "Adding null course should not increase count");
    }

    @Test
    public void testStudentToString() {
        Student student = new Student("Grace", "S007");

        assertEquals("Student[name=Grace, id=S007]", student.toString(),
            "toString() should return correct format");
    }

    @Test
    public void testCourseToString() {
        Course course = new Course("Data Structures", "CS201");

        assertEquals("Course[name=Data Structures, code=CS201]", course.toString(),
            "toString() should return correct format");
    }

    @Test
    public void testComplexScenario() {
        // Create students
        Student alice = new Student("Alice", "S001");
        Student bob = new Student("Bob", "S002");
        Student charlie = new Student("Charlie", "S003");

        // Create courses
        Course java = new Course("Java Programming", "CS101");
        Course python = new Course("Python Basics", "CS102");

        // Enrollments
        java.enrollStudent(alice);
        java.enrollStudent(bob);
        java.enrollStudent(charlie);

        python.enrollStudent(alice);
        python.enrollStudent(charlie);

        // Verify Java course
        assertEquals(3, java.getStudentCount());
        assertTrue(java.isStudentEnrolled(alice));
        assertTrue(java.isStudentEnrolled(bob));
        assertTrue(java.isStudentEnrolled(charlie));

        // Verify Python course
        assertEquals(2, python.getStudentCount());
        assertTrue(python.isStudentEnrolled(alice));
        assertFalse(python.isStudentEnrolled(bob));
        assertTrue(python.isStudentEnrolled(charlie));

        // Verify students
        assertEquals(2, alice.getCourseCount());    // Java and Python
        assertEquals(1, bob.getCourseCount());      // Java only
        assertEquals(2, charlie.getCourseCount());  // Java and Python

        assertTrue(alice.isEnrolledIn(java));
        assertTrue(alice.isEnrolledIn(python));
        assertTrue(bob.isEnrolledIn(java));
        assertFalse(bob.isEnrolledIn(python));
    }

    @Test
    public void testGetEnrolledStudentsList() {
        Student s1 = new Student("Student1", "S001");
        Student s2 = new Student("Student2", "S002");

        Course course = new Course("Test Course", "TEST");
        course.enrollStudent(s1);
        course.enrollStudent(s2);

        ArrayList<Student> students = course.getEnrolledStudents();

        assertEquals(2, students.size(),
            "getEnrolledStudents() should return list of correct size");
        assertTrue(students.contains(s1),
            "List should contain first student");
        assertTrue(students.contains(s2),
            "List should contain second student");
    }

    @Test
    public void testGetEnrolledCoursesList() {
        Course c1 = new Course("Course1", "C001");
        Course c2 = new Course("Course2", "C002");

        Student student = new Student("Test Student", "S001");
        c1.enrollStudent(student);
        c2.enrollStudent(student);

        ArrayList<Course> courses = student.getEnrolledCourses();

        assertEquals(2, courses.size(),
            "getEnrolledCourses() should return list of correct size");
        assertTrue(courses.contains(c1),
            "List should contain first course");
        assertTrue(courses.contains(c2),
            "List should contain second course");
    }
}
