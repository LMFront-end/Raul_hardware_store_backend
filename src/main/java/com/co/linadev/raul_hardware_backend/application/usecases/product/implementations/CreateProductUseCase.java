package com.co.linadev.raul_hardware_backend.application.usecases.product.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.ProductMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.product.interfaces.CreateProduct;
import com.co.linadev.raul_hardware_backend.domain.dtos.ProductDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateProductUseCase implements CreateProduct {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public Mono<ProductDTO> create(ProductDTO productDTO) {
        return productRepository.save(productMapper.mapToNewCollection().apply(productDTO))
                .map(productMapper.mapToDto());
    }
}
