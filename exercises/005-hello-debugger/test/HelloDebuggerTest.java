import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class HelloDebuggerTest {
    
    @Test
    public void testCompilationSucceeds() {
        // If this test runs, the code compiles successfully
        Assertions.assertTrue(true, "Code should compile without errors");
    }
    
    @Test
    public void testMessagePrinted() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        HelloDebugger.main(new String[]{});
        
        System.setOut(System.out);
        
        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Hello, Debug World!"), 
            "Output should contain the message");
    }
    
    @Test
    public void testNamePrinted() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        HelloDebugger.main(new String[]{});
        
        System.setOut(System.out);
        
        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Debugger"), 
            "Output should contain 'Debugger'");
    }
    
    @Test
    public void testWelcomePrinted() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        HelloDebugger.main(new String[]{});
        
        System.setOut(System.out);
        
        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Welcome to debugging"), 
            "Output should contain welcome message");
    }
}
