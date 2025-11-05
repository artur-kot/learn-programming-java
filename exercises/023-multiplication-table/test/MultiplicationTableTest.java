
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplicationTableTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSingleTableFor3() {
        MultiplicationTable.printSingleTable(3);
        String output = outContent.toString();

        // Check that output contains key results
        assertTrue(output.contains("3") && output.contains("30"),
                "Output should contain multiplication results for 3");

        // Check that it has approximately 10 lines (one for each multiplier 1-10)
        String[] lines = output.trim().split("\n");
        assertEquals(10, lines.length, "Should have 10 lines for multipliers 1-10");
    }

    @Test
    public void testSingleTableFor7() {
        MultiplicationTable.printSingleTable(7);
        String output = outContent.toString();

        assertTrue(output.contains("7") && output.contains("70"),
                "Output should contain multiplication results for 7");

        String[] lines = output.trim().split("\n");
        assertEquals(10, lines.length, "Should have 10 lines");
    }

    @Test
    public void testFullGridDimensions() {
        System.setOut(originalOut);  // Restore to see if there are issues
        System.setOut(new PrintStream(outContent));

        MultiplicationTable.printFullGrid();
        String output = outContent.toString();

        String[] lines = output.trim().split("\n");
        assertEquals(10, lines.length, "Full grid should have 10 rows");
    }

    @Test
    public void testFullGridValues() {
        MultiplicationTable.printFullGrid();
        String output = outContent.toString();

        // Check for some key values that should appear in the grid
        assertTrue(output.contains("100"), "Grid should contain 10*10=100");
        assertTrue(output.contains("1"), "Grid should contain 1*1=1");
        assertTrue(output.contains("50"), "Grid should contain 5*10=50 or 10*5=50");
    }

    @Test
    public void testSingleTableCorrectMath() {
        MultiplicationTable.printSingleTable(5);
        String output = outContent.toString();

        String[] lines = output.trim().split("\n");

        // For a proper implementation, each line should contain the result
        // Line 1 should have 5*1=5, Line 5 should have 5*5=25, etc.
        assertTrue(output.contains("5") && output.contains("25"),
                "Should show 5*5=25");
        assertTrue(output.contains("50"),
                "Should show 5*10=50");
    }
}
