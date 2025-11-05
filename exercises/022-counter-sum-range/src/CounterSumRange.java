
import java.util.Scanner;

public class CounterSumRange {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Solution from Exercise 021 - counts up from 1 to 10, then down from 10 to 1
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }
            
            for (int i = 10; i >= 1; i--) {
                System.out.println(i);
            }
            
            // TODO: Replace the above counting loops with:
            // 1. Ask user for a number (upper limit for the sum)
            // 2. Validate the input (must be > 0)
            // 3. Create an accumulator variable initialized to 0
            // 4. Use a for loop from 1 to the user's number
            // 5. In each iteration, add the current number to the accumulator
            // 6. After the loop, print the sum with a clear message
            //
            // Example output:
            // Enter a number: 5
            // The sum of numbers from 1 to 5 is: 15
        }
    }
}
