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
public class CreatePointOfSaleDTO {
    private String name; // Nom du point de vente à créer
    private String address; // Adresse du point de vente à créer
    private int quantity; // Quantité associée au point de vente à créer

    public CreatePointOfSaleDTO() {
        // Constructeur par défaut
    }
}
