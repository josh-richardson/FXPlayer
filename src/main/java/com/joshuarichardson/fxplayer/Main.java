package com.joshuarichardson.fxplayer;

import com.google.gson.Gson;
import com.joshuarichardson.musicapi.music_objects.Song;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        ArrayList<Song> songs = new ArrayList<>();
//        songs.add(new Song("C://file.mp3", "1111-1111-1111-1111", "1111-1111-1111-1111", 5, 0, "1111-1111-1111-1111", LocalDateTime.of(2003, 5, 3, 12, 1)));
        songs.add(new Song("C://file.mp3", "1111-1111-1111-1111", "1111-1111-1111-1111", 5, 0, "1111-1111-1111-1111", LocalDateTime.of(2003, 5, 3, 12, 1)));
        System.out.println(new Gson().toJson(songs, ArrayList.class));


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
