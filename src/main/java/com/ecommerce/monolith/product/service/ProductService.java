package com.ecommerce.monolith.product.service;

import com.ecommerce.monolith.product.dto.CreateProductRequest;
import com.ecommerce.monolith.product.dto.ProductDTO;
import java.util.List;


public interface ProductService {
    List<ProductDTO> getAllProducts(); // [cite: 68]
    ProductDTO getProductById(Long id); // [cite: 69]
    ProductDTO createProduct(CreateProductRequest request); // [cite: 71]
    ProductDTO updateProduct(Long id, CreateProductRequest request); // [cite: 73]
    void deleteProduct(Long id); // [cite: 75]
}