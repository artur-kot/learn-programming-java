import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ShoppingListTest {

    private ShoppingList shoppingList;
    private ArrayList<String> list;

    @BeforeEach
    void setUp() {
        shoppingList = new ShoppingList();
        list = new ArrayList<>();
    }

    // Test: Adding Items
    @Test
    void testAddSingleItem() {
        shoppingList.addItem(list, "Milk");
        assertEquals(1, list.size());
        assertEquals("Milk", list.get(0));
    }

    @Test
    void testAddMultipleItems() {
        shoppingList.addItem(list, "Bread");
        shoppingList.addItem(list, "Milk");
        shoppingList.addItem(list, "Eggs");
        assertEquals(3, list.size());
        assertEquals("Bread", list.get(0));
        assertEquals("Milk", list.get(1));
        assertEquals("Eggs", list.get(2));
    }

    @Test
    void testAddDuplicateItems() {
        shoppingList.addItem(list, "Milk");
        shoppingList.addItem(list, "Milk");
        assertEquals(2, list.size());
    }

    // Test: Removing Items
    @Test
    void testRemoveExistingItem() {
        list.add("Bread");
        list.add("Milk");
        list.add("Eggs");
        shoppingList.removeItem(list, "Milk");
        assertEquals(2, list.size());
        assertFalse(list.contains("Milk"));
    }

    @Test
    void testRemoveNonExistingItem() {
        list.add("Bread");
        list.add("Eggs");
        shoppingList.removeItem(list, "Milk");
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveFirstOccurrenceOnly() {
        list.add("Milk");
        list.add("Bread");
        list.add("Milk");
        shoppingList.removeItem(list, "Milk");
        assertEquals(2, list.size());
        assertEquals("Bread", list.get(0));
        assertEquals("Milk", list.get(1));
    }

    @Test
    void testRemoveFromEmptyList() {
        shoppingList.removeItem(list, "Milk");
        assertEquals(0, list.size());
    }

    // Test: Searching Items
    @Test
    void testSearchItemFound() {
        list.add("Bread");
        list.add("Milk");
        list.add("Eggs");
        int index = shoppingList.searchItem(list, "Milk");
        assertEquals(1, index);
    }

    @Test
    void testSearchItemNotFound() {
        list.add("Bread");
        list.add("Eggs");
        int index = shoppingList.searchItem(list, "Milk");
        assertEquals(-1, index);
    }

    @Test
    void testSearchItemAtBeginning() {
        list.add("Bread");
        list.add("Milk");
        list.add("Eggs");
        int index = shoppingList.searchItem(list, "Bread");
        assertEquals(0, index);
    }

    @Test
    void testSearchItemAtEnd() {
        list.add("Bread");
        list.add("Milk");
        list.add("Eggs");
        int index = shoppingList.searchItem(list, "Eggs");
        assertEquals(2, index);
    }

    @Test
    void testSearchInEmptyList() {
        int index = shoppingList.searchItem(list, "Milk");
        assertEquals(-1, index);
    }

    @Test
    void testSearchDuplicateReturnsFirst() {
        list.add("Milk");
        list.add("Bread");
        list.add("Milk");
        int index = shoppingList.searchItem(list, "Milk");
        assertEquals(0, index);
    }

    // Test: Counting Occurrences
    @Test
    void testCountZeroOccurrences() {
        list.add("Bread");
        list.add("Eggs");
        int count = shoppingList.countOccurrences(list, "Milk");
        assertEquals(0, count);
    }

    @Test
    void testCountSingleOccurrence() {
        list.add("Bread");
        list.add("Milk");
        list.add("Eggs");
        int count = shoppingList.countOccurrences(list, "Milk");
        assertEquals(1, count);
    }

    @Test
    void testCountMultipleOccurrences() {
        list.add("Milk");
        list.add("Bread");
        list.add("Milk");
        list.add("Eggs");
        list.add("Milk");
        int count = shoppingList.countOccurrences(list, "Milk");
        assertEquals(3, count);
    }

    @Test
    void testCountInEmptyList() {
        int count = shoppingList.countOccurrences(list, "Milk");
        assertEquals(0, count);
    }

    @Test
    void testCountAllItemsSame() {
        list.add("Milk");
        list.add("Milk");
        list.add("Milk");
        int count = shoppingList.countOccurrences(list, "Milk");
        assertEquals(3, count);
    }

    // Test: Displaying List
    @Test
    void testDisplayEmptyList() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        shoppingList.displayList(list);
        String output = outputStream.toString().trim();

        assertEquals("Shopping list is empty", output);
        System.setOut(System.out);
    }

    @Test
    void testDisplaySingleItem() {
        list.add("Bread");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        shoppingList.displayList(list);
        String output = outputStream.toString().trim();

        assertEquals("1. Bread", output);
        System.setOut(System.out);
    }

    @Test
    void testDisplayMultipleItems() {
        list.add("Bread");
        list.add("Milk");
        list.add("Eggs");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        shoppingList.displayList(list);
        String output = outputStream.toString().trim();

        String[] lines = output.split(System.lineSeparator());
        assertEquals(3, lines.length);
        assertEquals("1. Bread", lines[0]);
        assertEquals("2. Milk", lines[1]);
        assertEquals("3. Eggs", lines[2]);

        System.setOut(System.out);
    }

    @Test
    void testDisplayWithDuplicates() {
        list.add("Milk");
        list.add("Bread");
        list.add("Milk");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        shoppingList.displayList(list);
        String output = outputStream.toString().trim();

        String[] lines = output.split(System.lineSeparator());
        assertEquals(3, lines.length);
        assertEquals("1. Milk", lines[0]);
        assertEquals("2. Bread", lines[1]);
        assertEquals("3. Milk", lines[2]);

        System.setOut(System.out);
    }
}
