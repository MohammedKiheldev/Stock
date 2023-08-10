package com.stock.service;

import com.stock.dao.pointOfSale.PointOfSaleDao;
import com.stock.dao.product.ProductDao;
import com.stock.dto.pointOfSale.CreatePointOfSaleDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.product.CreateProductDTO;
import com.stock.dto.product.ProductDTO;
import com.stock.dto.product.UpdateProductDTO;
import com.stock.model.PointOfSale;
import com.stock.model.Product;
import com.stock.util.product.ProductUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mock;
import java.util.List; // Import List class
import java.util.ArrayList; // Import ArrayList class

import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductDao productDao;

    @Mock
    private PointOfSaleDao pointOfSaleDao;

    @Mock
    private ProductUtil productUtil;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllProducts() {
        // Prepare mock data
        List<Product> productList = new ArrayList<>();
        List<ProductDTO> dtoList = new ArrayList<>();

        when(productDao.getAllProducts()).thenReturn(productList);
        when(productUtil.convertToDTOs(productList)).thenReturn(dtoList);

        List<ProductDTO> response = productService.getAllProducts();

        assertEquals(dtoList, response);
    }

    @Test
    void testGetProductByIdValidId() {
        Long productId = 1L;
        Product mockProduct = new Product();
        ProductDTO mockDTO = new ProductDTO();

        when(productDao.getProductById(productId)).thenReturn(mockProduct);
        when(productUtil.convertToDTO(mockProduct)).thenReturn(mockDTO);

        ProductDTO response = productService.getProductById(productId);

        assertEquals(mockDTO, response);
    }

    @Test
    void testGetProductByIdInvalidId() {
        Long productId = 1L;

        when(productDao.getProductById(productId)).thenReturn(null);

        ProductDTO response = productService.getProductById(productId);

        assertNull(response);
    }
}
