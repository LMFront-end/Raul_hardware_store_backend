package com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.SupplierMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.supplier.interfaces.FindSupplierById;
import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.SupplierRepository;
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
