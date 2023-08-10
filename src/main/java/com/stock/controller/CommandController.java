// Import necessary classes and packages
package com.stock.controller;

import com.stock.dto.command.CommandDTO;
import com.stock.dto.command.CreateCommandDTO;
import com.stock.dto.command.UpdateCommandDTO;
import com.stock.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Declare this class as a RestController and map it to the "/command" route
@RestController
@RequestMapping("/command")
public class CommandController {

    // Automatically inject the CommandService dependency
    @Autowired
    private CommandService commandService;

    // Handle HTTP GET request to retrieve all commands
    @GetMapping
    public List<CommandDTO> getAllCommands() {
        return commandService.getAllCommands();
    }

    // Handle HTTP GET request to retrieve a command by its ID
    @GetMapping("/{id}")
    public CommandDTO getCommandById(@PathVariable Long id) {
        return commandService.getCommandById(id);
    }

    // Handle HTTP POST request to create a new command
    @PostMapping
    public CommandDTO createCommand(@RequestBody CreateCommandDTO createCommandDTO) {
        return commandService.createCommand(createCommandDTO);
    }

    // Handle HTTP PUT request to update an existing command by its ID
    @PutMapping("/{id}")
    public CommandDTO updateCommand(@PathVariable Long id, @RequestBody UpdateCommandDTO updatedCommandDTO) {
        return commandService.updateCommand(id, updatedCommandDTO);
    }

    // Handle HTTP DELETE request to delete a command by its ID
    @DeleteMapping("/{id}")
    public boolean deleteCommand(@PathVariable Long id) {
        return commandService.deleteCommand(id);
    }
}
