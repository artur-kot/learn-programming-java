
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("Calculator - Format Results Tests")
public class CalculatorFormatResultsTest {

    @Test
    @DisplayName("roundToDecimals() rounds to 2 decimal places")
    public void testRoundToDecimalsTwo() {
        assertEquals(3.14, CalculatorFormatResults.roundToDecimals(3.14159, 2));
        assertEquals(2.14, CalculatorFormatResults.roundToDecimals(2.142857, 2));
    }

    @Test
    @DisplayName("roundToDecimals() rounds to 3 decimal places")
    public void testRoundToDecimalsThree() {
        assertEquals(3.142, CalculatorFormatResults.roundToDecimals(3.14159, 3), 0.0001);
        assertEquals(2.143, CalculatorFormatResults.roundToDecimals(2.142857, 3), 0.0001);
    }

    @Test
    @DisplayName("roundToDecimals() handles rounding up")
    public void testRoundToDecimalsUp() {
        assertEquals(3.15, CalculatorFormatResults.roundToDecimals(3.149, 2), 0.0001);
        assertEquals(3.20, CalculatorFormatResults.roundToDecimals(3.199, 2), 0.0001);
    }

    @Test
    @DisplayName("roundToDecimals() rounds to 0 decimal places")
    public void testRoundToDecimalsZero() {
        assertEquals(3.0, CalculatorFormatResults.roundToDecimals(3.5, 0));
        assertEquals(4.0, CalculatorFormatResults.roundToDecimals(3.6, 0));
    }

    @Test
    @DisplayName("roundToDecimals() handles negative numbers")
    public void testRoundToDecimalsNegative() {
        assertEquals(-3.14, CalculatorFormatResults.roundToDecimals(-3.14159, 2));
        assertEquals(-2.15, CalculatorFormatResults.roundToDecimals(-2.149, 2), 0.0001);
    }

    @Test
    @DisplayName("formatToDecimals() returns string with 2 decimal places")
    public void testFormatToDecimalsTwo() {
        assertEquals("3.14", CalculatorFormatResults.formatToDecimals(3.14159, 2));
        assertEquals("2.14", CalculatorFormatResults.formatToDecimals(2.142857, 2));
    }

    @Test
    @DisplayName("formatToDecimals() returns string with 3 decimal places")
    public void testFormatToDecimalsThree() {
        assertEquals("3.142", CalculatorFormatResults.formatToDecimals(3.14159, 3));
        assertEquals("2.143", CalculatorFormatResults.formatToDecimals(2.142857, 3));
    }

    @Test
    @DisplayName("formatToDecimals() returns string with 0 decimal places")
    public void testFormatToDecimalsZero() {
        assertEquals("3", CalculatorFormatResults.formatToDecimals(3.5, 0));
        assertEquals("4", CalculatorFormatResults.formatToDecimals(3.6, 0));
    }

    @Test
    @DisplayName("formatToDecimals() handles negative numbers")
    public void testFormatToDecimalsNegative() {
        assertEquals("-3.14", CalculatorFormatResults.formatToDecimals(-3.14159, 2));
    }

    @Test
    @DisplayName("divide() returns correct quotient as double")
    public void testDivide() {
        assertEquals(2.5, CalculatorFormatResults.divide(5, 2));
        assertEquals(2.142857142857143, CalculatorFormatResults.divide(15, 7), 0.0001);
    }

    @Test
    @DisplayName("displayResult() outputs formatted message")
    public void testDisplayResult() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(out));

        CalculatorFormatResults.displayResult("15 / 7", 2.142857, 2);

        System.setOut(oldOut);
        String output = out.toString();

        // Verify the output contains the operation and formatted result
        assertTrue(output.contains("15 / 7"));
        assertTrue(output.contains("2.14"));
    }
}
