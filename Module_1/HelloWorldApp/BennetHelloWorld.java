/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_1.HelloWorldApp;

public class BennetHelloWorld {

    // Global Class Variables
    private static String gFirstName = "Tyler";
    private static String gLastName = "Bennet";

    public static void main(String[] args) {
        System.out.printf("%s %s", gFirstName, gLastName); // Returns the global values to print to the console.
    } //end main
} //end BennetHelloWorld