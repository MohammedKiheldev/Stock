package com.stock.dao.command;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stock.model.Command;
import com.stock.repository.CommandRepository;

// This class implements the CommandDao interface and interacts with the database
@Repository
public class CommandDaoImpl implements CommandDao {

    @Autowired
    private CommandRepository commandRepository;

    // Retrieve a list of all commands from the database
    @Override
    public List<Command> getAllCommands() {
        return commandRepository.findAll();
    }

    // Retrieve a specific command by its ID from the database
    @Override
    public Command getCommandById(Long id) {
        Optional<Command> command = commandRepository.findById(id);
        return command.orElse(null);
    }

    // Add a new command to the database
    @Override
    public Command addCommand(Command command) {
        return commandRepository.save(command);
    }

    // Update an existing command in the database
    @Override
    public Command updateCommand(Command command) {
        return commandRepository.save(command);
    }

    // Delete a command from the database based on its ID
    @Override
    public void deleteCommand(Long id) {
        commandRepository.deleteById(id);
    }
}
