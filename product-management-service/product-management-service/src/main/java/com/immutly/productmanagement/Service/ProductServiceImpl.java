package com.immutly.productmanagement.Service;

import com.immutly.productmanagement.DTO.ProductDto;
import com.immutly.productmanagement.Exception.InvalidProductException;
import com.immutly.productmanagement.Exception.ProductNotFoundException;
import com.immutly.productmanagement.Model.Product;
import com.immutly.productmanagement.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String productId) throws ProductNotFoundException {
        return productRepository.findById(Integer.valueOf(productId))
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
    }

    @Override
    public Product addProduct(ProductDto productDto) throws InvalidProductException {
        Product product = new Product(ProductIDGenerator.getId(),
                productDto.getProduct_Name(),
                productDto.getProduct_Description(),
                productDto.getProduct_Price(),
                productDto.getProduct_Availability());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String productId, ProductDto productDto)
            throws ProductNotFoundException, InvalidProductException {
        Product existingProduct = getProductById(productId);
        existingProduct.setProduct_Name(productDto.getProduct_Name());
        existingProduct.setProduct_Description(productDto.getProduct_Description());
        existingProduct.setProduct_Price(productDto.getProduct_Price());
        existingProduct.setProduct_Availability(productDto.getProduct_Availability());
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(String productId) throws ProductNotFoundException {
        Product product = getProductById(productId);
        productRepository.delete(product);
    }
}
