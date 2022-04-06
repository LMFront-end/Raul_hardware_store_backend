package com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations;


import com.co.linadev.raul_hardware_backend.application.usecases.customer.interfaces.DeleteCustomer;
import com.co.linadev.raul_hardware_backend.domain.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteCustomerUseCase implements DeleteCustomer {

    private final CustomerRepository customerRepository;

    @Override
    public Mono<Void> delete(String id) {
        return customerRepository.deleteById(id);
    }
}
