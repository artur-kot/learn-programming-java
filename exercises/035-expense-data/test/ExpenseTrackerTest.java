
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseTrackerTest {

    @Test
    public void testAddExpense() {
        ArrayList<String> expenses = new ArrayList<>();
        ExpenseTracker.addExpense(expenses, "Food", 25.50);

        assertEquals(1, expenses.size(), "Should have 1 expense after adding");
        assertTrue(expenses.get(0).contains("Food"), "Expense should contain category");
        assertTrue(expenses.get(0).contains("25.5"), "Expense should contain amount");
    }

    @Test
    public void testAddMultipleExpenses() {
        ArrayList<String> expenses = new ArrayList<>();
        ExpenseTracker.addExpense(expenses, "Food", 25.50);
        ExpenseTracker.addExpense(expenses, "Transport", 15.00);
        ExpenseTracker.addExpense(expenses, "Food", 30.00);

        assertEquals(3, expenses.size(), "Should have 3 expenses");
    }

    @Test
    public void testGetTotalExpensesEmpty() {
        ArrayList<String> expenses = new ArrayList<>();
        double total = ExpenseTracker.getTotalExpenses(expenses);

        assertEquals(0.0, total, 0.01, "Total of empty list should be 0");
    }

    @Test
    public void testGetTotalExpensesSingle() {
        ArrayList<String> expenses = new ArrayList<>();
        ExpenseTracker.addExpense(expenses, "Food", 25.50);

        double total = ExpenseTracker.getTotalExpenses(expenses);
        assertEquals(25.50, total, 0.01, "Total should be 25.50");
    }

    @Test
    public void testGetTotalExpensesMultiple() {
        ArrayList<String> expenses = new ArrayList<>();
        ExpenseTracker.addExpense(expenses, "Food", 25.50);
        ExpenseTracker.addExpense(expenses, "Transport", 15.00);
        ExpenseTracker.addExpense(expenses, "Entertainment", 40.00);

        double total = ExpenseTracker.getTotalExpenses(expenses);
        assertEquals(80.50, total, 0.01, "Total should be 80.50");
    }

    @Test
    public void testGetTotalByCategoryEmpty() {
        ArrayList<String> expenses = new ArrayList<>();
        double total = ExpenseTracker.getTotalByCategory(expenses, "Food");

        assertEquals(0.0, total, 0.01, "Total for category in empty list should be 0");
    }

    @Test
    public void testGetTotalByCategorySingle() {
        ArrayList<String> expenses = new ArrayList<>();
        ExpenseTracker.addExpense(expenses, "Food", 25.50);

        double total = ExpenseTracker.getTotalByCategory(expenses, "Food");
        assertEquals(25.50, total, 0.01, "Food total should be 25.50");
    }

    @Test
    public void testGetTotalByCategoryMultiple() {
        ArrayList<String> expenses = new ArrayList<>();
        ExpenseTracker.addExpense(expenses, "Food", 25.50);
        ExpenseTracker.addExpense(expenses, "Transport", 15.00);
        ExpenseTracker.addExpense(expenses, "Food", 30.00);

        double foodTotal = ExpenseTracker.getTotalByCategory(expenses, "Food");
        assertEquals(55.50, foodTotal, 0.01, "Food total should be 55.50");

        double transportTotal = ExpenseTracker.getTotalByCategory(expenses, "Transport");
        assertEquals(15.00, transportTotal, 0.01, "Transport total should be 15.00");
    }

    @Test
    public void testGetTotalByCategoryNotFound() {
        ArrayList<String> expenses = new ArrayList<>();
        ExpenseTracker.addExpense(expenses, "Food", 25.50);

        double total = ExpenseTracker.getTotalByCategory(expenses, "Entertainment");
        assertEquals(0.0, total, 0.01, "Total for non-existent category should be 0");
    }

    @Test
    public void testGetExpenseCountEmpty() {
        ArrayList<String> expenses = new ArrayList<>();
        int count = ExpenseTracker.getExpenseCount(expenses);

        assertEquals(0, count, "Count of empty list should be 0");
    }

    @Test
    public void testGetExpenseCountMultiple() {
        ArrayList<String> expenses = new ArrayList<>();
        ExpenseTracker.addExpense(expenses, "Food", 25.50);
        ExpenseTracker.addExpense(expenses, "Transport", 15.00);
        ExpenseTracker.addExpense(expenses, "Food", 30.00);

        int count = ExpenseTracker.getExpenseCount(expenses);
        assertEquals(3, count, "Count should be 3");
    }

    @Test
    public void testViewExpensesFormat() {
        ArrayList<String> expenses = new ArrayList<>();
        ExpenseTracker.addExpense(expenses, "Food", 25.50);
        ExpenseTracker.addExpense(expenses, "Transport", 15.00);

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ExpenseTracker.viewExpenses(expenses);

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains("Your Expenses"), "Should display header");
        assertTrue(output.contains("Food"), "Should display Food category");
        assertTrue(output.contains("Transport"), "Should display Transport category");
        assertTrue(output.contains("25.5"), "Should display 25.50 amount");
        assertTrue(output.contains("15"), "Should display 15.00 amount");
    }

    @Test
    public void testViewExpensesEmpty() {
        ArrayList<String> expenses = new ArrayList<>();

        // Should not throw exception on empty list
        ExpenseTracker.viewExpenses(expenses);
        assertTrue(true, "viewExpenses should handle empty list gracefully");
    }

    @Test
    public void testAddExpenseWithDecimals() {
        ArrayList<String> expenses = new ArrayList<>();
        ExpenseTracker.addExpense(expenses, "Food", 12.99);

        double total = ExpenseTracker.getTotalExpenses(expenses);
        assertEquals(12.99, total, 0.01, "Should handle decimal amounts");
    }

    @Test
    public void testAddExpenseWithZero() {
        ArrayList<String> expenses = new ArrayList<>();
        ExpenseTracker.addExpense(expenses, "Free", 0.0);

        double total = ExpenseTracker.getTotalExpenses(expenses);
        assertEquals(0.0, total, 0.01, "Should handle zero amount");
    }
}
