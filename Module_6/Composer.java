/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_6;

public class Composer {
    
    //private global class variables
    private int id;
    private String name;
    private String genre;

    /**
     * Default Constructor
     */
    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }

    /**
     * Three Argument Constructor
     * @param id int
     * @param name String
     * @param genre String
     */
    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre; 

    }

    /**
     * Sets the Composer Id
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the Composer Id
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the Composer Name
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the Composer Name
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the Composer Genre
     * @param genre String
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the Composer Genre
     * @return String
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Overrides super.toString() to output a custom Composer toString message.
     */
    @Override
    public String toString() {
        String result = StringFormatting.MESSAGE_SPACING + "Id: " + this.id + StringFormatting.NEW_LINE_SPACING +
                        StringFormatting.MESSAGE_SPACING + "Name: " + this.name + StringFormatting.NEW_LINE_SPACING +
                        StringFormatting.MESSAGE_SPACING + "Genre: " + this.genre;
        return result;
    }

}


