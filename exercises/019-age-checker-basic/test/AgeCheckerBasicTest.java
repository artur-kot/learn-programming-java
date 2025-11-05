
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class AgeCheckerBasicTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    private void restoreOut() {
        System.setOut(originalOut);
    }

    private String runAgeChecker(String input) {
        // Create input stream from test input
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try {
            AgeCheckerBasic.main(new String[]{});
        } catch (Exception e) {
            // Expected if program exits
        }

        String output = outContent.toString();
        restoreOut();
        return output;
    }

    @Test
    public void testNewbornAge() {
        String output = runAgeChecker("0\n");
        assertTrue(output.toLowerCase().contains("newborn"),
                "Age 0 should be categorized as Newborn");
    }

    @Test
    public void testChildAge() {
        String output = runAgeChecker("7\n");
        assertTrue(output.toLowerCase().contains("child"),
                "Age 7 should be categorized as Child");
    }

    @Test
    public void testTeenagerAge() {
        String output = runAgeChecker("15\n");
        assertTrue(output.toLowerCase().contains("teenager"),
                "Age 15 should be categorized as Teenager");
    }

    @Test
    public void testAdultAge() {
        String output = runAgeChecker("30\n");
        assertTrue(output.toLowerCase().contains("adult"),
                "Age 30 should be categorized as Adult");
    }

    @Test
    public void testSeniorAge() {
        String output = runAgeChecker("70\n");
        assertTrue(output.toLowerCase().contains("senior"),
                "Age 70 should be categorized as Senior");
    }

    @Test
    public void testBoundaryChild12() {
        String output = runAgeChecker("12\n");
        assertTrue(output.toLowerCase().contains("child"),
                "Age 12 should be categorized as Child");
    }

    @Test
    public void testBoundaryTeenager13() {
        String output = runAgeChecker("13\n");
        assertTrue(output.toLowerCase().contains("teenager"),
                "Age 13 should be categorized as Teenager");
    }

    @Test
    public void testBoundaryTeenager19() {
        String output = runAgeChecker("19\n");
        assertTrue(output.toLowerCase().contains("teenager"),
                "Age 19 should be categorized as Teenager");
    }

    @Test
    public void testBoundaryAdult20() {
        String output = runAgeChecker("20\n");
        assertTrue(output.toLowerCase().contains("adult"),
                "Age 20 should be categorized as Adult");
    }

    @Test
    public void testBoundaryAdult64() {
        String output = runAgeChecker("64\n");
        assertTrue(output.toLowerCase().contains("adult"),
                "Age 64 should be categorized as Adult");
    }

    @Test
    public void testBoundarySenior65() {
        String output = runAgeChecker("65\n");
        assertTrue(output.toLowerCase().contains("senior"),
                "Age 65 should be categorized as Senior");
    }

    @Test
    public void testInvalidNegativeAge() {
        String output = runAgeChecker("-5\n");
        assertTrue(output.toLowerCase().contains("invalid"),
                "Negative age should show invalid message");
    }

    @Test
    public void testInvalidTooHighAge() {
        String output = runAgeChecker("150\n");
        assertTrue(output.toLowerCase().contains("invalid"),
                "Age over 120 should show invalid message");
    }

    @Test
    public void testValidMaximumAge() {
        String output = runAgeChecker("120\n");
        assertTrue(output.toLowerCase().contains("senior"),
                "Age 120 should be valid and categorized as Senior");
    }

    @Test
    public void testRecommendationIncluded() {
        String output = runAgeChecker("25\n");
        // Should contain both category and some recommendation text
        assertTrue(output.toLowerCase().contains("adult"),
                "Should include adult category");
        assertTrue(output.length() > 50,
                "Output should include both category and recommendation");
    }
}
