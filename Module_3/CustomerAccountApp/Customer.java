/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_3.CustomerAccountApp;

/**
 * 
 */
public class Customer {

    private static String MESSAGE_SPACING = "       ";
    private static String NEW_LINE_SPACING = "\n";

    private String gName;
    private String gAddress;
    private String gCity;
    private String gZip;

    /**
     * Default Constructor
     */
    public Customer() {
        this.gName = "";
        this.gAddress = "";
        this.gCity = "";
        this.gZip = "";
    }

    /**
     * 4 Argument Constructor to build a custom customer.
     * @param gName
     * @param gAddress
     * @param gCity
     * @param gZip
     */
    public Customer(String gName, String gAddress, String gCity, String gZip) {
        this.gName = gName;
        this.gAddress = gAddress;
        this.gCity = gCity;
        this.gZip = gZip;
    }
    
    /**
     * @Override toString method for custom output.
     */
    public String toString() {
        String customerDetails = "";
        customerDetails += MESSAGE_SPACING + "--Customer Details--" + NEW_LINE_SPACING;
        customerDetails += MESSAGE_SPACING + "Name: " + this.gName + NEW_LINE_SPACING;
        customerDetails += MESSAGE_SPACING + "Address: " + this.gAddress + NEW_LINE_SPACING;
        customerDetails += MESSAGE_SPACING + "City: " + this.gCity + NEW_LINE_SPACING;
        customerDetails += MESSAGE_SPACING + "Zip: " + this.gZip + NEW_LINE_SPACING; 

        return customerDetails;

    }
}
