import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GradeBook {

    //read in the student list
    //read in the class list
    //read in the gradebook list


    public void SaveGrade(String className, String firstName, String lastName, String assignment, String gpa) {
        /*    private String studentLabel = "";
        private String assignmentLabel = "";
        private String classLabel = "";
        private String gpaLabel = "";*/
        String filePath = "C:/data/gradebook.csv";

        String result = ("\n" + className + "," + firstName + "," + lastName + "," + assignment + "," + gpa);

        try
        {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            fileWriter.write(result);
            //bufferedWriter.append('\n' + result);

            // Always close files.
            bufferedWriter.close();

            }
            catch(IOException ex) {
                System.out.println("Error writing to file '"+ filePath + "'");}

    }

}
