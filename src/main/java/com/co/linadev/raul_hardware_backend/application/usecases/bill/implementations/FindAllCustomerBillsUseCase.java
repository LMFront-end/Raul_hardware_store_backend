package com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations;

import com.co.linadev.raul_hardware_backend.application.mappers.BillMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces.FindAllCustomerBills;
import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerBillDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllCustomerBillsUseCase implements FindAllCustomerBills {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public Flux<CustomerBillDTO> findAll() {
        return billRepository.findAllByCustomerIdExists(true).map(billMapper.mapToCustomerBillDto());
    }
}
