package com.co.linadev.raul_hardware_backend.application.usecases.transaction.implementations;

import com.example.raul_hardware_store.application.mappers.TransactionMapper;
import com.example.raul_hardware_store.application.usecases.transaction.interfaces.FindTransactionById;
import com.example.raul_hardware_store.domain.dtos.TransactionDTO;
import com.example.raul_hardware_store.domain.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindTransactionByIdUseCase implements FindTransactionById {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public Mono<TransactionDTO> findById(String id) {
        return transactionRepository.findById(id).map(transactionMapper.mapToDto());
    }
}
