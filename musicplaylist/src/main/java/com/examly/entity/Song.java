package com.examly.entity;

public class Song {
    private int songId;
    private String title;
    private String artist;
    private String genre;
    private int releaseYear;

    public Song(int songId, String title, String artist, String genre,int releaseYear) {
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }

    public int getSongId() { return songId; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getGenre() { return genre; }
    public int getReleaseYear() { return releaseYear; }

    @Override
    public String toString() {
    return String.format(
        "%-15s : %d\n%-15s : %s\n%-15s : %s\n%-15s : %s\n%-15s : %d",
        "Song ID", songId,
        "Title", title,
        "Artist", artist,
        "Genre", genre,
        "Release Year", releaseYear
    );
  }

}
