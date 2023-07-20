package com.codecool.spotifyApp.spotify;

import com.codecool.spotifyApp.spotify.author.Podcaster;
import com.codecool.spotifyApp.spotify.author.Singer;
import com.codecool.spotifyApp.spotify.musicStyle.MusicStyle;
import com.codecool.spotifyApp.spotify.track.Album;
import com.codecool.spotifyApp.spotify.track.Podcast;
import com.codecool.spotifyApp.spotify.track.Song;
import com.codecool.spotifyApp.spotify.track.Track;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpotifyAppTest {
    private SpotifyApp spotifyApp;
    private Singer singer1;
    private Singer singer2;
    private Podcaster podcaster1;
    private Podcaster podcaster2;
    private Song song1;
    private Song song2;
    private Song song3;
    private Podcast podcast1;
    private Podcast podcast2;
    private Podcast podcast3;
    private Album album1;
    private Album album2;
    @BeforeEach
    public void setUp() {
        spotifyApp = new SpotifyApp();
        singer1 = new Singer("Singer Johnny");
        singer2 = new Singer("Singer Chris");
        podcaster1 = new Podcaster("Podcaster Joe");
        podcaster2 = new Podcaster("Podcaster Jenny");
        song1 = new Song("Song1", 181, "song1Lyrics");
        song2 = new Song("Song2", 221, "song2Lyrics");
        song3 = new Song("Song3", 196, "song3Lyrics");
        podcast1 = new Podcast("Podcast1", 1130, 1);
        podcast2 = new Podcast("Podcast2", 1330, 2);
        podcast3 = new Podcast("Podcast3", 920, 3);
        album1 = new Album("Album1", MusicStyle.POP);
        album2 = new Album("Album2", MusicStyle.JAZZ);

        song1.play();
        song2.play();
        song2.play();

        album1.addSong(song1);
        album1.addSong(song2);
        album2.addSong(song3);

        singer1.uploadAlbum(album1);
        singer2.uploadAlbum(album2);

        podcaster1.upload(podcast1);
        podcaster1.upload(podcast2);
        podcaster2.upload(podcast3);

        spotifyApp.addAuthors(singer1);
        spotifyApp.addAuthors(singer2);
        spotifyApp.addAuthors(podcaster1);
        spotifyApp.addAuthors(podcaster2);
    }

    @Test
    void getPublishedTracksForASinger() {
        List<Track> expected = List.of(song1,song2);
        List<Track> actual = spotifyApp.getPublishedTracks("Singer Johnny");

        Assertions.assertEquals(expected,actual);
    }
    @Test
    void getPublishedTracksForAPodcaster(){
        List<Track> expected = List.of(podcast1,podcast2);
        List<Track> actual = spotifyApp.getPublishedTracks("Podcaster Joe");

        Assertions.assertEquals(expected,actual);
    }
    @Test
    void getMostPlayedSongs(){
        Song expected = song2;
        Song actual = spotifyApp.mostListenedSongs();

        Assertions.assertEquals(expected,actual);
    }
}