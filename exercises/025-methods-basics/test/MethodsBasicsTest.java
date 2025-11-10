import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MethodsBasicsTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // ============ Tests for printGreeting() ============

    @Test
    public void testPrintGreetingOutput() {
        MethodsBasics.printGreeting();
        String output = outputStream.toString();
        assertTrue(output.contains("Welcome to Java Methods!"),
                "printGreeting() should print 'Welcome to Java Methods!'");
    }

    @Test
    public void testPrintGreetingHasNewline() {
        MethodsBasics.printGreeting();
        String output = outputStream.toString();
        assertTrue(output.trim().length() > 0,
                "printGreeting() should print something");
    }

    // ============ Tests for greet(String name) ============

    @Test
    public void testGreetWithAlice() {
        MethodsBasics.greet("Alice");
        String output = outputStream.toString();
        assertTrue(output.contains("Hello, Alice!"),
                "greet(\"Alice\") should print 'Hello, Alice!'");
    }

    @Test
    public void testGreetWithBob() {
        MethodsBasics.greet("Bob");
        String output = outputStream.toString();
        assertTrue(output.contains("Hello, Bob!"),
                "greet(\"Bob\") should print 'Hello, Bob!'");
    }

    @Test
    public void testGreetWithDifferentNames() {
        outputStream.reset();
        MethodsBasics.greet("Charlie");
        String output = outputStream.toString();
        assertTrue(output.contains("Hello, Charlie!"),
                "greet() should work with any name");
    }

    // ============ Tests for add(int a, int b) ============

    @Test
    public void testAddPositiveNumbers() {
        assertEquals(15, MethodsBasics.add(10, 5),
                "add(10, 5) should return 15");
    }

    @Test
    public void testAddWithZero() {
        assertEquals(7, MethodsBasics.add(7, 0),
                "add(7, 0) should return 7");
    }

    @Test
    public void testAddNegativeNumbers() {
        assertEquals(-3, MethodsBasics.add(-5, 2),
                "add(-5, 2) should return -3");
    }

    @Test
    public void testAddTwoNegatives() {
        assertEquals(-10, MethodsBasics.add(-3, -7),
                "add(-3, -7) should return -10");
    }

    // ============ Tests for multiply(int a, int b) ============

    @Test
    public void testMultiplyPositiveNumbers() {
        assertEquals(24, MethodsBasics.multiply(6, 4),
                "multiply(6, 4) should return 24");
    }

    @Test
    public void testMultiplyByZero() {
        assertEquals(0, MethodsBasics.multiply(5, 0),
                "multiply(5, 0) should return 0");
    }

    @Test
    public void testMultiplyByOne() {
        assertEquals(8, MethodsBasics.multiply(8, 1),
                "multiply(8, 1) should return 8");
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        assertEquals(-20, MethodsBasics.multiply(4, -5),
                "multiply(4, -5) should return -20");
    }

    // ============ Tests for isEven(int number) ============

    @Test
    public void testIsEvenWithEvenNumber() {
        assertTrue(MethodsBasics.isEven(10),
                "isEven(10) should return true");
    }

    @Test
    public void testIsEvenWithOddNumber() {
        assertFalse(MethodsBasics.isEven(7),
                "isEven(7) should return false");
    }

    @Test
    public void testIsEvenWithZero() {
        assertTrue(MethodsBasics.isEven(0),
                "isEven(0) should return true (zero is even)");
    }

    @Test
    public void testIsEvenWithNegativeEven() {
        assertTrue(MethodsBasics.isEven(-4),
                "isEven(-4) should return true");
    }

    @Test
    public void testIsEvenWithNegativeOdd() {
        assertFalse(MethodsBasics.isEven(-3),
                "isEven(-3) should return false");
    }

    @Test
    public void testIsEvenWithTwo() {
        assertTrue(MethodsBasics.isEven(2),
                "isEven(2) should return true");
    }

    @Test
    public void testIsEvenWithOne() {
        assertFalse(MethodsBasics.isEven(1),
                "isEven(1) should return false");
    }

    // ============ Tests for getFullName(String firstName, String lastName) ============

    @Test
    public void testGetFullNameJohnDoe() {
        assertEquals("John Doe", MethodsBasics.getFullName("John", "Doe"),
                "getFullName(\"John\", \"Doe\") should return \"John Doe\"");
    }

    @Test
    public void testGetFullNameAliceSmith() {
        assertEquals("Alice Smith", MethodsBasics.getFullName("Alice", "Smith"),
                "getFullName(\"Alice\", \"Smith\") should return \"Alice Smith\"");
    }

    @Test
    public void testGetFullNameWithSingleCharacter() {
        assertEquals("A B", MethodsBasics.getFullName("A", "B"),
                "getFullName should work with single character names");
    }

    @Test
    public void testGetFullNameHasSpace() {
        String fullName = MethodsBasics.getFullName("Jane", "Johnson");
        assertTrue(fullName.contains(" "),
                "Full name should contain a space between first and last name");
    }

    @Test
    public void testGetFullNameDifferentNames() {
        assertEquals("Bob Wilson", MethodsBasics.getFullName("Bob", "Wilson"),
                "getFullName should work with any names");
    }
}
