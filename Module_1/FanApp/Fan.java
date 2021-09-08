/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package FanApp;

public class Fan {

    // public class global static variables
    public static int STOPPED = 0;
    public static int SLOW = 1;
    public static int MEDIUM = 2;
    public static int FAST = 3;

    // private class global variables
    private int gFanSpeed;
    private boolean gFanStatus;
    private double gFanRadius;
    private String gFanColor;

    /**
     * Default Constructor
     */
    public Fan() {
        this.gFanSpeed = STOPPED;
        this.gFanStatus = false;
        this.gFanRadius = 6;
        this.gFanColor = "White";


    } // end Fan Default Constructor

    /**
     * 4 argument constructor, which is used to set the fan's speed, status, radius, and color.
     * @param inFanSpeed int
     * @param inFanStatus boolean
     * @param inFanRadius double
     * @param inFanColor String
     */
    public Fan(int inFanSpeed, boolean inFanStatus, double inFanRadius, String inFanColor) {
        this.gFanSpeed = inFanSpeed;
        this.gFanStatus = inFanStatus;
        this.gFanRadius = inFanRadius;
        this.gFanColor = inFanColor;
    } // end Fan

    /**
     * 
     * @param inFanSpeed int
     */
    public void setFanSpeed(int inFanSpeed) {
        this.gFanSpeed = inFanSpeed;
    } // end setFanSpeed

    /**
     * 
     * @return returns the fan speed
     */
    public int getFanSpeed() {
        return this.gFanSpeed;
    } // end getFanSpeed

    /**
     * 
     * @param inFanStatus boolean
     */
    public void setFanStatus(boolean inFanStatus) {
        this.gFanStatus = inFanStatus;
    } // end setFanStatus

    /**
     * 
     * @return returns the fan status
     */
    public boolean getFanStatus() {
        return this.gFanStatus;
    } // end getFanStatus

    /**
     * 
     * @param inFanRadius double
     */
    public void setFanRadius(double inFanRadius) {
        this.gFanRadius = inFanRadius;
    } // end setFanRadius

    /**
     * 
     * @return returns the fan's radius
     */
    public double getFanRadius() {
        return gFanRadius;
    } // end getFanRadius

    /**
     * 
     * @param inFanColor String
     */
    public void setFanColor(String inFanColor) {
        this.gFanColor = inFanColor;
    } // end setFanColor

    /**
     * 
     * @return returns the fan's color
     */
    public String getFanColor() {
        return gFanColor;
    } // end getFanColor

    /**
     * Overrides the ToString value to print the fan status.
     * @return prints the results to the console window.
     */
    public String toString() {

        if(this.gFanStatus == true) {
            return String.format("The fan speed is set to %s with a color of %s and a radius of %s", this.gFanSpeed, this.gFanColor, this.gFanRadius); 
        } else {
            return String.format("The fan is %s with a radius of %s and the fan is off", this.gFanColor, this.gFanRadius);
        }
    } // end ToString
} // end Fan Class