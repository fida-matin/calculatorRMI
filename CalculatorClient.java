
// imports a library which imports the Remote Method Invocation 
import java.rmi.*;

public class CalculatorClient {

    public CalculatorClient() {
    }

    public static void main(String[] args) {
        String host_Address = (args.length < 1) ? "127.0.0.1" : args[0];

        try {
            Calculator calc = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));

            System.out.println("Starting to add elements");
            calc.pushValue(6);
            calc.pushValue(4);
            calc.pushValue(18);
            calc.pushValue(21);

            System.out.println(calc.delayPop(5000));

            System.out.println("Pushing operations");
            calc.pushOperation("gcd");
        } catch (Exception error) {
            System.out.println(error);
        }
    }

}
