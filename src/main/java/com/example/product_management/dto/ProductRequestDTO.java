package com.example.product_management.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequestDTO {
    @NotBlank(message = "Ürün adı boş olamaz")
    private String name;

    @NotNull(message = "Fiyat alanı zorunludur")
    @Min(value = 0, message = "Fiyat 0'dan küçük olamaz")
    private Double price;

    public ProductRequestDTO() {}
    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}