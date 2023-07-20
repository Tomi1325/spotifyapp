package com.codecool.spotifyApp.spotify.track;

public class Podcast extends Track {
    private int seasonNumber;
    private int trackNumber;
    private static int trackNumberCount = 0;

    public Podcast(String name, int length, int seasonNumber) {
        super(name, length);
        this.seasonNumber = seasonNumber;
        this.trackNumber = trackNumberCount++;
    }

    @Override
    public String toString() {
        return "Podcast name is: " +name;
    }
}
