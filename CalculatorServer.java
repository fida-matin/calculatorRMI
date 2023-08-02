import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;

public class CalculatorServer extends CalculatorImplementation {
    public CalculatorServer() throws RemoteException {
    }

    public static void main(String args[]) {
        try {

            CalculatorServer server = new CalculatorServer();
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(server, 0);

            Registry RMI_Registry = LocateRegistry.getRegistry();
            try {
                RMI_Registry.bind("Calculator", stub);
            } catch (Exception error) {
                RMI_Registry.rebind("Calculator", stub);
            }

            System.out.println("Server Ready");
        } catch (Exception error) {
            System.out.println(error);
        }
    }
}
