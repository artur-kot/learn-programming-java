
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ArrayBasicsTest {

    private ArrayBasics arrayBasics;
    private ByteArrayOutputStream output;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        arrayBasics = new ArrayBasics();
        output = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(output));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    // Part 1: Print Methods Tests
    @Test
    void testPrintArray() {
        int[] numbers = {1, 2, 3};
        arrayBasics.printArray(numbers);
        String result = output.toString();
        assertTrue(result.contains("1"), "Should print 1");
        assertTrue(result.contains("2"), "Should print 2");
        assertTrue(result.contains("3"), "Should print 3");
    }

    @Test
    void testPrintArrayInline() {
        output.reset();
        int[] numbers = {5, 10, 15};
        arrayBasics.printArrayInline(numbers);
        String result = output.toString().trim();
        assertTrue(result.contains("5") && result.contains("10") && result.contains("15"),
                "Should print all numbers inline");
    }

    @Test
    void testPrintArrayWithIndex() {
        output.reset();
        int[] numbers = {7, 8, 9};
        arrayBasics.printArrayWithIndex(numbers);
        String result = output.toString();
        assertTrue(result.contains("Index") && result.contains("7"),
                "Should include index and values");
    }

    // Part 2: Aggregation Tests
    @Test
    void testCalculateSumSimple() {
        int[] numbers = {1, 2, 3};
        assertEquals(6, arrayBasics.calculateSum(numbers));
    }

    @Test
    void testCalculateSumSingleElement() {
        int[] numbers = {5};
        assertEquals(5, arrayBasics.calculateSum(numbers));
    }

    @Test
    void testCalculateSumLargeNumbers() {
        int[] numbers = {100, 200, 300};
        assertEquals(600, arrayBasics.calculateSum(numbers));
    }

    @Test
    void testCalculateSumWithNegatives() {
        int[] numbers = {-5, 10, -3, 8};
        assertEquals(10, arrayBasics.calculateSum(numbers));
    }

    @Test
    void testCalculateAverageSimple() {
        int[] numbers = {1, 2, 3};
        assertEquals(2.0, arrayBasics.calculateAverage(numbers));
    }

    @Test
    void testCalculateAverageWithDecimals() {
        int[] numbers = {1, 2, 3, 4};
        assertEquals(2.5, arrayBasics.calculateAverage(numbers));
    }

    @Test
    void testFindMinSimple() {
        int[] numbers = {5, 2, 8};
        assertEquals(2, arrayBasics.findMin(numbers));
    }

    @Test
    void testFindMinNegatives() {
        int[] numbers = {-5, 0, 10};
        assertEquals(-5, arrayBasics.findMin(numbers));
    }

    @Test
    void testFindMaxSimple() {
        int[] numbers = {5, 2, 8};
        assertEquals(8, arrayBasics.findMax(numbers));
    }

    @Test
    void testFindMaxAllSame() {
        int[] numbers = {3, 3, 3};
        assertEquals(3, arrayBasics.findMax(numbers));
    }

    // Part 3: Count Tests
    @Test
    void testCountEven() {
        int[] numbers = {1, 2, 3, 4};
        assertEquals(2, arrayBasics.countEven(numbers));
    }

    @Test
    void testCountEvenAllEven() {
        int[] numbers = {2, 4, 6, 8};
        assertEquals(4, arrayBasics.countEven(numbers));
    }

    @Test
    void testCountOdd() {
        int[] numbers = {1, 2, 3, 4};
        assertEquals(2, arrayBasics.countOdd(numbers));
    }

    @Test
    void testCountOddAllOdd() {
        int[] numbers = {1, 3, 5, 7};
        assertEquals(4, arrayBasics.countOdd(numbers));
    }

    @Test
    void testCountGreaterThan() {
        int[] numbers = {1, 5, 3, 8};
        assertEquals(2, arrayBasics.countGreaterThan(numbers, 4));
    }

    @Test
    void testCountGreaterThanNone() {
        int[] numbers = {1, 2, 3};
        assertEquals(0, arrayBasics.countGreaterThan(numbers, 10));
    }

    @Test
    void testCountGreaterThanAll() {
        int[] numbers = {5, 6, 7};
        assertEquals(3, arrayBasics.countGreaterThan(numbers, 2));
    }
}
