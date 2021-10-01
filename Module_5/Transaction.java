/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    
    //private global class variables
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    private String gDate = dateFormat.format(date);
    private String gDescription;
    private double gAmount;

    /**
     * Default Constructor
     */
    public Transaction() {
        this.gDescription = "";
        this.gAmount = 0;
    }

    /**
     * Multiargument constructor
     * @param description String
     * @param amount double
     */
    public Transaction(String description, double amount) {
        this.gDescription = description;
        this.gAmount = amount;
    }

    /**
     * Sets the Transaction Date
     * @param gDate String
     */
    public void setDate(String gDate) {
        this.gDate = gDate;
    }

    /**
     * Gets the Transaction Date
     * @return String
     */
    public String getDate() {
        return this.gDate;
    }

    /**
     * Sets the Transaction Description
     * 
     */
    public void setDescription(String gDescription) {
        this.gDescription = gDescription;
    }

    /**
     * Gets the Transaction Description
     * @return String
     */
    public String getDescription() {
        return this.gDescription;
    }

    /**
     * Sets the Transaction Amount
     * @param gAmount double
     */
    public void setAmount(double gAmount) {
        this.gAmount = gAmount;
    }

    /**
     * Gets the Transaction Amount
     * @return double
     */
    public double getAmount() {
        return this.gAmount;
    }

    /**
     * Overrides the super.toString() method for a custom output format.
     */
    @Override
    public String toString() {
        String output = StringFormatting.MESSAGE_SPACING + "Date: " + this.gDate + StringFormatting.NEW_LINE_SPACING +
                        StringFormatting.MESSAGE_SPACING + "Description: " + this.gDescription + StringFormatting.NEW_LINE_SPACING +
                        StringFormatting.MESSAGE_SPACING + "Amount: " + String.format("$%,6.2f", this.gAmount) + StringFormatting.NEW_LINE_SPACING +
                        StringFormatting.NEW_LINE_SPACING;
        return output;
    }
}
