import java.util.ArrayList;
import java.util.Collections;

public class DataOperations {

    /**
     * Sort the list in ascending order (smallest to largest)
     * Modifies the original list
     * Example: [3, 1, 4, 1, 5] becomes [1, 1, 3, 4, 5]
     */
    public void sortList(ArrayList<Integer> list) {
        // TODO: Use Collections.sort() to sort the list
    }

    /**
     * Filter and return only values greater than the threshold
     * Creates and returns a new list, original list unchanged
     * Example: filterGreaterThan([1, 5, 3, 8, 2], 3) returns [5, 8]
     */
    public ArrayList<Integer> filterGreaterThan(ArrayList<Integer> list, int threshold) {
        // TODO: Create new list with values greater than threshold
        return new ArrayList<>();
    }

    /**
     * Merge two lists into one new list
     * Combines all elements from list1 followed by all elements from list2
     * Original lists remain unchanged
     * Example: [1, 2] + [3, 4] = [1, 2, 3, 4]
     */
    public ArrayList<Integer> mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        // TODO: Create new list combining both lists
        return new ArrayList<>();
    }

    /**
     * Remove duplicate values from the list
     * Returns new list with only unique values (first occurrence kept)
     * Preserves original order
     * Example: [1, 2, 2, 3, 1, 4] becomes [1, 2, 3, 4]
     */
    public ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        // TODO: Create new list without duplicates
        return new ArrayList<>();
    }

    /**
     * Calculate and return statistics: min, max, and average
     * Return format: "Min: X, Max: Y, Average: Z"
     * Round average to 1 decimal place
     * Return "No data" if list is empty
     * Example: [1, 2, 3, 4, 5] returns "Min: 1, Max: 5, Average: 3.0"
     */
    public String getStatistics(ArrayList<Integer> list) {
        // TODO: Calculate min, max, and average. Return formatted string
        return "";
    }
}
