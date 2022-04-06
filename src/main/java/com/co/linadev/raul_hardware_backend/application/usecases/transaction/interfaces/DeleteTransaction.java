package com.co.linadev.raul_hardware_backend.application.usecases.transaction.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteTransaction {
    Mono<Void> delete(String id);
}
