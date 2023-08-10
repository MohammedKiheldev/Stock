package com.stock.dto.command;

import java.util.Date;
import java.util.List;

import com.stock.model.ProductCommand;
import com.stock.model.User;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Lombok annotations for generating common boilerplate code
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class CommandDTO {
    private Long id; // ID de la commande
    private String number; // Numéro de la commande
    private Date date; // Date de la commande
    private int productQuantity; // Quantité totale des produits dans la commande
    private List<ProductCommand> products; // Liste des produits inclus dans la commande
    private User salesAgent; // Agent de vente associé à la commande
}
