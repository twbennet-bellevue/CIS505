import java.util.List;

public class Student {
    
    private String studentName;
    private String contactNumber;
    private String contactEmail;
    private String imageUrl;

    public Student(String studentName, String contactNumber, String contactEmail, String imageUrl) {
        this.studentName = studentName;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
        this.imageUrl = imageUrl;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return this.studentName;
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
        //String replace = imageUrl.replaceAll("\\", "/");


        return imageUrl;

    }


}
