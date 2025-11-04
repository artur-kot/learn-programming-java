
import java.util.Scanner;

/**
 * Your task: Ask the user for their profile information
 *
 * Concepts you'll practice: - Scanner for user input - Reading different data
 * types (String, int) - Parsing input correctly
 */
public class ProfileInputData {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter your name: ");
            String name = /* TODO: Ask for and read the user's age */

            System.out.print("Enter your email: ");
            String email = /* TODO: Ask for and read the user's email */

            System.out.print("Enter your age: ");
            int age = /* TODO: Ask for and read the user's age */

            // TODO: After reading an int, clear the buffer if necessary

            System.out.print("Are you a student (true/false): ");
            boolean isStudent = /* TODO: Ask for and read the user's student status */;

            System.out.println("--- Profile Summary ---");
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Age: " + age);
            System.out.println("Student: " + isStudent);
        }
    }
}
w