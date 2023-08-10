package com.stock.controller;

import com.stock.dto.command.CommandDTO;
import com.stock.dto.command.CreateCommandDTO;
import com.stock.dto.command.UpdateCommandDTO;
import com.stock.service.CommandService;

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

class CommandControllerTest {

    @Mock
    private CommandService commandService; // Mock of CommandService

    @InjectMocks
    private CommandController commandController; // Instance of CommandController with injected mocks

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this); // Initialize the mocks
    }

    @Test
    void testGetAllCommands() {
        // Prepare mock data
        List<CommandDTO> commandList = new ArrayList<>();
        when(commandService.getAllCommands()).thenReturn(commandList);

        // Call the controller method
        List<CommandDTO> response = commandController.getAllCommands();

        // Compare the expected and actual results
        assertEquals(commandList, response);
    }

    @Test
    void testGetCommandById() {
        Long commandId = 1L;
        CommandDTO commandDTO = new CommandDTO();
        when(commandService.getCommandById(commandId)).thenReturn(commandDTO);

        CommandDTO response = commandController.getCommandById(commandId);

        assertEquals(commandDTO, response);
    }

    @Test
    void testCreateCommand() {
        CreateCommandDTO createCommandDTO = new CreateCommandDTO();
        CommandDTO newCommand = new CommandDTO();
        when(commandService.createCommand(createCommandDTO)).thenReturn(newCommand);

        CommandDTO response = commandController.createCommand(createCommandDTO);

        assertEquals(newCommand, response);
    }

    @Test
    void testUpdateCommand() {
        Long commandId = 1L;
        UpdateCommandDTO updateCommandDTO = new UpdateCommandDTO();
        CommandDTO updatedCommand = new CommandDTO();
        when(commandService.updateCommand(eq(commandId), any(UpdateCommandDTO.class))).thenReturn(updatedCommand);

        CommandDTO response = commandController.updateCommand(commandId, updateCommandDTO);

        assertEquals(updatedCommand, response);
    }

    @Test
    void testDeleteCommand() {
        Long commandId = 1L;
        when(commandService.deleteCommand(commandId)).thenReturn(true);

        boolean response = commandController.deleteCommand(commandId);

        assertEquals(true, response);
    }
}
