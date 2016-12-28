package com.joshuarichardson.musicapi;

import com.joshuarichardson.musicapi.music_objects.MainDatabase;
import com.joshuarichardson.musicapi.music_objects.Playlist;
import com.joshuarichardson.musicapi.music_objects.Song;
import javafx.beans.property.SimpleBooleanProperty;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Joshua on 02/12/2016.
 */
public class PlaybackManager {

    private int currentIndex = - 1;
    private FilePlayer currentPlayer;
    private Playlist currentPlaylist;
    private MainDatabase songDatabase;
    private SimpleBooleanProperty playing = new SimpleBooleanProperty(false);
    private Song currentSong;


    public boolean isPlaying() {
        return playing.get();
    }

    public SimpleBooleanProperty playingProperty() {
        return playing;
    }


    public PlaybackManager(File... files) {
        Arrays.stream(files).forEach(this::addSong);
    }




    private FilePlayer playNext() {
        FilePlayer f = new FilePlayer(currentSong.getFile(), this);
        currentPlayer = f;
        return f;
    }

    public void addSong(File song) {
        Song s = new Song(songDatabase, song);
        songDatabase.addSong(s);
    }


    public FilePlayer getPlayer() {
        return currentPlayer;
    }


}
