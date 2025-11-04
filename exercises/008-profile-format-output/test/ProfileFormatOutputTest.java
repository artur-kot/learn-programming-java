
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ProfileFormatOutputTest {

    @Test
    public void testOutputContainsName() {
        String input = "Frank Smith\n35\nfrank@test.com\nBoston\ntrue\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileFormatOutput.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Frank Smith"),
                "Output should contain the name");
    }

    @Test
    public void testOutputContainsAge() {
        String input = "Grace Lee\n28\ngrace@mail.com\nChicago\nfalse\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileFormatOutput.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("28"),
                "Output should contain the age");
    }

    @Test
    public void testOutputIsFormatted() {
        String input = "Henry Davis\n42\nhenry@example.org\nSeattle\ntrue\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileFormatOutput.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        // Check for multiple lines suggesting formatted output
        String[] lines = output.split("\n");
        Assertions.assertTrue(lines.length > 5,
                "Output should have multiple formatted lines (profile card structure)");
    }

    @Test
    public void testOutputContainsAllFields() {
        String input = "Iris Chen\n31\niris@domain.net\nAustin\nfalse\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileFormatOutput.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Iris Chen")
                && output.contains("31")
                && output.contains("iris@domain.net")
                && output.contains("Austin"),
                "Output should contain all entered fields");
    }
}
