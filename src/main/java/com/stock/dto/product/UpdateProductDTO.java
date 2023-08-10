package com.stock.dto.product;

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
public class UpdateProductDTO {
    private String name; // Nouveau nom du produit à mettre à jour
    private double price; // Nouveau prix du produit à mettre à jour
    private double minimumPrice; // Nouveau prix minimum du produit à mettre à jour
    private int quantityInStock; // Nouvelle quantité en stock du produit à mettre à jour
    private String description; // Nouvelle description du produit à mettre à jour
}
