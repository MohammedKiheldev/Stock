package com.stock.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.stock.dto.user.CreateUserDTO;
import com.stock.dto.user.UpdateUserDTO;
import com.stock.dto.user.UserDTO;
import com.stock.model.PointOfSale;
import com.stock.model.User;
import com.stock.util.user.UserUtil;
import com.stock.dao.pointOfSale.PointOfSaleDao;
import com.stock.dao.user.UserDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private UserUtil userUtil;
    
    @Autowired
    private PointOfSaleDao pointOfSaleDao;

    public List<UserDTO> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        return userUtil.convertToDTOs(users);
    }

    public UserDTO getUserById(Long id) {
        User user = userDao.getUserById(id);
        return userUtil.convertToDTO(user);
    }

    public UserDTO createUser(CreateUserDTO createUserDTO) {
        User user = userUtil.convertToEntity(createUserDTO);
        User newUser = userDao.addUser(user);
        return userUtil.convertToDTO(newUser);
    }

    public UserDTO updateUser(Long id, UpdateUserDTO updateUserDTO) {
        User existingUser = userDao.getUserById(id);
        if (existingUser != null) {
            existingUser.setName(updateUserDTO.getName());
            existingUser.setEmail(updateUserDTO.getEmail());
            existingUser.setPassword(updateUserDTO.getPassword());
            existingUser.setType(updateUserDTO.getType());
            PointOfSale pointOfSale = userUtil.convertToEntity(updateUserDTO.getPointOfSale()) ;
            existingUser.setPointOfSale(pointOfSale);
            User updatedUser = userDao.updateUser(existingUser);
            return userUtil.convertToDTO(updatedUser);
        } else {
            return null;
        }
    }

    public boolean deleteUser(Long id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            userDao.deleteUser(id);
            return true;
        } else {
            return false;
        }
    }

    
}
