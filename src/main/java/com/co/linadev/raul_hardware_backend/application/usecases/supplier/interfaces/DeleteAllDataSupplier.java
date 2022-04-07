package com.co.linadev.raul_hardware_backend.application.usecases.supplier.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteAllDataSupplier {
    Mono<Void>deleteAll();
}
