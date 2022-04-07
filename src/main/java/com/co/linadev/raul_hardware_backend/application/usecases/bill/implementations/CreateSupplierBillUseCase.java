package com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations;

import com.co.linadev.raul_hardware_backend.application.mappers.BillMapper;
import com.co.linadev.raul_hardware_backend.application.mappers.SupplierMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces.CreateSupplierBill;
import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierBillDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.BillRepository;
import com.co.linadev.raul_hardware_backend.domain.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateSupplierBillUseCase implements CreateSupplierBill {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public Mono<SupplierBillDTO> create(SupplierBillDTO supplierBillDTO) {
        return billRepository.save(billMapper.mapToCollectionFromSupplierBill().apply(supplierBillDTO))
                .map(billMapper.mapToSupplierBillDto());
    }
}
