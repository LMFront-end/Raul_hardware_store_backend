package com.co.linadev.raul_hardware_backend.application.usecases.product.interfaces;


import com.co.linadev.raul_hardware_backend.domain.dtos.ProductDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindAllProducts {
    Flux<ProductDTO> findAll();
}
