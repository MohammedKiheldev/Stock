// Import necessary classes and packages
package com.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.stock.dto.pointOfSale.CreatePointOfSaleDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.pointOfSale.UpdatePointOfSaleDTO;
import com.stock.service.PointOfSaleService;
import java.util.List;

// Declare this class as a RestController and map it to the "/pointofsale" route
@RestController
@RequestMapping("/pointofsale")
public class PointOfSaleController {

    // Automatically inject the PointOfSaleService dependency
    @Autowired
    private PointOfSaleService pointOfSaleService;

    // Handle HTTP GET request to retrieve all points of sale
    @GetMapping
    public ResponseEntity<List<PointOfSaleDTO>> getAllPointsOfSale() {
        List<PointOfSaleDTO> pointsOfSale = pointOfSaleService.getAllPointsOfSale();
        return new ResponseEntity<>(pointsOfSale, HttpStatus.OK);
    }

    // Handle HTTP GET request to retrieve a point of sale by its ID
    @GetMapping("/{id}")
    public ResponseEntity<PointOfSaleDTO> getPointOfSaleById(@PathVariable Long id) {
        PointOfSaleDTO pointOfSale = pointOfSaleService.getPointOfSaleById(id);
        if (pointOfSale != null) {
            return new ResponseEntity<>(pointOfSale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Handle HTTP POST request to create a new point of sale
    @PostMapping
    public ResponseEntity<PointOfSaleDTO> createPointOfSale(@RequestBody CreatePointOfSaleDTO createPointOfSaleDTO) {
        PointOfSaleDTO newPointOfSale = pointOfSaleService.createPointOfSale(createPointOfSaleDTO);
        return new ResponseEntity<>(newPointOfSale, HttpStatus.CREATED);
    }

    // Handle HTTP PUT request to update an existing point of sale by its ID
    @PutMapping("/{id}")
    public ResponseEntity<PointOfSaleDTO> updatePointOfSale(@PathVariable Long id, @RequestBody UpdatePointOfSaleDTO updatePointOfSaleDTO) {
        PointOfSaleDTO updatedPointOfSale = pointOfSaleService.updatePointOfSale(id, updatePointOfSaleDTO);
        if (updatedPointOfSale != null) {
            return new ResponseEntity<>(updatedPointOfSale, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Handle HTTP DELETE request to delete a point of sale by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePointOfSale(@PathVariable Long id) {
        boolean success = pointOfSaleService.deletePointOfSale(id);
        if (success) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
