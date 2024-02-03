package edu.ics372.abdnn.medsched;

import javafx.application.Application;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class ScheduleAppointmentView {

    public void start(Stage primaryStage) {
        // Creating a ComboBox
        ComboBox<String> comboBox = new ComboBox<>();

        // Creating a list of items to be displayed in the ComboBox
        ObservableList<String> items = FXCollections.observableArrayList(
            "Option 1",
            "Option 2",
            "Option 3",
            "Option 4"
        );

        // Adding items to the ComboBox
        comboBox.setItems(items);

        // Set a default value for the ComboBox
        comboBox.setValue("Option 1");

        // Handling selection change events
        comboBox.setOnAction(event -> {
            String selectedValue = comboBox.getValue();
            System.out.println("Selected: " + selectedValue);
        });

        // Creating a layout and adding the ComboBox to it
        VBox vbox = new VBox(comboBox);

        // Creating a scene
        Scene scene = new Scene(vbox, 300, 200);

        // Setting the stage title and scene
        primaryStage.setTitle("JavaFX ComboBox Example");
        primaryStage.setScene(scene);

        // Showing the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}