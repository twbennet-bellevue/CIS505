import java.util.List;

public class Class {

    private String className;
    private String instructorName;
    private String contactNumber;
    private String contactEmail;

    private List<Student> students;

    public Class(String className, String instructorName, String contactNumber, String contactEmail) {
        this.className = className;
        this.instructorName = instructorName;
        this.contactNumber = contactNumber;
        this.contactEmail = contactEmail;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
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

    public void addStudents(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return this.students;
    }
    
}
