package com.codecool.spotifyApp.spotify.track;

public abstract class Track {
    protected String name;
    private int length;
    private int numberOfTimesPlayed;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
        numberOfTimesPlayed = 0;
    }

    public void play(){
        numberOfTimesPlayed++;
    }

    public int getNumberOfTimesPlayed() {
        return numberOfTimesPlayed;
    }
}
