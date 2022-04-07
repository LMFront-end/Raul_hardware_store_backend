package com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces;


import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerBillDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindAllBills {
    Flux<CustomerBillDTO> findAll();
}
