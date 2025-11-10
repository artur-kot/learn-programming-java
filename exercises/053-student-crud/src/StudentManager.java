import java.util.ArrayList;

public class StudentManager {

    // TODO: Declare private field: students (ArrayList<Student>)

    /**
     * Constructor to initialize the StudentManager
     */
    public StudentManager() {
        // TODO: Initialize the students ArrayList
    }

    /**
     * Add a student to the collection
     */
    public void addStudent(Student student) {
        // TODO: Add the student to the students ArrayList
    }

    /**
     * Remove a student by their ID
     * Returns true if student was found and removed, false otherwise
     */
    public boolean removeStudent(int id) {
        // TODO: Find the student by id and remove them
        // Return true if found and removed, false if not found
        return false;
    }

    /**
     * Find a student by their ID
     * Returns the Student object if found, null otherwise
     */
    public Student findStudent(int id) {
        // TODO: Loop through students and find the one with matching id
        // Return the student if found, null otherwise
        return null;
    }

    /**
     * List all students in the system
     * Print each student on a separate line with a number
     * If no students, print "No students in the system"
     * Example output:
     * 1. Student{id=101, name='Alice Johnson', grades=[95.0, 88.5]}
     * 2. Student{id=102, name='Bob Smith', grades=[78.0]}
     */
    public void listAllStudents() {
        // TODO: Check if students list is empty and print appropriate message
        // Otherwise, loop through and print each student with a number
    }

    /**
     * Get the list of all students
     */
    public ArrayList<Student> getStudents() {
        // TODO: Return the students ArrayList
        return null;
    }
}
