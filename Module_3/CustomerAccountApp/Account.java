/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_3.CustomerAccountApp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {

    private static String MESSAGE_SPACING = "       ";
    private static String NEW_LINE_SPACING = "\n";
    private static int DEFAULT_ACCOUNT_BALANCE = 200;

    private double gBalance;
    
    public Account() {
        this.gBalance = DEFAULT_ACCOUNT_BALANCE;
    }

    public void deposit(double amt) {
        this.gBalance += amt;
    }

    public void withdraw(double amt) {
        if (this.gBalance >= amt) {
            this.gBalance -= amt;
        }
    }

    public void setBalance(double gBalance) {
        this.gBalance = gBalance;
    }

    public double getBalance() {
        return this.gBalance;
    }

    public void displayMenu() {
        String accountMenu = "";

        accountMenu += MESSAGE_SPACING + "Account Menu" + NEW_LINE_SPACING;
        accountMenu += MESSAGE_SPACING + "Enter <D/d> for deposit" + NEW_LINE_SPACING;
        accountMenu += MESSAGE_SPACING + "Enter <W/w> for withdraw" + NEW_LINE_SPACING;
        accountMenu += MESSAGE_SPACING + "Enter <B/b> for balance" + NEW_LINE_SPACING;
        accountMenu += MESSAGE_SPACING + "    Enter option>: ";

        System.out.print(accountMenu);
    }

    public String getTransactionDate() {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        return formatter.format(date);
    }
}
