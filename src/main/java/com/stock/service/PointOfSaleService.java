package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.stock.dao.pointOfSale.PointOfSaleDao;
import com.stock.model.PointOfSale;
import com.stock.util.pointOfSale.PointOfSaleUtil;
import com.stock.dto.pointOfSale.CreatePointOfSaleDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.pointOfSale.UpdatePointOfSaleDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointOfSaleService{

    @Autowired
    private PointOfSaleDao pointOfSaleDao;
    
    @Autowired
    private PointOfSaleUtil pointOfSaleUtil;

    public List<PointOfSaleDTO> getAllPointsOfSale() {
        List<PointOfSale> pointsOfSale = pointOfSaleDao.getAllPointsOfSale();
        return pointOfSaleUtil.convertToDTOs(pointsOfSale);
    }

    public PointOfSaleDTO getPointOfSaleById(Long id) {
        PointOfSale pointOfSale = pointOfSaleDao.getPointOfSaleById(id);
        return pointOfSaleUtil.convertToDTO(pointOfSale);
    }

    public PointOfSaleDTO createPointOfSale(CreatePointOfSaleDTO createPointOfSaleDTO) {
        PointOfSale pointOfSale = pointOfSaleUtil.convertToEntity(createPointOfSaleDTO);
        PointOfSale newPointOfSale = pointOfSaleDao.addPointOfSale(pointOfSale);
        return pointOfSaleUtil.convertToDTO(newPointOfSale);
    }

    public PointOfSaleDTO updatePointOfSale(Long id, UpdatePointOfSaleDTO updatePointOfSaleDTO) {
        PointOfSale pointOfSale = pointOfSaleDao.getPointOfSaleById(id);
        pointOfSale.setName(updatePointOfSaleDTO.getName());
        pointOfSale.setAddress(updatePointOfSaleDTO.getAddress());
        pointOfSale.setQuantity(updatePointOfSaleDTO.getQuantity());
        PointOfSale updatedPointOfSaleEntity = pointOfSaleDao.updatePointOfSale(pointOfSale);
        return pointOfSaleUtil.convertToDTO(updatedPointOfSaleEntity);
    }

    public boolean deletePointOfSale(Long id) {
        try {
            pointOfSaleDao.deletePointOfSale(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
