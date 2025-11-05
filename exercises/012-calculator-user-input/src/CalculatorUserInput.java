
import java.util.Scanner;

/**
 * Exercise 012: Calculator - User Input
 *
 * Your task: Create an interactive calculator that gets two numbers from the
 * user and performs all four basic operations.
 *
 * Concepts you'll practice: - Scanner for reading user input - nextInt() and
 * nextDouble() methods - User prompts and feedback - Reusing methods from
 * previous exercises
 */
public class CalculatorUserInput {

    // Reuse these methods from exercise 011, or implement them here
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        // TODO: Create a Scanner to read user input
        // Bonus: Wrap it with try-with-resources (try {...} clause)

        // TODO: Prompt the user to enter the first number
        // Hint: System.out.print("Enter first number: ");
        // TODO: Read the first number using scanner.nextInt()

        // TODO: Prompt the user to enter the second number
        // TODO: Read the second number using scanner.nextInt()
        // TODO: Call each operation method and display the results

        // Format:
        // "10 + 5 = 15"
        // "10 - 5 = 5"
        // "10 * 5 = 50"
        // "10 / 5 = 2"

        // TODO: Close the scanner when done (or not if using try-with-resources)
    }
}
