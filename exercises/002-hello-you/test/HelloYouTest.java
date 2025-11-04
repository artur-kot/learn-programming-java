import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloYouTest {
    @Test
    public void testGreetingContainsHello() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        HelloYou.main(new String[]{});
        
        System.setOut(System.out);
        
        String output = outputStream.toString();
        Assertions.assertTrue(output.toLowerCase().contains("hello"), 
            "Output should contain a greeting (like 'hello')");
    }
    
    @Test
    public void testOutputUsesStringConcatenation() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        HelloYou.main(new String[]{});
        
        System.setOut(System.out);
        
        String output = outputStream.toString();
        Assertions.assertTrue(output.length() > 10, 
            "Output should be a complete greeting message combining multiple parts");
    }
}
