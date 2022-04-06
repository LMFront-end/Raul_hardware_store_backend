package com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations;

import com.example.raul_hardware_store.application.usecases.bill.interfaces.DeleteBill;
import com.example.raul_hardware_store.domain.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteBillUseCase implements DeleteBill {

    private final BillRepository billRepository;

    @Override
    public Mono<Void> delete(String id) {
        return billRepository.deleteById(id);
    }
}
