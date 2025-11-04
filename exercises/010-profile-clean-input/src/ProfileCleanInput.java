
import java.util.Scanner;

/**
 * Exercise 010: Profile - Clean Input
 *
 * Your task: Clean up user input by trimming whitespace and adjusting
 * capitalization
 *
 * Concepts you'll practice: - String.trim() to remove leading/trailing spaces -
 * String.toUpperCase() to convert to uppercase - String.toLowerCase() to
 * convert to lowercase - String manipulation for data cleaning
 */
public class ProfileCleanInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        // TODO: Clean the names by:
        // 1. Trimming whitespace with .trim()
        // 2. Converting to lowercase with .toLowerCase()
        // 3. Capitalizing first letter (use substring and toUpperCase)
        // Example: "  jOHN  " -> "John"
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your email (may have extra spaces): ");
        String email = scanner.nextLine();

        // TODO: Clean the email by:
        // 1. Trimming whitespace
        // 2. Converting to lowercase (emails are typically lowercase)
        System.out.print("Enter your country code (e.g., us, uk, ca): ");
        String countryCode = scanner.nextLine();

        // TODO: Clean the country code by:
        // 1. Trimming whitespace
        // 2. Converting to UPPERCASE (country codes are usually uppercase)
        // TODO: Validate that email contains "@" after cleaning
        // TODO: Display the cleaned profile information
        // Show both "before" and "after" to demonstrate the cleaning
        scanner.close();
    }
}
