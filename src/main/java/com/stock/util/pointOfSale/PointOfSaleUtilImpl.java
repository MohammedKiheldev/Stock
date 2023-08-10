package com.stock.util.pointOfSale;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.stock.dto.pointOfSale.CreatePointOfSaleDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.model.PointOfSale;

// Implementation of PointOfSaleUtil interface
@Service
public class PointOfSaleUtilImpl implements PointOfSaleUtil {

    // Convert a list of PointOfSale entities to a list of PointOfSaleDTOs
    @Override
    public List<PointOfSaleDTO> convertToDTOs(List<PointOfSale> pointsOfSale) {
        return pointsOfSale.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Convert a PointOfSale entity to a PointOfSaleDTO
    @Override
    public PointOfSaleDTO convertToDTO(PointOfSale pointOfSale) {
        if (pointOfSale == null) {
            return null;
        }

        PointOfSaleDTO dto = new PointOfSaleDTO();
        dto.setId(pointOfSale.getId());
        dto.setName(pointOfSale.getName());
        dto.setAddress(pointOfSale.getAddress());
        dto.setQuantity(pointOfSale.getQuantity());
        return dto;
    }

    // Convert a CreatePointOfSaleDTO to a PointOfSale entity
    @Override
    public PointOfSale convertToEntity(CreatePointOfSaleDTO createPointOfSaleDTO) {
        PointOfSale pointOfSale = new PointOfSale();
        pointOfSale.setName(createPointOfSaleDTO.getName());
        pointOfSale.setAddress(createPointOfSaleDTO.getAddress());
        pointOfSale.setQuantity(createPointOfSaleDTO.getQuantity());
        return pointOfSale;
    }

    // Convert a PointOfSaleDTO to a PointOfSale entity
    @Override
    public PointOfSale convertToEntity(PointOfSaleDTO pointOfSaleDTO) {
        PointOfSale pointOfSale = new PointOfSale();
        pointOfSale.setName(pointOfSaleDTO.getName());
        pointOfSale.setAddress(pointOfSaleDTO.getAddress());
        pointOfSale.setQuantity(pointOfSaleDTO.getQuantity());
        return pointOfSale;
    }
}
