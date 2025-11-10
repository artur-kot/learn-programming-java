# Exercise 024: Guessing Game - Random Numbers & Loops

## Overview

Ever played a guessing game? Someone thinks of a number, and you try to guess it while they give you hints like "higher" or "lower". Now you'll build that game with code!

This exercise introduces **while loops** and the **Random class**. Unlike for loops that count a specific number of times, while loops keep running until something happens - perfect for games where you don't know how many guesses a player will need!

## What You're Learning

### The Random Class

When you play games, you want unpredictability. The `Random` class generates random numbers for you.

To use it, you first need to import it and create a Random object:
```java
import java.util.Random;

Random rand = new Random();
```

Then you can generate random numbers. The `nextInt(n)` method gives you a random number from 0 up to (but not including) n:
```java
int randomNumber = rand.nextInt(100);  // Gives 0-99
int randomNumber = rand.nextInt(100) + 1;  // Gives 1-100
```

**Why `+ 1`?** Because `nextInt(100)` gives 0-99, and adding 1 shifts the range to 1-100!

### While Loops

A **while loop** keeps repeating as long as a condition is true. It's perfect when you don't know exactly how many times you need to repeat something.

Basic structure:
```java
while (condition) {
    // Code that repeats while condition is true
}
```

The loop checks the condition before each iteration. When it becomes false, the loop stops.

**Think about it:** In a guessing game, you don't know if the player will guess in 1 try or 20 tries. A while loop lets you keep asking for guesses until they get it right!

### The Challenge

You'll combine these concepts to create a working game where:
- The computer picks a random number
- The player makes guesses
- The game gives hints ("too high" or "too low")
- The loop continues until the player wins
- The player can choose to play again

## Your Task

Complete the methods in `GuessingGame.java` to create a fully functional guessing game.

### Part 1: generateRandomNumber(int min, int max)
Create a method that returns a random integer between min and max (inclusive).

**Hints for this method:**
- The range from min to max includes both endpoints
- If min=1 and max=100, valid numbers are 1, 2, 3... 99, 100
- Use the Random class's `nextInt()` method
- Think about the math: how many possible numbers are there from min to max?

### Part 2: checkGuess(int guess, int target)
Create a method that compares a guess to the target number and returns a hint string.

Should return:
- "Too low!" if guess < target
- "Too high!" if guess > target
- "Correct!" if guess == target

### Part 3: playGame()
This is the heart of your program! Create the main game loop that:
1. Generates a random number between 1 and 100
2. Initializes an attempt counter to 0
3. Uses a **while loop** that continues until the player guesses correctly
4. Inside the loop:
   - Prompts the player for their guess
   - Increments the attempt counter
   - Gets a hint using checkGuess()
   - Displays the hint
   - If correct, breaks out of the loop
5. After the loop, displays how many attempts it took

**This is where you practice while loops!** Think about what condition keeps the game running.

### Part 4: playAgain()
Create a method that asks if the player wants to play again.
- Prompt the user with "Play again? (yes/no): "
- Read their response
- Return true if they answered "yes" or "y" (case-insensitive)
- Return false otherwise

## Example Output

```
=====================================
   Welcome to the Guessing Game!
   I'm thinking of a number 1-100
=====================================

Enter your guess: 50
Too low!
Enter your guess: 75
Too high!
Enter your guess: 62
Too low!
Enter your guess: 68
Too high!
Enter your guess: 65
Correct!

You guessed it in 5 attempts!

Play again? (yes/no): yes

=====================================
   New Game! Good luck!
=====================================

Enter your guess: 30
Too low!
Enter your guess: 60
Too high!
Enter your guess: 45
Correct!

You guessed it in 3 attempts!

Play again? (yes/no): no

Thanks for playing!
```

## Requirements

Your implementation should:
- Generate random numbers in the specified range (1-100)
- Use a while loop for the main game logic
- Count and display the number of attempts
- Give accurate hints ("Too low!", "Too high!", "Correct!")
- Handle replay functionality correctly
- Work with Scanner for user input

## Testing Your Solution

Compile and run your program:
```bash
javac src/GuessingGame.java
java -cp src GuessingGame
```

Run the automated tests:
```bash
mvn test
```

The tests verify:
- Random number generation stays within bounds
- The checkGuess method returns correct hints
- The playAgain method correctly interprets yes/no responses

## Hints

<details>
<summary>Hint 1: Generating Random Numbers in a Range</summary>

To generate a random number from min to max (inclusive):

1. Figure out how many possible values there are: `max - min + 1`
2. Generate a random number in that range: `rand.nextInt(max - min + 1)`
3. Shift it to start at min: `rand.nextInt(max - min + 1) + min`

Example: For 1-100, that's `rand.nextInt(100) + 1`
</details>

<details>
<summary>Hint 2: The While Loop Condition</summary>

Your while loop needs to keep running until the player guesses correctly. Think about what variable tracks whether they've guessed right.

One approach: Use a boolean variable like `boolean hasWon = false;`

Another approach: Compare the guess directly in the condition.

The loop continues WHILE they haven't won yet!
</details>

<details>
<summary>Hint 3: Comparing Strings for Play Again</summary>

When checking if the user said "yes":
- Get their input: `String response = scanner.nextLine();`
- Convert to lowercase: `response.toLowerCase()`
- Compare: `response.equals("yes") || response.equals("y")`

The `||` means "or" - true if either condition is true.
</details>

<details>
<summary>Hint 4: Structure of playGame()</summary>

Think about the flow:
```java
Generate random number
Set attempts to 0
Set hasWon to false

while (not won yet) {
    Ask for guess
    Increment attempts
    Check if guess is correct
    If correct:
        Set hasWon to true
        Display success message
    Otherwise:
        Display hint
}

Display total attempts
```
</details>

## Reflection Questions

After completing this exercise, think about:

1. **Loop choice**: Why is a while loop better than a for loop for this game? What would make a for loop awkward here?

2. **Random testing**: How would you test that your random number generator works correctly? Can you prove it's truly random?

3. **Improving hints**: How could you make the hints even more helpful? What if you told the player when they're "very close"?

4. **Edge cases**: What happens if the player enters text instead of a number? How could you handle that gracefully?

5. **Strategy**: If the range is 1-100, what's the smartest guessing strategy? Can you guarantee winning in a certain number of guesses?

## Next Steps

Excellent work mastering while loops and random numbers! These are fundamental tools for creating interactive programs:
- Games with unpredictable elements
- Programs that run until a condition is met
- User interfaces that wait for specific input
- Simulations and randomized algorithms

Up next, you'll learn about methods and how to organize your code into reusable building blocks!

## Read More

Want to dive deeper? Check out these resources:

- [Oracle Java Tutorials - Random Numbers](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
- [Oracle Java Tutorials - The while Statement](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html)
- [GeeksforGeeks - While Loop in Java](https://www.geeksforgeeks.org/java-while-loop-with-examples/)
- [Game Development Basics](https://www.gamedesigning.org/learn/game-logic/)
