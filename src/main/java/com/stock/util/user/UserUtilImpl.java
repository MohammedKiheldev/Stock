package com.stock.util.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.user.CreateUserDTO;
import com.stock.dto.user.UserDTO;
import com.stock.model.PointOfSale;
import com.stock.model.User;

// Implementation of UserConversion interface
@Service
public class UserUtilImpl implements UserUtil {

    @Override
    public List<UserDTO> convertToDTOs(List<User> users) {
        List<UserDTO> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(convertToDTO(user));
        }
        return dtos;
    }

    @Override
    public UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setType(user.getType());
        return dto;
    }

    @Override
    public User convertToEntity(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setName(createUserDTO.getName());
        user.setEmail(createUserDTO.getEmail());
        user.setPassword(createUserDTO.getPassword());
        user.setType(createUserDTO.getType());
        
        // Convert PointOfSaleDTO to PointOfSale entity
        PointOfSale pointOfSale = convertToEntity(createUserDTO.getPointOfSale());
        user.setPointOfSale(pointOfSale);
        return user;
    }

    @Override
    public PointOfSale convertToEntity(PointOfSaleDTO pointOfSaleDTO) {
        PointOfSale pointOfSale = new PointOfSale();
        pointOfSale.setId(pointOfSaleDTO.getId());
        return pointOfSale;
    }
}
