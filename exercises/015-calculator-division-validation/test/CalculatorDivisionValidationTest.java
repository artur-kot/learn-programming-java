
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("Calculator - Division Validation Tests")
public class CalculatorDivisionValidationTest {

    @Test
    @DisplayName("isValidDivisor() returns true for non-zero divisors")
    public void testIsValidDivisorTrue() {
        assertTrue(CalculatorDivisionValidation.isValidDivisor(5.0));
        assertTrue(CalculatorDivisionValidation.isValidDivisor(-3.0));
        assertTrue(CalculatorDivisionValidation.isValidDivisor(0.0001));
    }

    @Test
    @DisplayName("isValidDivisor() returns false for zero")
    public void testIsValidDivisorFalse() {
        assertFalse(CalculatorDivisionValidation.isValidDivisor(0.0));
        assertFalse(CalculatorDivisionValidation.isValidDivisor(0));
    }

    @Test
    @DisplayName("safeDivide() returns correct result for valid division")
    public void testSafeDivideValid() {
        assertEquals(5.0, CalculatorDivisionValidation.safeDivide(10.0, 2.0));
        assertEquals(2.5, CalculatorDivisionValidation.safeDivide(5.0, 2.0));
    }

    @Test
    @DisplayName("safeDivide() returns NaN for division by zero")
    public void testSafeDivideZero() {
        double result = CalculatorDivisionValidation.safeDivide(10.0, 0.0);
        assertTrue(Double.isNaN(result));
    }

    @Test
    @DisplayName("safeDivide() handles negative numbers")
    public void testSafeDivideNegative() {
        assertEquals(-5.0, CalculatorDivisionValidation.safeDivide(10.0, -2.0));
        assertEquals(-2.5, CalculatorDivisionValidation.safeDivide(-5.0, 2.0));
    }

    @Test
    @DisplayName("safeDivide() handles zero dividend")
    public void testSafeDivideZeroDividend() {
        assertEquals(0.0, CalculatorDivisionValidation.safeDivide(0.0, 5.0));
    }

    @Test
    @DisplayName("divideSafe() prints correct result for valid division")
    public void testDivideSafeValid() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(out));

        CalculatorDivisionValidation.divideSafe(10.0, 2.0);

        System.setOut(oldOut);
        String output = out.toString();

        assertTrue(output.contains("10"));
        assertTrue(output.contains("2"));
        assertTrue(output.contains("5"));
    }

    @Test
    @DisplayName("divideSafe() prints error message for division by zero")
    public void testDivideSafeZero() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(out));

        CalculatorDivisionValidation.divideSafe(10.0, 0.0);

        System.setOut(oldOut);
        String output = out.toString();

        assertTrue(output.contains("Error") || output.contains("zero"));
    }

    @Test
    @DisplayName("validateAndCalculate() returns correct result string")
    public void testValidateAndCalculateValid() {
        String result = CalculatorDivisionValidation.validateAndCalculate(20, 4);
        assertTrue(result.contains("20") || result.contains("5"));
        assertFalse(result.contains("Error"));
    }

    @Test
    @DisplayName("validateAndCalculate() returns error string for division by zero")
    public void testValidateAndCalculateZero() {
        String result = CalculatorDivisionValidation.validateAndCalculate(20, 0);
        assertTrue(result.contains("Error") || result.contains("zero"));
    }

    @Test
    @DisplayName("validateAndCalculate() handles zero dividend")
    public void testValidateAndCalculateZeroDividend() {
        String result = CalculatorDivisionValidation.validateAndCalculate(0, 5);
        assertFalse(result.contains("Error"));
    }

    @Test
    @DisplayName("validateAndCalculate() handles negative numbers")
    public void testValidateAndCalculateNegative() {
        String result = CalculatorDivisionValidation.validateAndCalculate(-20, 4);
        assertFalse(result.contains("Error"));

        String resultNegativeDivisor = CalculatorDivisionValidation.validateAndCalculate(20, -4);
        assertFalse(resultNegativeDivisor.contains("Error"));
    }
}
