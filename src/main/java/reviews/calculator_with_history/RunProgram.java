package reviews.calculator_with_history;

import java.util.Scanner;

public class RunProgram {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new Solver(), new Scanner(System.in));
        calculator.run();

    }
}
