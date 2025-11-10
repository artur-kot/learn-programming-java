import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testConstructorAutoGeneratesAccountNumber() {
        BankAccount account1 = new BankAccount("Alice", 1000.0);
        BankAccount account2 = new BankAccount("Bob", 500.0);

        assertNotNull(account1.getAccountNumber(),
            "Account number should be auto-generated");
        assertNotNull(account2.getAccountNumber(),
            "Account number should be auto-generated");
        assertNotEquals(account1.getAccountNumber(), account2.getAccountNumber(),
            "Each account should have unique account number");
    }

    @Test
    public void testAccountNumberFormat() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        String accountNumber = account.getAccountNumber();

        assertTrue(accountNumber.startsWith("ACC"),
            "Account number should start with 'ACC'");
        assertTrue(accountNumber.length() > 3,
            "Account number should have digits after 'ACC'");
    }

    @Test
    public void testStaticAccountCount() {
        int initialCount = BankAccount.getAccountCount();

        BankAccount account1 = new BankAccount("Alice", 1000.0);
        assertEquals(initialCount + 1, BankAccount.getAccountCount(),
            "Account count should increment after creating account");

        BankAccount account2 = new BankAccount("Bob", 500.0);
        assertEquals(initialCount + 2, BankAccount.getAccountCount(),
            "Account count should increment for each new account");
    }

    @Test
    public void testConstructorInitializesFields() {
        BankAccount account = new BankAccount("Alice Johnson", 1000.0);

        assertEquals("Alice Johnson", account.getOwner(),
            "Constructor should initialize owner");
        assertEquals(1000.0, account.getBalance(), 0.01,
            "Constructor should initialize balance");
    }

    @Test
    public void testDepositValidAmount() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        boolean result = account.deposit(500.0);

        assertTrue(result, "Deposit should return true for valid amount");
        assertEquals(1500.0, account.getBalance(), 0.01,
            "Balance should increase after deposit");
    }

    @Test
    public void testDepositInvalidAmount() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        boolean result1 = account.deposit(-100.0);
        boolean result2 = account.deposit(0.0);

        assertFalse(result1, "Deposit should return false for negative amount");
        assertFalse(result2, "Deposit should return false for zero amount");
        assertEquals(1000.0, account.getBalance(), 0.01,
            "Balance should not change for invalid deposits");
    }

    @Test
    public void testWithdrawValidAmount() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        boolean result = account.withdraw(300.0);

        assertTrue(result, "Withdraw should return true for valid amount");
        assertEquals(700.0, account.getBalance(), 0.01,
            "Balance should decrease after withdrawal");
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        boolean result = account.withdraw(1500.0);

        assertFalse(result, "Withdraw should return false for insufficient funds");
        assertEquals(1000.0, account.getBalance(), 0.01,
            "Balance should not change when withdrawal fails");
    }

    @Test
    public void testWithdrawInvalidAmount() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        boolean result1 = account.withdraw(-100.0);
        boolean result2 = account.withdraw(0.0);

        assertFalse(result1, "Withdraw should return false for negative amount");
        assertFalse(result2, "Withdraw should return false for zero amount");
        assertEquals(1000.0, account.getBalance(), 0.01,
            "Balance should not change for invalid withdrawals");
    }

    @Test
    public void testGetters() {
        BankAccount account = new BankAccount("Alice Johnson", 1000.0);

        assertEquals("Alice Johnson", account.getOwner(),
            "getOwner should return owner name");
        assertEquals(1000.0, account.getBalance(), 0.01,
            "getBalance should return current balance");
        assertNotNull(account.getAccountNumber(),
            "getAccountNumber should return account number");
    }

    @Test
    public void testDisplayAccountInfo() {
        BankAccount account = new BankAccount("Alice", 1000.0);
        assertDoesNotThrow(() -> account.displayAccountInfo(),
            "displayAccountInfo should not throw exception");
    }

    @Test
    public void testMultipleTransactions() {
        BankAccount account = new BankAccount("Alice", 1000.0);

        account.deposit(500.0);  // 1500
        account.withdraw(200.0); // 1300
        account.deposit(100.0);  // 1400

        assertEquals(1400.0, account.getBalance(), 0.01,
            "Balance should reflect all transactions");
    }
}
