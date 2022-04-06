package com.co.linadev.raul_hardware_backend.application.usecases.product.implementations;

import com.example.raul_hardware_store.application.mappers.ProductMapper;
import com.example.raul_hardware_store.application.usecases.product.interfaces.FindAllProducts;
import com.example.raul_hardware_store.domain.dtos.ProductDTO;
import com.example.raul_hardware_store.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllProductsUseCase implements FindAllProducts {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Flux<ProductDTO> findAll() {
        return productRepository.findAll().map(productMapper.mapToDto());
    }
}
