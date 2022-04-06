package com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces;

import com.example.raul_hardware_store.domain.dtos.BillDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindAllBills {
    Flux<BillDTO> findAll();
}
