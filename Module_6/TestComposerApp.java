/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/
package Module_6;

import java.util.List;
import java.util.Scanner;

public class TestComposerApp {
    
    public static void main(String[] args) {
        ProgramEntry();

        boolean cont = true;
        MemComposerDao composerDao = new MemComposerDao();
        
        do {
            System.out.print(DisplayMenu());
            Scanner sc = new Scanner(System.in);
            switch(sc.nextInt()) {
                case 1: ViewComposers(composerDao); //Switch to view the Composers
                        break;
                case 2: FindComposer(composerDao, sc); //Find the Composer at ID
                        break; 
                case 3: InsertComposer(composerDao, sc); //Inserts a Composer
                        break;
                case 4: Exit(); // Exits the application. 
                default: 
                    break;
            } 
        } while (cont);

    }

    /**
     * Exits the application gracefully
     */
    private static void Exit() {
        ProgramClose();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);

    }

    /**
     * View the Composers
     * @param composerDao MemComposerDao
     */
    private static void ViewComposers(MemComposerDao composerDao) {
        List<Composer> composers = composerDao.findAll();

        System.out.println(StringFormatting.NEW_LINE_CHAR_RETURN + StringFormatting.MESSAGE_SPACING + "--DISPLAYING COMPOSERS--");
        for (Composer composer : composers) {
            System.out.println(composer.toString() + StringFormatting.NEW_LINE_CHAR_RETURN);
        }
    }

    /**
     * Finds the Composer
     * @param composerDao MemComposerDao
     * @param sc Scanner
     */
    private static void FindComposer(MemComposerDao composerDao, Scanner sc) {
        System.out.println(StringFormatting.NEW_LINE_CHAR_RETURN);
        System.out.print(StringFormatting.MESSAGE_SPACING + "Enter an id: ");
        try {
            Composer composer = composerDao.findBy(sc.nextInt());
            System.out.println(StringFormatting.NEW_LINE_CHAR_RETURN);
            System.out.println(StringFormatting.MESSAGE_SPACING + "--DISPLAYING COMPOSER--");
            System.out.println(composer.toString());
        } catch (NullPointerException np) {
            System.out.println(StringFormatting.MESSAGE_SPACING + "No composer was found");
        }
    }

    /**
     * Inserts a Composer
     * @param composerDao MemComposerDao
     * @param sc Scanner
     */
    private static void InsertComposer(MemComposerDao composerDao, Scanner sc) {
        System.out.print(StringFormatting.MESSAGE_SPACING + "Enter an id: ");
        int id = sc.nextInt();

        System.out.print(StringFormatting.MESSAGE_SPACING + "Enter a name: ");
        String name = sc.next();
        name += sc.nextLine();

        System.out.print(StringFormatting.MESSAGE_SPACING + "Enter a genre: " );
        String genre = sc.next();
        genre += sc.nextLine();

        composerDao.insert(new Composer(id, name, genre));
    }

    /**
     * Program Exiting Message
     */
    private static void ProgramClose() {
        System.out.println(StringFormatting.NEW_LINE_CHAR_RETURN);
        String menuOutput = StringFormatting.MESSAGE_SPACING + "Thanks for using the Composer Tracker! Now closing the program." + StringFormatting.NEW_LINE_SPACING;
        System.out.println(menuOutput);
    }
    
    /**
     * Program Entry Display
     */
    private static void ProgramEntry() {
        String menuOutput = StringFormatting.MESSAGE_SPACING + "Welcome to the Composer Tracker" + StringFormatting.NEW_LINE_SPACING;
        System.out.print(menuOutput);
    }

    /**
     * Program Menu
     */
    private static String DisplayMenu() {
        String menuOutput = StringFormatting.NEW_LINE_SPACING + StringFormatting.MESSAGE_SPACING + "MENU OPTIONS" + StringFormatting.NEW_LINE_SPACING +
            StringFormatting.MESSAGE_SPACING_WITH_TAB + "1. View Composers" + StringFormatting.NEW_LINE_SPACING +
            StringFormatting.MESSAGE_SPACING_WITH_TAB + "2. Find Composer" + StringFormatting.NEW_LINE_SPACING +
            StringFormatting.MESSAGE_SPACING_WITH_TAB + "3. Add Composer" + StringFormatting.NEW_LINE_SPACING + 
            StringFormatting.MESSAGE_SPACING_WITH_TAB + "4. Exit" + StringFormatting.NEW_LINE_SPACING + 
            StringFormatting.NEW_LINE_SPACING +
            StringFormatting.MESSAGE_SPACING + "Please choose an option: ";
        return menuOutput;
    }
}
