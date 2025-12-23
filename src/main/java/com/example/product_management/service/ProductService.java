package com.example.product_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_management.dto.ProductRequestDTO;
import com.example.product_management.entity.Product;
import com.example.product_management.repository.ProductRepository;

@Service 
public class ProductService {

    @Autowired //Dependency Injection
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(ProductRequestDTO dto) {
    Product product = new Product();
    product.setName(dto.getName());
    product.setPrice(dto.getPrice());
    
    return productRepository.save(product);
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, ProductRequestDTO dto) {
    return productRepository.findById(id) // check if it exists
        .map(product -> {
            product.setName(dto.getName());
            product.setPrice(dto.getPrice()); 
            return productRepository.save(product); 
        }).orElseThrow(() -> new RuntimeException("Ürün bulunamadı!"));
    }


}