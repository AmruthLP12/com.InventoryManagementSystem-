package com.inventory.ui;

import com.inventory.model.Product;
import com.inventory.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductUI {
    private static ProductService productService;
    private static Scanner scanner;

    // Static initialization block to set up dependencies
    static {
        productService = new ProductService();
        scanner = new Scanner(System.in);
    }

    public static void productMenu() {
        int choice;
        do {
            System.out.println("=== Product Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);
    }

    private static void addProduct() {
        System.out.println("Enter Product Details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Description: ");
        String description = scanner.nextLine();

        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);
        newProduct.setDescription(description);

        productService.addProduct(newProduct);
        System.out.println("Product added successfully.");
    }

    private static void viewAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("=== All Products ===");
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    private static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product existingProduct = productService.getProductById(productId);
        if (existingProduct == null) {
            System.out.println("Product not found with ID: " + productId);
        } else {
            System.out.println("Enter updated details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Description: ");
            String description = scanner.nextLine();

            existingProduct.setName(name);
            existingProduct.setPrice(price);
            existingProduct.setDescription(description);

            productService.updateProduct(existingProduct);
            System.out.println("Product updated successfully.");
        }
    }

    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product existingProduct = productService.getProductById(productId);
        if (existingProduct == null) {
            System.out.println("Product not found with ID: " + productId);
        } else {
            productService.deleteProduct(productId);
            System.out.println("Product deleted successfully.");
        }
    }
}
