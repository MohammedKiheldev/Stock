package com.stock.util;

import com.stock.dto.pointOfSale.CreatePointOfSaleDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.model.PointOfSale;
import com.stock.util.pointOfSale.PointOfSaleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PointOfSaleUtilTest {

    @Mock
    private PointOfSaleUtil pointOfSaleUtil;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testConvertToDTOs() {
        List<PointOfSale> mockPointsOfSale = new ArrayList<>();
        List<PointOfSaleDTO> mockDTOs = new ArrayList<>();

        when(pointOfSaleUtil.convertToDTOs(mockPointsOfSale)).thenReturn(mockDTOs);

        List<PointOfSaleDTO> response = pointOfSaleUtil.convertToDTOs(mockPointsOfSale);

        assertEquals(mockDTOs, response);
    }

    @Test
    void testConvertToDTO() {
        PointOfSale mockPointOfSale = new PointOfSale();
        PointOfSaleDTO mockDTO = new PointOfSaleDTO();

        when(pointOfSaleUtil.convertToDTO(mockPointOfSale)).thenReturn(mockDTO);

        PointOfSaleDTO response = pointOfSaleUtil.convertToDTO(mockPointOfSale);

        assertEquals(mockDTO, response);
    }

    @Test
    void testConvertToEntityFromCreateDTO() {
        CreatePointOfSaleDTO mockCreateDTO = new CreatePointOfSaleDTO();
        PointOfSale mockPointOfSale = new PointOfSale();

        when(pointOfSaleUtil.convertToEntity(mockCreateDTO)).thenReturn(mockPointOfSale);

        PointOfSale response = pointOfSaleUtil.convertToEntity(mockCreateDTO);

        assertEquals(mockPointOfSale, response);
    }

    @Test
    void testConvertToEntityFromDTO() {
        PointOfSaleDTO mockDTO = new PointOfSaleDTO();
        PointOfSale mockPointOfSale = new PointOfSale();

        when(pointOfSaleUtil.convertToEntity(mockDTO)).thenReturn(mockPointOfSale);

        PointOfSale response = pointOfSaleUtil.convertToEntity(mockDTO);

        assertEquals(mockPointOfSale, response);
    }

    // Add more test cases as needed
}
