import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import java.awt.*;

public class Exercise31_17 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
	MenuBar menuBar = new MenuBar();
	
	Menu operationMenu = new Menu("Operation");
		menuBar.getMenus().add(operationMenu);
	
	Menu calculateSubMenu = new Menu("Calculate");
	Menu exitSubMenu = new Menu("Exit");
		operationMenu.getItems().add(calculateSubMenu); 
		operationMenu.getItems().add(exitSubMenu);
		
	BorderPane borderPane = new BorderPane();
	borderPane.setTop(menuBar);
	
	GridPane pane = new GridPane();
		
	TextField investAmount = new TextField();
	TextField numbYears = new TextField();
	TextField annualIntRate = new TextField();
	TextField futureVal = new TextField();

	Label investLabel = new Label("Investment Amount: ");
	Label yearsLabel = new Label("Number of Years: ");
	Label rateLabel = new Label("Annual Interest Rate: ");
	Label futureLabel = new Label("Future Value: ");
	
	pane.add(investLabel, 0, 0);
	pane.add(investAmount, 1, 0);
	pane.add(yearsLabel, 0, 1);
	pane.add(numbYears, 1, 1);
	pane.add(rateLabel, 0, 2);
	pane.add(annualIntRate, 1, 2);
	pane.add(futureLabel, 0, 3);
	pane.add(futureVal, 1, 3);
	borderPane.setCenter(pane);

	HBox hBox = new HBox();
	Button btCalculate = new Button("Calculate");
	hBox.getChildren().add(btCalculate);
	borderPane.setBottom(hBox);
	
	btCalculate.setOnAction(e -> {
		Integer investmentAmount = Integer.parseInt(investAmount.getText());
		Integer years = Integer.parseInt(numbYears.getText());
		Double monthlyInterestRate = Double.parseDouble(annualIntRate.getText());
		
		Double futureValue = investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
		futureValue *= 100;
		futureValue = (double) Math.round(futureValue);
		futureValue /= 100;
		
		futureVal.setText("$" + futureValue + "");
	});
		
	calculateSubMenu.setOnAction(e -> {
		Integer investmentAmount = Integer.parseInt(investAmount.getText());
		Integer years = Integer.parseInt(numbYears.getText());
		Double monthlyInterestRate = Double.parseDouble(annualIntRate.getText());
		
		Double futureValue = investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
		futureValue *= 100;
		futureValue = (double) Math.round(futureValue);
		futureValue /= 100;
		
		futureVal.setText("$" + futureValue + "");
	});
		
	exitSubMenu.setOnAction(e -> {
		System.exit(0);
	});
		
	Scene scene = new Scene(borderPane, 400, 250);  
	primaryStage.setTitle("DisplayFigure"); // Set the window title
	primaryStage.setScene(scene); // Place the scene in the window
	primaryStage.show(); // Display the window
	}
}