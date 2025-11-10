
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class UserManagerTest {

    private UserManager manager;

    @BeforeEach
    public void setUp() {
        manager = new UserManager();
    }

    @Test
    public void testAddUserAndGetCount() {
        manager.addUser(new User("Alice", 25));
        assertEquals(1, manager.getUserCount(),
            "getUserCount() should return 1 after adding one user");

        manager.addUser(new User("Bob", 30));
        assertEquals(2, manager.getUserCount(),
            "getUserCount() should return 2 after adding two users");
    }

    @Test
    public void testAddNullUserDoesNotAdd() {
        manager.addUser(new User("Alice", 25));
        manager.addUser(null);

        assertEquals(1, manager.getUserCount(),
            "Adding null user should not increase count");
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User("Alice", 25);
        User user2 = new User("Bob", 30);

        manager.addUser(user1);
        manager.addUser(user2);

        ArrayList<User> allUsers = manager.getAllUsers();
        assertEquals(2, allUsers.size(),
            "getAllUsers() should return all added users");
        assertTrue(allUsers.contains(user1),
            "getAllUsers() should contain first user");
        assertTrue(allUsers.contains(user2),
            "getAllUsers() should contain second user");
    }

    @Test
    public void testFindByNameExists() {
        manager.addUser(new User("Alice", 25));
        manager.addUser(new User("Bob", 30));
        manager.addUser(new User("Charlie", 35));

        User found = manager.findByName("Bob");
        assertNotNull(found, "findByName() should find existing user");
        assertEquals("Bob", found.getName(),
            "findByName() should return user with correct name");
        assertEquals(30, found.getAge(),
            "findByName() should return user with correct age");
    }

    @Test
    public void testFindByNameNotExists() {
        manager.addUser(new User("Alice", 25));
        manager.addUser(new User("Bob", 30));

        User notFound = manager.findByName("Charlie");
        assertNull(notFound,
            "findByName() should return null for non-existent user");
    }

    @Test
    public void testFindByNameEmptyList() {
        User notFound = manager.findByName("Alice");
        assertNull(notFound,
            "findByName() should return null when list is empty");
    }

    @Test
    public void testFilterByAgeRangeMultipleMatches() {
        manager.addUser(new User("Alice", 25));
        manager.addUser(new User("Bob", 30));
        manager.addUser(new User("Charlie", 20));
        manager.addUser(new User("Diana", 35));

        ArrayList<User> filtered = manager.filterByAgeRange(20, 30);

        assertEquals(3, filtered.size(),
            "filterByAgeRange(20, 30) should return 3 users");

        boolean hasAlice = false, hasBob = false, hasCharlie = false;
        for (User user : filtered) {
            if (user.getName().equals("Alice")) hasAlice = true;
            if (user.getName().equals("Bob")) hasBob = true;
            if (user.getName().equals("Charlie")) hasCharlie = true;
        }

        assertTrue(hasAlice && hasBob && hasCharlie,
            "Filtered list should contain Alice, Bob, and Charlie");
    }

    @Test
    public void testFilterByAgeRangeNoMatches() {
        manager.addUser(new User("Alice", 25));
        manager.addUser(new User("Bob", 30));

        ArrayList<User> filtered = manager.filterByAgeRange(40, 50);

        assertEquals(0, filtered.size(),
            "filterByAgeRange() should return empty list when no matches");
    }

    @Test
    public void testFilterByAgeRangeBoundaries() {
        manager.addUser(new User("Alice", 20));
        manager.addUser(new User("Bob", 30));
        manager.addUser(new User("Charlie", 40));

        ArrayList<User> filtered = manager.filterByAgeRange(20, 40);

        assertEquals(3, filtered.size(),
            "filterByAgeRange() should include users at boundaries (inclusive)");
    }

    @Test
    public void testGetOldestUser() {
        manager.addUser(new User("Alice", 25));
        manager.addUser(new User("Bob", 30));
        manager.addUser(new User("Charlie", 45));
        manager.addUser(new User("Diana", 35));

        User oldest = manager.getOldestUser();

        assertNotNull(oldest, "getOldestUser() should not return null");
        assertEquals("Charlie", oldest.getName(),
            "getOldestUser() should return user with highest age");
        assertEquals(45, oldest.getAge(),
            "Oldest user should have age 45");
    }

    @Test
    public void testGetOldestUserEmptyList() {
        User oldest = manager.getOldestUser();

        assertNull(oldest,
            "getOldestUser() should return null when list is empty");
    }

    @Test
    public void testGetOldestUserTie() {
        manager.addUser(new User("Alice", 30));
        manager.addUser(new User("Bob", 30));

        User oldest = manager.getOldestUser();

        assertNotNull(oldest, "getOldestUser() should return a user when there's a tie");
        assertEquals(30, oldest.getAge(),
            "Oldest user should have age 30");
    }

    @Test
    public void testGetYoungestUser() {
        manager.addUser(new User("Alice", 25));
        manager.addUser(new User("Bob", 30));
        manager.addUser(new User("Charlie", 20));
        manager.addUser(new User("Diana", 35));

        User youngest = manager.getYoungestUser();

        assertNotNull(youngest, "getYoungestUser() should not return null");
        assertEquals("Charlie", youngest.getName(),
            "getYoungestUser() should return user with lowest age");
        assertEquals(20, youngest.getAge(),
            "Youngest user should have age 20");
    }

    @Test
    public void testGetYoungestUserEmptyList() {
        User youngest = manager.getYoungestUser();

        assertNull(youngest,
            "getYoungestUser() should return null when list is empty");
    }

    @Test
    public void testGetYoungestUserTie() {
        manager.addUser(new User("Alice", 20));
        manager.addUser(new User("Bob", 20));

        User youngest = manager.getYoungestUser();

        assertNotNull(youngest, "getYoungestUser() should return a user when there's a tie");
        assertEquals(20, youngest.getAge(),
            "Youngest user should have age 20");
    }

    @Test
    public void testMultipleOperations() {
        manager.addUser(new User("Alice", 25));
        manager.addUser(new User("Bob", 30));
        manager.addUser(new User("Charlie", 20));
        manager.addUser(new User("Diana", 35));

        // Test count
        assertEquals(4, manager.getUserCount());

        // Test find
        User found = manager.findByName("Diana");
        assertEquals(35, found.getAge());

        // Test filter
        ArrayList<User> filtered = manager.filterByAgeRange(25, 35);
        assertEquals(3, filtered.size());

        // Test extremes
        assertEquals("Diana", manager.getOldestUser().getName());
        assertEquals("Charlie", manager.getYoungestUser().getName());
    }
}
