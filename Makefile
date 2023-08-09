JFLAGS = -g
JC = javac
.SUFFIXES: .java .class

.java.class:
		$(JC) $(JFLAGS) $*.java

# This uses the line continuation character (\) for readability
# You can list these all on a single line, separated by a space instead.
# If your version of make can't handle the leading tabs on each
# line, just remove them (these are also just added for readability).
CLASSES = \
        Calculator.java \
        CalculatorClient.java \
        CalculatorImplementation.java \
        CalculatorServer.java \
		UnitTesting.java

default: classes

classes: $(CLASSES:.java=.class)

rmi:
	rmiregistry &

server:	CalculatorServer.java
	java CalculatorServer

client:	CalculatorClient.java
	java CalculatorClient

unit:	UnitTesting.java
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
	@echo "'rmi' - starts the registry, only needs to be done once on each machine "
	@echo " to close rmi use 'ps' to get process id and use 'kill -9 PID' to remove process"
	@echo "'server' - executes server "
	@echo "'client' - executes client "
	@echo " "


