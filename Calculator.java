
import javafx.application.Application;
import java.io.IOException;
import java.io.FileInputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Region;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.text.DecimalFormat;

/*************************************************************************************************************
 * A calculator that will solve simple math problems for grade 4, 5 and 6
 * This is the main class
 *
 * @author (Anyanwu Benedict Chukwuemeka)
 * @version (ver 1)
 ************************************************************************************************************/
public class Calculator extends Application
{
    // Variable initialisation
    
    // Window Size
    private final int VERTWIN = 600;
    private final int HORIZWIN = 400;
    
    // Screen lines
    private Label inputLine = new Label("");
    private Label outputLine = new Label("");
    private Label errorLine = new Label("");
    
    // Toggle Group for grouping the grade math radio buttons
    private ToggleGroup mathGradeRadioGroup = new ToggleGroup();
    
    // Radio buttons
    private RadioButton grade4math = new RadioButton("Grade 4 MATH");
    private RadioButton grade5math = new RadioButton("Grade 5 MATH");
    private RadioButton grade6math = new RadioButton("Grade 6 MATH");
    
    // Buttons for the calculator
    
    // Numbers 0 - 9
    private Button button0 = new Button("0");
    private Button button1 = new Button("1");
    private Button button2 = new Button("2");
    private Button button3 = new Button("3");
    private Button button4 = new Button("4");
    private Button button5 = new Button("5");
    private Button button6 = new Button("6");
    private Button button7 = new Button("7");
    private Button button8 = new Button("8");
    private Button button9 = new Button("9");
        
    // Operator buttons
    private Button buttonAdd = new Button("+");
    private Button buttonMinus = new Button("-");
    private Button buttonMultiply = new Button("*");
    private Button buttonDivide = new Button("/");
    private Button buttonClear = new Button("C");
    private Button buttonSolve = new Button("=");

