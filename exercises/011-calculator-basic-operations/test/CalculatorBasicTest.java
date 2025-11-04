
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator - Basic Operations Tests")
public class CalculatorBasicTest {

    @Test
    @DisplayName("add() returns correct sum of two positive integers")
    public void testAddPositive() {
        assertEquals(15, CalculatorBasic.add(10, 5));
        assertEquals(25, CalculatorBasic.add(12, 13));
    }

    @Test
    @DisplayName("add() works with negative numbers")
    public void testAddNegative() {
        assertEquals(0, CalculatorBasic.add(10, -10));
        assertEquals(-5, CalculatorBasic.add(-10, 5));
    }

    @Test
    @DisplayName("subtract() returns correct difference")
    public void testSubtract() {
        assertEquals(12, CalculatorBasic.subtract(20, 8));
        assertEquals(0, CalculatorBasic.subtract(5, 5));
        assertEquals(-5, CalculatorBasic.subtract(5, 10));
    }

    @Test
    @DisplayName("subtract() works with negative numbers")
    public void testSubtractNegative() {
        assertEquals(15, CalculatorBasic.subtract(10, -5));
        assertEquals(-15, CalculatorBasic.subtract(-10, 5));
    }

    @Test
    @DisplayName("multiply() returns correct product")
    public void testMultiply() {
        assertEquals(42, CalculatorBasic.multiply(7, 6));
        assertEquals(0, CalculatorBasic.multiply(100, 0));
        assertEquals(1, CalculatorBasic.multiply(1, 1));
    }

    @Test
    @DisplayName("multiply() works with negative numbers")
    public void testMultiplyNegative() {
        assertEquals(-20, CalculatorBasic.multiply(-4, 5));
        assertEquals(20, CalculatorBasic.multiply(-4, -5));
    }

    @Test
    @DisplayName("divide() returns correct quotient")
    public void testDivide() {
        assertEquals(5.0, CalculatorBasic.divide(15.0, 3.0));
        assertEquals(2.5, CalculatorBasic.divide(5.0, 2.0));
        assertEquals(1.0, CalculatorBasic.divide(10.0, 10.0));
    }

    @Test
    @DisplayName("divide() returns correct result for non-whole division")
    public void testDivideDecimal() {
        assertEquals(3.5, CalculatorBasic.divide(7.0, 2.0));
        assertEquals(0.5, CalculatorBasic.divide(1.0, 2.0));
    }

    @Test
    @DisplayName("divide() works with negative numbers")
    public void testDivideNegative() {
        assertEquals(-5.0, CalculatorBasic.divide(15.0, -3.0));
        assertEquals(5.0, CalculatorBasic.divide(-15.0, -3.0));
    }
}
