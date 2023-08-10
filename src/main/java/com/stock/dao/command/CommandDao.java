package com.stock.dao.command;

import java.util.List;

import com.stock.model.Command;

// This interface defines methods for interacting with the Command entity in the data access layer
public interface CommandDao {

    // Retrieve a list of all commands
    List<Command> getAllCommands();

    // Retrieve a specific command by its ID
    Command getCommandById(Long id);

    // Add a new command to the database
    Command addCommand(Command command);

    // Update an existing command in the database
    Command updateCommand(Command command);

    // Delete a command from the database based on its ID
    void deleteCommand(Long id);
}
