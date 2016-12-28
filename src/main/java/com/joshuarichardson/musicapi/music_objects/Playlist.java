package com.joshuarichardson.musicapi.music_objects;

import java.util.ArrayList;

/**
 * @author: Joshua Richardson on 02/12/2016.
 */
public class Playlist {
    private String name;
    private ArrayList<Song> songs;


    public Playlist(String name) {
        this.name = name;
    }


    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song s) {
        songs.add(s);
    }
}
