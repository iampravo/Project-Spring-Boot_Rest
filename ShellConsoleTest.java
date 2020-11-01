import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;


/**
 * Test Class with ~90% Coverage
 */
@RunWith(MockitoJUnitRunner.class)
public class ShellConsoleTest {

    @InjectMocks
    ShellConsole shellConsole;


    @Test
    public void main() {

        String input1 = "DATE";
        String input11 = "HELP DATE";
        String input2 = "PRINT \"Pravin Singh\"";
        String input22 = "HELP PRINT ";
        String input3 = "HELP";
        String input33 = "HELP HELP";
        String input4 = "TIME";
        String input44 = "HELP TIME";
        String input5 = "HELP EXIT";
        String input55 = "EXIT";


        String simulatedUserInput = input1 +
                System.getProperty("line.separator")
                + input11 + System.getProperty("line.separator")
                + input2 + System.getProperty("line.separator")
                + input22 + System.getProperty("line.separator")
                + input3 + System.getProperty("line.separator")
                + input33 + System.getProperty("line.separator")
                + input4 + System.getProperty("line.separator")
                + input44 + System.getProperty("line.separator")
                + input5 + System.getProperty("line.separator")
                + input55 + System.getProperty("line.separator");

        InputStream in1 = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in1);
        shellConsole.main(new String[0]);

    }

    @Test
    public void validateInput() {
    }
}

//todo

/**
 * Please add following dependencies on Project's pom.xml
 * <dependency>
 *             <groupId>junit</groupId>
 *             <artifactId>junit</artifactId>
 *             <version>4.11</version>
 *             <scope>test</scope>
 *         </dependency>
 *         <dependency>
 *             <groupId>commons-lang</groupId>
 *             <artifactId>commons-lang</artifactId>
 *             <version>2.6</version>
 *         </dependency>
 *         <dependency>
 *             <groupId>org.mockito</groupId>
 *             <artifactId>mockito-core</artifactId>
 *             <version>3.3.3</version>
 *             <scope>test</scope>
 *         </dependency>

 */