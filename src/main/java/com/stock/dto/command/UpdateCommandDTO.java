package com.stock.dto.command;

import java.util.Date;
import java.util.List;

import com.stock.dto.productCommand.CreateProductCommandDTO;
import com.stock.model.Invoice;
import com.stock.model.ProductCommand;
import com.stock.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCommandDTO {
    private String number; // Nouveau numéro de commande
    private Date date; // Nouvelle date de commande
    private int productQuantity; // Nouvelle quantité totale des produits dans la commande
    private List<CreateProductCommandDTO> products; // Nouvelle liste de produits inclus dans la commande
}
