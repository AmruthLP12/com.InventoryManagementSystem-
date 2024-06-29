package com.inventory.ui;

import com.inventory.model.Stock;
import com.inventory.service.StockService;

import java.util.List;
import java.util.Scanner;

public class StockUI {
    private static StockService stockService = new StockService();
    private static Scanner scanner = new Scanner(System.in);

    public static void stockMenu() {
        while (true) {
            System.out.println("Stock Management");
            System.out.println("1. Add Stock");
            System.out.println("2. View All Stocks");
            System.out.println("3. Update Stock");
            System.out.println("4. Delete Stock");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStock();
                    break;
                case 2:
                    viewAllStocks();
                    break;
                case 3:
                    updateStock();
                    break;
                case 4:
                    deleteStock();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStock() {
        System.out.println("Enter product ID: ");
        int productId = scanner.nextInt();
        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();

        Stock stock = new Stock(productId, quantity);
        stockService.addStock(stock);

        System.out.println("Stock added successfully!");
    }

    private static void viewAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        System.out.println("All Stocks:");
        for (Stock stock : stocks) {
            System.out.println("ID: " + stock.getId() + ", Product ID: " + stock.getProductId() +
                    ", Quantity: " + stock.getQuantity());
        }
    }

    private static void updateStock() {
        System.out.println("Enter stock ID to update: ");
        int stockId = scanner.nextInt();
        Stock stock = stockService.getStockById(stockId);

        if (stock != null) {
            System.out.println("Enter new product ID: ");
            int productId = scanner.nextInt();
            System.out.println("Enter new quantity: ");
            int quantity = scanner.nextInt();

            stock.setProductId(productId);
            stock.setQuantity(quantity);

            stockService.updateStock(stock);

            System.out.println("Stock updated successfully!");
        } else {
            System.out.println("Stock not found.");
        }
    }

    private static void deleteStock() {
        System.out.println("Enter stock ID to delete: ");
        int stockId = scanner.nextInt();

        stockService.deleteStock(stockId);
        System.out.println("Stock deleted successfully!");
    }
}
