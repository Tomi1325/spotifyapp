package com.codecool.spotifyApp.spotify;

import com.codecool.spotifyApp.spotify.author.Author;
import com.codecool.spotifyApp.spotify.author.Singer;
import com.codecool.spotifyApp.spotify.track.Album;
import com.codecool.spotifyApp.spotify.track.Song;
import com.codecool.spotifyApp.spotify.track.Track;

import java.util.ArrayList;
import java.util.List;

public class SpotifyApp {
    private List<Author> authors;

    public SpotifyApp() {
        this.authors = new ArrayList<>();
    }

    public void addAuthors(Author author){
        authors.add(author);
    }

    public List<Song> searchSongByName(String name){
        List<Song> songsWithMatchingName = new ArrayList<>();
        for (Author author : authors) {
            if(author instanceof Singer){
                songsWithMatchingName.addAll(((Singer) author).searchSongByName(name));
            }
        }
        return songsWithMatchingName;
    }

    public List<Track> getPublishedTracks(String name){
        List<Track> allThingsPublished = new ArrayList<>();
        for (Author author : authors) {
            if(author.getName().equals(name)){
                allThingsPublished = author.getAllPublished();
            }
        }
        return allThingsPublished;
    }

    public Song mostListenedSongs(){
        Song songWithMostListens = null;
        int numberOfListens = 0;
        for (Author author : authors) {
            if(author instanceof Singer){
              List<Album> allPublished = ((Singer) author).getAlbumList();
                for (Album album : allPublished) {
                    if(album.getSongWithMostListens().getNumberOfTimesPlayed() > numberOfListens ){
                        songWithMostListens = album.getSongWithMostListens();
                        numberOfListens = album.getSongWithMostListens().getNumberOfTimesPlayed();
                    }
                }
            }
        }
        return songWithMostListens;
    }
}
