package com.joshuarichardson.musicapi;

import com.joshuarichardson.musicapi.music_objects.MainDatabase;
import com.joshuarichardson.musicapi.music_objects.Playlist;
import com.joshuarichardson.musicapi.music_objects.Song;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Joshua on 02/12/2016.
 */
public class PlaybackManager {

    private int currentIndex = - 1;
    private Playlist currentPlaylist;
    private MainDatabase songDatabase = new MainDatabase(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    private SimpleBooleanProperty playing = new SimpleBooleanProperty(false);
    private Song currentSong;
    private MediaPlayer player;
    private Media media;
    private List<TrackListener> listeners = new ArrayList<TrackListener>();

    Runnable loadSongThreaded = this::loadSong;


    public PlaybackManager() {
        playingProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) { play(); } else { pause(); }
        });
    }


    public void addTrackChangedListener(TrackListener toAdd) {
        listeners.add(toAdd);
    }

    public boolean isPlaying() {
        return playing.get();
    }

    public SimpleBooleanProperty playingProperty() {
        return playing;
    }

    public PlaybackManager(File... files) {
        Arrays.stream(files).forEach(this::addSong);
    }

    public void play() {
        if (currentSong == null) {
            currentSong = songDatabase.getSongs().get(0);
            loadSongThreaded.run();
        }
        if (player.getStatus() == MediaPlayer.Status.UNKNOWN) {
            player.setOnReady(() -> player.play());
        } else {
            player.play();
        }
    }

    private void loadSong() {
        media = new Media(currentSong.getFile().toURI().toASCIIString());
        player = new MediaPlayer(media);
    }

    public void pause() {
        if (currentSong != null) {
            player.pause();
        }
    }

    public void addSong(File song) {
        Song s = new Song(songDatabase, song);
        songDatabase.addSong(s);
    }





}
