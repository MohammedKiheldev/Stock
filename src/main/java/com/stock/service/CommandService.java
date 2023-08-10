package com.stock.service;

import com.stock.dao.command.CommandDao;
import com.stock.dao.invoice.InvoiceDao;
import com.stock.dao.product.ProductDao;
import com.stock.dto.command.CommandDTO;
import com.stock.dto.command.CreateCommandDTO;
import com.stock.dto.command.UpdateCommandDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.product.ProductDTO;
import com.stock.dto.productCommand.CreateProductCommandDTO;
import com.stock.dto.productCommand.ProductCommandDTO;
import com.stock.dto.user.UserDTO;
import com.stock.model.Command;
import com.stock.model.PointOfSale;
import com.stock.model.Product;
import com.stock.model.ProductCommand;
import com.stock.model.User;
import com.stock.util.command.CommandUtil;
import com.stock.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommandService {

    @Autowired
    private CommandDao commandDao;
    
    @Autowired
    private InvoiceDao invoiceDao;
    
    @Autowired
    private CommandUtil commandUtil;
    

    @Autowired
    private ProductDao productDao;

    public List<CommandDTO> getAllCommands() {
        List<Command> commands = commandDao.getAllCommands();
        return commandUtil.convertToDTOs(commands);
    }

    public CommandDTO getCommandById(Long id) {
        Command command = commandDao.getCommandById(id);
        if (command != null) {
            return commandUtil.convertToDTO(command);
        } else {
            return null;
        }
    }

    @Transactional
    public CommandDTO createCommand(CreateCommandDTO createCommandDTO) {
        Command command = commandUtil.convertToEntity(createCommandDTO);
        
        int productQuantity = 0;
        for (ProductCommand productCommand : command.getProducts()) {
            productQuantity += productCommand.getQuantityInCommand();
        }

        boolean useMinimumPrice = productQuantity >= 3;
        System.out.println("Use minimum price: " + useMinimumPrice);

        for (ProductCommand productCommand : command.getProducts()) {
            Long productId = productCommand.getProduct().getId();
            Product existingProduct = productDao.getProductById(productId);
            if (existingProduct != null) {
                double unitPrice = useMinimumPrice ? existingProduct.getMinimumPrice() : existingProduct.getPrice();
                productCommand.setUnitPrice(unitPrice);

                productCommand.setCommand(command);
                // Decrease the product quantity in stock
                int quantityInCommand = productCommand.getQuantityInCommand();
                existingProduct.setQuantityInStock(existingProduct.getQuantityInStock() - quantityInCommand);

                // Decrease the product quantity in the PointOfSale
                PointOfSale pointOfSale = existingProduct.getPointOfSale();
                pointOfSale.setQuantity(pointOfSale.getQuantity() - quantityInCommand);
            }
        }

        // Set the total quantity of products in the command
        command.setProductQuantity(productQuantity);

        // Save the command in the database to generate the ID and update the product quantity in stock
        Command savedCommand = commandDao.addCommand(command);

        // Generate the command number using the newly generated ID
        commandUtil.generateNumber(savedCommand);

        // Save the command again to update the command number in the database

        return commandUtil.convertToDTO(savedCommand);
    }
    
    @Transactional
    public CommandDTO updateCommand(Long id, UpdateCommandDTO updatedCommandDTO) {
        Command existingCommand = commandDao.getCommandById(id);

        if (existingCommand != null) {
            // Update fields of the existing command with data from updatedCommandDTO
            existingCommand.setNumber(updatedCommandDTO.getNumber());
            existingCommand.setDate(new Date());
            

            List<ProductCommand> Products = existingCommand.getProducts();
            
            for (ProductCommand productCommand : Products) {
            	Long productId = productCommand.getProduct().getId();

                Product existingProduct = productDao.getProductById(productId);
                
                if (existingProduct != null) {
                   

                    productCommand.setCommand(existingCommand);
                    
                    int quantityInCommand = productCommand.getQuantityInCommand();
                    existingProduct.setQuantityInStock(existingProduct.getQuantityInStock() + quantityInCommand);

                   
                    PointOfSale pointOfSale = existingProduct.getPointOfSale();
                    pointOfSale.setQuantity(pointOfSale.getQuantity() + quantityInCommand);
                }
                
                
            }
           
            List<CreateProductCommandDTO> updatedProducts = updatedCommandDTO.getProducts();

            // Calculate the total quantity of products in the updated command
            int productQuantity = 0;
            for (CreateProductCommandDTO productCommand : updatedProducts) {
                productQuantity += productCommand.getQuantityInCommand();
            }
            
            existingCommand.setProductQuantity(productQuantity);

            // Check if the quantity of products exceeds 3
            boolean useMinimumPrice = productQuantity >= 3;

            List<ProductCommand> productCommands = new ArrayList<>();
            for (CreateProductCommandDTO productCommandDTO : updatedProducts) {
                ProductCommand productCommand = commandUtil.convertToEntity(productCommandDTO);
                productCommands.add(productCommand);
            }

            // Update the existing products' properties
            for (ProductCommand productCommand : productCommands) {
                // You need to fetch the existing ProductCommand and update its properties
                // instead of creating new ProductCommand instances
                /*ProductCommand existingProductCommand = getExistingProductCommand(existingCommand, productCommand);
                if (existingProductCommand != null) {
                    // Update the existingProductCommand properties here
                    double unitPrice = useMinimumPrice ? existingProductCommand.getProduct().getMinimumPrice() : existingProductCommand.getProduct().getPrice();
                    existingProductCommand.setUnitPrice(unitPrice);
                    // Other updates as needed
                }*/
            	
            	Long productId = productCommand.getProduct().getId();
            	
                Product existingProduct = productDao.getProductById(productId);
                
                if (existingProduct != null) {
                    double unitPrice = useMinimumPrice ? existingProduct.getMinimumPrice() : existingProduct.getPrice();
                    productCommand.setUnitPrice(unitPrice);

                    productCommand.setCommand(existingCommand);
                    // Decrease the product quantity in stock
                    int quantityInCommand = productCommand.getQuantityInCommand();
                    existingProduct.setQuantityInStock(existingProduct.getQuantityInStock() - quantityInCommand);

                    // Decrease the product quantity in the PointOfSale
                    PointOfSale pointOfSale = existingProduct.getPointOfSale();
                    pointOfSale.setQuantity(pointOfSale.getQuantity() - quantityInCommand );
                }
            	
            	
            }

            // Update the list of products in the existingCommand
            existingCommand.getProducts().clear();
            existingCommand.getProducts().addAll(productCommands);

            // Save the updated command in the database 
            Command savedCommand = commandDao.updateCommand(existingCommand);

            // Generate the command number using the existing ID
            commandUtil.generateNumber(savedCommand);
            
            List<Invoice> invoices = invoiceDao.getAllInvoices();
            for (Invoice invoice : invoices) {
            	if(invoice.getCommand().getId() == existingCommand.getId()) {
            		double totalAmount = commandUtil.calculateTotalAmount(invoice.getCommand());
            		invoice.setAmount(totalAmount);
                    invoiceDao.addInvoice(invoice);
            	}
            }
            

            // Save the command again to update the command number in the database
            savedCommand = commandDao.updateCommand(savedCommand);

            return commandUtil.convertToDTO(savedCommand);
        }

        return null; // Return null if the command with the given ID doesn't exist
    }

    public boolean deleteCommand(Long id) {
        Command existingCommand = commandDao.getCommandById(id);
        if (existingCommand != null) {
        	List<ProductCommand> Products = existingCommand.getProducts();
            
            for (ProductCommand productCommand : Products) {
            	Long productId = productCommand.getProduct().getId();

                Product existingProduct = productDao.getProductById(productId);
                
                if (existingProduct != null) {
                   

                    productCommand.setCommand(existingCommand);
                    
                    int quantityInCommand = productCommand.getQuantityInCommand();
                    existingProduct.setQuantityInStock(existingProduct.getQuantityInStock() + quantityInCommand);

                   
                    PointOfSale pointOfSale = existingProduct.getPointOfSale();
                    pointOfSale.setQuantity(pointOfSale.getQuantity() + quantityInCommand);
                }
                
                
            }
            
            long idInvoice = 0;
            List<Invoice> invoices = invoiceDao.getAllInvoices();
            for (Invoice invoice : invoices) {
            	if(invoice.getCommand().getId() == existingCommand.getId()) {
            		idInvoice = invoice.getId();
            	}
            }
            invoiceDao.deleteInvoice(idInvoice);
            commandDao.deleteCommand(id);
            
            return true;
        } else {
            return false;
        }
    }

	
}
