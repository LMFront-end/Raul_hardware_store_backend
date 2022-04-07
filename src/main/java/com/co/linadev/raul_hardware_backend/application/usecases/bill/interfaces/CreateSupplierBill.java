package com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces;

import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierBillDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateSupplierBill {
    Mono<SupplierBillDTO> create(SupplierBillDTO supplierBillDTO);
}
