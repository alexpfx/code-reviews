package reviews.calculator_with_history;

import java.util.ArrayList;
import java.util.List;

public class HistoryHolder {
    private List<Double> history = new ArrayList<>();

    public void add(Double number) {
        history.add(number);
    }

    public void printHistory() {
        history.forEach(number -> {
            System.out.print(number + " ");
        });

    }

}
