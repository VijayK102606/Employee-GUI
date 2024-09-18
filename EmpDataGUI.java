
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// TODO: Auto-generated Javadoc
/**
 * The Class EmpDataGUI.
 *
 * @author Scott
 */
public class EmpDataGUI extends Application {
	
	/** The main. */
	private GridPane main = new GridPane();	
	
	/** The pane. */
	private BorderPane pane = new BorderPane();
    
    /** The controller. */
    private ListController controller = new ListController();
    
    /** The view. */
    private BorderPane view = new BorderPane();
    
    /** The scroll. */
    private ScrollPane scroll = new ScrollPane();
    // TODO #1:
    // create private TextField variables for Name, SSN, Salary and Years
    /** The name last. */
    // so that they can be accessed directly by methods inside this class.
    private TextField nameLast;
    
    /** The name first. */
    private TextField nameFirst;
	
	/** The ssn. */
	private TextField SSN;
	
	/** The Age. */
	private TextField Age;
	
	/** The Pronouns. */
	private TextField Pronouns;
	
	/** The Salary. */
	private TextField Salary;
	
	/** The Years. */
	private TextField Years;
	
	/** The group. */
	private ToggleGroup group;
	
	/** The engineering. */
	RadioButton engineering;
	
	/** The marketing. */
	RadioButton marketing;
	
	/** The manufacturing. */
	RadioButton manufacturing;
	
	/** The finance. */
	RadioButton finance;
	
	/** The hr. */
	RadioButton hr;
	
	/** The support. */
	RadioButton support;
	
	/** The management. */
	RadioButton management;
	
	public final static int width = 400;
	public final static int height = 500;
	public final static int grid1 = 1;
	public final static int grid2 = 2;
	public final static int grid3 = 3;
	public final static int grid4 = 4;
	public final static int grid5 = 5;
	public final static int grid6 = 6;
	public final static int grid7 = 7;
	public final static int grid8 = 8;
	public final static int grid9 = 9;
    
