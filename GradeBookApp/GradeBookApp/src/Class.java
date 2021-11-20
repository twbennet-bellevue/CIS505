/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/
import java.util.List;

public class Class {

    private String className;
    private String instructorName;
    private String contactNumber;
    private String contactEmail;

    private List<Student> students;

    /**
     * Four argument constructor
     * @param className String
     * @param instructorName String
     * @param contactNumber String
     * @param contactEmail String
     */
    public Class(String className, String instructorName, String contactNumber, String contactEmail) {
        this.className = className;
        this.instructorName = instructorName;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
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
     * Sets the instructor name
     * @param instructorName String
     */
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    /**
     * Gets the instructor name
     * @return String
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
     * @return String
     */
    public String getContactNumber() {
        return this.contactNumber;
    }

    /**
     * Sets the contact email
     * @param contactEmail String
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * Gets the contact Email
     * @return String
     */
    public String getContactEmail() {
        return this.contactEmail;
    }

    /**
     * Adds a student
     * @param student Student
     */
    public void addStudents(Student student) {
        students.add(student);
    }

    /**
     * Get a list of students
     * @return List<Student>
     */
    public List<Student> getStudents() {
        return this.students;
    }
    
}
