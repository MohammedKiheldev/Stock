package com.stock.dao;

import com.stock.dao.command.CommandDao;
import com.stock.model.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CommandDaoTest {

    @Mock
    private CommandDao commandDao;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCommands() {
        List<Command> mockCommands = new ArrayList<>();
        when(commandDao.getAllCommands()).thenReturn(mockCommands);

        List<Command> response = commandDao.getAllCommands();

        assertEquals(mockCommands, response);
    }

    @Test
    void testGetCommandById() {
        Long commandId = 1L;
        Command mockCommand = new Command();

        when(commandDao.getCommandById(commandId)).thenReturn(mockCommand);

        Command response = commandDao.getCommandById(commandId);

        assertEquals(mockCommand, response);
    }

    @Test
    void testAddCommand() {
        Command mockCommand = new Command();
        Command newCommand = new Command();

        when(commandDao.addCommand(mockCommand)).thenReturn(newCommand);

        Command response = commandDao.addCommand(mockCommand);

        assertEquals(newCommand, response);
    }

    @Test
    void testUpdateCommand() {
        Command mockCommand = new Command();
        Command updatedCommand = new Command();

        when(commandDao.updateCommand(mockCommand)).thenReturn(updatedCommand);

        Command response = commandDao.updateCommand(mockCommand);

        assertEquals(updatedCommand, response);
    }

    @Test
    void testDeleteCommand() {
        Long commandId = 1L;

        // Configure the commandDao mock to behave when deleteCommand is called
        doNothing().when(commandDao).deleteCommand(commandId);

        commandDao.deleteCommand(commandId);

        // Verify that deleteCommand was called
        verify(commandDao, times(1)).deleteCommand(commandId);
    }
}
