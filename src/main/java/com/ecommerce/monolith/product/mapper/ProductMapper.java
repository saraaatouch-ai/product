package com.ecommerce.monolith.product.mapper;


import com.ecommerce.monolith.product.dto.ProductDTO;
import com.ecommerce.monolith.product.dto.CreateProductRequest;
import com.ecommerce.monolith.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import java.util.List;

@Mapper(componentModel = "spring") // [cite: 56]
public interface ProductMapper {

    // Convertit une entité Product en DTO [cite: 57, 58]
    ProductDTO toDTO(Product product);

    // Convertit une liste d'entités Product en liste de DTO [cite: 59, 60]
    List<ProductDTO> toDTOList(List<Product> products);

    // Convertit une requête CreateProductRequest en entité Product [cite: 61]
    Product toEntity(CreateProductRequest request);

    // Met à jour une entité Product existante à partir d'une requête [cite: 62]
    @Mapping(target = "id", ignore = true) // [cite: 62]
    void updateEntity(CreateProductRequest request, @MappingTarget Product product); // [cite: 63]
}