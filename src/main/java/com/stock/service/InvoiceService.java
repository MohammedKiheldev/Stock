package com.stock.service;


import com.stock.dao.command.CommandDao;
import com.stock.dao.invoice.InvoiceDao;
import com.stock.dto.command.CommandDTO;
import com.stock.dto.invoice.CreateInvoiceDTO;
import com.stock.dto.invoice.InvoiceDTO;
import com.stock.dto.invoice.UpdateInvoiceDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.model.Command;
import com.stock.model.Invoice;
import com.stock.model.PointOfSale;
import com.stock.model.ProductCommand;
import com.stock.model.User;
import com.stock.util.invoice.InvoiceUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private CommandDao commandDao;
    
    @Autowired
    private InvoiceUtil invoiceUtil;
    

    public List<InvoiceDTO> getAllInvoices() {
        List<Invoice> invoices = invoiceDao.getAllInvoices();
        return invoiceUtil.convertToDTOs(invoices);
    }

    public InvoiceDTO getInvoiceById(Long id) {
        Invoice invoice = invoiceDao.getInvoiceById(id);
        if (invoice != null) {
            return invoiceUtil.convertToDTO(invoice);
        } else {
            return null;
        }
    }

    public InvoiceDTO createInvoice(CreateInvoiceDTO createInvoiceDTO) {
        Invoice invoice = invoiceUtil.convertToEntity(createInvoiceDTO);

        invoice.setDate(new Date());
        Command command = commandDao.getCommandById(invoice.getCommand().getId());
        // Calculate the total amount (montant) based on the unit prices of products in the associated Command
        double totalAmount = invoiceUtil.calculateTotalAmount(command);
        invoice.setAmount(totalAmount);

        invoiceDao.updateInvoice(invoice);
        // Generate the invoice number using the newly generated ID
        invoiceUtil.generateNumber(invoice);

        // Save the invoice in the database
        Invoice savedInvoice = invoiceDao.addInvoice(invoice);

        return invoiceUtil.convertToDTO(savedInvoice);
    }

    public InvoiceDTO updateInvoice(Long id, UpdateInvoiceDTO updateInvoiceDTO) {
        // Get the existing invoice by its ID
        Invoice existingInvoice = invoiceDao.getInvoiceById(id);
        existingInvoice.setDate(new Date());
        if (existingInvoice != null) {
            Invoice updatedInvoice = invoiceUtil.convertToEntity(updateInvoiceDTO);
            updatedInvoice.setId(id);

            // Calculate the total amount (montant) based on the unit prices of products in the associated Command
            double totalAmount = invoiceUtil.calculateTotalAmount(updatedInvoice.getCommand());
            updatedInvoice.setAmount(totalAmount);

            invoiceDao.updateInvoice(updatedInvoice);
            // Generate the invoice number using the existing ID
            invoiceUtil.generateNumber(updatedInvoice);

            // Update the invoice in the database
            Invoice savedInvoice = invoiceDao.updateInvoice(updatedInvoice);

            return invoiceUtil.convertToDTO(savedInvoice);
        } else {
            return null;
        }
    }
    public boolean deleteInvoice(Long id) {
        Invoice existingInvoice = invoiceDao.getInvoiceById(id);
        if (existingInvoice != null) {
            invoiceDao.deleteInvoice(id);
            return true;
        } else {
            return false;
        }
    }
}
