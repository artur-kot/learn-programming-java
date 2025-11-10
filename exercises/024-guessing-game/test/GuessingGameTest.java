import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuessingGameTest {

    @Test
    public void testGenerateRandomNumberInRange() {
        // Test that random numbers are within the specified range
        for (int i = 0; i < 100; i++) {
            int random = GuessingGame.generateRandomNumber(1, 100);
            assertTrue(random >= 1 && random <= 100,
                    "Random number should be between 1 and 100, got: " + random);
        }
    }

    @Test
    public void testGenerateRandomNumberSmallRange() {
        // Test with a smaller range
        for (int i = 0; i < 50; i++) {
            int random = GuessingGame.generateRandomNumber(5, 10);
            assertTrue(random >= 5 && random <= 10,
                    "Random number should be between 5 and 10, got: " + random);
        }
    }

    @Test
    public void testGenerateRandomNumberSingleValue() {
        // When min equals max, should always return that value
        int random = GuessingGame.generateRandomNumber(42, 42);
        assertEquals(42, random,
                "When min equals max, should return that value");
    }

    @Test
    public void testCheckGuessTooLow() {
        String hint = GuessingGame.checkGuess(25, 50);
        assertEquals("Too low!", hint,
                "Should return 'Too low!' when guess is less than target");
    }

    @Test
    public void testCheckGuessTooHigh() {
        String hint = GuessingGame.checkGuess(75, 50);
        assertEquals("Too high!", hint,
                "Should return 'Too high!' when guess is greater than target");
    }

    @Test
    public void testCheckGuessCorrect() {
        String hint = GuessingGame.checkGuess(50, 50);
        assertEquals("Correct!", hint,
                "Should return 'Correct!' when guess equals target");
    }

    @Test
    public void testCheckGuessEdgeCases() {
        // Test edge cases
        assertEquals("Too low!", GuessingGame.checkGuess(1, 100),
                "Minimum guess should be too low");
        assertEquals("Too high!", GuessingGame.checkGuess(100, 1),
                "Maximum guess should be too high");
        assertEquals("Correct!", GuessingGame.checkGuess(1, 1),
                "Matching edge values should be correct");
    }

    @Test
    public void testCheckGuessConsistency() {
        // Test consistency with multiple checks
        int target = 42;

        assertEquals("Too low!", GuessingGame.checkGuess(30, target));
        assertEquals("Too low!", GuessingGame.checkGuess(41, target));
        assertEquals("Correct!", GuessingGame.checkGuess(42, target));
        assertEquals("Too high!", GuessingGame.checkGuess(43, target));
        assertEquals("Too high!", GuessingGame.checkGuess(50, target));
    }

    @Test
    public void testRandomNumberDistribution() {
        // Ensure random numbers cover the full range over many iterations
        boolean[] seen = new boolean[11]; // For range 1-10

        for (int i = 0; i < 200; i++) {
            int random = GuessingGame.generateRandomNumber(1, 10);
            if (random >= 1 && random <= 10) {
                seen[random] = true;
            }
        }

        // Check that we've seen at least 80% of possible values
        int count = 0;
        for (int i = 1; i <= 10; i++) {
            if (seen[i]) count++;
        }

        assertTrue(count >= 8,
                "Random generator should produce varied numbers. Saw " + count + " out of 10 possible values");
    }
}
