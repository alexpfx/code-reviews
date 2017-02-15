package reviews.calculator_with_history;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUtils {
    public static ByteArrayOutputStream setSystemOutputAndReturnOutput() {
        ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputContent);
        System.setOut(printStream);
        return outputContent;
    }

    public static void resetSystemOutput() {
        System.setOut(null);
    }


    static Scanner getScannerWithInput(String input) {
        return new Scanner(new ByteArrayInputStream(input.getBytes()));
    }

    static Matcher<String> createIgnoreSeparatorMatcher(String expected) {
        return Matchers.equalToIgnoringWhiteSpace(expected);
    }
}