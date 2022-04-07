package com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations;

import com.co.linadev.raul_hardware_backend.application.usecases.supplier.interfaces.DeleteAllDataSupplier;
import com.co.linadev.raul_hardware_backend.domain.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteAllDataSupplierUseCase implements DeleteAllDataSupplier {

    private final SupplierRepository supplierRepository;

    @Override
    public Mono<Void> deleteAll() {
        return supplierRepository.deleteAll();
    }
}
