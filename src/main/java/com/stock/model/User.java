package com.stock.model;

import lombok.Getter; // Lombok annotation to generate getters
import lombok.Setter; // Lombok annotation to generate setters
import jakarta.persistence.Entity; // JPA annotation to indicate that it's an entity
import jakarta.persistence.GeneratedValue; // JPA annotation to generate unique identifiers
import jakarta.persistence.GenerationType; // JPA annotation to specify generation type
import jakarta.persistence.Id; // JPA annotation for the primary key
import jakarta.persistence.ManyToOne; // JPA annotation for ManyToOne relationship
import jakarta.persistence.EnumType; // JPA enum for enumeration type
import jakarta.persistence.Enumerated; // JPA annotation for enum type

@Entity // Specifies that this class is an entity
@Getter // Lombok annotation to generate getters
@Setter // Lombok annotation to generate setters
public class User {

    @Id // Specifies that this field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Long id; // Primary key
    
    private String name; // User's name
    
    private String email; // User's email
    
    private String password; // User's password
    
    @Enumerated(EnumType.STRING) // Specifies that this field should be persisted as a string representation of the enum
    private UserType type; // Type of user (enum)
    
    @ManyToOne // Specifies a ManyToOne relationship with PointOfSale entity
    private PointOfSale pointOfSale; // Point of sale associated with the user
    
}
