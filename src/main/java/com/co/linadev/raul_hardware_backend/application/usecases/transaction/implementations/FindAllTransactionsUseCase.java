package com.co.linadev.raul_hardware_backend.application.usecases.transaction.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.TransactionMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.transaction.interfaces.FindAllTransactions;
import com.co.linadev.raul_hardware_backend.domain.dtos.TransactionDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.TransactionRepository;
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
