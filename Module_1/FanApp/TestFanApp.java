/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_1.FanApp;

public class TestFanApp {

    public static void main(String[] args) {
        Fan test = new Fan(); // Create a default Fan object
        Fan test2 = new Fan(12, true, 8.2, "Red"); // Create a new Fan object with the values 12, true, 8.2, "Red".

        test2.setFanSpeed(25); // Set the second Fan object to a speed of 25.

        System.out.println(test); // Call the toString() method for the first Fan object
        System.out.println(test2); // Call the toString() method for the second Fan object

    } // end main
} //end BennetHelloWorld