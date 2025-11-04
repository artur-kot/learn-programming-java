
import java.util.Scanner;

/**
 * Exercise 009: Profile - Validate Email
 *
 * Your task: Ensure the email address contains an "@" symbol
 *
 * Concepts you'll practice: - String.contains() method - Conditional statements
 * (if/else) - Input validation - User feedback
 */
public class ProfileValidateEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        // TODO: Validate that the email contains "@"
        // Use the String.contains() method
        // If valid, print a success message
        // If invalid, print an error message
        // Hint: if (email.contains("@")) { ... } else { ... }
        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        // TODO: Only print the profile card if the email is valid
        // You might need to use a boolean variable to track validity
        scanner.close();
    }
}
