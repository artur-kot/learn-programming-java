
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTest {

    // Test reverseArray
    @Test
    public void testReverseArrayBasic() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, ArrayOperations.reverseArray(arr),
            "Reversed array should be {5,4,3,2,1}");
    }

    @Test
    public void testReverseArraySingleElement() {
        int[] arr = {42};
        int[] expected = {42};
        assertArrayEquals(expected, ArrayOperations.reverseArray(arr),
            "Single element array should remain unchanged");
    }

    @Test
    public void testReverseArrayEvenLength() {
        int[] arr = {1, 2, 3, 4};
        int[] expected = {4, 3, 2, 1};
        assertArrayEquals(expected, ArrayOperations.reverseArray(arr),
            "Even-length array should reverse correctly");
    }

    @Test
    public void testReverseArrayDoesNotModifyOriginal() {
        int[] arr = {1, 2, 3};
        int[] original = {1, 2, 3};
        ArrayOperations.reverseArray(arr);
        assertArrayEquals(original, arr,
            "Original array should not be modified");
    }

    // Test mergeArrays
    @Test
    public void testMergeArraysBasic() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, ArrayOperations.mergeArrays(arr1, arr2),
            "Merged array should contain all elements in order");
    }

    @Test
    public void testMergeArraysDifferentSizes() {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, ArrayOperations.mergeArrays(arr1, arr2),
            "Should handle arrays of different sizes");
    }

    @Test
    public void testMergeArraysOneEmpty() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {};
        int[] expected = {1, 2, 3};
        assertArrayEquals(expected, ArrayOperations.mergeArrays(arr1, arr2),
            "Should handle empty second array");
    }

    @Test
    public void testMergeArraysWithDuplicates() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 3, 4};
        int[] expected = {1, 2, 3, 2, 3, 4};
        assertArrayEquals(expected, ArrayOperations.mergeArrays(arr1, arr2),
            "Merge should keep all elements including duplicates");
    }

    // Test removeDuplicates
    @Test
    public void testRemoveDuplicatesBasic() {
        int[] arr = {1, 2, 2, 3, 1, 4};
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, ArrayOperations.removeDuplicates(arr),
            "Should remove duplicates and preserve first occurrence order");
    }

    @Test
    public void testRemoveDuplicatesNoDuplicates() {
        int[] arr = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, ArrayOperations.removeDuplicates(arr),
            "Array with no duplicates should remain unchanged");
    }

    @Test
    public void testRemoveDuplicatesAllSame() {
        int[] arr = {5, 5, 5, 5};
        int[] expected = {5};
        assertArrayEquals(expected, ArrayOperations.removeDuplicates(arr),
            "All same elements should result in single element");
    }

    @Test
    public void testRemoveDuplicatesSingleElement() {
        int[] arr = {7};
        int[] expected = {7};
        assertArrayEquals(expected, ArrayOperations.removeDuplicates(arr),
            "Single element array should remain unchanged");
    }

    // Test contains
    @Test
    public void testContainsFound() {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(ArrayOperations.contains(arr, 3),
            "Should return true when element exists");
    }

    @Test
    public void testContainsNotFound() {
        int[] arr = {1, 2, 3, 4, 5};
        assertFalse(ArrayOperations.contains(arr, 10),
            "Should return false when element doesn't exist");
    }

    @Test
    public void testContainsFirstElement() {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(ArrayOperations.contains(arr, 1),
            "Should find first element");
    }

    @Test
    public void testContainsLastElement() {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(ArrayOperations.contains(arr, 5),
            "Should find last element");
    }

    @Test
    public void testContainsNegativeNumber() {
        int[] arr = {-5, -2, 0, 3, 7};
        assertTrue(ArrayOperations.contains(arr, -2),
            "Should find negative numbers");
    }

    // Test sortArray
    @Test
    public void testSortArrayBasic() {
        int[] arr = {5, 2, 8, 1, 9};
        int[] expected = {1, 2, 5, 8, 9};
        assertArrayEquals(expected, ArrayOperations.sortArray(arr),
            "Should sort in ascending order");
    }

    @Test
    public void testSortArrayAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, ArrayOperations.sortArray(arr),
            "Already sorted array should remain same");
    }

    @Test
    public void testSortArrayReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, ArrayOperations.sortArray(arr),
            "Reverse sorted array should be sorted correctly");
    }

    @Test
    public void testSortArrayWithDuplicates() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        int[] expected = {1, 1, 2, 3, 4, 5, 5, 6, 9};
        assertArrayEquals(expected, ArrayOperations.sortArray(arr),
            "Should handle duplicates correctly");
    }

    @Test
    public void testSortArrayDoesNotModifyOriginal() {
        int[] arr = {5, 2, 8, 1};
        int[] original = {5, 2, 8, 1};
        ArrayOperations.sortArray(arr);
        assertArrayEquals(original, arr,
            "Original array should not be modified");
    }

    // Test filterEven
    @Test
    public void testFilterEvenBasic() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] expected = {2, 4, 6};
        assertArrayEquals(expected, ArrayOperations.filterEven(arr),
            "Should return only even numbers");
    }

    @Test
    public void testFilterEvenNoEvenNumbers() {
        int[] arr = {1, 3, 5, 7, 9};
        int[] expected = {};
        assertArrayEquals(expected, ArrayOperations.filterEven(arr),
            "Should return empty array when no even numbers");
    }

    @Test
    public void testFilterEvenAllEven() {
        int[] arr = {2, 4, 6, 8};
        int[] expected = {2, 4, 6, 8};
        assertArrayEquals(expected, ArrayOperations.filterEven(arr),
            "Should return all elements when all are even");
    }

    @Test
    public void testFilterEvenWithZero() {
        int[] arr = {-2, 0, 1, 2, 3};
        int[] expected = {-2, 0, 2};
        assertArrayEquals(expected, ArrayOperations.filterEven(arr),
            "Zero and negative even numbers should be included");
    }

    @Test
    public void testFilterEvenPreservesOrder() {
        int[] arr = {8, 3, 2, 7, 4, 1, 6};
        int[] expected = {8, 2, 4, 6};
        assertArrayEquals(expected, ArrayOperations.filterEven(arr),
            "Should preserve order from original array");
    }

    // Integration test
    @Test
    public void testAllOperationsTogether() {
        int[] arr1 = {3, 1, 4, 1, 5};
        int[] arr2 = {9, 2, 6};

        // Merge
        int[] merged = ArrayOperations.mergeArrays(arr1, arr2);
        assertEquals(8, merged.length, "Merged array should have 8 elements");

        // Remove duplicates
        int[] unique = ArrayOperations.removeDuplicates(merged);
        assertEquals(7, unique.length, "Should have 7 unique elements");

        // Sort
        int[] sorted = ArrayOperations.sortArray(unique);
        assertEquals(1, sorted[0], "First element should be 1");
        assertEquals(9, sorted[sorted.length - 1], "Last element should be 9");

        // Filter even
        int[] evens = ArrayOperations.filterEven(sorted);
        assertTrue(evens.length > 0, "Should have some even numbers");
        for (int num : evens) {
            assertEquals(0, num % 2, "All filtered numbers should be even");
        }
    }
}
