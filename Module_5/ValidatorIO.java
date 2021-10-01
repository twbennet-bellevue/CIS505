package Module_5;

import java.util.Scanner;

public class ValidatorIO {


    public static String getString(Scanner sc, String prompt) {
        String input = "";
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);

            if (sc.hasNext()) {
                input = sc.next();
                isValid = true;
            } else {
                System.out.println(StringFormatting.MESSAGE_SPACING + StringFormatting.NEW_LINE_SPACING + 
                    "Error! Invalid string value." + StringFormatting.NEW_LINE_SPACING);
            }
            sc.nextLine();
        }
        return input;
    }

    public static double getDouble(Scanner sc, String prompt) {
        double input = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);

            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println(StringFormatting.MESSAGE_SPACING + StringFormatting.NEW_LINE_SPACING + 
                    "Error! Invalid double value." + StringFormatting.NEW_LINE_SPACING);
            }
            sc.nextLine();
        }
        return input;
    }

    public static Integer getInt(Scanner sc, String prompt) {
        Integer input = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);

            if (sc.hasNextInt()) {
                input = sc.nextInt();
                isValid = true;
            } else {
                System.out.println(StringFormatting.MESSAGE_SPACING + StringFormatting.NEW_LINE_SPACING + 
                    "Error! Invalid integer value." + StringFormatting.NEW_LINE_SPACING);
            }
            sc.nextLine();
        }
        return input;
    }
}
