package dev.luanfernandes.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String model;
    private BigDecimal price;
}