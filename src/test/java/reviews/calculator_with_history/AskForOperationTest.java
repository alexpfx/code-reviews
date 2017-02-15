package reviews.calculator_with_history;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AskForOperationTest {
    public static ByteArrayOutputStream outputContent;
    AskForOperation askForOperation;

    @Before
    public void setUp() {
        outputContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void tearDown() throws Exception {
        askForOperation = null;
        outputContent = null;
    }

    @Test
    public void ask() throws Exception {
        askForOperation = new AskForOperation(new Scanner(new ByteArrayInputStream("*\n".getBytes())));
        Character result = askForOperation.ask();
        assertEquals("What to do?" +
                "\n + for add" +
                "\n - for minus" +
                "\n * for multiply" +
                "\n / for divide" +
                "\n % for mod" +
                "\n ^ for first number into the power of second number" + System.lineSeparator(), outputContent.toString());
        assertEquals('*', result.charValue());


    }

    @Test(expected = NoSuchElementException.class)
    public void askWrongInput() throws Exception {
        askForOperation = new AskForOperation(new Scanner(new ByteArrayInputStream("".getBytes())));
        askForOperation.ask();
    }


}