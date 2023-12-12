package com.immutly.productmanagement.Service;

import java.util.List;

import com.immutly.productmanagement.DTO.ProductDto;
import com.immutly.productmanagement.Exception.InvalidProductException;
import com.immutly.productmanagement.Exception.ProductNotFoundException;
import com.immutly.productmanagement.Model.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String productId) throws ProductNotFoundException;
    Product addProduct(ProductDto productDto) throws InvalidProductException;
    Product updateProduct(String productId, ProductDto productDto)
            throws ProductNotFoundException, InvalidProductException;
    void deleteProduct(String productId) throws ProductNotFoundException;
}
