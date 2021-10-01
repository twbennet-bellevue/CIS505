package Module_5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {

    private static String FILE_NAME = "expenses.txt";

    private static File gFile = new File(FILE_NAME);

    public static ArrayList<Transaction> findAll() throws IOException {
        //open expenses.txt file, iterate through each line, and return an arraylist of transactions
        //Invoke Scanner input = new Scanner(file) 
        
        Scanner input = new Scanner(gFile);
        ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

        while (input.hasNextLine()) {
            //loop, every new line that starts with date is a new loop

            String line = input.nextLine();
            Transaction transaction = new Transaction();
            if (!line.equals("Date,Description,Amount")) {
                String date = "";
                String description = "";
                String amount = "";

                String[] results = line.split(",");
                
                date = results[0];
                description = results[1];
                amount = results[2];

                transaction.setDate(date);
                transaction.setDescription(description);
                transaction.setAmount(Double.parseDouble(amount));
                
                transactionList.add(transaction);
            }            
        }

        return transactionList;
    }

    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;

        if (gFile.exists()) {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME),true));
            
        } else {
            output = new PrintWriter(FILE_NAME);
            output.print("Date" + ",");
            output.print("Description" + ",");
            output.print("Amount");
            output.println("");
        }

        for (Transaction tran: transactions) {
            output.print(tran.getDate() + ",");
            output.print(tran.getDescription() + ",");
            output.print(tran.getAmount());
            output.println("");
        }

        output.close();
    }
}
