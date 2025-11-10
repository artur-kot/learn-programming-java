import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test suite for Calculator Refactor exercise
 *
 * These tests verify that:
 * 1. Each extracted method exists and works correctly
 * 2. Math operations produce correct results
 * 3. Division by zero is handled properly
 * 4. Menu display and operation execution work as expected
 */
public class CalculatorRefactorTest {

    /**
     * Test 1: Verify add() method exists and works correctly
     */
    @Test
    public void testAddMethod() {
        // Test positive numbers
        assertEquals(15.0, CalculatorRefactor.add(10.0, 5.0), 0.001,
            "add(10.0, 5.0) should return 15.0");

        // Test negative numbers
        assertEquals(-5.0, CalculatorRefactor.add(-10.0, 5.0), 0.001,
            "add(-10.0, 5.0) should return -5.0");

        // Test decimals
        assertEquals(7.7, CalculatorRefactor.add(3.2, 4.5), 0.001,
            "add(3.2, 4.5) should return 7.7");

        // Test zero
        assertEquals(5.0, CalculatorRefactor.add(0.0, 5.0), 0.001,
            "add(0.0, 5.0) should return 5.0");
    }

    /**
     * Test 2: Verify subtract() method exists and works correctly
     */
    @Test
    public void testSubtractMethod() {
        // Test positive result
        assertEquals(5.0, CalculatorRefactor.subtract(10.0, 5.0), 0.001,
            "subtract(10.0, 5.0) should return 5.0");

        // Test negative result
        assertEquals(-15.0, CalculatorRefactor.subtract(-10.0, 5.0), 0.001,
            "subtract(-10.0, 5.0) should return -15.0");

        // Test decimals
        assertEquals(1.3, CalculatorRefactor.subtract(4.5, 3.2), 0.001,
            "subtract(4.5, 3.2) should return 1.3");

        // Test zero
        assertEquals(-5.0, CalculatorRefactor.subtract(0.0, 5.0), 0.001,
            "subtract(0.0, 5.0) should return -5.0");
    }

    /**
     * Test 3: Verify multiply() method exists and works correctly
     */
    @Test
    public void testMultiplyMethod() {
        // Test positive numbers
        assertEquals(50.0, CalculatorRefactor.multiply(10.0, 5.0), 0.001,
            "multiply(10.0, 5.0) should return 50.0");

        // Test negative numbers
        assertEquals(-50.0, CalculatorRefactor.multiply(-10.0, 5.0), 0.001,
            "multiply(-10.0, 5.0) should return -50.0");

        // Test decimals
        assertEquals(14.4, CalculatorRefactor.multiply(3.2, 4.5), 0.001,
            "multiply(3.2, 4.5) should return 14.4");

        // Test zero
        assertEquals(0.0, CalculatorRefactor.multiply(0.0, 5.0), 0.001,
            "multiply(0.0, 5.0) should return 0.0");
    }

    /**
     * Test 4: Verify divide() method exists and works correctly
     */
    @Test
    public void testDivideMethod() {
        // Test normal division
        assertEquals(2.0, CalculatorRefactor.divide(10.0, 5.0), 0.001,
            "divide(10.0, 5.0) should return 2.0");

        // Test negative numbers
        assertEquals(-2.0, CalculatorRefactor.divide(-10.0, 5.0), 0.001,
            "divide(-10.0, 5.0) should return -2.0");

        // Test decimals
        assertEquals(0.711, CalculatorRefactor.divide(3.2, 4.5), 0.01,
            "divide(3.2, 4.5) should return approximately 0.711");

        // Test division by 1
        assertEquals(5.0, CalculatorRefactor.divide(5.0, 1.0), 0.001,
            "divide(5.0, 1.0) should return 5.0");
    }

