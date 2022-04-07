package com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations;

import com.co.linadev.raul_hardware_backend.application.mappers.BillMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces.CreateCustomerBill;

import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerBillDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateCustomerBillUseCase implements CreateCustomerBill {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public Mono<CustomerBillDTO> create(CustomerBillDTO billDTO) {
        return billRepository.save(billMapper.mapToCollectionFromCustomerBill().apply(billDTO))
                .map(billMapper.mapToCustomerBillDto());
    }
}
