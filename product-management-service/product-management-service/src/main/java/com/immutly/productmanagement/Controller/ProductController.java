package com.immutly.productmanagement.Controller;

import com.immutly.productmanagement.DTO.ProductDto;
import com.immutly.productmanagement.Exception.InvalidProductException;
import com.immutly.productmanagement.Exception.ProductNotFoundException;
import com.immutly.productmanagement.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts() {

        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<?> getProductById(@PathVariable String product_id) {
        try {
            return ResponseEntity.ok(productService.getProductById(product_id));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {
        try {
            return ResponseEntity.ok(productService.addProduct(productDto));
        } catch (InvalidProductException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{product_id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@PathVariable String product_id, @RequestBody ProductDto productDto) {
        try {
            return ResponseEntity.ok(productService.updateProduct(product_id, productDto));
        } catch (ProductNotFoundException | InvalidProductException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String product_id) {
        try {
            productService.deleteProduct(product_id);
            return ResponseEntity.ok("Product deleted successfully");
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
