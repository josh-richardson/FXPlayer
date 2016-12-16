package com.joshuarichardson.musicapi.music_objects;

import com.joshuarichardson.musicapi.Utils;

/**
 * @author: Joshua Richardson on 02/12/2016.
 */
public class Artist {
    private String name;
    private String id;


    public Artist(String name) {
        this.name = name;
        id = Utils.artifactId();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
