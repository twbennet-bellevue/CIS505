import java.util.ArrayList;
import java.util.List;

public class Instructor {
    private String instructorName;
    private String contactNumber;
    private String contactEmail;
    private String imageUrl;
    private String className;
    private String classList;

    public Instructor(String instructorName, String className, String contactNumber, String contactEmail, String imageUrl, String classList) {
        this.instructorName = instructorName;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
        this.imageUrl = imageUrl;
        this.classList = classList;
        this.className = className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public void setClassList(String classList) {
        this.classList = classList;
    }

    public List<String> getClassList() {
        List<String> tempClassList = new ArrayList<String>();
        
        String[] list = classList.split(";");

        for (String item : list) {
            tempClassList.add(item);
        }

        return tempClassList;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorName() {
        return this.instructorName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public String getImageUrl() {
        return imageUrl;

    }

}
