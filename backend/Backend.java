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
        /*System.out.println("\nOld");
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }*/

        String usertoAdd = userDetails.substring(3, 18);
        String userType = userDetails.substring(19, 21);
        String credits = userDetails.substring(22, 31);
        String newUser = usertoAdd + " " + userType + " " + credits;
        for(int i = 0; i < users.size(); i++) {
            String username = users.get(i).substring(0, 15);
            if (username.equals(usertoAdd)) {
                System.out.println("User " + usertoAdd + " already exists");
                return;
            }
        }
        users.add(newUser);

        /*System.out.println("New");
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }*/
    }

    /**
     * Update a user. This method modifies a string in the users vector
     * to represent changing the amount of credit the user has.
     * @param userDetails The transaction code that indicates adding credit to a user, or refunding a user.
     * @return Nothing.
     */
    public void updateUser(String userDetails) {
        /*System.out.println("\nOld");
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }*/

        String userToUpdate = userDetails.substring(3, 18);
        String userType = userDetails.substring(19, 21);
        String credits = userDetails.substring(22, 31); // Assuming the front end has already calculated the user's new credit.
        //double creditValue = Double.parseDouble(credits);
        for(int i = 0; i < users.size(); i++) {
            String username = users.get(i).substring(0, 15);
            if (username.equals(userToUpdate)) {
                String updatedUser = username + " " + userType + " " + credits;
                users.set(i, updatedUser);
                break;
            }
        }

        /*System.out.println("New");
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }*/
    }

    /**
     * Delete a user. This method removes an entry in the users vector
     * to represent that user being deleted. The user that is deleted matches the given userName.
     * @param userName The username of the user to delete.
     * @return Nothing.
     */
    public void deleteUser(String transaction) {
        /*System.out.println("\nOld");
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }*/

        String userToDelete = transaction.substring(3, 18);
        for(int i = 0; i < users.size(); i++) {
            String username = users.get(i).substring(0, 15);
            if (username.equals(userToDelete)) {
                System.out.println("Deleted user: " + username);
                users.remove(i);
                break;
            }
        }

        /*System.out.println("New");
        for(int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }*/
    }

    /**
     * Adds a new item. This method will add a string to the items vector
     * to represent adding a new item.
     * @param itemDetails The transaction code that indicates advertising an item.
     * @return Nothing.
     */
    public void addNewItem(String itemDetails) {
        Item item = new Item(itemDetails);
        Vector<String> items = this.getItems(); // Get a vector of all the current items

        items.add(item.itemString());  // Add new item to the list
        for(int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }

        this.setItems(items);   // Set the instantiated object to this newly added vector
    }

    /**
     * Updates an item. This method modifies a string in the items vector
     * to represent changing the item's current highest bidder, current highest bid, 
     * and the number of days it has left.
     * @param itemDetails The transaction code that indicates bidding on an item.
     * @return Nothing.
     */
    public void updateItem(String itemDetails) {
        Item item = new Item(itemDetails);

        Vector<String> items = this.getItems();

        for(int i = 0; i < items.size(); i++) {
            // If the names are the same
            if(item.getName().equals(Item.extractName(items.get(i)))) {
                // If the sellers are also the same
                // Checking for name incase two people sell an item with same name
                if(item.getSeller().equals(Item.extractSeller(items.get(i))))
                {
                    Item newItem = new Item(items.get(i));
                    // If the value of the passed items price is higher than that of the item in the file
                    // Check for this incase two people bid the same price in the same session
                    // First person will have the bid saved
                    if(Float.valueOf(item.getPrice()).floatValue() > Float.valueOf(newItem.getPrice()).floatValue()) {
                        newItem.setPrice(item.getPrice());
                        newItem.setBidder(item.getBidder());
                        items.set(i, newItem.itemString());
                    } 
                }
            }
        }
    }

    /**
     * Deletes an item. This method removes an entry in the items vector
     * to represent that item being deleted. The item that is deleted matches the given itemName.
     * @param username The username of the user to delete their items.
     * @return Nothing.
     */
    public void deleteItem(String username) {
        Vector<String> items = this.getItems();

        for(int i = 0; i < items.size(); i++) {
            // If the names are the same
            if(username.equals(Item.extractSeller(items.get(i)))) {
                items.remove(i);
            }
        }
    }
}