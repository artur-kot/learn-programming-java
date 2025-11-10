
public class ArrayBasics {

    // TODO: Print each element of the array on a new line
    // Example: For array {1, 2, 3}, print:
    // 1
    // 2
    // 3
    public static void printArray(int[] arr) {

    }

    // TODO: Calculate and return the sum of all elements in the array
    // Example: For array {1, 2, 3, 4}, return 10
    public static int sum(int[] arr) {
        return 0;
    }

    // TODO: Calculate and return the average of all elements
    // Return type is double to handle decimal averages
    // Example: For array {2, 4, 6}, return 4.0
    public static double average(int[] arr) {
        return 0.0;
    }

    // TODO: Find and return the smallest element in the array
    // Example: For array {5, 2, 9, 1, 7}, return 1
    public static int findMin(int[] arr) {
        return 0;
    }

    // TODO: Find and return the largest element in the array
    // Example: For array {5, 2, 9, 1, 7}, return 9
    public static int findMax(int[] arr) {
        return 0;
    }

    public static void main(String[] args) {
        // Test your methods here
        int[] numbers = {5, 12, 3, 18, 7};

        System.out.println("Array elements:");
        printArray(numbers);

        System.out.println("\nSum: " + sum(numbers));
        System.out.println("Average: " + average(numbers));
        System.out.println("Min: " + findMin(numbers));
        System.out.println("Max: " + findMax(numbers));
    }
}
