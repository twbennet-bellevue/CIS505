/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/
package Module_4;

public class Product {

    // private static global class variables
    private static String MESSAGE_SPACING = "       ";
    private static String NEW_LINE_SPACING = "\n";

    // private global variables
    private String gCode;
    private String gDescription;
    private double gPrice;

    /**
     * Default Constructor
     */
    public Product() {
        this.gCode = "";
        this.gDescription = "";
        this.gPrice = 0;
    }

    /**
     * Sets the Product Code
     * @param gCode String
     */
    public void setCode(String gCode) {
        this.gCode = gCode;
    }

    /**
     * Gets the Product Code
     * @return String Code
     */
    public String getCode() {
        return this.gCode;
    }

    /**
     * Sets the Product Description
     * @param gDescription String
     */
    public void setDescription(String gDescription) {
        this.gDescription = gDescription;
    }

    /**
     * Gets the Product Description
     * @return String Description
     */
    public String getDescription() {
        return this.gDescription;
    }

    /**
     * Sets the Product Price
     * @param gPrice double
     */
    public void setPrice(double gPrice) {
        this.gPrice = gPrice;
    }

    /**
     * Gets the Product Price
     * @return gPrice double
     */
    public double getPrice() {
        return this.gPrice;
    }

    /**
     * Overrides super toString to customize the output.
     */
    @Override
    public String toString() {
        String output = MESSAGE_SPACING + "Product Code: " + gCode + NEW_LINE_SPACING +
                        MESSAGE_SPACING + "Description: " + gDescription + NEW_LINE_SPACING + 
                        MESSAGE_SPACING + "Price: " + String.format("$%,6.2f", gPrice);
        return output;
    }
}
