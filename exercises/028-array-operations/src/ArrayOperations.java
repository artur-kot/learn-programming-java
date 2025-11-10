
public class ArrayOperations {

    // TODO: Return a NEW array with elements in reverse order
    // Do NOT modify the original array
    // Example: {1, 2, 3} should return {3, 2, 1}
    public static int[] reverseArray(int[] arr) {
        return null;
    }

    // TODO: Combine two arrays into one new array
    // Put all elements from arr1 first, then all from arr2
    // Example: {1, 2} and {3, 4} should return {1, 2, 3, 4}
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        return null;
    }

    // TODO: Return a new array containing only unique values
    // Preserve the order of first occurrence
    // Example: {1, 2, 2, 3, 1, 4} should return {1, 2, 3, 4}
    public static int[] removeDuplicates(int[] arr) {
        return null;
    }

    // TODO: Check if the array contains the specified value
    // Return true if found, false otherwise
    // Example: contains({1, 2, 3}, 2) should return true
    public static boolean contains(int[] arr, int value) {
        return false;
    }

    // TODO: Return a new sorted array in ascending order (smallest to largest)
    // Do NOT modify the original array
    // You can use Arrays.sort() or implement your own sorting
    // Example: {5, 2, 8, 1} should return {1, 2, 5, 8}
    public static int[] sortArray(int[] arr) {
        return null;
    }

    // TODO: Return a new array containing only even numbers from the original
    // Preserve the order from original array
    // Example: {1, 2, 3, 4, 5, 6} should return {2, 4, 6}
    public static int[] filterEven(int[] arr) {
        return null;
    }

    public static void main(String[] args) {
        // Test your methods here
        int[] numbers = {5, 2, 8, 1, 9, 2, 5};

        System.out.println("Original array:");
        printArray(numbers);

        System.out.println("\nReversed:");
        printArray(reverseArray(numbers));

        System.out.println("\nWithout duplicates:");
        printArray(removeDuplicates(numbers));

        System.out.println("\nSorted:");
        printArray(sortArray(numbers));

        System.out.println("\nEven numbers only:");
        printArray(filterEven(numbers));

        System.out.println("\nContains 8? " + contains(numbers, 8));
        System.out.println("Contains 99? " + contains(numbers, 99));

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        System.out.println("\nMerged arrays:");
        printArray(mergeArrays(arr1, arr2));
    }

    // Helper method to print arrays
    private static void printArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
