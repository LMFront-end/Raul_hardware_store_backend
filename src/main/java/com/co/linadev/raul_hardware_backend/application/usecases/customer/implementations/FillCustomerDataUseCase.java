package com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations;

import com.co.linadev.raul_hardware_backend.application.mappers.CustomerMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.customer.interfaces.FillCustomerData;
import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FillCustomerDataUseCase implements FillCustomerData {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public Flux<CustomerDTO> fillData(List<CustomerDTO> customerDTOList) {
        return customerRepository.saveAll(customerDTOList.stream().map(customerMapper.mapToCollection()).collect(Collectors.toList()))
                .map(customerMapper.mapToDto());
    }
}
