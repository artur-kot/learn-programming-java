import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("Alice Johnson", "ACC001", 1000.0);
    }

    @Test
    public void testConstructorInitializesFields() {
        assertEquals("Alice Johnson", account.getOwner(),
            "Constructor should initialize owner field");
        assertEquals("ACC001", account.getAccountNumber(),
            "Constructor should initialize accountNumber field");
        assertEquals(1000.0, account.getBalance(), 0.01,
            "Constructor should initialize balance field");
    }

    @Test
    public void testGetBalance() {
        assertEquals(1000.0, account.getBalance(), 0.01,
            "getBalance should return the current balance");
    }

    @Test
    public void testGetOwner() {
        assertEquals("Alice Johnson", account.getOwner(),
            "getOwner should return the owner name");
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals("ACC001", account.getAccountNumber(),
            "getAccountNumber should return the account number");
    }

    @Test
    public void testDepositValidAmount() {
        boolean result = account.deposit(500.0);
        assertTrue(result, "deposit should return true for valid amount");
        assertEquals(1500.0, account.getBalance(), 0.01,
            "Balance should increase after valid deposit");
    }

    @Test
    public void testDepositZeroAmount() {
        boolean result = account.deposit(0.0);
        assertFalse(result, "deposit should return false for zero amount");
        assertEquals(1000.0, account.getBalance(), 0.01,
            "Balance should not change for zero deposit");
    }

    @Test
    public void testDepositNegativeAmount() {
        boolean result = account.deposit(-100.0);
        assertFalse(result, "deposit should return false for negative amount");
        assertEquals(1000.0, account.getBalance(), 0.01,
            "Balance should not change for negative deposit");
    }

    @Test
    public void testWithdrawValidAmount() {
        boolean result = account.withdraw(300.0);
        assertTrue(result, "withdraw should return true for valid amount");
        assertEquals(700.0, account.getBalance(), 0.01,
            "Balance should decrease after valid withdrawal");
    }

    @Test
    public void testWithdrawExactBalance() {
        boolean result = account.withdraw(1000.0);
        assertTrue(result, "withdraw should return true when withdrawing exact balance");
        assertEquals(0.0, account.getBalance(), 0.01,
            "Balance should be zero after withdrawing all funds");
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        boolean result = account.withdraw(1500.0);
        assertFalse(result, "withdraw should return false for insufficient funds");
        assertEquals(1000.0, account.getBalance(), 0.01,
            "Balance should not change when withdrawal fails");
    }

    @Test
    public void testWithdrawNegativeAmount() {
        boolean result = account.withdraw(-100.0);
        assertFalse(result, "withdraw should return false for negative amount");
        assertEquals(1000.0, account.getBalance(), 0.01,
            "Balance should not change for negative withdrawal");
    }

    @Test
    public void testWithdrawZeroAmount() {
        boolean result = account.withdraw(0.0);
        assertFalse(result, "withdraw should return false for zero amount");
        assertEquals(1000.0, account.getBalance(), 0.01,
            "Balance should not change for zero withdrawal");
    }

    @Test
    public void testMultipleTransactions() {
        account.deposit(500.0);  // 1500
        account.withdraw(200.0); // 1300
        account.deposit(100.0);  // 1400
        account.withdraw(400.0); // 1000

        assertEquals(1000.0, account.getBalance(), 0.01,
            "Balance should reflect all transactions correctly");
    }

    @Test
    public void testDepositAndWithdrawReturnValues() {
        assertTrue(account.deposit(100.0),
            "Valid deposit should return true");
        assertFalse(account.deposit(-50.0),
            "Invalid deposit should return false");
        assertTrue(account.withdraw(50.0),
            "Valid withdrawal should return true");
        assertFalse(account.withdraw(2000.0),
            "Invalid withdrawal should return false");
    }

    @Test
    public void testNewAccountWithZeroBalance() {
        BankAccount zeroAccount = new BankAccount("Bob Smith", "ACC002", 0.0);
        assertEquals(0.0, zeroAccount.getBalance(), 0.01,
            "New account should accept zero initial balance");

        zeroAccount.deposit(100.0);
        assertEquals(100.0, zeroAccount.getBalance(), 0.01,
            "Should be able to deposit into zero-balance account");
    }

    @Test
    public void testDisplayAccountInfo() {
        // This test just ensures the method exists and doesn't throw an exception
        assertDoesNotThrow(() -> account.displayAccountInfo(),
            "displayAccountInfo should not throw an exception");
    }
}
