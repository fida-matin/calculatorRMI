# calculatorRMI
Using Java RMI to construct a remotely operated calculator

General Instructions:
- Type "make instructions" in the terminal to get the Makefile instructions for running different files

Compilation Instructions:
- Type "make" to compile all files, this will run javac on all .java files

Executing Files Instructions:
- Type "make setup" if there isn't an RMI already
- Can make RMI using "rmiregistry &" seperately
- Type "make server" for just the server
- Server needs to be set up on a terminal which is separate to the client terminal

Testing Instructions:
- Follow instruction from "make instructions"
- Run all tests using "make test"
- Run Unit testing using "make unit"
- Run integeration testing for one instance with multiple clients enter "1" when program asks for input
- When doing integration testing with multiple terminals enter any other value, run each terminal roughly 2 seconds after each other (After 3 is removed)
- Testing should print out all outputs onto the client terminal

