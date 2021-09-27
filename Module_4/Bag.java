/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_4;

public class Bag extends Product {
    
    // private static global class variables
    private static String MESSAGE_SPACING = "       ";
    private static String NEW_LINE_SPACING = "\n";
    
    private String gType;

    /**
     * Default Constructor
     */
    public Bag() {
        this.gType = "";
    }

    /**
     * Sets the Ball Type
     * @param ballType String
     */
    public void setBallType(String ballType) {
        this.gType = ballType;
    }

    /**
     * Gets the Ball Type
     * @return String ballType
     */
    public String getBallType() {
        return this.gType;
    }

    /**
     * Overrides the super.ToString to return a ball type with the super toString.
     */
    @Override
    public String toString() {
        return super.toString() + NEW_LINE_SPACING +
            MESSAGE_SPACING + "Type: " + this.gType + NEW_LINE_SPACING + NEW_LINE_SPACING;
    }
}
