# Exercise 022: Counter - Sum Range

## Overview

Build on Exercise 021 by calculating the sum of numbers in a range. Instead of just printing each number, you'll now accumulate them into a running total. This introduces the **accumulator pattern** - a fundamental programming technique.

## What You're Learning

### The Accumulator Pattern

An **accumulator** is a variable that collects values across multiple loop iterations. The pattern is:

1. **Initialize** the accumulator to 0 (or appropriate starting value)
2. **In each iteration**, add the current value to the accumulator
3. **After the loop**, use the final accumulated value

### Example

```java
int sum = 0;  // Initialize accumulator

for (int i = 1; i <= 5; i++) {
    sum = sum + i;  // Add current value to sum
    // Or use the shorthand: sum += i;
}

System.out.println(sum);  // Output: 15 (1+2+3+4+5)
```

### The += Operator

The `+=` operator is shorthand for adding to a variable:

```java
sum = sum + i;  // Regular way
sum += i;       // Shorthand - same thing!
```

Both do the same thing, but `+=` is more concise.

## Your Task

Write a Java program that:

1. **Asks the user** for a number (representing the upper limit)
2. **Uses a for loop** to sum all numbers from 1 to that number
3. **Uses an accumulator variable** to track the running total
4. **Prints the result** with a clear message
5. **Handles invalid input** (negative or zero should prompt again)

## Example Output

```
Enter a number: 5
The sum of numbers from 1 to 5 is: 15
```

Another example:
```
Enter a number: 10
The sum of numbers from 1 to 10 is: 55
```

## Algorithm

1. Create a variable to store user input
2. Create an accumulator variable (initialized to 0)
3. Use a for loop from 1 to the user's number
4. In each iteration, add the loop counter to the accumulator
5. Display the result

## Tips

- Initialize your accumulator to 0 before the loop
- Use `sum += i` to add the current number to your total
- The formula for sum of 1 to N is: 1+2+3+...+N
  - For N=5: 1+2+3+4+5 = 15
  - For N=10: 1+2+3+4+5+6+7+8+9+10 = 55

## Starter Code

The `CounterSumRange.java` file contains the count up and count down loops from Exercise 021. Your task is to:
1. Ask the user for a number
2. Replace the counting loops with a loop that sums numbers from 1 to the user's input
3. Print the sum

## Testing

Run the tests to verify your solution:
```bash
mvn test
```

## Next Steps

You've now learned:
- Basic loops and loop modification (Exercise 021)
- Accumulators and aggregation (Exercise 022)

These are fundamental skills you'll use throughout your programming career!
