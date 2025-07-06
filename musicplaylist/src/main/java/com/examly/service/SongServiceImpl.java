package com.examly.service;

import com.examly.entity.Song;
import com.examly.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongServiceImpl implements SongService {

    private Song extractSong(ResultSet rs) throws SQLException {
        return new Song(
            rs.getInt("song_id"),
            rs.getString("title"),
            rs.getString("artist"),
            rs.getString("genre"),
            rs.getInt("release_year")
        );
    }

    @Override
    public String addSong(Song song) {
        String sql = "INSERT INTO music (song_id, title, artist, genre, release_year) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, song.getSongId());
            ps.setString(2, song.getTitle());
            ps.setString(3, song.getArtist());
            ps.setString(4, song.getGenre());
            ps.setInt(5, song.getReleaseYear());
            return ps.executeUpdate() > 0 ? "Song added!" : "Failed to add song.";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String updateSong(Song song) {
        String sql = "UPDATE music SET title = ?, artist = ?, genre = ?, release_year = ? WHERE song_id = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, song.getTitle());
            ps.setString(2, song.getArtist());
            ps.setString(3, song.getGenre());
            ps.setInt(4, song.getReleaseYear());
            ps.setInt(5, song.getSongId());
            return ps.executeUpdate() > 0 ? "Song updated!" : "Failed to update.";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String deleteSong(int songId) {
        String sql = "DELETE FROM music WHERE song_id = ?";
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, songId);
            return ps.executeUpdate() > 0 ? "Song deleted!" : "Failed to delete.";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public List<Song> getAllSongs() {
        String sql = "SELECT * FROM music";
        List<Song> list = new ArrayList<>();
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) list.add(extractSong(rs));
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Song> searchByArtist(String artist) {
        String sql = "SELECT * FROM music WHERE artist = ?";
        List<Song> list = new ArrayList<>();
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, artist);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(extractSong(rs));
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Song> filterByGenre(String genre) {
        String sql = "SELECT * FROM music WHERE genre = ?";
        List<Song> list = new ArrayList<>();
        try (Connection con = DBConnectionUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, genre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(extractSong(rs));
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }
}
