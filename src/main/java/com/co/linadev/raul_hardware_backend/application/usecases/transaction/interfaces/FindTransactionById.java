package com.co.linadev.raul_hardware_backend.application.usecases.transaction.interfaces;


import com.co.linadev.raul_hardware_backend.domain.dtos.TransactionDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindTransactionById {
    Mono<TransactionDTO> findById(String id);
}
