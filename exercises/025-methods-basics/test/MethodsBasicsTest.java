
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MethodsBasicsTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrintBoundary() {
        MethodsBasics.printBoundary();
        String output = outContent.toString();
        assertTrue(output.length() > 0, "printBoundary should print something");
        assertTrue(output.contains("=") || output.contains("-"),
                "Boundary should contain separator characters");
    }

    @Test
    public void testPrintWelcome() {
        MethodsBasics.printWelcome();
        String output = outContent.toString();
        assertTrue(output.length() > 0, "printWelcome should print something");
    }

    @Test
    public void testGreet() {
        MethodsBasics.greet("Alice");
        String output = outContent.toString();
        assertTrue(output.contains("Alice"), "Greeting should include the name");
    }

    @Test
    public void testPrintMultipleTimes() {
        MethodsBasics.printMultipleTimes("Test", 3);
        String output = outContent.toString();
        assertTrue(output.contains("Test"), "Should contain the message");
        // Count occurrences (rough check)
        int count = output.split("Test").length - 1;
        assertEquals(3, count, "Message should be printed 3 times");
    }

    @Test
    public void testCalculateArea() {
        MethodsBasics.calculateArea(5, 3);
        String output = outContent.toString();
        assertTrue(output.contains("15") || output.contains("area"),
                "Should calculate and print area (5 * 3 = 15)");
    }

    @Test
    public void testAdd() {
        int result = MethodsBasics.add(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    public void testAddWithNegatives() {
        int result = MethodsBasics.add(-5, 3);
        assertEquals(-2, result, "-5 + 3 should equal -2");
    }

    @Test
    public void testSubtract() {
        int result = MethodsBasics.subtract(10, 3);
        assertEquals(7, result, "10 - 3 should equal 7");
    }

    @Test
    public void testMultiply() {
        int result = MethodsBasics.multiply(4, 5);
        assertEquals(20, result, "4 * 5 should equal 20");
    }

    @Test
    public void testDivide() {
        int result = MethodsBasics.divide(20, 4);
        assertEquals(5, result, "20 / 4 should equal 5");
    }

    @Test
    public void testGetFullName() {
        String result = MethodsBasics.getFullName("John", "Doe");
        assertEquals("John Doe", result, "Should concatenate first and last name");
    }

    @Test
    public void testGetFullNameDifferent() {
        String result = MethodsBasics.getFullName("Alice", "Smith");
        assertEquals("Alice Smith", result, "Should concatenate correctly");
    }
}
