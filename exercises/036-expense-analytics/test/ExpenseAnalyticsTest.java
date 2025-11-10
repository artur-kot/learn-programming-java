
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseAnalyticsTest {

    @Test
    public void testFilterByCategoryEmpty() {
        ArrayList<String> expenses = new ArrayList<>();
        ArrayList<String> filtered = ExpenseAnalytics.filterByCategory(expenses, "Food");

        assertNotNull(filtered, "Should return a list, not null");
        assertEquals(0, filtered.size(), "Filtered list should be empty");
    }

    @Test
    public void testFilterByCategorySingle() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");

        ArrayList<String> filtered = ExpenseAnalytics.filterByCategory(expenses, "Food");
        assertEquals(1, filtered.size(), "Should return 1 matching expense");
    }

    @Test
    public void testFilterByCategoryMultiple() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");
        expenses.add("Transport:15.00");
        expenses.add("Food:30.00");
        expenses.add("Entertainment:40.00");

        ArrayList<String> filtered = ExpenseAnalytics.filterByCategory(expenses, "Food");
        assertEquals(2, filtered.size(), "Should return 2 Food expenses");

        // Verify both expenses contain "Food"
        for (String expense : filtered) {
            assertTrue(expense.contains("Food"), "Filtered expense should be Food category");
        }
    }

    @Test
    public void testFilterByCategoryNoMatches() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");
        expenses.add("Transport:15.00");

        ArrayList<String> filtered = ExpenseAnalytics.filterByCategory(expenses, "Entertainment");
        assertEquals(0, filtered.size(), "Should return empty list when no matches");
    }

    @Test
    public void testFindHighestExpenseEmpty() {
        ArrayList<String> expenses = new ArrayList<>();
        double highest = ExpenseAnalytics.findHighestExpense(expenses);

        assertEquals(0.0, highest, 0.01, "Empty list should return 0.0");
    }

    @Test
    public void testFindHighestExpenseSingle() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");

        double highest = ExpenseAnalytics.findHighestExpense(expenses);
        assertEquals(25.50, highest, 0.01, "Should return the only expense");
    }

    @Test
    public void testFindHighestExpenseMultiple() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");
        expenses.add("Transport:15.00");
        expenses.add("Entertainment:40.00");
        expenses.add("Food:30.00");

        double highest = ExpenseAnalytics.findHighestExpense(expenses);
        assertEquals(40.00, highest, 0.01, "Should find the highest expense");
    }

    @Test
    public void testFindLowestExpenseEmpty() {
        ArrayList<String> expenses = new ArrayList<>();
        double lowest = ExpenseAnalytics.findLowestExpense(expenses);

        assertEquals(0.0, lowest, 0.01, "Empty list should return 0.0");
    }

    @Test
    public void testFindLowestExpenseSingle() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");

        double lowest = ExpenseAnalytics.findLowestExpense(expenses);
        assertEquals(25.50, lowest, 0.01, "Should return the only expense");
    }

    @Test
    public void testFindLowestExpenseMultiple() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");
        expenses.add("Transport:15.00");
        expenses.add("Entertainment:40.00");
        expenses.add("Food:30.00");

        double lowest = ExpenseAnalytics.findLowestExpense(expenses);
        assertEquals(15.00, lowest, 0.01, "Should find the lowest expense");
    }

    @Test
    public void testGetAverageExpenseEmpty() {
        ArrayList<String> expenses = new ArrayList<>();
        double average = ExpenseAnalytics.getAverageExpense(expenses);

        assertEquals(0.0, average, 0.01, "Average of empty list should be 0.0");
    }

    @Test
    public void testGetAverageExpenseSingle() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");

        double average = ExpenseAnalytics.getAverageExpense(expenses);
        assertEquals(25.50, average, 0.01, "Average of single item is the item itself");
    }

    @Test
    public void testGetAverageExpenseMultiple() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:20.00");
        expenses.add("Transport:10.00");
        expenses.add("Entertainment:30.00");

        double average = ExpenseAnalytics.getAverageExpense(expenses);
        assertEquals(20.00, average, 0.01, "Average should be 20.00 (60/3)");
    }

    @Test
    public void testCheckBudgetOverBudget() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:60.00");
        expenses.add("Transport:50.00");

        String message = ExpenseAnalytics.checkBudget(expenses, 100.00);
        assertTrue(message.contains("Warning") || message.contains("over"),
                "Should indicate over budget");
        assertTrue(message.contains("10"), "Should show amount over budget");
    }

    @Test
    public void testCheckBudgetUnderBudget() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:30.00");
        expenses.add("Transport:20.00");

        String message = ExpenseAnalytics.checkBudget(expenses, 100.00);
        assertTrue(message.contains("Good") || message.contains("under") || message.contains("below"),
                "Should indicate under budget");
        assertTrue(message.contains("50"), "Should show amount under budget");
    }

    @Test
    public void testCheckBudgetExactly() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:50.00");
        expenses.add("Transport:50.00");

        String message = ExpenseAnalytics.checkBudget(expenses, 100.00);
        assertNotNull(message, "Should return a message");
        assertFalse(message.isEmpty(), "Message should not be empty");
    }

    @Test
    public void testGenerateReportDoesNotCrash() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");
        expenses.add("Transport:15.00");

        // Should not throw exception
        ExpenseAnalytics.generateReport(expenses);
        assertTrue(true, "generateReport should complete without errors");
    }

    @Test
    public void testGenerateReportEmpty() {
        ArrayList<String> expenses = new ArrayList<>();

        // Should handle empty list gracefully
        ExpenseAnalytics.generateReport(expenses);
        assertTrue(true, "generateReport should handle empty list");
    }

    @Test
    public void testGenerateReportContent() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");
        expenses.add("Transport:15.00");

        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ExpenseAnalytics.generateReport(expenses);

        System.setOut(originalOut);
        String output = outputStream.toString();

        assertTrue(output.contains("Total") || output.contains("total"),
                "Report should show total");
        assertTrue(output.length() > 0, "Report should produce output");
    }

    @Test
    public void testFilterPreservesOriginal() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");
        expenses.add("Transport:15.00");

        int originalSize = expenses.size();
        ExpenseAnalytics.filterByCategory(expenses, "Food");

        assertEquals(originalSize, expenses.size(),
                "Filter should not modify original list");
    }

    @Test
    public void testGetTotalExpensesHelper() {
        ArrayList<String> expenses = new ArrayList<>();
        expenses.add("Food:25.50");
        expenses.add("Transport:15.00");

        double total = ExpenseAnalytics.getTotalExpenses(expenses);
        assertEquals(40.50, total, 0.01, "Helper method should calculate total");
    }
}
