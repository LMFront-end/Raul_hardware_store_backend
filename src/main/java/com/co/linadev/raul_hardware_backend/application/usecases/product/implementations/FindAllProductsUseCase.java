package com.co.linadev.raul_hardware_backend.application.usecases.product.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.ProductMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.product.interfaces.FindAllProducts;
import com.co.linadev.raul_hardware_backend.domain.dtos.ProductDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.ProductRepository;
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
