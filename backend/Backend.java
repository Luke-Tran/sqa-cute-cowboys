package backend;
/**
 * Backend class.
 * Reads a daily transaction file and parses data to modify information 
 * about current users and available items. 
 * Then writes that information to the current users file and available items file.
 * 
 * @author Luke Tran, Sean Caldwell, Calvin Lapp
 * @since March 16th, 2020
 * @version 1.0.2
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
     * Add a new user. This method will add a string to the users vector
     * to represent adding a new user.
     * @param userDetails The transaction code that indicates creating a user.
     * @return Nothing.
     */
    public void addNewUser(String userDetails) {
        String username = userDetails.substring(3, 18);
        String userType = userDetails.substring(19, 21);
        String credits = userDetails.substring(22, 31);
        String newUser = username + " " + userType + " " + credits;
        users.add(newUser);
    }

    /**
     * Update a user. This method modifies a string in the users vector
     * to represent changing the amount of credit the user has.
     * @param userDetails The transaction code that indicates adding credit to a user, or refunding a user.
     * @return Nothing.
     */
    public void updateUser(String userDetails) {
        String userToUpdate = userDetails.substring(3, 18);
        String userType = userDetails.substring(19, 21);
        String credits = userDetails.substring(22, 31); // Assuming the front end has already calculated the user's new credit.
        //double creditValue = Double.parseDouble(credits);
        for(int i = 0; i < users.size(); i++) {
            String username = users.get(i).substring(0, 16);
            if (username.equals(userToUpdate)) {
                String updatedUser = username + " " + userType + " " + credits;
                users.set(i, updatedUser);
                break;
            }
        }

    }

    /**
     * Delete a user. This method removes an entry in the users vector
     * to represent that user being deleted. The user that is deleted matches the given userName.
     * @param userName The username of the user to delete.
     * @return Nothing.
     */
    public void deleteUser(String transaction) {
        String userToDelete = transaction.substring(3, 18);
        for(int i = 0; i < users.size(); i++) {
            String username = users.get(i).substring(0, 16);
            if (username.equals(userToDelete)) {
                users.remove(i);
                break;
            }
        }
    }

    /**
     * Adds a new item. This method will add a string to the items vector
     * to represent adding a new item.
     * @param itemDetails The transaction code that indicates advertising an item.
     * @return Nothing.
     */
    public void addNewItem(String itemDetails) {

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