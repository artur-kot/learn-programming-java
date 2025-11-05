
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorRefactorTest {

    @Test
    public void testAddition() {
        double result = CalculatorRefactor.add(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    public void testSubtraction() {
        double result = CalculatorRefactor.subtract(10, 3);
        assertEquals(7, result, "10 - 3 should equal 7");
    }

    @Test
    public void testMultiplication() {
        double result = CalculatorRefactor.multiply(4, 5);
        assertEquals(20, result, "4 * 5 should equal 20");
    }

    @Test
    public void testDivision() {
        double result = CalculatorRefactor.divide(20, 4);
        assertEquals(5, result, 0.01, "20 / 4 should equal 5");
    }

    @Test
    public void testDivisionWithDecimals() {
        double result = CalculatorRefactor.divide(7, 2);
        assertEquals(3.5, result, 0.01, "7 / 2 should equal 3.5");
    }

    @Test
    public void testAdditionWithNegatives() {
        double result = CalculatorRefactor.add(-5, 3);
        assertEquals(-2, result, "-5 + 3 should equal -2");
    }

    @Test
    public void testSubtractionNegativeResult() {
        double result = CalculatorRefactor.subtract(3, 10);
        assertEquals(-7, result, "3 - 10 should equal -7");
    }

    @Test
    public void testMultiplicationByZero() {
        double result = CalculatorRefactor.multiply(5, 0);
        assertEquals(0, result, "5 * 0 should equal 0");
    }

    @Test
    public void testIsValidNumberTrue() {
        assertTrue(CalculatorRefactor.isValidNumber(50), "50 should be valid");
        assertTrue(CalculatorRefactor.isValidNumber(0), "0 should be valid");
        assertTrue(CalculatorRefactor.isValidNumber(1000000), "1000000 should be valid");
    }

    @Test
    public void testIsValidNumberFalse() {
        assertFalse(CalculatorRefactor.isValidNumber(-1), "-1 should be invalid");
        assertFalse(CalculatorRefactor.isValidNumber(-100), "-100 should be invalid");
    }

    @Test
    public void testIsValidOperationPlus() {
        assertTrue(CalculatorRefactor.isValidOperation("+"), "+ should be valid");
    }

    @Test
    public void testIsValidOperationMinus() {
        assertTrue(CalculatorRefactor.isValidOperation("-"), "- should be valid");
    }

    @Test
    public void testIsValidOperationMultiply() {
        assertTrue(CalculatorRefactor.isValidOperation("*"), "* should be valid");
    }

    @Test
    public void testIsValidOperationDivide() {
        assertTrue(CalculatorRefactor.isValidOperation("/"), "/ should be valid");
    }

    @Test
    public void testIsValidOperationInvalid() {
        assertFalse(CalculatorRefactor.isValidOperation("^"), "^ should be invalid");
        assertFalse(CalculatorRefactor.isValidOperation("xyz"), "xyz should be invalid");
    }

    @Test
    public void testPerformOperationAdd() {
        double result = CalculatorRefactor.performOperation(5, 3, "+");
        assertEquals(8, result, "Operation + should use add()");
    }

    @Test
    public void testPerformOperationSubtract() {
        double result = CalculatorRefactor.performOperation(10, 3, "-");
        assertEquals(7, result, "Operation - should use subtract()");
    }

    @Test
    public void testPerformOperationMultiply() {
        double result = CalculatorRefactor.performOperation(4, 5, "*");
        assertEquals(20, result, "Operation * should use multiply()");
    }

    @Test
    public void testPerformOperationDivide() {
        double result = CalculatorRefactor.performOperation(20, 4, "/");
        assertEquals(5, result, 0.01, "Operation / should use divide()");
    }

    @Test
    public void testGetNumber() {
        // Simulate user input of "42"
        String input = "42\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        double result = CalculatorRefactor.getNumber(scanner, "Enter number: ");
        assertEquals(42, result, "Should read and return 42");
    }

    @Test
    public void testDisplayMenu() {
        // Just verify the method exists and can be called
        CalculatorRefactor.displayMenu();
        assertTrue(true, "displayMenu() should be callable");
    }
}
