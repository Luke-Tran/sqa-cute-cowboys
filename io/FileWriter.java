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
class FileWriter {

    /* Methods */
    /**
     *
     * @param data
     */



     /**
      * Write the changed user and item details to their respective files
      * @param data
      * @return
      */
    public static void writeUsersFile(Vector<String> userData, Vector<String> itemData) {
      try {
            PrintWriter pw = new PrintWriter("current_user_accounts_file.txt");

        } catch (FileNotFoundException fnfe){
            System.out.println(fnfe);
        }


        pw.close();



        try {
              PrintWriter pw = new PrintWriter("available_items_file.txt");

          } catch (FileNotFoundException fnfe){
              System.out.println(fnfe);
          }

          pw.close();
    }


    /**
     * Wipe the daily transaction file
     * @param data
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
