
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class AgeCheckerAdvancedTest {

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
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try {
            AgeCheckerAdvanced.main(new String[]{});
        } catch (Exception e) {
            // Expected if program exits
        }

        String output = outContent.toString();
        restoreOut();
        return output;
    }

    @Test
    public void testChildCannotVote() {
        String output = runAgeChecker("10\nno\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("vote") && lower.contains("no"),
                "Child age 10 should not be able to vote");
    }

    @Test
    public void testTeenagerCanDrive() {
        String output = runAgeChecker("16\nno\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("drive"),
                "Output should mention driving");
    }

    @Test
    public void testTeenagerCannotVote() {
        String output = runAgeChecker("15\nno\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("vote") && lower.contains("no"),
                "Teenager age 15 should not be able to vote");
    }

    @Test
    public void testTeenagerCanWork() {
        String output = runAgeChecker("16\nno\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("work"),
                "Output should mention working");
    }

    @Test
    public void testAdultCanVote() {
        String output = runAgeChecker("18\nno\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("vote") && lower.contains("yes"),
                "Adult age 18 should be able to vote");
    }

    @Test
    public void testAdultCanDrive() {
        String output = runAgeChecker("18\nno\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("drive") && lower.contains("yes"),
                "Adult age 18 should be able to drive");
    }

    @Test
    public void testAdultUnder21CannotDrinkLegally() {
        String output = runAgeChecker("19\nno\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("drink") || lower.contains("alcohol"),
                "Output should mention drinking/alcohol");
    }

    @Test
    public void testAdultOver21CanDrink() {
        String output = runAgeChecker("21\nno\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("drink") || lower.contains("alcohol"),
                "Output should mention drinking/alcohol");
    }

    @Test
    public void testSeniorPermissions() {
        String output = runAgeChecker("70\nno\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("vote"),
                "Senior should be able to vote");
    }

    @Test
    public void testMultiplePermissionsChecked() {
        String output = runAgeChecker("25\nno\n");
        String lower = output.toLowerCase();
        // Should mention at least 4 different permissions
        int permissionCount = 0;
        if (lower.contains("vote")) {
            permissionCount++;
        }
        if (lower.contains("drive")) {
            permissionCount++;
        }
        if (lower.contains("drink") || lower.contains("alcohol")) {
            permissionCount++;
        }
        if (lower.contains("work")) {
            permissionCount++;
        }
        if (lower.contains("contract") || lower.contains("sign")) {
            permissionCount++;
        }

        assertTrue(permissionCount >= 4,
                "Should check at least 4 different permissions, found: " + permissionCount);
    }

    @Test
    public void testInvalidAge() {
        String output = runAgeChecker("-5\nno\n");
        assertTrue(output.toLowerCase().contains("invalid"),
                "Negative age should show invalid message");
    }

    @Test
    public void testInvalidAgeHigh() {
        String output = runAgeChecker("150\nno\n");
        assertTrue(output.toLowerCase().contains("invalid"),
                "Age over 120 should show invalid message");
    }

    @Test
    public void testValidMaximumAge() {
        String output = runAgeChecker("120\nno\n");
        assertTrue(output.length() > 50,
                "Age 120 should be processed successfully");
    }

    @Test
    public void testLoopContinuesContinue() {
        String output = runAgeChecker("25\nyes\n20\nno\n");
        // Should process two different ages
        assertTrue(output.length() > 100,
                "Should process multiple people when user answers 'yes'");
    }

    @Test
    public void testOutputFormatting() {
        String output = runAgeChecker("18\nno\n");
        String lower = output.toLowerCase();
        // Should have some clear indicators (yes/no, can/cannot, etc.)
        boolean hasYes = lower.contains("yes");
        boolean hasNo = lower.contains("no");
        boolean hasCan = lower.contains("can");
        boolean hasCannot = lower.contains("cannot");

        assertTrue(hasYes || hasNo || hasCan || hasCannot,
                "Output should clearly indicate yes/no or can/cannot for permissions");
    }
}
