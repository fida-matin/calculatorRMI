
// imports a library which imports the Remote Method Invocation 
import java.rmi.*;

public class CalculatorClient {

    public CalculatorClient() {
    }

    public static void main(String[] args) {
        String host_Address = (args.length < 1) ? "127.0.0.1" : args[0];

        try {
            Calculator calc = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));

            int res = calc.pop();

            if (res == 4) {
                System.out.println("Success! The Answer is 4");
            }
        } catch (Exception error) {
            System.out.println(error);
        }
    }

}
