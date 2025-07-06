package com.examly.service;

import java.util.List;

import com.examly.entity.Library;

public interface LibraryService 
{
    String addBooks(Library library);
    String updateBooks(Library library);
    String deleteBooks(int book_id);
    List<Library>getAllBooks();
    List<Library>searchByAuthor(String author);
    List<Library>filterByGenere(String genere);
}
