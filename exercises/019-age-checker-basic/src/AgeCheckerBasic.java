
import java.util.Scanner;

public class AgeCheckerBasic {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // TODO: Validate age (must be >= 0 and <= 120)
            // If invalid, print error message: "Invalid age! Age must be between 0 and 120"
            // Then exit the program
            // TODO: Use if/else if/else to check age categories:
            // - Age 0: Print "Age category: Newborn"
            // - Age 1-12: Print "Age category: Child"
            // - Age 13-19: Print "Age category: Teenager"
            // - Age 20-64: Print "Age category: Adult"
            // - Age 65+: Print "Age category: Senior"
            // TODO: For each category, print an appropriate recommendation:
            // - Newborn: "Recommendation: Take care and enjoy early development!"
            // - Child: "Recommendation: Focus on learning and having fun!"
            // - Teenager: "Recommendation: Explore interests and prepare for adulthood!"
            // - Adult: "Recommendation: Time to build your career and independence!"
            // - Senior: "Recommendation: Enjoy your well-earned rest and retirement!"
            // BONUS: Try implementing this same logic using a switch statement instead!
            // Switch statements provide an alternative way to check multiple values.
            // Hint: You might need to divide age into ranges first or use pattern matching.
        }
    }
}
