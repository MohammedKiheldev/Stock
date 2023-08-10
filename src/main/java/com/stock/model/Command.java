package com.stock.model;

import java.util.List;

import lombok.AllArgsConstructor; // Lombok annotation to generate an all-args constructor
import lombok.EqualsAndHashCode; // Lombok annotation to generate equals() and hashCode() methods
import lombok.Getter; // Lombok annotation to generate getters
import lombok.NoArgsConstructor; // Lombok annotation to generate a default constructor
import lombok.Setter; // Lombok annotation to generate setters
import lombok.ToString; // Lombok annotation to generate the toString() method
import jakarta.persistence.CascadeType; // JPA annotation for cascading operations
import jakarta.persistence.Entity; // JPA annotation to indicate that it's an entity
import jakarta.persistence.Inheritance; // JPA annotation for inheritance
import jakarta.persistence.InheritanceType; // JPA annotation to specify inheritance strategy
import jakarta.persistence.ManyToOne; // JPA annotation for ManyToOne relationship
import jakarta.persistence.OneToMany; // JPA annotation for OneToMany relationship

@Entity // Specifies that this class is an entity
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a default constructor
@EqualsAndHashCode // Lombok annotation to generate equals() and hashCode() methods
@ToString // Lombok annotation to generate the toString() method
@Getter // Lombok annotation to generate getters
@Setter // Lombok annotation to generate setters
@Inheritance(strategy = InheritanceType.JOINED) // Specifies the inheritance strategy
public class Command extends Sale { // Extends the Sale class

    private int productQuantity; // Quantity of products in the command

    @ManyToOne // Specifies a ManyToOne relationship
    private User salesAgent; // User representing the sales agent

    @OneToMany(mappedBy = "command", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCommand> products; // List of ProductCommand associated with the command

}
