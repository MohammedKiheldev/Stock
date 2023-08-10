package com.stock.dto.pointOfSale;

import lombok.AllArgsConstructor; // Annotation pour générer un constructeur avec tous les champs
import lombok.EqualsAndHashCode; // Annotation pour générer les méthodes equals() et hashCode()
import lombok.Getter; // Annotation pour générer les méthodes getter pour les champs
import lombok.Setter; // Annotation pour générer les méthodes setter pour les champs
import lombok.ToString; // Annotation pour générer la méthode toString()

@AllArgsConstructor // Constructeur avec tous les champs
@EqualsAndHashCode // Génère les méthodes equals() et hashCode()
@ToString // Génère la méthode toString()
@Getter // Génère les méthodes getter pour les champs
@Setter // Génère les méthodes setter pour les champs
public class UpdatePointOfSaleDTO {
    private String name; // Nouveau nom du point de vente
    private String address; // Nouvelle adresse du point de vente
    private int quantity; // Nouvelle quantité associée au point de vente

    public UpdatePointOfSaleDTO() {
    }
}
