
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
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();
            
            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();
            
            // TODO: Clean the names by:
            // 1. Trimming whitespace with .trim()
            // 2. Converting to lowercase with .toLowerCase()
            // 3. Capitalizing first letter (use substring and toUpperCase)
            // Example: "  jOHN  " -> "John"
            String cleanedFirstName = /* Code */
            String cleanedLastName = /* Code */
                    
                    
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter your email (may have extra spaces): ");
            String email = scanner.nextLine();
            
            // TODO: Clean the email by:
            // 1. Trimming whitespace
            // 2. Converting to lowercase (emails are typically lowercase)
            String cleanedEmail = /* Code */
                    
                    
            System.out.print("Enter your country code (e.g., us, uk, ca): ");
            String countryCode = scanner.nextLine();
            
            // TODO: Clean the country code by:
            // 1. Trimming whitespace
            // 2. Converting to UPPERCASE (country codes are usually uppercase)
            // TODO: Validate that email contains "@" after cleaning
            String cleanedCountryCode = /* Code */
                    
            System.out.println("--- Profile Summary (Raw) ---");
            System.out.println("Name: " + firstName + " " + lastName);
            System.out.println("Age: " + age);
            System.out.println("Email: " + email);
            System.out.println("Country Code: " + countryCode);
            
            System.out.println("--- Profile Summary (Cleaned) ---");
            System.out.println("Name: " + cleanedFirstName + " " + cleanedLastName);
            System.out.println("Age: " + age);
            System.out.println("Email: " + cleanedEmail);
            System.out.println("Country Code: " + cleanedCountryCode);
        }
    }
}
