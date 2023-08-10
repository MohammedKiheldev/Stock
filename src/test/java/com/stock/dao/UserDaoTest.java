package com.stock.dao;

import com.stock.dao.user.UserDao;
import com.stock.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserDaoTest {

    @Mock
    private UserDao userDao;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllUsers() {
        List<User> mockUsers = new ArrayList<>();
        when(userDao.getAllUsers()).thenReturn(mockUsers);

        List<User> response = userDao.getAllUsers();

        assertEquals(mockUsers, response);
    }

    @Test
    void testGetUserById() {
        Long userId = 1L;
        User mockUser = new User();

        when(userDao.getUserById(userId)).thenReturn(mockUser);

        User response = userDao.getUserById(userId);

        assertEquals(mockUser, response);
    }

    @Test
    void testAddUser() {
        User mockUser = new User();
        User newUser = new User();

        when(userDao.addUser(mockUser)).thenReturn(newUser);

        User response = userDao.addUser(mockUser);

        assertEquals(newUser, response);
    }

    @Test
    void testUpdateUser() {
        User mockUser = new User();
        User updatedUser = new User();

        when(userDao.updateUser(mockUser)).thenReturn(updatedUser);

        User response = userDao.updateUser(mockUser);

        assertEquals(updatedUser, response);
    }

    @Test
    void testDeleteUser() {
        Long userId = 1L;

        // Configure the userDao mock to behave when deleteUser is called
        doNothing().when(userDao).deleteUser(userId);

        userDao.deleteUser(userId);

        // Verify that deleteUser was called
        verify(userDao, times(1)).deleteUser(userId);
    }
}
