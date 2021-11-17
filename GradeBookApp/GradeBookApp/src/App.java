/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.function.IntBinaryOperator;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class App extends Application {
    private GridPane gridPane = new GridPane();
    private Button btnStudents = new Button("Students");
    private Button btnClasses = new Button("Classes");
    private Button btnReports = new Button("Reports");
    private Button btnListOpen = new Button("Open Class");
    private Button btnBackClasses = new Button("Back");
    private Button btnOpenReport = new Button("Open Report");
    private Button btnOpenStudentRecord = new Button("Open Student Record");
    private Button btnBackStudents = new Button("Back");
    private Button btnGradeBook = new Button("GradeBook");
    private Button btnGradeBookOpen = new Button("Open Gradebook");

    //Button btnViewGradeBook = new Button("View GradeBook");
    Button addGrade = new Button("Add Grade");
    Button editGrade = new Button("Edit Grade");
    Button saveGrade = new Button("Save Grade");

    private String classSelected = "";
    private String reportSelected = "";
    private String studentSelected = "";

    private ListView listClasses = new ListView();
    private ListView listStudents = new ListView();

    private Label lblProgramTitle = new Label("Student Performance Tracker App");
    private Label lblBodyMain = new Label("Main Screen");
    private Label lblBodyMainDescription = new Label("Welcome to the Student Performance Tracker App");
    private Label lblBodyMainDescriptionOptions = new Label("Select a navigation option on the left menu to view one of the following options:");
    private Label lblBodyOption1 = new Label("-Students");
    private Label lblBodyOption2 = new Label("-Classes");
    private Label lblBodyOption3 = new Label("-Reports");
    private Label classes = new Label("Stats");
    private Label gradeBookTitle = new Label ("");
    private Button saveButton = new Button("SAVE");

    private ComboBox student = new ComboBox();
    TextField textAssignment = new TextField("");

    private String studentLabel = "";
    private String assignmentLabel = "";
    private String classLabel = "";
    private String gpaLabel = "";

    private ComboBox comboBox = new ComboBox();
    ComboBox gpaCombo = new ComboBox();

    private ClassBook classBook = new ClassBook();
    private List<String> allStudents;

    private ListView listClassResults = new ListView();
    private ListView classGrades = new ListView();
    private BorderPane bp = new BorderPane();


    @Override
    public void start(Stage primaryStage){

        classBook.importClassBook();
        classBook.importStudents();
        classBook.importGradeBook();
        allStudents = classBook.getStudents();

        //build left grid
        //build main center page grid
        BorderPane border = new BorderPane();
        HBox hbox = addHBox(addVBoxNav());
        border.setLeft(hbox);
        hbox.setPrefWidth(150);

        VBox vboxMain = addVBoxMain();
        border.setCenter(vboxMain);
        vboxMain.setPrefWidth(500);
        //border.setLeft(addVBox());
        //addStackPane(hbox);         // Add stack to HBox in top region

       // border.setCenter(addGridPane());
        //border.setRight(addFlowPane());
        
        btnStudents.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                border.setCenter(null);
                border.setCenter(openStudentForm());
    
            }
        });

        btnReports.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                border.setCenter(null);
                border.setCenter(openReportsForm());
    
            }
        });

        btnBackStudents.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                border.setCenter(null);
                border.setCenter(openStudentForm());
    
            }
        });

        btnOpenStudentRecord.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                studentSelected = listStudents.getSelectionModel().getSelectedItem().toString();
                border.setCenter(null);
                border.setCenter(buildStudentRecordBody(studentSelected));
    
            }
        });

        btnClasses.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                border.setCenter(null);
                border.setCenter(openClassesForm());
    
            }
        });
        
        btnGradeBookOpen.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                border.setCenter(null);
                //border.setCenter();
                classSelected = listClasses.getSelectionModel().getSelectedItem().toString();
                border.setCenter(openGradeBookViewForm());
                //DO STUFF
    
            }
        });

        saveButton.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                classSelected = listClasses.getSelectionModel().getSelectedItem().toString();
                border.setCenter(null);
                //border.setCenter(openClassInstanceForm());
                //save the grade items
                GradeBook saveBookItem = new GradeBook();
                System.out.println("Targeted Student: " + student.getSelectionModel().getSelectedItem().toString());
                
                String[] name = student.getSelectionModel().getSelectedItem().toString().split("\\s+");
                String gpaResult = "";

                String gpaLabel = gpaCombo.getSelectionModel().getSelectedItem().toString();

                switch (gpaLabel) {
                    case "A": gpaResult = "1.0"; break;
                    case "A-": gpaResult = ".92"; break;
                    case "B+": gpaResult = ".89"; break;
                    case "B": gpaResult = ".85"; break;
                    case "B-": gpaResult = ".81"; break;
                    case "C+": gpaResult = ".78"; break;
                    case "C": gpaResult = ".75"; break;
                    case "C-": gpaResult = ".71"; break;
                    case "D": gpaResult = ".67"; break;
                    case "F": gpaResult = ".65"; break;
                }
                System.out.println("CIS501-1" + name[0] + name[1] + " | Assignment " + textAssignment.getText().toString() + " | GPA Label : " + gpaResult);
                //saveBookItem.SaveGrade(classLabel, name[0], name[1], assignmentLabel, gpaResult);
                //saveBookItem.SaveGrade("CIS501-1", "Tony", "Stark", "Test", ".85");
                saveBookItem.SaveGrade("CIS501-1", name[0], name[1], textAssignment.getText().toString(), gpaResult);

                border.setCenter(openGradeBookViewForm());
    
            }
        });


        btnListOpen.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                classSelected = listClasses.getSelectionModel().getSelectedItem().toString();
                border.setCenter(null);
                border.setCenter(openClassInstanceForm());
    
            }
        });

        btnOpenReport.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                //classSelected = listClasses.getSelectionModel().getSelectedItem().toString();
                border.setCenter(null);
                border.setCenter(buildReportSelected(comboBox.getSelectionModel().getSelectedItem().toString()));
    
            }
        });

        btnBackClasses.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                border.setCenter(null);
                border.setCenter(openClassesForm());
    
    
            }
        });

        btnGradeBook.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                border.setCenter(null);
                border.setCenter(openGradeBookForm());
                
    
            }
        });

        addGrade.setOnAction(new EventHandler<ActionEvent>(){
  
            @Override
            public void handle(ActionEvent event){
                border.setCenter(null);
                //border.setCenter();
                border.setCenter(openNewGradeForm());
    
            }
        });

        

        Scene scene = new Scene(border, 800, 600); // Builds the Scene

        primaryStage.setTitle("OpenEx Student Performance App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public VBox addVBoxNav() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        //vbox.setStyle("-fx-background-color: #336699;");
        lblProgramTitle.setPrefSize(200,60);
        lblProgramTitle.setTextAlignment(TextAlignment.JUSTIFY);
        lblProgramTitle.setWrapText(true);
        lblProgramTitle.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        lblProgramTitle.setTextFill(Color.WHITE);

        btnStudents.setPadding(new Insets(12, 12, 12, 12));
        btnReports.setPadding(new Insets(12, 12, 12, 12));
        btnClasses.setPadding(new Insets(12, 12, 12, 12));
        btnGradeBook.setPadding(new Insets(12, 12, 12, 12));


        btnStudents.setPrefSize(100, 20);
        btnReports.setPrefSize(100, 20);
        btnClasses.setPrefSize(100, 20);
        btnGradeBook.setPrefSize(100, 20);
        //vbox.getChildren().addAll(btnStudents, btnReports, btnClasses);
        vbox.getChildren().addAll(lblProgramTitle, btnStudents, btnReports, btnClasses, btnGradeBook);
        return vbox;
    }

    public HBox addHBox(VBox inHBox) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        

        //Button buttonCurrent = new Button("Current");
        //buttonCurrent.setPrefSize(100, 20);
    
        //Button buttonProjected = new Button("Projected");
        //buttonProjected.setPrefSize(100, 20);
        hbox.getChildren().addAll(inHBox);
    
        return hbox;
    }

    private HBox titleBar(String labelIn) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        Label label = new Label(labelIn);
        //Label label = new Label("Students");
        label.setPrefSize(200,50);
        label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        label.setTextFill(Color.WHITE);
        hbox.getChildren().addAll(label);
        return hbox;
    }

    private VBox centerPage(HBox inHBox, BorderPane inBP) {
        VBox vbox = new VBox();

        inHBox.setPadding(new Insets(15, 12, 15, 12));
        inHBox.setSpacing(10);

        inBP.setPadding(new Insets(15, 12, 15, 12));
        //inBP.setSpacing(10);
        vbox.getChildren().addAll(inHBox, inBP);
        return vbox;
    }

    private BorderPane addNewGrade() {

        BorderPane bpGrade = new BorderPane();
        VBox vbox = new VBox();



        HBox classBox = new HBox();
        HBox studentBox = new HBox();
        HBox gpaBox = new HBox();
        HBox assignmentBox = new HBox();

        HBox bottom = new HBox();


        Label labelStudentSelection = new Label("Select Student:");
        Label labelStudent = new Label("Select Student: ");
        Label gpaSelection = new Label("Select Letter Grade: ");
        Label assignmentName = new Label("Assignment Name: ");


        student = new ComboBox();
        for (String listStudents : classBook.getStudentsByCourse(gradeBookTitle.getText())) {
            student.getItems().add(listStudents);
        }
 
        gpaCombo = new ComboBox();

        gpaCombo.getItems().add("A");
        gpaCombo.getItems().add("A-");
        gpaCombo.getItems().add("B+");
        gpaCombo.getItems().add("B");
        gpaCombo.getItems().add("B-");
        gpaCombo.getItems().add("C+");
        gpaCombo.getItems().add("C");
        gpaCombo.getItems().add("C-");
        gpaCombo.getItems().add("D");
        gpaCombo.getItems().add("F");

        studentBox.getChildren().addAll(labelStudent, student);
        gpaBox.getChildren().addAll(gpaSelection, gpaCombo);
        bottom.getChildren().addAll(saveButton);
        assignmentBox.getChildren().addAll(assignmentName, textAssignment);

        vbox.getChildren().addAll(classBox,studentBox,gpaBox,assignmentBox,bottom);
        bp.setCenter(vbox);
        
        return bp;
    }

    public BorderPane buildReportSelected(String course) {
        BorderPane bp = new BorderPane();

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis(0, 1, .25);        
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        xAxis.setLabel("GPA (Standard 4.0 Scale)");                
        yAxis.setLabel("Returns to date");
        bc.setTitle("GPA Bar Chart by Class");

        //comboBox.getItems().add(classNames);
        //get gpa results studdent, by gpa
        List<Grade> tempGrades = classBook.findGradesForClass(course);

        XYChart.Series series1 = new XYChart.Series();

        series1.setName(course);

        for (Grade gradeList : tempGrades) {
            series1.getData().add(new XYChart.Data(gradeList.getStudentName(), gradeList.getGrade()));
        }

        //series1.getData().add(new XYChart.Data(4.0, 4.0));
        //series1.getData().add(new XYChart.Data(2.8, 2.8));
        //series1.getData().add(new XYChart.Data(6.2, 24.8));
        //series1.getData().add(new XYChart.Data(1, 14));
        //series1.getData().add(new XYChart.Data(1.2, 26.4));
        //series1.getData().add(new XYChart.Data(3.4, 3));
        //series1.getData().add(new XYChart.Data(2.9, 3));
        //series1.getData().add(new XYChart.Data(3.5, 1));
        ///series1.getData().add(new XYChart.Data(3.6, 7));
        //series1.getData().add(new XYChart.Data(3.2, 12));

        bc.getData().addAll(series1);
        
        xAxis.setLabel("Student");       
        yAxis.setLabel("GPA");

        bp.setCenter(bc);

        return bp;
    }

    

    public BorderPane buildStudentPage(String studentIn) {
        Label title = new Label("Students");
        BorderPane bp = new BorderPane();
        bp.setCenter(buildAllClassBody());
        return bp;
    }

    
    public BorderPane buildStudentRecordPage() {
        Label title = new Label("Student Record");
        BorderPane bp = new BorderPane();
        bp.setCenter(buildAllClassBody());
        return bp;
    }

    
    public BorderPane openStudentRecordPage() {
        Label title = new Label("Students");
        BorderPane bp = new BorderPane();
        bp.setCenter(buildAllClassBody());
        return bp;
    }

    

    public BorderPane openStudentSelectedForm(String studentName) {
        Student studentIn = classBook.findStudent(studentName);
        Label lblStudentName = new Label("Student Name: ");
        Label lblStudentNameData = new Label(studentIn.getStudentName());
        Label lblContactNum = new Label("Contact #: ");
        Label lblContactNumData = new Label(studentIn.getContactNumber());
        Label lblProgramName = new Label("Program");
        Label lblProgramNameData = new Label("Master of Science");
        Label lblEditInfo = new Label("Edit Info");
        Label lblClass = new Label("Class: " );
        Button btnEditInfo = new Button("Edit Class");
        Label lblContactEmail = new Label("Contact Email: ");
        Label lblContactEmailData = new Label(studentIn.getContactEmail());

        BorderPane classHeader = new BorderPane();
        InputStream stream = null;
        //classSelected = listClasses.getSelectionModel().getSelectedItem().toString();

        try {
            //stream = new FileInputStream("C:\\Bellevue-Development\\CIS505\\GradeBookApp\\images\\person-icon.png");
            stream = new FileInputStream(studentIn.getImageUrl());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        HBox classHeaderHBox = new HBox();
        HBox classLblBox = new HBox();
        HBox classLblContact = new HBox();
        HBox classLblEmail = new HBox();
        HBox classInstructorHBox = new HBox();

        lblClass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblContactNum.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblContactNumData.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        lblContactEmail.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblContactEmailData.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        lblStudentName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblStudentNameData.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        
        VBox centerBox = new VBox();
        VBox rightBox = new VBox();
        //classLblBox = new HBox(lblClass, lblClassInfo);
        classLblContact = new HBox(lblContactNum, lblContactNumData);
        classLblEmail = new HBox(lblContactEmail, lblContactEmailData);
        classInstructorHBox = new HBox(lblStudentName, lblStudentNameData);


        centerBox = new VBox(classLblBox, classInstructorHBox, classLblContact,classLblEmail);
        centerBox.setPadding(new Insets(12, 12, 12, 12));
        //rightBox.setPadding(new Insets(12, 12, 12, 12));
        //rightBox = new VBox(classInstructorHBox);
        classHeaderHBox = new HBox(centerBox);
        centerBox.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centerBox, Pos.CENTER);



        //Button back = new Button("Back");
        btnBackStudents.setPrefSize(100,20);
        btnEditInfo.setPrefSize(100,20);
        btnBackStudents.setPadding(new Insets(12, 12, 12, 12));

        Image img = new Image(stream);

        Circle circle = new Circle(100);
        ImagePattern pattern = new ImagePattern(img);
        circle.setFill(pattern);
        //System.out.println("Test:" + getClass().getResource("ben_affleck.jpg").toString());
        //images\ben_affleck.jpg
        ImageView image = new ImageView(img);
        //image.setX(10);
        //image.setY(10);

        HBox navigationStudentForm = new HBox();
        navigationStudentForm = new HBox(btnBackStudents);

        image.setFitWidth(175);
        image.setFitHeight(175);
        classHeader.setBottom(navigationStudentForm);
        classHeader.setLeft(circle);
        classHeader.setCenter(classHeaderHBox);
        //classHeader.setRight(rightBox);
        

        BorderPane.setMargin(btnBackStudents, new Insets(12,12,12,12));

        BorderPane bp = new BorderPane();
        bp.setTop(classHeader);

        List<String> listOfClasses = classBook.findStudentClasses(studentName);

        bp.setCenter(buildStudentClassBody(listOfClasses, studentSelected));
        //bp.setCenter(vbox);

        return bp;
    }

    /*public HBox buildGradeBookBody() {

    }*/

    public HBox buildGradeBookView(String course) {
        List<String> gradeBook = new ArrayList<String>();
        gradeBook = classBook.getClassAssignments(course);

        ListView view = new ListView();
        
        for (String element : gradeBook) {
            view.getItems().add(element);
            System.out.println("element: " + element);
        }

        HBox bodyView = new HBox(view);
        bodyView.setMaxWidth(800);
        view.setPrefWidth(800);
        //bodyView.setBackground(new Background(new BackgroundFill(Color.WHITE,CornerRadii.EMPTY,Insets.EMPTY)));
  
        return bodyView;
    }

    public HBox buildStudentClassBody(List<String> classes, String student) {
        HBox bodyView = new HBox();


        bodyView = new HBox(buildStudentClassList(classes, student), buildStudentClassGrades(student));
        return bodyView;
    }

    public VBox buildStudentClassResults(String course, String student) {
        VBox classList = new VBox();

        

        //Label classes = new Label("CIS505-1 - Class Statistics:");
        //import class statistic
        //setClassResults(course, student);

        listClassResults.setFocusTraversable(false);
        //listClassResults.setMouseTransparent(true);
        

        //double gpaResult = classBook.getStudentGPACourse(studentSelected, course);

        //listClassResults.getItems().add("Student Grade: " + gpaResult);
        //listClassResults.getItems().add("Class GPA (Average): 3.222");
        //listClassResults.getItems().add("Class GPA (High): 4.0");
        //listClassResults.getItems().add("Class GPA (Low): 2.8");

                
        /*listClasses.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {
                public void changed(ObservableValue<? extends String> observable, String oldvalue, String newValue) {
                    System.out.println("selection changed");
                    //buildStudentClassResults(listClasses.getSelectionModel().getSelectedItem().toString(), studentSelected);
                    
                    setClassResults(listClasses.getSelectionModel().getSelectedItem().toString(), studentSelected);
                    
            }
        });*/

        classList = new VBox(classes, listClassResults);

        return classList;
    }

    public void setClassResults(String course, String student) {
        /*System.out.println("Class Results changed");
        System.out.println("Student " + studentSelected + " - course " + course + " grade:" + classBook.getStudentGPACourse(studentSelected, course));
        classes.setText("Grades" + course);

        String gpaResultStr = "";*/

        /*if (gpaResult == -1.00) {
            gpaResultStr = "N/A";
        } else {
            gpaResultStr = "" + gpaResult;
        } 

        //listClassResults = new ListView();
        //listClassResultsIn.getSelectionModel().getSelectedItems().removeAll();
        //listClassResultsIn.refresh();*/

        //listClassResults.getSelectionModel().getSelectedItems().removeAll();
        //listClassResults.getItems().add("Student Grade: " + 0.0);
        //listClassResults.getItems().add("Class GPA (Average): 3.222");
        //listClassResults.getItems().add("Class GPA (High): 4.0");
        //listClassResults.getItems().add("Class GPA (Low): 2.8");
        //.refresh();
    }

    public VBox buildStudentClassGrades(String student) {
        VBox classList = new VBox();

        //import studentName

        classGrades = new ListView();

        Label classes = new Label("Grades:");


        List<String> listOfClasses = classBook.getStudentAssignments(student);

        for (String tempClass : listOfClasses) {

            
            classGrades.getItems().add(tempClass);

            
        }
 
        //listClasses.getItems().add("CIS501-1");
        //listClasses.getItems().add("CIS515-2");
        //listClasses.getItems().add("CIS614-1");
        //listClasses.getItems().add("CIS505-2");
        //listClasses.getSelectionModel().select(0);

 

        classList = new VBox(classes, classGrades);

        return classList;

    }

    public VBox buildStudentClassList(List<String> classListings, String student) {
        VBox classList = new VBox();

        //import studentName

        listClasses = new ListView();

        Label classes = new Label("Classes:");


        List<String> listOfClasses = classListings;

        for (String tempClass : listOfClasses) {

            
            double dataPoint = classBook.getStudentGPACourse(student, tempClass);
            if (dataPoint == -1.0) {
                listClasses.getItems().add(tempClass + " | GPA: " + "not available");
            } else {
                listClasses.getItems().add(tempClass + " | GPA: " + dataPoint);
            }

            
        }
 
        //listClasses.getItems().add("CIS501-1");
        //listClasses.getItems().add("CIS515-2");
        //listClasses.getItems().add("CIS614-1");
        //listClasses.getItems().add("CIS505-2");
        //listClasses.getSelectionModel().select(0);

 

        classList = new VBox(classes, listClasses);

        return classList;

    }

    public BorderPane buildClassInstancePage(String intructorName) {
        Instructor instructor = classBook.findInstructor(intructorName);

        Label lblInstructorName = new Label("Instructor Name: ");
        Label lblInstructorNameData = new Label(instructor.getInstructorName());
        Label lblContactNum = new Label("Contact #: ");
        Label lblContactNumData = new Label(instructor.getContactNumber());
        Label lblProgramName = new Label("Program");
        Label lblProgramNameData = new Label("Master of Science");
        Label lblEditInfo = new Label("Edit Info");
        Label lblClass = new Label("Class: " );
        Button btnEditInfo = new Button("Edit Class");
        Label lblContactEmail = new Label("Contact Email: ");
        Label lblContactEmailData = new Label(instructor.getContactEmail());
        Label lblClassInfo = new Label(classSelected);

        BorderPane classHeader = new BorderPane();
        InputStream stream = null;
        try {
            stream = new FileInputStream(instructor.getImageUrl());
            //stream = new FileInputStream("C:\\Bellevue-Development\\CIS505\\GradeBookApp\\images\\ben_affleck.jpg");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        HBox classHeaderHBox = new HBox();
        HBox classLblBox = new HBox();
        HBox classLblContact = new HBox();
        HBox classLblEmail = new HBox();
        HBox classInstructorHBox = new HBox();

        lblClass.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblClassInfo.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        lblContactNum.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblContactNumData.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        lblContactEmail.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblContactEmailData.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        lblInstructorName.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblInstructorNameData.setFont(Font.font("verdana", FontWeight.NORMAL, FontPosture.REGULAR, 12));
        
        VBox centerBox = new VBox();
        VBox rightBox = new VBox();
        classLblBox = new HBox(lblClass, lblClassInfo);
        classLblContact = new HBox(lblContactNum, lblContactNumData);
        classLblEmail = new HBox(lblContactEmail, lblContactEmailData);
        classInstructorHBox = new HBox(lblInstructorName, lblInstructorNameData);


        centerBox = new VBox(classLblBox, classInstructorHBox, classLblContact,classLblEmail);
        centerBox.setPadding(new Insets(12, 12, 12, 12));
        //rightBox.setPadding(new Insets(12, 12, 12, 12));
        //rightBox = new VBox(classInstructorHBox);
        classHeaderHBox = new HBox(centerBox);
        centerBox.setAlignment(Pos.CENTER);
        BorderPane.setAlignment(centerBox, Pos.CENTER);



        //Button back = new Button("Back");
        btnBackClasses.setPrefSize(100,20);
        btnEditInfo.setPrefSize(100,20);
        btnBackClasses.setPadding(new Insets(12, 12, 12, 12));

        Image img = new Image(stream);

        Circle circle = new Circle(100);
        ImagePattern pattern = new ImagePattern(img);
        circle.setFill(pattern);
        //System.out.println("Test:" + getClass().getResource("ben_affleck.jpg").toString());
        //images\ben_affleck.jpg
        ImageView image = new ImageView(img);
        //image.setX(10);
        //image.setY(10);
        image.setFitWidth(175);
        image.setFitHeight(175);
        classHeader.setBottom(btnBackClasses);
        classHeader.setLeft(circle);
        classHeader.setCenter(classHeaderHBox);
        //classHeader.setRight(rightBox);


        BorderPane.setMargin(btnBackClasses, new Insets(12,12,12,12));

        BorderPane bp = new BorderPane();
        bp.setTop(classHeader);
        bp.setCenter(buildClassBody(instructor));
        //bp.setCenter(vbox);

        return bp;
    }

    public BorderPane buildAllClassBody() {
        BorderPane classBody = new BorderPane();
        
        //classBody = new HBox(buildAllStudents(), btnOpenStudentRecord);
        //classBody.setPadding(new Insets(15, 12, 15, 12));
        classBody.setLeft(buildAllStudents());
        classBody.setCenter(btnOpenStudentRecord);
        return classBody;
    }

    public VBox buildStudentRecordBody(String student) {
        
        //classBody = new HBox(buildAllStudents(), btnOpenStudentRecord);
        //classBody.setPadding(new Insets(15, 12, 15, 12));
        
        VBox reportVBox = centerPage(titleBar("Student Record Form"), openStudentSelectedForm(student));
        return reportVBox;
    }
    

    public VBox buildAllStudents() {
        VBox resultsView = new VBox();
        listStudents = new ListView();

        Label students = new Label("Students:");

        for (String stud : allStudents) {
            listStudents.getItems().add(stud);
        }
        /*
        listStudents.getItems().add("Test-Student1");
        listStudents.getItems().add("Test-Student2");
        listStudents.getItems().add("Test-Student3");
        listStudents.getItems().add("Test-Student4");
        listStudents.getItems().add("Test-Student5");
        listStudents.getItems().add("Test-Student6");
        listStudents.getItems().add("Test-Student7");
        listStudents.getItems().add("Test-Student8");
        listStudents.getItems().add("Test-Student9");
        listStudents.getItems().add("Test-Student10");
        listStudents.getItems().add("Test-Student11");
        listStudents.getItems().add("Test-Student12");
        listStudents.getItems().add("Test-Student13");
        listStudents.getItems().add("Test-Student14");
        listStudents.getItems().add("Test-Student15");*/

        listStudents.getSelectionModel().select(0);

        resultsView = new VBox(students, listStudents);

        return resultsView;
    }

    public HBox buildClassBody(Instructor instructor) {
        HBox classBody = new HBox();
        classBody = new HBox(buildClassStudents(instructor));

        return classBody;
    }

    public VBox buildClassStudents(Instructor instructor) {
        VBox resultsView = new VBox();
        listStudents = new ListView();

        Label students = new Label("Students:");

        for (String student : instructor.getClassList()) {
            listStudents.getItems().add(student);
        }
 
        //listStudents.getItems().add("Test-Student1");
        //listStudents.getItems().add("Test-Student2");
        //listStudents.getItems().add("Test-Student3");
        //listStudents.getItems().add("Test-Student4");
        //listStudents.getItems().add("Test-Student5");
        listStudents.getSelectionModel().select(0);

        resultsView = new VBox(students, listStudents);

        return resultsView;
    }

    public VBox buildClassResults() {
        VBox resultsView = new VBox();
        Label results = new Label("Class Statistics:");
        ListView lvStats = new ListView();
        lvStats.getItems().add("Class GPA (Average): 3.222");
        lvStats.getItems().add("Class GPA (High): 4.0");
        lvStats.getItems().add("ClassGPA (Low): 2.8");
        lvStats.setFocusTraversable(false);
        lvStats.setMouseTransparent(true);
        resultsView = new VBox(results, lvStats);
        return resultsView;
    }

    public BorderPane buildReportPage() {
        ListView reportView = new ListView();
        HBox hBox = new HBox();

        Label title = new Label("Reports");
        comboBox = new ComboBox();

        for (String classNames : classBook.findAllClasses()) {
            comboBox.getItems().add(classNames);
        }
        title.setPrefWidth(200);
        comboBox.setPadding(new Insets(12,12,12,12));
        comboBox.setPrefWidth(200);
        title.setPadding(new Insets(12, 12, 12, 12));

        //btnListOpen.setPadding(new Insets(12, 12, 12, 12));
        btnOpenReport.setPadding(new Insets(12,12,12,12));
        btnOpenReport.setPrefWidth(200);

        hBox.getChildren().addAll(title,comboBox, btnOpenReport);

        //reportView.getItems().add("Student Eligibility by (Class)");
        //reportView.getItems().add("Student Eligibility by (Student)");
        reportView.getItems().add("GPA Report");
        reportView.getSelectionModel().select(0);

        VBox vbox = new VBox(reportView);

        BorderPane bp = new BorderPane();
        bp.setTop(hBox);
        bp.setCenter(vbox);


        return bp;
    }

    public BorderPane buildGradebookClassPage() {
        listClasses = new ListView();
        HBox hBox = new HBox();

        Label title = new Label("Classes");


        title.setPadding(new Insets(15, 300, 15, 12));


        btnListOpen.setPadding(new Insets(12, 12, 12, 12));

        hBox.getChildren().addAll(title, btnGradeBookOpen);

        for (String classListings : classBook.findAllClasses()) {
            listClasses.getItems().add(classListings);
        }
        //listClasses.getItems().add("CIS505-1");
        //listClasses.getItems().add("CIS505-2");
        //listClasses.getItems().add("CIS530-1");
        //listClasses.getItems().add("CIS530-2");
        //listClasses.getItems().add("CIS614-1");

        listClasses.getSelectionModel().select(0);

        VBox vbox = new VBox(listClasses);

        BorderPane bp = new BorderPane();
        bp.setTop(hBox);
        bp.setCenter(vbox);


        return bp;
    }

    public BorderPane buildGradeBookViewPage() {

        HBox hbButtons = new HBox();
        gradeBookTitle = new Label(classSelected);

        addGrade.setPadding(new Insets(12, 12, 12, 12));
        editGrade.setPadding(new Insets(12, 12, 12, 12));
        saveGrade.setPadding(new Insets(12, 12, 12, 12));
        editGrade.isDisabled();
        saveGrade.isDisabled();

        hbButtons = new HBox(addGrade, editGrade, saveGrade);
        bp.setTop(gradeBookTitle);
        bp.setBottom(hbButtons);
        System.out.println(classSelected);
       
        HBox centerScreenView = new HBox();
        centerScreenView.getChildren().add(buildGradeBookView(classSelected));
        centerScreenView.setAlignment(Pos.CENTER);

        classLabel = classSelected;

        HBox.setHgrow(centerScreenView, Priority.ALWAYS);
        bp.setPrefWidth(800);
        bp.setPrefSize(1000,600);
        centerScreenView.setPrefWidth(800);
        centerScreenView.setPrefSize(800,600);
       // centerScreenView.setPadding(new Insets(12,12,12,12));

        addGrade.setMaxWidth(200);
        editGrade.setMaxWidth(200);
        saveGrade.setMaxWidth(200);
        centerScreenView.setMaxWidth(800);
        //centerScreenView.setBackground(new Background(new BackgroundFill(Color.RED,CornerRadii.EMPTY,Insets.EMPTY)));
   
        HBox.setHgrow(addGrade, Priority.ALWAYS);
        HBox.setHgrow(editGrade, Priority.ALWAYS);
        HBox.setHgrow(saveGrade, Priority.ALWAYS);
        HBox.setHgrow(centerScreenView, Priority.ALWAYS);

        bp.setCenter(centerScreenView);
 

        return bp;

    }

    public BorderPane buildClassPage() {
        listClasses = new ListView();
        listClasses.getItems().removeAll();

        HBox hBox = new HBox();

        Label title = new Label("Classes");

        List<String> instructorClassList = classBook.findAllClasses();

        title.setPadding(new Insets(15, 300, 15, 12));

        btnListOpen.setPadding(new Insets(12, 12, 12, 12));

        hBox.getChildren().addAll(title, btnListOpen);

        for (String tempClassList : instructorClassList) {
            listClasses.getItems().add(tempClassList);
        }
        //listClasses.getItems().add("CIS505-1");
        //listClasses.getItems().add("CIS505-2");
        //listClasses.getItems().add("CIS530-1");
        //listClasses.getItems().add("CIS530-2");
        //listClasses.getItems().add("CIS614-1");
        listClasses.getSelectionModel().select(0);

        VBox vbox = new VBox(listClasses);

        BorderPane bp = new BorderPane();
        bp.setTop(hBox);
        bp.setCenter(vbox);


        return bp;
    }
    
    public VBox openStudentForm() {
        //EDIT ME

        VBox studentVBox = centerPage(titleBar("Student Form"), buildStudentPage("Tony Stark"));
        return studentVBox;
    }

    public VBox openStudentRecordForm() {

        VBox studentVBox = centerPage(titleBar("Student Record Form"), buildStudentRecordPage());
        return studentVBox;
    }

    public VBox openReportsForm() {
        VBox reportVBox = centerPage(titleBar("Report Form"), buildReportPage());
        return reportVBox;
    }

    public VBox openGradeBookForm() {
        VBox classVBox = centerPage(titleBar("Gradebook Form"), buildGradebookClassPage());
        return classVBox;
    }

    public VBox openNewGradeForm() {
        VBox classVBox = centerPage(titleBar("New Grade Form"), addNewGrade());
        return classVBox;
    }

    public VBox openClassesForm() {
        VBox classVBox = centerPage(titleBar("Class Form"), buildClassPage());
        return classVBox;
    }

    public VBox openGradeBookViewForm() {
        VBox classVBox = centerPage(titleBar("GradeBook View Form"), buildGradeBookViewPage());
        return classVBox;
    }

    public VBox openClassInstanceForm() {
        VBox classVBox = centerPage(titleBar("Class " + classSelected), buildClassInstancePage(classSelected));
        return classVBox;
    }

    public VBox addVBoxMain() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color: #999999;");
        lblBodyMain.setPrefSize(200,60);
        lblBodyMain.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        lblBodyMain.setTextFill(Color.BLACK);
        lblBodyMain.setPadding(new Insets(15, 12, 15, 12));
        //lblBodyMain.setAlignment(Pos.CENTER);
        lblBodyMain.setTextAlignment(TextAlignment.CENTER);
        vbox.setAlignment(Pos.BASELINE_LEFT);

        lblBodyMainDescription.setWrapText(true);
        lblBodyMainDescription.setPadding(new Insets(20, 0, 0, 0));
        lblBodyMainDescription.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblBodyMainDescription.setTextFill(Color.BLACK);

        lblBodyMainDescriptionOptions.setWrapText(true);
        lblBodyMainDescriptionOptions.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblBodyMainDescriptionOptions.setTextFill(Color.BLACK);

        lblBodyOption1.setWrapText(true);
        lblBodyOption1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblBodyOption1.setTextFill(Color.BLACK);
        lblBodyOption1.setTextAlignment(TextAlignment.LEFT);

        lblBodyOption2.setWrapText(true);
        lblBodyOption2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblBodyOption2.setTextFill(Color.BLACK);

        lblBodyOption3.setWrapText(true);
        lblBodyOption3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        lblBodyOption3.setTextFill(Color.BLACK);


        //vbox.getChildren().addAll(btnStudents, btnReports, btnClasses);
        vbox.getChildren().addAll(lblBodyMain, lblBodyMainDescription, lblBodyMainDescriptionOptions, lblBodyOption1, lblBodyOption2, lblBodyOption3);
        return vbox;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
