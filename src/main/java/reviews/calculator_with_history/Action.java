package reviews.calculator_with_history;

import java.util.Arrays;
import java.util.Optional;

public enum Action {

    DO_MORE_CALCULATIONS(1), EXIT_AND_PRINT_HISTORY(2), CHANGE_NUMBERS(3);

    private int actionNumber;

    Action(int actionNumber) {
        this.actionNumber = actionNumber;
    }

    public static Optional<Action> byActionNumber(int actionNumber) {
        return Arrays.stream(values())
                .filter(action -> action.actionNumber == actionNumber)
                .findFirst();
    }

    public boolean isStopCondition() {
        return this == EXIT_AND_PRINT_HISTORY;
    }

    public boolean isChangeNumbers() {
        return this == CHANGE_NUMBERS;
    }
}
