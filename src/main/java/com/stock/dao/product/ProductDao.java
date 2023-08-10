package com.stock.dao.product;

import com.stock.model.Product;

import java.util.List;

// This interface defines methods for interacting with the Product entity in the data access layer
public interface ProductDao {

    // Retrieve a list of all products
    List<Product> getAllProducts();

    // Retrieve a specific product by its ID
    Product getProductById(Long id);

    // Add a new product to the database
    Product addProduct(Product product);

    // Update an existing product in the database
    Product updateProduct(Product product);

    // Delete a product from the database based on its ID
    void deleteProduct(Long id);
}
