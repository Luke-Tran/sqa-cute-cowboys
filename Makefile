all: java

java:
	javac backend/*.java
	javac -d tests/output/ -cp .:./tests/junit-4.12.jar tests/UserTests.java

runtests:
	java -cp .:/:tests/output/:./tests/hamcrest-core-1.3.jar:./tests/junit-4.12.jar org.junit.runner.JUnitCore tests.UserTests