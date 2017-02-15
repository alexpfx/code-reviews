package reviews.calculator_with_history;

import java.util.Scanner;
import java.util.function.BiFunction;

public class AskForOperation {
    static final BiFunction<String, Scanner, Character> READ_OPERATION = (menuMessage, scanner) -> {
        System.out.println(menuMessage);
        String operation = scanner.next();
        return operation.charAt(0);
    };

    private static final String OPERATION_MENU = "What to do?" +
            "\n + for add" +
            "\n - for minus" +
            "\n * for multiply" +
            "\n / for divide" +
            "\n % for mod" +
            "\n ^ for first number into the power of second number";

    private Scanner scanner;

    public AskForOperation(Scanner scanner) {
        this.scanner = scanner;
    }

    public Character ask() {
        return READ_OPERATION.apply(OPERATION_MENU, scanner);
    }
}