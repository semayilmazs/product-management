package com.example.product_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_management.dto.ProductRequestDTO;
import com.example.product_management.entity.Product;
import com.example.product_management.service.ProductService;

import jakarta.validation.Valid;


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
    public Product create(@Valid @RequestBody ProductRequestDTO dto) {
    return productService.saveProduct(dto);
    }
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO dto) {
        return productService.updateProduct(id, dto);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Başarıyla silindi";
    }
}