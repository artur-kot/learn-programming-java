import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator - Command-Line Arguments Tests")
public class CalculatorCommandLineArgsTest {

    @Test
    @DisplayName("add() returns correct sum")
    public void testAdd() {
        assertEquals(15.0, CalculatorCommandLineArgs.add(10, 5));
        assertEquals(0.0, CalculatorCommandLineArgs.add(5, -5));
        assertEquals(25.5, CalculatorCommandLineArgs.add(10.5, 15));
    }

    @Test
    @DisplayName("subtract() returns correct difference")
    public void testSubtract() {
        assertEquals(5.0, CalculatorCommandLineArgs.subtract(10, 5));
        assertEquals(-5.0, CalculatorCommandLineArgs.subtract(5, 10));
        assertEquals(0.0, CalculatorCommandLineArgs.subtract(7, 7));
    }

    @Test
    @DisplayName("multiply() returns correct product")
    public void testMultiply() {
        assertEquals(50.0, CalculatorCommandLineArgs.multiply(10, 5));
        assertEquals(0.0, CalculatorCommandLineArgs.multiply(10, 0));
        assertEquals(-20.0, CalculatorCommandLineArgs.multiply(4, -5));
    }

    @Test
    @DisplayName("divide() returns correct quotient")
    public void testDivide() {
        assertEquals(5.0, CalculatorCommandLineArgs.divide(20, 4));
        assertEquals(2.5, CalculatorCommandLineArgs.divide(5, 2));
        assertEquals(1.0, CalculatorCommandLineArgs.divide(10, 10));
    }

    @Test
    @DisplayName("divide() handles negative numbers")
    public void testDivideNegative() {
        assertEquals(-5.0, CalculatorCommandLineArgs.divide(20, -4));
        assertEquals(-2.5, CalculatorCommandLineArgs.divide(-5, 2));
    }

    @Test
    @DisplayName("add() works with doubles")
    public void testAddDoubles() {
        assertEquals(3.5, CalculatorCommandLineArgs.add(1.5, 2), 0.0001);
        assertEquals(10.1, CalculatorCommandLineArgs.add(5.05, 5.05), 0.0001);
    }

    @Test
    @DisplayName("subtract() works with doubles")
    public void testSubtractDoubles() {
        assertEquals(0.5, CalculatorCommandLineArgs.subtract(2.5, 2), 0.0001);
    }

    @Test
    @DisplayName("multiply() works with doubles")
    public void testMultiplyDoubles() {
        assertEquals(2.25, CalculatorCommandLineArgs.multiply(1.5, 1.5), 0.0001);
    }

    @Test
    @DisplayName("divide() works with doubles")
    public void testDivideDoubles() {
        assertEquals(1.5, CalculatorCommandLineArgs.divide(3.0, 2.0), 0.0001);
    }
}
