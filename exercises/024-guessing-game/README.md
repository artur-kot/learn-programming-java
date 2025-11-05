# Exercise 024: Guessing Game - Random Numbers & Loops

## Overview

Build a complete interactive guessing game that combines multiple programming concepts: random number generation, loops, conditionals, and game flow control. This exercise progressively builds features from generating random numbers to implementing a full playable game with attempt tracking and replay functionality.

## What You're Learning

### Part 1: Generating Random Numbers

The `Random` class generates random numbers:

```java
import java.util.Random;

Random random = new Random();
int secretNumber = random.nextInt(100) + 1;  // Random number 1-100
```

Breaking this down:
- `new Random()` creates a random number generator
- `nextInt(100)` generates a random number 0-99
- `+ 1` shifts the range to 1-100

### Part 2: While Loops for Game Logic

A **while loop** runs as long as a condition is true:

```java
int attempts = 0;
while (guess != secretNumber) {
    // Get user input
    // Check if guess is correct
    // Provide feedback
    attempts++;
}
```

The loop continues until the user guesses correctly.

### Part 3: Conditional Feedback

Give the user hints based on their guess:

```java
if (guess < secretNumber) {
    System.out.println("Too low! Try again.");
} else if (guess > secretNumber) {
    System.out.println("Too high! Try again.");
} else {
    System.out.println("Correct! You won!");
}
```

### Part 4: Attempt Tracking

Count how many guesses the user makes:

```java
int attempts = 0;
while (guess != secretNumber) {
    attempts++;
    // Game logic here
}
System.out.println("You took " + attempts + " attempts!");
```

### Part 5: Nested Loops for Replay

Allow the user to play multiple rounds:

```java
boolean playAgain = true;
while (playAgain) {
    // Play one round
    
    // Ask to play again
    System.out.print("Play again? (yes/no): ");
    String response = scanner.nextLine().toLowerCase();
    playAgain = response.equals("yes");
}
```

## Your Task

Create a complete guessing game program with the following features:

### Part 1: Initialize Game
- Create a `Random` object
- Generate a secret number between 1 and 100
- Initialize attempt counter

### Part 2: Game Loop
- **Prompt** the user for a guess
- **Validate** that input is a valid number (1-100)
- **Compare** the guess to the secret number
- **Provide feedback**:
  - If too low: "Your guess is too low! Try again."
  - If too high: "Your guess is too high! Try again."
  - If correct: "Correct! You guessed it in X attempts!"
- **Increment** the attempt counter
- **Continue** until guess is correct

### Part 3: End of Round Stats
- Display how many attempts it took
- Show a congratulatory message

### Part 4: Replay Feature
- Ask if the user wants to play again
- Accept "yes", "y", "no", "n" (case-insensitive)
- Generate a new secret number and reset counters if playing again
- Exit gracefully if not

### Part 5: Overall Statistics (Bonus)
- Track total games played
- Display final statistics when exiting

## Example Output

```
======================================
  Welcome to the Guessing Game!
  I'm thinking of a number 1-100...
======================================

What's your guess? 50
Your guess is too low! Try again.

What's your guess? 75
Your guess is too high! Try again.

What's your guess? 62
Your guess is too low! Try again.

What's your guess? 68
Your guess is too high! Try again.

What's your guess? 65
Correct! You guessed it in 5 attempts!

Play again? (yes/no): yes

======================================
  New game! I'm thinking of a number...
======================================

What's your guess? 50
Your guess is too low! Try again.

What's your guess? 75
Your guess is too high! Try again.

What's your guess? 62
Correct! You guessed it in 3 attempts!

Play again? (yes/no): no

======================================
Thanks for playing! You played 2 games.
======================================
```

## Algorithm

1. **Setup**: Import Random, create Scanner, initialize variables
2. **Outer loop** (while playing):
   - Generate a new secret number (1-100)
   - Reset attempt counter
   - **Inner loop** (while guessing):
     - Get user input
     - Validate input (must be valid number, 1-100)
     - Compare to secret number
     - Provide appropriate feedback
     - Increment attempts
   - Display final round stats
   - Ask to play again
3. **Exit**: Display overall statistics

## Tips

- **Input Validation**: Use try/catch or check for valid ranges
- **Case-insensitive comparison**: Use `.toLowerCase()` for "yes"/"no" responses
- **Nested Loops**: Outer loop for game rounds, inner loop for guesses
- **Readability**: Use clear separators (====) for output sections
- **Random generation**: Remember `new Random()` creates the generator once, then call `nextInt()` on it

## Starter Code

```java
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    
    /**
     * Generates a random number between 1 and 100
     */
    public static int generateSecretNumber() {
        // TODO: Implement random number generation
        return 0;  // Placeholder
    }
    
    /**
     * Validates that input is a valid integer
     */
    public static boolean isValidInput(String input) {
        // TODO: Implement input validation
        return false;  // Placeholder
    }
    
    /**
     * Plays a single round of the guessing game
     * @return the number of attempts it took to win
     */
    public static int playSingleRound() {
        // TODO: Implement single game round logic
        // - Generate secret number
        // - Get guesses in a loop
        // - Provide feedback
        // - Track attempts
        // - Return attempt count
        return 0;  // Placeholder
    }
    
    /**
     * Asks the user if they want to play again
     * @return true if user wants to play, false otherwise
     */
    public static boolean askPlayAgain() {
        // TODO: Implement play again logic
        // - Prompt user
        // - Read response
        // - Accept: yes, y, no, n (case-insensitive)
        // - Return true/false accordingly
        return false;  // Placeholder
    }
    
    /**
     * Main game loop - coordinates multiple rounds and statistics
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gamesPlayed = 0;
        int totalAttempts = 0;
        
        System.out.println("======================================");
        System.out.println("  Welcome to the Guessing Game!");
        System.out.println("  Guess a number between 1 and 100");
        System.out.println("======================================\n");
        
        boolean playing = true;
        while (playing) {
            // TODO: Implement main game loop
            // 1. Play a single round
            // 2. Get attempts from that round
            // 3. Update statistics
            // 4. Ask if user wants to play again
            // 5. Update playing flag
        }
        
        // TODO: Display final statistics
        System.out.println("\n======================================");
        System.out.println("Thanks for playing!");
        System.out.println("======================================");
    }
}
```

## Testing Hints

The test file will verify:
- Random number generation produces numbers in range 1-100
- Input validation correctly identifies valid/invalid inputs
- Single round logic produces correct attempt counts
- Play again logic correctly interprets yes/no responses
- Game statistics are tracked accurately
- Program handles invalid inputs gracefully
