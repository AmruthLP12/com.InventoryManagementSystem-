package com.inventory.service;

import com.inventory.dao.ReportDAO;

import java.util.Map;

public class ReportService {
    private ReportDAO reportDAO;

    public ReportService() {
        reportDAO = new ReportDAO();
    }

    public Map<String, Integer> getProductStockReport() {
        return reportDAO.getProductStockReport();
    }

    public Map<String, Integer> getOrderReport() {
        return reportDAO.getOrderReport();
    }
}
