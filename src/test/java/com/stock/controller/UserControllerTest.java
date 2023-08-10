package com.stock.controller;

import com.stock.dto.user.CreateUserDTO;
import com.stock.dto.user.UpdateUserDTO;
import com.stock.dto.user.UserDTO;
import com.stock.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService; // Mock of UserService

    @InjectMocks
    private UserController userController; // Instance of UserController with injected mocks

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this); // Initialize the mocks
    }

    @Test
    void testGetAllUsers() {
        // Prepare mock data
        List<UserDTO> userList = new ArrayList<>();
        when(userService.getAllUsers()).thenReturn(userList);

        // Call the controller method
        List<UserDTO> response = userController.getAllUsers();

        // Compare the expected and actual results
        assertEquals(userList, response);
    }

    @Test
    void testGetUserById() {
        Long userId = 1L;
        UserDTO userDTO = new UserDTO();
        when(userService.getUserById(userId)).thenReturn(userDTO);

        UserDTO response = userController.getUserById(userId);

        assertEquals(userDTO, response);
    }

    @Test
    void testCreateUser() {
        CreateUserDTO createUserDTO = new CreateUserDTO();
        UserDTO newUser = new UserDTO();
        when(userService.createUser(createUserDTO)).thenReturn(newUser);

        UserDTO response = userController.createUser(createUserDTO);

        assertEquals(newUser, response);
    }

    @Test
    void testUpdateUser() {
        Long userId = 1L;
        UpdateUserDTO updateUserDTO = new UpdateUserDTO();
        UserDTO updatedUser = new UserDTO();
        when(userService.updateUser(eq(userId), any(UpdateUserDTO.class))).thenReturn(updatedUser);

        UserDTO response = userController.updateUser(userId, updateUserDTO);

        assertEquals(updatedUser, response);
    }

    @Test
    void testDeleteUser() {
        Long userId = 1L;
        when(userService.deleteUser(userId)).thenReturn(true);

        boolean response = userController.deleteUser(userId);

        assertEquals(true, response);
    }
}
