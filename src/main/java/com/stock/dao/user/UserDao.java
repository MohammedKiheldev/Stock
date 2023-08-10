package com.stock.dao.user;

import java.util.List;


import com.stock.model.User;

// This interface defines methods for interacting with the User entity in the data access layer
public interface UserDao {

    // Retrieve a list of all users
    List<User> getAllUsers();

    // Retrieve a specific user by their ID
    User getUserById(Long id);

    // Add a new user to the database
    User addUser(User user);

    // Update an existing user in the database
    User updateUser(User user);

    // Delete a user from the database based on their ID
    void deleteUser(Long id);
}
