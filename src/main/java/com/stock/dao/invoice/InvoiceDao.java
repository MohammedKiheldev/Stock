package com.stock.dao.invoice;

import com.stock.model.Invoice;

import java.util.List;

// This interface defines methods for interacting with the Invoice entity in the data access layer
public interface InvoiceDao {

    // Retrieve a list of all invoices
    List<Invoice> getAllInvoices();

    // Retrieve a specific invoice by its ID
    Invoice getInvoiceById(Long id);

    // Add a new invoice to the database
    Invoice addInvoice(Invoice invoice);

    // Update an existing invoice in the database
    Invoice updateInvoice(Invoice invoice);

    // Delete an invoice from the database based on its ID
    void deleteInvoice(Long id);
}
