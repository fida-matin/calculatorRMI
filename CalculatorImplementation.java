import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorImplementation implements Calculator {

    public CalculatorImplementation() {
    }

    private ArrayList<Integer> stack = new ArrayList<Integer>();

    private static int basicGCD(int val1, int val2) {
        if (val2 == 0) {
            return val1;
        }
        return basicGCD(val2, val1 % val2);
    }

    private static int basicLCM(int val1, int val2) {
        return (val1 * val2) / basicGCD(val1, val2);
    }

    private static int findGCD(ArrayList<Integer> values) {
        if (values == null || values.isEmpty()) {
            return values.get(0);
        }

        int res = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            int currNum = values.get(i);
            res = basicGCD(res, currNum);
        }

        return res;
    }

    private static int findLCM(ArrayList<Integer> values) {
        if (values == null || values.isEmpty()) {
            return values.get(0);
        }

        int res = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            int currNum = values.get(i);
            res = basicLCM(res, currNum);
        }

        return res;
    }

    /**
     * FUNCTIONS
     */

    public void pushValue(int val) {
        stack.add(0, val);
    }

    public void pushOperation(String operator) {
        int res = 0;
        if (operator.equals("min")) {
            res = stack.get(0);
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i) < res) {
                    res = stack.get(i);
                }
            }

        } else if (operator.equals("max")) {
            res = stack.get(0);
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i) > res) {
                    res = stack.get(i);
                }
            }
        } else if (operator.equals("lcm")) {
            res = findLCM(stack);
        } else if (operator.equals("gcd")) {
            res = findGCD(stack);
        }
        stack.clear();
        stack.add(0, res);
    }

    public int pop() {
        int val = stack.get(0);
        stack.remove(0);
        return val;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int delayPop(int millis) {

        int val = stack.get(0);
        long start = System.currentTimeMillis();
        while (millis != System.currentTimeMillis() - start) {
        }

        stack.remove(0);
        return val;
    }

}
