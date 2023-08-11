import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Insets;
import javafx.geometry.Side;

public class TabPaneDemo extends Application {
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    
    TabPane tabPane = new TabPane();
    
    Tab tab1 = new Tab("Line");
    StackPane pane1 = new StackPane();
    pane1.getChildren().add(new Line(10, 10, 80, 80));
    tab1.setContent(pane1);
    Tab tab2 = new Tab("Rectangle");
    tab2.setContent(new Rectangle(10, 10, 200, 200));
    Tab tab3 = new Tab("Circle");
    tab3.setContent(new Circle(50, 50, 20));
    Tab tab4 = new Tab("Ellipse");
    tab4.setContent(new Ellipse(10, 10, 100, 80));
    tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
    
//  BorderPane borderPane = new BorderPane();
    
    HBox paneRadButtons = new HBox(20);
    paneRadButtons.setPadding(new Insets(5, 5, 5, 5));
    paneRadButtons.setAlignment(Pos.CENTER);
    
    RadioButton rbTop = new RadioButton("Top");
    RadioButton rbLeft = new RadioButton("Left");
    RadioButton rbBottom = new RadioButton("Bottom");
    RadioButton rbRight = new RadioButton("Right");
    paneRadButtons.getChildren().addAll(rbTop, rbLeft, rbBottom, rbRight);
    
    BorderPane borderPane = new BorderPane();
    borderPane.setBottom(paneRadButtons);
    borderPane.setTop(tabPane);
    
    ToggleGroup group = new ToggleGroup();
    rbTop.setToggleGroup(group);
    rbLeft.setToggleGroup(group);
    rbBottom.setToggleGroup(group);
    rbRight.setToggleGroup(group);
    
    rbTop.setOnAction(e -> {
      if (rbTop.isSelected()) {
        tabPane.setSide(Side.TOP);
//      pane1.setAlignment(Pos.CENTER);
      }
    });
    
    rbLeft.setOnAction(e -> {
      if (rbLeft.isSelected()) {
        tabPane.setSide(Side.LEFT);
//      pane1.setAlignment(Pos.CENTER);
      }
    });
    
    rbBottom.setOnAction(e -> {
      if (rbBottom.isSelected()) {
        tabPane.setSide(Side.BOTTOM);
//      pane1.setAlignment(Pos.CENTER);
      }
    });
    
    rbRight.setOnAction(e -> {
      if (rbRight.isSelected()) {
        tabPane.setSide(Side.RIGHT);
//      pane1.setAlignment(Pos.CENTER);
      }
    });

    Scene scene = new Scene(borderPane, 300, 250);  
    primaryStage.setTitle("DisplayFigure"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   * line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}