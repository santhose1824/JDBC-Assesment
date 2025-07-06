package com.examly.service;


import java.util.List;

import com.examly.entity.Song;


public interface SongService {
    String addSong(Song song);
    String updateSong(Song song);
    String deleteSong(int songId);
    List<Song> getAllSongs();
    List<Song> searchByArtist(String artist);
    List<Song> filterByGenre(String genre);
}
