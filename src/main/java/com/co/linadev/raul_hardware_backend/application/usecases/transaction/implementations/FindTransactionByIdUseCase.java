package com.co.linadev.raul_hardware_backend.application.usecases.transaction.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.TransactionMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.transaction.interfaces.FindTransactionById;
import com.co.linadev.raul_hardware_backend.domain.dtos.TransactionDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.TransactionRepository;
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
