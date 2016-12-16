package com.joshuarichardson.musicapi.music_objects;

/**
 * @author: Joshua Richardson on 02/12/2016.
 */
public class Album {
    private String name;
    private String id;

    public Album(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
