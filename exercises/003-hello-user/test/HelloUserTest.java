import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloUserTest {
    
    @Test
    public void testPromptsForInput() {
        String input = "Alice\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        HelloUser.main(new String[]{});
        
        System.setOut(System.out);
        System.setIn(System.in);
        
        String output = outputStream.toString();
        Assertions.assertTrue(output.toLowerCase().contains("name") || output.toLowerCase().contains("enter"), 
            "Program should prompt the user to enter their name");
    }
    
    @Test
    public void testGreetsWithUserInput() {
        String input = "Bob\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        HelloUser.main(new String[]{});
        
        System.setOut(System.out);
        System.setIn(System.in);
        
        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Bob"), 
            "Program should output the user's input name");
    }
    
    @Test
    public void testOutputContainsGreeting() {
        String input = "Charlie\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        HelloUser.main(new String[]{});
        
        System.setOut(System.out);
        System.setIn(System.in);
        
        String output = outputStream.toString();
        Assertions.assertTrue(output.toLowerCase().contains("hello") || output.toLowerCase().contains("welcome"), 
            "Program should greet the user");
    }
}
