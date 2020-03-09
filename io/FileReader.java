package io;
/**
 * FileReader class.
 * Reads input from files
 * 
 * @author Luke Tran, Sean Caldwell, Calvin Lapp
 * @since March 2nd, 2020
 * @version 1.0
 * @name FileReader.java
 */

import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    /* Methods */

    /**
     * Retrieve all transactions from daily transaction file
     * @param fileName
     * @return a vector containing all of the transaction lines
     */
    public static Vector<String> getTransactions(String fileName) {
        Vector<String> data = new Vector<String>();
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while(reader.hasNext()){
                data.add(reader.nextLine());
            }
            reader.close();
        }catch(FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        System.out.println("Get Transactions method.");
        return data;
    }

    /**
     * Retrieve all users from current users file
     * @param fileName
     * @return
     */
    public static Vector<String> getUsers(String fileName) {
        System.out.println("Get Users method.");
        return null;
    }

    /**
     * Retrieve all items from available items file
     * @param fileName
     * @return
     */
    public static Vector<String> getItems(String fileName) {
        System.out.println("Get Items method.");
        return null;
    }
}