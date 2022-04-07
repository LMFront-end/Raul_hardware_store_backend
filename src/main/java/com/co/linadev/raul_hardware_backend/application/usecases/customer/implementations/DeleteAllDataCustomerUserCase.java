package com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations;

import com.co.linadev.raul_hardware_backend.application.usecases.customer.interfaces.DeleteAllDataCustomer;
import com.co.linadev.raul_hardware_backend.domain.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteAllDataCustomerUserCase implements DeleteAllDataCustomer {

    private final CustomerRepository customerRepository;


    @Override
    public Mono<Void> deleteAll() {
        return customerRepository.deleteAll();
    }
}
