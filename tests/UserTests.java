package tests;

import backend.Backend;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import java.util.Vector;

/*
 * Please compile from the root directory of this project.
 * These instructions were written for a Linux machine.
 * To compile the backend:
   $ javac backend/*.java
 * To compile this file:
   $ javac -d tests/output/ -cp .:<path to junit-4.12.jar> tests/UserTests.java
 * To run the test:
   $ java -cp .:/:tests/output/:<path to hamcrest-core-1.3.jar>:<path to junit-4.12.jar> org.junit.runner.JUnitCore tests.UserTests
 */

public class UserTests {

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
}

