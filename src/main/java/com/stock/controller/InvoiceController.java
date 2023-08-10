// Import necessary classes and packages
package com.stock.controller;

import com.stock.dto.invoice.CreateInvoiceDTO;
import com.stock.dto.invoice.InvoiceDTO;
import com.stock.dto.invoice.UpdateInvoiceDTO;
import com.stock.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Declare this class as a RestController and map it to the "/invoice" route
@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    // Automatically inject the InvoiceService dependency
    @Autowired
    private InvoiceService invoiceService;

    // Handle HTTP GET request to retrieve all invoices
    @GetMapping
    public List<InvoiceDTO> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // Handle HTTP GET request to retrieve an invoice by its ID
    @GetMapping("/{id}")
    public InvoiceDTO getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }

    // Handle HTTP POST request to create a new invoice
    @PostMapping
    public InvoiceDTO createInvoice(@RequestBody CreateInvoiceDTO createInvoiceDTO) {
        return invoiceService.createInvoice(createInvoiceDTO);
    }

    // Handle HTTP PUT request to update an existing invoice by its ID
    @PutMapping("/{id}")
    public InvoiceDTO updateInvoice(@PathVariable Long id, @RequestBody UpdateInvoiceDTO updateInvoiceDTO) {
        return invoiceService.updateInvoice(id, updateInvoiceDTO);
    }

    // Handle HTTP DELETE request to delete an invoice by its ID
    @DeleteMapping("/{id}")
    public boolean deleteInvoice(@PathVariable Long id) {
        return invoiceService.deleteInvoice(id);
    }
}
