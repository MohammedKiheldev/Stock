package com.stock.service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.dao.pointOfSale.PointOfSaleDao;
import com.stock.dao.product.ProductDao;
import com.stock.dto.pointOfSale.CreatePointOfSaleDTO;
import com.stock.dto.pointOfSale.PointOfSaleDTO;
import com.stock.dto.product.CreateProductDTO;
import com.stock.dto.product.ProductDTO;
import com.stock.dto.product.UpdateProductDTO;
import com.stock.model.Product;
import com.stock.util.product.ProductUtil;
import com.stock.model.PointOfSale;
@Service
public class ProductService{

    @Autowired
    private ProductDao productDao;

    @Autowired
    private PointOfSaleDao pointOfSaleDao;
    
    @Autowired
    private ProductUtil productUtil;

    @Autowired
    private PointOfSaleService pointOfSaleService;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productDao.getAllProducts();
        return productUtil.convertToDTOs(products);
    }

    public ProductDTO getProductById(Long id) {
        Product product = productDao.getProductById(id);
        if (product != null) {
            return productUtil.convertToDTO(product);
        } else {
            return null;
        }
    }

    @Transactional
    public ProductDTO createProduct(CreateProductDTO createProductDTO) {
        Product product = productUtil.convertToEntity(createProductDTO);
        product.setCode(productUtil.genererCodeProduit());
        Long pointOfSaleId = product.getPointOfSale().getId();
        PointOfSale pointOfSale = pointOfSaleDao.getPointOfSaleById(pointOfSaleId);
        if (pointOfSale != null) {
            product.setPointOfSale(pointOfSale);
        }
        int quantity = product.getQuantityInStock();
        pointOfSale.setQuantity(quantity + pointOfSale.getQuantity());
        pointOfSaleDao.updatePointOfSale(pointOfSale);
        Product newProduct = productDao.addProduct(product);
        return productUtil.convertToDTO(newProduct);
    }

    @Transactional
    public ProductDTO updateProduct(Long id, UpdateProductDTO updateProductDTO) {
        Product existingProduct = productDao.getProductById(id);
        Long pointOfSaleId = existingProduct.getPointOfSale().getId();
        PointOfSale pointOfSale = pointOfSaleDao.getPointOfSaleById(pointOfSaleId);
        
        int oldQuantity = existingProduct.getQuantityInStock();
        
        if (existingProduct != null) {
            existingProduct.setName(updateProductDTO.getName());
            existingProduct.setDescription(updateProductDTO.getDescription());
            existingProduct.setQuantityInStock(updateProductDTO.getQuantityInStock());
            existingProduct.setPrice(updateProductDTO.getPrice());
            existingProduct.setMinimumPrice(updateProductDTO.getMinimumPrice());
            
            
            int newQuantity = updateProductDTO.getQuantityInStock();
            
            int quantityDifference = newQuantity - oldQuantity;
            pointOfSale.setQuantity(pointOfSale.getQuantity() + quantityDifference);
            
            pointOfSaleDao.updatePointOfSale(pointOfSale);
            Product updatedProduct = productDao.updateProduct(existingProduct);
            return productUtil.convertToDTO(updatedProduct);
        } else {
            return null;
        }
    }

    public boolean deleteProduct(Long id) {
        Product product = productDao.getProductById(id);
        
        if (product != null) {
            productDao.deleteProduct(id);
            
            Long pointOfSaleId = product.getPointOfSale().getId();
            PointOfSale pointOfSale = pointOfSaleDao.getPointOfSaleById(pointOfSaleId);
            int Quantity = product.getQuantityInStock();
            pointOfSale.setQuantity(pointOfSale.getQuantity() - Quantity);
            pointOfSaleDao.updatePointOfSale(pointOfSale);
            return true;
        } else {
            return false;
        }
    }

}
