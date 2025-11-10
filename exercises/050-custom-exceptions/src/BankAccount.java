/**
 * BankAccount class demonstrating custom exception usage
 *
 * This class represents a bank account with validation and error handling
 * using custom exceptions.
 *
 * Concepts you'll practice:
 * - Throwing custom exceptions
 * - Using throws keyword in method signatures
 * - Input validation with exceptions
 * - Business logic error handling
 */
public class BankAccount {

    // TODO: Declare private fields
    // - accountNumber (String)
    // - balance (double)
    // - ownerName (String)


    // TODO: Create constructor
    // Method signature: public BankAccount(String accountNumber, String ownerName, double initialBalance)
    //                                      throws InvalidAccountException, TransactionFailedException
    // This constructor should:
    // 1. Call validateAccount(accountNumber) to validate the account number
    // 2. Validate that ownerName is not null or empty (throw InvalidAccountException if invalid)
    // 3. Validate that initialBalance is not negative (throw TransactionFailedException if negative)
    // 4. Initialize all fields if validation passes



    // TODO: Implement validateAccount static method
    // Method signature: public static void validateAccount(String accountNumber) throws InvalidAccountException
    // This method should validate:
    // 1. Account number is not null (throw InvalidAccountException with message "Account number cannot be null")
    // 2. Account number is not empty (throw InvalidAccountException with message "Account number cannot be empty")
    // 3. Account number is exactly 8 characters (throw InvalidAccountException with message "Account number must be 8 characters")



    // TODO: Implement withdraw method
    // Method signature: public void withdraw(double amount) throws InsufficientFundsException, TransactionFailedException
    // This method should:
    // 1. Validate that amount is positive (throw TransactionFailedException if not)
    // 2. Validate that balance is sufficient (throw InsufficientFundsException if not)
    //    Message should include: "Insufficient funds. Balance: $X.XX, Requested: $Y.YY"
    // 3. Subtract amount from balance if validation passes



    // TODO: Implement deposit method
    // Method signature: public void deposit(double amount) throws TransactionFailedException
    // This method should:
    // 1. Validate that amount is positive (throw TransactionFailedException with message "Deposit amount must be positive")
    // 2. Add amount to balance if validation passes



    // TODO: Implement getter methods
    // - public String getAccountNumber()
    // - public double getBalance()
    // - public String getOwnerName()




    // TODO: Implement toString method
    // Return a string with format: "Account[accountNumber, owner: ownerName, balance: $X.XX]"
    // Use String.format("%.2f", balance) to format balance to 2 decimal places



    public static void main(String[] args) {
        // TODO: Test your BankAccount class with various scenarios
        System.out.println("=== Testing Bank Account with Custom Exceptions ===\n");

        // Test 1: Create valid account
        System.out.println("Test 1: Creating valid account");
        try {
            // TODO: Create account with valid data
            // Example: BankAccount account = new BankAccount("12345678", "John Doe", 1000.0);
            // Print success message and account details
        } catch (/* TODO: Add exception types */ e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 2: Try invalid account number
        System.out.println("\nTest 2: Creating account with invalid account number");
        try {
            // TODO: Try to create account with invalid account number (e.g., "123")
        } catch (/* TODO: Add exception types */ e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test 3: Try withdrawal with insufficient funds
        System.out.println("\nTest 3: Withdrawing more than balance");
        try {
            // TODO: Create account and try to withdraw more than balance
        } catch (/* TODO: Add exception types */ e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test 4: Try negative deposit
        System.out.println("\nTest 4: Attempting negative deposit");
        try {
            // TODO: Create account and try to deposit negative amount
        } catch (/* TODO: Add exception types */ e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test 5: Successful transactions
        System.out.println("\nTest 5: Successful deposit and withdrawal");
        try {
            // TODO: Create account, deposit, withdraw, and display final balance
        } catch (/* TODO: Add exception types */ e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
