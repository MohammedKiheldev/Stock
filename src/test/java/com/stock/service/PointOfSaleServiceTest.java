package com.stock.service;

import com.stock.dao.pointOfSale.PointOfSaleDao;
import com.stock.dto.pointOfSale.CreatePointOfSaleDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.pointOfSale.UpdatePointOfSaleDTO;
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

class PointOfSaleServiceTest {

    @Mock
    private PointOfSaleDao pointOfSaleDao; // Mock of PointOfSaleDao

    @Mock
    private PointOfSaleUtil pointOfSaleUtil; // Mock of PointOfSaleUtil

    @InjectMocks
    private PointOfSaleService pointOfSaleService; // Instance of PointOfSaleService with injected mocks

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this); // Initialize the mocks
    }

    @Test
    void testGetAllPointsOfSale() {
        List<PointOfSale> mockPointOfSaleList = new ArrayList<>();
        List<PointOfSaleDTO> mockDTOList = new ArrayList<>();

        when(pointOfSaleDao.getAllPointsOfSale()).thenReturn(mockPointOfSaleList);
        when(pointOfSaleUtil.convertToDTOs(mockPointOfSaleList)).thenReturn(mockDTOList);

        List<PointOfSaleDTO> response = pointOfSaleService.getAllPointsOfSale();

        assertEquals(mockDTOList, response);
    }

    @Test
    void testGetPointOfSaleById() {
        Long pointOfSaleId = 1L;
        PointOfSale mockPointOfSale = new PointOfSale();
        PointOfSaleDTO mockDTO = new PointOfSaleDTO();

        when(pointOfSaleDao.getPointOfSaleById(pointOfSaleId)).thenReturn(mockPointOfSale);
        when(pointOfSaleUtil.convertToDTO(mockPointOfSale)).thenReturn(mockDTO);

        PointOfSaleDTO response = pointOfSaleService.getPointOfSaleById(pointOfSaleId);

        assertEquals(mockDTO, response);
    }

    @Test
    void testCreatePointOfSale() {
        CreatePointOfSaleDTO createDTO = new CreatePointOfSaleDTO();
        PointOfSale mockPointOfSale = new PointOfSale();
        PointOfSale newPointOfSale = new PointOfSale();
        PointOfSaleDTO mockDTO = new PointOfSaleDTO();

        when(pointOfSaleUtil.convertToEntity(createDTO)).thenReturn(mockPointOfSale);
        when(pointOfSaleDao.addPointOfSale(mockPointOfSale)).thenReturn(newPointOfSale);
        when(pointOfSaleUtil.convertToDTO(newPointOfSale)).thenReturn(mockDTO);

        PointOfSaleDTO response = pointOfSaleService.createPointOfSale(createDTO);

        assertEquals(mockDTO, response);
    }

    @Test
    void testUpdatePointOfSale() {
        Long pointOfSaleId = 1L;
        UpdatePointOfSaleDTO updateDTO = new UpdatePointOfSaleDTO();
        PointOfSale mockPointOfSale = new PointOfSale();
        PointOfSale updatedPointOfSale = new PointOfSale();
        PointOfSaleDTO mockDTO = new PointOfSaleDTO();

        when(pointOfSaleDao.getPointOfSaleById(pointOfSaleId)).thenReturn(mockPointOfSale);
        when(pointOfSaleDao.updatePointOfSale(any(PointOfSale.class))).thenReturn(updatedPointOfSale);
        when(pointOfSaleUtil.convertToDTO(updatedPointOfSale)).thenReturn(mockDTO);

        PointOfSaleDTO response = pointOfSaleService.updatePointOfSale(pointOfSaleId, updateDTO);

        assertEquals(mockDTO, response);
    }
    @Test
    void testDeletePointOfSaleSuccess() {
        Long pointOfSaleId = 1L;

        // Configure the pointOfSaleDao mock to behave when deletePointOfSale is called
        doNothing().when(pointOfSaleDao).deletePointOfSale(pointOfSaleId);

        boolean response = pointOfSaleService.deletePointOfSale(pointOfSaleId);

        assertTrue(response);
    }

    @Test
    void testDeletePointOfSaleFailure() {
        Long pointOfSaleId = 1L;

        // Configure the pointOfSaleDao mock to behave when deletePointOfSale is called
        doThrow(new RuntimeException("Deletion failed")).when(pointOfSaleDao).deletePointOfSale(pointOfSaleId);

        boolean response = pointOfSaleService.deletePointOfSale(pointOfSaleId);

        assertFalse(response);
    }

}
