package com.examly.entity;

public class Library 
{
    private int book_id;
    private String title;
    private String author;
    private String genere;
    private boolean availability;
    private int publication_year;

    public Library(int book_id, String title, String author, String genere, boolean availability,int publication_year) 
    {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.genere = genere;
        this.availability = availability;
        this.publication_year = publication_year;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(int publication_year) {
        this.publication_year = publication_year;
    }

    @Override
    public String toString() {
    return String.format(
        "%-15s : %d\n%-15s : %s\n%-15s : %s\n%-15s : %s\n%-15s : %s\n%-15s : %d",
        "Book Id", book_id,
        "Book Title", title,
        "Book Author", author,
        "Book Genre", genere,
        "Availability", availability,
        "Publication Year", publication_year
      );
    }
    
    
}
