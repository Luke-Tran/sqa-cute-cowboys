package backend;
/**
 * User class.
 * Gets and sets information related to a user.
 * Displays a string of all the users information
 * 
 * @author Luke Tran, Sean Caldwell, Calvin Lapp
 * @since March 26th, 2020
 * @version 1.0.0
 * @name User.java
 */

 public class User {
    
    public User(String userDetails) {
        if(userDetails.length() == Constants.CURRENT_USER_LENGTH) {
            this.username = userDetails.substring(0, 15);
            this.accountType = userDetails.substring(16, 18);
            this.balance = userDetails.substring(19, 28);
        }
    }

    /* Attributes */
    private String username;

    private String accountType;

    private String balance;

    /* Methods */

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return this.username;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getBalance() {
        return this.balance;
    }

    public String toString() {
        return this.username + " " + this.accountType + " " + this.balance;
    }
 }

