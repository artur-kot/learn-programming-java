import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

class TodoEnhancedTest {

    private TodoEnhanced todo;
    private ArrayList<String> tasks;
    private ByteArrayOutputStream output;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        todo = new TodoEnhanced();
        tasks = new ArrayList<>();
        output = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(output));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    // Test basic functionality (from Exercise 033)
    @Test
    void testAddTaskBasic() {
        todo.addTask(tasks, "Buy milk");
        assertEquals(1, tasks.size());
        assertEquals("Buy milk", tasks.get(0));
    }

    @Test
    void testRemoveTaskBasic() {
        tasks.add("Task 1");
        tasks.add("Task 2");
        todo.removeTask(tasks, 0);
        assertEquals(1, tasks.size());
        assertEquals("Task 2", tasks.get(0));
    }

    @Test
    void testGetTaskCountBasic() {
        tasks.add("Task 1");
        tasks.add("Task 2");
        assertEquals(2, todo.getTaskCount(tasks));
    }

    // Test markComplete method
    @Test
    void testMarkCompleteIncomplete() {
        tasks.add("Buy groceries");
        todo.markComplete(tasks, 0);
        assertTrue(tasks.get(0).startsWith("[DONE]"), "Should add [DONE] prefix");
        assertTrue(tasks.get(0).contains("Buy groceries"), "Should preserve task description");
    }

    @Test
    void testMarkCompleteToggleBack() {
        tasks.add("Buy groceries");
        todo.markComplete(tasks, 0);
        todo.markComplete(tasks, 0);
        assertEquals("Buy groceries", tasks.get(0), "Should remove [DONE] prefix when toggling back");
    }

    @Test
    void testMarkCompleteMultipleToggle() {
        tasks.add("Task A");
        todo.markComplete(tasks, 0); // Mark complete
        String firstComplete = tasks.get(0);
        assertTrue(firstComplete.startsWith("[DONE]"));

        todo.markComplete(tasks, 0); // Mark incomplete
        assertEquals("Task A", tasks.get(0));

        todo.markComplete(tasks, 0); // Mark complete again
        assertTrue(tasks.get(0).startsWith("[DONE]"));
    }

    @Test
    void testMarkCompleteInvalidIndex() {
        tasks.add("Task 1");
        todo.markComplete(tasks, 5);
        String result = output.toString();
        assertTrue(result.contains("Invalid index"), "Should print error for invalid index");
        assertEquals("Task 1", tasks.get(0), "Should not modify task");
    }

    @Test
    void testMarkCompleteNegativeIndex() {
        tasks.add("Task 1");
        todo.markComplete(tasks, -1);
        String result = output.toString();
        assertTrue(result.contains("Invalid index"));
    }

    // Test addTaskWithPriority method
    @Test
    void testAddTaskWithPriorityHigh() {
        todo.addTaskWithPriority(tasks, "Study for exam", "HIGH");
        assertEquals(1, tasks.size());
        assertTrue(tasks.get(0).startsWith("[HIGH]"), "Should add HIGH prefix");
        assertTrue(tasks.get(0).contains("Study for exam"), "Should contain task description");
    }

    @Test
    void testAddTaskWithPriorityMedium() {
        todo.addTaskWithPriority(tasks, "Buy groceries", "MEDIUM");
        assertTrue(tasks.get(0).startsWith("[MEDIUM]"));
    }

    @Test
    void testAddTaskWithPriorityLow() {
        todo.addTaskWithPriority(tasks, "Water plants", "LOW");
        assertTrue(tasks.get(0).startsWith("[LOW]"));
    }

    @Test
    void testAddTaskWithPriorityInvalid() {
        todo.addTaskWithPriority(tasks, "Some task", "INVALID");
        assertEquals(1, tasks.size());
        assertTrue(tasks.get(0).startsWith("[MEDIUM]"), "Should default to MEDIUM for invalid priority");
    }

    @Test
    void testAddTaskWithPriorityEmpty() {
        todo.addTaskWithPriority(tasks, "", "HIGH");
        assertEquals(0, tasks.size(), "Should not add empty task");
    }

    @Test
    void testAddTaskWithPriorityNull() {
        todo.addTaskWithPriority(tasks, null, "HIGH");
        assertEquals(0, tasks.size(), "Should not add null task");
    }

    @Test
    void testAddTaskWithPriorityMultiple() {
        todo.addTaskWithPriority(tasks, "Task 1", "HIGH");
        todo.addTaskWithPriority(tasks, "Task 2", "LOW");
        todo.addTaskWithPriority(tasks, "Task 3", "MEDIUM");
        assertEquals(3, tasks.size());
        assertTrue(tasks.get(0).contains("HIGH"));
        assertTrue(tasks.get(1).contains("LOW"));
        assertTrue(tasks.get(2).contains("MEDIUM"));
    }

    // Test filterByStatus method
    @Test
    void testFilterByStatusCompleted() {
        tasks.add("Task 1");
        tasks.add("[DONE] Task 2");
        tasks.add("Task 3");
        tasks.add("[DONE] Task 4");

        ArrayList<String> completed = todo.filterByStatus(tasks, true);
        assertEquals(2, completed.size());
        assertTrue(completed.get(0).startsWith("[DONE]"));
        assertTrue(completed.get(1).startsWith("[DONE]"));
    }

    @Test
    void testFilterByStatusIncomplete() {
        tasks.add("Task 1");
        tasks.add("[DONE] Task 2");
        tasks.add("Task 3");
        tasks.add("[DONE] Task 4");

        ArrayList<String> incomplete = todo.filterByStatus(tasks, false);
        assertEquals(2, incomplete.size());
        assertFalse(incomplete.get(0).startsWith("[DONE]"));
        assertFalse(incomplete.get(1).startsWith("[DONE]"));
    }

    @Test
    void testFilterByStatusAllCompleted() {
        tasks.add("[DONE] Task 1");
        tasks.add("[DONE] Task 2");

        ArrayList<String> completed = todo.filterByStatus(tasks, true);
        assertEquals(2, completed.size());

        ArrayList<String> incomplete = todo.filterByStatus(tasks, false);
        assertEquals(0, incomplete.size());
    }

    @Test
    void testFilterByStatusNoneCompleted() {
        tasks.add("Task 1");
        tasks.add("Task 2");

        ArrayList<String> completed = todo.filterByStatus(tasks, true);
        assertEquals(0, completed.size());

        ArrayList<String> incomplete = todo.filterByStatus(tasks, false);
        assertEquals(2, incomplete.size());
    }

    @Test
    void testFilterByStatusEmpty() {
        ArrayList<String> completed = todo.filterByStatus(tasks, true);
        assertEquals(0, completed.size());
    }

    @Test
    void testFilterByStatusNull() {
        ArrayList<String> completed = todo.filterByStatus(null, true);
        assertNotNull(completed, "Should return empty list, not null");
        assertEquals(0, completed.size());
    }

    @Test
    void testFilterByStatusDoesNotModifyOriginal() {
        tasks.add("Task 1");
        tasks.add("[DONE] Task 2");
        int originalSize = tasks.size();

        todo.filterByStatus(tasks, true);
        assertEquals(originalSize, tasks.size(), "Original list should not be modified");
    }

    // Test getCompletedCount method
    @Test
    void testGetCompletedCountNone() {
        tasks.add("Task 1");
        tasks.add("Task 2");
        assertEquals(0, todo.getCompletedCount(tasks));
    }

    @Test
    void testGetCompletedCountSome() {
        tasks.add("Task 1");
        tasks.add("[DONE] Task 2");
        tasks.add("Task 3");
        tasks.add("[DONE] Task 4");
        assertEquals(2, todo.getCompletedCount(tasks));
    }

    @Test
    void testGetCompletedCountAll() {
        tasks.add("[DONE] Task 1");
        tasks.add("[DONE] Task 2");
        tasks.add("[DONE] Task 3");
        assertEquals(3, todo.getCompletedCount(tasks));
    }

    @Test
    void testGetCompletedCountEmpty() {
        assertEquals(0, todo.getCompletedCount(tasks));
    }

    @Test
    void testGetCompletedCountNull() {
        assertEquals(0, todo.getCompletedCount(null));
    }

    // Test generateSummary method
    @Test
    void testGenerateSummaryEmpty() {
        String summary = todo.generateSummary(tasks);
        assertTrue(summary.contains("No tasks"), "Should indicate no tasks");
    }

    @Test
    void testGenerateSummaryBasic() {
        tasks.add("Task 1");
        tasks.add("[DONE] Task 2");
        tasks.add("Task 3");

        String summary = todo.generateSummary(tasks);
        assertTrue(summary.contains("Total tasks: 3"), "Should show total");
        assertTrue(summary.contains("Completed: 1"), "Should show completed count");
        assertTrue(summary.contains("Remaining: 2"), "Should show remaining count");
        assertTrue(summary.contains("Progress: 33%"), "Should show percentage");
    }

    @Test
    void testGenerateSummaryAllCompleted() {
        tasks.add("[DONE] Task 1");
        tasks.add("[DONE] Task 2");

        String summary = todo.generateSummary(tasks);
        assertTrue(summary.contains("Total tasks: 2"));
        assertTrue(summary.contains("Completed: 2"));
        assertTrue(summary.contains("Remaining: 0"));
        assertTrue(summary.contains("Progress: 100%"));
    }

    @Test
    void testGenerateSummaryNoneCompleted() {
        tasks.add("Task 1");
        tasks.add("Task 2");
        tasks.add("Task 3");

        String summary = todo.generateSummary(tasks);
        assertTrue(summary.contains("Total tasks: 3"));
        assertTrue(summary.contains("Completed: 0"));
        assertTrue(summary.contains("Remaining: 3"));
        assertTrue(summary.contains("Progress: 0%"));
    }

    @Test
    void testGenerateSummaryFormat() {
        tasks.add("Task 1");
        tasks.add("[DONE] Task 2");

        String summary = todo.generateSummary(tasks);
        assertTrue(summary.contains("==="), "Should contain header decoration");
        assertTrue(summary.contains("Summary"), "Should contain Summary in header");
    }

    // Integration tests
    @Test
    void testIntegrationCompleteWorkflow() {
        // Add tasks with priority
        todo.addTaskWithPriority(tasks, "Study", "HIGH");
        todo.addTaskWithPriority(tasks, "Exercise", "LOW");
        todo.addTask(tasks, "Shopping");

        assertEquals(3, tasks.size());

        // Mark one complete
        todo.markComplete(tasks, 0);
        assertEquals(1, todo.getCompletedCount(tasks));

        // Filter
        ArrayList<String> completed = todo.filterByStatus(tasks, true);
        assertEquals(1, completed.size());

        ArrayList<String> incomplete = todo.filterByStatus(tasks, false);
        assertEquals(2, incomplete.size());

        // Summary
        String summary = todo.generateSummary(tasks);
        assertTrue(summary.contains("Total tasks: 3"));
        assertTrue(summary.contains("Completed: 1"));
    }

    @Test
    void testIntegrationMarkCompleteWithPriority() {
        todo.addTaskWithPriority(tasks, "Important task", "HIGH");
        todo.markComplete(tasks, 0);

        String task = tasks.get(0);
        assertTrue(task.contains("[DONE]"), "Should be marked complete");
        assertTrue(task.contains("HIGH"), "Should preserve priority");
        assertTrue(task.contains("Important task"), "Should preserve description");
    }

    @Test
    void testIntegrationRemoveAndCount() {
        todo.addTaskWithPriority(tasks, "Task 1", "HIGH");
        todo.addTask(tasks, "Task 2");
        todo.markComplete(tasks, 0);

        assertEquals(1, todo.getCompletedCount(tasks));

        todo.removeTask(tasks, 0);
        assertEquals(1, tasks.size());
        assertEquals(0, todo.getCompletedCount(tasks));
    }
}
