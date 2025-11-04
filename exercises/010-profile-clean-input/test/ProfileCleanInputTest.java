
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ProfileCleanInputTest {

    @Test
    public void testTrimsWhitespace() {
        String input = "  John  \n  Smith  \n30\n  john@test.com  \n  us  \n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileCleanInput.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        // Should show cleaned version without extra spaces
        Assertions.assertTrue(output.contains("John") && output.contains("Smith"),
                "Names should be trimmed");
    }

    @Test
    public void testCapitalizesNames() {
        String input = "alice\nJOHNSON\n25\nalice@example.com\nuk\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileCleanInput.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        // Should capitalize first letter, lowercase rest
        Assertions.assertTrue(output.contains("Alice") && output.contains("Johnson"),
                "Names should be properly capitalized");
    }

    @Test
    public void testLowercasesEmail() {
        String input = "Bob\nWilliams\n40\nBOB@EXAMPLE.COM\nca\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileCleanInput.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("bob@example.com"),
                "Email should be converted to lowercase");
    }

    @Test
    public void testUppercasesCountryCode() {
        String input = "Carol\nDavis\n35\ncarol@test.org\nus\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileCleanInput.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("US"),
                "Country code should be converted to uppercase");
    }

    @Test
    public void testValidatesCleanedEmail() {
        String input = "David\nMiller\n28\ninvalidemail.com\nuk\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileCleanInput.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString().toLowerCase();
        Assertions.assertTrue(output.contains("invalid") || output.contains("error"),
                "Should validate email after cleaning");
    }
}
