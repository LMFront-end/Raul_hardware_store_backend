package com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.BillMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces.FindAllBills;
import com.co.linadev.raul_hardware_backend.domain.dtos.BillDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
@RequiredArgsConstructor
public class FindAllBillsUseCase implements FindAllBills {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public Flux<BillDTO> findAll() {
        return billRepository.findAll().map(billMapper.mapToDto());
    }
}
