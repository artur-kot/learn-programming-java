
import java.util.Scanner;

/**
 * Exercise 008: Profile - Format Output
 *
 * Your task: Display profile information in a beautifully formatted card
 *
 * Concepts you'll practice: - printf for formatted output - Format specifiers
 * (%s, %d, %b) - Escape sequences (\n, \t) - Creating visually appealing output
 */
public class ProfileFormatOutput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your city: ");
        String city = scanner.nextLine();

        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean();

        // TODO: Use printf to create a nicely formatted profile card
        // Your card should:
        // - Have a header/title
        // - Display each field with labels
        // - Use proper alignment and spacing
        // - Look professional and easy to read
        //
        // Example format:
        // ================================
        //        PROFILE CARD
        // ================================
        // Name:     Alice Johnson
        // Age:      25 years
        // Email:    alice@example.com
        // City:     New York
        // Student:  Yes
        // ================================
        scanner.close();
    }
}
