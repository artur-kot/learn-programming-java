import java.util.ArrayList;

public class StudentStats {

    /**
     * Calculate the average grade for a student
     * Returns 0.0 if the student has no grades
     */
    public static double getAverageGrade(Student student) {
        // TODO: Calculate and return average of student's grades
        // Handle case where student has no grades (return 0.0)
        return 0.0;
    }

    /**
     * Get the top N students sorted by average grade (highest first)
     * If there are fewer than N students, return all students sorted
     * Students with no grades should appear at the end
     */
    public static ArrayList<Student> getTopStudents(StudentManager manager, int n) {
        // TODO: Create a list of top N students sorted by average grade
        // Use getAverageGrade() to calculate each student's average
        // Sort in descending order (highest average first)
        return null;
    }

    /**
     * Calculate the class average across all students
     * This is the average of all individual student averages
     * Returns 0.0 if there are no students
     */
    public static double getClassAverage(StudentManager manager) {
        // TODO: Calculate average of all student averages
        // Return 0.0 if no students
        return 0.0;
    }

    /**
     * Generate and print a detailed report for an individual student
     * Format:
     * ========================================
     * Student Report: [Name] (ID: [ID])
     * ========================================
     * Grades: [list of grades]
     * Number of Grades: [count]
     * Average Grade: [average with 2 decimals]
     * Status: [Excellent/Good/Satisfactory/Needs Improvement/No Grades]
     * ========================================
     *
     * Status based on average:
     * 90+: Excellent
     * 80-89: Good
     * 70-79: Satisfactory
     * Below 70: Needs Improvement
     * No grades: No Grades
     */
    public static void generateStudentReport(Student student) {
        // TODO: Print formatted student report with all information
    }

    /**
     * Generate and print a comprehensive class statistics report
     * Format:
     * ========================================
     * Class Statistics Report
     * ========================================
     * Total Students: [count]
     * Class Average: [average with 2 decimals]
     * Highest Average: [average] ([student name])
     * Lowest Average: [average] ([student name])
     * Students with A average (90+): [count]
     * Students with B average (80-89): [count]
     * Students with C average (70-79): [count]
     * Students below C average: [count]
     * ========================================
     */
    public static void generateClassReport(StudentManager manager) {
        // TODO: Print comprehensive class statistics
        // Include all metrics listed above
    }
}
