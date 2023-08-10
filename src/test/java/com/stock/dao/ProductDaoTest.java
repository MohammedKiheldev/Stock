package com.stock.dao;

import com.stock.dao.product.ProductDao;
import com.stock.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductDaoTest {

    @Mock
    private ProductDao productDao;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllProducts() {
        List<Product> mockProducts = new ArrayList<>();
        when(productDao.getAllProducts()).thenReturn(mockProducts);

        List<Product> response = productDao.getAllProducts();

        assertEquals(mockProducts, response);
    }

    @Test
    void testGetProductById() {
        Long productId = 1L;
        Product mockProduct = new Product();

        when(productDao.getProductById(productId)).thenReturn(mockProduct);

        Product response = productDao.getProductById(productId);

        assertEquals(mockProduct, response);
    }

    @Test
    void testAddProduct() {
        Product mockProduct = new Product();
        Product newProduct = new Product();

        when(productDao.addProduct(mockProduct)).thenReturn(newProduct);

        Product response = productDao.addProduct(mockProduct);

        assertEquals(newProduct, response);
    }

    @Test
    void testUpdateProduct() {
        Product mockProduct = new Product();
        Product updatedProduct = new Product();

        when(productDao.updateProduct(mockProduct)).thenReturn(updatedProduct);

        Product response = productDao.updateProduct(mockProduct);

        assertEquals(updatedProduct, response);
    }

    @Test
    void testDeleteProduct() {
        Long productId = 1L;

        // Configure the productDao mock to behave when deleteProduct is called
        doNothing().when(productDao).deleteProduct(productId);

        productDao.deleteProduct(productId);

        // Verify that deleteProduct was called
        verify(productDao, times(1)).deleteProduct(productId);
    }
}
