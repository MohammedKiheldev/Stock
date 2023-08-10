package com.stock.dao.invoice;

import com.stock.model.Invoice;
import com.stock.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// This class implements the InvoiceDao interface and interacts with the database
@Repository
public class InvoiceDaoImpl implements InvoiceDao {

    @Autowired
    private InvoiceRepository invoiceRepository;

    // Retrieve a list of all invoices from the database
    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // Retrieve a specific invoice by its ID from the database
    @Override
    public Invoice getInvoiceById(Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice.orElse(null);
    }

    // Add a new invoice to the database
    @Override
    public Invoice addInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    // Update an existing invoice in the database
    @Override
    public Invoice updateInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    // Delete an invoice from the database based on its ID
    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
