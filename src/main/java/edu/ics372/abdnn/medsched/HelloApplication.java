package edu.ics372.abdnn.medsched;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static final int DEFAULT_SCENE_WIDTH = 800;
    static final int DEFAULT_SCENE_HEIGHT = 600;
    @Override
    public void start (Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), DEFAULT_SCENE_WIDTH, DEFAULT_SCENE_HEIGHT);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main (String[] args) {
        launch();
    }
}

/*
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPage extends Application {
   @Override
   public void start(Stage stage) {
      //creating label email
      Text text1 = new Text("Email");

      //creating label password
      Text text2 = new Text("Password");

      //Creating Text Filed for email
      TextField textField1 = new TextField();

      //Creating Text Filed for password
      PasswordField textField2 = new PasswordField();

      //Creating Buttons
      Button button1 = new Button("Submit");
      Button button2 = new Button("Clear");

      //Creating a Grid Pane
      GridPane gridPane = new GridPane();

      //Setting size for the pane
      gridPane.setMinSize(400, 200);

      //Setting the padding
      gridPane.setPadding(new Insets(10, 10, 10, 10));

      //Setting the vertical and horizontal gaps between the columns
      gridPane.setVgap(5);
      gridPane.setHgap(5);

      //Setting the Grid alignment
      gridPane.setAlignment(Pos.CENTER);

      //Arranging all the nodes in the grid
      gridPane.add(text1, 0, 0);
      gridPane.add(textField1, 1, 0);
      gridPane.add(text2, 0, 1);
      gridPane.add(textField2, 1, 1);
      gridPane.add(button1, 0, 2);
      gridPane.add(button2, 1, 2);

      //Styling nodes
      button1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
      button2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");

      text1.setStyle("-fx-font: normal bold 20px 'serif' ");
      text2.setStyle("-fx-font: normal bold 20px 'serif' ");
      gridPane.setStyle("-fx-background-color: BEIGE;");

      //Creating a scene object
      Scene scene = new Scene(gridPane);

      //Setting title to the Stage
      stage.setTitle("CSS Example");

      //Adding scene to the stage
      stage.setScene(scene);

      //Displaying the contents of the stage
      stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}
 */