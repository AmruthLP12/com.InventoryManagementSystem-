package com.inventory.ui;

import com.inventory.model.Product;
import com.inventory.service.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    BigDecimal price = scanner.nextBigDecimal();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();

                    Product product = new Product();
                    product.setName(name);
                    product.setDescription(description);
                    product.setPrice(price);
                    product.setQuantity(quantity);

                    productService.addProduct(product);
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    List<Product> products = productService.getAllProducts();
                    for (Product p : products) {
                        System.out.println(p.getName() + ": " + p.getDescription() + ", Price: " + p.getPrice() + ", Quantity: " + p.getQuantity());
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
