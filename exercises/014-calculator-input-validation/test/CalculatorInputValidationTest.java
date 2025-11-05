
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

@DisplayName("Calculator - Input Validation Tests")
public class CalculatorInputValidationTest {

    @Test
    @DisplayName("add() returns correct sum")
    public void testAdd() {
        assertEquals(15.0, CalculatorInputValidation.add(10, 5));
        assertEquals(0.0, CalculatorInputValidation.add(5, -5));
        assertEquals(25.5, CalculatorInputValidation.add(10.5, 15));
    }

    @Test
    @DisplayName("divide() returns correct quotient")
    public void testDivide() {
        assertEquals(5.0, CalculatorInputValidation.divide(20, 4));
        assertEquals(2.5, CalculatorInputValidation.divide(5, 2));
        assertEquals(1.0, CalculatorInputValidation.divide(10, 10));
    }

    @Test
    @DisplayName("divide() handles negative numbers")
    public void testDivideNegative() {
        assertEquals(-5.0, CalculatorInputValidation.divide(20, -4));
        assertEquals(-2.5, CalculatorInputValidation.divide(-5, 2));
    }

    @Test
    @DisplayName("readInteger() successfully parses valid integer input")
    public void testReadIntegerValid() {
        String input = "42\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int result = CalculatorInputValidation.readInteger(scanner, "Enter number: ");
        assertEquals(42, result);
    }

    @Test
    @DisplayName("readInteger() handles invalid then valid input")
    public void testReadIntegerInvalidThenValid() {
        String input = "abc\n123\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        int result = CalculatorInputValidation.readInteger(scanner, "Enter number: ");
        assertEquals(123, result);
    }

    @Test
    @DisplayName("readDouble() successfully parses valid double input")
    public void testReadDoubleValid() {
        String input = "3.14\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        double result = CalculatorInputValidation.readDouble(scanner, "Enter number: ");
        assertEquals(3.14, result, 0.01);
    }

    @Test
    @DisplayName("readDouble() handles invalid then valid input")
    public void testReadDoubleInvalidThenValid() {
        String input = "xyz\n2.5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);

        double result = CalculatorInputValidation.readDouble(scanner, "Enter number: ");
        assertEquals(2.5, result, 0.01);
    }

    @Test
    @DisplayName("add() works with doubles")
    public void testAddDoubles() {
        assertEquals(3.5, CalculatorInputValidation.add(1.5, 2), 0.0001);
        assertEquals(10.1, CalculatorInputValidation.add(5.05, 5.05), 0.0001);
    }

    @Test
    @DisplayName("divide() works with doubles")
    public void testDivideDoubles() {
        assertEquals(1.5, CalculatorInputValidation.divide(3.0, 2.0), 0.0001);
    }
}
