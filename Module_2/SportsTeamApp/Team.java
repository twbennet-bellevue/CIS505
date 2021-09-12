/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
    https://stackoverflow.com/questions/45622269/resize-and-copy-java-array-in-one-operation //site this
*/

package Module_2.SportsTeamApp;

import java.util.Arrays;

public class Team {
    // private class global static variables
    private static int DEFAULT_PLAYER_LIMIT = 20;

    // private class global variables
    private String gTeamName;
    private String[] gPlayers;
    private int gPlayerCount;

    /**
     * Default Constructor
     * Values are set to the default for team name, player count, and gPlayers with a default size of 20.
     */
    public Team() {
        this.gTeamName = "";
        this.gPlayerCount = 0;
        this.gPlayers = new String[DEFAULT_PLAYER_LIMIT];
    }

    /**
     * One Argument Constructor, which is used to enter in a team name.
     * @param teamNameIn String
     */
    public Team(String teamNameIn) {
        this.gTeamName = teamNameIn;
    }

    /**
     * 
     * @param playerNameIn String
     */
    public void addPlayer(String playerNameIn) {

        String[] tempPlayerArray = new String[gPlayerCount+1];

        if (gPlayerCount >= DEFAULT_PLAYER_LIMIT) {
            System.out.println("player limit reached" + gPlayerCount + "," + tempPlayerArray.length);
            for (int i=0; i < gPlayerCount; i++) {
                tempPlayerArray[i] = gPlayers[i];
            }
            this.gPlayers = tempPlayerArray;
            this.gPlayers[gPlayerCount] = playerNameIn;
        } else {
            this.gPlayers[gPlayerCount] = playerNameIn;
        }

        ++gPlayerCount;

    }

    /**
     * 
     * @return returns the player string array
     */
    public String[] getPlayers() {
        if (this.gPlayerCount <= DEFAULT_PLAYER_LIMIT) {
            this.gPlayers = Arrays.copyOfRange(gPlayers, 0, gPlayerCount);
        } 
        return this.gPlayers;
    }

    /**
     * 
     * @return returns the player count as an integer
     */
    public int getPlayerCount() {
        return this.gPlayerCount;
    }

    /**
     * 
     * @param playerCountIn int
     */
    public void setPlayerCount(int playerCountIn) {
        this.gPlayerCount = playerCountIn;
    }

    /**
     * 
     * @return returns the team name
     */
    public String getTeamName() {
        return this.gTeamName;
    }

    /**
     * 
     * @param teamNameIn String
     */
    public void setTeamName(String teamNameIn) {
        this.gTeamName = teamNameIn;
    }
}
