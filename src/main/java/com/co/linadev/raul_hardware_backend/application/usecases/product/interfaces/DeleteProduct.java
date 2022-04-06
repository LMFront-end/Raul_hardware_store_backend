package com.co.linadev.raul_hardware_backend.application.usecases.product.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteProduct {
    Mono<Void> delete(String id);
}
