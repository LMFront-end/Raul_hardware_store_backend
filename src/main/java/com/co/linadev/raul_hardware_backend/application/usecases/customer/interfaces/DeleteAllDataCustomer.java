package com.co.linadev.raul_hardware_backend.application.usecases.customer.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteAllDataCustomer {
    Mono<Void> deleteAll();
}
