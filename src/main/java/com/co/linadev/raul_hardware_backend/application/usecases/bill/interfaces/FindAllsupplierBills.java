package com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces;

import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierBillDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindAllsupplierBills {
    Flux<SupplierBillDTO> findAll();
}
