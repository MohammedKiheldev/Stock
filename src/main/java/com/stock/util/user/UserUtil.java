package com.stock.util.user;

import java.util.List;

import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.user.CreateUserDTO;
import com.stock.dto.user.UserDTO;
import com.stock.model.PointOfSale;
import com.stock.model.User;

// This interface defines methods for converting between DTOs and entities related to users
public interface UserUtil {

    // Convert a list of User entities to a list of UserDTOs
    List<UserDTO> convertToDTOs(List<User> users);

    // Convert a User entity to a UserDTO
    UserDTO convertToDTO(User user);

    // Convert a CreateUserDTO to a User entity
    User convertToEntity(CreateUserDTO createUserDTO);

    // Convert a PointOfSaleDTO to a PointOfSale entity
    PointOfSale convertToEntity(PointOfSaleDTO pointOfSaleDTO);
}
