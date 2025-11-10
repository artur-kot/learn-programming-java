import java.util.ArrayList;

public class StudentStats {

    public static double getAverageGrade(Student student) {
        if (student.getGrades().isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (double grade : student.getGrades()) {
            sum += grade;
        }
        return sum / student.getGrades().size();
    }

    public static ArrayList<Student> getTopStudents(StudentManager manager, int n) {
        ArrayList<Student> allStudents = new ArrayList<>(manager.getStudents());
        ArrayList<Student> topStudents = new ArrayList<>();

        // Sort by average grade (descending)
        for (int i = 0; i < Math.min(n, allStudents.size()); i++) {
            int maxIndex = 0;
            double maxAverage = -1;

            for (int j = 0; j < allStudents.size(); j++) {
                double avg = getAverageGrade(allStudents.get(j));
                if (avg > maxAverage) {
                    maxAverage = avg;
                    maxIndex = j;
                }
            }

            topStudents.add(allStudents.get(maxIndex));
            allStudents.remove(maxIndex);
        }

        return topStudents;
    }

    public static double getClassAverage(StudentManager manager) {
        if (manager.getStudents().isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (Student student : manager.getStudents()) {
            sum += getAverageGrade(student);
        }
        return sum / manager.getStudents().size();
    }

    public static void generateStudentReport(Student student) {
        System.out.println("========================================");
        System.out.println("Student Report: " + student.getName() + " (ID: " + student.getId() + ")");
        System.out.println("========================================");
        System.out.println("Grades: " + student.getGrades());
        System.out.println("Number of Grades: " + student.getGrades().size());

        double average = getAverageGrade(student);
        System.out.printf("Average Grade: %.2f%n", average);

        String status;
        if (student.getGrades().isEmpty()) {
            status = "No Grades";
        } else if (average >= 90) {
            status = "Excellent";
        } else if (average >= 80) {
            status = "Good";
        } else if (average >= 70) {
            status = "Satisfactory";
        } else {
            status = "Needs Improvement";
        }
        System.out.println("Status: " + status);
        System.out.println("========================================");
    }

    public static void generateClassReport(StudentManager manager) {
        System.out.println("========================================");
        System.out.println("Class Statistics Report");
        System.out.println("========================================");

        ArrayList<Student> students = manager.getStudents();
        System.out.println("Total Students: " + students.size());

        if (students.isEmpty()) {
            System.out.println("No students to report on");
            System.out.println("========================================");
            return;
        }

        double classAvg = getClassAverage(manager);
        System.out.printf("Class Average: %.2f%n", classAvg);

        // Find highest and lowest
        Student highest = students.get(0);
        Student lowest = students.get(0);
        double highestAvg = getAverageGrade(highest);
        double lowestAvg = getAverageGrade(lowest);

        for (Student student : students) {
            double avg = getAverageGrade(student);
            if (avg > highestAvg) {
                highest = student;
                highestAvg = avg;
            }
            if (avg < lowestAvg) {
                lowest = student;
                lowestAvg = avg;
            }
        }

        System.out.printf("Highest Average: %.2f (%s)%n", highestAvg, highest.getName());
        System.out.printf("Lowest Average: %.2f (%s)%n", lowestAvg, lowest.getName());

        // Count by grade ranges
        int countA = 0, countB = 0, countC = 0, countBelow = 0;
        for (Student student : students) {
            double avg = getAverageGrade(student);
            if (avg >= 90) countA++;
            else if (avg >= 80) countB++;
            else if (avg >= 70) countC++;
            else countBelow++;
        }

        System.out.println("Students with A average (90+): " + countA);
        System.out.println("Students with B average (80-89): " + countB);
        System.out.println("Students with C average (70-79): " + countC);
        System.out.println("Students below C average: " + countBelow);
        System.out.println("========================================");
    }
}
