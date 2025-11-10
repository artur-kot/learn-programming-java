import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * BankAccount - Enhanced with transaction history and advanced operations
 *
 * Your task: Add inner Transaction class, record transaction history,
 * implement transfers and interest calculation
 *
 * This builds on Exercise 43. Enhance your existing BankAccount!
 *
 * Concepts you'll practice:
 * - Inner classes
 * - Object references
 * - Composition (objects containing objects)
 * - Transaction history
 * - Advanced banking operations
 */
public class BankAccount {

    // Static fields for auto-generating account numbers
    private static int nextAccountNumber = 1001;
    private static int accountCount = 0;

    // Instance fields
    private String owner;
    private double balance;
    private String accountNumber;

    // TODO: Add private field transactionHistory (ArrayList<Transaction>)


    // TODO: Create inner Transaction class
    // Requirements:
    // - Private fields: type (String), amount (double), timestamp (String), balanceAfter (double)
    // - Constructor: Transaction(String type, double amount)
    //   * Initialize type and amount from parameters
    //   * Set timestamp to current date/time
    //   * Set balanceAfter to current account balance
    // - Getter methods: getType(), getAmount(), getTimestamp(), getBalanceAfter()
    // - toString() method that returns formatted transaction string


    // Constructor
    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
        this.accountNumber = "ACC" + nextAccountNumber;
        nextAccountNumber++;
        accountCount++;

        // TODO: Initialize transactionHistory ArrayList

    }

    // TODO: Modify deposit method to record transactions
    // After successful deposit, add Transaction to history with type "Deposit"
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            // TODO: Add transaction record
            return true;
        }
        return false;
    }

    // TODO: Modify withdraw method to record transactions
    // After successful withdrawal, add Transaction to history with type "Withdrawal"
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            // TODO: Add transaction record
            return true;
        }
        return false;
    }

    // TODO: Implement transfer method
    // - Takes BankAccount toAccount and double amount as parameters
    // - Returns boolean (true if successful, false if failed)
    // - Should withdraw from this account and deposit to target account
    // - Consider using special transaction types: "Transfer Out" and "Transfer In"
    // - Only complete transfer if withdrawal succeeds


    // TODO: Implement calculateInterest method
    // - Takes double annualRate as parameter (e.g., 5.0 for 5%)
    // - Returns double (the interest amount)
    // - Calculate interest = balance * (annualRate / 100.0)
    // - Add interest to balance
    // - Record transaction with type "Interest"


    // TODO: Implement getTransactionHistory method
    // - Returns ArrayList<Transaction>


    // TODO: Implement getTransactionCount method
    // - Returns int (number of transactions)


    // TODO: Implement displayTransactionHistory method
    // - Prints all transactions in a formatted way
    // - Should include header with account number
    // - Loop through transactions and print each one


    // Existing getter methods
    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner: " + owner);
        System.out.printf("Balance: $%.2f%n", balance);
    }

    // Main method for testing
    public static void main(String[] args) {
        BankAccount alice = new BankAccount("Alice Johnson", 1000.0);
        BankAccount bob = new BankAccount("Bob Smith", 500.0);

        System.out.println("=== Initial Accounts ===");
        alice.displayAccountInfo();
        System.out.println();
        bob.displayAccountInfo();

        System.out.println("\n=== Performing Transactions ===");
        alice.deposit(500.0);
        System.out.println("Alice deposited $500");

        alice.withdraw(200.0);
        System.out.println("Alice withdrew $200");

        System.out.println("\n=== Transfer Test ===");
        boolean success = alice.transfer(bob, 300.0);
        System.out.println("Transfer $300 from Alice to Bob: " + success);

        System.out.println("\nAlice's balance: $" + alice.getBalance());
        System.out.println("Bob's balance: $" + bob.getBalance());

        System.out.println("\n=== Interest Calculation ===");
        double interest = alice.calculateInterest(5.0);
        System.out.printf("Alice earned $%.2f in interest%n", interest);
        System.out.println("Alice's new balance: $" + alice.getBalance());

        System.out.println("\n=== Transaction History ===");
        alice.displayTransactionHistory();

        System.out.println("\n=== Bob's Transaction History ===");
        bob.displayTransactionHistory();
    }
}