    /**
     * Start.
     * creates basic scene and gui layout that appears when running the program.
     *
     * @param primaryStage the primary stage
     */
    @Override
    public void start(Stage primaryStage) {
    
    	Scene scene = new Scene(pane, width, height);
    	Scene scene2 = new Scene(view, width, height);
    	
//		Labels:    	
    	Label Ltitle = new Label("EMPLOYEE DATA ENTRY");
    	Label LNameFirst = new Label("First Name: ");
    	Label LNameLast = new Label("Last Name: ");
    	Label LAge = new Label("Age: ");
    	Label LPronouns = new Label("Pronouns: ");
    	Label LSSN = new Label("SSN: ");
    	Label LSalary = new Label("Salary: ");
    	Label LYears = new Label("Years: ");
    	Label LDept = new Label("Dept: ");
    	
//		TextFields:  	
    	nameLast = new TextField();
    	nameFirst = new TextField();
    	SSN = new TextField();
    	Age = new TextField();
    	Pronouns = new TextField();
    	Salary = new TextField();
    	Years = new TextField();
   
//		Buttons:
    	Button sortName = new Button("Sort By Name  ");
    	Button sortID = new Button("Sort By ID  ");	
    	Button sortSalary = new Button("Sort By Salary");    	
    	Button Back = new Button("Back");
    	Button addEmployee = new Button("add Employee");
    	Button viewEmployees = new Button("view Employees");
    	Button addDB = new Button("SaveEmployeeDB");
    	
//		SetOnActions:
    	sortName.setOnAction(e -> controller.sortByName());
    	sortID.setOnAction(e -> controller.sortByID());
    	sortSalary.setOnAction(e -> controller.sortBySalary());
    	Back.setOnAction(e -> primaryStage.setScene(scene));
    	addEmployee.setOnAction(e -> enterAll());
    	viewEmployees.setOnAction(e -> {viewEmployeeDB(); primaryStage.setScene(scene2);});
    	addDB.setOnAction(e -> controller.saveEmployeeDB());
    	
//		RadioButtons:
    	engineering = new RadioButton("Engineering");
    	marketing = new RadioButton("Marketing/Sales");
    	manufacturing = new RadioButton("Manufacturing");
    	finance = new RadioButton("Finance");
    	hr = new RadioButton("Human Resources");
    	support = new RadioButton("Customer Support");
    	management = new RadioButton("Management");
    	
// 		Groups:	
    	HBox scrollBox = new HBox();
    	scrollBox.getChildren().addAll(Back, sortName, sortID, sortSalary);
    	
    	VBox depts = new VBox();
    	depts.getChildren().addAll(engineering, marketing, manufacturing, finance, hr, support, management);
    	
    	HBox buttons = new HBox();
    	buttons.getChildren().addAll(addEmployee, viewEmployees, addDB);
    	
    	group = new ToggleGroup();
    	engineering.setToggleGroup(group);
    	marketing.setToggleGroup(group);
    	manufacturing.setToggleGroup(group);
    	finance.setToggleGroup(group);
    	hr.setToggleGroup(group);
    	support.setToggleGroup(group);
    	management.setToggleGroup(group);
    	
    	engineering.setSelected(true);
    	
    	
// 		Layout:
    	main.add(LNameLast, 0, grid2);
    	main.add(nameLast, grid1, grid2);
    	
    	main.add(LNameFirst, 0, grid3);
    	main.add(nameFirst, grid1, grid3);
    	
    	main.add(LSSN, 0, grid4);
    	main.add(SSN, grid1, grid4);
    	
    	main.add(LAge, 0, grid5);
    	main.add(Age, grid1, grid5);
    	
    	main.add(LPronouns, 0, grid6);
    	main.add(Pronouns, grid1, grid6);
    	
    	main.add(LSalary, 0, grid7);
    	main.add(Salary, grid1, grid7);
    	
    	main.add(LYears, 0, grid8);
    	main.add(Years, grid1, grid8);
    	
    	main.add(LDept, 0, grid9);
    	main.add(depts, grid1, grid9);
 
//		Pane:
    	pane.setCenter(main);
    	pane.setTop(Ltitle);
    	pane.setBottom(buttons);
    	
//		View:
    	view.setBottom(scrollBox);
    	view.setCenter(scroll);
    	
    	primaryStage.setTitle("Employees");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    /**
     * Enter all.
     * method called when add employee button is pressed. goes to method in list controller
     * to add employee.
     */
    public void enterAll() {    	
    	RadioButton selected = (RadioButton) group.getSelectedToggle();
		String value = selected.getText();
		String message = controller.addEmployee(nameFirst.getText(), nameLast.getText(), SSN.getText(), Age.getText(), 
				Pronouns.getText(), Salary.getText(), Years.getText(), value);
		if(message != "") {
			generateAlert(message);
		} 
		else {
			nameLast.clear();
			nameFirst.clear();
			SSN.clear();
			Age.clear();
			Pronouns.clear();
			Salary.clear();
			Years.clear();
			engineering.setSelected(true);
		}
    }

    /**
     * View employee DB.
     * Method called when pressing view employee button which displays list of employees on second 
     * page.
     */
    private void viewEmployeeDB() {
    	String[] empDataStr = controller.getEmployeeDataStr();
    	ListView<String> lv = new ListView<>(FXCollections.observableArrayList(empDataStr));
    	lv.setPrefWidth(width);
    	lv.setPrefHeight(height);
    	scroll.setContent(lv);
    }
    
    /**
     * Generate alert.
     * 
     * generates alert based on number which indicates type of error to produce error message
     * and popup alert when pressing add employee.
     *
     * @param message the message
     */
	public void generateAlert(String message) {
    	Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText("Add Employee Failed");
		alert.setContentText(message);
		alert.showAndWait();
    }
   
	/**
	 * The main method.
	 * 
	 * runs program.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

} ;
