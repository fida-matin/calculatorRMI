
// Fida Matin - a1798239
// University of Adelaide
// 06 Aug 2023
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;

// Server File
// create an extension of Calculator Implementation
public class CalculatorServer extends CalculatorImplementation {
    public CalculatorServer() throws RemoteException {
    }

    // main runs the server, binding the stub to "Calculator"
    public static void main(String args[]) {
        try {
            // create server instance
            CalculatorServer server = new CalculatorServer();
            // Assign a port for the stub
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(server, 0);

            // Construct a RMI Registry
            Registry RMI_Registry = LocateRegistry.getRegistry();
            // Attempt to bind, if already bound, then rebind
            try {
                RMI_Registry.bind("Calculator", stub);
            } catch (Exception error) {
                RMI_Registry.rebind("Calculator", stub);
            }
            // Print statement if server has constructed successfully
            System.out.println("Server Ready");
        } catch (Exception error) {
            System.out.println(error);
        }
    }
}
