package io;
/**
 * FileReader class.
 * This class deals with reading of files.
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
     * Retrieve all data from a file, one line at a time.
     * Store these lines in a vector. 
     * @param fileName
     * @return a vector containing all of the lines of a file.
     */
    public static Vector<String> getFileInfo(String fileName) {
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
        return data;
    }
}