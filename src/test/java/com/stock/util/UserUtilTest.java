package com.stock.util;

import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.user.CreateUserDTO;
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

class UserUtilTest {

    @Mock
    private UserUtil userUtil;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testConvertToDTOs() {
        List<User> mockUsers = new ArrayList<>();
        List<UserDTO> mockDTOs = new ArrayList<>();

        when(userUtil.convertToDTOs(mockUsers)).thenReturn(mockDTOs);

        List<UserDTO> response = userUtil.convertToDTOs(mockUsers);

        assertEquals(mockDTOs, response);
    }

    @Test
    void testConvertToDTO() {
        User mockUser = new User();
        UserDTO mockDTO = new UserDTO();

        when(userUtil.convertToDTO(mockUser)).thenReturn(mockDTO);

        UserDTO response = userUtil.convertToDTO(mockUser);

        assertEquals(mockDTO, response);
    }

    @Test
    void testConvertToEntityFromCreateDTO() {
        CreateUserDTO mockCreateDTO = new CreateUserDTO();
        User mockUser = new User();

        when(userUtil.convertToEntity(mockCreateDTO)).thenReturn(mockUser);

        User response = userUtil.convertToEntity(mockCreateDTO);

        assertEquals(mockUser, response);
    }

    @Test
    void testConvertToEntityFromPointOfSaleDTO() {
        PointOfSaleDTO mockPointOfSaleDTO = new PointOfSaleDTO();
        PointOfSale mockPointOfSale = new PointOfSale();

        when(userUtil.convertToEntity(mockPointOfSaleDTO)).thenReturn(mockPointOfSale);

        PointOfSale response = userUtil.convertToEntity(mockPointOfSaleDTO);

        assertEquals(mockPointOfSale, response);
    }

    // Add more test cases as needed
}
