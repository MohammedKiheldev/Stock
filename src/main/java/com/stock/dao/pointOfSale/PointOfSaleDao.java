package com.stock.dao.pointOfSale;

import com.stock.model.PointOfSale;

import java.util.List;

// This interface defines methods for interacting with the PointOfSale entity in the data access layer
public interface PointOfSaleDao {

    // Retrieve a list of all points of sale
    List<PointOfSale> getAllPointsOfSale();

    // Retrieve a specific point of sale by its ID
    PointOfSale getPointOfSaleById(Long id);

    // Add a new point of sale to the database
    PointOfSale addPointOfSale(PointOfSale pointOfSale);

    // Update an existing point of sale in the database
    PointOfSale updatePointOfSale(PointOfSale pointOfSale);

    // Delete a point of sale from the database based on its ID
    void deletePointOfSale(Long id);
}
