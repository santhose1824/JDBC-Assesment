package com.examly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.examly.entity.Product;
import com.examly.service.ProductService;
import com.examly.service.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        ProductService  productService = new ProductServiceImpl();
        int choice;
        do
        {
            System.out.println("product Management");
            System.out.println("-------------------------");
            System.out.println("1) Add product");
            System.out.println("2) Update product");
            System.out.println("3) Delete product");
            System.out.println("4) View product");
            System.out.println("5) Search product by Category");
            System.out.println("6) Filter product by quantity");
            System.out.println("7) Filter product by price range ");
            System.out.println("0) Exit");
            System.out.println("--------------------------------");
            System.out.println("Enter your choice");
            choice = Integer.parseInt(input.nextLine());
            switch(choice)
            {
                case 1 -> addProduct(input, productService);
                case 2 -> updateProduct(input, productService);
                case 3 -> deleteProduct(input, productService);
                case 4 -> getAllProducts(productService);
                case 5 -> searchByCategory(input, productService);
                case 6 -> filterByProductQuantity(input, productService);
                case 7 -> filteByProductPrice(input, productService);
                case 0 -> System.out.println("System exit");
                default -> System.out.println("Invalid Choice");
            }
        }
        while(choice!=0);
    }

    private static void addProduct(Scanner input,ProductService service)
    {
        System.out.println("Enter the product Id : ");
        int String = Integer.parseInt(input.nextLine());
        System.out.println("Enter the  product Name : ");
        String name = input.nextLine();
        System.out.println("Enter the product Category : ");
        String category = input.nextLine();
        System.out.println("Enter the product quantity : ");
        int quantity = Integer.parseInt(input.nextLine());
        System.out.println("Enter the product price : ");
        double price = Double.parseDouble(input.nextLine());
        System.out.println("In stock or not (true/false) : ");
        boolean inStock = Boolean.parseBoolean(input.nextLine());
        Product product = new Product(String, name, category, quantity, price, inStock);
        String result = service.addProducts(product);
        System.out.println(result);
    }

    private static void updateProduct(Scanner input,ProductService service)
    {
        System.out.println("Enter the product Id : ");
        int String = Integer.parseInt(input.nextLine());
        System.out.println("Enter the new product Name : ");
        String name = input.nextLine();
        System.out.println("Enter the new product Category : ");
        String category = input.nextLine();
        System.out.println("Enter the new product quantity : ");
        int quantity = Integer.parseInt(input.nextLine());
        System.out.println("Enter the product new price : ");
        double price = Double.parseDouble(input.nextLine());
        System.out.println("In stock or not (true/false) : ");
        boolean inStock = Boolean.parseBoolean(input.nextLine());
        Product product = new Product(String, name, category, quantity, price, inStock);
        String result = service.updateProduct(product);
        System.out.println(result);
    }

    private static void deleteProduct(Scanner input, ProductService service)
    {
        System.out.println("Enter the product Id to delete : ");
        int productId = Integer.parseInt(input.nextLine());

        String result = service.deleteproduct(productId);

        System.out.println(result);
    }

    private static void getAllProducts(ProductService service)
    {
        List<Product> productList = new ArrayList<>();
        productList = service.viewAllProducts();
        if(productList.isEmpty())
        {
            System.out.println("No records is table");
        }
        else
        {
            productList.forEach(System.out::println);
        }
    }

    private static void searchByCategory(Scanner input, ProductService service)
    {
        List<Product> productList = new ArrayList<>();
        System.out.println("Enter the category :");
        String category = input.nextLine();
        productList = service.searchProductByCategory(category);
        if(productList.isEmpty())
        {
            System.out.println("There is not record found ...");
        }
        else
        {
            productList.forEach(System.out::println);
        }
    }

    private static void filterByProductQuantity(Scanner input, ProductService service)
    {
        List<Product> productsList = new ArrayList<>();
        System.out.println("Enter the quantity : ");
        int quantity = Integer.parseInt(input.nextLine());
        productsList = service.filterProductByQuantity(quantity);
        if(productsList.isEmpty())
        {
            System.out.println("There is no record found ...");
        }
        else
        {
            productsList.forEach(System.out::println);
        }
    }
    private static void filteByProductPrice(Scanner input,ProductService service)
    {
        List<Product> productList = new ArrayList<>();
        System.out.println("Enter the product price : ");
        double price = Double.parseDouble(input.nextLine());
        productList = service.filterProductByPriceRange(price);
        if(productList.isEmpty())
        {
            System.out.println("There is no record found..");
        }
        else
        {
            productList.forEach(System.out::println);
        }
    }

}