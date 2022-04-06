package com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteBill {
    Mono<Void> delete(String id);
}
