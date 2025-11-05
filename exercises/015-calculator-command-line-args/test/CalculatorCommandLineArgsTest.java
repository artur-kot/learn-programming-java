
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@DisplayName("Calculator - Command-Line Arguments Tests")
public class CalculatorCommandLineArgsTest {

    private PrintStream oldOut;
    private ByteArrayOutputStream capturedOutput;

    @BeforeEach
    public void setUp() {
        // Capture System.out for testing output
        oldOut = System.out;
        capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));
    }

    private void restoreSystemOut() {
        System.setOut(oldOut);
    }

    private String getOutput() {
        restoreSystemOut();
        return capturedOutput.toString();
    }

    @Test
    @DisplayName("add() returns correct sum")
    public void testAdd() {
        restoreSystemOut();
        assertEquals(15.0, CalculatorCommandLineArgs.add(10, 5));
        assertEquals(0.0, CalculatorCommandLineArgs.add(5, -5));
        assertEquals(25.5, CalculatorCommandLineArgs.add(10.5, 15));
    }

    @Test
    @DisplayName("subtract() returns correct difference")
    public void testSubtract() {
        restoreSystemOut();
        assertEquals(5.0, CalculatorCommandLineArgs.subtract(10, 5));
        assertEquals(-5.0, CalculatorCommandLineArgs.subtract(5, 10));
        assertEquals(0.0, CalculatorCommandLineArgs.subtract(7, 7));
    }

    @Test
    @DisplayName("multiply() returns correct product")
    public void testMultiply() {
        restoreSystemOut();
        assertEquals(50.0, CalculatorCommandLineArgs.multiply(10, 5));
        assertEquals(0.0, CalculatorCommandLineArgs.multiply(10, 0));
        assertEquals(-20.0, CalculatorCommandLineArgs.multiply(4, -5));
    }

    @Test
    @DisplayName("divide() returns correct quotient")
    public void testDivide() {
        restoreSystemOut();
        assertEquals(5.0, CalculatorCommandLineArgs.divide(20, 4));
        assertEquals(2.5, CalculatorCommandLineArgs.divide(5, 2));
        assertEquals(1.0, CalculatorCommandLineArgs.divide(10, 10));
    }

    @Test
    @DisplayName("divide() handles division by zero")
    public void testDivideByZero() {
        double result = CalculatorCommandLineArgs.divide(20, 0);
        assertTrue(Double.isNaN(result), "Division by zero should return NaN");
        String output = getOutput();
        assertTrue(output.contains("Error") || output.contains("zero"));
    }

    @Test
    @DisplayName("divide() handles negative numbers")
    public void testDivideNegative() {
        restoreSystemOut();
        assertEquals(-5.0, CalculatorCommandLineArgs.divide(20, -4));
        assertEquals(-2.5, CalculatorCommandLineArgs.divide(-5, 2));
    }

    // ============= MAIN METHOD TESTS WITH SIMULATED ARGS =============
    @Test
    @DisplayName("main() with valid add operation arguments")
    public void testMainWithAddOperation() {
        String[] args = {"10", "5", "add"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("10") || output.contains("10.0"));
        assertTrue(output.contains("5") || output.contains("5.0"));
        assertTrue(output.contains("+"));
        assertTrue(output.contains("15"));
    }

    @Test
    @DisplayName("main() with valid subtract operation arguments")
    public void testMainWithSubtractOperation() {
        String[] args = {"20", "8", "subtract"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("20") || output.contains("20.0"));
        assertTrue(output.contains("8") || output.contains("8.0"));
        assertTrue(output.contains("-"));
        assertTrue(output.contains("12"));
    }

    @Test
    @DisplayName("main() with valid multiply operation arguments")
    public void testMainWithMultiplyOperation() {
        String[] args = {"7", "6", "multiply"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("7") || output.contains("7.0"));
        assertTrue(output.contains("6") || output.contains("6.0"));
        assertTrue(output.contains("*"));
        assertTrue(output.contains("42"));
    }

    @Test
    @DisplayName("main() with valid divide operation arguments")
    public void testMainWithDivideOperation() {
        String[] args = {"20", "4", "divide"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("20") || output.contains("20.0"));
        assertTrue(output.contains("4") || output.contains("4.0"));
        assertTrue(output.contains("/"));
        assertTrue(output.contains("5"));
    }

    @Test
    @DisplayName("main() with doubles in arguments")
    public void testMainWithDoubleArguments() {
        String[] args = {"15.5", "2.5", "add"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("15.5"));
        assertTrue(output.contains("2.5"));
        assertTrue(output.contains("18")); // 15.5 + 2.5 = 18
    }

    @Test
    @DisplayName("main() with too few arguments")
    public void testMainWithTooFewArguments() {
        String[] args = {"10", "5"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("Error"));
        assertTrue(output.contains("Expected 3 arguments"));
        assertTrue(output.contains("got 2"));
    }

    @Test
    @DisplayName("main() with too many arguments")
    public void testMainWithTooManyArguments() {
        String[] args = {"10", "5", "add", "extra"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("Error"));
        assertTrue(output.contains("Expected 3 arguments"));
        assertTrue(output.contains("got 4"));
    }

    @Test
    @DisplayName("main() with no arguments")
    public void testMainWithNoArguments() {
        String[] args = {};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("Error"));
        assertTrue(output.contains("Expected 3 arguments"));
        assertTrue(output.contains("got 0"));
    }

    @Test
    @DisplayName("main() with invalid first number")
    public void testMainWithInvalidFirstNumber() {
        String[] args = {"abc", "5", "add"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("Error") && output.contains("Invalid number"));
    }

    @Test
    @DisplayName("main() with invalid second number")
    public void testMainWithInvalidSecondNumber() {
        String[] args = {"10", "xyz", "add"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("Error") && output.contains("Invalid number"));
    }

    @Test
    @DisplayName("main() with invalid operation")
    public void testMainWithInvalidOperation() {
        String[] args = {"10", "5", "power"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("Error"));
        assertTrue(output.contains("Unknown operation"));
        assertTrue(output.contains("power"));
    }

    @Test
    @DisplayName("main() division by zero via arguments")
    public void testMainWithDivisionByZeroArguments() {
        String[] args = {"20", "0", "divide"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("Error") || output.contains("NaN") || output.contains("zero"));
    }

    @Test
    @DisplayName("main() with negative numbers in arguments")
    public void testMainWithNegativeNumbers() {
        String[] args = {"-10", "5", "multiply"};
        CalculatorCommandLineArgs.main(args);
        String output = getOutput();

        assertTrue(output.contains("-50"));
    }
}
