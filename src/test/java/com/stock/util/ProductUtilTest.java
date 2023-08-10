package com.stock.util;

import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.product.CreateProductDTO;
import com.stock.dto.product.ProductDTO;
import com.stock.model.PointOfSale;
import com.stock.model.Product;
import com.stock.util.product.ProductUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductUtilTest {

    @Mock
    private ProductUtil productUtil;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testConvertToDTOs() {
        List<Product> mockProducts = new ArrayList<>();
        List<ProductDTO> mockDTOs = new ArrayList<>();

        when(productUtil.convertToDTOs(mockProducts)).thenReturn(mockDTOs);

        List<ProductDTO> response = productUtil.convertToDTOs(mockProducts);

        assertEquals(mockDTOs, response);
    }

    @Test
    void testConvertToDTO() {
        Product mockProduct = new Product();
        ProductDTO mockDTO = new ProductDTO();

        when(productUtil.convertToDTO(mockProduct)).thenReturn(mockDTO);

        ProductDTO response = productUtil.convertToDTO(mockProduct);

        assertEquals(mockDTO, response);
    }

    @Test
    void testConvertToEntityFromCreateDTO() {
        CreateProductDTO mockCreateDTO = new CreateProductDTO();
        Product mockProduct = new Product();

        when(productUtil.convertToEntity(mockCreateDTO)).thenReturn(mockProduct);

        Product response = productUtil.convertToEntity(mockCreateDTO);

        assertEquals(mockProduct, response);
    }

    @Test
    void testConvertToDTOFromPointOfSale() {
        PointOfSaleDTO mockPointOfSaleDTO = new PointOfSaleDTO();
        PointOfSale mockPointOfSale = new PointOfSale();

        when(productUtil.convertToDTO(mockPointOfSale)).thenReturn(mockPointOfSaleDTO);

        PointOfSaleDTO response = productUtil.convertToDTO(mockPointOfSale);

        assertEquals(mockPointOfSaleDTO, response);
    }

    @Test
    void testConvertToEntityFromPointOfSaleDTO() {
        PointOfSaleDTO mockPointOfSaleDTO = new PointOfSaleDTO();
        PointOfSale mockPointOfSale = new PointOfSale();

        when(productUtil.convertToEntity(mockPointOfSaleDTO)).thenReturn(mockPointOfSale);

        PointOfSale response = productUtil.convertToEntity(mockPointOfSaleDTO);

        assertEquals(mockPointOfSale, response);
    }

    @Test
    void testGenerateProductCode() {
        Long mockCode = 123456L;

        when(productUtil.genererCodeProduit()).thenReturn(mockCode);

        Long response = productUtil.genererCodeProduit();

        assertEquals(mockCode, response);
    }

    // Add more test cases as needed
}
