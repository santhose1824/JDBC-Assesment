package com.example.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil 
{
    private static final String DATABASEURL  = "jdbc:mysql://localhost:3306/student_db";
    private static final String DATABASEUSER = "root";
    private static final String DATABASEPASS = "Password123";
    public static Connection getConnection()
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DATABASEURL, DATABASEUSER, DATABASEPASS);
            System.out.println("Database Connected Successfully");
            return connection;
        } 
        catch (SQLException e) 
        {
           System.out.println("Failed to connect with database");
           return null; 
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Driver Class is not found");
            return null;
        }
    }
}
