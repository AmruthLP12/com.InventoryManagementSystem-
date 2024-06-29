package com.inventory.ui;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        int choice;
        do {
            System.out.println("=== Inventory Management System ===");
            System.out.println("1. Product Management");
            System.out.println("2. Stock Management");
            System.out.println("3. Order Management");
            System.out.println("4. Report Management");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    ProductUI.productMenu();
                    break;
                case 2:
                    StockUI.stockMenu();
                    break;
                case 3:
                    OrderUI.orderMenu();
                    break;
                case 4:
                    ReportUI.reportMenu();
                    break;
                case 5:
                    System.out.println("Exiting Inventory Management System...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
