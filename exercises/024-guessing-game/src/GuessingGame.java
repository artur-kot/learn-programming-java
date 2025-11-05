
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    /**
     * Generates a random number between 1 and 100
     *
     * @return a random integer in range [1, 100]
     */
    public static int generateSecretNumber() {
        // TODO: Implement random number generation
        // Use Random class to generate number between 1 and 100
        // Hint: new Random().nextInt(100) + 1
        return 0;  // Placeholder
    }

    /**
     * Validates that input is a valid integer in the correct range
     *
     * @param input the user input string
     * @return true if valid number between 1-100, false otherwise
     */
    public static boolean isValidInput(String input) {
        // TODO: Implement input validation
        // - Try to parse as integer
        // - Check if it's in range 1-100
        // - Return true only if both conditions pass
        // - Catch NumberFormatException and return false
        return false;  // Placeholder
    }

    /**
     * Parses a string to integer (assumes valid input - call isValidInput
     * first)
     *
     * @param input the user input string
     * @return the parsed integer
     */
    public static int parseGuess(String input) {
        return Integer.parseInt(input);
    }

    /**
     * Provides feedback on how the guess compares to secret number
     *
     * @param guess the user's guess
     * @param secret the secret number
     * @return feedback message
     */
    public static String getHint(int guess, int secret) {
        // TODO: Implement hint logic
        // - If guess < secret: return "Too low!"
        // - If guess > secret: return "Too high!"
        // - Otherwise: return empty string (user won't need hint)
        return "";  // Placeholder
    }

    /**
     * Plays a single round of the guessing game
     *
     * @return the number of attempts it took to guess correctly
     */
    public static int playSingleRound() {
        Scanner scanner = new Scanner(System.in);
        int secretNumber = generateSecretNumber();
        int attempts = 0;
        int guess = -1;

        System.out.println("\nI'm thinking of a number between " + MIN_NUMBER + " and " + MAX_NUMBER + "...");

        // TODO: Implement single game round logic
        // 1. Use a while loop until guess == secretNumber
        // 2. Prompt user for input
        // 3. Validate input - if invalid, show error and continue
        // 4. If valid, increment attempts and get hint
        // 5. Show hint if not correct, or show victory message if correct
        // 6. Return total attempts
        while (guess != secretNumber) {
            System.out.print("What's your guess? ");
            String input = scanner.nextLine().trim();

            if (!isValidInput(input)) {
                System.out.println("Invalid input! Please enter a number between " + MIN_NUMBER + " and " + MAX_NUMBER);
                continue;
            }

            guess = parseGuess(input);
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Correct! You guessed it in " + attempts + " attempt" + (attempts == 1 ? "" : "s") + "!");
            } else {
                String hint = getHint(guess, secretNumber);
                System.out.println(hint);
            }
        }

        return attempts;
    }

    /**
     * Asks the user if they want to play again
     *
     * @return true if user wants to play, false otherwise
     */
    public static boolean askPlayAgain() {
        Scanner scanner = new Scanner(System.in);

        // TODO: Implement play again logic
        // 1. Prompt: "Play again? (yes/no): "
        // 2. Get user response and convert to lowercase
        // 3. Check if response is "yes", "y" -> return true
        // 4. Check if response is "no", "n" -> return false
        // 5. If invalid, loop and ask again
        while (true) {
            System.out.print("Play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("yes") || response.equals("y")) {
                return true;
            } else if (response.equals("no") || response.equals("n")) {
                return false;
            } else {
                System.out.println("Please enter 'yes' or 'no'");
            }
        }
    }

    /**
     * Main game loop - coordinates multiple rounds and statistics
     */
    public static void main(String[] args) {
        int gamesPlayed = 0;
        int totalAttempts = 0;

        System.out.println("======================================");
        System.out.println("  Welcome to the Guessing Game!");
        System.out.println("  Guess a number between 1 and 100");
        System.out.println("======================================");

        // TODO: Implement main game loop
        // 1. Use while(true) or a boolean flag for outer loop
        // 2. Play a single round and get attempts
        // 3. Increment gamesPlayed counter
        // 4. Add attempts to totalAttempts
        // 5. Ask if player wants to play again
        // 6. If no, break and show statistics
        boolean playing = true;
        while (playing) {
            int attemptsThisRound = playSingleRound();
            gamesPlayed++;
            totalAttempts += attemptsThisRound;

            playing = askPlayAgain();
        }

        // TODO: Display final statistics
        // Show total games and average attempts
        System.out.println("\n======================================");
        System.out.println("Thanks for playing!");
        System.out.println("Games played: " + gamesPlayed);
        if (gamesPlayed > 0) {
            double avgAttempts = (double) totalAttempts / gamesPlayed;
            System.out.println("Average attempts per game: " + String.format("%.2f", avgAttempts));
        }
        System.out.println("======================================");
    }
}
