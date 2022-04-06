package com.co.linadev.raul_hardware_backend.application.usecases.product.implementations;

import com.example.raul_hardware_store.application.mappers.ProductMapper;
import com.example.raul_hardware_store.application.usecases.product.interfaces.FindProductById;
import com.example.raul_hardware_store.domain.dtos.ProductDTO;
import com.example.raul_hardware_store.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindProductByIdUseCase implements FindProductById {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Mono<ProductDTO> findById(String id) {
        return productRepository.findById(id).map(productMapper.mapToDto());
    }
}
