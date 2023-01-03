package dev.luanfernandes.infrastructure.implementation;


import dev.luanfernandes.domain.dto.ProductDTO;
import dev.luanfernandes.domain.service.ProductService;
import dev.luanfernandes.infrastructure.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class ProductServiceImpl implements ProductService {
    @Inject
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductDTO::new).toList();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return new ProductDTO(productRepository.findById(id));
    }

    @Override
    @Transactional
    public void createProduct(ProductDTO productDTO){
        productRepository.persist(productDTO.toEntity());
    }

    @Override
    @Transactional
    public void updateProduct(Long id, ProductDTO productDTO){
        var obj = productRepository.findById(id);
        obj.setName(productDTO.getName());
        obj.setDescription(productDTO.getDescription());
        obj.setCategory(productDTO.getCategory());
        obj.setModel(productDTO.getModel());
        obj.setPrice(productDTO.getPrice());
        productRepository.persist(obj);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
