import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    // Scanner is shared across methods
    private static Scanner scanner = new Scanner(System.in);
    private static Random rand = new Random();

    /**
     * Generates a random number between min and max (inclusive).
     *
     * @param min The minimum value (inclusive)
     * @param max The maximum value (inclusive)
     * @return A random integer between min and max
     */
    public static int generateRandomNumber(int min, int max) {
        // TODO: Generate and return a random number between min and max
        // Hint: How many possible values are there from min to max?
        // Hint: Use rand.nextInt() and add the appropriate offset
        return 0;  // Placeholder - replace this
    }

    /**
     * Compares a guess to the target and returns a hint.
     *
     * @param guess The player's guess
     * @param target The target number to guess
     * @return "Too low!" if guess < target, "Too high!" if guess > target, "Correct!" if equal
     */
    public static String checkGuess(int guess, int target) {
        // TODO: Compare guess and target, return appropriate hint
        // Return "Too low!" if guess is less than target
        // Return "Too high!" if guess is greater than target
        // Return "Correct!" if they match
        return "";  // Placeholder - replace this
    }

    /**
     * Plays one round of the guessing game.
     * The player tries to guess a random number between 1 and 100.
     */
    public static void playGame() {
        // TODO: Implement the main game loop
        // 1. Generate a random number between 1 and 100
        // 2. Initialize an attempts counter
        // 3. Create a while loop that continues until the player guesses correctly
        // 4. Inside the loop:
        //    - Prompt for a guess
        //    - Increment attempts
        //    - Get hint from checkGuess()
        //    - Display the hint
        //    - If correct, break from the loop
        // 5. After the loop, display how many attempts it took

        System.out.println("\nI'm thinking of a number between 1 and 100...");

        // Your code here
    }

    /**
     * Asks the player if they want to play again.
     *
     * @return true if the player wants to play again, false otherwise
     */
    public static boolean playAgain() {
        // TODO: Ask the user if they want to play again
        // Prompt: "Play again? (yes/no): "
        // Accept "yes" or "y" (case-insensitive) as true
        // Everything else returns false
        return false;  // Placeholder - replace this
    }

    /**
     * Main method - starts the game and handles replay loop.
     */
    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("   Welcome to the Guessing Game!");
        System.out.println("   I'm thinking of a number 1-100");
        System.out.println("=====================================");

        // TODO: Create a loop that:
        // 1. Plays one game round
        // 2. Asks if the player wants to play again
        // 3. Continues if they say yes, exits if they say no

        // Your code here

        System.out.println("\nThanks for playing!");
        scanner.close();
    }
}