    /****************************************************************
     *  Start Method
     *  Creates the stage and initialises the calculator
     *****************************************************************/
    @Override
    public void start(Stage stage) throws Exception
    {
        // Create root pane - the root of the calculator
        Pane root = new Pane();
        
        // Creates primary base of calculator
        Pane main = new Pane();
        main.setId("main");
        
        // Adding a VBox to contain the primary components of the calculator
        VBox base = new VBox();
        base.setId("base");
        
        
        
        // BRANDING OF THE CALCULATOR
        
        // Brand Box
        HBox brandBox = new HBox();
        brandBox.setId("brandBox");
        
        // Brand Logo
        Pane brandLogo = new Pane();
        brandLogo.setId("brandLogo");
        
        // Brand Name
        VBox brandName = new VBox();
        brandName.setId("brandName");
        
        // Calculator Name
        Label calcName1 = new Label("FRANKENSTEIN SOLVES");
        calcName1.setId("calcName");
        
        Label calcName2 = new Label("fr-so99292 MATH GURL EDITION");
        calcName2.setId("version");
        
        // Creator Name
        Label creatorName1 = new Label("by ACBennny ");
        creatorName1.getStyleClass().add("creatorName");
        
         
        
        // DISPLAY OF THE CALCULATOR
        
        // Screen box
        VBox screenBox = new VBox();
        screenBox.getStyleClass().add("screenBox");
        
        // Input line to show user input
        inputLine.getStyleClass().add("ioLines");
        inputLine.setId("inputLine");
        
        // Output line to show user input
        outputLine.getStyleClass().add("ioLines");
        outputLine.setId("outputLine");
        
        // Error line to display error message
        errorLine.setId("errorLine");
        
        
        
        
        // GRADE MATH OF THE CALCULATOR
        
        // Box for the grade math radio buttons
        HBox mathGradeBox = new HBox();
        mathGradeBox.getStyleClass().add("mathGradeBox");
        
        // Grade math radio buttons
        grade4math.setToggleGroup(mathGradeRadioGroup);
        grade5math.setToggleGroup(mathGradeRadioGroup);
        grade6math.setToggleGroup(mathGradeRadioGroup);
        
        // grade 4 math button is selected by default
        grade4math.setSelected(true);
        
        
        
        // BUTTONS OF THE CALCULATOR
        
        // The button box - houses all the buttons
        GridPane calcButtonsBox = new GridPane();
        calcButtonsBox.getStyleClass().add("calcButtonsBox");
        
        // Id for Clear to button
        buttonClear.setId("buttonClear");
        
        // Id for Equals to button
        buttonSolve.setId("buttonSolve");
        
        // Add buttons to grid in buttonsBox
        calcButtonsBox.add(button0, 1, 3);
        calcButtonsBox.add(button1, 0, 0);
        calcButtonsBox.add(button2, 1, 0);
        calcButtonsBox.add(button3, 2, 0);
        calcButtonsBox.add(button4, 0, 1);
        calcButtonsBox.add(button5, 1, 1);
        calcButtonsBox.add(button6, 2, 1);
        calcButtonsBox.add(button7, 0, 2);
        calcButtonsBox.add(button8, 1, 2);
        calcButtonsBox.add(button9, 2, 2);
        calcButtonsBox.add(buttonAdd, 3, 1);
        calcButtonsBox.add(buttonMinus, 3, 2);
        calcButtonsBox.add(buttonMultiply, 0, 3);
        calcButtonsBox.add(buttonDivide, 2, 3);
        calcButtonsBox.add(buttonClear, 3, 0);
        calcButtonsBox.add(buttonSolve, 3, 3);
        
        // Adding eventlisteners to buttons
        button0.setOnAction(e -> inputToScreen(e));
        button1.setOnAction(e -> inputToScreen(e));
        button2.setOnAction(e -> inputToScreen(e));
        button3.setOnAction(e -> inputToScreen(e));
        button4.setOnAction(e -> inputToScreen(e));
        button5.setOnAction(e -> inputToScreen(e));
        button6.setOnAction(e -> inputToScreen(e));
        button7.setOnAction(e -> inputToScreen(e));
        button8.setOnAction(e -> inputToScreen(e));
        button9.setOnAction(e -> inputToScreen(e));
        buttonAdd.setOnAction(e -> inputToScreen(e));
        buttonMinus.setOnAction(e -> inputToScreen(e));
        buttonMultiply.setOnAction(e -> inputToScreen(e));
        buttonDivide.setOnAction(e -> inputToScreen(e));
        buttonClear.setOnAction(e -> clearTheScreen());
        buttonSolve.setOnAction(e -> solveOperation());
        
        
        
        // Adding all children in the hierarchy
        
        mathGradeBox.getChildren().addAll(grade4math,grade5math,grade6math);
        screenBox.getChildren().addAll(inputLine, outputLine, errorLine);
        brandName.getChildren().addAll(calcName1,calcName2,creatorName1);
        brandBox.getChildren().addAll(brandLogo,brandName);
        base.getChildren().addAll(brandBox,screenBox,mathGradeBox,calcButtonsBox);
        main.getChildren().addAll(base);
        root.getChildren().addAll(main);
        
        
        // Creating the Scene
        Scene theScene = new Scene(root, HORIZWIN,VERTWIN);
        
        // Linking the css stylesheet
        theScene.getStylesheets().add(getClass().getResource("calculator_style.css").toExternalForm());
        
        // Title of the pprogram
        stage.setTitle("Calculator by ACBennny");
        
        // Adding an icon of the application
        stage.getIcons().add(new Image(Calculator.class.getResourceAsStream("image/calcBrandLogo.gif")));
        
        // Preventing resizing of the window
        stage.setResizable(false);
        
        // Setting the scene
        stage.setScene(theScene);

        // Showing the Stage
        stage.show();
    }
    
    
    /************************************************************
     * name: inputToScreen
     * function: listens to mouse click events and displays 
     * the text of the button clicked
     * 
     ************************************************************/
     private void inputToScreen(ActionEvent event)
     {
         // check which button was clicked
         Button clickedButton = (Button) event.getSource();
         
         // Display text of buttin that was clicked
         String clickedButtonText = clickedButton.getText();
         
         // get the surrent text in the input line 
         String inputLineText = inputLine.getText();
         
         // Check if it is a number
         if(Character.isDigit(clickedButtonText.charAt(0)))
         {
             // Display it directly
             inputLine.setText(inputLineText + clickedButtonText);
         }
         // if it is not a number, that is an operator
         else
         {
             // Display while creating space between text
             inputLine.setText(inputLineText + " " + clickedButtonText + " ");
         }
     }
     
