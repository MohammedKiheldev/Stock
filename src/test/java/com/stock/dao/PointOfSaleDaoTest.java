package com.stock.dao;

import com.stock.dao.pointOfSale.PointOfSaleDao;
import com.stock.model.PointOfSale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PointOfSaleDaoTest {

    @Mock
    private PointOfSaleDao pointOfSaleDao;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllPointsOfSale() {
        List<PointOfSale> mockPointsOfSale = new ArrayList<>();
        when(pointOfSaleDao.getAllPointsOfSale()).thenReturn(mockPointsOfSale);

        List<PointOfSale> response = pointOfSaleDao.getAllPointsOfSale();

        assertEquals(mockPointsOfSale, response);
    }

    @Test
    void testGetPointOfSaleById() {
        Long pointOfSaleId = 1L;
        PointOfSale mockPointOfSale = new PointOfSale();

        when(pointOfSaleDao.getPointOfSaleById(pointOfSaleId)).thenReturn(mockPointOfSale);

        PointOfSale response = pointOfSaleDao.getPointOfSaleById(pointOfSaleId);

        assertEquals(mockPointOfSale, response);
    }

    @Test
    void testAddPointOfSale() {
        PointOfSale mockPointOfSale = new PointOfSale();
        PointOfSale newPointOfSale = new PointOfSale();

        when(pointOfSaleDao.addPointOfSale(mockPointOfSale)).thenReturn(newPointOfSale);

        PointOfSale response = pointOfSaleDao.addPointOfSale(mockPointOfSale);

        assertEquals(newPointOfSale, response);
    }

    @Test
    void testUpdatePointOfSale() {
        PointOfSale mockPointOfSale = new PointOfSale();
        PointOfSale updatedPointOfSale = new PointOfSale();

        when(pointOfSaleDao.updatePointOfSale(mockPointOfSale)).thenReturn(updatedPointOfSale);

        PointOfSale response = pointOfSaleDao.updatePointOfSale(mockPointOfSale);

        assertEquals(updatedPointOfSale, response);
    }

    @Test
    void testDeletePointOfSale() {
        Long pointOfSaleId = 1L;

        // Configure the pointOfSaleDao mock to behave when deletePointOfSale is called
        doNothing().when(pointOfSaleDao).deletePointOfSale(pointOfSaleId);

        pointOfSaleDao.deletePointOfSale(pointOfSaleId);

        // Verify that deletePointOfSale was called
        verify(pointOfSaleDao, times(1)).deletePointOfSale(pointOfSaleId);
    }
}
