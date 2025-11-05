
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class CounterSumRangeTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private InputStream originalIn;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        originalIn = System.in;
        System.setOut(new PrintStream(outContent));
    }

    private void restoreIO() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private String runWithInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        try {
            CounterSumRange.main(new String[]{});
        } catch (Exception e) {
            // Expected
        }
        String output = outContent.toString();
        restoreIO();
        return output;
    }

    @Test
    public void testSum5Equals15() {
        String output = runWithInput("5\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("15") || output.contains("15"),
                "Sum of 1 to 5 should be 15");
    }

    @Test
    public void testSum10Equals55() {
        String output = runWithInput("10\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("55") || output.contains("55"),
                "Sum of 1 to 10 should be 55");
    }

    @Test
    public void testSum1Equals1() {
        String output = runWithInput("1\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("1") && output.contains("sum"),
                "Sum of 1 to 1 should be 1");
    }

    @Test
    public void testSum3Equals6() {
        String output = runWithInput("3\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("6") || output.contains("6"),
                "Sum of 1 to 3 should be 6 (1+2+3)");
    }

    @Test
    public void testOutputMentionsSumOrTotal() {
        String output = runWithInput("5\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("sum") || lower.contains("total"),
                "Output should mention 'sum' or 'total'");
    }

    @Test
    public void testAsksForInput() {
        String output = runWithInput("5\n");
        String lower = output.toLowerCase();
        assertTrue(lower.contains("enter") || lower.contains("number"),
                "Should ask user to enter a number");
    }
}
