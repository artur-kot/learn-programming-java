
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
        // Hint: new Random().nextInt() with correct parameters

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
        // - Whitespaces should be trimmed before parsing

        return false; // Placeholder
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

        while (true) {
            System.out.print("Play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();

            switch (response) {
                case "yes":
                case "y":
                    return true;
                case "no":
                case "n":
                    return false;
                default:
                    System.out.println("Please enter 'yes' or 'no'");
                    break;
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

        boolean playing = true;
        while (playing) {
            int attemptsThisRound = playSingleRound();
            gamesPlayed++;
            totalAttempts += attemptsThisRound;

            playing = askPlayAgain();
        }

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
