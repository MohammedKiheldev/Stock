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

import java.util.List;

public interface CommandUtil {

    List<CommandDTO> convertToDTOs(List<Command> commands);

    CommandDTO convertToDTO(Command command);

    Command convertToEntity(CreateCommandDTO createCommandDTO);

    PointOfSale convertToEntity(PointOfSaleDTO pointOfSaleDTO);

    User convertToEntity(UserDTO userDTO);

    ProductCommand convertToEntity(CreateProductCommandDTO productCommandDTO);

    Product convertToEntity(ProductDTO productDTO);

    Command convertToEntity(UpdateCommandDTO updateCommandDTO);

    void generateNumber(Command command);

    double calculateTotalAmount(Command command);
}
