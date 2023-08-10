package com.stock.util.invoice;

import com.stock.dto.command.CommandDTO;
import com.stock.dto.invoice.CreateInvoiceDTO;
import com.stock.dto.invoice.InvoiceDTO;
import com.stock.dto.invoice.UpdateInvoiceDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.model.Command;
import com.stock.model.Invoice;
import com.stock.model.PointOfSale;
import com.stock.model.ProductCommand;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InvoiceUtilImpl implements InvoiceUtil {

    @Override
    public void generateNumber(Invoice invoice) {
        // Ensure that the invoice has a valid date before generating the number
        if (invoice.getDate() == null) {
            invoice.setDate(new Date());
        }

        // Format the date as a string in "yyyyMMdd" format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateStr = sdf.format(invoice.getDate());

        // Append a three-digit representation of the invoice ID to the date
        String numberStr = dateStr + "-" + String.format("%03d", invoice.getId());

        // Set the generated number as the invoice's number
        invoice.setNumber(numberStr);
    }

    @Override
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
    
 // Convert a list of Invoice entities to a list of InvoiceDTOs
    public List<InvoiceDTO> convertToDTOs(List<Invoice> invoices) {
        List<InvoiceDTO> dtos = new ArrayList<>();
        for (Invoice invoice : invoices) {
            dtos.add(convertToDTO(invoice));
        }
        return dtos;
    }

    // Convert an Invoice entity to an InvoiceDTO
    public InvoiceDTO convertToDTO(Invoice invoice) {
        InvoiceDTO dto = new InvoiceDTO();
        // Convert Invoice entity properties to corresponding InvoiceDTO properties
        return dto;
    }

    // Convert a CreateInvoiceDTO to an Invoice entity
    public Invoice convertToEntity(CreateInvoiceDTO createInvoiceDTO) {
        Invoice invoice = new Invoice();
        
        // Convert PointOfSaleDTO to PointOfSale entity
        PointOfSale pointOfSale = convertToEntity(createInvoiceDTO.getPointOfSale());
        invoice.setPointOfSale(pointOfSale);
        
        // Convert CommandDTO to Command entity
        Command command = convertToEntity(createInvoiceDTO.getCommand());
        invoice.setCommand(command);
        
        // Map other properties from CreateInvoiceDTO to Invoice entity
        return invoice;
    }
    
    // Convert a PointOfSaleDTO to a PointOfSale entity
    public PointOfSale convertToEntity(PointOfSaleDTO pointOfSaleDTO) {
        PointOfSale pointOfSale = new PointOfSale();
        pointOfSale.setId(pointOfSaleDTO.getId());
        // Map other properties from PointOfSaleDTO to PointOfSale entity
        return pointOfSale;
    }
    
    // Convert a CommandDTO to a Command entity
    public Command convertToEntity(CommandDTO commandDTO) {
        Command command = new Command();
        command.setId(commandDTO.getId());
        // Map other properties from CommandDTO to Command entity
        return command;
    }

    // Convert an UpdateInvoiceDTO to an Invoice entity
    public Invoice convertToEntity(UpdateInvoiceDTO updateInvoiceDTO) {
        Invoice invoice = new Invoice();
        // Map properties from UpdateInvoiceDTO to Invoice entity
        return invoice;
    }
}
