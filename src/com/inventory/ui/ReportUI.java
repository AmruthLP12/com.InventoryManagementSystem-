package com.inventory.ui;

import com.inventory.service.ReportService;

import java.util.Map;
import java.util.Scanner;

public class ReportUI {
    private static ReportService reportService = new ReportService();
    private static Scanner scanner = new Scanner(System.in);

    public static void reportMenu() {
        while (true) {
            System.out.println("Report Management");
            System.out.println("1. View Product Stock Report");
            System.out.println("2. View Order Report");
            System.out.println("3. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewProductStockReport();
                    break;
                case 2:
                    viewOrderReport();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void viewProductStockReport() {
        Map<String, Integer> report = reportService.getProductStockReport();
        System.out.println("Product Stock Report:");
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            System.out.println("Product: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }

    private static void viewOrderReport() {
        Map<String, Integer> report = reportService.getOrderReport();
        System.out.println("Order Report:");
        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            System.out.println("Product: " + entry.getKey() + ", Total Ordered: " + entry.getValue());
        }
    }
}
