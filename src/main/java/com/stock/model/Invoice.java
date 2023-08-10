package com.stock.model;

import lombok.AllArgsConstructor; // Lombok annotation to generate an all-args constructor
import lombok.EqualsAndHashCode; // Lombok annotation to generate equals() and hashCode() methods
import lombok.Getter; // Lombok annotation to generate getters
import lombok.NoArgsConstructor; // Lombok annotation to generate a default constructor
import lombok.Setter; // Lombok annotation to generate setters
import lombok.ToString; // Lombok annotation to generate the toString() method
import jakarta.persistence.Entity; // JPA annotation to indicate that it's an entity
import jakarta.persistence.Inheritance; // JPA annotation for inheritance
import jakarta.persistence.InheritanceType; // JPA annotation to specify inheritance strategy
import jakarta.persistence.OneToOne; // JPA annotation for OneToOne relationship
import jakarta.persistence.JoinColumn; // JPA annotation to specify join column

@Entity // Specifies that this class is an entity
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a default constructor
@EqualsAndHashCode // Lombok annotation to generate equals() and hashCode() methods
@ToString // Lombok annotation to generate the toString() method
@Getter // Lombok annotation to generate getters
@Setter // Lombok annotation to generate setters
@Inheritance(strategy = InheritanceType.JOINED) // Specifies the inheritance strategy
public class Invoice extends Sale {

    private double amount; // Total amount for the invoice
    
    @OneToOne // Specifies a OneToOne relationship
    @JoinColumn(name = "command_id") // Specifies the join column name
    private Command command; // Command associated with the invoice
    
}
