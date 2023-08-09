JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
        Calculator.java \
        CalculatorClient.java \
        CalculatorImplementation.java \
        CalculatorServer.java \
		UnitTesting.java

default: classes

classes: $(CLASSES:.java=.class)

setup: 			CalculatorServer.java
	@echo " "
	@echo "KILLING PROCESS FOR RMI:"
	@echo "To close rmi use 'ps' to get process id and use 'kill -9 PID' to remove process"
	@echo " "
	rmiregistry &
	sleep 2
	java CalculatorServer

server: 		CalculatorServer.java
	java CalculatorServer

test: 			CalculatorClient.java UnitTesting.java
	java -ea UnitTesting
	sleep 2
	java -ea CalculatorClient

integration: 	CalculatorClient.java
	java -ea CalculatorClient

unit:			UnitTesting.java
	java -ea UnitTesting

clean: 
	$(RM) *.class

instructions:
	@echo " "
	@echo "Fida Matin - a1798239 - University of Adelaide"
	@echo "06/08/2023"
	@echo " "
	@echo "Makefile for Java RMI Implementation for a Calculator Tool"
	@echo " "
	@echo "Make Commands: "
	@echo "'setup' - starts the registry & server, only needs to be done once on seperate terminal"
	@echo " to close rmi use 'ps' to get process id and use 'kill -9 PID' to remove process"
	@echo "'server' - starts only the server, to be used if rmi already running"
	@echo "'test' - run all integration and unit tests"
	@echo "'integration' - executes client for integration testing "
	@echo "if running single terminal enter 1 as stdin, otherwise enter "
	@echo "'unit' - executes unit testing for CalculatorImplementation"
	@echo "'clean' - Removes all class files"
	@echo " "


