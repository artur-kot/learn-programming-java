import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloJavaTest {
    
    @Test
    public void testHelloJavaOutput() {
        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        // Run the main method
        HelloJava.main(new String[]{});
        
        // Restore original output
        System.setOut(System.out);
        
        // Check that the output contains the expected message
        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Hello, Java World!"), 
            "Output should contain 'Hello, Java World!'");
    }
    
    @Test
    public void testOutputHasNewline() {
        // Capture console output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        // Run the main method
        HelloJava.main(new String[]{});
        
        // Restore original output
        System.setOut(System.out);
        
        // Check that println was used (which adds a newline)
        String output = outputStream.toString();
        Assertions.assertTrue(output.endsWith("\n") || output.endsWith("\r\n"), 
            "Output should end with a newline (use println, not print)");
    }
}
