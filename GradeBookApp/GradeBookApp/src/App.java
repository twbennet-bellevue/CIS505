/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Locale.Category;
import java.util.function.IntBinaryOperator;

import javafx.application.Application;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

    Button viewGradeBook = new Button("View GradeBook");
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
    

    @Override
    public void start(Stage primaryStage){

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
                border.setCenter(buildStudentRecordBody());
    
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
                border.setCenter(buildReportSelected());
    
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

    public BorderPane buildReportSelected() {
        BorderPane bp = new BorderPane();
        String twoPointZero = "2.0";
        String threePointZero = "3.0";
        String fourPointZero = "4.0";
        final NumberAxis xAxis = new NumberAxis(0, 4, .5);
        final NumberAxis yAxis = new NumberAxis(0, 20, 1);        
        final ScatterChart<Number,Number> sc = new ScatterChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("GPA (Standard 4.0 Scale)");                
        yAxis.setLabel("Returns to date");
        sc.setTitle("GPA Scatter Chart by Class");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("CIS501-1");
        series1.getData().add(new XYChart.Data(4.0, 4.0));
        series1.getData().add(new XYChart.Data(2.8, 2.8));
        series1.getData().add(new XYChart.Data(6.2, 24.8));
        series1.getData().add(new XYChart.Data(1, 14));
        series1.getData().add(new XYChart.Data(1.2, 26.4));
        series1.getData().add(new XYChart.Data(3.4, 3));
        series1.getData().add(new XYChart.Data(2.9, 3));
        series1.getData().add(new XYChart.Data(3.5, 1));
        series1.getData().add(new XYChart.Data(3.6, 7));
        series1.getData().add(new XYChart.Data(3.2, 12));

        sc.getData().addAll(series1);
        
        xAxis.setLabel("GPA");       
        yAxis.setLabel("Value");

        bp.setCenter(sc);

        return bp;
    }

    

    public BorderPane buildStudentPage() {
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

    

    public BorderPane openStudentSelectedForm() {
        Label lblStudentName = new Label("Student Name: ");
        Label lblStudentNameData = new Label("John Doe");
        Label lblContactNum = new Label("Contact #: ");
        Label lblContactNumData = new Label("000-000-0000");
        Label lblProgramName = new Label("Program");
        Label lblProgramNameData = new Label("Master of Science");
        Label lblEditInfo = new Label("Edit Info");
        Label lblClass = new Label("Class: " );
        Button btnEditInfo = new Button("Edit Class");
        Label lblContactEmail = new Label("Contact Email: ");
        Label lblContactEmailData = new Label("john_doe@someuniversity.edu");

        BorderPane classHeader = new BorderPane();
        InputStream stream = null;
        try {
            stream = new FileInputStream("C:\\Bellevue-Development\\CIS505\\GradeBookApp\\images\\person-icon.png");
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
        //bp.setCenter(buildClassBody());
        bp.setCenter(buildStudentClassBody());
        //bp.setCenter(vbox);

        return bp;
    }

    /*public HBox buildGradeBookBody() {

    }*/

    public HBox buildStudentClassBody() {
        HBox bodyView = new HBox();

        bodyView = new HBox(buildStudentClassList(), buildStudentClassResults());
        return bodyView;
    }

    public VBox buildStudentClassResults() {
        VBox classList = new VBox();

        ListView listClassResults = new ListView();

        Label classes = new Label("CIS505-1 - Class Statistics:");

 
        listClassResults.getItems().add("Class GPA (Average): 3.222");
        listClassResults.getItems().add("Class GPA (High): 4.0");
        listClassResults.getItems().add("Class GPA (Low): 2.8");
        listClassResults.setFocusTraversable(false);
        listClassResults.setMouseTransparent(true);


        classList = new VBox(classes, listClassResults);

        return classList;
    }

    public VBox buildStudentClassList() {
        VBox classList = new VBox();

        ListView listClasses = new ListView();

        Label classes = new Label("Classes:");

 
        listClasses.getItems().add("CIS501-1");
        listClasses.getItems().add("CIS515-2");
        listClasses.getItems().add("CIS614-1");
        listClasses.getItems().add("CIS505-2");
        listClasses.getSelectionModel().select(0);

        classList = new VBox(classes, listClasses);

        return classList;

    }

    public BorderPane buildClassInstancePage() {
        Label lblInstructorName = new Label("Instructor Name: ");
        Label lblInstructorNameData = new Label("Ben Affleck");
        Label lblContactNum = new Label("Contact #: ");
        Label lblContactNumData = new Label("000-000-0000");
        Label lblProgramName = new Label("Program");
        Label lblProgramNameData = new Label("Master of Science");
        Label lblEditInfo = new Label("Edit Info");
        Label lblClass = new Label("Class: " );
        Button btnEditInfo = new Button("Edit Class");
        Label lblContactEmail = new Label("Contact Email: ");
        Label lblContactEmailData = new Label("ben_affleck@someuniversity.edu");
        Label lblClassInfo = new Label(classSelected);

        BorderPane classHeader = new BorderPane();
        InputStream stream = null;
        try {
            stream = new FileInputStream("C:\\Bellevue-Development\\CIS505\\GradeBookApp\\images\\ben_affleck.jpg");
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
        bp.setCenter(buildClassBody());
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

    public VBox buildStudentRecordBody() {
        
        //classBody = new HBox(buildAllStudents(), btnOpenStudentRecord);
        //classBody.setPadding(new Insets(15, 12, 15, 12));
        VBox reportVBox = centerPage(titleBar("Student Record Form"), openStudentSelectedForm());
        return reportVBox;
    }
    

    public VBox buildAllStudents() {
        VBox resultsView = new VBox();
        listStudents = new ListView();

        Label students = new Label("Students:");

 
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
        listStudents.getItems().add("Test-Student15");

        listStudents.getSelectionModel().select(0);

        resultsView = new VBox(students, listStudents);

        return resultsView;
    }

    public HBox buildClassBody() {
        HBox classBody = new HBox();
        classBody = new HBox(buildClassStudents());

        return classBody;
    }

    public VBox buildClassStudents() {
        VBox resultsView = new VBox();
        listStudents = new ListView();

        Label students = new Label("Students:");

 
        listStudents.getItems().add("Test-Student1");
        listStudents.getItems().add("Test-Student2");
        listStudents.getItems().add("Test-Student3");
        listStudents.getItems().add("Test-Student4");
        listStudents.getItems().add("Test-Student5");
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


        title.setPadding(new Insets(15, 300, 15, 12));

        //btnListOpen.setPadding(new Insets(12, 12, 12, 12));
        btnOpenReport.setPadding(new Insets(12,12,12,12));

        hBox.getChildren().addAll(title, btnOpenReport);

        reportView.getItems().add("Student Eligibility by (Class)");
        reportView.getItems().add("Student Eligibility by (Student)");
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

        listClasses.getItems().add("CIS505-1");
        listClasses.getItems().add("CIS505-2");
        listClasses.getItems().add("CIS530-1");
        listClasses.getItems().add("CIS530-2");
        listClasses.getItems().add("CIS614-1");

        listClasses.getSelectionModel().select(0);

        VBox vbox = new VBox(listClasses);

        BorderPane bp = new BorderPane();
        bp.setTop(hBox);
        bp.setCenter(vbox);


        return bp;
    }

    public BorderPane buildGradeBookViewPage() {
        BorderPane bp = new BorderPane();
        HBox hbButtons = new HBox();
        Label gradeBookTitle = new Label(classSelected);

        hbButtons = new HBox(viewGradeBook, addGrade, editGrade, saveGrade);
        bp.setTop(gradeBookTitle);
        bp.setCenter(hbButtons);

        return bp;

    }

    public BorderPane buildClassPage() {
        listClasses = new ListView();
        HBox hBox = new HBox();

        Label title = new Label("Classes");


        title.setPadding(new Insets(15, 300, 15, 12));

        btnListOpen.setPadding(new Insets(12, 12, 12, 12));

        hBox.getChildren().addAll(title, btnListOpen);

        listClasses.getItems().add("CIS505-1");
        listClasses.getItems().add("CIS505-2");
        listClasses.getItems().add("CIS530-1");
        listClasses.getItems().add("CIS530-2");
        listClasses.getItems().add("CIS614-1");
        listClasses.getSelectionModel().select(0);

        VBox vbox = new VBox(listClasses);

        BorderPane bp = new BorderPane();
        bp.setTop(hBox);
        bp.setCenter(vbox);


        return bp;
    }
    
    public VBox openStudentForm() {

        VBox studentVBox = centerPage(titleBar("Student Form"), buildStudentPage());
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

    public VBox openClassesForm() {
        VBox classVBox = centerPage(titleBar("Class Form"), buildClassPage());
        return classVBox;
    }

    public VBox openGradeBookViewForm() {
        VBox classVBox = centerPage(titleBar("GradeBook View Form"), buildGradeBookViewPage());
        return classVBox;
    }

    public VBox openClassInstanceForm() {
        VBox classVBox = centerPage(titleBar("Class " + classSelected), buildClassInstancePage());
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
