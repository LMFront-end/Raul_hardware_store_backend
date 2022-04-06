package com.co.linadev.raul_hardware_backend.application.mappers;


import com.co.linadev.raul_hardware_backend.domain.collections.Product;
import com.co.linadev.raul_hardware_backend.domain.dtos.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductMapper {

    public Function<Product, ProductDTO> mapToDto(){
        return product -> new ProductDTO(product.getId(),
                                        product.getSupplierId(),
                                        product.getName(),
                                        product.getDescription(),
                                        product.getPrice(),
                                        product.getStock(),
                                        product.getMinAmount());
    }

    public Function<ProductDTO, Product> mapToNewCollection(){
        return productDTO -> new Product(productDTO.getId(),
                                        productDTO.getSupplierId(),
                                        productDTO.getName(),
                                        productDTO.getDescription(),
                                        productDTO.getPrice(),
                                        0,
                                        productDTO.getMinAmount());
    }

}
