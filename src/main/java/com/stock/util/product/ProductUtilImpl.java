package com.stock.util.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.product.CreateProductDTO;
import com.stock.dto.product.ProductDTO;
import com.stock.model.PointOfSale;
import com.stock.model.Product;

// Implementation of ProductUtil interface
@Service
public class ProductUtilImpl implements ProductUtil {

    @Override
    public List<ProductDTO> convertToDTOs(List<Product> products) {
        List<ProductDTO> dtos = new ArrayList<>();
        for (Product product : products) {
            dtos.add(convertToDTO(product));
        }
        return dtos;
    }

    @Override
    public ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setQuantityInStock(product.getQuantityInStock());
        dto.setPrice(product.getPrice());
        dto.setMinimumPrice(product.getMinimumPrice());
        return dto;
    }

    @Override
    public Product convertToEntity(CreateProductDTO createProductDTO) {
        Product product = new Product();
        product.setName(createProductDTO.getName());
        product.setDescription(createProductDTO.getDescription());
        product.setQuantityInStock(createProductDTO.getQuantityInStock());
        product.setPrice(createProductDTO.getPrice());
        product.setMinimumPrice(createProductDTO.getMinimumPrice());

        // Convert PointOfSaleDTO to PointOfSale entity
        PointOfSale pointOfSale = convertToEntity(createProductDTO.getPointOfSale()); // Replace with the actual instance of the method
        product.setPointOfSale(pointOfSale);

        return product;
    }


    @Override
    public PointOfSaleDTO convertToDTO(PointOfSale pointOfSale) {
        if (pointOfSale == null) {
            return null;
        }

        PointOfSaleDTO dto = new PointOfSaleDTO();
        dto.setId(pointOfSale.getId());
        dto.setName(pointOfSale.getName());
        dto.setAddress(pointOfSale.getAddress());
        dto.setQuantity(pointOfSale.getQuantity());
        return dto;
    }

    @Override
    public PointOfSale convertToEntity(PointOfSaleDTO pointOfSaleDTO) {
        PointOfSale pointOfSale = new PointOfSale();
        pointOfSale.setId(pointOfSaleDTO.getId());
        return pointOfSale;
    }
    
    @Override
    public Long genererCodeProduit() {
        // Generate a random number between 100000 (inclusive) and 999999 (inclusive)
        long code = (long) (Math.random() * 900000) + 100000;

        // Return the generated code
        return code;
    }
}
