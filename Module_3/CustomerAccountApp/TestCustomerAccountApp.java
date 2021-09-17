/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_3.CustomerAccountApp;

import java.util.Scanner;

/**
 * TestCustomerAccountApp - Program Entry Class
 */
public class TestCustomerAccountApp {

    // private static global strings
    private static String MESSAGE_SPACING = "       ";
    private static String NEW_LINE_SPACING = "\n";

 
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean programLoop = true;

        programEntryMessage(); //Present the program entry to the user interface
        
        do {
            Account userAccount = new Account();
            Customer gCurrentCustomer = promptCustomerId(userInput); //Prompts the user for a valid user ID.

            System.out.print(NEW_LINE_SPACING);

            userAccount.displayMenu(); //Displays the menu to the user
            userAccount = promptAccountAction(userInput, userAccount); //Prompt the user for account actions

            System.out.print(NEW_LINE_SPACING);
            System.out.println(gCurrentCustomer.toString());
            System.out.printf(MESSAGE_SPACING + "Account Balance: " + "$%,6.2f", userAccount.getBalance());
            System.out.println(NEW_LINE_SPACING);

            programLoop = programContinueLoop(userInput); //Loop Decision for Continuing or exiting

        } while (programLoop);
        
    }

    /**
     * Welcome message method
     */
    private static void programEntryMessage() {
        System.out.println(MESSAGE_SPACING + "Welcome to the Customer Account App.");
        System.out.print(NEW_LINE_SPACING);
    }

    /**
     * Prompt the user for a Customer ID to lookup.
     * @param objIn Scanner
     * @return Customer object
     */
    private static Customer promptCustomerId(Scanner objIn) {
        Customer customerDetails = new Customer();
        boolean customerIdFlag = true;
        int customerId = 0;


        while (customerIdFlag) {
            System.out.println(MESSAGE_SPACING + "Enter a customer ID: ");
            System.out.print(MESSAGE_SPACING + "  ex: 1007, 1008, 1009>: ");
    
            customerId = objIn.nextInt();
            System.out.println(customerId);

            switch (customerId) {
                case 1007: 
                    customerDetails = CustomerDB.getCustomer(1007); 
                    customerIdFlag = false;
                    break;
                case 1008: 
                    customerDetails = CustomerDB.getCustomer(1008); 
                    customerIdFlag = false;
                    break;
                case 1009: 
                    customerDetails = CustomerDB.getCustomer(1009); 
                    customerIdFlag = false;
                    break;
                default: 
                    customerDetails = new Customer(); 
                    customerIdFlag = false;
                    break;
            }
        }
        return customerDetails;
        
    }

    /**
     * Prompt Account Actions from user
     * @param objIn Scanner
     * @return Account object
     */
    private static Account promptAccountAction(Scanner objIn, Account accountIn) {
        String userInput = "";
        Customer customerDetails = new Customer();
        boolean customerIdFlag = true;

        while (customerIdFlag) {
            userInput = objIn.next();
            
            switch (userInput.toLowerCase()) {
                case "d": deposit(objIn, accountIn); customerIdFlag = false; break;
                case "w": withdraw(objIn, accountIn); customerIdFlag = false; break;
                case "b": getBalance(accountIn); customerIdFlag = false; break;
                default: System.out.println(MESSAGE_SPACING + "Error: Invalid Option"); break;
            }
            System.out.print(NEW_LINE_SPACING);
        }
        return accountIn;
    }

    /**
     * Program Continue Loop 
     * @param objIn Scanner
     * @return boolean
     */
    private static boolean programContinueLoop(Scanner objIn) {
        boolean programLoopFlag = true;
        boolean continueLoopId = true;
        String userInput = "";

        while (continueLoopId) {
            System.out.print(MESSAGE_SPACING + "Continue? (y/n): ");
            userInput = objIn.next();
            
            switch (userInput.toLowerCase()) {
                case "y": programLoopFlag = true; continueLoopId = false; break;
                case "n": programLoopFlag = false; continueLoopId = false; break;
                default: System.out.println(MESSAGE_SPACING + "Error: Invalid Option"); break;
            }
            System.out.print(NEW_LINE_SPACING);
        }

        return programLoopFlag;
    }

    /**
     * Deposit Money
     * @param objIn Scanner
     * @param accountIn Account
     */
    private static void deposit(Scanner objIn, Account accountIn) {
        System.out.print(MESSAGE_SPACING + "Enter deposit amount: ");
        double userInput = objIn.nextDouble();
        accountIn.deposit(userInput);
    }

    /**
     * Withdraw Money
     * @param objIn Scanner
     * @param accountIn Account
     */
    private static void withdraw(Scanner objIn, Account accountIn) {
        System.out.println(MESSAGE_SPACING + "Enter withdraw amount: ");
        double userInput = objIn.nextDouble();

        accountIn.withdraw(userInput);
    }

    /**
     * Get Balance
     * @param accountIn Account
     */
    private static void getBalance(Account accountIn) {
        System.out.printf(MESSAGE_SPACING + "Balance as of " + accountIn.getTransactionDate() + " is " + "$%,6.2f", accountIn.getBalance());
    }
    
}
