
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ProfileValidateEmailTest {

    @Test
    public void testValidEmailAccepted() {
        String input = "John Doe\n30\njohn@example.com\nPortland\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileValidateEmail.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("john@example.com"),
                "Valid email should be accepted and displayed");
    }

    @Test
    public void testInvalidEmailRejected() {
        String input = "Jane Smith\n28\ninvalidemail.com\nDenver\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileValidateEmail.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString().toLowerCase();
        Assertions.assertTrue(output.contains("invalid") || output.contains("error") || output.contains("@"),
                "Invalid email should trigger an error message");
    }

    @Test
    public void testEmailValidationMessage() {
        String input = "Bob Johnson\n45\nbob.example.com\nMiami\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileValidateEmail.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        // Should not display the city when email is invalid
        Assertions.assertFalse(output.contains("Miami") && output.contains("Bob Johnson") && output.contains("Profile"),
                "Should not display full profile when email is invalid");
    }

    @Test
    public void testValidEmailDisplaysProfile() {
        String input = "Carol White\n33\ncarol@test.org\nAustin\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileValidateEmail.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Carol White") && output.contains("Austin"),
                "Valid email should allow full profile to be displayed");
    }
}
