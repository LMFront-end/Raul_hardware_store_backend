package com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.SupplierMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.supplier.interfaces.CreateSupplier;
import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateSupplierUseCase implements CreateSupplier {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public Mono<SupplierDTO> create(SupplierDTO supplierDTO) {
        return supplierRepository.save(supplierMapper.mapToCollection().apply(supplierDTO))
                .map(supplierMapper.mapToDto());
    }
}
