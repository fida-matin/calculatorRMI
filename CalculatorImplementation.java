import java.util.ArrayList;

public class CalculatorImplementation implements Calculator {

    public CalculatorImplementation() {
    }

    private ArrayList<Integer> stack = new ArrayList<Integer>();

    /**
     * FUNCTIONS
     */

    public void pushValue(int val) {
        System.out.println("Success");
    }

    public void pushOperation(String operator) {
        System.out.println("Success");
    }

    public int pop() {
        return 4;
    }

    public boolean isEmpty() {
        return true;
    }

    public int delayPop(int millis) {
        return stack.size();
    }

}
