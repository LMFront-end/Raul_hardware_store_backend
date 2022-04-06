package com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations;

import com.example.raul_hardware_store.application.mappers.SupplierMapper;
import com.example.raul_hardware_store.application.usecases.supplier.interfaces.FindSupplierById;
import com.example.raul_hardware_store.domain.dtos.SupplierDTO;
import com.example.raul_hardware_store.domain.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindSupplierByIdUseCase implements FindSupplierById {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public Mono<SupplierDTO> findById(String id) {
        return supplierRepository.findById(id).map(supplierMapper.mapToDto());
    }
}
