/**
 * Run class.
 * Instantiates a Backend object to be manipulated.
 * Parses through the various files and extracts data from them
 * to be saved into the Backend's object.
 * Backend object manipulates the data as it needs
 * then write back out to the files with new data.
 * 
 * @author Luke Tran, Sean Caldwell, Calvin Lapp
 * @since March 15th, 2020
 * @version 1.0
 * @name Run.java
 */
import backend.Backend;
import io.FileParser;
import java.util.*;

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
        Backend tests = new Backend();
        FileParser parser = new FileParser();
        Vector<String> testerVector = new Vector<String>();
        Vector<String> oldFileData = new Vector<String>();

        // Set the users var to all users from the accounts file
        tests.setUsers(parser.getFileInfo("current_user_accounts_file.txt"));
        // Loop through each result and display it
        for(int i = 0; i < tests.getUsers().size(); i++) {
            System.out.println(tests.getUsers().get(i));
        }

        // Save data to new variable so we dont lose the original data
        oldFileData.addAll(tests.getUsers());



        System.out.println("\n\nNow writing new information to file and re displaying new content...\n\n");


        // Add too the vector to display new information
        testerVector.add("========================================");
        testerVector.add("              NEW INFO ADDED            ");
        testerVector.add("========================================");
        // Write to the current accoutns file the new information we just created
        parser.writeFile("current_user_accounts_file.txt", testerVector);

        // Show the new user accounts file
        tests.setUsers(parser.getFileInfo("current_user_accounts_file.txt"));
        for(int i = 0; i < tests.getUsers().size(); i++) {
            System.out.println(tests.getUsers().get(i));
        }

        // Set the file back to the previous data
        parser.writeFile("current_user_accounts_file.txt", oldFileData);
    }
}