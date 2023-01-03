package dev.luanfernandes.domain.service;

import dev.luanfernandes.domain.dto.ProductDTO;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    @Transactional
    void createProduct(ProductDTO productDTO);

    @Transactional
    void updateProduct(Long id, ProductDTO productDTO);

    @Transactional
    void deleteProduct(Long id);
}