    /************************************************************
     * name: clearTheScreen
     * function: clears all text on the screen
     * 
     ************************************************************/
    private void clearTheScreen()
    {
        inputLine.setText("");
        outputLine.setText("");
        errorLine.setText("");
    }
    
    /************************************************************
     * name: solveOperation
     * function: solves the given operation on screen
     * 
     ************************************************************/
     private void solveOperation()
     {
         // Get the text from the display_input Label
        String expression = inputLine.getText();
        
        // Split the expression to get the operands and the operator
        String[] components = expression.split("\\s+");
        
        // Check if it is a valid expression
        if(components.length == 3)
        {
            // Operands
            int part1 = Integer.parseInt(components[0]);
            int part2 = Integer.parseInt(components[2]);
            
            // result
            int result = 0;
            
            // Get the radio button group for the grades math
            RadioButton gradeRadioButton = (RadioButton) mathGradeRadioGroup.getSelectedToggle();
            
            // Calculate based on operator
            switch (components[1])
            {
                // Addition 
                case "+":
                    result = part1 + part2;
                    
                    // show result 
                    outputLine.setText(String.valueOf(result));
                    break;
                
                // Multiplication 
                case "×":
                    result = part1 * part2;
                    
                    // show result 
                    outputLine.setText(String.valueOf(result));
                    
                    break;
                
                // Subtraction
                case "-":
                    // Grade 4
                    if(gradeRadioButton.getText().equals("Grade 4 MATH"))
                    {
                        // Check that operand1 is greater than/equal to than operand2
                        if(part1 >= part2)
                        {
                            result = part1 - part2;
                            
                            // show result
                            outputLine.setText(String.valueOf(result));
                        }
                        else
                        {
                            // show error
                            errorLine.setText("ERROR!!!");
                            
                            // Clear Ouput
                            outputLine.setText("");
                            
                            return;
                        }
                    }
                    // Grade 5 and 6 subtracts as normal
                    else
                    {
                        result = part1 - part2;
                        
                        // Display the result in the display_output Label
                        outputLine.setText(String.valueOf(result));
                        
                        // Clear the error message
                        errorLine.setText("");
                    }
                    
                    break;
                
                // Division
                default :
                    // grade 4 can only work if no remainder
                    if(gradeRadioButton.getText().equals("Grade 4 MATH"))
                    {
                        // Check if number divides without remainder
                        if(part1 % part2 == 0)
                        {
                            // Calculate division
                            result = part1 / part2;
                            
                            // show result
                            outputLine.setText(String.valueOf(result));
                        }
                        else
                        {
                            // show error 
                            errorLine.setText("ERROR!!!");
                            
                            // Clear output line
                            outputLine.setText("");
                            
                            return;
                        }
                    }
                    // grade 5, quotient and remainder is used
                    else if(gradeRadioButton.getText().equals("Grade 5 MATH"))
                    {
                        // Calculate Quotient and remainder
                        int operand1 = (int) (part1 / part2);
                        int operand2 = (int) (part1 % part2);
                        
                        // Store Result
                        String calculate = operand1 + " R " + operand2;
                        
                        // show result
                        outputLine.setText(String.valueOf(calculate));
                        
                        // Remove error message
                        errorLine.setText("");
                        
                        return;
                    }
                    // For grade 6, result is calculated to 4 decimal places
                    else
                    {                            
                        // Converting operands to double
                        double operand1 = (double) part1;
                        double operand2 = (double) part2;
                        
                        // Calculating
                        double calculate = operand1 / operand2;
                        
                        // Round to 4 decimal places
                        DecimalFormat calc4Deci = new DecimalFormat("0.0000");
                        String covertCalc = calc4Deci.format(calculate);
                        
                        // show Result
                        outputLine.setText(String.valueOf(covertCalc));
                        
                        // Clear error
                        errorLine.setText("");
                    }
                    break;
            }
        }
     }
}
