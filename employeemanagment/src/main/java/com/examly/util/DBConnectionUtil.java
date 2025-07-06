package com.examly.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil 
{
    private static String DATABASEURL      = "jdbc:mysql://localhost:3306/assesmet";
    private static String DATABASEUSER     = "root";
    private static String DATABASEPASSWORD = "Password123";
    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DATABASEURL, DATABASEUSER, DATABASEPASSWORD);
            System.out.println("Database Connected Successfully !!");
            return connection;
        }
        catch(SQLException e)
        {
            System.out.println("Error on connecting to Database");
            System.out.println(e.toString());
            return null;
        }  
        catch(ClassNotFoundException e)
        {
            System.out.println("Driver Class is not found");
            System.out.println(e.toString());
            return null;
        }
    }
}
