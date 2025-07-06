package com.examly;

import com.examly.entity.Library;
import com.examly.service.LibraryService;
import com.examly.service.LibraryServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LibraryService libraryService = new LibraryServiceImpl();
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("-----------------------------");
            System.out.println("1) Add Book");
            System.out.println("2) Update Book");
            System.out.println("3) Delete Book");
            System.out.println("4) View All Books");
            System.out.println("5) Search Book by Author");
            System.out.println("6) Filter Book by Genre");
            System.out.println("0) Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1 -> addBook(input, libraryService);
                case 2 -> updateBook(input, libraryService);
                case 3 -> deleteBook(input, libraryService);
                case 4 -> viewAllBooks(libraryService);
                case 5 -> searchByAuthor(input, libraryService);
                case 6 -> filterByGenre(input, libraryService);
                case 0 -> System.out.println("Exiting system.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private static void addBook(Scanner input, LibraryService service) {
        System.out.print("Enter Book ID: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Enter Title: ");
        String title = input.nextLine();
        System.out.print("Enter Author: ");
        String author = input.nextLine();
        System.out.print("Enter Genre: ");
        String genre = input.nextLine();
        System.out.print("Is Available (true/false): ");
        boolean availability = Boolean.parseBoolean(input.nextLine());
        System.out.print("Enter Publication Year: ");
        int year = Integer.parseInt(input.nextLine());

        Library book = new Library(id, title, author, genre, availability, year);
        System.out.println(service.addBooks(book));
    }

    private static void updateBook(Scanner input, LibraryService service) {
        System.out.print("Enter Book ID to Update: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.print("Enter New Title: ");
        String title = input.nextLine();
        System.out.print("Enter New Author: ");
        String author = input.nextLine();
        System.out.print("Enter New Genre: ");
        String genre = input.nextLine();
        System.out.print("Is Available (true/false): ");
        boolean availability = Boolean.parseBoolean(input.nextLine());
        System.out.print("Enter New Publication Year: ");
        int year = Integer.parseInt(input.nextLine());

        Library book = new Library(id, title, author, genre, availability, year);
        System.out.println(service.updateBooks(book));
    }

    private static void deleteBook(Scanner input, LibraryService service) {
        System.out.print("Enter Book ID to Delete: ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println(service.deleteBooks(id));
    }

    private static void viewAllBooks(LibraryService service) {
        List<Library> books = service.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void searchByAuthor(Scanner input, LibraryService service) {
        System.out.print("Enter Author Name: ");
        String author = input.nextLine();
        List<Library> books = service.searchByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No books found for author: " + author);
        } else {
            books.forEach(System.out::println);
        }
    }

    private static void filterByGenre(Scanner input, LibraryService service) {
        System.out.print("Enter Genre to Filter: ");
        String genre = input.nextLine();
        List<Library> books = service.filterByGenere(genre);
        if (books.isEmpty()) {
            System.out.println("No books found in genre: " + genre);
        } else {
            books.forEach(System.out::println);
        }
    }
}
