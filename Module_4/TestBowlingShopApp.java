/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/
package Module_4;

import java.util.Scanner;

public class TestBowlingShopApp {

    // private static global variables
    private static String MESSAGE_SPACING = "       ";
    private static String MESSAGE_SPACING_SMALL = "    ";
    private static String NEW_LINE_SPACING = "\n";

    public static void main(String[] args) {
        promptUser(); //Program Prompt & Output Logic
    }

    /**
     * Prompts the User for Products and Menu Options
     * Options: b, a, s, x
     */
    public static void promptUser() {
        String userInput = "";
        Scanner scanner = new Scanner(System.in);
        boolean customerPromptFlag = true;
        GenericQueue<Product> productResults;

        while (customerPromptFlag) {
            displayMenu();
            System.out.print(MESSAGE_SPACING +"Please choose an option: ");
            userInput = scanner.next(); // Get user input
            if (!userInput.equalsIgnoreCase("x")) { 
                System.out.print(NEW_LINE_SPACING + MESSAGE_SPACING + "--Product Listing--"+ NEW_LINE_SPACING);
            } else {
                programClose(); // Program close logic (assuming "x" is detected)
            } 
            

            if (userInput.equalsIgnoreCase("s")|| userInput.equalsIgnoreCase("b") || userInput.equalsIgnoreCase("a")) {
                productResults = ProductDB.getProducts(userInput.toLowerCase());
                while (productResults.size() > 0) {

                    System.out.print(productResults.dequeue());
                }
            } else if (userInput.equalsIgnoreCase("x")) {
                customerPromptFlag = false; //break program loop if user enters an "x"
            }
            
        }
    }

    /**
     * Displays the Program Menu Message
     */
    public static void displayMenu() {
        String menuOutput =  NEW_LINE_SPACING + MESSAGE_SPACING + "MENU OPTIONS" + NEW_LINE_SPACING +
            MESSAGE_SPACING + MESSAGE_SPACING_SMALL + "1. <b> Bowling Balls" + NEW_LINE_SPACING +
            MESSAGE_SPACING + MESSAGE_SPACING_SMALL + "2. <a> Bowling Bag" + NEW_LINE_SPACING +
            MESSAGE_SPACING + MESSAGE_SPACING_SMALL + "3. <s> Bowling Shoes" + NEW_LINE_SPACING +
            MESSAGE_SPACING + MESSAGE_SPACING_SMALL + "4. <x> To exit" + NEW_LINE_SPACING + NEW_LINE_SPACING;

        System.out.print(menuOutput);          
    }

    /**
     * Displays the Program Exit Message
     */
    public static void programClose() {
        String menuExitOutput = MESSAGE_SPACING + "--Program Exit--" + NEW_LINE_SPACING;

        System.out.print(menuExitOutput);
    }

}
