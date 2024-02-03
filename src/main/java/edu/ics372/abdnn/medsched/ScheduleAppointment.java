package edu.ics372.abdnn.medsched;

import edu.ics372.abdnn.medsched.core.catalogs.*;
import edu.ics372.abdnn.medsched.core.concretes.*;
import edu.ics372.abdnn.medsched.core.global.*;
import edu.ics372.abdnn.medsched.facade.request.*;
import edu.ics372.abdnn.medsched.facade.response.*;
import javafx.application.Application;
import javafx.collections.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class ScheduleAppointment extends Application {
    static final int DEFAULT_SCENE_WIDTH = 800;
    static final int DEFAULT_SCENE_HEIGHT = 600;
    @Override
    public void start (Stage stage) throws IOException {
        stage.setTitle("ChoiceBox Experiment 1");
        Response response = new Response();
        ArrayList<String> names = response.response(new DepartmentNamesRequest());
        System.out.println("total departments " + names.size());

        ChoiceBox choiceBox = new ChoiceBox();

        choiceBox.getItems().add("Primary Care");
        choiceBox.getItems().add("Choice 2");
        choiceBox.getItems().add("Choice 3");
        for (Department department : Departments.INSTANCE.getDepartments()) {
            System.out.println(department.getName());
            choiceBox.getItems().add(department.getName());
        }

        HBox hbox = new HBox(choiceBox);

        Scene scene = new Scene(hbox, DEFAULT_SCENE_WIDTH, DEFAULT_SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main (String[] args) {
        Application.launch();
    }
}