/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
    https://stackoverflow.com/questions/45622269/resize-and-copy-java-array-in-one-operation //site this
*/

package Module_2.SportsTeamApp;

import java.util.Arrays;

public class Team {

    private static int DEFAULT_PLAYER_LIMIT = 20;

    private String gTeamName;
    private String[] gPlayers = new String[DEFAULT_PLAYER_LIMIT];
    private int gPlayerCount;

    public Team() {
        this.gTeamName = "";
        this.gPlayerCount = 0;
    }

    public Team(String teamNameIn) {
        this.gTeamName = teamNameIn;
    }

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

    public String[] getPlayers() {
        if (this.gPlayerCount <= DEFAULT_PLAYER_LIMIT) {
            this.gPlayers = Arrays.copyOfRange(gPlayers, 0, gPlayerCount);
        } 
        return this.gPlayers;
    }

    public int getPlayerCount() {
        return this.gPlayerCount;
    }

    public void setPlayerCount(int playerCountIn) {
        this.gPlayerCount = playerCountIn;
    }

    public String getTeamName() {
        return this.gTeamName;
    }

    public void setTeamName(String teamNameIn) {
        this.gTeamName = teamNameIn;
    }




}
