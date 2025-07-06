package com.examly;

import com.examly.entity.Song;
import com.examly.service.SongService;
import com.examly.service.SongServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SongService songService = new SongServiceImpl();
        int choice;

        do {
            System.out.println("Music Playlist Management");
            System.out.println("1) Add Song");
            System.out.println("2) Update Song");
            System.out.println("3) Delete Song");
            System.out.println("4) View All Songs");
            System.out.println("5) Search Songs by Artist");
            System.out.println("6) Filter Songs by Genre");
            System.out.println("7) Filter Songs by Duration");
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1 -> addSong(input, songService);
                case 2 -> updateSong(input, songService);
                case 3 -> deleteSong(input, songService);
                case 4 -> viewSongs(songService);
                case 5 -> searchByArtist(input, songService);
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void addSong(Scanner input, SongService service) {
        System.out.print("Enter Song ID: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Enter Title: ");
        String title = input.nextLine();
        System.out.print("Enter Artist: ");
        String artist = input.nextLine();
        System.out.print("Enter Genre: ");
        String genre = input.nextLine();
        System.out.print("Enter Release Year: ");
        int year = Integer.parseInt(input.nextLine());

        Song song = new Song(id, title, artist, genre, year);
        System.out.println(service.addSong(song));
    }

    private static void updateSong(Scanner input, SongService service) {
        System.out.print("Enter Song ID to update: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Enter New Title: ");
        String title = input.nextLine();
        System.out.print("Enter New Artist: ");
        String artist = input.nextLine();
        System.out.print("Enter New Genre: ");
        String genre = input.nextLine();
        System.out.print("Enter New Release Year: ");
        int year = Integer.parseInt(input.nextLine());

        Song song = new Song(id, title, artist, genre, year);
        System.out.println(service.updateSong(song));
    }

    private static void deleteSong(Scanner input, SongService service) {
        System.out.print("Enter Song ID to delete: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println(service.deleteSong(id));
    }

    private static void viewSongs(SongService service) {
        List<Song> songs = service.getAllSongs();
        songs.forEach(System.out::println);
    }

    private static void searchByArtist(Scanner input, SongService service) {
        System.out.print("Enter Artist Name: ");
        String artist = input.nextLine();
        List<Song> songs = service.searchByArtist(artist);
        songs.forEach(System.out::println);
    }


}
