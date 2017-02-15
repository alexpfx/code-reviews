package reviews.calculator_with_history;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by alexandre on 14/02/2017.
 */
public class CalculatorTest {

    public static final String OUTPUT_EXPECTED_TEST_1 = "Input the 1st number\n" +
            "Input the 2nd number\n" +
            "What to do?\n" +
            " + for add\n" +
            " - for minus\n" +
            " * for multiply\n" +
            " / for divide\n" +
            " % for mod\n" +
            " ^ for first number into the power of second number\n" +
            "3.0\n" +
            "Dormammu, I came to bargain! Wanna do some extra calculations?\n" +
            " 1 - for 'Yes'\n" +
            " 2 - for 'No'\n" +
            " 3 - to change the numbers\n" +
            "Okay! Nobody misses you\n" +
            " But here's the calculations you've done so far\n" +
            "3.0";
    public static final String OUTPUT_EXPECTED_TEST_2 = "Input the 1st number\n" +
            "Input the 2nd number\n" +
            "What to do?\n" +
            " + for add\n" +
            " - for minus\n" +
            " * for multiply\n" +
            " / for divide\n" +
            " % for mod\n" +
            " ^ for first number into the power of second number\n" +
            "3.0\n" +
            "Dormammu, I came to bargain! Wanna do some extra calculations?\n" +
            " 1 - for 'Yes'\n" +
            " 2 - for 'No'\n" +
            " 3 - to change the numbers\n" +
            "What to do?\n" +
            " + for add\n" +
            " - for minus\n" +
            " * for multiply\n" +
            " / for divide\n" +
            " % for mod\n" +
            " ^ for first number into the power of second number\n" +
            "1.0\n" +
            "Dormammu, I came to bargain! Wanna do some extra calculations?\n" +
            " 1 - for 'Yes'\n" +
            " 2 - for 'No'\n" +
            " 3 - to change the numbers\n" +
            "Okay! Nobody misses you\n" +
            " But here's the calculations you've done so far\n" +
            "3.0 1.0";
    public static final String OUTPUT_EXPECTED_TEST_3 = "Input the 1st number\n" +
            "Input the 2nd number\n" +
            "What to do?\n" +
            " + for add\n" +
            " - for minus\n" +
            " * for multiply\n" +
            " / for divide\n" +
            " % for mod\n" +
            " ^ for first number into the power of second number\n" +
            "3.0\n" +
            "Dormammu, I came to bargain! Wanna do some extra calculations?\n" +
            " 1 - for 'Yes'\n" +
            " 2 - for 'No'\n" +
            " 3 - to change the numbers\n" +
            "What to do?\n" +
            " + for add\n" +
            " - for minus\n" +
            " * for multiply\n" +
            " / for divide\n" +
            " % for mod\n" +
            " ^ for first number into the power of second number\n" +
            "1.0\n" +
            "Dormammu, I came to bargain! Wanna do some extra calculations?\n" +
            " 1 - for 'Yes'\n" +
            " 2 - for 'No'\n" +
            " 3 - to change the numbers\n" +
            "Input the 1st number\n" +
            "Input the 2nd number\n" +
            "What to do?\n" +
            " + for add\n" +
            " - for minus\n" +
            " * for multiply\n" +
            " / for divide\n" +
            " % for mod\n" +
            " ^ for first number into the power of second number\n" +
            "-1.0\n" +
            "Dormammu, I came to bargain! Wanna do some extra calculations?\n" +
            " 1 - for 'Yes'\n" +
            " 2 - for 'No'\n" +
            " 3 - to change the numbers\n" +
            "Okay! Nobody misses you\n" +
            " But here's the calculations you've done so far\n" +
            "3.0 1.0 -1.0";
    Calculator calculator;
    private ByteArrayOutputStream output;

    @Before
    public void setUp() throws Exception {
        output = TestUtils.setSystemOutputAndReturnOutput();
    }

    @After
    public void tearDown() throws Exception {
        TestUtils.resetSystemOutput();

    }

    @Test
    public void runOneRound() throws Exception {
        String firstRoundInput = "1\n2\n+\n2\n";
        calculator = new Calculator(new Solver(), TestUtils.getScannerWithInput(firstRoundInput));
        calculator.run();
        assertNotNull(calculator);
        Matcher<String> expected = TestUtils.createIgnoreSeparatorMatcher(CalculatorTest.OUTPUT_EXPECTED_TEST_1);
        assertThat(output.toString(), expected);
    }

    @Test
    public void runTwoRoundsAddPowAndExit() throws Exception {
        String firstRoundInput = "1\n2\n+\n1\n^\n2\n";
        calculator = new Calculator(new Solver(), TestUtils.getScannerWithInput(firstRoundInput));
        calculator.run();
        assertNotNull(calculator);
        Matcher<String> expected = TestUtils.createIgnoreSeparatorMatcher(CalculatorTest.OUTPUT_EXPECTED_TEST_2);
        assertThat(output.toString(), expected);
    }

    @Test
    public void runTwoRoundsAddPowChangeNumbersSubExit() throws Exception {
        String firstRoundInput = "1\n2\n+\n1\n^\n3\n1\n2\n-\n2\n";
        calculator = new Calculator(new Solver(), TestUtils.getScannerWithInput(firstRoundInput));
        calculator.run();
        assertNotNull(calculator);
        Matcher<String> expected = TestUtils.createIgnoreSeparatorMatcher(CalculatorTest.OUTPUT_EXPECTED_TEST_3);
        assertThat(output.toString(), expected);
    }


}