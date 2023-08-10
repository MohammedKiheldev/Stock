package com.stock.dto.productCommand;

import lombok.AllArgsConstructor; // Annotation pour générer un constructeur avec tous les champs
import lombok.EqualsAndHashCode; // Annotation pour générer les méthodes equals et hashCode
import lombok.Getter; // Annotation pour générer les méthodes getter pour les champs
import lombok.NoArgsConstructor; // Annotation pour générer un constructeur sans arguments
import lombok.Setter; // Annotation pour générer les méthodes setter pour les champs
import lombok.ToString; // Annotation pour générer la méthode toString
import com.stock.dto.command.CommandDTO; // Import de la classe CommandDTO
import com.stock.dto.product.ProductDTO; // Import de la classe ProductDTO

@AllArgsConstructor // Génère un constructeur avec tous les champs
@NoArgsConstructor // Génère un constructeur sans arguments
@EqualsAndHashCode // Génère les méthodes equals et hashCode pour la comparaison d'objets
@ToString // Génère la méthode toString pour afficher l'objet sous forme de chaîne de caractères
@Getter // Génère les méthodes getter pour les champs
@Setter // Génère les méthodes setter pour les champs
public class ProductCommandDTO {
    private Long id; // Identifiant du produit dans la commande
    
    private Double unitPrice; // Prix unitaire du produit
    
    private int quantityInCommand; // Quantité du produit dans la commande

    private CommandDTO command; // Commande à laquelle le produit est associé

    private ProductDTO product; // Produit associé à la commande
}
