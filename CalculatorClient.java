
// Fida Matin - a1798239
// University of Adelaide
// 06 Aug 2023
// imports a library which imports the Remote Method Invocation 
import java.rmi.*;
import java.util.Scanner;

// Client File
public class CalculatorClient {
    public CalculatorClient() {
    }

    // main function to run calls from
    public static void main(String[] args) {
        String host_Address = (args.length < 1) ? "127.0.0.1" : args[0];

        try {
            String integration = "";
            try (Scanner readin = new Scanner(System.in)) {
                System.out.println(
                        "\nRun Test in one instance or multiple?\n (Type '1' for one and anything else for multiple):");

                integration = readin.nextLine();
            }

            if (integration == "1") {
                /**
                 * INTEGRATION ONE CLIENT TESTING
                 */
                System.out.println("\nINTEGRATION TESTING\n");
                // pushValue() and pop() Tests
                System.out.println("\nTesting with one client:\n");
                System.out.println("Making a client...");
                Calculator client = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));
                System.out.println("Success");

                while (!client.isEmpty()) {
                    client.pop();
                }

                System.out.println("Test 1 - Adding and Removing values with the client");
                System.out.println("Using pushValue() and pop()");
                System.out.println("Adding elements...");
                client.pushValue(6);
                client.pushValue(4);
                client.pushValue(18);
                client.pushValue(21);

                System.out.println("Popping elements...");
                assert client.pop() == 21;
                assert client.pop() == 18;
                assert client.pop() == 4;
                assert client.pop() == 6;
                System.out.println("\nTest 1 - PASS\n");

                // pushOperation() Tests
                System.out.println("Test 2 - pushOperation() test");

                // min test
                System.out.println("Testing for min...");

                while (!client.isEmpty()) {
                    client.pop();
                }

                client.pushValue(6);
                client.pushValue(4);
                client.pushValue(18);

                client.pushOperation("min");
                assert client.pop() == 4;
                System.out.println("PASS");

                // max test
                System.out.println("Testing for max...");

                while (!client.isEmpty()) {
                    client.pop();
                }

                client.pushValue(6);
                client.pushValue(4);
                client.pushValue(18);

                client.pushOperation("max");
                assert client.pop() == 18;
                System.out.println("PASS");

                // lcm test
                System.out.println("Testing for Least Common Multiple...");

                while (!client.isEmpty()) {
                    client.pop();
                }

                client.pushValue(6);
                client.pushValue(4);
                client.pushValue(18);

                client.pushOperation("lcm");
                assert client.pop() == 36;
                System.out.println("PASS");

                // gcd test
                System.out.println("Testing for Greatest Common Divisor...");

                while (!client.isEmpty()) {
                    client.pop();
                }

                client.pushValue(6);
                client.pushValue(4);
                client.pushValue(18);

                client.pushOperation("gcd");
                assert client.pop() == 2;
                System.out.println("PASS\n");
                System.out.println("Test 2 - PASS\n");

                while (!client.isEmpty()) {
                    client.pop();
                }

                // delayPop() Tests
                System.out.println("Test 3 - pushDelay() test");
                client.pushValue(1);
                int delay = 1000; // 1 second delay
                double error = delay * 0.05; // 5% error
                double start = System.currentTimeMillis();
                System.out.println("Running Delay for 1000 milliseconds (1 second)...");
                System.out.println(client.delayPop(delay));
                double diff = System.currentTimeMillis() - start;
                assert (Math.abs(diff - delay)) <= error;
                System.out.println("\nTest 3 - PASS\n");

                while (!client.isEmpty()) {
                    client.pop();
                }

                /**
                 * INTEGRATION MULTIPLE CLIENTS TESTING
                 */
                System.out.println("\nTesting with multiple clients\n");
                System.out.println("Attempting to make 4 clients");
                Calculator client1 = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));
                Calculator client2 = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));
                Calculator client3 = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));
                Calculator client4 = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));
                System.out.println("Success!\n");

                System.out.println("Test 4 - All Clients can access the same stack");
                System.out.println("Testing using pushValue() and pop()");
                client1.pushValue(1);
                client2.pushValue(2);
                client3.pushValue(3);
                client4.pushValue(4);

                assert client1.pop() == 4;
                System.out.println("Client 1 on same stack as Client 4");
                assert client2.pop() == 3;
                System.out.println("Client 2 on same stack as Client 3");
                assert client4.pop() == 2;
                System.out.println("Client 4 on same stack as Client 2");

                System.out.println("All Clients using same stack");
                System.out.println("\nTest 4 - PASS\n");

                while (!client.isEmpty()) {
                    client.pop();
                }

                System.out.println("Test 5 - pushOperation() test");
                System.out.println("testing min...");
                client1.pushValue(6);
                client2.pushValue(4);
                client3.pushValue(18);
                client4.pushValue(36);
                client.pushOperation("min");
                assert client.pop() == 4;
                System.out.println("PASS");

                System.out.println("testing max...");
                client1.pushValue(6);
                client2.pushValue(4);
                client3.pushValue(18);
                client4.pushValue(36);
                client.pushOperation("max");
                assert client.pop() == 36;
                System.out.println("PASS");

                System.out.println("testing lcm...");
                client1.pushValue(6);
                client2.pushValue(4);
                client3.pushValue(18);
                client4.pushValue(36);
                client.pushOperation("lcm");
                assert client.pop() == 36;
                System.out.println("PASS");

                System.out.println("testing gcd...");
                client1.pushValue(6);
                client2.pushValue(4);
                client3.pushValue(18);
                client4.pushValue(36);
                client.pushOperation("gcd");
                assert client.pop() == 2;
                System.out.println("PASS");
                System.out.println("\nTest 5 - PASS\n");

                while (!client.isEmpty()) {
                    client.pop();
                }

                System.out.println("Test 6 - delayPop() test");
                client1.pushValue(6);
                client2.pushValue(4);
                client3.pushValue(18);
                client4.pushValue(36);

                System.out.println("Client 1...");
                start = System.currentTimeMillis();
                client1.delayPop(delay);
                diff = System.currentTimeMillis() - start;
                assert (Math.abs(diff - delay)) <= error;
                System.out.println("PASS");

                System.out.println("Client 2...");
                start = System.currentTimeMillis();
                client1.delayPop(delay);
                diff = System.currentTimeMillis() - start;
                assert (Math.abs(diff - delay)) <= error;
                System.out.println("PASS");

                System.out.println("Client 3...");
                start = System.currentTimeMillis();
                client1.delayPop(delay);
                diff = System.currentTimeMillis() - start;
                assert (Math.abs(diff - delay)) <= error;
                System.out.println("PASS");

                System.out.println("Client 4...");
                start = System.currentTimeMillis();
                client1.delayPop(delay);
                diff = System.currentTimeMillis() - start;
                assert (Math.abs(diff - delay)) <= error;
                System.out.println("PASS");
                System.out.println("\nTest 6 - PASS\n");

                System.out.println("All Integration Tests Passed!\n");

                while (!client.isEmpty()) {
                    client.pop();
                }
            } else {
                Calculator client1 = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));
                Calculator client2 = (Calculator) Naming.lookup(String.format("//%s/Calculator", host_Address));

                System.out.println("Adding - 2");
                client1.pushValue(2);
                System.out.println("Adding - 3");
                client2.pushValue(3);

                System.out.println("Removing:");
                System.out.println(client1.delayPop(2000));

                System.out.println("Adding - 4");
                client1.pushValue(4);

                System.out.println("Removing:");
                System.out.println(client2.delayPop(2000));
                System.out.println("Removing:");
                System.out.println(client1.delayPop(2000));

                System.out.println("Adding - 5");
                client2.pushValue(5);

                System.out.println("Removing:");
                System.out.println(client2.delayPop(2000));
                System.out.println("Removing:");
                System.out.println(client1.delayPop(2000));

                System.out.println("Adding - 6");
                client1.pushValue(6);
                System.out.println("Adding - 7");
                client2.pushValue(7);
                System.out.println("Adding - 8");
                client1.pushValue(8);
                System.out.println("Adding - 9");
                client2.pushValue(9);
                System.out.println("Adding - 10");
                client1.pushValue(10);
                System.out.println("Adding - 11");
                client2.pushValue(11);

                System.out.println("Removing:");
                System.out.println(client2.delayPop(2000));
                System.out.println("Removing:");
                System.out.println(client2.delayPop(2000));
                System.out.println("Removing:");
                System.out.println(client2.delayPop(2000));
                System.out.println("Removing:");
                System.out.println(client2.delayPop(2000));
                System.out.println("Removing:");
                System.out.println(client2.delayPop(2000));

                if (client1.isEmpty() == true) {
                    System.out.println("Final Input was removed");
                    System.out.println("Test Passed");
                } else {
                    System.out.println("Finished running, still some values left in stack");
                }
            }

        } catch (Exception error) {
            System.out.println(error);
        }
    }

}
