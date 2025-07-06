package com.examly.service;

import java.util.List;

import com.examly.entity.Product;

public interface ProductService 
{
    String addProducts(Product product);
    String updateProduct(Product product);
    String deleteproduct(int productId);
    List<Product>viewAllProducts();
    List<Product>searchProductByCategory(String category);
    List<Product>filterProductByQuantity(int quantity);
    List<Product>filterProductByPriceRange(double price);
}
