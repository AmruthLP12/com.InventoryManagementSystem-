package com.inventory.dao;

import com.inventory.model.Order;
import com.inventory.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public void addOrder(Order order) {
        String sql = "INSERT INTO Orders (product_id, quantity, order_date) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, order.getProductId());
            statement.setInt(2, order.getQuantity());
            statement.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM Orders";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setProductId(resultSet.getInt("product_id"));
                order.setQuantity(resultSet.getInt("quantity"));
                order.setOrderDate(resultSet.getDate("order_date"));
                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order getOrderById(int orderId) {
        Order order = null;
        String sql = "SELECT * FROM Orders WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setProductId(resultSet.getInt("product_id"));
                order.setQuantity(resultSet.getInt("quantity"));
                order.setOrderDate(resultSet.getDate("order_date"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public void updateOrder(Order order) {
        String sql = "UPDATE Orders SET product_id = ?, quantity = ?, order_date = ? WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, order.getProductId());
            statement.setInt(2, order.getQuantity());
            statement.setDate(3, new java.sql.Date(order.getOrderDate().getTime()));
            statement.setInt(4, order.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(int orderId) {
        String sql = "DELETE FROM Orders WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, orderId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
