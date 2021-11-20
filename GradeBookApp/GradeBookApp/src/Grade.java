/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

public class Grade {

    private String className;
    private String assignmentName;
    private double grade;
    private String studentName;

    /**
     * Four argument constructor
     * @param className String
     * @param studentName String
     * @param assignmentName String
     * @param grade String
     */
    public Grade(String className, String studentName, String assignmentName, String grade) {
        this.className = className;
        this.studentName = studentName;
        this.assignmentName = assignmentName;
        this.grade = Double.parseDouble(grade);
    }

    /**
     * Sets the student name
     * @param studentName String
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Gets the student name
     * @return
     */
    public String getStudentName() {
        return this.studentName;
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
     * Sets the assignment name
     * @param assignmentName String
     */
    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    /**
     * Gets the assignment name
     * @return String
     */
    public String getAssignmentName() {
        return this.assignmentName;
    }

    /**
     * Set the assignment grade
     * @param grade double
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

    /**
     * Get the assignment grade
     * @return double
     */
    public double getGrade() {
        return this.grade;
    }

    /**
     * Grade toString
     * @param className String
     * @param assignmentName String
     * @param grade int
     */
    public Grade(String className, String assignmentName, int grade) {
        this.className = className;
        this.assignmentName = assignmentName;
        this.grade = grade;
    }
    
}
