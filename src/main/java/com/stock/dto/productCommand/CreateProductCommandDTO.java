package com.stock.dto.productCommand;

import lombok.Getter; // Annotation pour générer les méthodes getter pour les champs
import lombok.Setter; // Annotation pour générer les méthodes setter pour les champs
import com.stock.dto.product.ProductDTO; // Import de la classe ProductDTO

@Getter // Génère les méthodes getter pour les champs
@Setter // Génère les méthodes setter pour les champs
public class CreateProductCommandDTO {
    private int quantityInCommand; // Quantité du produit dans la commande
    
    private ProductDTO product; // Produit associé à la commande
}
