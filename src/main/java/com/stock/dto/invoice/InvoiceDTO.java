package com.stock.dto.invoice;

import java.util.Date;

import com.stock.dto.product.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor // Constructeur avec tous les champs
@NoArgsConstructor // Constructeur par défaut
@EqualsAndHashCode // Génère les méthodes equals() et hashCode()
@ToString // Génère la méthode toString()
@Getter // Génère les méthodes getter pour les champs
@Setter // Génère les méthodes setter pour les champs
public class InvoiceDTO {
    private Long id; // Identifiant de la facture
    private Date date; // Date de la facture
    private double amount; // Montant total de la facture
    private String number; // Numéro de la facture
}
