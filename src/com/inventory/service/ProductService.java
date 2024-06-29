package com.inventory.service;

import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        productDAO = new ProductDAO();
    }

    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productDAO.getProductById(productId);
    }

    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    public void deleteProduct(int productId) {
        productDAO.deleteProduct(productId);
    }
}
