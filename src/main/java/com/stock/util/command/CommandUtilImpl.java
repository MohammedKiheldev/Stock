package com.stock.util.command;

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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CommandUtilImpl implements CommandUtil {

    @Override
    public List<CommandDTO> convertToDTOs(List<Command> commands) {
        List<CommandDTO> dtos = new ArrayList<>();
        for (Command command : commands) {
            dtos.add(convertToDTO(command));
        }
        return dtos;
    }

    @Override
    public CommandDTO convertToDTO(Command command) {
        CommandDTO dto = new CommandDTO();
        // Your logic for converting products to ProductCommandDTO
        // dto.setProducts(...);
        return dto;
    }

    @Override
    public Command convertToEntity(CreateCommandDTO createCommandDTO) {
        Command command = new Command();
        // Map other fields as needed

        // Convert UserDTO to User entity and set as sales agent
        User salesAgent = convertToEntity(createCommandDTO.getSalesAgent());
        command.setSalesAgent(salesAgent);
        
        // Convert PointOfSaleDTO to PointOfSale entity
        PointOfSale pointOfSale = convertToEntity(createCommandDTO.getPointOfSale());
        command.setPointOfSale(pointOfSale);

        List<ProductCommand> productCommands = new ArrayList<>();
        for (CreateProductCommandDTO productCommandDTO : createCommandDTO.getProducts()) {
            // Convert CreateProductCommandDTO to ProductCommand entity
            ProductCommand productCommand = convertToEntity(productCommandDTO);
            productCommands.add(productCommand);
        }
        command.setProducts(productCommands);
        return command;
    }

    @Override
    public PointOfSale convertToEntity(PointOfSaleDTO pointOfSaleDTO) {
        PointOfSale pointOfSale = new PointOfSale();
        pointOfSale.setId(pointOfSaleDTO.getId());
        return pointOfSale;
    }

    @Override
    public User convertToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        // Map other fields as needed
        return user;
    }

    @Override
    public ProductCommand convertToEntity(CreateProductCommandDTO productCommandDTO) {
        ProductCommand productCommand = new ProductCommand();
        // Convert ProductDTO to Product entity
        Product product = convertToEntity(productCommandDTO.getProduct());
        
        productCommand.setProduct(product);
        productCommand.setQuantityInCommand(productCommandDTO.getQuantityInCommand());
        // Map fields from DTO to entity
        return productCommand;
    }

    @Override
    public Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        
        product.setId(productDTO.getId());
        // Map fields from DTO to entity
        return product;
    }

    @Override
    public Command convertToEntity(UpdateCommandDTO updateCommandDTO) {
        if (updateCommandDTO == null) {
            return null;
        }

        Command command = new Command();
        // Fill in the command properties with values from updateCommandDTO

        return command;
    }
    
    // Generates a unique command number based on the date and command ID
    public void generateNumber(Command command) {
        // Ensure that the command has a valid date before generating the number
        if (command.getDate() == null) {
            command.setDate(new Date());
        }

        // Format the date as a string in "yyyyMMdd" format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = sdf.format(command.getDate());

        // Append a three-digit representation of the command ID to the date
        String numberStr = dateStr + "-" + String.format("%03d", command.getId());

        // Set the generated number as the command's number
        command.setNumber(numberStr);
    }

    // Calculates the total amount for a given command
    public double calculateTotalAmount(Command command) {
        double totalAmount = 0;
        // Iterate through the products associated with the command
        for (ProductCommand productCommand : command.getProducts()) {
            double unitPrice = productCommand.getUnitPrice();
            int quantityOrdered = productCommand.getQuantityInCommand();

            // Calculate the total amount for the product and accumulate
            totalAmount += (unitPrice * quantityOrdered);
        }
        return totalAmount;
    }
}
