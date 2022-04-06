package com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations;

import com.example.raul_hardware_store.application.mappers.SupplierMapper;
import com.example.raul_hardware_store.application.usecases.supplier.interfaces.FindAllSuppliers;
import com.example.raul_hardware_store.domain.dtos.SupplierDTO;
import com.example.raul_hardware_store.domain.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllSuppliersUseCase implements FindAllSuppliers {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public Flux<SupplierDTO> findAll() {
        return supplierRepository.findAll().map(supplierMapper.mapToDto());
    }
}
