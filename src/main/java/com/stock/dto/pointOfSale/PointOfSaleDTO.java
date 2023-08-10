package com.stock.dto.pointOfSale;

import com.stock.dto.product.ProductDTO; // Import d'une classe externe

import lombok.AllArgsConstructor; // Annotation pour générer un constructeur avec tous les champs
import lombok.EqualsAndHashCode; // Annotation pour générer les méthodes equals() et hashCode()
import lombok.Getter; // Annotation pour générer les méthodes getter pour les champs
import lombok.NoArgsConstructor; // Annotation pour générer un constructeur sans arguments
import lombok.Setter; // Annotation pour générer les méthodes setter pour les champs
import lombok.ToString; // Annotation pour générer la méthode toString()

@AllArgsConstructor // Constructeur avec tous les champs
@NoArgsConstructor // Constructeur sans arguments
@EqualsAndHashCode // Génère les méthodes equals() et hashCode()
@ToString // Génère la méthode toString()
@Getter // Génère les méthodes getter pour les champs
@Setter // Génère les méthodes setter pour les champs
public class PointOfSaleDTO {
    private Long id; // Identifiant du point de vente
    private String name; // Nom du point de vente
    private String address; // Adresse du point de vente
    private int quantity; // Quantité associée au point de vente
}
