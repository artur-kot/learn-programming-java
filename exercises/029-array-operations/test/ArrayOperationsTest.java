
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

class ArrayOperationsTest {

    private ArrayOperations arrayOps;

    @BeforeEach
    void setUp() {
        arrayOps = new ArrayOperations();
    }

    // Part 1: Array Merging Tests
    @Test
    void testMergeArrays() {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        int[] result = arrayOps.mergeArrays(arr1, arr2);
        assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    void testMergeArraysEmpty() {
        int[] arr1 = {};
        int[] arr2 = {1, 2};
        int[] result = arrayOps.mergeArrays(arr1, arr2);
        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void testMergeArraysSorted() {
        int[] arr1 = {3, 1};
        int[] arr2 = {4, 2};
        int[] result = arrayOps.mergeArraysSorted(arr1, arr2);
        assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    void testMergeArraysSortedWithDuplicates() {
        int[] arr1 = {3, 1, 2};
        int[] arr2 = {2, 4};
        int[] result = arrayOps.mergeArraysSorted(arr1, arr2);
        assertArrayEquals(new int[]{1, 2, 2, 3, 4}, result);
    }

    // Part 2: Reversal & Copying Tests
    @Test
    void testReverseArray() {
        int[] numbers = {1, 2, 3};
        int[] result = arrayOps.reverseArray(numbers);
        assertArrayEquals(new int[]{3, 2, 1}, result);
        // Verify original not modified
        assertArrayEquals(new int[]{1, 2, 3}, numbers);
    }

    @Test
    void testReverseArraySingleElement() {
        int[] numbers = {5};
        int[] result = arrayOps.reverseArray(numbers);
        assertArrayEquals(new int[]{5}, result);
    }

    @Test
    void testReverseArrayInPlace() {
        int[] numbers = {1, 2, 3, 4, 5};
        arrayOps.reverseArrayInPlace(numbers);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, numbers);
    }

    @Test
    void testReverseArrayInPlaceEven() {
        int[] numbers = {1, 2, 3, 4};
        arrayOps.reverseArrayInPlace(numbers);
        assertArrayEquals(new int[]{4, 3, 2, 1}, numbers);
    }

    @Test
    void testCopyArray() {
        int[] original = {1, 2, 3};
        int[] copy = arrayOps.copyArray(original);
        assertArrayEquals(original, copy);
        // Verify independence
        copy[0] = 99;
        assertEquals(1, original[0]);
    }

    // Part 3: Duplicate Removal Tests
    @Test
    void testRemoveDuplicates() {
        int[] numbers = {1, 2, 2, 3, 1};
        int[] result = arrayOps.removeDuplicates(numbers);
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void testRemoveDuplicatesNoDuplicates() {
        int[] numbers = {1, 2, 3, 4};
        int[] result = arrayOps.removeDuplicates(numbers);
        assertArrayEquals(new int[]{1, 2, 3, 4}, result);
    }

    @Test
    void testRemoveDuplicatesAllDuplicates() {
        int[] numbers = {5, 5, 5, 5};
        int[] result = arrayOps.removeDuplicates(numbers);
        assertArrayEquals(new int[]{5}, result);
    }

    @Test
    void testContainsDuplicatesTrue() {
        int[] numbers = {1, 2, 1};
        assertTrue(arrayOps.containsDuplicates(numbers));
    }

    @Test
    void testContainsDuplicatesFalse() {
        int[] numbers = {1, 2, 3};
        assertFalse(arrayOps.containsDuplicates(numbers));
    }

    // Part 4: Searching & Filtering Tests
    @Test
    void testIndexOfFound() {
        int[] numbers = {5, 2, 8, 2};
        assertEquals(1, arrayOps.indexOf(numbers, 2));
    }

    @Test
    void testIndexOfNotFound() {
        int[] numbers = {1, 2, 3};
        assertEquals(-1, arrayOps.indexOf(numbers, 99));
    }

    @Test
    void testIndexOfFirstOccurrence() {
        int[] numbers = {1, 2, 3, 2, 1};
        assertEquals(1, arrayOps.indexOf(numbers, 2));
    }

    @Test
    void testContainsTrue() {
        int[] numbers = {1, 2, 3};
        assertTrue(arrayOps.contains(numbers, 2));
    }

    @Test
    void testContainsFalse() {
        int[] numbers = {1, 2, 3};
        assertFalse(arrayOps.contains(numbers, 5));
    }

    @Test
    void testFilterEven() {
        int[] numbers = {1, 2, 3, 4};
        int[] result = arrayOps.filterEven(numbers);
        assertArrayEquals(new int[]{2, 4}, result);
    }

    @Test
    void testFilterOdd() {
        int[] numbers = {1, 2, 3, 4};
        int[] result = arrayOps.filterOdd(numbers);
        assertArrayEquals(new int[]{1, 3}, result);
    }

    @Test
    void testFilterNoMatches() {
        int[] numbers = {2, 4, 6};
        int[] result = arrayOps.filterOdd(numbers);
        assertArrayEquals(new int[]{}, result);
    }

    // Part 5: Sorting & Transformation Tests
    @Test
    void testSortAscending() {
        int[] numbers = {3, 1, 4, 1, 5};
        int[] result = arrayOps.sortAscending(numbers);
        assertArrayEquals(new int[]{1, 1, 3, 4, 5}, result);
    }

    @Test
    void testSortAscendingDoesNotModifyOriginal() {
        int[] original = {3, 1, 4};
        int[] sorted = arrayOps.sortAscending(original);
        assertArrayEquals(new int[]{3, 1, 4}, original);
    }

    @Test
    void testSortDescending() {
        int[] numbers = {3, 1, 4, 1, 5};
        int[] result = arrayOps.sortDescending(numbers);
        assertArrayEquals(new int[]{5, 4, 3, 1, 1}, result);
    }

    @Test
    void testSortDescendingDoesNotModifyOriginal() {
        int[] original = {3, 1, 4};
        int[] sorted = arrayOps.sortDescending(original);
        assertArrayEquals(new int[]{3, 1, 4}, original);
    }

    @Test
    void testMultiplyAll() {
        int[] numbers = {1, 2, 3};
        int[] result = arrayOps.multiplyAll(numbers, 2);
        assertArrayEquals(new int[]{2, 4, 6}, result);
    }

    @Test
    void testMultiplyAllByZero() {
        int[] numbers = {1, 2, 3};
        int[] result = arrayOps.multiplyAll(numbers, 0);
        assertArrayEquals(new int[]{0, 0, 0}, result);
    }

    @Test
    void testMultiplyAllNegative() {
        int[] numbers = {1, -2, 3};
        int[] result = arrayOps.multiplyAll(numbers, -1);
        assertArrayEquals(new int[]{-1, 2, -3}, result);
    }
}
