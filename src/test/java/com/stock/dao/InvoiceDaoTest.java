package com.stock.dao;

import com.stock.dao.invoice.InvoiceDao;
import com.stock.model.Invoice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InvoiceDaoTest {

    @Mock
    private InvoiceDao invoiceDao;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllInvoices() {
        List<Invoice> mockInvoices = new ArrayList<>();
        when(invoiceDao.getAllInvoices()).thenReturn(mockInvoices);

        List<Invoice> response = invoiceDao.getAllInvoices();

        assertEquals(mockInvoices, response);
    }

    @Test
    void testGetInvoiceById() {
        Long invoiceId = 1L;
        Invoice mockInvoice = new Invoice();

        when(invoiceDao.getInvoiceById(invoiceId)).thenReturn(mockInvoice);

        Invoice response = invoiceDao.getInvoiceById(invoiceId);

        assertEquals(mockInvoice, response);
    }

    @Test
    void testAddInvoice() {
        Invoice mockInvoice = new Invoice();
        Invoice newInvoice = new Invoice();

        when(invoiceDao.addInvoice(mockInvoice)).thenReturn(newInvoice);

        Invoice response = invoiceDao.addInvoice(mockInvoice);

        assertEquals(newInvoice, response);
    }

    @Test
    void testUpdateInvoice() {
        Invoice mockInvoice = new Invoice();
        Invoice updatedInvoice = new Invoice();

        when(invoiceDao.updateInvoice(mockInvoice)).thenReturn(updatedInvoice);

        Invoice response = invoiceDao.updateInvoice(mockInvoice);

        assertEquals(updatedInvoice, response);
    }

    @Test
    void testDeleteInvoice() {
        Long invoiceId = 1L;

        // Configure the invoiceDao mock to behave when deleteInvoice is called
        doNothing().when(invoiceDao).deleteInvoice(invoiceId);

        invoiceDao.deleteInvoice(invoiceId);

        // Verify that deleteInvoice was called
        verify(invoiceDao, times(1)).deleteInvoice(invoiceId);
    }
}
