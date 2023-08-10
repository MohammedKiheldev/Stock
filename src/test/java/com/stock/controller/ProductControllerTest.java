package com.stock.controller;

import com.stock.dto.product.CreateProductDTO;
import com.stock.dto.product.ProductDTO;
import com.stock.dto.product.UpdateProductDTO;
import com.stock.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService; // Mock of ProductService

    @InjectMocks
    private ProductController productController; // Instance of ProductController with injected mocks

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this); // Initialize the mocks
    }

    @Test
    void testGetAllProducts() {
        // Prepare mock data
        List<ProductDTO> productList = new ArrayList<>();
        when(productService.getAllProducts()).thenReturn(productList);

        // Call the controller method
        ResponseEntity<List<ProductDTO>> response = productController.getAllProducts();

        // Compare the expected and actual results
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productList, response.getBody());
    }

    @Test
    void testGetProductById() {
        Long productId = 1L;
        ProductDTO productDTO = new ProductDTO();
        when(productService.getProductById(productId)).thenReturn(productDTO);

        ResponseEntity<ProductDTO> response = productController.getProductById(productId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productDTO, response.getBody());
    }

    @Test
    void testCreateProduct() {
        CreateProductDTO createProductDTO = new CreateProductDTO();
        ProductDTO newProduct = new ProductDTO();
        when(productService.createProduct(createProductDTO)).thenReturn(newProduct);

        ResponseEntity<ProductDTO> response = productController.createProduct(createProductDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newProduct, response.getBody());
    }

    @Test
    void testUpdateProduct() {
        Long productId = 1L;
        UpdateProductDTO updateProductDTO = new UpdateProductDTO();
        ProductDTO updatedProduct = new ProductDTO();
        when(productService.updateProduct(eq(productId), any(UpdateProductDTO.class))).thenReturn(updatedProduct);

        ResponseEntity<ProductDTO> response = productController.updateProduct(productId, updateProductDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProduct, response.getBody());
    }

    @Test
    void testDeleteProduct() {
        Long productId = 1L;
        when(productService.deleteProduct(productId)).thenReturn(true);

        ResponseEntity<Void> response = productController.deleteProduct(productId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
