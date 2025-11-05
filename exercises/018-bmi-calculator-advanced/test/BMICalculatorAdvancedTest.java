
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BMI Calculator - Advanced Tests")
public class BMICalculatorAdvancedTest {

    @Test
    @DisplayName("calculateBMI() computes correct value")
    public void testCalculateBMI() {
        assertEquals(22.86, BMICalculatorAdvanced.calculateBMI(70, 1.75), 0.1);
        assertEquals(25.0, BMICalculatorAdvanced.calculateBMI(75, 1.73), 0.1);
        assertEquals(18.5, BMICalculatorAdvanced.calculateBMI(65, 1.87), 0.1);
    }

    @Test
    @DisplayName("interpretBMI() returns 'Underweight' for BMI < 18.5")
    public void testUnderweight() {
        assertEquals("Underweight", BMICalculatorAdvanced.interpretBMI(18.4));
        assertEquals("Underweight", BMICalculatorAdvanced.interpretBMI(15.0));
    }

    @Test
    @DisplayName("interpretBMI() returns 'Normal weight' for 18.5 <= BMI < 25")
    public void testNormalWeight() {
        assertEquals("Normal weight", BMICalculatorAdvanced.interpretBMI(18.5));
        assertEquals("Normal weight", BMICalculatorAdvanced.interpretBMI(20.0));
        assertEquals("Normal weight", BMICalculatorAdvanced.interpretBMI(24.9));
    }

    @Test
    @DisplayName("interpretBMI() returns 'Overweight' for 25 <= BMI < 30")
    public void testOverweight() {
        assertEquals("Overweight", BMICalculatorAdvanced.interpretBMI(25.0));
        assertEquals("Overweight", BMICalculatorAdvanced.interpretBMI(27.0));
        assertEquals("Overweight", BMICalculatorAdvanced.interpretBMI(29.9));
    }

    @Test
    @DisplayName("interpretBMI() returns 'Obese' for BMI >= 30")
    public void testObese() {
        assertEquals("Obese", BMICalculatorAdvanced.interpretBMI(30.0));
        assertEquals("Obese", BMICalculatorAdvanced.interpretBMI(35.0));
        assertEquals("Obese", BMICalculatorAdvanced.interpretBMI(40.0));
    }

    @Test
    @DisplayName("interpretBMI() handles boundary values correctly")
    public void testBoundaryValues() {
        assertEquals("Underweight", BMICalculatorAdvanced.interpretBMI(18.49));
        assertEquals("Normal weight", BMICalculatorAdvanced.interpretBMI(18.5));
        assertEquals("Normal weight", BMICalculatorAdvanced.interpretBMI(24.99));
        assertEquals("Overweight", BMICalculatorAdvanced.interpretBMI(25.0));
        assertEquals("Overweight", BMICalculatorAdvanced.interpretBMI(29.99));
        assertEquals("Obese", BMICalculatorAdvanced.interpretBMI(30.0));
    }

    @Test
    @DisplayName("calculateBMI() throws exception for invalid inputs")
    public void testInvalidInputs() {
        assertThrows(IllegalArgumentException.class, () -> {
            BMICalculatorAdvanced.calculateBMI(-70, 1.75);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            BMICalculatorAdvanced.calculateBMI(0, 1.75);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            BMICalculatorAdvanced.calculateBMI(70, -1.75);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            BMICalculatorAdvanced.calculateBMI(70, 0);
        });
    }
}
