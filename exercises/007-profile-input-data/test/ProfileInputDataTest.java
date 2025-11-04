
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ProfileInputDataTest {

    @Test
    public void testPromptsForName() {
        String input = "Bob\n25\nbob@example.com\ntrue\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileInputData.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.toLowerCase().contains("name"),
                "Program should prompt for name");
    }

    @Test
    public void testDisplaysEnteredName() {
        String input = "Carol\n30\ncarol@test.com\nfalse\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileInputData.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Carol"),
                "Program should display the entered name");
    }

    @Test
    public void testDisplaysEnteredAge() {
        String input = "David\n28\ndavid@mail.com\ntrue\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileInputData.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("28"),
                "Program should display the entered age");
    }

    @Test
    public void testDisplaysEnteredEmail() {
        String input = "Eve\n22\neve@domain.com\nfalse\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        ProfileInputData.main(new String[]{});

        System.setOut(System.out);
        System.setIn(System.in);

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("eve@domain.com"),
                "Program should display the entered email");
    }
}
