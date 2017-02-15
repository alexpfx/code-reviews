package reviews.calculator_with_history;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiFunction;

public class AskForAction {

    private static final BiFunction<String, Scanner, Optional<Action>> READ_ACTION = (menuMessage, scanner) -> {
        System.out.println(menuMessage);
        String actionString = scanner.next();
        return NumberUtils.isValidInt(actionString) ? Action.byActionNumber(Integer.parseInt(actionString)) : Optional.empty();
    };

    private static final String CHOOSE_ACTION_MENU = "Dormammu, I came to bargain! " +
            "Wanna do some extra calculations?" +
            "\n 1 - for 'Yes'" +
            "\n 2 - for 'No'" +
            "\n 3 - to change the numbers";

    private Scanner scanner;

    public AskForAction(Scanner scanner) {
        this.scanner = scanner;
    }

    public Optional<Action> ask() {
        return READ_ACTION.apply(CHOOSE_ACTION_MENU, scanner);
    }
}