package com.examly.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.examly.entity.Library;
import com.examly.util.DBConnectionUtil;


public class LibraryServiceImpl implements LibraryService
{

    @Override
    public String addBooks(Library library) {
        String sqlQUery = "INSERT INTO library (book_id, title, author, genre, availability, publication_year)VALUES (?, ?, ?, ?, ?, ?);";
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQUery);
        )
        {
            preparedStatement.setInt(1, library.getBook_id());
            preparedStatement.setString(2, library.getTitle());
            preparedStatement.setString(3,library.getAuthor());
            preparedStatement.setString(4, library.getGenere());
            preparedStatement.setBoolean(5, library.isAvailability());
            preparedStatement.setInt(6, library.getPublication_year());
            
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0 ? "Books added successfully":"Failed to add Books";
        }
        catch(SQLException e)
        {
            System.out.println("Error on inserting the data");
            return e.toString();
        }
    }

    @Override
    public String updateBooks(Library library) {
        String sqlQUery = "UPDATE library SET title = ?, author = ?, genre = ?, availability = ?, publication_year =  ? WHERE book_id = ?";
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQUery);
        )
        {
            preparedStatement.setString(1, library.getTitle());
            preparedStatement.setString(2,library.getAuthor());
            preparedStatement.setString(3, library.getGenere());
            preparedStatement.setBoolean(4, library.isAvailability());
            preparedStatement.setInt(5, library.getPublication_year());
            preparedStatement.setInt(6, library.getBook_id());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0 ? "Books updated successfully":"Failed to update Books";
        }
        catch(SQLException e)
        {
            System.out.println("Error on updating the data");
            return e.toString();
        }
    }

    @Override
    public String deleteBooks(int book_id) {
        String sqlQuery ="DELETE FROM library WHERE book_id = ?";
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        )
        {
            preparedStatement.setInt(1, book_id);
            int deletedRows = preparedStatement.executeUpdate();
            return deletedRows > 0 ?"Books Deleted Successfully":"Failed to delete the books";
        }
        catch(SQLException e)
        {
            System.out.println("Error on deleting data");
            return e.toString(); 
        }
    }

    @Override
    public List<Library> getAllBooks() {
        String sqlQuery = "SELECT * FROM library";
        List<Library> booksList = new ArrayList<>();
        try
        (
           Connection connection = DBConnectionUtil.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery); 
           ResultSet resultSet = preparedStatement.executeQuery();
        )
        {
            while (resultSet.next()) {
                booksList.add(extractedBooks(resultSet));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error on fetching data : "+e.toString());
        }

        return booksList;
    }

    @Override
    public List<Library> searchByAuthor(String author) {
        String query = "SELECT * FROM library WHERE author = ?";
        List<Library> booksList = new ArrayList<>();
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        )
        {
            preparedStatement.setString(1, author);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                booksList.add(extractedBooks(resultSet));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.toString());
        }
        return booksList;
    }

    @Override
    public List<Library> filterByGenere(String genere) {
       String sqlQuery = "SELECT * FROM library WHERE genre = ?";
       List<Library> booksList = new ArrayList<>();
       try
       (
        Connection connection = DBConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
       )
       {
            preparedStatement.setString(1, genere);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                booksList.add(extractedBooks(resultSet));
            }
       }
       catch(SQLException e)
       {
        System.out.println("Error on fetching data  : "+e.toString());
       }
       return booksList;
    }
    private Library extractedBooks(ResultSet resultSet) throws SQLException
    {
        return new Library(
            resultSet.getInt("book_id"),
            resultSet.getString("title"),
            resultSet.getString("author"),
            resultSet.getString("genre"),
            resultSet.getBoolean("availability"),
            resultSet.getInt("publication_year")
        );
    }
}
