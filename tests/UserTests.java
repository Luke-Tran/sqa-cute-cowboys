package tests;

import backend.Backend;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import java.util.Vector;

/*
 * Please compile from the root directory of this project.
 * These instructions were written for a Linux machine.
 * If you are on Linux, you can copy and paste these commands into the terminal to run the tests.
 * Or, you could use `make` to compile, and `make runtests` to run the tests.
 * To compile the backend:
 * 	$ javac backend/*.java
 * To compile this file:
 * 	$ javac -d tests/output/ -cp .:./tests/junit-4.12.jar tests/UserTests.java
 * To run the tests:
 * 	$ java -cp .:/:tests/output/:./tests/hamcrest-core-1.3.jar:./tests/junit-4.12.jar org.junit.runner.JUnitCore tests.UserTests
 */

public class UserTests {

	// Tests setUsers() and getUsers() statement coverage.
	@Test
	public void testGetUsers() {
		Backend backend = new Backend();
		backend.setUsers(new Vector<String>());
		assertTrue(backend.getUsers().size() == 0);
	}

	// Tests that addNewUser() can add a user.
	@Test
	public void usersVectorNotEmptyAfterAdd() {
		Backend backend = new Backend();
		backend.setUsers(new Vector<String>());
		backend.addNewUser("01 a               FS 000000.00");
		assertTrue(backend.getUsers().size() > 0);
	}

	// Tests that addNewUser() does not add a user if they already exist.
	@Test
	public void doNotAddDuplicateUser() {
		Backend backend = new Backend();
		backend.setUsers(new Vector<String>());
		backend.addNewUser("01 a               FS 000000.00");
		backend.addNewUser("01 a               FS 000000.00");
		assertTrue(backend.getUsers().size() > 0);
	}

	// Tests statement coverage for updateUser().
	@Test
	public void testUpdateUser() {
		Backend backend = new Backend();
		backend.setUsers(new Vector<String>());
		backend.addNewUser("01 a               FS 000000.00");
		backend.updateUser("06 a               FS 000000.00");
		assertTrue(backend.getUsers().get(0).equals("a               FS 000000.00")); // May have to change this to utilize the User class
	}

	// Tests statement coverage for deleteUser().
	@Test
	public void testDeleteUser() {
		Backend backend = new Backend();
		backend.setUsers(new Vector<String>());
		backend.addNewUser("01 a               FS 000000.00");
		backend.deleteUser("02 a               FS 000000.00");
		assertTrue(backend.getUsers().size() == 0);
	}
}
