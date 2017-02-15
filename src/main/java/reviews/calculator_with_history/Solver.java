package reviews.calculator_with_history;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public class Solver {
    private static final BiFunction<Double, Double, Double> SUM = (firstNumber, secondNumber) -> firstNumber + secondNumber;
    private static final BiFunction<Double, Double, Double> SUB = (firstNumber, secondNumber) -> firstNumber - secondNumber;
    private static final BiFunction<Double, Double, Double> MUL = (firstNumber, secondNumber) -> firstNumber * secondNumber;
    private static final BiFunction<Double, Double, Double> DIV = (firstNumber, secondNumber) -> firstNumber / secondNumber;
    private static final BiFunction<Double, Double, Double> MOD = (firstNumber, secondNumber) -> firstNumber % secondNumber;
    private static final BiFunction<Double, Double, Double> POW = (firstNumber, secondNumber) -> Math.pow(firstNumber, secondNumber);
    private static Map<Character, BiFunction<Double, Double, Double>> map;

    static {
        map = new HashMap<>();
        map.put('+', SUM);
        map.put('-', SUB);
        map.put('*', MUL);
        map.put('/', DIV);
        map.put('%', MOD);
        map.put('^', POW);
    }

    public Optional<Double> solveExpression(Expression expression) {
        BiFunction<Double, Double, Double> operation = map.get(expression.checker());
        if (operation == null) {
            return Optional.empty();
        }
        return Optional.of(operation.apply(expression.firstNumber(), expression.secondNumber()));
    }

}
