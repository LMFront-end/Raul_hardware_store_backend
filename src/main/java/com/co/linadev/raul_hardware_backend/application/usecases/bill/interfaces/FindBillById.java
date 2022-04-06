package com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces;

import com.co.linadev.raul_hardware_backend.domain.dtos.BillDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindBillById {
    Mono<BillDTO> findById(String id);
}
