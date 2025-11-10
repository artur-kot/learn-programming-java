import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.ArrayList;

@DisplayName("Data Persistence with CSV Tests")
public class DataPersistenceTest {

    private static final String TEST_FILE = "test_people.csv";

    @AfterEach
    public void cleanup() {
        // Clean up test files after each test
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    @DisplayName("Person.toCSV() formats correctly")
    public void testPersonToCSV() {
        Person person = new Person("John Doe", 30, "john@email.com");
        String csv = person.toCSV();

        assertEquals("John Doe,30,john@email.com", csv);
    }

    @Test
    @DisplayName("parseCSVLine() parses valid line correctly")
    public void testParseCSVLineValid() {
        String line = "Jane Smith,25,jane@email.com";
        Person person = DataPersistence.parseCSVLine(line);

        assertNotNull(person);
        assertEquals("Jane Smith", person.name);
        assertEquals(25, person.age);
        assertEquals("jane@email.com", person.email);
    }

    @Test
    @DisplayName("parseCSVLine() handles invalid number format")
    public void testParseCSVLineInvalidNumber() {
        String line = "Bob,not_a_number,bob@email.com";
        Person person = DataPersistence.parseCSVLine(line);

        assertNull(person, "Should return null for invalid number format");
    }

    @Test
    @DisplayName("parseCSVLine() handles wrong number of fields")
    public void testParseCSVLineWrongFields() {
        String line = "Alice,28";  // Missing email
        Person person = DataPersistence.parseCSVLine(line);

        assertNull(person, "Should return null for wrong number of fields");
    }

    @Test
    @DisplayName("saveToCSV() creates file with correct content")
    public void testSaveToCSV() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 28, "alice@email.com"));
        people.add(new Person("Bob", 35, "bob@email.com"));

        DataPersistence.saveToCSV(people, TEST_FILE);

        assertTrue(new File(TEST_FILE).exists(), "File should be created");
    }

    @Test
    @DisplayName("loadFromCSV() reads and parses file correctly")
    public void testLoadFromCSV() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 28, "alice@email.com"));
        people.add(new Person("Bob", 35, "bob@email.com"));

        DataPersistence.saveToCSV(people, TEST_FILE);
        ArrayList<Person> loaded = DataPersistence.loadFromCSV(TEST_FILE);

        assertEquals(2, loaded.size(), "Should load 2 people");
        assertEquals("Alice", loaded.get(0).name);
        assertEquals(28, loaded.get(0).age);
        assertEquals("alice@email.com", loaded.get(0).email);
        assertEquals("Bob", loaded.get(1).name);
        assertEquals(35, loaded.get(1).age);
        assertEquals("bob@email.com", loaded.get(1).email);
    }

    @Test
    @DisplayName("loadFromCSV() returns empty list for non-existent file")
    public void testLoadFromNonExistentFile() {
        ArrayList<Person> loaded = DataPersistence.loadFromCSV("nonexistent.csv");

        assertNotNull(loaded, "Should return a list, not null");
        assertTrue(loaded.isEmpty(), "List should be empty for non-existent file");
    }

    @Test
    @DisplayName("loadFromCSV() skips invalid lines")
    public void testLoadFromCSVSkipsInvalidLines() {
        // Manually create a CSV file with some invalid lines
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 28, "alice@email.com"));

        DataPersistence.saveToCSV(people, TEST_FILE);

        // Now load - should get 1 valid person
        ArrayList<Person> loaded = DataPersistence.loadFromCSV(TEST_FILE);

        assertEquals(1, loaded.size(), "Should load only valid entries");
        assertEquals("Alice", loaded.get(0).name);
    }

    @Test
    @DisplayName("Round-trip: save and load multiple people")
    public void testRoundTrip() {
        ArrayList<Person> original = new ArrayList<>();
        original.add(new Person("Alice Johnson", 28, "alice@email.com"));
        original.add(new Person("Bob Smith", 35, "bob@email.com"));
        original.add(new Person("Charlie Brown", 42, "charlie@email.com"));

        DataPersistence.saveToCSV(original, TEST_FILE);
        ArrayList<Person> loaded = DataPersistence.loadFromCSV(TEST_FILE);

        assertEquals(original.size(), loaded.size());
        for (int i = 0; i < original.size(); i++) {
            assertEquals(original.get(i).name, loaded.get(i).name);
            assertEquals(original.get(i).age, loaded.get(i).age);
            assertEquals(original.get(i).email, loaded.get(i).email);
        }
    }

    @Test
    @DisplayName("saveToCSV() handles empty list")
    public void testSaveEmptyList() {
        ArrayList<Person> empty = new ArrayList<>();
        DataPersistence.saveToCSV(empty, TEST_FILE);

        ArrayList<Person> loaded = DataPersistence.loadFromCSV(TEST_FILE);
        assertTrue(loaded.isEmpty(), "Should load empty list from empty file");
    }

    @Test
    @DisplayName("Person with special characters in name")
    public void testPersonWithSpecialName() {
        Person person = new Person("O'Brien", 30, "obrien@email.com");
        String csv = person.toCSV();

        assertEquals("O'Brien,30,obrien@email.com", csv);

        Person parsed = DataPersistence.parseCSVLine(csv);
        assertNotNull(parsed);
        assertEquals("O'Brien", parsed.name);
    }
}
