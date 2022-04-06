package com.co.linadev.raul_hardware_backend.application.usecases.transaction.implementations;

import com.example.raul_hardware_store.application.mappers.TransactionMapper;
import com.example.raul_hardware_store.application.usecases.transaction.interfaces.FindAllTransactions;
import com.example.raul_hardware_store.domain.dtos.TransactionDTO;
import com.example.raul_hardware_store.domain.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllTransactionsUseCase implements FindAllTransactions {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Override
    public Flux<TransactionDTO> findAll() {
        return transactionRepository.findAll().map(transactionMapper.mapToDto());
    }
}
