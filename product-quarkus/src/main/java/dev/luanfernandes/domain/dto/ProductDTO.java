package dev.luanfernandes.domain.dto;

import dev.luanfernandes.domain.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private String category;
    private String model;
    private BigDecimal price;
    public ProductDTO(ProductEntity productEntity) {
        this.id = productEntity.getId();
        this.name = productEntity.getName();
        this.description = productEntity.getDescription();
        this.category = productEntity.getCategory();
        this.model = productEntity.getModel();
        this.price = productEntity.getPrice();
    }

    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .name(name)
                .description(description)
                .category(category)
                .model(model)
                .price(price)
                .build();
    }
}