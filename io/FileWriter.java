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

public class FileWriter {

    /* Methods */

     /**
      * Write new data to the specified data
      * @param data
      * @return
      */
    public void writeFile(String file, Vector<String> data) {

      //write details to the current file
      try {
            PrintWriter pw = new PrintWriter(file);
            
            for(int i = 0; i < data.size(); i++){
                pw.write(data.get(i));
            }
            pw.flush();
            pw.close();

        } catch (FileNotFoundException fnfe){
            System.out.println(fnfe);
        }
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
