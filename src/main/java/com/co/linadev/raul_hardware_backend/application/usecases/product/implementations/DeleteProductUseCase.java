package com.co.linadev.raul_hardware_backend.application.usecases.product.implementations;

import com.example.raul_hardware_store.application.usecases.product.interfaces.DeleteProduct;
import com.example.raul_hardware_store.domain.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteProductUseCase implements DeleteProduct {

    private final ProductRepository productRepository;


    @Override
    public Mono<Void> delete(String id) {
        return productRepository.deleteById(id);
    }
}
