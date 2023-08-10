package com.stock.model;

import lombok.Getter; // Lombok annotation to generate getters
import lombok.Setter; // Lombok annotation to generate setters
import jakarta.persistence.Entity; // JPA annotation to indicate that it's an entity
import jakarta.persistence.GeneratedValue; // JPA annotation to generate unique identifiers
import jakarta.persistence.GenerationType; // JPA annotation to specify generation type
import jakarta.persistence.Id; // JPA annotation for the primary key
import jakarta.persistence.ManyToOne; // JPA annotation for ManyToOne relationship
import jakarta.persistence.Inheritance; // JPA annotation for inheritance strategy
import jakarta.persistence.InheritanceType; // JPA enum for inheritance type

import java.util.Date; // Import for the Date class

@Entity // Specifies that this class is an entity
@Getter // Lombok annotation to generate getters
@Setter // Lombok annotation to generate setters
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Specifies inheritance strategy
public abstract class Sale {

    @Id // Specifies that this field is the primary key
    @GeneratedValue(strategy = GenerationType.TABLE) // Specifies the generation strategy for the primary key
    private Long id; // Primary key
    
    private Date date; // Date of the sale
    
    private String number; // Sale number
    
    @ManyToOne // Specifies a ManyToOne relationship with PointOfSale entity
    private PointOfSale pointOfSale; // Point of sale associated with the sale
    
}
