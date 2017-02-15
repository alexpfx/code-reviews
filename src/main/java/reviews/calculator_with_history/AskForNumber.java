package reviews.calculator_with_history;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.BiFunction;

public class AskForNumber {
    private static final BiFunction<String, Scanner, Double> READ_NUMBER_FUNCTION = (menuMessage, scanner) -> {
        System.out.println(menuMessage);
        String input = scanner.next();
        if (NumberUtils.isValidFloat(input)) {
            return Double.valueOf(input);
        }
        throw new InputMismatchException("not a valid number!");
    };

    private final String menuMessage;
    private final Scanner scanner;


    public AskForNumber(String menuMessage, Scanner scanner) {
        this.menuMessage = menuMessage;
        this.scanner = scanner;
    }

    public double ask() {
        return READ_NUMBER_FUNCTION.apply(menuMessage, scanner);
    }

}
