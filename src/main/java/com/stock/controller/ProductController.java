// Import necessary classes and packages
package com.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.stock.dto.product.CreateProductDTO;
import com.stock.dto.product.ProductDTO;
import com.stock.dto.product.UpdateProductDTO;
import com.stock.service.ProductService;
import java.util.List;

// Declare this class as a RestController and map it to the "/product" route
@RestController
@RequestMapping("/product")
public class ProductController {

    // Automatically inject the ProductService dependency
    @Autowired
    private ProductService productService;

    // Handle HTTP GET request to retrieve all products
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Handle HTTP GET request to retrieve a product by its ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO product = productService.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Handle HTTP POST request to create a new product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody CreateProductDTO createProductDTO) {
        ProductDTO newProduct = productService.createProduct(createProductDTO);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    // Handle HTTP PUT request to update an existing product by its ID
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody UpdateProductDTO updateProductDTO) {
        ProductDTO updatedProduct = productService.updateProduct(id, updateProductDTO);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Handle HTTP DELETE request to delete a product by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean success = productService.deleteProduct(id);
        if (success) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
