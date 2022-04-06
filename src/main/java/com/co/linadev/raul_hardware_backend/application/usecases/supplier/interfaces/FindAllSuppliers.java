package com.co.linadev.raul_hardware_backend.application.usecases.supplier.interfaces;

import com.example.raul_hardware_store.domain.dtos.SupplierDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindAllSuppliers {
    Flux<SupplierDTO> findAll();
}
