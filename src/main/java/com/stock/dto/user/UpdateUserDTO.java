package com.stock.dto.user;

import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.model.UserType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a default constructor
@EqualsAndHashCode // Lombok annotation to generate equals() and hashCode() methods
@ToString // Lombok annotation to generate the toString() method
@Getter // Lombok annotation to generate getters
@Setter // Lombok annotation to generate setters
public class UpdateUserDTO {

    private String name; // User's name
    private String email; // User's email address
    private String password; // User's password
    private UserType type; // User type (UserType enum)
    private PointOfSaleDTO pointOfSale; // Point of sale associated with the user
}
