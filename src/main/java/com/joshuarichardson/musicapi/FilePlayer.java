package com.joshuarichardson.musicapi;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * @author: Joshua Richardson on 02/12/2016.
 */
public class FilePlayer {


    private MediaPlayer player;
    private Media media;

    private SimpleBooleanProperty readyState = new SimpleBooleanProperty(false);


    public FilePlayer(String fileName, PlaybackManager manager) {
        media = new Media(fileName);
        player = new MediaPlayer(media);
        player.setOnReady(() -> readyState.set(true));

        manager.playingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { player.stop(); } else { player.play(); }
        });

    }

    public boolean getReadyState() {
        return readyState.get();
    }

    public SimpleBooleanProperty readyStateProperty() {
        return readyState;
    }


    public MediaPlayer getPlayer() {
        return player;
    }

    public Media getMedia() {
        return media;
    }

}
