package com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.BillMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.bill.interfaces.FindBillById;
import com.co.linadev.raul_hardware_backend.domain.dtos.BillDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.BillRepository;
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
