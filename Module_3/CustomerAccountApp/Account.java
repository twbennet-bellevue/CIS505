/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_3.CustomerAccountApp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  Account Class 
 */
public class Account {

    // private static global variables
    private static String MESSAGE_SPACING = "       ";
    private static String NEW_LINE_SPACING = "\n";
    private static int DEFAULT_ACCOUNT_BALANCE = 200;

    // private global variables
    private double gBalance;
    
    /**
     * Default Constructor
     */
    public Account() {
        this.gBalance = DEFAULT_ACCOUNT_BALANCE;
    }

    /**
     * Deposits the amount into the Account.
     * @param amt Double
     */
    public void deposit(double amt) {
        this.gBalance += amt;
    }

    /**
     * Withdraws the balance from the Account
     * @param amt Double
     */
    public void withdraw(double amt) {
        if (this.gBalance >= amt) {
            this.gBalance -= amt;
        }
    }

    /**
     * Sets the Balance for the Account.
     * @param gBalance Double
     */
    public void setBalance(double gBalance) {
        this.gBalance = gBalance;
    }

    /**
     * Get the Account Balance
     * @return Double gBalance
     */
    public double getBalance() {
        return this.gBalance;
    }

    /**
     * Displays the Menu to the user.
     */
    public void displayMenu() {
        String accountMenu = "";

        accountMenu += MESSAGE_SPACING + "Account Menu" + NEW_LINE_SPACING;
        accountMenu += MESSAGE_SPACING + "Enter <D/d> for deposit" + NEW_LINE_SPACING;
        accountMenu += MESSAGE_SPACING + "Enter <W/w> for withdraw" + NEW_LINE_SPACING;
        accountMenu += MESSAGE_SPACING + "Enter <B/b> for balance" + NEW_LINE_SPACING;
        accountMenu += MESSAGE_SPACING + "    Enter option>: ";

        System.out.print(accountMenu);
    }

    /**
     * Get the transaction date
     * @return String transaction date
     */
    public String getTransactionDate() {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        return formatter.format(date);
    }
}
