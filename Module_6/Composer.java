package Module_6;

public class Composer {
    
    private int id = 0;
    private String name = "";
    private String genre = "";

    public Composer() {

    }

    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre; 

    }

    @Override
    public String toString() {
        String result = StringFormatting.MESSAGE_SPACING + "Id: " + this.id +
                        StringFormatting.MESSAGE_SPACING + "Name: " + this.name +
                        StringFormatting.MESSAGE_SPACING + "Genre: " + this.genre +
                        StringFormatting.NEW_LINE_SPACING;
        return result;
    }

}


