package com.stock.controller;

import com.stock.dto.pointOfSale.CreatePointOfSaleDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.pointOfSale.UpdatePointOfSaleDTO;
import com.stock.service.PointOfSaleService;

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

class PointOfSaleControllerTest {

    @Mock
    private PointOfSaleService pointOfSaleService; // Mock of PointOfSaleService

    @InjectMocks
    private PointOfSaleController pointOfSaleController; // Instance of PointOfSaleController with injected mocks

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this); // Initialize the mocks
    }

    @Test
    void testGetAllPointsOfSale() {
        // Prepare mock data
        List<PointOfSaleDTO> pointOfSaleList = new ArrayList<>();
        when(pointOfSaleService.getAllPointsOfSale()).thenReturn(pointOfSaleList);

        // Call the controller method
        ResponseEntity<List<PointOfSaleDTO>> response = pointOfSaleController.getAllPointsOfSale();

        // Compare the expected and actual results
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pointOfSaleList, response.getBody());
    }

    @Test
    void testGetPointOfSaleById() {
        Long pointOfSaleId = 1L;
        PointOfSaleDTO pointOfSaleDTO = new PointOfSaleDTO();
        when(pointOfSaleService.getPointOfSaleById(pointOfSaleId)).thenReturn(pointOfSaleDTO);

        ResponseEntity<PointOfSaleDTO> response = pointOfSaleController.getPointOfSaleById(pointOfSaleId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(pointOfSaleDTO, response.getBody());
    }

    @Test
    void testCreatePointOfSale() {
        CreatePointOfSaleDTO createPointOfSaleDTO = new CreatePointOfSaleDTO();
        PointOfSaleDTO newPointOfSale = new PointOfSaleDTO();
        when(pointOfSaleService.createPointOfSale(createPointOfSaleDTO)).thenReturn(newPointOfSale);

        ResponseEntity<PointOfSaleDTO> response = pointOfSaleController.createPointOfSale(createPointOfSaleDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newPointOfSale, response.getBody());
    }

    @Test
    void testUpdatePointOfSale() {
        Long pointOfSaleId = 1L;
        UpdatePointOfSaleDTO updatePointOfSaleDTO = new UpdatePointOfSaleDTO();
        PointOfSaleDTO updatedPointOfSale = new PointOfSaleDTO();
        when(pointOfSaleService.updatePointOfSale(eq(pointOfSaleId), any(UpdatePointOfSaleDTO.class))).thenReturn(updatedPointOfSale);

        ResponseEntity<PointOfSaleDTO> response = pointOfSaleController.updatePointOfSale(pointOfSaleId, updatePointOfSaleDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPointOfSale, response.getBody());
    }

    @Test
    void testDeletePointOfSale() {
        Long pointOfSaleId = 1L;
        when(pointOfSaleService.deletePointOfSale(pointOfSaleId)).thenReturn(true);

        ResponseEntity<Void> response = pointOfSaleController.deletePointOfSale(pointOfSaleId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
