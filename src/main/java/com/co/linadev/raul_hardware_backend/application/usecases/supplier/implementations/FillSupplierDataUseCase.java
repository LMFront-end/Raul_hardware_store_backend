package com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations;

import com.co.linadev.raul_hardware_backend.application.mappers.SupplierMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.supplier.interfaces.FillSupplierData;
import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FillSupplierDataUseCase implements FillSupplierData {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;


    @Override
    public Flux<SupplierDTO> fillData(List<SupplierDTO> supplierDTOLists) {
        return supplierRepository.saveAll(supplierDTOLists.stream().map(supplierMapper.mapToCollection()).collect(Collectors.toList()))
                .map(supplierMapper.mapToDto());
    }
}
