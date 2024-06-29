package com.inventory.service;

import com.inventory.dao.StockDAO;
import com.inventory.model.Stock;

import java.util.List;

public class StockService {
    private StockDAO stockDAO;

    public StockService() {
        stockDAO = new StockDAO();
    }

    public void addStock(Stock stock) {
        stockDAO.addStock(stock);
    }

    public List<Stock> getAllStocks() {
        return stockDAO.getAllStocks();
    }

    public Stock getStockById(int stockId) {
        return stockDAO.getStockById(stockId);
    }

    public void updateStock(Stock stock) {
        stockDAO.updateStock(stock);
    }

    public void deleteStock(int stockId) {
        stockDAO.deleteStock(stockId);
    }
}
