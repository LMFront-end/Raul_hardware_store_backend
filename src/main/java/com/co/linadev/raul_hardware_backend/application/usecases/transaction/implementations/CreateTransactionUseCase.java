package com.co.linadev.raul_hardware_backend.application.usecases.transaction.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.TransactionMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.transaction.interfaces.CreateTransaction;
import com.co.linadev.raul_hardware_backend.domain.dtos.TransactionDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreateTransactionUseCase implements CreateTransaction {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public Mono<TransactionDTO> create(TransactionDTO transactionDTO) {
        return transactionRepository.save(transactionMapper.mapToNewCollection().apply(transactionDTO))
                .map(transactionMapper.mapToDto());
    }
}
