package com.stock.dao.pointOfSale;

import com.stock.model.PointOfSale;
import com.stock.repository.PointOfSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

// This class implements the PointOfSaleDao interface and interacts with the database
@Repository
public class PointOfSaleDaoImpl implements PointOfSaleDao {

    @Autowired
    private PointOfSaleRepository pointOfSaleRepository;

    // Retrieve a list of all points of sale from the database
    @Override
    public List<PointOfSale> getAllPointsOfSale() {
        return pointOfSaleRepository.findAll();
    }

    // Retrieve a specific point of sale by its ID from the database
    @Override
    public PointOfSale getPointOfSaleById(Long id) {
        return pointOfSaleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Point of Sale not found with id: " + id));
    }

    // Add a new point of sale to the database
    @Override
    public PointOfSale addPointOfSale(PointOfSale pointOfSale) {
        return pointOfSaleRepository.save(pointOfSale);
    }

    // Update an existing point of sale in the database
    @Override
    public PointOfSale updatePointOfSale(PointOfSale pointOfSale) {
        return pointOfSaleRepository.save(pointOfSale);
    }

    // Delete a point of sale from the database based on its ID
    @Override
    public void deletePointOfSale(Long id) {
        pointOfSaleRepository.deleteById(id);
    }
}
