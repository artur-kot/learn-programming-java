import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

class DataOperationsTest {

    private DataOperations dataOps;

    @BeforeEach
    void setUp() {
        dataOps = new DataOperations();
    }

    // Test: Sorting Lists
    @Test
    void testSortListAscending() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5));
        dataOps.sortList(list);
        assertEquals(Arrays.asList(1, 1, 3, 4, 5), list);
    }

    @Test
    void testSortAlreadySorted() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        dataOps.sortList(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }

    @Test
    void testSortReversed() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        dataOps.sortList(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }

    @Test
    void testSortSingleElement() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(42));
        dataOps.sortList(list);
        assertEquals(Arrays.asList(42), list);
    }

    @Test
    void testSortEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        dataOps.sortList(list);
        assertEquals(new ArrayList<>(), list);
    }

    @Test
    void testSortNegativeNumbers() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-3, 5, -1, 2, -4));
        dataOps.sortList(list);
        assertEquals(Arrays.asList(-4, -3, -1, 2, 5), list);
    }

    // Test: Filtering
    @Test
    void testFilterGreaterThanBasic() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 3, 8, 2));
        ArrayList<Integer> result = dataOps.filterGreaterThan(list, 3);
        assertEquals(Arrays.asList(5, 8), result);
        // Verify original unchanged
        assertEquals(Arrays.asList(1, 5, 3, 8, 2), list);
    }

    @Test
    void testFilterGreaterThanNone() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> result = dataOps.filterGreaterThan(list, 10);
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testFilterGreaterThanAll() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 6, 7, 8));
        ArrayList<Integer> result = dataOps.filterGreaterThan(list, 3);
        assertEquals(Arrays.asList(5, 6, 7, 8), result);
    }

    @Test
    void testFilterGreaterThanEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = dataOps.filterGreaterThan(list, 5);
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testFilterGreaterThanNegativeThreshold() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-5, -2, 0, 3, 1));
        ArrayList<Integer> result = dataOps.filterGreaterThan(list, -3);
        assertEquals(Arrays.asList(-2, 0, 3, 1), result);
    }

    @Test
    void testFilterDoesNotModifyOriginal() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 3, 8, 2));
        ArrayList<Integer> originalCopy = new ArrayList<>(list);
        dataOps.filterGreaterThan(list, 3);
        assertEquals(originalCopy, list);
    }

    // Test: Merging Lists
    @Test
    void testMergeListsBasic() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5));
        ArrayList<Integer> result = dataOps.mergeLists(list1, list2);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);
    }

    @Test
    void testMergeListsFirstEmpty() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> result = dataOps.mergeLists(list1, list2);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void testMergeListsSecondEmpty() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> result = dataOps.mergeLists(list1, list2);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    void testMergeListsBothEmpty() {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> result = dataOps.mergeLists(list1, list2);
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testMergeListsOrder() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 4, 6));
        ArrayList<Integer> result = dataOps.mergeLists(list1, list2);
        assertEquals(Arrays.asList(1, 3, 5, 2, 4, 6), result);
    }

    @Test
    void testMergeDoesNotModifyOriginals() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4));
        ArrayList<Integer> copy1 = new ArrayList<>(list1);
        ArrayList<Integer> copy2 = new ArrayList<>(list2);
        dataOps.mergeLists(list1, list2);
        assertEquals(copy1, list1);
        assertEquals(copy2, list2);
    }

    // Test: Removing Duplicates
    @Test
    void testRemoveDuplicatesBasic() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 4));
        ArrayList<Integer> result = dataOps.removeDuplicates(list);
        assertEquals(Arrays.asList(1, 2, 3, 4), result);
    }

    @Test
    void testRemoveDuplicatesNoDuplicates() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> result = dataOps.removeDuplicates(list);
        assertEquals(Arrays.asList(1, 2, 3, 4), result);
    }

    @Test
    void testRemoveDuplicatesAllSame() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 5, 5, 5, 5));
        ArrayList<Integer> result = dataOps.removeDuplicates(list);
        assertEquals(Arrays.asList(5), result);
    }

    @Test
    void testRemoveDuplicatesEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = dataOps.removeDuplicates(list);
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testRemoveDuplicatesSingleElement() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(42));
        ArrayList<Integer> result = dataOps.removeDuplicates(list);
        assertEquals(Arrays.asList(42), result);
    }

    @Test
    void testRemoveDuplicatesPreservesOrder() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 1, 3, 2));
        ArrayList<Integer> result = dataOps.removeDuplicates(list);
        assertEquals(Arrays.asList(3, 1, 2), result);
    }

    @Test
    void testRemoveDuplicatesDoesNotModifyOriginal() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        ArrayList<Integer> originalCopy = new ArrayList<>(list);
        dataOps.removeDuplicates(list);
        assertEquals(originalCopy, list);
    }

    // Test: Statistics
    @Test
    void testGetStatisticsBasic() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        String result = dataOps.getStatistics(list);
        assertEquals("Min: 1, Max: 5, Average: 3.0", result);
    }

    @Test
    void testGetStatisticsEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        String result = dataOps.getStatistics(list);
        assertEquals("No data", result);
    }

    @Test
    void testGetStatisticsSingleElement() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(42));
        String result = dataOps.getStatistics(list);
        assertEquals("Min: 42, Max: 42, Average: 42.0", result);
    }

    @Test
    void testGetStatisticsNegativeNumbers() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-5, -2, -8, -1));
        String result = dataOps.getStatistics(list);
        assertEquals("Min: -8, Max: -1, Average: -4.0", result);
    }

    @Test
    void testGetStatisticsMixedNumbers() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-10, 0, 10, 20));
        String result = dataOps.getStatistics(list);
        assertEquals("Min: -10, Max: 20, Average: 5.0", result);
    }

    @Test
    void testGetStatisticsDecimalAverage() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        String result = dataOps.getStatistics(list);
        assertEquals("Min: 1, Max: 3, Average: 2.0", result);
    }

    @Test
    void testGetStatisticsRoundingAverage() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        String result = dataOps.getStatistics(list);
        // Average is 2.5, should be rounded to 1 decimal place
        assertEquals("Min: 1, Max: 4, Average: 2.5", result);
    }

    @Test
    void testGetStatisticsLargeNumbers() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(100, 200, 300));
        String result = dataOps.getStatistics(list);
        assertEquals("Min: 100, Max: 300, Average: 200.0", result);
    }

    @Test
    void testGetStatisticsAllSame() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(7, 7, 7, 7));
        String result = dataOps.getStatistics(list);
        assertEquals("Min: 7, Max: 7, Average: 7.0", result);
    }
}
