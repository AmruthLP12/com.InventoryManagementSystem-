package com.inventory.ui;

import com.inventory.model.Order;
import com.inventory.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderUI {
    private static OrderService orderService = new OrderService();
    private static Scanner scanner = new Scanner(System.in);

    public static void orderMenu() {
        while (true) {
            System.out.println("Order Management");
            System.out.println("1. Add Order");
            System.out.println("2. View All Orders");
            System.out.println("3. Update Order");
            System.out.println("4. Delete Order");
            System.out.println("5. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    viewAllOrders();
                    break;
                case 3:
                    updateOrder();
                    break;
                case 4:
                    deleteOrder();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addOrder() {
        System.out.println("Enter product ID: ");
        int productId = scanner.nextInt();
        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.println("Enter order date (yyyy-mm-dd): ");
        String dateStr = scanner.next();
        Date orderDate = java.sql.Date.valueOf(dateStr);

        Order order = new Order(productId, quantity, orderDate);
        orderService.addOrder(order);

        System.out.println("Order added successfully!");
    }

    private static void viewAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        System.out.println("All Orders:");
        for (Order order : orders) {
            System.out.println("ID: " + order.getId() + ", Product ID: " + order.getProductId() +
                    ", Quantity: " + order.getQuantity() + ", Date: " + order.getOrderDate());
        }
    }

    private static void updateOrder() {
        System.out.println("Enter order ID to update: ");
        int orderId = scanner.nextInt();
        Order order = orderService.getOrderById(orderId);

        if (order != null) {
            System.out.println("Enter new product ID: ");
            int productId = scanner.nextInt();
            System.out.println("Enter new quantity: ");
            int quantity = scanner.nextInt();
            System.out.println("Enter new order date (yyyy-mm-dd): ");
            String dateStr = scanner.next();
            Date orderDate = java.sql.Date.valueOf(dateStr);

            order.setProductId(productId);
            order.setQuantity(quantity);
            order.setOrderDate(orderDate);

            orderService.updateOrder(order);

            System.out.println("Order updated successfully!");
        } else {
            System.out.println("Order not found.");
        }
    }

    private static void deleteOrder() {
        System.out.println("Enter order ID to delete: ");
        int orderId = scanner.nextInt();

        orderService.deleteOrder(orderId);
        System.out.println("Order deleted successfully!");
    }
}
