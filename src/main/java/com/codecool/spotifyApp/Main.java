package com.codecool.spotifyApp;


import com.codecool.spotifyApp.spotify.SpotifyApp;
import com.codecool.spotifyApp.spotify.author.Podcaster;
import com.codecool.spotifyApp.spotify.author.Singer;
import com.codecool.spotifyApp.spotify.musicStyle.MusicStyle;
import com.codecool.spotifyApp.spotify.track.Album;
import com.codecool.spotifyApp.spotify.track.Podcast;
import com.codecool.spotifyApp.spotify.track.Song;

public class Main {
    public static void main(String[] args) {
        SpotifyApp spotifyApp = new SpotifyApp();
        Singer singer = new Singer("Singer Johnny");
        Singer singer2 = new Singer("Singer Chris");
        Podcaster podcaster = new Podcaster("Podcaster Joe");
        Podcaster podcaster2 = new Podcaster("Podcaster Jenny");
        Song song1 = new Song("Song1",181,"song1Lyrics");
        Song song2 = new Song("Song2",221,"song2Lyrics");
        Song song3 = new Song("Song3",196,"song3Lyrics");
        Podcast podcast1 = new Podcast("Podcast1",1130,1);
        Podcast podcast2 = new Podcast("Podcast2",1330,2);
        Podcast podcast3 = new Podcast("Podcast3",920,3);
        Album album1 = new Album("Album1", MusicStyle.POP);
        Album album2 = new Album("Album2", MusicStyle.JAZZ);

        song1.play();
        song2.play();
        song2.play();

        album1.addSong(song1);
        album1.addSong(song2);
        album2.addSong(song3);

        singer.uploadAlbum(album1);
        singer2.uploadAlbum(album2);

        podcaster.upload(podcast1);
        podcaster.upload(podcast2);
        podcaster2.upload(podcast3);

        spotifyApp.addAuthors(singer);
        spotifyApp.addAuthors(singer2);
        spotifyApp.addAuthors(podcaster);
        spotifyApp.addAuthors(podcaster2);

        System.out.println(spotifyApp.searchSongByName("Song1"));


        System.out.println(spotifyApp.getPublishedTracks("Singer Johnny"));
        System.out.println(spotifyApp.getPublishedTracks("Podcaster Jenny"));

        System.out.println(spotifyApp.mostListenedSongs());

    }
}