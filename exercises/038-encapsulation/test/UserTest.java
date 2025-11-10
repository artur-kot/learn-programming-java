
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class UserTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    private void restoreOut() {
        System.setOut(originalOut);
    }

    @Test
    public void testFieldsArePrivate() throws NoSuchFieldException {
        restoreOut();
        Field nameField = User.class.getDeclaredField("name");
        Field ageField = User.class.getDeclaredField("age");

        assertTrue(Modifier.isPrivate(nameField.getModifiers()),
            "name field should be private");
        assertTrue(Modifier.isPrivate(ageField.getModifiers()),
            "age field should be private");
    }

    @Test
    public void testConstructorWithValidData() {
        restoreOut();
        User user = new User("Alice", 25);

        assertEquals("Alice", user.getName(), "Constructor should set valid name");
        assertEquals(25, user.getAge(), "Constructor should set valid age");
    }

    @Test
    public void testConstructorWithNullName() {
        restoreOut();
        User user = new User(null, 30);

        assertEquals("Unknown", user.getName(),
            "Constructor should set name to 'Unknown' when null");
    }

    @Test
    public void testConstructorWithEmptyName() {
        restoreOut();
        User user = new User("", 30);

        assertEquals("Unknown", user.getName(),
            "Constructor should set name to 'Unknown' when empty");
    }

    @Test
    public void testConstructorWithNegativeAge() {
        restoreOut();
        User user = new User("Bob", -5);

        assertEquals(0, user.getAge(),
            "Constructor should set age to 0 when negative");
    }

    @Test
    public void testConstructorWithBothInvalidInputs() {
        restoreOut();
        User user = new User("", -10);

        assertEquals("Unknown", user.getName(),
            "Constructor should correct invalid name");
        assertEquals(0, user.getAge(),
            "Constructor should correct invalid age");
    }

    @Test
    public void testSetNameWithValidName() {
        restoreOut();
        User user = new User("Alice", 25);
        user.setName("Alicia");

        assertEquals("Alicia", user.getName(),
            "setName() should update name with valid input");
    }

    @Test
    public void testSetNameWithNullRejectsChange() {
        restoreOut();
        User user = new User("Bob", 30);
        user.setName(null);

        assertEquals("Bob", user.getName(),
            "setName() should reject null and keep original name");
    }

    @Test
    public void testSetNameWithEmptyStringRejectsChange() {
        restoreOut();
        User user = new User("Charlie", 35);
        user.setName("");

        assertEquals("Charlie", user.getName(),
            "setName() should reject empty string and keep original name");
    }

    @Test
    public void testSetAgeWithValidAge() {
        restoreOut();
        User user = new User("Diana", 28);
        user.setAge(29);

        assertEquals(29, user.getAge(),
            "setAge() should update age with valid input");
    }

    @Test
    public void testSetAgeWithNegativeRejectsChange() {
        restoreOut();
        User user = new User("Eve", 40);
        user.setAge(-5);

        assertEquals(40, user.getAge(),
            "setAge() should reject negative values and keep original age");
    }

    @Test
    public void testSetAgeWithZero() {
        restoreOut();
        User user = new User("Frank", 50);
        user.setAge(0);

        assertEquals(0, user.getAge(),
            "setAge() should accept 0 as a valid age");
    }

    @Test
    public void testMultipleSetterCalls() {
        restoreOut();
        User user = new User("Grace", 22);

        user.setName("Gracie");
        user.setAge(23);
        assertEquals("Gracie", user.getName(),
            "Name should be updated after valid setName()");
        assertEquals(23, user.getAge(),
            "Age should be updated after valid setAge()");

        user.setName("");  // Invalid - should be rejected
        user.setAge(-1);   // Invalid - should be rejected
        assertEquals("Gracie", user.getName(),
            "Name should remain unchanged after invalid setName()");
        assertEquals(23, user.getAge(),
            "Age should remain unchanged after invalid setAge()");
    }

    @Test
    public void testDisplayInfo() {
        User user = new User("Henry", 45);
        user.displayInfo();

        String output = outContent.toString().trim();
        restoreOut();

        assertTrue(output.contains("Henry"), "displayInfo() should print the name");
        assertTrue(output.contains("45"), "displayInfo() should print the age");
    }

    @Test
    public void testGettersReturnCurrentValues() {
        restoreOut();
        User user = new User("Iris", 30);

        assertEquals("Iris", user.getName(), "getName() should return current name");
        assertEquals(30, user.getAge(), "getAge() should return current age");

        user.setName("Isabella");
        user.setAge(31);

        assertEquals("Isabella", user.getName(),
            "getName() should return updated name");
        assertEquals(31, user.getAge(),
            "getAge() should return updated age");
    }
}