    /**
     * Test 5: Verify divide() handles division by zero
     */
    @Test
    public void testDivideByZero() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        double result = CalculatorRefactor.divide(10.0, 0.0);

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertEquals(0.0, result, 0.001,
            "divide(10.0, 0.0) should return 0.0 when dividing by zero");
        assertTrue(output.toLowerCase().contains("error") || output.toLowerCase().contains("cannot") || output.toLowerCase().contains("zero"),
            "divide() should print an error message when dividing by zero");
    }

    /**
     * Test 6: Verify displayMenu() method exists and outputs menu
     */
    @Test
    public void testDisplayMenu() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        CalculatorRefactor.displayMenu();

        System.setOut(originalOut);
        String output = outputStream.toString().toLowerCase();

        assertTrue(output.contains("add"), "Menu should contain 'add' option");
        assertTrue(output.contains("subtract"), "Menu should contain 'subtract' option");
        assertTrue(output.contains("multiply"), "Menu should contain 'multiply' option");
        assertTrue(output.contains("divide"), "Menu should contain 'divide' option");
        assertTrue(output.contains("exit"), "Menu should contain 'exit' option");
    }

    /**
     * Test 7: Verify getNumberInput() method exists
     */
    @Test
    public void testGetNumberInputMethodExists() {
        // We can't fully test input methods without mocking Scanner,
        // but we can verify the method exists and has correct signature
        try {
            java.lang.reflect.Method method = CalculatorRefactor.class.getMethod("getNumberInput", String.class);
            assertEquals(double.class, method.getReturnType(),
                "getNumberInput() should return a double");
        } catch (NoSuchMethodException e) {
            fail("getNumberInput(String) method should exist");
        }
    }

    /**
     * Test 8: Verify performOperation() method handles addition
     */
    @Test
    public void testPerformOperationAddition() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        CalculatorRefactor.performOperation(1, 10.0, 5.0);

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains("15.0") || output.contains("15"),
            "performOperation(1, 10.0, 5.0) should display result 15.0");
    }

    /**
     * Test 9: Verify performOperation() method handles subtraction
     */
    @Test
    public void testPerformOperationSubtraction() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        CalculatorRefactor.performOperation(2, 10.0, 5.0);

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains("5.0") || output.contains("5"),
            "performOperation(2, 10.0, 5.0) should display result 5.0");
    }

    /**
     * Test 10: Verify performOperation() method handles multiplication
     */
    @Test
    public void testPerformOperationMultiplication() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        CalculatorRefactor.performOperation(3, 10.0, 5.0);

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains("50.0") || output.contains("50"),
            "performOperation(3, 10.0, 5.0) should display result 50.0");
    }

    /**
     * Test 11: Verify performOperation() method handles division
     */
    @Test
    public void testPerformOperationDivision() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        CalculatorRefactor.performOperation(4, 10.0, 5.0);

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains("2.0") || output.contains("2"),
            "performOperation(4, 10.0, 5.0) should display result 2.0");
    }

    /**
     * Test 12: Verify performOperation() handles division by zero
     */
    @Test
    public void testPerformOperationDivisionByZero() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        CalculatorRefactor.performOperation(4, 10.0, 0.0);

        System.setOut(originalOut);
        String output = outputStream.toString().toLowerCase();

        assertTrue(output.contains("error") || output.contains("cannot") || output.contains("zero"),
            "performOperation(4, 10.0, 0.0) should display error for division by zero");
    }

    /**
     * Test 13: Verify math operations maintain precision
     */
    @Test
    public void testMathOperationsPrecision() {
        // Test that operations handle decimal precision correctly
        assertEquals(0.3, CalculatorRefactor.add(0.1, 0.2), 0.001,
            "add(0.1, 0.2) should handle decimal precision");

        assertEquals(7.5, CalculatorRefactor.multiply(2.5, 3.0), 0.001,
            "multiply(2.5, 3.0) should return 7.5");

        assertEquals(3.333, CalculatorRefactor.divide(10.0, 3.0), 0.01,
            "divide(10.0, 3.0) should return approximately 3.333");
    }

    /**
     * Test 14: Verify edge cases for operations
     */
    @Test
    public void testEdgeCases() {
        // Test with very large numbers
        assertEquals(2000000.0, CalculatorRefactor.add(1000000.0, 1000000.0), 0.001,
            "add() should handle large numbers");

        // Test with very small numbers
        assertEquals(0.0002, CalculatorRefactor.add(0.0001, 0.0001), 0.0001,
            "add() should handle small decimals");

        // Test negative division
        assertEquals(-2.0, CalculatorRefactor.divide(-10.0, 5.0), 0.001,
            "divide() should handle negative numbers correctly");
    }
}
