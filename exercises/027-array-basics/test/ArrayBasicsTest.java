
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayBasicsTest {

    @Test
    public void testSumBasic() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(15, ArrayBasics.sum(arr), "Sum of {1,2,3,4,5} should be 15");
    }

    @Test
    public void testSumSingleElement() {
        int[] arr = {42};
        assertEquals(42, ArrayBasics.sum(arr), "Sum of single element should be that element");
    }

    @Test
    public void testSumNegativeNumbers() {
        int[] arr = {-5, -3, -2};
        assertEquals(-10, ArrayBasics.sum(arr), "Sum should handle negative numbers");
    }

    @Test
    public void testSumMixedNumbers() {
        int[] arr = {10, -5, 3, -2, 7};
        assertEquals(13, ArrayBasics.sum(arr), "Sum should handle mixed positive/negative");
    }

    @Test
    public void testAverageBasic() {
        int[] arr = {2, 4, 6};
        assertEquals(4.0, ArrayBasics.average(arr), 0.001, "Average of {2,4,6} should be 4.0");
    }

    @Test
    public void testAverageDecimal() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(3.0, ArrayBasics.average(arr), 0.001, "Average of {1,2,3,4,5} should be 3.0");
    }

    @Test
    public void testAverageSingleElement() {
        int[] arr = {7};
        assertEquals(7.0, ArrayBasics.average(arr), 0.001, "Average of single element should be that element");
    }

    @Test
    public void testAverageNegativeNumbers() {
        int[] arr = {-4, -2, 0, 2, 4};
        assertEquals(0.0, ArrayBasics.average(arr), 0.001, "Average should handle negative numbers");
    }

    @Test
    public void testFindMinBasic() {
        int[] arr = {5, 2, 9, 1, 7};
        assertEquals(1, ArrayBasics.findMin(arr), "Min of {5,2,9,1,7} should be 1");
    }

    @Test
    public void testFindMinSingleElement() {
        int[] arr = {42};
        assertEquals(42, ArrayBasics.findMin(arr), "Min of single element should be that element");
    }

    @Test
    public void testFindMinNegativeNumbers() {
        int[] arr = {-5, -2, -10, -3};
        assertEquals(-10, ArrayBasics.findMin(arr), "Min should handle negative numbers");
    }

    @Test
    public void testFindMinFirstElement() {
        int[] arr = {1, 5, 3, 9};
        assertEquals(1, ArrayBasics.findMin(arr), "Min should work when first element is smallest");
    }

    @Test
    public void testFindMinLastElement() {
        int[] arr = {9, 5, 3, 1};
        assertEquals(1, ArrayBasics.findMin(arr), "Min should work when last element is smallest");
    }

    @Test
    public void testFindMaxBasic() {
        int[] arr = {5, 2, 9, 1, 7};
        assertEquals(9, ArrayBasics.findMax(arr), "Max of {5,2,9,1,7} should be 9");
    }

    @Test
    public void testFindMaxSingleElement() {
        int[] arr = {42};
        assertEquals(42, ArrayBasics.findMax(arr), "Max of single element should be that element");
    }

    @Test
    public void testFindMaxNegativeNumbers() {
        int[] arr = {-5, -2, -10, -3};
        assertEquals(-2, ArrayBasics.findMax(arr), "Max should handle negative numbers");
    }

    @Test
    public void testFindMaxFirstElement() {
        int[] arr = {9, 5, 3, 1};
        assertEquals(9, ArrayBasics.findMax(arr), "Max should work when first element is largest");
    }

    @Test
    public void testFindMaxLastElement() {
        int[] arr = {1, 3, 5, 9};
        assertEquals(9, ArrayBasics.findMax(arr), "Max should work when last element is largest");
    }

    @Test
    public void testAllMethodsTogether() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(150, ArrayBasics.sum(arr), "Sum should be correct");
        assertEquals(30.0, ArrayBasics.average(arr), 0.001, "Average should be correct");
        assertEquals(10, ArrayBasics.findMin(arr), "Min should be correct");
        assertEquals(50, ArrayBasics.findMax(arr), "Max should be correct");
    }
}
