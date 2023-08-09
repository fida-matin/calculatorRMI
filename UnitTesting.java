
// Fida Matin - a1798239
// University of Adelaide
// 09 Aug 2023
import java.lang.Math;

// Unit Test file
public class UnitTesting {
    public static void main(String args[]) {
        CalculatorImplementation test = new CalculatorImplementation();

        /**
         * TEST 1 - pushValue() & pop() test
         */
        System.out.println("\nTest 1 - Adding + Removing Values to Stack:");
        System.out.println("Adding Values 2,3,4,5,6");
        test.pushValue(2);
        test.pushValue(3);
        test.pushValue(4);
        test.pushValue(5);
        test.pushValue(6);

        assert test.pop() == 6;
        System.out.println("Found 6");
        assert test.pop() == 5;
        System.out.println("Found 5");
        assert test.pop() == 4;
        System.out.println("Found 4");
        assert test.pop() == 3;
        System.out.println("Found 3");
        assert test.pop() == 2;
        System.out.println("Found 2\n");
        System.out.println("Test 1 - Pass\n");

        /**
         * TEST 2 isEmpty() test
         */
        System.out.println("Test 2 - Checking if Empty");
        System.out.println("Adding Value to Stack");
        test.pushValue(1);
        assert test.isEmpty() == false;
        System.out.println("Returns false for isEmpty");
        test.pop();
        System.out.println("Remove all values from Stack");
        assert test.isEmpty() == true;
        System.out.println("Returns true for isEmpty\n");
        System.out.println("Test 2 - Pass\n");

        /**
         * TEST 3 pushOperation() test
         */
        System.out.println("Test 3 - Testing pushing operations");

        // TEST 3.1 min input test
        System.out.println("Test 3.1 - Testing min");
        System.out.println("Adding 15,61,34");

        test.pushValue(15);
        test.pushValue(61);
        test.pushValue(34);
        test.pushOperation("min");

        assert test.pop() == 15;
        assert test.isEmpty() == true;
        System.out.println("Returned 15 and Stack was cleared");
        System.out.println("Test 3.1 - Pass");

        // TEST 3.2 max input test
        System.out.println("\nTest 3.2 - Testing max");
        System.out.println("Adding 15,61,34");

        test.pushValue(15);
        test.pushValue(61);
        test.pushValue(34);
        test.pushOperation("max");

        assert test.pop() == 61;
        assert test.isEmpty() == true;
        System.out.println("Returned 61 and Stack was cleared");
        System.out.println("Test 3.2 - Pass");

        // TEST 3.3 lcm input test
        System.out.println("\nTest 3.3 - Testing Lowest Common Multiple");
        System.out.println("Adding 15,61,34");

        test.pushValue(15);
        test.pushValue(61);
        test.pushValue(34);
        test.pushOperation("lcm");

        assert test.pop() == 31110;
        assert test.isEmpty() == true;
        System.out.println("Returned 31110 and Stack was cleared");
        System.out.println("Test 3.3 - Pass");

        // TEST 3.4
        System.out.println("\nTest 3.4 - Testing Greatest Common Divisor");
        System.out.println("Adding 24,12,210");

        test.pushValue(24);
        test.pushValue(12);
        test.pushValue(210);
        test.pushOperation("gcd");

        assert test.pop() == 6;
        assert test.isEmpty() == true;
        System.out.println("Returned 6 and Stack was cleared");
        System.out.println("Test 3.4 - Pass");

        System.out.println("\nTest 3 - Pass\n");

        /**
         * TEST 4 delayPop() test
         */
        System.out.println("Test 4 - Testing delayed pop");
        test.pushValue(1);
        int delay = 1000; // 1 second delay
        double error = delay * 0.05; // 5% error
        double start = System.currentTimeMillis();
        System.out.println("Running Delay for 1000 milliseconds (1 second)");
        test.delayPop(1000);
        double diff = System.currentTimeMillis() - start;
        assert (Math.abs(diff - delay)) <= error;
        System.out.println("Delay is within acceptable error\n");
        System.out.println("Test 4 - Pass\n");

        System.out.println("\nAll Unit Tests Passed!\n");

    }

}
