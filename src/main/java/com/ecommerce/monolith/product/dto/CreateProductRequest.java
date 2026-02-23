package com.ecommerce.monolith.product.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class CreateProductRequest {
    @NotBlank(message = "Product name is required") // [cite: 47]
    private String name;

    private String description;

    @NotNull(message = "Price is required") // [cite: 52]
    @Positive(message = "Price must be greater than 0") // [cite: 53]
    private BigDecimal price;

    @PositiveOrZero(message = "Stock cannot be negative") // [cite: 54]
    private Integer stock = 0;
}