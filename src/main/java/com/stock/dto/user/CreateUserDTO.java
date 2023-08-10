package com.stock.dto.user;

import com.stock.dto.pointOfSale.PointOfSaleDTO; // Import de la classe PointOfSaleDTO
import com.stock.model.UserType; // Import de la classe UserType
import lombok.AllArgsConstructor; // Annotation pour générer un constructeur avec tous les champs

import lombok.EqualsAndHashCode; // Annotation pour générer les méthodes equals() et hashCode()
import lombok.Getter; // Annotation pour générer les méthodes getter pour les champs
import lombok.Setter; // Annotation pour générer les méthodes setter pour les champs
import lombok.ToString; // Annotation pour générer la méthode toString()

@AllArgsConstructor // Génère un constructeur avec tous les champs
@EqualsAndHashCode // Génère les méthodes equals() et hashCode() pour la classe
@ToString // Génère la méthode toString() pour la classe
@Getter // Génère les méthodes getter pour les champs
@Setter // Génère les méthodes setter pour les champs
public class CreateUserDTO {

    private String name; // Nom de l'utilisateur à créer
    private String email; // Adresse e-mail de l'utilisateur à créer
    private String password; // Mot de passe de l'utilisateur à créer
    private UserType type; // Type d'utilisateur (enum) de l'utilisateur à créer
    private PointOfSaleDTO pointOfSale; // PointOfSaleDTO associé à l'utilisateur à créer
    
    public CreateUserDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    
}
