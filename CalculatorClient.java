
// Fida Matin - a1798239
// University of Adelaide
// 06 Aug 2023
// imports a library which imports the Remote Method Invocation 
import java.rmi.*;

// Client File
public class CalculatorClient {
    public CalculatorClient() {
    }

    // main function to run calls from
    public static void main(String[] args) {
        String host_Address = (args.length < 1) ? "127.0.0.1" : args[0];

        try {
            Calculator calc = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));

            System.out.println("Starting to add elements");
            calc.pushValue(6);
            calc.pushValue(4);
            calc.pushValue(18);
            calc.pushValue(21);

            System.out.println(calc.pop());
            System.out.println(calc.pop());
            System.out.println(calc.pop());
            System.out.println(calc.pop());

            calc.pushValue(6);
            calc.pushValue(4);
            calc.pushValue(18);
            calc.pushValue(21);

            System.out.println("Removing: ");
            System.out.println(calc.delayPop(5000));

            System.out.println("Pushing operations:");
            System.out.println("GCD check");
            calc.pushOperation("gcd");

            // Expected GCD is 2;
            if (calc.pop() == 2) {
                System.out.println("Output is correct");
            }

        } catch (Exception error) {
            System.out.println(error);
        }
    }

}
