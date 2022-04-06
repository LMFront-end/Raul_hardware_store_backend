package com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations;

import com.example.raul_hardware_store.application.mappers.CustomerMapper;
import com.example.raul_hardware_store.application.usecases.customer.interfaces.FindCustomerById;
import com.example.raul_hardware_store.domain.dtos.CustomerDTO;
import com.example.raul_hardware_store.domain.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindCustomerByIdUseCase implements FindCustomerById {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Mono<CustomerDTO> findById(String id) {
        return customerRepository.findById(id).map(customerMapper.mapToDto());
    }
}
