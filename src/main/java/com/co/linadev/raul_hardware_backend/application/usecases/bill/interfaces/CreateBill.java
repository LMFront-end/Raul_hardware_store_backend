package com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces;


import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerBillDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface
CreateBill {
    Mono<CustomerBillDTO> create(CustomerBillDTO billDTO);
}
