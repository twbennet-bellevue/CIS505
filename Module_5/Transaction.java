package Module_5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    private String gDate = dateFormat.format(date);
    private String gDescription;
    private double gAmount;

    public Transaction() {
        this.gDescription = "";
        this.gAmount = 0;
    }

    public Transaction(String description, double amount) {
        this.gDescription = description;
        this.gAmount = amount;
    }

    public void setDate(String gDate) {
        this.gDate = gDate;
    }

    public String getDate() {
        return this.gDate;
    }

    public void setDescription(String gDescription) {
        this.gDescription = gDescription;
    }

    public String getDescription() {
        return this.gDescription;
    }

    public void setAmount(double gAmount) {
        this.gAmount = gAmount;
    }

    public double getAmount() {
        return this.gAmount;
    }

    @Override
    public String toString() {
        String output = StringFormatting.MESSAGE_SPACING + "Date: " + this.gDate + StringFormatting.NEW_LINE_SPACING +
                        StringFormatting.MESSAGE_SPACING + "Description: " + this.gDescription + StringFormatting.NEW_LINE_SPACING +
                        StringFormatting.MESSAGE_SPACING + "Amount: " + String.format("$%,6.2f", this.gAmount) + StringFormatting.NEW_LINE_SPACING +
                        StringFormatting.NEW_LINE_SPACING;
        return output;
    }
}
