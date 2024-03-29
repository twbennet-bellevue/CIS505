/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_2.SportsTeamApp;

import java.util.Scanner;

public class TestSportsTeamApp {
    private static String MESSAGE_SPACING = "       ";
    private static String NEW_LINE_SPACING = "\n";
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);

        programEntryMessage(); //Present the program entry to the user interface

        while (true) {
            Team teamA = new Team();
            promptTeamName(userInput, teamA); // Prompt the user for the team name.
            promptPlayerName(userInput, teamA); // Prompt the user for the player names.
            summaryResults(userInput, teamA); // Output the results to the user
            
            if (continueMessage(userInput) == "n") {
                break;
            }
        }

    }

    /**
     * Welcome message method
     */
    private static void programEntryMessage() {
        System.out.println(MESSAGE_SPACING + "Welcome to the Sports Team App.");
        System.out.print(NEW_LINE_SPACING);
    }
    
    /**
     * Prompts the user for a team name.
     * @param objIn
     * @param teamIn
     */
    private static void promptTeamName(Scanner objIn, Team teamIn) {
        System.out.print(MESSAGE_SPACING + "Enter a team name: ");

        String teamNameIn;
        while (true) {
            teamNameIn = objIn.nextLine();
            teamIn.setTeamName(teamNameIn);
            System.out.print(NEW_LINE_SPACING);
            break;
        }
    }

    /**
     * Prompts the user for the player names.
     * @param objIn
     * @param teamIn
     */
    private static void promptPlayerName(Scanner objIn, Team teamIn) {
        System.out.println(MESSAGE_SPACING + "Enter the player names: ");
        System.out.print(MESSAGE_SPACING + "  hint: use commas for multiple players; no spaces>: ");

        String playerNamesIn;
        while (true) {
            playerNamesIn = objIn.nextLine();
            playerNamesIn.replaceAll("\\s", "");

            if (playerNamesIn != null || playerNamesIn != "") {
                String[] playersList = playerNamesIn.split(",");
                for (int i=0; i < playersList.length; ++i) {
                    teamIn.addPlayer(playersList[i]);
                }
                break;
            }
        }

        System.out.print(NEW_LINE_SPACING);
    }

    /**
     * Prints out the summary results.
     * @param objIn
     * @param teamIn
     */
    private static void summaryResults(Scanner objIn, Team teamIn) {
        System.out.println(MESSAGE_SPACING + "--Team Summary--");
        System.out.println(MESSAGE_SPACING + "Number of players in team: " + teamIn.getPlayerCount());
        System.out.print(MESSAGE_SPACING + "Players on team: ");
        
        String[] playerNamesIn;
        while (true) {
            playerNamesIn = teamIn.getPlayers();

            if (playerNamesIn != null) {
                for (int i=0; i < playerNamesIn.length; i++) {
                    if (i != 0) {
                        System.out.print(",");
                    }
                    System.out.print(playerNamesIn[i]);
                }
                break;
            } else {
                System.out.println("Player names were null.");
            }
        }
        System.out.print(NEW_LINE_SPACING);
    }

    /**
     * Prompt user to continue or not.
     * @param objIn
     * @return
     */
    private static String continueMessage(Scanner objIn) {
        String promptContinue;
        while (true) {
            System.out.print(NEW_LINE_SPACING + MESSAGE_SPACING + "Continue? (y/n): " );
            promptContinue = objIn.nextLine();
            System.out.print(NEW_LINE_SPACING);

            switch(promptContinue.toLowerCase()) {
                case "y":
                    return "y";
                case "n":
                    return "n";
            }

        }

    }
}
