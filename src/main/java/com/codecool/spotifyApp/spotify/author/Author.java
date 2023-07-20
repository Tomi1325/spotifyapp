package com.codecool.spotifyApp.spotify.author;

import com.codecool.spotifyApp.spotify.track.Track;

import java.util.List;

public abstract class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
    public abstract List<Track> getAllPublished();
}
