
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

@DisplayName("Temperature Converter - Switch Statements Tests")
public class TemperatureConverterTest {

    private PrintStream oldOut;
    private ByteArrayOutputStream capturedOutput;

    @BeforeEach
    public void setUp() {
        oldOut = System.out;
        capturedOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capturedOutput));
    }

    private void restoreSystemOut() {
        System.setOut(oldOut);
    }

    private String getOutput() {
        restoreSystemOut();
        return capturedOutput.toString();
    }

    // ============= CONVERSION METHOD TESTS =============
    @Test
    @DisplayName("celsiusToFahrenheit() converts correctly")
    public void testCelsiusToFahrenheit() {
        restoreSystemOut();
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), 0.01);
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), 0.01);
        assertEquals(68.0, TemperatureConverter.celsiusToFahrenheit(20), 0.01);
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40), 0.01);
    }

    @Test
    @DisplayName("fahrenheitToCelsius() converts correctly")
    public void testFahrenheitToCelsius() {
        restoreSystemOut();
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32), 0.01);
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212), 0.01);
        assertEquals(20.0, TemperatureConverter.fahrenheitToCelsius(68), 0.01);
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40), 0.01);
    }

    @Test
    @DisplayName("celsiusToKelvin() converts correctly")
    public void testCelsiusToKelvin() {
        restoreSystemOut();
        assertEquals(273.15, TemperatureConverter.celsiusToKelvin(0), 0.01);
        assertEquals(373.15, TemperatureConverter.celsiusToKelvin(100), 0.01);
        assertEquals(293.15, TemperatureConverter.celsiusToKelvin(20), 0.01);
    }

    @Test
    @DisplayName("kelvinToCelsius() converts correctly")
    public void testKelvinToCelsius() {
        restoreSystemOut();
        assertEquals(0.0, TemperatureConverter.kelvinToCelsius(273.15), 0.01);
        assertEquals(100.0, TemperatureConverter.kelvinToCelsius(373.15), 0.01);
        assertEquals(20.0, TemperatureConverter.kelvinToCelsius(293.15), 0.01);
    }

    @Test
    @DisplayName("fahrenheitToKelvin() converts correctly")
    public void testFahrenheitToKelvin() {
        restoreSystemOut();
        assertEquals(273.15, TemperatureConverter.fahrenheitToKelvin(32), 0.01);
        assertEquals(373.15, TemperatureConverter.fahrenheitToKelvin(212), 0.01);
    }

    @Test
    @DisplayName("kelvinToFahrenheit() converts correctly")
    public void testKelvinToFahrenheit() {
        restoreSystemOut();
        assertEquals(32.0, TemperatureConverter.kelvinToFahrenheit(273.15), 0.01);
        assertEquals(212.0, TemperatureConverter.kelvinToFahrenheit(373.15), 0.01);
    }

    // ============= VALIDATION TESTS =============
    @Test
    @DisplayName("isValidChoice() returns true for valid choices")
    public void testIsValidChoiceTrue() {
        restoreSystemOut();
        assertTrue(TemperatureConverter.isValidChoice(0));
        assertTrue(TemperatureConverter.isValidChoice(1));
        assertTrue(TemperatureConverter.isValidChoice(3));
        assertTrue(TemperatureConverter.isValidChoice(6));
    }

    @Test
    @DisplayName("isValidChoice() returns false for invalid choices")
    public void testIsValidChoiceFalse() {
        restoreSystemOut();
        assertFalse(TemperatureConverter.isValidChoice(-1));
        assertFalse(TemperatureConverter.isValidChoice(7));
        assertFalse(TemperatureConverter.isValidChoice(10));
    }

    // ============= SWITCH ROUTING TESTS =============
    @Test
    @DisplayName("performConversion() with choice 1 (C to F)")
    public void testPerformConversionChoice1() {
        restoreSystemOut();
        assertEquals(32.0, TemperatureConverter.performConversion(1, 0), 0.01);
        assertEquals(212.0, TemperatureConverter.performConversion(1, 100), 0.01);
    }

    @Test
    @DisplayName("performConversion() with choice 2 (F to C)")
    public void testPerformConversionChoice2() {
        restoreSystemOut();
        assertEquals(0.0, TemperatureConverter.performConversion(2, 32), 0.01);
        assertEquals(100.0, TemperatureConverter.performConversion(2, 212), 0.01);
    }

    @Test
    @DisplayName("performConversion() with choice 3 (C to K)")
    public void testPerformConversionChoice3() {
        restoreSystemOut();
        assertEquals(273.15, TemperatureConverter.performConversion(3, 0), 0.01);
        assertEquals(373.15, TemperatureConverter.performConversion(3, 100), 0.01);
    }

    @Test
    @DisplayName("performConversion() with choice 4 (K to C)")
    public void testPerformConversionChoice4() {
        restoreSystemOut();
        assertEquals(0.0, TemperatureConverter.performConversion(4, 273.15), 0.01);
        assertEquals(100.0, TemperatureConverter.performConversion(4, 373.15), 0.01);
    }

    @Test
    @DisplayName("performConversion() with choice 5 (F to K)")
    public void testPerformConversionChoice5() {
        restoreSystemOut();
        assertEquals(273.15, TemperatureConverter.performConversion(5, 32), 0.01);
        assertEquals(373.15, TemperatureConverter.performConversion(5, 212), 0.01);
    }

    @Test
    @DisplayName("performConversion() with choice 6 (K to F)")
    public void testPerformConversionChoice6() {
        restoreSystemOut();
        assertEquals(32.0, TemperatureConverter.performConversion(6, 273.15), 0.01);
        assertEquals(212.0, TemperatureConverter.performConversion(6, 373.15), 0.01);
    }

    @Test
    @DisplayName("performConversion() returns NaN for invalid choice")
    public void testPerformConversionInvalidChoice() {
        restoreSystemOut();
        double result = TemperatureConverter.performConversion(7, 100);
        assertTrue(Double.isNaN(result), "Invalid choice should return NaN");
    }

    // ============= MENU DISPLAY TEST =============
    @Test
    @DisplayName("displayMenu() shows all conversion options")
    public void testDisplayMenu() {
        TemperatureConverter.displayMenu();
        String output = getOutput();

        assertTrue(output.contains("1") || output.contains("Celsius to Fahrenheit"));
        assertTrue(output.contains("2") || output.contains("Fahrenheit to Celsius"));
        assertTrue(output.contains("3") || output.contains("Celsius to Kelvin"));
        assertTrue(output.contains("4") || output.contains("Kelvin to Celsius"));
        assertTrue(output.contains("5") || output.contains("Fahrenheit to Kelvin"));
        assertTrue(output.contains("6") || output.contains("Kelvin to Fahrenheit"));
        assertTrue(output.contains("0") || output.contains("Exit"));
    }

    // ============= NEGATIVE NUMBERS TEST =============
    @Test
    @DisplayName("conversions work correctly with negative temperatures")
    public void testNegativeTemperatures() {
        restoreSystemOut();
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40), 0.01);
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40), 0.01);
    }

    // ============= DECIMAL PRECISION TEST =============
    @Test
    @DisplayName("conversions maintain decimal precision")
    public void testDecimalPrecision() {
        restoreSystemOut();
        double result = TemperatureConverter.celsiusToFahrenheit(36.6);
        assertEquals(97.88, result, 0.01);
    }
}
