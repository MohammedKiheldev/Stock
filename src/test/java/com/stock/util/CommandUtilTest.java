package com.stock.util;

import com.stock.dto.command.CommandDTO;
import com.stock.dto.command.CreateCommandDTO;
import com.stock.dto.command.UpdateCommandDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.product.ProductDTO;
import com.stock.dto.productCommand.CreateProductCommandDTO;
import com.stock.dto.user.UserDTO;
import com.stock.model.Command;
import com.stock.model.PointOfSale;
import com.stock.model.Product;
import com.stock.model.ProductCommand;
import com.stock.model.User;
import com.stock.util.command.CommandUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommandUtilTest {

    @Mock
    private CommandUtil commandUtil;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testConvertToDTOs() {
        List<Command> mockCommands = new ArrayList<>();
        List<CommandDTO> mockDTOs = new ArrayList<>();

        when(commandUtil.convertToDTOs(mockCommands)).thenReturn(mockDTOs);

        List<CommandDTO> response = commandUtil.convertToDTOs(mockCommands);

        assertEquals(mockDTOs, response);
    }

    @Test
    void testConvertToDTO() {
        Command mockCommand = new Command();
        CommandDTO mockDTO = new CommandDTO();

        when(commandUtil.convertToDTO(mockCommand)).thenReturn(mockDTO);

        CommandDTO response = commandUtil.convertToDTO(mockCommand);

        assertEquals(mockDTO, response);
    }

    @Test
    void testConvertToEntity() {
        CreateCommandDTO createCommandDTO = new CreateCommandDTO();
        Command mockCommand = new Command();

        when(commandUtil.convertToEntity(createCommandDTO)).thenReturn(mockCommand);

        Command response = commandUtil.convertToEntity(createCommandDTO);

        assertEquals(mockCommand, response);
    }

    @Test
    void testGenerateNumber() {
        Command mockCommand = new Command();

        commandUtil.generateNumber(mockCommand);

        // Add assertions based on the behavior of the generateNumber method
    }

    @Test
    void testCalculateTotalAmount() {
        Command mockCommand = new Command();
        double mockTotalAmount = 100.0;

        when(commandUtil.calculateTotalAmount(mockCommand)).thenReturn(mockTotalAmount);

        double response = commandUtil.calculateTotalAmount(mockCommand);

        assertEquals(mockTotalAmount, response);
    }

    // Similarly, add test cases for other methods like convertToEntity, generateNumber, calculateTotalAmount, etc.
}
