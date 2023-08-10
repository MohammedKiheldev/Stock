package com.stock.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stock.dao.command.CommandDao;
import com.stock.dao.invoice.InvoiceDao;
import com.stock.dto.invoice.CreateInvoiceDTO;
import com.stock.dto.invoice.InvoiceDTO;
import com.stock.dto.invoice.UpdateInvoiceDTO;
import com.stock.model.Command;
import com.stock.model.Invoice;
import com.stock.service.InvoiceService;
import com.stock.util.invoice.InvoiceUtil;

import java.util.ArrayList;
import java.util.List;

class InvoiceServiceTest {

    @Mock
    private InvoiceDao invoiceDao;

    @Mock
    private CommandDao commandDao;

    @Mock
    private InvoiceUtil invoiceUtil;

    @InjectMocks
    private InvoiceService invoiceService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllInvoices() {
        List<Invoice> mockInvoiceList = new ArrayList<>();
        List<InvoiceDTO> mockDTOList = new ArrayList<>();

        when(invoiceDao.getAllInvoices()).thenReturn(mockInvoiceList);
        when(invoiceUtil.convertToDTOs(mockInvoiceList)).thenReturn(mockDTOList);

        List<InvoiceDTO> response = invoiceService.getAllInvoices();

        assertEquals(mockDTOList, response);
    }

    @Test
    void testGetInvoiceById() {
        Long invoiceId = 1L;
        Invoice mockInvoice = new Invoice();
        InvoiceDTO mockDTO = new InvoiceDTO();

        when(invoiceDao.getInvoiceById(invoiceId)).thenReturn(mockInvoice);
        when(invoiceUtil.convertToDTO(mockInvoice)).thenReturn(mockDTO);

        InvoiceDTO response = invoiceService.getInvoiceById(invoiceId);

        assertEquals(mockDTO, response);
    }

    @Test
    void testUpdateInvoice() {
        Long invoiceId = 1L;
        UpdateInvoiceDTO updateDTO = new UpdateInvoiceDTO();
        Invoice mockInvoice = new Invoice();
        Invoice updatedInvoice = new Invoice();
        InvoiceDTO mockDTO = new InvoiceDTO();

        // Configure the mock command
        Command command = new Command();
        when(invoiceDao.getInvoiceById(invoiceId)).thenReturn(mockInvoice);
        when(invoiceUtil.convertToEntity(updateDTO)).thenReturn(updatedInvoice);
        when(invoiceUtil.calculateTotalAmount(command)).thenReturn(100.0); // Mock the total amount calculation
        when(invoiceDao.updateInvoice(updatedInvoice)).thenReturn(updatedInvoice);
        when(invoiceUtil.convertToDTO(updatedInvoice)).thenReturn(mockDTO);

        InvoiceDTO response = invoiceService.updateInvoice(invoiceId, updateDTO);

        assertEquals(mockDTO, response);
    }

    @Test
    void testDeleteInvoiceFailure() {
        Long invoiceId = 1L;

        // Configure the invoiceDao mock to throw an exception when deleteInvoice is called
        doThrow(new RuntimeException("Deletion failed")).when(invoiceDao).deleteInvoice(invoiceId);

        boolean response = invoiceService.deleteInvoice(invoiceId);

        assertFalse(response);
    }
}
