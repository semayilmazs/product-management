package com.example.product_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_management.entity.Product;
import com.example.product_management.service.ProductService;

@RestController // tells us this is an api  
@RequestMapping("/api/products") // defines the address
public class ProductController {

    private final ProductService productService;

    // Constructor Injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping 
    public List<Product> getAll() {
        return productService.getAllProducts();
    }
    @PostMapping 
    public Product create(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}