
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@DisplayName("Calculator - User Input Tests")
public class CalculatorUserInputTest {

    @Test
    @DisplayName("Calculator performs all four operations correctly")
    public void testCalculatorWithUserInput() {
        // Simulate user input: 20 and 4
        String input = "20\n4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // This test verifies the methods work correctly
        // The actual user interaction is tested through expected behavior
        assertEquals(24, CalculatorUserInput.add(20, 4));
        assertEquals(16, CalculatorUserInput.subtract(20, 4));
        assertEquals(80, CalculatorUserInput.multiply(20, 4));
        assertEquals(5.0, CalculatorUserInput.divide(20.0, 4.0));
    }

    @Test
    @DisplayName("add() method works correctly")
    public void testAdd() {
        assertEquals(10, CalculatorUserInput.add(5, 5));
        assertEquals(0, CalculatorUserInput.add(-5, 5));
    }

    @Test
    @DisplayName("subtract() method works correctly")
    public void testSubtract() {
        assertEquals(10, CalculatorUserInput.subtract(15, 5));
        assertEquals(-10, CalculatorUserInput.subtract(5, 15));
    }

    @Test
    @DisplayName("multiply() method works correctly")
    public void testMultiply() {
        assertEquals(50, CalculatorUserInput.multiply(10, 5));
        assertEquals(0, CalculatorUserInput.multiply(0, 100));
    }

    @Test
    @DisplayName("divide() method works correctly")
    public void testDivide() {
        assertEquals(2.5, CalculatorUserInput.divide(10.0, 4.0));
        assertEquals(1.0, CalculatorUserInput.divide(5.0, 5.0));
    }
}
