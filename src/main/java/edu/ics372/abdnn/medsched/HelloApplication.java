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