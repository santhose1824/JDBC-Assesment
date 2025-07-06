package com.examly.entity;

public class Product {
    private int product_id;
    private String name;
    private String category;
    private int quantity;
    private double price;
    private boolean inStock;

    public Product(int product_id, String name, String category, int quantity, double price,boolean inStock) {
        this.product_id = product_id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.inStock = inStock;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getInStock()
    {
        return inStock;
    }
    
    public void setInStock(boolean isInStock)
    {
        this.inStock = isInStock;
    }

    @Override
    public String toString() {
    return String.format(
        "%-15s : %s\n%-15s : %s\n%-15s : %s\n%-15s : %d\n%-15s : %.2f\n%-15s : %s",
        "Product ID", product_id,
        "Name", name,
        "Category", category,
        "Quantity", quantity,
        "Price", price,
        "In Stock", inStock
    );
  }
}
