package com.codecool.spotifyApp.spotify.author;

import com.codecool.spotifyApp.spotify.track.Album;
import com.codecool.spotifyApp.spotify.track.Song;
import com.codecool.spotifyApp.spotify.track.Track;

import java.util.ArrayList;
import java.util.List;

public class Singer extends Author {
    private List<Album> albumList;
    public Singer(String name) {
        super(name);
        albumList = new ArrayList<>();
    }


    public void uploadAlbum(Album album){
        albumList.add(album);
    }

    public List<Track> getAllSong() {
        List<Track> allSongs = new ArrayList<>();

        for (Album album : albumList) {
            allSongs.addAll(album.getSongList());
        }
        return allSongs;
    }

    public List<Song> searchSongByName(String  name){
        List<Song> songsWithSameName = new ArrayList<>();
        for (Album album : albumList) {
            songsWithSameName.add(album.searchBySongName(name));
        }
        return songsWithSameName;
    }

    @Override
    public List<Track> getAllPublished() {
        return getAllSong();
    }
}