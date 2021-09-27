/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/
package Module_4;

public class Shoe extends Product {
    
    // private static global class variables
    private static String MESSAGE_SPACING = "       ";
    private static String NEW_LINE_SPACING = "\n";

    // private global class variables
    private double gSize;
    
    /**
     * Default Constructor
     */
    public Shoe() {
        this.gSize = 0;    
    }

    /**
     * Sets the Shoe Size
     * @param gSize double
     */
    public void setSize(double gSize) {
        this.gSize = gSize;
    }

    /**
     * Gets the Shoe size
     * @return double size
     */
    public double getSize() {
        return this.gSize;
    }

    /**
     * Overrides the super.toString to include the super.ToString and the Shoe Size.
     */
    @Override
    public String toString() {
        return super.toString() + NEW_LINE_SPACING +
            MESSAGE_SPACING + "Size: " + this.gSize + NEW_LINE_SPACING + NEW_LINE_SPACING;
    }
}
