package com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.CustomerMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.customer.interfaces.CreateCustomer;
import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateCustomerUseCase implements CreateCustomer {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public Mono<CustomerDTO> create(CustomerDTO customerDTO) {
        return customerRepository.save(customerMapper.mapToCollection().apply(customerDTO))
                .map(customerMapper.mapToDto());
    }
}
