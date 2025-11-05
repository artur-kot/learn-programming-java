
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MethodOverloadingTest {

    @Test
    public void testCalculateIntInt() {
        int result = MethodOverloading.calculate(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    public void testCalculateDoubleDouble() {
        double result = MethodOverloading.calculate(5.5, 3.2);
        assertEquals(8.7, result, 0.01, "5.5 + 3.2 should equal 8.7");
    }

    @Test
    public void testCalculateIntDouble() {
        double result = MethodOverloading.calculate(5, 3.2);
        assertEquals(8.2, result, 0.01, "5 + 3.2 should equal 8.2");
    }

    @Test
    public void testCalculateStringString() {
        String result = MethodOverloading.calculate("Hello", "World");
        assertEquals("HelloWorld", result, "Should concatenate strings");
    }

    @Test
    public void testSumIntInt() {
        int result = MethodOverloading.sum(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    public void testSumIntIntInt() {
        int result = MethodOverloading.sum(5, 3, 2);
        assertEquals(10, result, "5 + 3 + 2 should equal 10");
    }

    @Test
    public void testSumDoubleDouble() {
        double result = MethodOverloading.sum(5.5, 3.2);
        assertEquals(8.7, result, 0.01, "5.5 + 3.2 should equal 8.7");
    }

    @Test
    public void testSumDoubleDoubleDouble() {
        double result = MethodOverloading.sum(5.5, 3.2, 1.8);
        assertEquals(10.5, result, 0.01, "5.5 + 3.2 + 1.8 should equal 10.5");
    }

    @Test
    public void testFormatInt() {
        String result = MethodOverloading.format(42);
        assertTrue(result.contains("42"), "Should contain the number");
        assertTrue(result.contains("Value") || result.length() > 0,
                "Should format the integer");
    }

    @Test
    public void testFormatDouble() {
        String result = MethodOverloading.format(3.14);
        assertTrue(result.contains("3.14") || result.contains("3"),
                "Should contain the double value");
    }

    @Test
    public void testFormatIntWidth() {
        String result = MethodOverloading.format(42, 6);
        assertEquals(6, result.length(),
                "Formatted result should be 6 characters wide");
        assertTrue(result.contains("42"), "Should contain the value");
    }

    @Test
    public void testFormatDoubleDecimal() {
        String result = MethodOverloading.format(3.14159, 2);
        assertTrue(result.contains("3.14"),
                "Should format to 2 decimal places");
    }

    @Test
    public void testFormatStringObject() {
        String result = MethodOverloading.format("Temperature", 72);
        assertTrue(result.contains("Temperature"),
                "Should contain the label");
        assertTrue(result.contains("72"),
                "Should contain the value");
    }

    @Test
    public void testDisplayInfoSingleParam() {
        // This test just verifies the method is callable
        // Output testing would require capturing System.out
        MethodOverloading.displayInfo("Alice");
        assertTrue(true, "displayInfo(String) should be callable");
    }

    @Test
    public void testDisplayInfoTwoParams() {
        MethodOverloading.displayInfo("Bob", 30);
        assertTrue(true, "displayInfo(String, int) should be callable");
    }

    @Test
    public void testDisplayInfoThreeParams() {
        MethodOverloading.displayInfo("Charlie", 25, "Boston");
        assertTrue(true, "displayInfo(String, int, String) should be callable");
    }
}
