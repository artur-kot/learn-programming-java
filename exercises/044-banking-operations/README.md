# Exercise 044: Banking Operations

## Introduction

You've built a solid foundation with encapsulated accounts and account management. Now let's implement more sophisticated operations that real banks perform: transferring money between accounts, tracking transaction history, and calculating interest.

This exercise introduces powerful OOP concepts: **object references** (how objects interact), **inner classes** (classes within classes), and **composition** (objects containing other objects).

## What You're Learning

**Object References:**

In Java, when you pass an object to a method, you're passing a reference to that object, not a copy. This means you can modify the original object:

```java
public void transfer(BankAccount from, BankAccount to, double amount) {
    from.withdraw(amount);  // Modifies the original 'from' account
    to.deposit(amount);     // Modifies the original 'to' account
}
```

Both `from` and `to` are references to existing account objects. Changes made through these references affect the original objects.

Think of it like this: If I give you the address of my house, you can visit and rearrange furniture. You're not working on a copy of my house - you're modifying the real thing!

**Inner Classes:**

An inner class is a class defined inside another class. It has special access to the outer class's members:

```java
public class BankAccount {
    private double balance;

    // Inner class
    public class Transaction {
        private String type;
        private double amount;
        private String date;

        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
            this.date = getCurrentDate();
        }

        // Can access outer class's private members!
        public double getBalanceAfterTransaction() {
            return balance; // Has access to BankAccount's balance
        }
    }
}
```

**Why use inner classes?**
- Logical grouping: Transaction only makes sense in the context of BankAccount
- Access to outer class: Inner class can access outer class's private members
- Encapsulation: Hide implementation details from outside users
- Organization: Keep related classes together

**Composition:**

Composition means building complex objects by combining simpler ones. Instead of inheritance ("is-a" relationship), composition uses a "has-a" relationship:

- A BankAccount **has-a** list of Transactions
- A Car **has-an** Engine
- A Computer **has-a** Processor

In this exercise, BankAccount will contain a list of Transaction objects. This is composition - BankAccount is composed of Transaction objects.

```java
public class BankAccount {
    private ArrayList<Transaction> transactionHistory;

    public void deposit(double amount) {
        balance += amount;
        // Record this transaction
        transactionHistory.add(new Transaction("Deposit", amount));
    }
}
```

**Working with Dates:**

For transaction timestamps, you can use simple strings or the `LocalDateTime` class:

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

String timestamp = LocalDateTime.now().format(
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
);
```

**Transfer Operations:**

Transfers must be atomic - they should either fully succeed or fully fail. If you can't withdraw from the source account, don't deposit to the destination:

```java
public boolean transfer(BankAccount to, double amount) {
    if (this.withdraw(amount)) {  // Try to withdraw
        to.deposit(amount);        // If successful, deposit
        return true;
    }
    return false;  // Transfer failed
}
```

## Challenge

Your task: **Enhance the BankAccount class with transfers, transaction history tracking using an inner Transaction class, and interest calculation.**

This builds on Exercise 43. You'll add advanced features to your existing account system!

## Requirements

**Part 1: Create Transaction Inner Class**

Inside BankAccount class, create a `Transaction` inner class:

**Private fields:**
- `type` (String) - "Deposit", "Withdrawal", "Transfer Out", "Transfer In", "Interest"
- `amount` (double) - transaction amount
- `timestamp` (String) - date/time of transaction
- `balanceAfter` (double) - balance after this transaction

**Constructor:**
- Takes type and amount
- Automatically sets timestamp to current date/time
- Stores current balance after transaction

**Getter methods:**
- `getType()`, `getAmount()`, `getTimestamp()`, `getBalanceAfter()`

**Display method:**
- `toString()` - returns formatted string with transaction details

**Part 2: Enhance BankAccount Class**

Add to your existing BankAccount class:

**Private field:**
- `transactionHistory` (ArrayList<Transaction>) - stores all transactions

**Modified methods:**
Update `deposit()` and `withdraw()` to record transactions:
- After successful operation, add Transaction to history
- Use appropriate transaction type

**New methods:**
- `transfer(BankAccount toAccount, double amount)` - transfer money to another account
  - Withdraw from this account
  - Deposit to target account
  - Record transaction in both accounts' histories
  - Return true if successful, false if failed

- `calculateInterest(double annualRate)` - calculate and add interest
  - Calculate interest based on current balance and rate
  - Add interest to balance
  - Record as "Interest" transaction
  - Return the interest amount

- `getTransactionHistory()` - return the list of transactions

- `getTransactionCount()` - return number of transactions

- `displayTransactionHistory()` - print all transactions in formatted way

## Hints

<details>
<summary>Hint 1: Inner Class Structure</summary>

Place the Transaction class inside BankAccount:
```java
public class BankAccount {
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    // Inner class
    public class Transaction {
        private String type;
        private double amount;
        private String timestamp;
        private double balanceAfter;

        // Constructor and methods...
    }

    // Rest of BankAccount methods...
}
```

</details>

<details>
<summary>Hint 2: Recording Transactions</summary>

Initialize the list in constructor and add transactions after operations:
```java
public BankAccount(String owner, double initialBalance) {
    // ... other initialization
    this.transactionHistory = new ArrayList<>();
}

