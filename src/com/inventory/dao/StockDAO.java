package com.inventory.dao;

import com.inventory.model.Stock;
import com.inventory.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockDAO {

    public void addStock(Stock stock) {
        String sql = "INSERT INTO Stocks (product_id, quantity) VALUES (?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, stock.getProductId());
            statement.setInt(2, stock.getQuantity());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Stock> getAllStocks() {
        List<Stock> stocks = new ArrayList<>();
        String sql = "SELECT * FROM Stocks";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Stock stock = new Stock();
                stock.setId(resultSet.getInt("id"));
                stock.setProductId(resultSet.getInt("product_id"));
                stock.setQuantity(resultSet.getInt("quantity"));
                stocks.add(stock);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocks;
    }

    public Stock getStockById(int stockId) {
        Stock stock = null;
        String sql = "SELECT * FROM Stocks WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, stockId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                stock = new Stock();
                stock.setId(resultSet.getInt("id"));
                stock.setProductId(resultSet.getInt("product_id"));
                stock.setQuantity(resultSet.getInt("quantity"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }

    public void updateStock(Stock stock) {
        String sql = "UPDATE Stocks SET product_id = ?, quantity = ? WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, stock.getProductId());
            statement.setInt(2, stock.getQuantity());
            statement.setInt(3, stock.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStock(int stockId) {
        String sql = "DELETE FROM Stocks WHERE id = ?";

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, stockId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
