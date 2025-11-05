
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class GuessingGameTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testGenerateSecretNumber() {
        // Test that random number is in valid range
        for (int i = 0; i < 10; i++) {
            int secret = GuessingGame.generateSecretNumber();
            assertTrue(secret >= 1 && secret <= 100,
                    "Secret number should be between 1 and 100, got: " + secret);
        }
    }

    @Test
    public void testIsValidInputWithValidNumbers() {
        assertTrue(GuessingGame.isValidInput("1"), "Should accept 1");
        assertTrue(GuessingGame.isValidInput("50"), "Should accept 50");
        assertTrue(GuessingGame.isValidInput("100"), "Should accept 100");
        assertTrue(GuessingGame.isValidInput("75"), "Should accept 75");
    }

    @Test
    public void testIsValidInputWithInvalidNumbers() {
        assertFalse(GuessingGame.isValidInput("0"), "Should reject 0");
        assertFalse(GuessingGame.isValidInput("101"), "Should reject 101");
        assertFalse(GuessingGame.isValidInput("-1"), "Should reject negative");
        assertFalse(GuessingGame.isValidInput("1000"), "Should reject out of range");
    }

    @Test
    public void testIsValidInputWithNonNumbers() {
        assertFalse(GuessingGame.isValidInput("abc"), "Should reject non-numeric");
        assertFalse(GuessingGame.isValidInput(""), "Should reject empty string");
        assertFalse(GuessingGame.isValidInput("50.5"), "Should reject decimal");
        assertFalse(GuessingGame.isValidInput("fifty"), "Should reject text");
    }

    @Test
    public void testGetHintTooLow() {
        String hint = GuessingGame.getHint(25, 50);
        assertTrue(hint.toLowerCase().contains("low"),
                "Should indicate guess is too low");
    }

    @Test
    public void testGetHintTooHigh() {
        String hint = GuessingGame.getHint(75, 50);
        assertTrue(hint.toLowerCase().contains("high"),
                "Should indicate guess is too high");
    }

    @Test
    public void testParseGuess() {
        assertEquals(42, GuessingGame.parseGuess("42"),
                "Should correctly parse valid input");
        assertEquals(1, GuessingGame.parseGuess("1"),
                "Should correctly parse 1");
        assertEquals(100, GuessingGame.parseGuess("100"),
                "Should correctly parse 100");
    }

    @Test
    public void testBoundaryValues() {
        // Test edge cases
        assertTrue(GuessingGame.isValidInput("1"), "Should accept minimum 1");
        assertTrue(GuessingGame.isValidInput("100"), "Should accept maximum 100");
        assertFalse(GuessingGame.isValidInput("0"), "Should reject 0");
        assertFalse(GuessingGame.isValidInput("101"), "Should reject 101");
    }

    @Test
    public void testInputValidationWithWhitespace() {
        // Assuming implementation trims input
        assertTrue(GuessingGame.isValidInput("  50  "),
                "Should handle whitespace");
        assertTrue(GuessingGame.isValidInput("1"),
                "Should accept 1");
    }
}
