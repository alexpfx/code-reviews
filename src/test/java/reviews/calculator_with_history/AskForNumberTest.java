package reviews.calculator_with_history;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AskForNumberTest {

    private AskForNumber askForNumber;
    private ByteArrayOutputStream output;

    @Before
    public void setUp() {
        output = TestUtils.setSystemOutputAndReturnOutput();
    }

    @After
    public void tearDown() {
        TestUtils.resetSystemOutput();
    }

    @Test
    public void testAsk() {
        askForNumber = new AskForNumber("msg1", new Scanner(new ByteArrayInputStream("100\n".getBytes())));
        double number = askForNumber.ask();
        Assert.assertEquals(100.0, number, 0.01);
        Assert.assertEquals("msg1" + System.lineSeparator(), output.toString());
    }

    @Test(expected = InputMismatchException.class)
    public void testInvalidInput() {
        askForNumber = new AskForNumber("msg1", new Scanner(new ByteArrayInputStream("100x\n".getBytes())));
        askForNumber.ask();
    }
}