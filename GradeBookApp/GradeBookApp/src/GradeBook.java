/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

public class GradeBook {

    /**
     * Saves the single grade
     * @param className String
     * @param firstName String
     * @param lastName String
     * @param assignment String
     * @param gpa String
     */
    public void SaveGrade(String className, String firstName, String lastName, String assignment, String gpa) {

        String filePath = "C:/data/gradebook.csv";
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();

        filePath = (path.toAbsolutePath() + "\\GradeBookApp\\data\\gradebook.csv");
        int count = 0;
        String result = "";
        if (count != 0) {
            result = (className + "," + firstName + "," + lastName + "," + assignment + "," + gpa);
        } else {
            result = ("\n" + className + "," + firstName + "," + lastName + "," + assignment + "," + gpa);
        }
         count++;

        try
        {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            fileWriter.write(result);

            // Always close files.
            bufferedWriter.close();

            }
            catch(IOException ex) {
                System.out.println("Error writing to file '"+ filePath + "'");}

    }


    /**
     * Saves a collection of grades
     * @param gradesIn List<Grade>
     */
    public void SaveGrades(List<Grade> gradesIn) {
        String filePath = "C:/data/gradebook.csv";
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();

        filePath = (path.toAbsolutePath() + "\\GradeBookApp\\data\\gradebook.csv");

        try {
            FileWriter fileWriter = new FileWriter(filePath, false);
            String result = "";

            System.out.println("pre-result");
            fileWriter.write(result);
            fileWriter.close();
            System.out.println("post-result");

            FileWriter fileWriter2 = new FileWriter(filePath, true);
            //BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            int count = 0;
            for (Grade grade : gradesIn) {
                
                
                String[] studentArray = null;

                studentArray = grade.getStudentName().split(" ");
                System.out.println("first name " + studentArray[0]);
                System.out.println("last name " + studentArray[1]);

                if (count == 0) {
                    result = (grade.getClassName() + "," + studentArray[0] + "," + studentArray[1] + "," + grade.getAssignmentName() + "," + grade.getGrade());
                    //fileWriter.write(result);
                    
                    fileWriter2.write(result);
                    
                } else {
                    result = ("\n" + grade.getClassName() + "," + studentArray[0] + "," + studentArray[1] + "," + grade.getAssignmentName() + "," + grade.getGrade());
                    //fileWriter.write(result);
                    fileWriter2.write(result);
                    
                }
                
                ++count;
                //split name array
                
    
            }
            fileWriter2.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file '"+ filePath + "'");
        }



    }

}
