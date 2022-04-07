package com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations;

import com.co.linadev.raul_hardware_backend.application.mappers.BillMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces.FindAllsupplierBills;
import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierBillDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllSupplierBillsUseCase implements FindAllsupplierBills {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public Flux<SupplierBillDTO> findAll() {
        return billRepository.findAllBySupplierIdExists(true).map(billMapper.mapToSupplierBillDto());
    }
}
