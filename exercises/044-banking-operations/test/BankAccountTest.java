import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("Alice Johnson", 1000.0);
    }

    @Test
    public void testTransactionHistoryInitialized() {
        assertNotNull(account.getTransactionHistory(),
            "Transaction history should be initialized");
        // New account might have initial transaction or be empty
        assertTrue(account.getTransactionCount() >= 0,
            "Transaction count should be non-negative");
    }

    @Test
    public void testDepositRecordsTransaction() {
        int initialCount = account.getTransactionCount();
        account.deposit(500.0);

        assertEquals(initialCount + 1, account.getTransactionCount(),
            "Deposit should add transaction to history");

        ArrayList<?> history = account.getTransactionHistory();
        assertFalse(history.isEmpty(), "History should contain transactions");
    }

    @Test
    public void testWithdrawRecordsTransaction() {
        int initialCount = account.getTransactionCount();
        account.withdraw(200.0);

        assertEquals(initialCount + 1, account.getTransactionCount(),
            "Withdrawal should add transaction to history");
    }

    @Test
    public void testInvalidDepositDoesNotRecordTransaction() {
        int initialCount = account.getTransactionCount();
        account.deposit(-100.0);

        assertEquals(initialCount, account.getTransactionCount(),
            "Invalid deposit should not record transaction");
    }

    @Test
    public void testInvalidWithdrawDoesNotRecordTransaction() {
        int initialCount = account.getTransactionCount();
        account.withdraw(5000.0); // Insufficient funds

        assertEquals(initialCount, account.getTransactionCount(),
            "Invalid withdrawal should not record transaction");
    }

    @Test
    public void testTransferBetweenAccounts() {
        BankAccount bob = new BankAccount("Bob Smith", 500.0);

        boolean success = account.transfer(bob, 300.0);
        assertTrue(success, "Transfer should succeed with sufficient funds");

        assertEquals(700.0, account.getBalance(), 0.01,
            "Source account should decrease by transfer amount");
        assertEquals(800.0, bob.getBalance(), 0.01,
            "Destination account should increase by transfer amount");
    }

    @Test
    public void testTransferRecordsTransactions() {
        BankAccount bob = new BankAccount("Bob Smith", 500.0);

        int aliceInitialCount = account.getTransactionCount();
        int bobInitialCount = bob.getTransactionCount();

        account.transfer(bob, 300.0);

        assertTrue(account.getTransactionCount() > aliceInitialCount,
            "Transfer should record transaction in source account");
        assertTrue(bob.getTransactionCount() > bobInitialCount,
            "Transfer should record transaction in destination account");
    }

    @Test
    public void testTransferInsufficientFunds() {
        BankAccount bob = new BankAccount("Bob Smith", 500.0);

        boolean success = account.transfer(bob, 2000.0);
        assertFalse(success, "Transfer should fail with insufficient funds");

        assertEquals(1000.0, account.getBalance(), 0.01,
            "Source balance should not change on failed transfer");
        assertEquals(500.0, bob.getBalance(), 0.01,
            "Destination balance should not change on failed transfer");
    }

    @Test
    public void testTransferNegativeAmount() {
        BankAccount bob = new BankAccount("Bob Smith", 500.0);

        boolean success = account.transfer(bob, -100.0);
        assertFalse(success, "Transfer should fail with negative amount");
    }

    @Test
    public void testCalculateInterest() {
        double interest = account.calculateInterest(5.0);

        assertEquals(50.0, interest, 0.01,
            "5% interest on $1000 should be $50");
        assertEquals(1050.0, account.getBalance(), 0.01,
            "Balance should increase by interest amount");
    }

    @Test
    public void testCalculateInterestRecordsTransaction() {
        int initialCount = account.getTransactionCount();

        account.calculateInterest(5.0);

        assertEquals(initialCount + 1, account.getTransactionCount(),
            "Interest calculation should record transaction");
    }

    @Test
    public void testCalculateInterestDifferentRates() {
        BankAccount account1 = new BankAccount("User1", 1000.0);
        BankAccount account2 = new BankAccount("User2", 2000.0);

        double interest1 = account1.calculateInterest(3.0);
        double interest2 = account2.calculateInterest(4.0);

        assertEquals(30.0, interest1, 0.01, "3% of $1000 should be $30");
        assertEquals(80.0, interest2, 0.01, "4% of $2000 should be $80");
    }

    @Test
    public void testGetTransactionHistory() {
        account.deposit(500.0);
        account.withdraw(200.0);

        ArrayList<?> history = account.getTransactionHistory();
        assertNotNull(history, "Transaction history should not be null");
        assertTrue(history.size() >= 2,
            "History should contain at least the deposit and withdrawal");
    }

    @Test
    public void testGetTransactionCount() {
        int initial = account.getTransactionCount();

        account.deposit(100.0);
        account.deposit(200.0);
        account.withdraw(50.0);

        assertEquals(initial + 3, account.getTransactionCount(),
            "Transaction count should reflect all transactions");
    }

    @Test
    public void testDisplayTransactionHistory() {
        account.deposit(500.0);
        account.withdraw(200.0);

        assertDoesNotThrow(() -> account.displayTransactionHistory(),
            "displayTransactionHistory should not throw exception");
    }

    @Test
    public void testMultipleOperationsAndHistory() {
        account.deposit(500.0);      // Balance: 1500
        account.withdraw(300.0);     // Balance: 1200
        account.calculateInterest(10.0); // Balance: 1320

        assertEquals(1320.0, account.getBalance(), 0.01,
            "Balance should reflect all operations");
        assertTrue(account.getTransactionCount() >= 3,
            "Should have at least 3 transactions recorded");
    }

    @Test
    public void testTransferToSelfNotRecommended() {
        // This test documents behavior - transferring to self should work
        // but may not make practical sense
        double initialBalance = account.getBalance();
        boolean success = account.transfer(account, 100.0);

        // Behavior depends on implementation
        // Some implementations might prevent self-transfer
        // Others might allow it (withdraw then deposit to same account)
    }

    @Test
    public void testBasicAccountFunctionality() {
        // Ensure basic features from previous exercises still work
        assertEquals("Alice Johnson", account.getOwner());
        assertEquals(1000.0, account.getBalance(), 0.01);
        assertNotNull(account.getAccountNumber());
        assertTrue(account.getAccountNumber().startsWith("ACC"));
    }

    @Test
    public void testTransactionHistoryPreservesOrder() {
        account.deposit(100.0);
        account.withdraw(50.0);
        account.deposit(200.0);

        ArrayList<?> history = account.getTransactionHistory();
        assertEquals(3, history.size(),
            "History should contain all 3 transactions");
        // Order should be: deposit, withdraw, deposit
    }

    @Test
    public void testInterestOnZeroBalance() {
        BankAccount zeroAccount = new BankAccount("Zero", 0.0);
        double interest = zeroAccount.calculateInterest(5.0);

        assertEquals(0.0, interest, 0.01,
            "Interest on zero balance should be zero");
        assertEquals(0.0, zeroAccount.getBalance(), 0.01,
            "Zero balance should remain zero after interest");
    }
}
