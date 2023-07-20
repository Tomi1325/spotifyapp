package com.codecool.spotifyApp.spotify.track;

import com.codecool.spotifyApp.spotify.musicStyle.MusicStyle;

import java.util.ArrayList;
import java.util.List;

public class Album{
    private String name;
    private MusicStyle musicStyle;
    private List<Song> songList;

    public Album(String name, MusicStyle musicStyle) {
        this.name = name;
        this.musicStyle = musicStyle;
        this.songList = new ArrayList<>();
    }

    public void addSong(Song song){
        songList.add(song);
    }

    public Song searchBySongName(String name){
        for (Song song : songList) {
            if(song.getName().equals(name)){
                return song;
            }
        }
        return null;
    }

    public List<Song> getSongList() {
        return songList;
    }
    public Song getSongWithMostListens(){
        Song mostPlayedSong = songList.get(0);
        int maxPlayTime = mostPlayedSong.getNumberOfTimesPlayed();
        for (Song song : songList) {
            if(song.getNumberOfTimesPlayed() > maxPlayTime){
                mostPlayedSong = song;
            }
        }return mostPlayedSong;
    }

}
