package com.stock.util.invoice;

import java.util.List;

import com.stock.dto.command.CommandDTO;
import com.stock.dto.invoice.CreateInvoiceDTO;
import com.stock.dto.invoice.InvoiceDTO;
import com.stock.dto.invoice.UpdateInvoiceDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.model.Command;
import com.stock.model.Invoice;
import com.stock.model.PointOfSale;

public interface InvoiceUtil {

    // Generates a unique invoice number based on the date and invoice ID
    void generateNumber(Invoice invoice);

    // Calculates the total amount for a given command
    double calculateTotalAmount(Command command);
    
    // Convert a list of Invoice entities to a list of InvoiceDTOs
    List<InvoiceDTO> convertToDTOs(List<Invoice> invoices);

    // Convert an Invoice entity to an InvoiceDTO
    InvoiceDTO convertToDTO(Invoice invoice);

    // Convert a CreateInvoiceDTO to an Invoice entity
    Invoice convertToEntity(CreateInvoiceDTO createInvoiceDTO);
    
    // Convert a PointOfSaleDTO to a PointOfSale entity
    PointOfSale convertToEntity(PointOfSaleDTO pointOfSaleDTO);
    
    // Convert a CommandDTO to a Command entity
    Command convertToEntity(CommandDTO commandDTO);

    // Convert an UpdateInvoiceDTO to an Invoice entity
    Invoice convertToEntity(UpdateInvoiceDTO updateInvoiceDTO);
}
