all: output

output:
	make compilefront
	make compileback

compilefront: fileIO.o item.o main.o mainWindow.o user.o
	g++ fileIO.o item.o main.o mainWindow.o user.o -o auction

compileback:
	javac backend/*.java
	javac -d tests/output/ -cp .:./lib/junit-4.12.jar tests/Tests.java
	javac Run.java
	javac -d tests/output/ -cp .:./lib/junit-4.12.jar MainTest.java

runtests:
	java -cp .:/:tests/output/:./lib/hamcrest-core-1.3.jar:./lib/junit-4.12.jar org.junit.runner.JUnitCore tests.Tests
	java -cp .:/:tests/output/:./lib/hamcrest-core-1.3.jar:./lib/junit-4.12.jar org.junit.runner.JUnitCore MainTest

fileIO.o: fileIO.cpp
	g++ -c fileIO.cpp

item.o: item.cpp
	g++ -c item.cpp

main.o: main.cpp
	g++ -c main.cpp

mainWindow.o: mainWindow.cpp
	g++ -c mainWindow.cpp

user.o: user.cpp
	g++ -c user.cpp

clean:
	rm *.o