package com.stock.service;

import com.stock.dao.command.CommandDao;
import com.stock.dto.command.CommandDTO;
import com.stock.dto.command.CreateCommandDTO;
import com.stock.dto.command.UpdateCommandDTO;
import com.stock.model.Command;
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

class CommandServiceTest {

    @Mock
    private CommandDao commandDao; // Mock of CommandDao

    @Mock
    private CommandUtil commandUtil; // Mock of CommandUtil

    @InjectMocks
    private CommandService commandService; // Instance of CommandService with injected mocks

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this); // Initialize the mocks
    }

    @Test
    void testGetAllCommands() {
        List<Command> mockCommandList = new ArrayList<>();
        List<CommandDTO> mockDTOList = new ArrayList<>();

        when(commandDao.getAllCommands()).thenReturn(mockCommandList);
        when(commandUtil.convertToDTOs(mockCommandList)).thenReturn(mockDTOList);

        List<CommandDTO> response = commandService.getAllCommands();

        assertEquals(mockDTOList, response);
    }

    @Test
    void testGetCommandById() {
        Long commandId = 1L;
        Command mockCommand = new Command();
        CommandDTO mockDTO = new CommandDTO();

        when(commandDao.getCommandById(commandId)).thenReturn(mockCommand);
        when(commandUtil.convertToDTO(mockCommand)).thenReturn(mockDTO);

        CommandDTO response = commandService.getCommandById(commandId);

        assertEquals(mockDTO, response);
    }

    @Test
    void testDeleteCommandFailure() {
        Long commandId = 1L;

        // Configure the commandDao mock to behave when deleteCommand is called
        doThrow(new RuntimeException("Deletion failed")).when(commandDao).deleteCommand(commandId);

        boolean response = commandService.deleteCommand(commandId);

        assertFalse(response);
    }

}
