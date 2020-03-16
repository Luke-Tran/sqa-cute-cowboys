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
import backend.Constants.*;

public class Item {

    public Item(String itemDetails) {
        if(itemDetails.length() == Constants.TRANS_ITEM_ENTRY_LENGTH) {
            this.name = itemDetails.substring(0, 25);
            this.seller = itemDetails.substring(26, 41);
            this.bidder = new String(new char[15]).replace('\0', ' ' ); // Fill 15 empty spaces for blank bidder
            this.days = itemDetails.substring(42, 45);
            this.price = itemDetails.substring(46, 52);
        } else if(itemDetails.length() == Constants.AVAIL_ITEM_ENTRY_LENGTH) {
            this.name = itemDetails.substring(0, 25);
            this.seller = itemDetails.substring(26, 41);
            this.bidder = itemDetails.substring(42, 57);
            this.days = itemDetails.substring(58, 61);
            this.price = itemDetails.substring(62, 68);
        } else {
            System.out.println("ERROR: Discrepency in item details");
        }
    }

    /* Attributes */
    private String name;

    private String seller;

    private String bidder;

    private String days;

    private String price;

    /* Methods */

    /* Setters*/

    public void setName(String name) {
        this.name = name;
    }

    public void setSaller(String seller) {
        this.seller = seller;
    }

    public void setBidder(String bidder) {
        this.bidder = bidder;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    /* Getters */

    public String getName() {
        return this.name;
    }

    public String getSeller() {
        return this.seller;
    }

    public String getBidder() {
        return this.bidder;
    }

    public String getDays() {
        return this.days;
    }

    public String getPrice() {
        return this.price;
    }

    /**
     * Concatenates item information seperated by spaces to be displayed
     * @return A string of the item details to be placed in the available items file
     */
    public String itemString() {
        return this.getName() + " " + this.getSeller() + " " + this.getBidder() + " " + this.getDays() + " " + this.getPrice();
    }
}