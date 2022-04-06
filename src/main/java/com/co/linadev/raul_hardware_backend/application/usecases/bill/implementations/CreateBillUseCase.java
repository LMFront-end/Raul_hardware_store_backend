package com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations;

import com.co.linadev.raul_hardware_backend.application.mappers.BillMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces.CreateBill;

import com.co.linadev.raul_hardware_backend.domain.dtos.BillDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateBillUseCase implements CreateBill {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public Mono<BillDTO> create(BillDTO billDTO) {
        return billRepository.save(billMapper.mapToCollection().apply(billDTO))
                .map(billMapper.mapToDto());
    }
}
