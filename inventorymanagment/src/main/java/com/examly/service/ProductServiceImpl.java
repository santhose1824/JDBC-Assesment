package com.examly.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examly.entity.Product;
import com.examly.util.DBConnectionUtil;

public class ProductServiceImpl  implements ProductService
{

    @Override
    public String addProducts(Product product) {
        String sqlQuery = "INSERT INTO product (product_id,name,category,quantity,price,isStock) VALUES(?,?,?,?,?,?)";
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        )
        {
            preparedStatement.setInt(1, product.getProduct_id());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getCategory());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setDouble(5, product.getPrice());
            preparedStatement.setBoolean(6, product.getInStock());

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0 ? "Product Data added Successfully" :"Failed to add {roduct} Data";

        } 
        catch(SQLException e)
        {
            System.out.println("Error on inserting the data : ");
            return e.toString();
        }

    }

    @Override
    public String updateProduct(Product product) {
        String sqlQuery = "UPDATE product SET name = ?, category = ?, quantity = ?, price = ?, isStock = ? WHERE product_id = ?";
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        )
        {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getCategory());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setBoolean(5, product.getInStock());
            preparedStatement.setInt(6, product.getProduct_id());

            int rowsUpdated = preparedStatement.executeUpdate();

            return rowsUpdated > 0 ? "Product Data updated Successfully" :"Failed to updtae product Data";

        } 
        catch(SQLException e)
        {
            System.out.println("Error on updating the data : ");
            return e.toString();
        }
    }

    @Override
    public String deleteproduct(int productId) {
        String sqlQuery = "DELETE FROM product WHERE product_id = ?";
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        )
        {
            preparedStatement.setInt(1, productId);
            

            int rowsDeleted = preparedStatement.executeUpdate();

            return rowsDeleted > 0 ? "Product Data deleted Successfully" :"Failed to delete Product Data";

        } 
        catch(SQLException e)
        {
            System.out.println("Error on deleting the data : ");
            return e.toString();
        }

    }

    @Override
    public List<Product> viewAllProducts() {
         String sqlQuery = "SELECT * from product";
        List<Product> productsList = new ArrayList<>();
        try
        (
            Connection connection = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
        )
        {
            while (resultSet.next()) {
                productsList.add(extractEmployeeData(resultSet));
            }
        } 
        catch(SQLException e)
        {
            System.out.println("Error on fetching the data : ");
        }
        return productsList;

    }

    @Override
    public List<Product> searchProductByCategory(String category) {
       String query = "SELECT * from product WHERE category = ?";
       List<Product>productList = new ArrayList<>();
       try
       (
        Connection connection = DBConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
       )
       {
        preparedStatement.setString(1, category);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            productList.add(extractEmployeeData(resultSet));
        }
       }
       catch(SQLException e)
       {
        System.out.println(e.toString());
       }
       return productList;
    }

    @Override
    public List<Product> filterProductByQuantity(int quantity) {
               String query = "SELECT * from product WHERE quantity = ?";
       List<Product>productList = new ArrayList<>();
       try
       (
        Connection connection = DBConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
       )
       {
        preparedStatement.setInt(1, quantity);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            productList.add(extractEmployeeData(resultSet));
        }
       }
       catch(SQLException e)
       {
        System.out.println(e.toString());
       }
       return productList;
    }

    @Override
    public List<Product> filterProductByPriceRange(double price) {
       String query = "SELECT * from product WHERE price > ?";
       List<Product>productList = new ArrayList<>();
       try
       (
        Connection connection = DBConnectionUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
       )
       {
        preparedStatement.setDouble(1, price);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            productList.add(extractEmployeeData(resultSet));
        }
       }
       catch(SQLException e)
       {
        System.out.println(e.toString());
       }
       return productList;
    }


     private Product extractEmployeeData(ResultSet resultSet) throws SQLException
    {
        return new Product(
            resultSet.getInt("product_id"),
            resultSet.getString("name"),
            resultSet.getString("category"),
            resultSet.getInt("quantity"),
            resultSet.getDouble("price"),
            resultSet.getBoolean("isStock")
        );
    }


}
