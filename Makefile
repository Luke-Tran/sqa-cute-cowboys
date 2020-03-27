all: java

java:
	javac backend/*.java
	javac -d tests/output/ -cp .:./lib/junit-4.12.jar tests/Tests.java

runtests:
	java -cp .:/:tests/output/:./lib/hamcrest-core-1.3.jar:./lib/junit-4.12.jar org.junit.runner.JUnitCore tests.Tests