package com.joshuarichardson.fxplayer;

import com.joshuarichardson.musicapi.resource.ImageResourceManager;
import com.joshuarichardson.musicapi.PlaybackManager;
import com.joshuarichardson.musicapi.resource.ImgRef;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button btnPrevious;
    @FXML
    private Button btnPlayPause;
    @FXML
    private Button btnForward;
    @FXML
    private ImageView ivAlbumArt;
    @FXML
    private Button btnAddMusic;



    private PlaybackManager playbackManager;
    private ImageResourceManager imageResourceManager = new ImageResourceManager(getClass(), "img", new ImgRef("play.png", 3), new ImgRef("pause.png", 0), new ImgRef("next.png", 0), new ImgRef("previous.png", 0), new ImgRef("placeholder.png", 0));


    public void initialize(URL location, ResourceBundle resources) {

        ivAlbumArt.setImage(imageResourceManager.get("placeholder").getImage());
        bindImageViewToButton(btnPlayPause, new ImageView(imageResourceManager.get("play").getImage()), 20 ,20, 4);
        bindImageViewToButton(btnPrevious, new ImageView(imageResourceManager.get("previous").getImage()), 12, 12, -2);
        bindImageViewToButton(btnForward, new ImageView(imageResourceManager.get("next").getImage()), 12, 12, 2);



        btnPlayPause.setOnAction(event -> playbackManager.playingProperty().set(!playbackManager.isPlaying()));

        btnAddMusic.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open MP3 File");
            File file = fileChooser.showOpenDialog(btnPrevious.getScene().getWindow());
            if (file != null) {
                playbackManager = new PlaybackManager(file.toURI().toASCIIString());

                playbackManager.playingProperty().addListener((observable, oldValue, newValue) -> {
                    ImgRef result = imageResourceManager.get(newValue ? "pause" : "play");
                    getBoundImage(btnPlayPause).setImage(result.getImage());
                    getBoundImage(btnPlayPause).setTranslateX(result.getXShift());
                    playbackManager.getCurrentFilePlayer().getPlayer().play();
                });
            }

        });

    }

    public void bindImageViewToButton(Button b, ImageView i, int x, int y, int xShift) {
        b.setGraphic(i);
        i.setTranslateX(xShift);
        b.widthProperty().addListener((observable, oldValue, newValue) -> i.fitWidthProperty().setValue(b.getWidth() - x));
        b.heightProperty().addListener((observable, oldValue, newValue) -> i.fitHeightProperty().setValue(b.getHeight() - y));
    }

    public ImageView getBoundImage(Button b) {
        return (ImageView) b.getGraphic();
    }
}
