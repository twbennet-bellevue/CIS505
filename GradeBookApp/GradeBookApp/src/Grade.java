public class Grade {

    private String className;
    private String assignmentName;
    private double grade;
    private String studentName;

    public Grade(String className, String studentName, String assignmentName, String grade) {
        this.className = className;
        this.studentName = studentName;
        this.assignmentName = assignmentName;
        this.grade = Double.parseDouble(grade);
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentName() {
        return this.assignmentName;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return this.grade;
    }

    public Grade(String className, String assignmentName, int grade) {
        this.className = className;
        this.assignmentName = assignmentName;
        this.grade = grade;
    }
    
}
