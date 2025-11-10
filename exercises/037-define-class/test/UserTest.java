
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

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
    public void testUserConstructorAndFields() {
        restoreOut();
        User user = new User("Alice", 25);

        assertEquals("Alice", user.name, "Constructor should initialize name field");
        assertEquals(25, user.age, "Constructor should initialize age field");
    }

    @Test
    public void testGetName() {
        restoreOut();
        User user = new User("Bob", 30);

        assertEquals("Bob", user.getName(), "getName() should return the name field");
    }

    @Test
    public void testGetAge() {
        restoreOut();
        User user = new User("Charlie", 35);

        assertEquals(35, user.getAge(), "getAge() should return the age field");
    }

    @Test
    public void testDisplayInfo() {
        User user = new User("Diana", 28);
        user.displayInfo();

        String output = outContent.toString().trim();
        restoreOut();

        assertTrue(output.contains("Diana"), "displayInfo() should print the name");
        assertTrue(output.contains("28"), "displayInfo() should print the age");
        assertTrue(output.toLowerCase().contains("name"), "displayInfo() should include 'Name:' label");
        assertTrue(output.toLowerCase().contains("age"), "displayInfo() should include 'Age:' label");
    }

    @Test
    public void testDisplayInfoFormat() {
        User user = new User("Eve", 22);
        user.displayInfo();

        String output = outContent.toString().trim();
        restoreOut();

        assertEquals("Name: Eve, Age: 22", output,
            "displayInfo() should print in format: 'Name: [name], Age: [age]'");
    }

    @Test
    public void testMultipleUserObjectsIndependent() {
        restoreOut();
        User user1 = new User("Frank", 40);
        User user2 = new User("Grace", 50);

        assertEquals("Frank", user1.getName(), "First user should have correct name");
        assertEquals(40, user1.getAge(), "First user should have correct age");
        assertEquals("Grace", user2.getName(), "Second user should have correct name");
        assertEquals(50, user2.getAge(), "Second user should have correct age");
    }

    @Test
    public void testConstructorWithDifferentValues() {
        restoreOut();
        User youngUser = new User("Alice", 18);
        User oldUser = new User("Bob", 99);

        assertEquals(18, youngUser.getAge(), "Young user should have age 18");
        assertEquals(99, oldUser.getAge(), "Old user should have age 99");
    }

    @Test
    public void testNameFieldIsString() {
        restoreOut();
        User user = new User("Test User", 25);

        assertTrue(user.getName() instanceof String, "getName() should return a String");
    }

    @Test
    public void testAgeFieldIsInt() {
        restoreOut();
        User user = new User("Test", 25);

        assertEquals(Integer.class, Integer.valueOf(user.getAge()).getClass(),
            "getAge() should return an int");
    }
}
