package com.stock.util.pointOfSale;

import java.util.List;
import java.util.stream.Collectors;

import com.stock.dto.pointOfSale.CreatePointOfSaleDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.model.PointOfSale;

// This interface defines methods for converting between DTOs and entities related to PointOfSale
public interface PointOfSaleUtil {

    // Convert a list of PointOfSale entities to a list of PointOfSaleDTOs
    List<PointOfSaleDTO> convertToDTOs(List<PointOfSale> pointsOfSale);

    // Convert a PointOfSale entity to a PointOfSaleDTO
    PointOfSaleDTO convertToDTO(PointOfSale pointOfSale);

    // Convert a CreatePointOfSaleDTO to a PointOfSale entity
    PointOfSale convertToEntity(CreatePointOfSaleDTO createPointOfSaleDTO);

    // Convert a PointOfSaleDTO to a PointOfSale entity
    PointOfSale convertToEntity(PointOfSaleDTO pointOfSaleDTO);
}
