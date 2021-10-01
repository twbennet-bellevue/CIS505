/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_5;

import java.io.IOException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {

    public static void main(String[] args) throws IOException {
        int loopCounter = 0;
        boolean cont = true;
        ProgramEntry();
        do {
            Scanner sc = new Scanner(System.in);
            int input = ValidatorIO.getInt(sc, DisplayMenu());
            switch(input) {
                case 1: ViewTransactions(); //Switch to view the transactions
                        break;
                case 2: AddTransaction(sc); //add the transaction to the expenses.txt file
                        break; 
                case 3: SummarizeTransactions(); //summarize the transactions and print them
                        
                default: 
                    cont = ContinuePrompt(); //program loop logic.
            }
            ++loopCounter;
            
            if (loopCounter >= 2 && cont == false) {
                cont = false;
            } else {
                cont = true;
            }

        } while (cont);


        ProgramClose(); //closes the program
    }

    /**
     * GetTransactions from file
     * @return ArrayList<Transaction>
     */
    public static ArrayList<Transaction> GetTransaction() {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        try {
            transactions = TransactionIO.findAll();
        } catch (IOException io) {
            System.out.println(io.toString());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

        return transactions;
    }

    /**
     * Adds the transactions to the system.
     * @param sc Scanner
     * @throws IOException
     */
    public static void AddTransaction(Scanner sc) throws IOException {
        ArrayList<Transaction> transactionIn = new ArrayList<Transaction>();
        double totalExpenses = 0.00;

        //transactionIn = GetTransaction();

        String prompt = "y";
        int loopCounter = 0;

        while (prompt.equalsIgnoreCase("y")) {
            ++loopCounter;
            String description = ValidatorIO.getString(sc, StringFormatting.MESSAGE_SPACING + " Enter the description: ");
            double amount = ValidatorIO.getDouble(sc, StringFormatting.MESSAGE_SPACING + "Enter the amount: ");

            Transaction transaction = new Transaction(description, amount);
            transactionIn.add(transaction);
            if (loopCounter < 2) {
                prompt = ValidatorIO.getString(sc, StringFormatting.MESSAGE_SPACING + "Add another transaction? (y/n): ");
                prompt = "y";
            } else {
                prompt = ValidatorIO.getString(sc, StringFormatting.MESSAGE_SPACING + "Add another transaction? (y/n): ");
            }
            
        }

        TransactionIO.bulkInsert(transactionIn);
    }

    /**
     * View the Transactions
     * @return double Expenses
     * @throws IOException
     */
    public static double ViewTransactions() throws IOException {
        ArrayList<Transaction> transactionIn = new ArrayList<Transaction>();
        double totalExpenses = 0.00;

        transactionIn = GetTransaction();

        System.out.print(
            StringFormatting.NEW_LINE_SPACING + StringFormatting.NEW_LINE_SPACING + 
            StringFormatting.MESSAGE_SPACING + "MONTHLY EXPENSES" + 
            StringFormatting.NEW_LINE_SPACING + StringFormatting.NEW_LINE_SPACING
        );

        for (Transaction transaction : transactionIn) {
            System.out.print(transaction.toString());
        }

        return totalExpenses;
    }

    /**
     * Summarizes the Transactions
     */
    public static void SummarizeTransactions() {
        double totalExpenses = 0.00;

        ArrayList<Transaction> transactionIn = GetTransaction();

      for (Transaction transaction : transactionIn) {
        totalExpenses += transaction.getAmount();
      }
        System.out.println(StringFormatting.NEW_LINE_SPACING + 
        StringFormatting.MESSAGE_SPACING + "Your total monthly expense is " + String.format("$%,6.2f", totalExpenses));
    }

    /**
     * Program Entry Display
     */
    private static void ProgramEntry() {
        String menuOutput = StringFormatting.MESSAGE_SPACING + "Welcome to the Expense Tracker" + StringFormatting.NEW_LINE_SPACING;
        System.out.print(menuOutput);
    }

    /**
     * Program Menu
     */
    private static String DisplayMenu() {
        String menuOutput = StringFormatting.NEW_LINE_SPACING + StringFormatting.MESSAGE_SPACING + "MENU OPTIONS" + StringFormatting.NEW_LINE_SPACING +
            StringFormatting.MESSAGE_SPACING_WITH_TAB + "1. View Transactions" + StringFormatting.NEW_LINE_SPACING +
            StringFormatting.MESSAGE_SPACING_WITH_TAB + "2. Add Transactions" + StringFormatting.NEW_LINE_SPACING +
            StringFormatting.MESSAGE_SPACING_WITH_TAB + "3. View Expense" + StringFormatting.NEW_LINE_SPACING + 
            StringFormatting.NEW_LINE_SPACING +
            StringFormatting.MESSAGE_SPACING + "Please choose an option: ";
        return menuOutput;
    }

    /**
     * Continue Prompt
     * @return boolean true/false
     */
    private static boolean ContinuePrompt() {
        Scanner sc = new Scanner(System.in);
        boolean loopStatus = true;
        String menuOutput = StringFormatting.NEW_LINE_SPACING + StringFormatting.MESSAGE_SPACING + "Continue? (y/n): ";
        System.out.print(menuOutput);
        String result = sc.next();
        if (result.equalsIgnoreCase("n")){
            loopStatus = false;
        } else if (result.equalsIgnoreCase("y")) {
            loopStatus = true;
        }
        return loopStatus;
    }

    /**
     * Program Exiting Message
     */
    private static void ProgramClose() {
        String menuOutput = StringFormatting.MESSAGE_SPACING + "Thanks for using the Expense Tracker! Now closing the program." + StringFormatting.NEW_LINE_SPACING;
        System.out.println(menuOutput);
    }

}
