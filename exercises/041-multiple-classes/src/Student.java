import java.util.ArrayList;

public class Student {
    // TODO: Declare private fields:
    // - name (String)
    // - studentId (String)
    // - enrolledCourses (ArrayList<Course>)

    // TODO: Create constructor: public Student(String name, String studentId)
    // Validation:
    // - If name is null or empty, set to "Unknown"
    // - If studentId is null or empty, set to "ID000"
    // - Initialize enrolledCourses as a new ArrayList

    // TODO: Create getName() method
    // Returns: String

    // TODO: Create getStudentId() method
    // Returns: String

    // TODO: Create getEnrolledCourses() method
    // Returns: ArrayList<Course>

    // TODO: Create addCourse(Course course) method
    // - Don't add if course is null
    // - Don't add if already enrolled (use contains())
    // - Add course to enrolledCourses list
    // NOTE: This method is called BY Course.enrollStudent()
    // Do NOT call course.enrollStudent() here (would cause infinite loop!)

    // TODO: Create getCourseCount() method
    // Returns: int (size of enrolledCourses)

    // TODO: Create isEnrolledIn(Course course) method
    // Returns: boolean (true if enrolledCourses contains the course)

    // TODO: Override toString() method
    // Format: "Student[name=Alice, id=S001]"
    // Use @Override annotation
}
