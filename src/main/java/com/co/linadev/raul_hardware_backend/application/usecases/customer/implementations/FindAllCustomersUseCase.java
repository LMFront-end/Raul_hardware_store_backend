package com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations;

import com.example.raul_hardware_store.application.mappers.CustomerMapper;
import com.example.raul_hardware_store.application.usecases.customer.interfaces.FindAllCustomers;
import com.example.raul_hardware_store.domain.dtos.CustomerDTO;
import com.example.raul_hardware_store.domain.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllCustomersUseCase implements FindAllCustomers {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public Flux<CustomerDTO> findAll() {
        return customerRepository.findAll().map(customerMapper.mapToDto());
    }
}
