package com.co.linadev.raul_hardware_backend.application.usecases.transaction.interfaces;


import com.co.linadev.raul_hardware_backend.domain.dtos.TransactionDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateTransaction {
    Mono<TransactionDTO> create(TransactionDTO transactionDTO);
}
