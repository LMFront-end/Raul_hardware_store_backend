package com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations;


import com.co.linadev.raul_hardware_backend.application.usecases.supplier.interfaces.DeleteSupplier;
import com.co.linadev.raul_hardware_backend.domain.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteSupplierUseCase implements DeleteSupplier {

    private final SupplierRepository supplierRepository;

    @Override
    public Mono<Void> delete(String id) {
        return supplierRepository.deleteById(id);
    }

}
