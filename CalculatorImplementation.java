
// Fida Matin - a1798239
// University of Adelaide
// 06 Aug 2023
import java.util.ArrayList;
import java.util.Arrays;

// Implementation File
public class CalculatorImplementation implements Calculator {
    public CalculatorImplementation() {
    }

    // create an ArrayList to act as the stack for the server
    private ArrayList<Integer> stack = new ArrayList<Integer>();

    // basicGCD returns the GCD between 2 numbers
    private static int basicGCD(int val1, int val2) {
        // base case - if val2 is 0 it means that the previous val1 is divisble by val2,
        // which has now become val1
        if (val2 == 0) {
            return val1;
        }
        // recursively iterate until a divisible combination is found
        return basicGCD(val2, val1 % val2);
    }

    // basicLCM returns the LCM between 2 numbers
    private static int basicLCM(int val1, int val2) {
        // LCM is the product divided by the GCD of the two values
        return (val1 * val2) / basicGCD(val1, val2);
    }

    // findGCD returns the GCD between all values in the stack
    private static int findGCD(ArrayList<Integer> values) {
        // store result
        int res = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            int currNum = values.get(i);
            // compare the previus GCD with the current number, to get new GCD
            res = basicGCD(res, currNum);
        }

        return res;
    }

    // findLCM returns the LCM between all values in the stack
    private static int findLCM(ArrayList<Integer> values) {
        // store result
        int res = values.get(0);
        for (int i = 0; i < values.size(); i++) {
            int currNum = values.get(i);
            // compare the previous LCM with the current number, to get new LCM
            res = basicLCM(res, currNum);
        }

        return res;
    }

    /**
     * FUNCTIONS FROM INTERFACE
     */

    public void pushValue(int val) {
        // add to top of stack
        stack.add(0, val);
    }

    public void pushOperation(String operator) {
        // check through all operations
        // stack is empty do nothing
        if (stack == null || stack.isEmpty()) {
            return;
        }
        // initialise result value
        int res = 0;
        // if "min" go through all values and store the minimum value
        if (operator.equals("min")) {
            res = stack.get(0);
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i) < res) {
                    res = stack.get(i);
                }
            }
            // if "max" go through all values and store the maximum value
        } else if (operator.equals("max")) {
            res = stack.get(0);
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i) > res) {
                    res = stack.get(i);
                }
            }
            // if "lcm" run function to find LCM of all values
        } else if (operator.equals("lcm")) {
            res = findLCM(stack);
            // if "gcd" run function to find GCD of all values
        } else if (operator.equals("gcd")) {
            res = findGCD(stack);
        }
        // clear stack and replace with the result
        stack.clear();
        stack.add(0, res);
    }

    // pop removes the last added element from the stack and returns the value
    public int pop() {
        int val = stack.get(0);
        stack.remove(0);
        return val;
    }

    // use the pre-existing isEmpty boolean function for ArrayLists
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // use the currentTimeMillis() function to compare time difference
    public int delayPop(int millis) {

        long start = System.currentTimeMillis();
        // run while loop until the time constraint is met
        while (millis != System.currentTimeMillis() - start) {
        }
        System.out.println(Arrays.toString(stack.toArray()));
        // remove and return value
        int val = stack.get(0);
        System.out.println(val);
        stack.remove(0);
        return val;
    }

}
