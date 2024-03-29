/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClassBook {

    private List<Class> classBook = new ArrayList<Class>();
    private List<Student> studentList = new ArrayList<Student>();
    private List<Instructor> instructorList = new ArrayList<Instructor>();
    private List<String> students = new ArrayList<String>();
    private List<String> uniqueClasses = new ArrayList<String>();
    private List<Grade> gradeBook = new ArrayList<Grade>();

    public ClassBook() {

    }

    /**
     * Imports the class book
     */
    public void importClassBook() {

        String filePath = "C:/data/classbook.csv";
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        //System.out.println(path.toAbsolutePath() + "\\GradeBookApp\\data\\classbook.csv");
        //import csv, line by line
        filePath = (path.toAbsolutePath() + "\\GradeBookApp\\data\\classbook.csv");

        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
 
            String line = "";
            while ((line = br.readLine()) != null) 
            {
               String[] instructorArray = line.split(",");

               String tempImagePath = path.toAbsolutePath() + "\\GradebookApp\\" + instructorArray[5];

               Instructor tempInstructors = new Instructor(instructorArray[0] + " " + instructorArray[1], instructorArray[2], instructorArray[3], instructorArray[4], tempImagePath, instructorArray[6]);
               instructorList.add(tempInstructors);
               System.out.println("Instructor List " + tempInstructors.getContactEmail());
            }
            br.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    /**
     * Imports the gradebook
     */
    public void importGradeBook() {

        String filePath = "C:/data/gradebook.csv";

        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        //System.out.println(path.toAbsolutePath() + "\\GradeBookApp\\data\\classbook.csv");
        //import csv, line by line
        filePath = (path.toAbsolutePath() + "\\GradeBookApp\\data\\gradebook.csv");

        //import csv, line by line
        gradeBook = new ArrayList<Grade>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
 
            int count = 0;
            String line = "";
            while ((line = br.readLine()) != null) 
            {
               //if (count != 0) {
                String[] gradeArray = line.split(",");

                Grade tempGrade = new Grade(gradeArray[0], gradeArray[1] + " " + gradeArray[2], gradeArray[3], gradeArray[4]);
                //System.out.println("grade: " + tempGrade.getGrade());
                gradeBook.add(tempGrade);
                //System.out.println("Grade List " + tempGrade.getAssignmentName());
               //}

               //count++;

            }
            br.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    /**
     * Removes the class assignments from the listing by course
     * @param course String
     * @return List<Grade>
     */
    public List<Grade> removeClassAssignments(String course) {
        List<Grade> gradeBookTemp = new ArrayList<Grade>();

        for (Grade grades: gradeBook) {
            if (!grades.getClassName().equals(course)) {
                gradeBookTemp.add(grades);
                System.out.println("out: " + grades.getClassName());
            }

        }

        gradeBook = gradeBookTemp;

        return gradeBookTemp;

    }

    /**
     * Gets the Class Assignments by course
     * @param course String
     * @return List<String>
     */
    public List<String> getClassAssignments(String course) {
        List<String> assignments = new ArrayList<String>();

        importGradeBook();

        double count = 0;
        int counter = 0;
        //System.out.println("Course: " + course);
        for (Grade grades: gradeBook) {
            //System.out.println("Gradebook : " + grades.getStudentName());

            if (grades.getClassName().equals(course)) {
                //System.out.println("Stud: " + student + " " + "course " + course + " Grade: " + grades.getGrade());
                System.out.println(grades.getClassName() + grades.getAssignmentName());
                assignments.add("Class Name: " + grades.getClassName() + " | " + "Student: " + grades.getStudentName() + " | Assignment Name: " +  grades.getAssignmentName() + " | " + "Grade: " + grades.getGrade());
                ++counter;

                //return grades.getGrade();
            }
        }

        if (counter == 0) {
            assignments.add("No grades");
            return assignments;
        }
        
       
        return assignments;
    }

    
    /**
     * Gets the Student Assignments by student
     * @param student String
     * @return List<String>
     */
    public List<String> getStudentAssignments(String student) {
        List<String> assignments = new ArrayList<String>();

        

        double count = 0;
        int counter = 0;
        //System.out.println("Course: " + course);
        for (Grade grades: gradeBook) {
            //System.out.println("Gradebook : " + grades.getStudentName());

            if (grades.getStudentName().equals(student)) {
                //System.out.println("Stud: " + student + " " + "course " + course + " Grade: " + grades.getGrade());
                assignments.add(grades.getClassName() + " | " + grades.getAssignmentName() + " | " + "Grade: " + grades.getGrade());
                ++counter;

                //return grades.getGrade();
            }
        }

        if (counter == 0) {
            assignments.add("No grades");
            return assignments;
        }
        
       
        return assignments;
    }

    /**
     * Gets the student GPA by course and student
     * @param student String
     * @param course String
     * @return double
     */
    public double getStudentGPACourse(String student, String course) {
        double tempGrade = -1.00;


        double count = 0;
        int counter = 0;
        System.out.println("Course: " + course);
        for (Grade grades: gradeBook) {
            //System.out.println("Gradebook : " + grades.getStudentName());

            if (grades.getStudentName().equals(student) && grades.getClassName().equals(course)) {
                System.out.println("Stud: " + student + " " + "course " + course + " Grade: " + grades.getGrade());
               // System.out.println(grades.getGrade());
                count += grades.getGrade();
                ++counter;

                //return grades.getGrade();
            }
        }

        if (counter == 0) {
            return tempGrade;
        }
        
       
        return count/counter;
    }

    /**
     * Gets the list of students
     * @return List<String>
     */
    public List<String> getStudents() {

        for (Student var : studentList) {
            students.add(var.getStudentName());
        }

        return students;
    }

    /**
     * Gets the students by course
     * @param course String
     * @return List<String>
     */
    public List<String> getStudentsByCourse(String course) {
        List<String> courses = new ArrayList<String>();

        for (Instructor tempInstructor : instructorList) {
            if (tempInstructor.getClassName().equals(course)) {
                return tempInstructor.getClassList();
            }

        }

        return null;
    }

    /**
     * Import the students 
     */
    public void importStudents() {
        String filePath = "C:/data/students.csv";

        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        filePath = (path.toAbsolutePath() + "\\GradeBookApp\\data\\students.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
 
            String line = "";
            while ((line = br.readLine()) != null) 
            {
               String[] studentArray = line.split(",");

               String tempStudentPath = path.toAbsolutePath() + "\\GradeBookApp\\" + studentArray[4];
               Student tempStudents = new Student(studentArray[0] + " " + studentArray[1], studentArray[2], studentArray[3], tempStudentPath);
               studentList.add(tempStudents);
               System.out.println(tempStudents.getContactEmail());
            }
            br.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Sets the class
     * @param classIn Class
     */
    public void setClassBook(Class classIn) {
        classBook.add(classIn);
    }

    /**
     * Finds all classes
     * @return List<String>
     */
    public List<String> findAllClasses() {
        System.out.println("Finding Classes");
        uniqueClasses = new ArrayList<String>();
        //List<String> outputClasses = new ArrayList<String>();

        //Loop through the instructor array and find classes
        for (Instructor tempInstructor : instructorList) {
            uniqueClasses.add(tempInstructor.getClassName());
        }

        return uniqueClasses;
    }

    /**
     * Finds all classes by students
     * @param studentName String
     * @return List<String>
     */
    public List<String> findStudentClasses(String studentName) {
        System.out.println("Finding instructors");
        List<String> outputClasses = new ArrayList<String>();

        //Loop through the instructor array and find the student
        for (Instructor tempInstructor : instructorList) {
            for (String tempClass : tempInstructor.getClassList()) {
                if (tempClass.equals(studentName)) {
                    outputClasses.add(tempInstructor.getClassName());
                }
            }
        }

        return outputClasses;
    }

    /**
     * Find a student object based on the student name
     */
    public Student findStudent(String studentName) {


        //find the student and return it
        for (Student temp : studentList) {
            String tempStudent = temp.getStudentName();

            if (tempStudent.equals(studentName)) {
                return temp;
            }


        }

        return null;


    }

    /**
     * Find the grades for a course based on the course name
     * @param course String
     * @return List<Grade>
     */
    public List<Grade> findGradesForClass(String course) {
        List<Grade> temp = new ArrayList<Grade>();

        for (Grade tempGrade : gradeBook) {
            if (tempGrade.getClassName().equals(course)) {
                temp.add(tempGrade);
            }
            
        }
        
        return temp;
    }

    /**
     * Find the instructor for a course
     * @param className String
     * @return Instructor
     */
    public Instructor findInstructor(String className) {


        //find the student and return it
        for (Instructor temp : instructorList) {
            String tempInstructor = temp.getClassName();

            if (tempInstructor.equals(className)) {
                return temp;
            }

        }

        return null;

    }    

}
