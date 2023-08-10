package com.stock.dto.command;

import java.util.List;

import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.productCommand.CreateProductCommandDTO;
import com.stock.dto.user.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommandDTO {
    
    private UserDTO salesAgent; // Agent de vente associé à la commande
    private PointOfSaleDTO pointOfSale; // Point de vente associé à la commande
    private List<CreateProductCommandDTO> products; // Liste des produits inclus dans la commande
}
