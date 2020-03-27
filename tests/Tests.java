package tests;

import backend.Backend;
import backend.Item;
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
 * 	$ javac -d tests/output/ -cp .:./lib/junit-4.12.jar tests/UserTests.java
 * To run the tests:
 * 	$ java -cp .:/:tests/output/:./lib/hamcrest-core-1.3.jar:./lib/junit-4.12.jar org.junit.runner.JUnitCore tests.UserTests
 */

public class Tests {

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
		assertTrue(backend.getUsers().size() == 1);
	}

	// Tests that addNewUser() does not add a user if they already exist.
	@Test
	public void doNotAddDuplicateUser() {
		Backend backend = new Backend();
		backend.setUsers(new Vector<String>());
		backend.addNewUser("01 a               FS 000000.00");
		backend.addNewUser("01 a               FS 000000.00");
		assertTrue(backend.getUsers().size() == 1);
	}

	// Tests statement coverage for updateUser().
	@Test
	public void testUpdateUser() {
		Backend backend = new Backend();
		backend.setUsers(new Vector<String>());
		backend.addNewUser("01 a               FS 000000.00");
		backend.updateUser("06 a               FS 000000.00");
		assertTrue(backend.getUsers().get(0).equals("a               FS 000000.00"));
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
	
	// Tests statement coverage for addItem().
	@Test
	public void testAddItem() {
		Backend backend = new Backend();
		backend.setItems(new Vector<String>());
		backend.addNewItem("03 a                         a               001 000.00");
		assertTrue(backend.getItems().size() == 1);
	}

	// Tests statement coverage for updateItem().
	@Test
	public void testUpdateItem() {
		Backend backend = new Backend();
		backend.setItems(new Vector<String>());
		backend.addNewItem("03 a                         a               001 000.00");
		backend.updateItem("04 a                         a               a               000.00");
		assertTrue(backend.getItems().size() == 1);
	}

	// Tests statement coverage for deleteItem().
	@Test
	public void testDeleteItem() {
		Backend backend = new Backend();
		backend.setItems(new Vector<String>());
		backend.addNewItem("03 a                         a               001 000.00");
		backend.deleteItem("a              ");
		assertTrue(backend.getItems().size() == 0);
	}

	// Tests statement coverage for endBid() if the item does not have a bidder.
	@Test
	public void testEndBidWithoutBidder() {
		Item item = new Item("03 a                         a               001 000.00");
		Backend backend = new Backend();
		backend.setUsers(new Vector<String>());
		backend.endBid(item);
		assertTrue(backend.getUsers().size() == 0);
	}

	// Tests statement coverage for endBid() if the item has a bidder.
	@Test
	public void testEndBidWithBidder() {
		Item item = new Item("03 a                         a               001 000.01");
		item.setBidder("a              ");

		Backend backend = new Backend();
		backend.setUsers(new Vector<String>());
		backend.addNewUser("01 a               FS 999999.99");

		backend.endBid(item);
		System.out.println(backend.getUsers().get(0).substring(18, 27));
		assertTrue(backend.getUsers().get(0).substring(18, 27).equals("999999.99"));
	}
}

