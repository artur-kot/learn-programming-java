import java.io.*;
import java.util.ArrayList;

public class StudentPersistence {

    /**
     * Save all students to a CSV file
     * Format: id,name,grade1;grade2;grade3
     * Example: 101,Alice Johnson,95.0;88.5;92.0
     *
     * Students with no grades should have no grades listed:
     * Example: 103,Charlie Davis
     *
     * Use try-with-resources to ensure file is closed properly
     * Print success message with count of students saved
     * Handle IOException and print error message
     */
    public static void saveToFile(StudentManager manager, String filename) {
        // TODO: Implement saving students to CSV file
        // Use BufferedWriter and FileWriter
        // Iterate through all students in manager
        // For each student, format as: id,name,grades
        // Grades should be semicolon-separated (95.0;88.5;92.0)
        // Handle IOException with try-catch
    }

    /**
     * Load students from a CSV file and return a StudentManager
     * Format: id,name,grade1;grade2;grade3
     *
     * Parse each line:
     * - Split by comma to get id, name, and grades
     * - If grades exist, split by semicolon
     * - Create Student object and add grades
     * - Add student to manager
     *
     * Use try-with-resources to ensure file is closed properly
     * Print success message with count of students loaded
     * Handle IOException and print error message
     * Return new StudentManager with loaded students
     */
    public static StudentManager loadFromFile(String filename) {
        // TODO: Implement loading students from CSV file
        // Use BufferedReader and FileReader
        // Read each line and parse it
        // Split line by comma: parts[0]=id, parts[1]=name, parts[2]=grades
        // If grades exist (parts.length > 2), split by semicolon
        // Create Student, add grades, add to manager
        // Handle IOException with try-catch
        // Return the populated StudentManager
        return null;
    }
}
