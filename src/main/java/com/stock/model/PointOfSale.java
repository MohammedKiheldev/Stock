package com.stock.model;

import com.stock.dto.product.ProductDTO; // Import for ProductDTO (if used)

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
import jakarta.persistence.OneToMany; // JPA annotation for OneToMany relationship

import java.util.List;

@Entity // Specifies that this class is an entity
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a default constructor
@EqualsAndHashCode // Lombok annotation to generate equals() and hashCode() methods
@ToString // Lombok annotation to generate the toString() method
@Getter // Lombok annotation to generate getters
@Setter // Lombok annotation to generate setters
public class PointOfSale {
    @Id // Specifies that this field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategy for the primary key
    private Long id; // Primary key
    
    private String name; // Name of the point of sale
    private String address; // Address of the point of sale
    private int quantity; // Quantity of products available
    
    @OneToMany(mappedBy = "pointOfSale") // Specifies a OneToMany relationship with Product entity
    private List<Product> products; // List of products associated with this point of sale

    @OneToMany(mappedBy = "pointOfSale") // Specifies a OneToMany relationship with User entity
    private List<User> users; // List of users associated with this point of sale 

    @OneToMany(mappedBy = "pointOfSale") // Specifies a OneToMany relationship with Sale entity
    private List<Sale> sales; // List of sales associated with this point of sale
    
    @OneToMany(mappedBy = "pointOfSale") // Specifies a OneToMany relationship with Command entity
    private List<Command> commands; // List of commands associated with this point of sale
 
}
