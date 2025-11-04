
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ProfileStoreInfoTest {

    @Test
    public void testOutputContainsName() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileStoreInfo.main(new String[]{});

        System.setOut(System.out);

        String output = outputStream.toString();
        Assertions.assertTrue(output.toLowerCase().contains("name"),
                "Output should contain the word 'name' or display a name");
    }

    @Test
    public void testOutputContainsAge() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileStoreInfo.main(new String[]{});

        System.setOut(System.out);

        String output = outputStream.toString();
        Assertions.assertTrue(output.toLowerCase().contains("age") || output.matches(".*\\d+.*"),
                "Output should contain the word 'age' or display a numeric age");
    }

    @Test
    public void testOutputContainsEmail() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileStoreInfo.main(new String[]{});

        System.setOut(System.out);

        String output = outputStream.toString();
        Assertions.assertTrue(output.toLowerCase().contains("email") || output.contains("@"),
                "Output should contain the word 'email' or display an email address");
    }

    @Test
    public void testOutputContainsStudentStatus() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileStoreInfo.main(new String[]{});

        System.setOut(System.out);

        String output = outputStream.toString();
        Assertions.assertTrue(
                output.toLowerCase().contains("student")
                || output.toLowerCase().contains("true")
                || output.toLowerCase().contains("false"),
                "Output should contain student status");
    }
}
