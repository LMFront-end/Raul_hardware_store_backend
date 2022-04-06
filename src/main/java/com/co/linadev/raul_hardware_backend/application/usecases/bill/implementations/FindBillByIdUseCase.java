package com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations;

import com.example.raul_hardware_store.application.mappers.BillMapper;
import com.example.raul_hardware_store.application.usecases.bill.interfaces.FindBillById;
import com.example.raul_hardware_store.domain.dtos.BillDTO;
import com.example.raul_hardware_store.domain.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindBillByIdUseCase implements FindBillById {

    private final BillRepository billRepository;
    private final BillMapper billMapper;

    @Override
    public Mono<BillDTO> findById(String id) {
        return billRepository.findById(id).map(billMapper.mapToDto());
    }
}
