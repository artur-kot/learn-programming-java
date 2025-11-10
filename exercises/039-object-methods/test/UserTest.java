
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
    public void testToStringFormat() {
        restoreOut();
        User user = new User("Alice", 25);
        String result = user.toString();

        assertEquals("User[name=Alice, age=25]", result,
            "toString() should return format: User[name=..., age=...]");
    }

    @Test
    public void testToStringWithDifferentValues() {
        restoreOut();
        User user1 = new User("Bob", 30);
        User user2 = new User("Charlie", 45);

        assertEquals("User[name=Bob, age=30]", user1.toString());
        assertEquals("User[name=Charlie, age=45]", user2.toString());
    }

    @Test
    public void testToStringCalledImplicitly() {
        User user = new User("Diana", 28);
        System.out.println(user);

        String output = outContent.toString().trim();
        restoreOut();

        assertEquals("User[name=Diana, age=28]", output,
            "toString() should be called when printing object");
    }

    @Test
    public void testEqualsWithSameObject() {
        restoreOut();
        User user = new User("Eve", 22);

        assertTrue(user.equals(user),
            "equals() should return true when comparing object to itself");
    }

    @Test
    public void testEqualsWithEqualUsers() {
        restoreOut();
        User user1 = new User("Frank", 35);
        User user2 = new User("Frank", 35);

        assertTrue(user1.equals(user2),
            "equals() should return true for users with same name and age");
        assertTrue(user2.equals(user1),
            "equals() should be symmetric");
    }

    @Test
    public void testEqualsWithDifferentNames() {
        restoreOut();
        User user1 = new User("Grace", 40);
        User user2 = new User("Hannah", 40);

        assertFalse(user1.equals(user2),
            "equals() should return false for users with different names");
    }

    @Test
    public void testEqualsWithDifferentAges() {
        restoreOut();
        User user1 = new User("Iris", 25);
        User user2 = new User("Iris", 26);

        assertFalse(user1.equals(user2),
            "equals() should return false for users with different ages");
    }

    @Test
    public void testEqualsWithNull() {
        restoreOut();
        User user = new User("Jack", 30);

        assertFalse(user.equals(null),
            "equals() should return false when compared to null");
    }

    @Test
    public void testEqualsWithDifferentType() {
        restoreOut();
        User user = new User("Kate", 28);
        String notAUser = "Not a user";

        assertFalse(user.equals(notAUser),
            "equals() should return false when compared to different type");
    }

    @Test
    public void testIsAdultWithAdult() {
        restoreOut();
        User adult = new User("Liam", 25);

        assertTrue(adult.isAdult(),
            "isAdult() should return true for age >= 18");
    }

    @Test
    public void testIsAdultWithMinor() {
        restoreOut();
        User minor = new User("Mia", 16);

        assertFalse(minor.isAdult(),
            "isAdult() should return false for age < 18");
    }

    @Test
    public void testIsAdultBoundary() {
        restoreOut();
        User exactly18 = new User("Noah", 18);

        assertTrue(exactly18.isAdult(),
            "isAdult() should return true for exactly age 18");
    }

    @Test
    public void testCanVoteWithEligibleVoter() {
        restoreOut();
        User voter = new User("Olivia", 30);

        assertTrue(voter.canVote(),
            "canVote() should return true for age >= 18");
    }

    @Test
    public void testCanVoteWithNonEligible() {
        restoreOut();
        User young = new User("Peter", 15);

        assertFalse(young.canVote(),
            "canVote() should return false for age < 18");
    }

    @Test
    public void testCanVoteBoundary() {
        restoreOut();
        User exactly18 = new User("Quinn", 18);

        assertTrue(exactly18.canVote(),
            "canVote() should return true for exactly age 18");
    }

    @Test
    public void testGetBirthYear() {
        restoreOut();
        User user25 = new User("Rachel", 25);
        User user30 = new User("Sam", 30);
        User user50 = new User("Tom", 50);

        assertEquals(1999, user25.getBirthYear(),
            "getBirthYear() should return 2024 - age");
        assertEquals(1994, user30.getBirthYear(),
            "getBirthYear() should return 2024 - age");
        assertEquals(1974, user50.getBirthYear(),
            "getBirthYear() should return 2024 - age");
    }

    @Test
    public void testGetBirthYearWithYoungUser() {
        restoreOut();
        User baby = new User("Baby", 1);

        assertEquals(2023, baby.getBirthYear(),
            "getBirthYear() should handle young ages correctly");
    }

    @Test
    public void testAllMethodsTogether() {
        restoreOut();
        User user1 = new User("Uma", 20);
        User user2 = new User("Uma", 20);

        // Test toString
        assertEquals("User[name=Uma, age=20]", user1.toString());

        // Test equals
        assertTrue(user1.equals(user2));

        // Test custom methods
        assertTrue(user1.isAdult());
        assertTrue(user1.canVote());
        assertEquals(2004, user1.getBirthYear());
    }

    @Test
    public void testEncapsulationStillMaintained() {
        restoreOut();
        User user = new User("Victor", 35);

        // Setters should still validate
        user.setAge(-5);
        assertEquals(35, user.getAge(),
            "setAge() should still reject negative values");

        user.setName("");
        assertEquals("Victor", user.getName(),
            "setName() should still reject empty strings");
    }
}
