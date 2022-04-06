package com.co.linadev.raul_hardware_backend.application.usecases.transaction.implementations;


import com.co.linadev.raul_hardware_backend.application.usecases.transaction.interfaces.DeleteTransaction;
import com.co.linadev.raul_hardware_backend.domain.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteTransactionUseCase implements DeleteTransaction {

    private final TransactionRepository transactionRepository;

    @Override
    public Mono<Void> delete(String id) {
        return transactionRepository.deleteById(id);
    }

}
