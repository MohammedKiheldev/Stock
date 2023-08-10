package com.stock.dao.product;

import com.stock.model.Product;
import com.stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

// This class implements the ProductDao interface and interacts with the database
@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    // Retrieve a list of all products from the database
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Retrieve a specific product by its ID from the database
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
    }

    // Add a new product to the database
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product in the database
    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete a product from the database based on its ID
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
