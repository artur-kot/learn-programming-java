
import java.util.Scanner;

public class AgeCheckerAdvanced {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueChoice;

        do {
            System.out.println("=== Age Checker - Advanced ===\n");
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // consume newline

            // TODO: Validate age (must be >= 0 and <= 120)
            // If invalid, print error message and skip to next iteration
            // TODO: Determine and display age category
            // (Reuse logic from Exercise 019: Newborn, Child, Teenager, Adult, Senior)
            // TODO: Display permissions based on age
            // Use nested if/else statements to check:
            // - Can vote (age >= 18)
            // - Can drive (age >= 16)
            // - Can drink alcohol (age >= 21)
            // - Can work (age >= 14)
            // - Can sign contracts (age >= 18)
            // TODO: Use clear formatting to show YES/NO or checkmarks/X marks
            // for each permission
            System.out.print("\nCheck another person? (yes/no): ");
            continueChoice = scanner.nextLine().toLowerCase();

        } while (continueChoice.equals("yes") || continueChoice.equals("y"));

        System.out.println("Thank you for using Age Checker!");
        scanner.close();
    }

    // TODO: Consider creating helper methods like:
    // - public static String getAgeCategory(int age)
    // - public static void displayPermissions(int age)
    // - public static boolean isValidAge(int age)
}
