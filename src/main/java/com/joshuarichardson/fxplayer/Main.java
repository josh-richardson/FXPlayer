package com.joshuarichardson.fxplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setController(new Controller());
        Parent root = fxmlLoader.load(getClass().getResourceAsStream("main.fxml"));

        primaryStage.setTitle("FXPlayer");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
