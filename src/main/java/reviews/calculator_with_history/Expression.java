package reviews.calculator_with_history;

public class Expression {
    private char checker;
    private double firstNumber;
    private double secondNumber;

    private Expression(char checker, double firstNumber, double secondNumber) {
        this.checker = checker;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public char checker() {
        return checker;
    }

    public double firstNumber() {
        return firstNumber;
    }

    public double secondNumber() {
        return secondNumber;
    }

    public static final class Builder {
        private char checker;
        private double firstNumber;
        private double secondNumber;

        private Builder() {
        }

        public static Builder anExpression() {
            return new Builder();
        }

        public Builder operator(char checker) {
            this.checker = checker;
            return this;
        }

        public Builder firstNumber(double firstNumber) {
            this.firstNumber = firstNumber;
            return this;
        }

        public Builder secondNumber(double secondNumber) {
            this.secondNumber = secondNumber;
            return this;
        }

        public Expression build() {
            Expression expression = new Expression(checker, firstNumber, secondNumber);
            return expression;
        }
    }
}
