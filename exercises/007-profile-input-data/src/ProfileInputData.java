import java.util.Scanner;

/**
 * Your task: Ask the user for their profile information
 *
 * Concepts you'll practice: - Scanner for user input - Reading different data
 * types (String, int) - Parsing input correctly
 */
public class ProfileInputData {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Ask for and read the user's name
        System.out.print("Enter your name: ");

        // TODO: Ask for and read the user's age
        // Hint: Use scanner.nextInt() for integers
        // TODO: Ask for and read the user's email
        // Hint: After nextInt(), you may need to call scanner.nextLine() to clear the buffer
        // TODO: Ask if they are a student (true/false)
        // Hint: Use scanner.nextBoolean() for boolean values
        // TODO: Print a summary of all the information collected
        scanner.close();
    }
}
