
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BMI Calculator - Basics Tests")
public class BMICalculatorTest {

    @Test
    @DisplayName("calculateBMI() computes correct value")
    public void testCalculateBMI() {
        assertEquals(22.86, BMICalculator.calculateBMI(70, 1.75), 0.1);
        assertEquals(25.0, BMICalculator.calculateBMI(75, 1.73), 0.1);
        assertEquals(18.5, BMICalculator.calculateBMI(65, 1.87), 0.1);
    }

    @Test
    @DisplayName("calculateBMI() throws exception for negative weight")
    public void testNegativeWeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            BMICalculator.calculateBMI(-70, 1.75);
        });
    }

    @Test
    @DisplayName("calculateBMI() throws exception for zero weight")
    public void testZeroWeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            BMICalculator.calculateBMI(0, 1.75);
        });
    }

    @Test
    @DisplayName("calculateBMI() throws exception for negative height")
    public void testNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            BMICalculator.calculateBMI(70, -1.75);
        });
    }

    @Test
    @DisplayName("calculateBMI() throws exception for zero height")
    public void testZeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> {
            BMICalculator.calculateBMI(70, 0);
        });
    }

    @Test
    @DisplayName("calculateBMI() works with various inputs")
    public void testVariousInputs() {
        assertEquals(30.0, BMICalculator.calculateBMI(90, 1.73), 0.1);
        assertEquals(20.0, BMICalculator.calculateBMI(64, 1.79), 0.1);
    }
}
