package com.co.linadev.raul_hardware_backend.application.usecases.customer.interfaces;

import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerDTO;
import reactor.core.publisher.Flux;

import java.util.List;

@FunctionalInterface
public interface FillCustomerData {
    Flux<CustomerDTO> fillData(List<CustomerDTO> customerDTOList);
}
