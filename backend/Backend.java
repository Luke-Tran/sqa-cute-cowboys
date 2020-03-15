package backend;
/**
 * Backend class.
 * Reads a daily transaction file and parses data to modify information 
 * about current users and available items. 
 * Then writes that information to the current users file and available items file.
 * 
 * @author Luke Tran, Sean Caldwell, Calvin Lapp
 * @since March 2nd, 2020
 * @version 1.0
 * @name Backend.java
 */

import java.util.Vector;

public class Backend {

    /* Attributes */
    private Vector<String> users;
    private Vector<String> transactions;
    private Vector<String> items;

    /* Methods */

    /* Setters */

    /**
     * Sets user vector
     * @param users
     */
    public void setUsers(Vector<String> users) {
        this.users = users;
    }

    /**
     * Sets transactions vector
     * @param transactions
     */
    public void setTransactions(Vector<String> transactions) {
        this.transactions = transactions;
    }

    /**
     * Sets items vector
     * @param items
     */
    public void setItems(Vector<String> items) {
        this.items = items;
    }
    
    /* Getters */

    /**
     * Gets the users vector
     * @return a vector with all current user information
     */
    public Vector<String> getUsers() {
        return users;
    }

    /**
     * Gets the transactions vector
     * @return a vector with all current transaction information
     */
    public Vector<String> getTransactions() {
        return transactions;
    }

    /**
     * Gets the items vector 
     * @return a vector with all current item information
     */
    public Vector<String> getItems() {
        return items;
    }

    /**
     * updateTransactions Function. This will loop through the transactions vector
     * and call the appropriate method based on what kind of transaction it is.
     * 01 calls addNewUser. 
     * 02 calls deleteUser and deleteItem.
     * 06 calls updateUser.
     * 05 calls updateUser twice. Once for the buyer and once for the seller.
     * 03 calls addNewItem.
     * 04 calls updateItem.
     * @param args Unused.
     * @return Nothing.
     */
    public static void updateTransactions(String[] args) {
        // setUsers(fileReader.getFileInfo("current_user_accounts_file.txt"));
        // System.out.println(users);
    }

    /**
     * Add a new user. This method will add a string to the users vector
     * to represent adding a new user.
     * @param userDetails The transaction code that indicates creating a user.
     * @return Nothing.
     */
    public static void addNewUser(String userDetails) {

    }

    /**
     * Update a user. This method modifies a string in the users vector
     * to represent changing the amount of credit the user has.
     * @param userDetails The transaction code that indicates adding credit to a user, or refunding a user.
     * @return Nothing.
     */
    public static void updateUser(String userDetails) {

    }

    /**
     * Delete a user. This method removes an entry in the users vector
     * to represent that user being deleted. The user that is deleted matches the given userName.
     * @param userName The username of the user to delete.
     * @return Nothing.
     */
    public static void deleteUser(String userName) {

    }

    /**
     * Adds a new item. This method will add a string to the items vector
     * to represent adding a new item.
     * @param itemDetails The transaction code that indicates advertising an item.
     * @return Nothing.
     */
    public static void addNewItem(String itemDetails) {

    }

    /**
     * Updates an item. This method modifies a string in the items vector
     * to represent changing the item's current highest bidder, current highest bid, 
     * and the number of days it has left.
     * @param itemDetails The transaction code that indicates bidding on an item.
     * @return Nothing.
     */
    public static void updateItem(String itemDetails) {

    }

    /**
     * Deletes an item. This method removes an entry in the items vector
     * to represent that item being deleted. The item that is deleted matches the given itemName.
     * @param itemName The name of the item to delete.
     * @return Nothing.
     */
    public static void deleteItem(String itemName) {

    }


}