public boolean deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount));
        return true;
    }
    return false;
}
```

</details>

<details>
<summary>Hint 3: Getting Current Timestamp</summary>

Simple approach using LocalDateTime:
```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public Transaction(String type, double amount) {
    this.type = type;
    this.amount = amount;
    this.balanceAfter = balance; // Access outer class field
    this.timestamp = LocalDateTime.now().format(
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    );
}
```

Or simpler with just date:
```java
import java.util.Date;

this.timestamp = new Date().toString();
```

</details>

<details>
<summary>Hint 4: Transfer Method</summary>

Transfer withdraws from current account and deposits to target:
```java
public boolean transfer(BankAccount toAccount, double amount) {
    if (this.withdraw(amount)) {
        toAccount.deposit(amount);
        // Transactions are already recorded by withdraw/deposit
        return true;
    }
    return false;
}
```

But you may want to use special transaction types like "Transfer Out" and "Transfer In" instead of "Withdrawal" and "Deposit".

</details>

<details>
<summary>Hint 5: Interest Calculation</summary>

Calculate interest as a percentage of balance:
```java
public double calculateInterest(double annualRate) {
    double interest = balance * (annualRate / 100.0);
    balance += interest;
    transactionHistory.add(new Transaction("Interest", interest));
    return interest;
}
```

For example, 5% annual rate on $1000 = $50 interest.

</details>

<details>
<summary>Hint 6: Display Transaction History</summary>

Loop through transactions and print each one:
```java
public void displayTransactionHistory() {
    System.out.println("Transaction History for " + accountNumber + ":");
    System.out.println("---------------------------------------------");
    for (Transaction t : transactionHistory) {
        System.out.println(t.toString());
    }
}
```

</details>

## Expected Behavior

Example usage:
```java
BankAccount alice = new BankAccount("Alice Johnson", 1000.0);
BankAccount bob = new BankAccount("Bob Smith", 500.0);

alice.deposit(500.0);
alice.withdraw(200.0);

System.out.println("Alice's balance: $" + alice.getBalance());
// Output: Alice's balance: $1300.0

// Transfer from Alice to Bob
boolean success = alice.transfer(bob, 300.0);
System.out.println("Transfer successful? " + success);
// Output: Transfer successful? true

System.out.println("Alice's balance after transfer: $" + alice.getBalance());
// Output: Alice's balance after transfer: $1000.0

System.out.println("Bob's balance after transfer: $" + bob.getBalance());
// Output: Bob's balance after transfer: $800.0

// Calculate interest (5% annual rate)
double interest = alice.calculateInterest(5.0);
System.out.println("Interest earned: $" + interest);
// Output: Interest earned: $50.0

System.out.println("Alice's new balance: $" + alice.getBalance());
// Output: Alice's new balance: $1050.0

// Display transaction history
alice.displayTransactionHistory();
// Output:
// Transaction History for ACC1001:
// ---------------------------------------------
// 2025-11-10 14:30:15 | Deposit | $500.00 | Balance: $1500.00
// 2025-11-10 14:30:20 | Withdrawal | $200.00 | Balance: $1300.00
// 2025-11-10 14:30:25 | Transfer Out | $300.00 | Balance: $1000.00
// 2025-11-10 14:30:30 | Interest | $50.00 | Balance: $1050.00

System.out.println("\nTotal transactions: " + alice.getTransactionCount());
// Output: Total transactions: 4
```

## How to Test Your Solution

**Using Maven:**
```bash
cd exercises/044-banking-operations
mvn test
```

**Manual Testing:**
```bash
cd exercises/044-banking-operations/src
javac BankAccount.java
# Test using main method or jshell
```

## Reflection Questions

1. **What's the difference between copying an object and passing a reference?** How does this affect transfers?
2. **Why make Transaction an inner class?** Could it be a separate class? What are the trade-offs?
3. **What happens if a transfer fails midway?** How does your implementation handle this?
4. **Why store balanceAfter in each transaction?** How is this useful?
5. **Could you implement transaction categories** (e.g., "Food", "Rent")? How would you extend the Transaction class?
6. **What if you wanted to implement transaction reversal?** How would you design this feature?
7. **How would you implement a monthly statement feature** that shows all transactions for a specific month?

## Next Steps

Congratulations! You've completed the Bank Account OOP series. You now understand:
- Encapsulation and data hiding
- Static members vs instance members
- Object references and how objects interact
- Inner classes and composition
- Building complex systems with multiple classes

Next, you'll explore **Inheritance and Polymorphism** - learning how classes can extend other classes and share behavior through inheritance hierarchies. You'll create shape classes, implement abstract classes, and build truly flexible object-oriented systems!

## Read More

- [Inner Classes in Java](https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
- [Object References](https://www.baeldung.com/java-pass-by-value-or-pass-by-reference)
- [Composition vs Inheritance](https://www.baeldung.com/java-composition-aggregation-association)
- [Working with LocalDateTime](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html)
- [ArrayList of Custom Objects](https://www.geeksforgeeks.org/arraylist-of-arraylist-in-java/)
