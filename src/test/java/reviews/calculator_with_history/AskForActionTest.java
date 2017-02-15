package reviews.calculator_with_history;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.Optional;

import static org.junit.Assert.*;

public class AskForActionTest {

    private AskForAction askForAction;
    private ByteArrayOutputStream output;

    @Before
    public void setUp() {
        output = TestUtils.setSystemOutputAndReturnOutput();
    }

    @After
    public void tearDown() {
        askForAction = null;
        TestUtils.resetSystemOutput();
    }

    @Test
    public void ask() throws Exception {
        askForAction = new AskForAction(TestUtils.getScannerWithInput("1\n"));
        Optional<Action> action = askForAction.ask();
        assertTrue(action.isPresent());
        assertEquals("Dormammu, I came to bargain! " +
                "Wanna do some extra calculations?" +
                "\n 1 - for 'Yes'" +
                "\n 2 - for 'No'" +
                "\n 3 - to change the numbers" + System.lineSeparator(), output.toString());

        assertEquals(Action.DO_MORE_CALCULATIONS, action.get());
    }

    @Test
    public void askWrongAction() throws Exception {
        askForAction = new AskForAction(TestUtils.getScannerWithInput("X\n"));
        Optional<Action> action = askForAction.ask();
        assertFalse(action.isPresent());
    }

}