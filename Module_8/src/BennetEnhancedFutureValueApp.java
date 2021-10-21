/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BennetEnhancedFutureValueApp extends Application{

    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblYears = new Label("Years:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private Label lblFutureValueDate = new Label("");
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfInterestRate = new TextField();
    private TextArea taResult = new TextArea("");
    private ComboBox<Integer> cbYearsList = new ComboBox<Integer>();
    
    private Button btnCalculate = new Button("Calculate");
    private Button btnClear = new Button("Clear");
    private GridPane gridPane = new GridPane();

    @Override
    public void start(Stage primaryStage){

        Scene scene = new Scene(gridPane, 300, 250); // Builds the Scene

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gridPane.setHgap(5.5);
        gridPane.setVgap(5.5);

        gridPane.add(lblMonthlyPayment, 0, 0);
        GridPane.setHalignment(lblMonthlyPayment, HPos.LEFT);

        gridPane.add(tfMonthlyPayment, 1, 0);
        GridPane.setHalignment(tfMonthlyPayment, HPos.RIGHT);

        gridPane.add(lblInterestRate, 0, 1);
        GridPane.setHalignment(lblInterestRate, HPos.LEFT);

        gridPane.add(tfInterestRate, 1, 1);
        GridPane.setHalignment(tfInterestRate, HPos.RIGHT);

        gridPane.add(lblYears, 0, 3);
        GridPane.setHalignment(lblYears, HPos.LEFT);

        gridPane.add(cbYearsList, 1, 3);
        GridPane.setHalignment(cbYearsList, HPos.RIGHT);

        lblInterestRateFormat.setTextFill(Color.RED); // Set the font color of the interest rate instructions to red.
        gridPane.add(lblInterestRateFormat, 1, 2); //Add the label to the grid pane
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT); //Position the label to the right of the pane

        gridPane.add(lblFutureValueDate, 0,6);
        GridPane.setHalignment(lblFutureValueDate, HPos.LEFT);
        GridPane.setColumnSpan(lblFutureValueDate, 2);
        setCbYears(); // Sets the ComboBox Years with dates to choose.

        btnClear.setOnAction(new EventHandler<ActionEvent>(){
  
          @Override
          public void handle(ActionEvent event){
            clearFormFields();
          }
        });

        btnCalculate.setOnAction(new EventHandler<ActionEvent>(){
  
          @Override
          public void handle(ActionEvent event){
                calculateLoan();
  
          }
      });

  
      HBox actionBtnContainer = new HBox();
      actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
      actionBtnContainer.setSpacing(10);
      actionBtnContainer.getChildren().add(btnClear);
      actionBtnContainer.getChildren().add(btnCalculate);

      gridPane.add(actionBtnContainer, 1, 5);
  
      gridPane.add(taResult, 0, 7);
      GridPane.setColumnSpan(taResult, 2);
  
      primaryStage.setTitle("Future Value App");
      primaryStage.setScene(scene);
      primaryStage.show();
      
    }

    /**
     * Resets the form to empty values and selections.
     */
    private void clearFormFields() {
        tfMonthlyPayment.setText("");
        tfInterestRate.setText("");
        taResult.setText("");
        setCbYears();
    }

    /**
     * Calculates the Loan from the values the user enters
     * Triggers the updateCBText() method to update the ComboBox 
     */
    private void calculateLoan() {
        Double monthlyPayment = Double.valueOf(tfMonthlyPayment.getText());
        Double interestRate = Double.valueOf(tfInterestRate.getText());
        int years = Integer.valueOf(cbYearsList.getValue());

        
        double calculation = FinanceCalculator.calculateFutureValue(monthlyPayment, interestRate, years);

        updateTAText("The future value is " + String.format("$%,.2f%n", calculation)); // Sets the result to the Text Area.
        updateCalculationDate();
    }

    private void updateCalculationDate() {
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        
        lblFutureValueDate.setText("Calculation as of " + dateformatter.format(now));
    }

    /**
     * Updates the TextArea result box with the supplied string.
     * @param text String
     */
    private void updateTAText(String text) {
        

        if (taResult.getText() == "" || taResult.getText() == null) {
            taResult.setText(text);
        } else {
            taResult.setText(text);
        }
        
    }

    /**
     * Sets the ComboBox Years with available dates to select.
     */
    private void setCbYears() {
        for (int i = 0; i <= 90; i++) {
            cbYearsList.getItems().add(i);
        }
        cbYearsList.getSelectionModel().selectFirst();
    }
  
  public static void main(String[] args) {
          launch(args);
      }
  }