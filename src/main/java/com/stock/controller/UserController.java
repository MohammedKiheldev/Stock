// Import necessary classes and packages
package com.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.stock.dto.user.CreateUserDTO;
import com.stock.dto.user.UpdateUserDTO;
import com.stock.dto.user.UserDTO;
import com.stock.service.UserService;
import java.util.List;

// Declare this class as a RestController and map it to the "/user" route
@RestController
@RequestMapping("/user")
public class UserController {

    // Automatically inject the UserService dependency
    @Autowired
    private UserService userService;

    // Handle HTTP GET request to retrieve all users
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // Handle HTTP GET request to retrieve a user by their ID
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Handle HTTP POST request to create a new user
    @PostMapping
    public UserDTO createUser(@RequestBody CreateUserDTO createUserDTO) {
        return userService.createUser(createUserDTO);
    }

    // Handle HTTP PUT request to update an existing user by their ID
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO updateUserDTO) {
        return userService.updateUser(id, updateUserDTO);
    }

    // Handle HTTP DELETE request to delete a user by their ID
    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
