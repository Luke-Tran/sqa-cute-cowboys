package io;
/**
 * FileWriter class.
 * Writes output to files.
 *
 * @author Luke Tran, Sean Caldwell, Calvin Lapp
 * @since March 2nd, 2020
 * @version 1.0
 * @name FileWriter.java
 */

import java.util.Vector;
import java.io.*;

/**
 * Main function
 * @param
 * @return
 */
public class FileWriter {

    /* Methods */
    /**
     *
     * 
     */



     /**
      * Write the changed user and item details to their respective files
      * @param userData, itemData
      * @return
      */
    public static void writeFiles(Vector<String> userData, Vector<String> itemData) {

      //write user details to the current user file
      try {
            PrintWriter pw = new PrintWriter("current_user_accounts_file.txt");

        } catch (FileNotFoundException fnfe){
            System.out.println(fnfe);
        }
        for(int i = 0; i < userData.size(); i++){
          pw.write(userData.get(i));
        }
        pw.flush();
        pw.close();


        //write item details to the available items file
        try {
              PrintWriter pw = new PrintWriter("available_items_file.txt");

          } catch (FileNotFoundException fnfe){
              System.out.println(fnfe);
          }
          for(int i = 0; i < itemData.size(); i++){
            pw.write(itemData.get(i));
          }
          pw.flush();
          pw.close();
    }


    /**
     * Wipe the daily transaction file
     * @param
     * @return
     */
    public static void wipeTransactionFile() {
      try {
            PrintWriter pw = new PrintWriter("daily_transaction_file.txt");
            pw.close();
        } catch (FileNotFoundException fnfe){
            System.out.println(fnfe);
        }

    }

}
