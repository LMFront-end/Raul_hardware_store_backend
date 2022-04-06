package com.co.linadev.raul_hardware_backend.application.usecases.customer.interfaces;

import com.example.raul_hardware_store.domain.dtos.CustomerDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindCustomerById {
    Mono<CustomerDTO> findById(String id);
}
