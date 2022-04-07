package com.co.linadev.raul_hardware_backend.application.usecases.employee.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteAllDataEmployee {
    Mono<Void> deleteAll();
}
