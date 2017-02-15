package reviews.calculator_with_history;

import java.util.Optional;
import java.util.Scanner;

public class Calculator {

    public static final String EXIT_MESSAGE = "Okay! Nobody misses you" +
            "\n But here's the calculations you've done so far";
    private static final String WRONG_ACTION_MESSAGE = "Shit, wrong answer,  you'll have to calculate " +
            "with these numbers again and then you can do whatever you want";
    private HistoryHolder historyHolder = new HistoryHolder();
    private Solver solver;
    private Scanner scanner;

    private AskForAction askForAction;
    private AskForNumber askForFirstNumber;
    private AskForNumber askForSecondNumber;
    private AskForOperation askForOperation;
    private double firstNumber;
    private double secondNumber;

    public Calculator(Solver solver, Scanner scanner) {
        this.scanner = scanner;
        this.solver = solver;
        initializeAskers();
    }

    private void initializeAskers() {
        askForAction = new AskForAction(this.scanner);
        askForFirstNumber = new AskForNumber("Input the 1st number", this.scanner);
        askForSecondNumber = new AskForNumber("Input the 2nd number", this.scanner);
        askForOperation = new AskForOperation(this.scanner);
    }

    public void run() {
        askUsersUnitialNumbers();
        Action action;
        do {
            Expression expression = buildExpression();
            processExpression(expression);
            action = askAndVerifyAction();
            if (action.isChangeNumbers()) {
                askUsersUnitialNumbers();
            }
        } while (!action.isStopCondition());
        endProgram();
    }

    private void askUsersUnitialNumbers() {
        firstNumber = askForFirstNumber.ask();
        secondNumber = askForSecondNumber.ask();
    }

    private Expression buildExpression() {

        char operator = askForOperation.ask();

        return Expression.Builder.anExpression()
                .firstNumber(firstNumber)
                .secondNumber(secondNumber)
                .operator(operator).build();
    }

    private void endProgram() {
        printExitMessage();
        printHistory();
    }

    private Action askAndVerifyAction() {
        Optional<Action> possibleAction = askForAction.ask();
        verifyPossibleAction(possibleAction);
        return possibleAction.get();
    }

    private void verifyPossibleAction(Optional<Action> possibleAction) {
        if (!possibleAction.isPresent()) {
            showWrongActionMessage();
        }
    }


    private void processExpression(Expression expression) {
        Optional<Double> possibleResult = solver.solveExpression(expression);

        printResult(possibleResult);
        addToHistory(possibleResult);
    }


    private void showWrongActionMessage() {
        System.out.println(WRONG_ACTION_MESSAGE);
    }

    private void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }

    private void addToHistory(Optional<Double> pretendResult) {
        if (pretendResult.isPresent()) {
            historyHolder.add(pretendResult.get());
        }
    }

    private void printResult(Optional<Double> pretendResult) {
        if (pretendResult.isPresent()) {
            System.out.println(pretendResult.get());
        }
    }

    private void printHistory() {
        historyHolder.printHistory();
    }

}