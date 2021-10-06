/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

package Module_6;

import java.util.ArrayList;
import java.util.List;

public class MemComposerDao implements ComposerDao {

    //private global class variables
    private List<Composer> composers = new ArrayList<Composer>();

    /**
     * Default Constructor
     */
    public MemComposerDao() {
    
        composers.add(new Composer(1007, "Ludwig Van Beethoven", "Classical"));
        composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
        composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(1010, "Johannes Brahms", "Classical"));
        composers.add(new Composer(1011, "Joseph Haydn", "Classical"));
    }

    /**
     * Finds All Composers
     * @return List<Composer>
     */
    @Override
    public List<Composer> findAll() {
        return composers;
    }

    /**
     * Finds the Composer by Integer primitive.
     * @param id Integer
     * @return Composer
     */
    @Override
    public Composer findBy(Integer id) {
        for (Composer composer : this.composers) {
            if (composer.getId() == id.intValue()) {
                return composer;
            }
        }
        
        return null;
    }

    /**
     * Inserts a Composer
     * @param composer Composer
     */
    @Override
    public void insert(Composer composer) {
        try {
            Composer composerToInsert = findBy(composer.getId());
            if (composerToInsert == null) {
                composers.add(composer);
            } else {
                System.out.println(StringFormatting.MESSAGE_SPACING + "Composer already exists");
            }
            
        } catch (NullPointerException np) {
            
        }
        
    }

}
