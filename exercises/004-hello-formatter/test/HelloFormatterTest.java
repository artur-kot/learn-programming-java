
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloFormatterTest {

    @Test
    public void testOutputContainsName() {
        String input = "Diana\n25\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        HelloFormatter.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Diana"),
                "Output should contain the user's name");
    }

    @Test
    public void testOutputContainsAge() {
        String input = "Eve\n30\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        HelloFormatter.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("30"),
                "Output should contain the user's age");
    }

    @Test
    public void testUsedPrintf() {
        String input = "Frank\n28\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        HelloFormatter.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        // Check that the output is properly formatted (multiple lines suggest printf usage)
        String[] lines = output.split("\n");
        Assertions.assertTrue(lines.length >= 2,
                "Output should have at least 2 formatted lines for greeting and age");
    }
}
