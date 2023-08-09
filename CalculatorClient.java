
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
            /**
             * INTEGRATION TESTING
             */
            System.out.println("Creating 4 Clients");
            Calculator client1 = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));
            Calculator client2 = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));
            Calculator client3 = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));
            Calculator client4 = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));
            System.out.println("Creating 4 Clients");
            client1.pushValue(1);
            client2.pushValue(2);
            client3.pushValue(3);
            client4.pushValue(4);

            assert client1.pop() == 4;
            assert client2.pop() == 3;
            assert client3.pop() == 2;
            assert client4.pop() == 1;

            // System.out.println("Starting to add elements");
            // calc.pushValue(6);
            // calc.pushValue(4);
            // calc.pushValue(18);
            // calc.pushValue(21);

            // System.out.println(calc.pop());
            // System.out.println(calc.pop());
            // System.out.println(calc.pop());
            // System.out.println(calc.pop());

            // calc.pushValue(6);
            // calc.pushValue(4);
            // calc.pushValue(18);
            // calc.pushValue(21);

            // System.out.println("Removing: ");
            // System.out.println(calc.delayPop(5000));

            // System.out.println("Pushing operations:");
            // System.out.println("GCD check");
            // calc.pushOperation("gcd");

            // // Expected GCD is 2;
            // if (calc.pop() == 2) {
            // System.out.println("Output is correct");
            // }

        } catch (Exception error) {
            System.out.println(error);
        }
    }

}
