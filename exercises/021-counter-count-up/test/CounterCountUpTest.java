
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class CounterCountUpTest {

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

    @Test
    public void testOutputContains1Through10() {
        CounterCountUp.main(new String[]{});
        String output = outContent.toString();
        restoreOut();

        for (int i = 1; i <= 10; i++) {
            assertTrue(output.contains(String.valueOf(i)),
                    "Output should contain number " + i);
        }
    }

    @Test
    public void testCountUpIsInOrder() {
        CounterCountUp.main(new String[]{});
        String output = outContent.toString();
        restoreOut();

        String[] lines = output.trim().split("\n");
        assertTrue(lines.length >= 20, "Output should have at least 20 lines (10 up + 10 down)");

        // Check first 10 lines are 1-10
        for (int i = 0; i < 10; i++) {
            assertEquals(String.valueOf(i + 1), lines[i].trim(),
                    "Line " + (i + 1) + " should contain " + (i + 1));
        }
    }

    @Test
    public void testCountDownInOrder() {
        CounterCountUp.main(new String[]{});
        String output = outContent.toString();
        restoreOut();

        String[] lines = output.trim().split("\n");
        assertTrue(lines.length >= 20, "Output should have at least 20 lines");

        // Check last 10 lines are 10-1
        for (int i = 0; i < 10; i++) {
            assertEquals(String.valueOf(10 - i), lines[10 + i].trim(),
                    "Line " + (11 + i) + " should contain " + (10 - i));
        }
    }

    @Test
    public void testNoInputPrompts() {
        CounterCountUp.main(new String[]{});
        String output = outContent.toString();
        restoreOut();

        String lower = output.toLowerCase();
        assertFalse(lower.contains("enter"), "Should not ask for user input");
        assertFalse(lower.contains("input"), "Should not ask for user input");
    }

    @Test
    public void testTwentyNumbersTotal() {
        CounterCountUp.main(new String[]{});
        String output = outContent.toString();
        restoreOut();

        String[] lines = output.trim().split("\n");
        int count = 0;
        for (String line : lines) {
            if (line.trim().matches("^\\d+$")) {
                count++;
            }
        }

        assertTrue(count >= 20, "Should print at least 20 numbers (10 up + 10 down)");
    }
}
