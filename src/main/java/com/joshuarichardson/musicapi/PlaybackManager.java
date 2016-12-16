package com.joshuarichardson.musicapi;

import com.joshuarichardson.musicapi.music_objects.MainDatabase;
import javafx.beans.property.SimpleBooleanProperty;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Joshua on 02/12/2016.
 */
public class PlaybackManager {

    private List<String> fileNames;
    private int currentIndex = - 1;
    private FilePlayer currentFilePlayer;
    private MainDatabase songDatabase;
    private SimpleBooleanProperty playing = new SimpleBooleanProperty(false);


    public boolean isPlaying() {
        return playing.get();
    }

    public SimpleBooleanProperty playingProperty() {
        return playing;
    }


    public PlaybackManager(String... fileNames) {
        this.fileNames = Arrays.stream(fileNames).collect(Collectors.toList());

        currentFilePlayer = playNext();
    }




    private FilePlayer playNext() {
        currentIndex++;
        return new FilePlayer(this.fileNames.get(currentIndex), this);
    }


    public FilePlayer getCurrentFilePlayer() {
        return currentFilePlayer;
    }


}
