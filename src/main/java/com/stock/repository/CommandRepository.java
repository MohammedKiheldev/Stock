package com.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.model.Command;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {
    // Spring Data JPA automatically provides CRUD operations for the Command entity
    // You can add custom query methods here if needed
}
