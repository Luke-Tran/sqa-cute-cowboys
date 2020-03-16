/**
 * Run class.
 * Instantiates a Backend object to be manipulated.
 * Parses through the various files and extracts data from them
 * to be saved into the Backend's object.
 * Backend object manipulates the data as it needs
 * then write back out to the files with new data.
 * 
 * @author Luke Tran, Sean Caldwell, Calvin Lapp
 * @since March 16th, 2020
 * @version 1.0.1
 * @name Run.java
 */
import backend.Backend;
import backend.Constants;
import io.FileParser;
import java.util.*;
import static backend.Constants.*;

class Run {

    /**
     * Main Function. This will loop through the transactions vector
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
    public static void main(String[] args) {
        Backend backend = new Backend();
        FileParser parser = new FileParser();
        String transCode = "";
        Vector<String> users = new Vector<String>();
        Vector<String> transactions = new Vector<String>();
        Vector<String> items = new Vector<String>();

        // Set the vectors in the backend object
        backend.setUsers(parser.getFileInfo(Constants.CURRENT_USER_ACCOUNTS_FILE));
        backend.setTransactions(parser.getFileInfo(Constants.DAILY_TRANSACTION_FILE));
        backend.setItems(parser.getFileInfo(Constants.AVAILABLE_ITEMS_FILE));

        users = backend.getUsers();
        transactions = backend.getTransactions();
        items = backend.getItems();

        for(int i = 0; i < transactions.size(); i++) {
            transCode = transactions.get(i).substring(0, 2);    // get the trans code
            switch(transCode) {
                case Constants.ADD_NEW_USER:
                    backend.addNewUser(transactions.get(i));
                    break;
                case Constants.DELETE: 
                    break;
                case Constants.ADD_NEW_ITEM: 
                    break;
                case Constants.BID: 
                    break;
                case Constants.REFUND: 
                    break;
                case Constants.ADD_CREDIT: 
                    break;
                case Constants.END_OF_SESSION: 
                    break;
                default:
                    break;
            }
        }
    }
}