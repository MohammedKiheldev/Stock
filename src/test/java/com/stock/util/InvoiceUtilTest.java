package com.stock.util;

import com.stock.dto.command.CommandDTO;
import com.stock.dto.invoice.CreateInvoiceDTO;
import com.stock.dto.invoice.InvoiceDTO;
import com.stock.dto.invoice.UpdateInvoiceDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.model.Command;
import com.stock.model.Invoice;
import com.stock.model.PointOfSale;
import com.stock.util.invoice.InvoiceUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InvoiceUtilTest {

    @Mock
    private InvoiceUtil invoiceUtil;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGenerateNumber() {
        Invoice mockInvoice = new Invoice();

        invoiceUtil.generateNumber(mockInvoice);

        // Add assertions based on the behavior of the generateNumber method
    }

    @Test
    void testCalculateTotalAmount() {
        Command mockCommand = new Command();
        double mockTotalAmount = 100.0;

        when(invoiceUtil.calculateTotalAmount(mockCommand)).thenReturn(mockTotalAmount);

        double response = invoiceUtil.calculateTotalAmount(mockCommand);

        assertEquals(mockTotalAmount, response);
    }

    @Test
    void testConvertToDTOs() {
        List<Invoice> mockInvoices = new ArrayList<>();
        List<InvoiceDTO> mockDTOs = new ArrayList<>();

        when(invoiceUtil.convertToDTOs(mockInvoices)).thenReturn(mockDTOs);

        List<InvoiceDTO> response = invoiceUtil.convertToDTOs(mockInvoices);

        assertEquals(mockDTOs, response);
    }

    @Test
    void testConvertToDTO() {
        Invoice mockInvoice = new Invoice();
        InvoiceDTO mockDTO = new InvoiceDTO();

        when(invoiceUtil.convertToDTO(mockInvoice)).thenReturn(mockDTO);

        InvoiceDTO response = invoiceUtil.convertToDTO(mockInvoice);

        assertEquals(mockDTO, response);
    }

    // Similarly, add test cases for other methods like convertToEntity, generateNumber, calculateTotalAmount, etc.
}
