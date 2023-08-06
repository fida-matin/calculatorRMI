nothing:
	@echo " "
	@echo "Fida Matin - a1798239 - University of Adelaide"
	@echo "06/08/2023"
	@echo " "
	@echo "Makefile for Java RMI Implementation for a Calculator Tool"
	@echo " "
	@echo "Make Commands: "
	@echo "'compile' - compiles all the necessary code"
	@echo "'rmi' - starts the registry, only needs to be done once on each machine "
	@echo " to close rmi use 'ps' to get process id and use 'kill -9 PID' to remove process"
	@echo "'server' - executes server "
	@echo "'client' - executes client "
	@echo " "

compile: Calculator.java CalculatorClient.java CalculatorImplementation.java CalculatorServer.java
	javac *.java

rmi:
	rmiregistry &

server: CalculatorServer.java
	java CalculatorServer.java

client: CalculatorClient.java
	java CalculatorClient.java



