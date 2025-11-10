# Exercise 050: Custom Exceptions

## Introduction

When you're building a banking application, generic exceptions like "Error!" or "Invalid operation!" aren't helpful. What if you could create specific exceptions like `InsufficientFundsException` or `InvalidAccountException` that clearly communicate what went wrong? That's exactly what custom exceptions enable! In this exercise, you'll learn to create your own exception classes and use them to build a robust, professional banking system with clear error handling.

## What You're Learning

**Why Create Custom Exceptions?**

Built-in Java exceptions are generic. They work for general errors, but they don't express the specific business rules of your application. Custom exceptions let you:
- Create meaningful error types specific to your domain
- Provide clearer error messages to users and developers
- Organize exception handling by business logic
- Make your code more readable and maintainable

**Checked vs Unchecked Exceptions**

In Java, there are two categories of exceptions:

**Checked Exceptions** (extend `Exception`):
- Must be declared in method signature using `throws`
- Must be caught or declared by calling methods
- Used for recoverable conditions (file not found, network timeout)
- Compiler enforces handling

**Unchecked Exceptions** (extend `RuntimeException`):
- Don't need to be declared or caught
- Used for programming errors (null pointer, invalid argument)
- Can be caught optionally
- Compiler doesn't enforce handling

```java
// Checked exception - must be declared
public void readFile(String filename) throws IOException {
    // May throw IOException
}

// Unchecked exception - optional declaration
public int divide(int a, int b) {
    if (b == 0) {
        throw new IllegalArgumentException("Division by zero");
    }
    return a / b;
}
```

**Creating Custom Exception Classes**

Creating a custom exception is simple - extend `Exception` or `RuntimeException`:

```java
// Checked custom exception
public class InsufficientFundsException extends Exception {
    // Constructor with message
    public InsufficientFundsException(String message) {
        super(message);
    }

    // Constructor with message and cause
    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

Best practices for custom exceptions:
- Give them descriptive names ending in "Exception"
- Extend `Exception` for checked, `RuntimeException` for unchecked
- Provide constructors that accept messages and causes
- Add custom fields if needed (e.g., account balance)
- Document when and why the exception is thrown

**The throw Keyword**

Use `throw` to explicitly throw an exception:

```java
public void withdraw(double amount) throws InsufficientFundsException {
    if (amount > balance) {
        throw new InsufficientFundsException(
            "Cannot withdraw $" + amount + ". Balance: $" + balance
        );
    }
    balance -= amount;
}
```

**The throws Keyword**

Use `throws` in the method signature to declare checked exceptions:

```java
// Method declares it might throw this exception
public void processPayment(double amount) throws InsufficientFundsException {
    withdraw(amount);
}
```

**Throw vs Throws - The Difference**

- `throw` - Used to actually throw an exception (in method body)
- `throws` - Used to declare exceptions a method might throw (in method signature)

```java
// "throws" declares what might be thrown
public void validate(String account) throws InvalidAccountException {
    if (account == null || account.isEmpty()) {
        throw new InvalidAccountException("Account number required"); // "throw" throws it
    }
}
```

**Exception Hierarchy**

You can create exception hierarchies for organized error handling:

```java
// Base exception
public class BankingException extends Exception {
    public BankingException(String message) {
        super(message);
    }
}

// Specific exceptions
public class InsufficientFundsException extends BankingException { }
public class InvalidAccountException extends BankingException { }
public class TransactionFailedException extends BankingException { }
```

This allows catching either specific exceptions or the parent to catch all:

```java
try {
    bank.processTransaction();
} catch (InsufficientFundsException e) {
    // Handle specifically
} catch (BankingException e) {
    // Handle any banking exception
}
```

**Adding Custom Data to Exceptions**

Exceptions can carry additional information:

```java
public class InsufficientFundsException extends Exception {
    private double requestedAmount;
    private double availableBalance;

    public InsufficientFundsException(double requested, double available) {
        super("Insufficient funds: requested $" + requested +
              ", available $" + available);
        this.requestedAmount = requested;
        this.availableBalance = available;
    }

    public double getRequestedAmount() { return requestedAmount; }
    public double getAvailableBalance() { return availableBalance; }
}
```

## Challenge

Build a banking system with custom exceptions that handle various error scenarios. You'll create three custom exception classes and a `BankAccount` class that uses them.

Your task:
1. Create custom exception classes for banking errors
2. Implement a `BankAccount` class with methods that throw these exceptions
3. Handle exceptions appropriately in calling code

## Requirements

**Custom Exception Classes:**
- `InsufficientFundsException` - checked exception, extends Exception
- `InvalidAccountException` - checked exception, extends Exception
- `TransactionFailedException` - checked exception, extends Exception
- Each should have at least one constructor accepting a message

**BankAccount Class:**
- Private fields: `accountNumber` (String), `balance` (double), `ownerName` (String)
- Constructor that validates input
- `withdraw(double amount)` throws `InsufficientFundsException` if insufficient funds
- `deposit(double amount)` throws `TransactionFailedException` if amount is negative
- `validateAccount(String accountNumber)` static method throws `InvalidAccountException` if invalid
- Getter methods for fields
- `toString()` method for display

**Validation Rules:**
- Account numbers must not be null or empty
- Account numbers must be exactly 8 characters
- Withdrawal amounts must be positive and not exceed balance
- Deposit amounts must be positive
- Owner name must not be null or empty

## Hints

<details>
<summary>Hint 1: Creating Custom Exceptions</summary>

Extend `Exception` and create a constructor that calls `super(message)`:
```java
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
```
</details>

<details>
<summary>Hint 2: Throwing Exceptions</summary>

Use `throw new ExceptionName(message)` inside your methods and declare `throws ExceptionName` in the method signature.
</details>

<details>
<summary>Hint 3: Validation</summary>

Check conditions before performing operations. If validation fails, throw the appropriate custom exception with a descriptive message.
</details>

<details>
<summary>Hint 4: Account Number Validation</summary>

Use `String` methods like `isEmpty()` and `.length()` to validate the account number format.
</details>

## Expected Behavior

Your custom exceptions should enable clear error handling:

```
Creating account with valid data: Success
Creating account with invalid account number: Throws InvalidAccountException

Withdrawing $50 from account with $100 balance: Success
Withdrawing $150 from account with $100 balance: Throws InsufficientFundsException

Depositing $50: Success
Depositing -$20: Throws TransactionFailedException

Validating account "12345678": Success
Validating account "123": Throws InvalidAccountException
Validating account null: Throws InvalidAccountException
```

## Testing Instructions

Run the tests to verify your implementation:

```bash
cd exercises/050-custom-exceptions
mvn test
```

All tests should pass, demonstrating proper custom exception creation and usage.

## Reflection Questions

After completing this exercise, consider:

1. When should you create a custom exception vs using built-in ones?
2. What's the difference between checked and unchecked exceptions, and when would you use each?
3. How do custom exceptions make your code more maintainable?
4. Why is it important to provide descriptive exception messages?
5. How does the exception hierarchy help organize error handling?

## Next Steps

With exception handling mastered, you're ready to move on to File I/O operations, where proper exception handling is essential for working with external resources!

## Read More

- [Creating Exception Classes](https://docs.oracle.com/javase/tutorial/essential/exceptions/creating.html)
- [Checked vs Unchecked Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html)
- [Exception Class Hierarchy](https://docs.oracle.com/javase/tutorial/essential/exceptions/throwing.html)
- [Best Practices for Exception Handling](https://www.oracle.com/technical-resources/articles/java/effective-exceptions.html)
