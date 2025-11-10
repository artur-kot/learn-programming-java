import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

class TodoListTest {

    private TodoList todoList;
    private ArrayList<String> tasks;
    private ByteArrayOutputStream output;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        todoList = new TodoList();
        tasks = new ArrayList<>();
        output = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(output));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    // Test addTask method
    @Test
    void testAddTaskSingle() {
        todoList.addTask(tasks, "Buy milk");
        assertEquals(1, tasks.size(), "Should have 1 task after adding");
        assertEquals("Buy milk", tasks.get(0), "Task content should match");
    }

    @Test
    void testAddTaskMultiple() {
        todoList.addTask(tasks, "Task 1");
        todoList.addTask(tasks, "Task 2");
        todoList.addTask(tasks, "Task 3");
        assertEquals(3, tasks.size(), "Should have 3 tasks after adding");
        assertEquals("Task 1", tasks.get(0));
        assertEquals("Task 2", tasks.get(1));
        assertEquals("Task 3", tasks.get(2));
    }

    @Test
    void testAddTaskEmpty() {
        todoList.addTask(tasks, "");
        assertEquals(0, tasks.size(), "Should not add empty task");
    }

    @Test
    void testAddTaskNull() {
        todoList.addTask(tasks, null);
        assertEquals(0, tasks.size(), "Should not add null task");
    }

    // Test viewTasks method
    @Test
    void testViewTasksEmpty() {
        todoList.viewTasks(tasks);
        String result = output.toString();
        assertTrue(result.contains("No tasks"), "Should show no tasks message");
    }

    @Test
    void testViewTasksSingle() {
        tasks.add("Buy groceries");
        todoList.viewTasks(tasks);
        String result = output.toString();
        assertTrue(result.contains("1. Buy groceries"), "Should display task with number 1");
    }

    @Test
    void testViewTasksMultiple() {
        tasks.add("Buy groceries");
        tasks.add("Study Java");
        tasks.add("Call dentist");
        todoList.viewTasks(tasks);
        String result = output.toString();
        assertTrue(result.contains("1. Buy groceries"), "Should display first task");
        assertTrue(result.contains("2. Study Java"), "Should display second task");
        assertTrue(result.contains("3. Call dentist"), "Should display third task");
    }

    @Test
    void testViewTasksNumbering() {
        tasks.add("Task A");
        tasks.add("Task B");
        todoList.viewTasks(tasks);
        String result = output.toString();
        assertTrue(result.matches("(?s).*1\\..*Task A.*"), "Should start numbering at 1");
        assertTrue(result.matches("(?s).*2\\..*Task B.*"), "Should continue numbering");
    }

    // Test removeTask method
    @Test
    void testRemoveTaskValid() {
        tasks.add("Task 1");
        tasks.add("Task 2");
        tasks.add("Task 3");
        todoList.removeTask(tasks, 1);
        assertEquals(2, tasks.size(), "Should have 2 tasks after removal");
        assertEquals("Task 1", tasks.get(0), "First task should remain");
        assertEquals("Task 3", tasks.get(1), "Third task should now be at index 1");
    }

    @Test
    void testRemoveTaskFirst() {
        tasks.add("First");
        tasks.add("Second");
        tasks.add("Third");
        todoList.removeTask(tasks, 0);
        assertEquals(2, tasks.size());
        assertEquals("Second", tasks.get(0), "Second should now be first");
    }

    @Test
    void testRemoveTaskLast() {
        tasks.add("First");
        tasks.add("Second");
        tasks.add("Third");
        todoList.removeTask(tasks, 2);
        assertEquals(2, tasks.size());
        assertEquals("First", tasks.get(0));
        assertEquals("Second", tasks.get(1));
    }

    @Test
    void testRemoveTaskInvalidNegative() {
        tasks.add("Task 1");
        tasks.add("Task 2");
        todoList.removeTask(tasks, -1);
        String result = output.toString();
        assertTrue(result.contains("Invalid index"), "Should print invalid index message");
        assertEquals(2, tasks.size(), "Should not remove any tasks");
    }

    @Test
    void testRemoveTaskInvalidTooLarge() {
        tasks.add("Task 1");
        tasks.add("Task 2");
        todoList.removeTask(tasks, 5);
        String result = output.toString();
        assertTrue(result.contains("Invalid index"), "Should print invalid index message");
        assertEquals(2, tasks.size(), "Should not remove any tasks");
    }

    @Test
    void testRemoveTaskInvalidExactlySize() {
        tasks.add("Task 1");
        tasks.add("Task 2");
        todoList.removeTask(tasks, 2); // Size is 2, so index 2 is invalid
        String result = output.toString();
        assertTrue(result.contains("Invalid index"), "Should print invalid index message");
        assertEquals(2, tasks.size(), "Should not remove any tasks");
    }

    // Test getTaskCount method
    @Test
    void testGetTaskCountEmpty() {
        assertEquals(0, todoList.getTaskCount(tasks), "Empty list should have count 0");
    }

    @Test
    void testGetTaskCountSingle() {
        tasks.add("Task 1");
        assertEquals(1, todoList.getTaskCount(tasks), "Should count 1 task");
    }

    @Test
    void testGetTaskCountMultiple() {
        tasks.add("Task 1");
        tasks.add("Task 2");
        tasks.add("Task 3");
        assertEquals(3, todoList.getTaskCount(tasks), "Should count 3 tasks");
    }

    @Test
    void testGetTaskCountNull() {
        assertEquals(0, todoList.getTaskCount(null), "Null list should return 0");
    }

    // Integration tests
    @Test
    void testIntegrationAddViewCount() {
        todoList.addTask(tasks, "Task 1");
        todoList.addTask(tasks, "Task 2");
        assertEquals(2, todoList.getTaskCount(tasks));

        output.reset();
        todoList.viewTasks(tasks);
        String result = output.toString();
        assertTrue(result.contains("1. Task 1"));
        assertTrue(result.contains("2. Task 2"));
    }

    @Test
    void testIntegrationAddRemoveView() {
        todoList.addTask(tasks, "Buy groceries");
        todoList.addTask(tasks, "Study Java");
        todoList.addTask(tasks, "Call dentist");

        todoList.removeTask(tasks, 1);

        output.reset();
        todoList.viewTasks(tasks);
        String result = output.toString();
        assertTrue(result.contains("1. Buy groceries"));
        assertTrue(result.contains("2. Call dentist"));
        assertFalse(result.contains("Study Java"), "Removed task should not appear");
    }

    @Test
    void testIntegrationRemoveAllTasks() {
        todoList.addTask(tasks, "Task 1");
        todoList.addTask(tasks, "Task 2");

        todoList.removeTask(tasks, 0);
        todoList.removeTask(tasks, 0);

        assertEquals(0, todoList.getTaskCount(tasks));

        output.reset();
        todoList.viewTasks(tasks);
        String result = output.toString();
        assertTrue(result.contains("No tasks"), "Should show no tasks after removing all");
    }
}
