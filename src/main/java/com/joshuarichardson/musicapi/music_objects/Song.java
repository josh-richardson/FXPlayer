package com.joshuarichardson.musicapi.music_objects;

import com.google.gson.Gson;
import com.joshuarichardson.musicapi.Utils;

import java.time.LocalDateTime;

/**
 * @author: Joshua Richardson on 02/12/2016.
 */
public class Song{

    private MainDatabase db;



    private String fileName;
    private String artistId;
    private String id;
    private int rating;
    private int plays;
    private String albumId;
    private LocalDateTime dateAdded;

    public Song(MainDatabase db, String fileName) {
        this.db = db;
        this.fileName = fileName;
        this.id = Utils.artifactId();
        this.rating = 0;
        this.plays = 0;
        this.dateAdded = LocalDateTime.now();
        this.artistId = Utils.artifactId();
    }


    public Song(String fileName, String artistId, String id, int rating, int plays, String albumId, LocalDateTime dateAdded) {
        this.fileName = fileName;
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
        return obj != null && obj instanceof Song && ((Song) obj).fileName.equals(fileName);
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

    public String getFileName() {
        return fileName;
    }

    public MainDatabase getDb() {
        return db;
    }
}
