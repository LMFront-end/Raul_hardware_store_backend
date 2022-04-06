package com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.CustomerMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.customer.interfaces.FindCustomerById;
import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.CustomerRepository;
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
