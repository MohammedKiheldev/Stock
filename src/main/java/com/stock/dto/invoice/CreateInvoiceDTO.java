package com.stock.dto.invoice;

import java.util.Date;
import java.util.List;

import com.stock.dto.command.CommandDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInvoiceDTO {
    private PointOfSaleDTO pointOfSale; // Point de vente associé à la facture
    private CommandDTO command; // Commande associée à la facture
}
