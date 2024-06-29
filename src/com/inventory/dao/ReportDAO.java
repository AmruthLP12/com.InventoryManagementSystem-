package com.inventory.dao;

import com.inventory.config.DatabaseConfig;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ReportDAO {

    public Map<String, Integer> getProductStockReport() {
        Map<String, Integer> report = new HashMap<>();
        String sql = "SELECT p.name, s.quantity FROM Product p JOIN Stocks s ON p.id = s.product_id";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String productName = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                report.put(productName, quantity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return report;
    }

    public Map<String, Integer> getOrderReport() {
        Map<String, Integer> report = new HashMap<>();
        String sql = "SELECT p.name, SUM(o.quantity) AS total_ordered FROM Orders o JOIN Product p ON o.product_id = p.id GROUP BY p.name";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String productName = resultSet.getString("name");
                int totalOrdered = resultSet.getInt("total_ordered");
                report.put(productName, totalOrdered);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return report;
    }
}
