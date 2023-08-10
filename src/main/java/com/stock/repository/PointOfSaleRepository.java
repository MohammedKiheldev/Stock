package com.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.model.PointOfSale;

@Repository
public interface PointOfSaleRepository extends JpaRepository<PointOfSale, Long> {
    // Spring Data JPA automatically provides CRUD operations for the PointOfSale entity
    // You can add custom query methods here if needed
}
