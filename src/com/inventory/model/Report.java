package com.inventory.model;

public class Report {
    private String productName;
    private int quantity;
    private String reportType;

    public Report() {}

    public Report(String productName, int quantity, String reportType) {
        this.productName = productName;
        this.quantity = quantity;
        this.reportType = reportType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    @Override
    public String toString() {
        return "Report{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", reportType='" + reportType + '\'' +
                '}';
    }
}
