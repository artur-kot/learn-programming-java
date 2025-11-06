
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MethodOverloadingTest {

    // Tests for overloaded add methods
    @Test
    public void testAddIntInt() {
        int result = MethodOverloading.add(5, 3);
        assertEquals(8, result, "add(5, 3) should equal 8");
    }

    @Test
    public void testAddIntIntNegative() {
        int result = MethodOverloading.add(-5, 3);
        assertEquals(-2, result, "add(-5, 3) should equal -2");
    }

    @Test
    public void testAddDoubleDouble() {
        double result = MethodOverloading.add(5.5, 3.2);
        assertEquals(8.7, result, 0.01, "add(5.5, 3.2) should equal 8.7");
    }

    @Test
    public void testAddDoubleDoubleNegative() {
        double result = MethodOverloading.add(-5.5, 3.2);
        assertEquals(-2.3, result, 0.01, "add(-5.5, 3.2) should equal -2.3");
    }

    // Tests for overloaded greet methods
    @Test
    public void testGreetString() {
        String result = MethodOverloading.greet("Alice");
        assertTrue(result.contains("Alice"),
                "Greeting should include the name");
    }

    @Test
    public void testGreetStringDifferent() {
        String result = MethodOverloading.greet("Bob");
        assertTrue(result.contains("Bob"),
                "Greeting should include the name");
    }

    @Test
    public void testGreetStringInt() {
        String result = MethodOverloading.greet("Charlie", 25);
        assertTrue(result.contains("Charlie"),
                "Greeting should include the name");
        assertTrue(result.contains("25"),
                "Greeting should include the age");
    }

    @Test
    public void testGreetStringIntDifferent() {
        String result = MethodOverloading.greet("Diana", 30);
        assertTrue(result.contains("Diana"),
                "Greeting should include the name");
        assertTrue(result.contains("30"),
                "Greeting should include the age");
    }
}
