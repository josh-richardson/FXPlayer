package com.joshuarichardson.musicapi.music_objects;

import com.google.gson.Gson;
import com.joshuarichardson.musicapi.Utils;
import org.apache.commons.lang3.StringUtils;

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
    private String albumId;
    public Metadata metadata;

    public Song(MainDatabase db, File musicFile) {
        this.db = db;
        this.musicFile = musicFile;
        this.id = Utils.artifactId();
        this.metadata = new Metadata(musicFile);

        db.getSongs().add(this);

        if (!StringUtils.isBlank(metadata.artist)) {
            Artist memberArtist;
            if ((memberArtist = db.getArtistByName(metadata.artist)) != null) {
                artistId = memberArtist.getId();
            } else {
                Artist songArtist = new Artist(metadata.artist);
                db.getArtists().add(songArtist);
                artistId = songArtist.getId();
            }
        }

        if (!StringUtils.isBlank(metadata.album)) {
            Album memberAlbum;
            if ((memberAlbum = db.getAlbumByName(metadata.album)) != null) {
                albumId = memberAlbum.getId();
            } else {
                Album songAlbum = new Album(metadata.album);
                db.getAlbums().add(songAlbum);
                albumId = songAlbum.getId();
            }
        }


    }


    //For development use only
    public Song(File musicFile, String artistId, String id, String albumId) {
        this.musicFile = musicFile;
        this.artistId = artistId;
        this.id = id;
        this.albumId = albumId;
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

    public MainDatabase getDb() {
        return db;
    }

    public File getMusicFile() {
        return musicFile;
    }
}
