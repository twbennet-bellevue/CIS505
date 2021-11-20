/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/
import java.util.List;

public class Student {
    
    private String studentName;
    private String contactNumber;
    private String contactEmail;
    private String imageUrl;

    /**
     * Default Constructor
     * @param studentName String
     * @param contactNumber String
     * @param contactEmail String
     * @param imageUrl String
     */
    public Student(String studentName, String contactNumber, String contactEmail, String imageUrl) {
        this.studentName = studentName;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
        this.imageUrl = imageUrl;
    }

    /**
     * Sets the student name
     * @param studentName String
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Gets the student Name
     * @return String student name
     */
    public String getStudentName() {
        return this.studentName;
    }

    /**
     * Sets the Student contact Number
     * @param contactNumber String
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Gets the Student Contact Number
     * @return String number
     */
    public String getContactNumber() {
        return this.contactNumber;
    }

    /**
     * Sets the student email
     * @param contactEmail String
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * Gets the Student Contact Email
     * @return String email
     */
    public String getContactEmail() {
        return this.contactEmail;
    }

    /**
     * Gets the Image Url for a student
     * @param imageUrl String
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    /**
     * Sets the Student Image Url
     * @return String url
     */
    public String getImageUrl() {
        return imageUrl;

    }


}
