package com.co.linadev.raul_hardware_backend.application.usecases.customer.interfaces;


import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindCustomerById {
    Mono<CustomerDTO> findById(String id);
}
