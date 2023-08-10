package com.stock.util.product;

import java.util.List;

import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.product.CreateProductDTO;
import com.stock.dto.product.ProductDTO;
import com.stock.model.PointOfSale;
import com.stock.model.Product;

// This interface defines methods for converting between DTOs and entities related to products
public interface ProductUtil {

    // Convert a list of Product entities to a list of ProductDTOs
    List<ProductDTO> convertToDTOs(List<Product> products);

    // Convert a Product entity to a ProductDTO
    ProductDTO convertToDTO(Product product);

    // Convert a CreateProductDTO to a Product entity
    Product convertToEntity(CreateProductDTO createProductDTO);

    // Convert a PointOfSale entity to a PointOfSaleDTO
    PointOfSaleDTO convertToDTO(PointOfSale pointOfSale);

    // Convert a PointOfSaleDTO to a PointOfSale entity
    PointOfSale convertToEntity(PointOfSaleDTO pointOfSaleDTO);
    
    // Generates a random 6-digit code for a product
    Long genererCodeProduit();
}
