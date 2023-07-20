package com.codecool.spotifyApp.spotify.author;

import com.codecool.spotifyApp.spotify.track.Podcast;
import com.codecool.spotifyApp.spotify.track.Track;

import java.util.ArrayList;
import java.util.List;

public class Podcaster extends Author {

    private List<Podcast> podcastList;

    public Podcaster(String name) {
        super(name);
        podcastList = new ArrayList<>();
    }

    public List<Track> getPodcastList() {
        List<Track> allPodcasts = new ArrayList<>();
        for (Podcast podcast : podcastList) {
            allPodcasts.add(podcast);
        }
        return allPodcasts;
    }

    public void upload(Track track) {
        podcastList.add((Podcast) track);
    }

    @Override
    public List<Track> getAllPublished() {
        return getPodcastList();
    }
}
