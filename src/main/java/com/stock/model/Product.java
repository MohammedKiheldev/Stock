package com.stock.model;

import lombok.AllArgsConstructor; // Lombok annotation to generate an all-args constructor
import lombok.EqualsAndHashCode; // Lombok annotation to generate equals() and hashCode() methods
import lombok.Getter; // Lombok annotation to generate getters
import lombok.NoArgsConstructor; // Lombok annotation to generate a default constructor
import lombok.Setter; // Lombok annotation to generate setters
import lombok.ToString; // Lombok annotation to generate the toString() method
import jakarta.persistence.Entity; // JPA annotation to indicate that it's an entity
import jakarta.persistence.GeneratedValue; // JPA annotation to generate unique identifiers
import jakarta.persistence.GenerationType; // JPA annotation to specify generation type
import jakarta.persistence.Id; // JPA annotation for the primary key
import jakarta.persistence.Column; // JPA annotation for custom column definitions
import jakarta.persistence.ManyToOne; // JPA annotation for ManyToOne relationship
import jakarta.persistence.OneToMany; // JPA annotation for OneToMany relationship
import jakarta.persistence.CascadeType; // JPA annotation for cascade behavior

import java.util.List;

@Entity // Specifies that this class is an entity
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a default constructor
@EqualsAndHashCode // Lombok annotation to generate equals() and hashCode() methods
@ToString // Lombok annotation to generate the toString() method
@Getter // Lombok annotation to generate getters
@Setter // Lombok annotation to generate setters
public class Product {
    @Id // Specifies that this field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Long id; // Primary key
    
    private String name; // Name of the product
    
    private double price; // Price of the product
    
    private double minimumPrice; // Minimum price of the product
    
    private int quantityInStock; // Quantity of the product in stock
    
    private String description; // Description of the product

    @Column(columnDefinition = "NUMERIC(6)", unique = true, length = 6) // Custom column definition for the code
    private Long code; // Code of the product
    
    @ManyToOne // Specifies a ManyToOne relationship with PointOfSale entity
    private PointOfSale pointOfSale; // Point of sale associated with the product
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true) // Specifies a OneToMany relationship with ProductCommand entity
	private List<ProductCommand> products; // List of product commands associated with the product
	
}
