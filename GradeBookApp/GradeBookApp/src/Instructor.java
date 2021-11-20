/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

import java.util.ArrayList;
import java.util.List;

public class Instructor {
    private String instructorName;
    private String contactNumber;
    private String contactEmail;
    private String imageUrl;
    private String className;
    private String classList;

    /**
     * Six parameter constructor
     * @param instructorName String
     * @param className String
     * @param contactNumber String
     * @param contactEmail String
     * @param imageUrl String
     * @param classList String
     */
    public Instructor(String instructorName, String className, String contactNumber, String contactEmail, String imageUrl, String classList) {
        this.instructorName = instructorName;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
        this.imageUrl = imageUrl;
        this.classList = classList;
        this.className = className;
    }

    /**
     * Sets the class name
     * @param className String
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Gets the class name
     * @return String
     */
    public String getClassName() {
        return this.className;
    }

    /**
     * Sets the class List
     * @param classList String
     */
    public void setClassList(String classList) {
        this.classList = classList;
    }

    /**
     * Gets the class list
     * @return List<String>
     */
    public List<String> getClassList() {
        List<String> tempClassList = new ArrayList<String>();
        
        String[] list = classList.split(";");

        for (String item : list) {
            tempClassList.add(item);
        }

        return tempClassList;
    }

    /**
     * Sets the instructor name
     * @param instructorName String
     */
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    /**
     * Gets the instructor name
     * @return String instructor name
     */
    public String getInstructorName() {
        return this.instructorName;
    }

    /**
     * Sets the contact number
     * @param contactNumber String
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Gets the contact number
     * @return String contact number
     */
    public String getContactNumber() {
        return this.contactNumber;
    }

    /**
     * Sets the contact number
     * @param contactEmail String
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * Gets the contact email
     * @return String
     */
    public String getContactEmail() {
        return this.contactEmail;
    }

    /**
     * Sets the image url
     * @param imageUrl String
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    /**
     * Gets the image url
     * @return String
     */
    public String getImageUrl() {
        return imageUrl;

    }

}
