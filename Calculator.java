
// Fida Matin - a1798239
// University of Adelaide
// 06 Aug 2023
import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface File
public interface Calculator extends Remote {
    // This method will take val and push it on to the top of the stack.
    void pushValue(int val) throws RemoteException;

    // This method will push a String containing an operator ("min", "max", "lcm",
    // "gcd") to the stack
    // for min - push the min value of all the popped values
    // for max - push the max value of all the popped values
    // for lcm - push the least common multiple of all the popped values
    // for gcd - push the greatest common divisor of all the popped values
    void pushOperation(String operator) throws RemoteException;

    // This method will pop the top of the stack and return it to the client
    int pop() throws RemoteException;

    // This method will return true if the stack is empty, false otherwise
    boolean isEmpty() throws RemoteException;

    // This method will wait millis milliseconds before carrying out the pop
    // operation as above
    int delayPop(int millis) throws RemoteException;
}
