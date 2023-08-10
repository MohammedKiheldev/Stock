package com.stock.dto.productCommand;

import lombok.Getter; // Annotation pour générer les méthodes getter pour les champs
import lombok.Setter; // Annotation pour générer les méthodes setter pour les champs
import com.stock.dto.product.ProductDTO; // Import de la classe ProductDTO

@Getter // Génère les méthodes getter pour les champs
@Setter // Génère les méthodes setter pour les champs
public class UpdateProductCommandDTO {
    private int quantityInCommand; // Nouvelle quantité du produit dans la commande
    
    private ProductDTO product; // Nouvelle version du produit associé à la commande
}
