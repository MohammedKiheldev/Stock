package com.stock.dto.user;

import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.product.ProductDTO;
import com.stock.model.PointOfSale;
import com.stock.model.UserType;
import lombok.AllArgsConstructor; // Lombok annotation to generate an all-args constructor
import lombok.EqualsAndHashCode; // Lombok annotation to generate equals() and hashCode() methods
import lombok.Getter; // Lombok annotation to generate getters
import lombok.NoArgsConstructor; // Lombok annotation to generate a default constructor
import lombok.Setter; // Lombok annotation to generate setters
import lombok.ToString; // Lombok annotation to generate the toString() method

@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a default constructor
@EqualsAndHashCode // Lombok annotation to generate equals() and hashCode() methods
@ToString // Lombok annotation to generate the toString() method
@Getter // Lombok annotation to generate getters
@Setter // Lombok annotation to generate setters
public class UserDTO {

    private Long id; // User's unique identifier
    private String name; // User's name
    private String email; // User's email address
    private String password; // User's password
    private UserType type; // User type (UserType enum)
    private PointOfSaleDTO pointOfSale; // Point of sale associated with the user

}
