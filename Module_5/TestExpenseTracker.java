package Module_5;

public class TestExpenseTracker {
    
    private String gDate;
    private String gDescription;
    private double gAmount;

    public TestExpenseTracker() {
        this.gDate = "00/00/0000"; //generate default date
        this.gDescription = "";
        this.gAmount = 0;
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
                        StringFormatting.MESSAGE_SPACING + "Amount: " + this.gAmount + StringFormatting.NEW_LINE_SPACING;
        return output;
    }
}
