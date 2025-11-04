
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator - Advanced Math Tests")
public class CalculatorAdvancedMathTest {

    @Test
    @DisplayName("modulo() returns correct remainder")
    public void testModuloBasic() {
        assertEquals(1, CalculatorAdvancedMath.modulo(10, 3));
        assertEquals(0, CalculatorAdvancedMath.modulo(10, 2));
    }

    @Test
    @DisplayName("modulo() works with large numbers")
    public void testModuloLarge() {
        assertEquals(3, CalculatorAdvancedMath.modulo(103, 10));
        assertEquals(0, CalculatorAdvancedMath.modulo(100, 25));
    }

    @Test
    @DisplayName("modulo() is useful for checking even/odd")
    public void testModuloEvenOdd() {
        // Even numbers have remainder 0
        assertEquals(0, CalculatorAdvancedMath.modulo(4, 2));
        // Odd numbers have remainder 1
        assertEquals(1, CalculatorAdvancedMath.modulo(7, 2));
    }

    @Test
    @DisplayName("power() returns correct exponentiation")
    public void testPowerBasic() {
        assertEquals(8.0, CalculatorAdvancedMath.power(2, 3));
        assertEquals(25.0, CalculatorAdvancedMath.power(5, 2));
    }

    @Test
    @DisplayName("power() handles exponent of 0")
    public void testPowerZeroExponent() {
        assertEquals(1.0, CalculatorAdvancedMath.power(10, 0));
        assertEquals(1.0, CalculatorAdvancedMath.power(5, 0));
    }

    @Test
    @DisplayName("power() handles exponent of 1")
    public void testPowerOneExponent() {
        assertEquals(7.0, CalculatorAdvancedMath.power(7, 1));
        assertEquals(100.0, CalculatorAdvancedMath.power(100, 1));
    }

    @Test
    @DisplayName("power() works with decimal bases and exponents")
    public void testPowerDecimal() {
        assertEquals(2.25, CalculatorAdvancedMath.power(1.5, 2), 0.0001);
        assertEquals(8.0, CalculatorAdvancedMath.power(2.0, 3.0));
    }

    @Test
    @DisplayName("squareRoot() returns correct result")
    public void testSquareRootBasic() {
        assertEquals(4.0, CalculatorAdvancedMath.squareRoot(16));
        assertEquals(5.0, CalculatorAdvancedMath.squareRoot(25));
    }

    @Test
    @DisplayName("squareRoot() works with decimal results")
    public void testSquareRootDecimal() {
        assertEquals(3.0, CalculatorAdvancedMath.squareRoot(9));
        assertEquals(2.0, CalculatorAdvancedMath.squareRoot(4));
    }

    @Test
    @DisplayName("squareRoot() handles square root of 1 and 0")
    public void testSquareRootEdgeCases() {
        assertEquals(1.0, CalculatorAdvancedMath.squareRoot(1));
        assertEquals(0.0, CalculatorAdvancedMath.squareRoot(0));
    }

    @Test
    @DisplayName("squareRoot() approximates irrational results")
    public void testSquareRootIrrational() {
        // √2 ≈ 1.414
        assertEquals(Math.sqrt(2), CalculatorAdvancedMath.squareRoot(2), 0.0001);
        // √10 ≈ 3.162
        assertEquals(Math.sqrt(10), CalculatorAdvancedMath.squareRoot(10), 0.0001);
    }
}
