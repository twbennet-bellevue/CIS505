/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/
package Module_4;

public class Ball extends Product {

    // private static global class variables
    private static String MESSAGE_SPACING = "       ";
    private static String NEW_LINE_SPACING = "\n";
    
    // private global class variables
    private String gColor;

    /**
     * Default Constructor
     */
    public Ball() {
        gColor = "";
    }

    /**
     * Sets the Ball color
     * @param color String
     */
    public void setColor(String color) {
        this.gColor = color;
    }

    /**
     * Gets the Ball Color
     * @return String color
     */
    public String getColor() {
        return this.gColor;
    }

    /**
     * Overrides the super toString to output the ball color with the super toString.
     */
    @Override
    public String toString() {
        return super.toString() + NEW_LINE_SPACING + 
            MESSAGE_SPACING + "Color: " + this.gColor + NEW_LINE_SPACING + NEW_LINE_SPACING;

    }
}
