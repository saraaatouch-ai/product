package com.ecommerce.monolith.product.service;

import com.ecommerce.monolith.product.dto.CreateProductRequest;
import com.ecommerce.monolith.product.dto.ProductDTO;
import com.ecommerce.monolith.product.mapper.ProductMapper;
import com.ecommerce.monolith.product.model.Product;
import com.ecommerce.monolith.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // [cite: 77]
@RequiredArgsConstructor // [cite: 78]
public class ProductServiceImpl implements ProductService { // [cite: 79]

    private final ProductRepository repository; // [cite: 80]
    private final ProductMapper mapper; // [cite: 81]

    @Override
    public List<ProductDTO> getAllProducts() {
        return mapper.toDTOList(repository.findAll()); // [cite: 83, 84]
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id)); // [cite: 86, 87, 88]
        return mapper.toDTO(product); // [cite: 89]
    }

    @Override
    public ProductDTO createProduct(CreateProductRequest request) {
        Product product = mapper.toEntity(request); // [cite: 92, 94]
        Product saved = repository.save(product); // [cite: 95, 96]
        return mapper.toDTO(saved); // [cite: 97]
    }

    @Override
    public ProductDTO updateProduct(Long id, CreateProductRequest request) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id)); // [cite: 99, 100, 104]
        mapper.updateEntity(request, product); // [cite: 105]
        Product updated = repository.save(product); // [cite: 105]
        return mapper.toDTO(updated); // [cite: 106]
    }

    @Override
    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) { // [cite: 108, 110]
            throw new RuntimeException("Product not found with id: " + id); // [cite: 111, 112]
        }
        repository.deleteById(id); // [cite: 113]
    }
}