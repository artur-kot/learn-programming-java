
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MethodsBasicsTest {

    @Test
    public void testIsValidEmailWithValidEmail() {
        assertTrue(MethodsBasics.isValidEmail("alice@example.com"),
                "alice@example.com should be valid");
    }

    @Test
    public void testIsValidEmailMissingAt() {
        assertFalse(MethodsBasics.isValidEmail("aliceexample.com"),
                "Email without @ should be invalid");
    }

    @Test
    public void testIsValidEmailMissingDot() {
        assertFalse(MethodsBasics.isValidEmail("alice@examplecom"),
                "Email without . should be invalid");
    }

    @Test
    public void testIsValidEmailValid() {
        assertTrue(MethodsBasics.isValidEmail("bob@test.co.uk"),
                "bob@test.co.uk should be valid");
    }

    @Test
    public void testReverseStringSimple() {
        assertEquals("olleh", MethodsBasics.reverseString("hello"),
                "Reverse of 'hello' should be 'olleh'");
    }

    @Test
    public void testReverseStringSingleChar() {
        assertEquals("a", MethodsBasics.reverseString("a"),
                "Reverse of 'a' should be 'a'");
    }

    @Test
    public void testReverseStringEmpty() {
        assertEquals("", MethodsBasics.reverseString(""),
                "Reverse of empty string should be empty");
    }

    @Test
    public void testReverseStringMultiWord() {
        assertEquals("avaJ", MethodsBasics.reverseString("Java"),
                "Reverse of 'Java' should be 'avaJ'");
    }
}
