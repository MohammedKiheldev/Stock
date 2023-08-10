package com.stock.service;

import com.stock.dao.user.UserDao;
import com.stock.dto.user.CreateUserDTO;
import com.stock.dto.user.UpdateUserDTO;
import com.stock.dto.user.UserDTO;
import com.stock.model.PointOfSale;
import com.stock.model.User;
import com.stock.util.user.UserUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserDao userDao; // Mock of UserDao

    @Mock
    private UserUtil userUtil; // Mock of UserUtil

    @InjectMocks
    private UserService userService; // Instance of UserService with injected mocks

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this); // Initialize the mocks
    }

    @Test
    void testGetAllUsers() {
        List<User> mockUserList = new ArrayList<>();
        List<UserDTO> mockDTOList = new ArrayList<>();

        when(userDao.getAllUsers()).thenReturn(mockUserList);
        when(userUtil.convertToDTOs(mockUserList)).thenReturn(mockDTOList);

        List<UserDTO> response = userService.getAllUsers();

        assertEquals(mockDTOList, response);
    }

    @Test
    void testGetUserById() {
        Long userId = 1L;
        User mockUser = new User();
        UserDTO mockDTO = new UserDTO();

        when(userDao.getUserById(userId)).thenReturn(mockUser);
        when(userUtil.convertToDTO(mockUser)).thenReturn(mockDTO);

        UserDTO response = userService.getUserById(userId);

        assertEquals(mockDTO, response);
    }

    @Test
    void testCreateUser() {
        CreateUserDTO createDTO = new CreateUserDTO();
        User mockUser = new User();
        User newUser = new User();
        UserDTO mockDTO = new UserDTO();

        when(userUtil.convertToEntity(createDTO)).thenReturn(mockUser);
        when(userDao.addUser(mockUser)).thenReturn(newUser);
        when(userUtil.convertToDTO(newUser)).thenReturn(mockDTO);

        UserDTO response = userService.createUser(createDTO);

        assertEquals(mockDTO, response);
    }

    @Test
    void testUpdateUser() {
        Long userId = 1L;
        UpdateUserDTO updateDTO = new UpdateUserDTO();
        User mockUser = new User();
        User updatedUser = new User();
        UserDTO mockDTO = new UserDTO();

        when(userDao.getUserById(userId)).thenReturn(mockUser);
        when(userDao.updateUser(any(User.class))).thenReturn(updatedUser);
        when(userUtil.convertToDTO(updatedUser)).thenReturn(mockDTO);

        UserDTO response = userService.updateUser(userId, updateDTO);

        assertEquals(mockDTO, response);
    }

    @Test
    void testDeleteUser() {
        Long userId = 1L;

        // Configure the userDao mock to behave when deleteUser is called
        doNothing().when(userDao).deleteUser(userId);

        assertDoesNotThrow(() -> userService.deleteUser(userId));
    }


    @Test
    void testDeleteUserFailure() {
        Long userId = 1L;

        // Configure the userDao mock to behave when deleteUser is called
        doThrow(new RuntimeException("Deletion failed")).when(userDao).deleteUser(userId);

        boolean response = userService.deleteUser(userId);

        assertFalse(response);
    }
}
