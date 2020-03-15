/**
 * 
 */
import backend.Backend;
import io.FileParser;
import java.util.*;

class Run {

    public static void main(String[] args) {
        Backend tests = new Backend();
        FileParser parser = new FileParser();
        Vector<String> testerVector = new Vector<String>();

        tests.setUsers(parser.getFileInfo("current_user_accounts_file.txt"));
        for(int i = 0; i < tests.getUsers().size(); i++) {
            System.out.println(tests.getUsers().get(i));
        }



        System.out.println("\n\nNow writing new information to file and re displaying new content...\n\n");



        testerVector.add("========================================");
        testerVector.add("              NEW INFO ADDED            ");
        testerVector.add("========================================");
        parser.writeFile("current_user_accounts_file.txt", testerVector);

        
        tests.setUsers(parser.getFileInfo("current_user_accounts_file.txt"));
        for(int i = 0; i < tests.getUsers().size(); i++) {
            System.out.println(tests.getUsers().get(i));
        }
    }
}