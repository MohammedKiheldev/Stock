package com.stock.controller;

import com.stock.dto.invoice.CreateInvoiceDTO;
import com.stock.dto.invoice.InvoiceDTO;
import com.stock.dto.invoice.UpdateInvoiceDTO;
import com.stock.service.InvoiceService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class InvoiceControllerTest {

    @Mock
    private InvoiceService invoiceService; // Mock of InvoiceService

    @InjectMocks
    private InvoiceController invoiceController; // Instance of InvoiceController with injected mocks

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this); // Initialize the mocks
    }

    @Test
    void testGetAllInvoices() {
        // Prepare mock data
        List<InvoiceDTO> invoiceList = new ArrayList<>();
        when(invoiceService.getAllInvoices()).thenReturn(invoiceList);

        // Call the controller method
        List<InvoiceDTO> response = invoiceController.getAllInvoices();

        // Compare the expected and actual results
        assertEquals(invoiceList, response);
    }

    @Test
    void testGetInvoiceById() {
        Long invoiceId = 1L;
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        when(invoiceService.getInvoiceById(invoiceId)).thenReturn(invoiceDTO);

        InvoiceDTO response = invoiceController.getInvoiceById(invoiceId);

        assertEquals(invoiceDTO, response);
    }

    @Test
    void testCreateInvoice() {
        CreateInvoiceDTO createInvoiceDTO = new CreateInvoiceDTO();
        InvoiceDTO newInvoice = new InvoiceDTO();
        when(invoiceService.createInvoice(createInvoiceDTO)).thenReturn(newInvoice);

        InvoiceDTO response = invoiceController.createInvoice(createInvoiceDTO);

        assertEquals(newInvoice, response);
    }

    @Test
    void testUpdateInvoice() {
        Long invoiceId = 1L;
        UpdateInvoiceDTO updateInvoiceDTO = new UpdateInvoiceDTO();
        InvoiceDTO updatedInvoice = new InvoiceDTO();
        when(invoiceService.updateInvoice(eq(invoiceId), any(UpdateInvoiceDTO.class))).thenReturn(updatedInvoice);

        InvoiceDTO response = invoiceController.updateInvoice(invoiceId, updateInvoiceDTO);

        assertEquals(updatedInvoice, response);
    }

    @Test
    void testDeleteInvoice() {
        Long invoiceId = 1L;
        when(invoiceService.deleteInvoice(invoiceId)).thenReturn(true);

        boolean response = invoiceController.deleteInvoice(invoiceId);

        assertEquals(true, response);
    }
}
