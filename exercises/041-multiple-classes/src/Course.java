import java.util.ArrayList;

public class Course {
    // TODO: Declare private fields:
    // - courseName (String)
    // - courseCode (String)
    // - enrolledStudents (ArrayList<Student>)

    // TODO: Create constructor: public Course(String courseName, String courseCode)
    // Validation:
    // - If courseName is null or empty, set to "Untitled Course"
    // - If courseCode is null or empty, set to "CODE000"
    // - Initialize enrolledStudents as a new ArrayList

    // TODO: Create getCourseName() method
    // Returns: String

    // TODO: Create getCourseCode() method
    // Returns: String

    // TODO: Create getEnrolledStudents() method
    // Returns: ArrayList<Student>

    // TODO: Create enrollStudent(Student student) method
    // This is the main enrollment method - it updates BOTH objects!
    // - Don't enroll if student is null
    // - Don't enroll if already enrolled (use contains())
    // - Add student to enrolledStudents list
    // - Call student.addCourse(this) to update student's list (bidirectional!)

    // TODO: Create getStudentCount() method
    // Returns: int (size of enrolledStudents)

    // TODO: Create isStudentEnrolled(Student student) method
    // Returns: boolean (true if enrolledStudents contains the student)

    // TODO: Override toString() method
    // Format: "Course[name=Java Programming, code=CS101]"
    // Use @Override annotation
}
