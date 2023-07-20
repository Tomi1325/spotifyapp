package com.codecool.spotifyApp.spotify.track;

public class Song extends Track {
    private String lyrics;
    public Song(String name, int length, String lyrics) {
        super(name, length);
        this.lyrics = lyrics;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Song name is: " + name;
    }
}
