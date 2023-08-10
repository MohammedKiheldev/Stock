package com.stock.model;

import lombok.Getter; // Lombok annotation to generate getters
import lombok.Setter; // Lombok annotation to generate setters
import jakarta.persistence.Entity; // JPA annotation to indicate that it's an entity
import jakarta.persistence.GeneratedValue; // JPA annotation to generate unique identifiers
import jakarta.persistence.GenerationType; // JPA annotation to specify generation type
import jakarta.persistence.Id; // JPA annotation for the primary key
import jakarta.persistence.ManyToOne; // JPA annotation for ManyToOne relationship

@Entity // Specifies that this class is an entity
@Getter // Lombok annotation to generate getters
@Setter // Lombok annotation to generate setters
public class ProductCommand {

    @Id // Specifies that this field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Long id; // Primary key
    
    private Double unitPrice; // Unit price of the product command
    
    private int quantityInCommand; // Quantity of the product in the command

    @ManyToOne // Specifies a ManyToOne relationship with Command entity
    private Command command; // Command associated with the product command

    @ManyToOne // Specifies a ManyToOne relationship with Product entity
    private Product product; // Product associated with the product command

}
