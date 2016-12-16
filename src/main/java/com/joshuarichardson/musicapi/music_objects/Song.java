package com.joshuarichardson.musicapi.music_objects;

import com.google.gson.Gson;
import com.joshuarichardson.musicapi.Utils;

import java.io.File;
import java.time.LocalDateTime;

/**
 * @author: Joshua Richardson on 02/12/2016.
 */
public class Song{

    private MainDatabase db;



    private File musicFile;
    private String artistId;
    private String id;
    private int rating;
    private int plays;
    private String albumId;
    private LocalDateTime dateAdded;


    public Song(MainDatabase db, File musicFile) {
        this.db = db;
        this.musicFile = musicFile;
        this.id = Utils.artifactId();
        this.rating = 0;
        this.plays = 0;
        this.dateAdded = LocalDateTime.now();


    }


    //For development use only
    public Song(File musicFile, String artistId, String id, int rating, int plays, String albumId, LocalDateTime dateAdded) {
        this.musicFile = musicFile;
        this.artistId = artistId;
        this.id = id;
        this.rating = rating;
        this.plays = plays;
        this.albumId = albumId;
        this.dateAdded = dateAdded;
    }

    public static Song fromJson(String json) {
        return new Gson().fromJson(json, Song.class);
    }

    public String toJson() {
        return new Gson().toJson(this, Song.class);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Song && ((Song) obj).getMusicFile().equals(musicFile);
    }

    public String getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }


    public String getArtistId() {
        return artistId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }


    public MainDatabase getDb() {
        return db;
    }

    public File getMusicFile() {
        return musicFile;
    }
}
