package com.joshuarichardson.musicapi.music_objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: Joshua Richardson on 02/12/2016.
 */
public class MainDatabase {

    //JUST IDs in objects, all shit stored in these arrays.

    private ArrayList<Song> songs;
    private ArrayList<Album> albums;
    private ArrayList<Artist> artists;
    private ArrayList<Playlist> playlists;


    public MainDatabase(ArrayList<Song> songs, ArrayList<Album> albums, ArrayList<Artist> artists, ArrayList<Playlist> playlists) {
        this.songs = songs;
        this.albums = albums;
        this.artists = artists;
        this.playlists = playlists;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public boolean containsSong(Song song) {
        return songs.contains(song);
    }

    public boolean containsSong(String fileName) {
        return songs.stream().anyMatch(s -> s.getFileName().equals(fileName));
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public List<Song> getSongsBy(Artist artist) {
        return songs.stream().filter(s -> Objects.equals(s.getArtistId(), artist.getId())).collect(Collectors.toList());
    }

    public List<Song> getSongsIn(Album album) {
        return songs.stream().filter(s -> s.getAlbumId().equals(album.getId())).collect(Collectors.toList());
    }
}
