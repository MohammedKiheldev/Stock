package com.stock.dao.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stock.model.User;
import com.stock.repository.UserRepository;

// This class implements the UserDao interface and interacts with the database
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    // Retrieve a list of all users from the database
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Retrieve a specific user by their ID from the database
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Add a new user to the database
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    // Update an existing user in the database
    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Delete a user from the database based on their ID
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
