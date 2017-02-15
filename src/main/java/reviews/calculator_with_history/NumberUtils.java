package reviews.calculator_with_history;

import java.util.function.IntPredicate;

public class NumberUtils {
    static boolean isValidInt(String action) {
        return action.chars().allMatch(Character::isDigit);
    }

    static boolean isValidFloat(String string) {
        IntPredicate p = (x) -> x == '.';
        return string.chars().allMatch(p.or(Character::isDigit));
    }


}