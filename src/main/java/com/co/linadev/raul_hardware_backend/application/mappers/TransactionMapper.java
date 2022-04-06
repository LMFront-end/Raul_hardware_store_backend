package com.co.linadev.raul_hardware_backend.application.mappers;


import com.co.linadev.raul_hardware_backend.domain.collections.Transaction;
import com.co.linadev.raul_hardware_backend.domain.dtos.TransactionDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TransactionMapper {

    public Function<Transaction, TransactionDTO> mapToDto(){
        return transaction -> new TransactionDTO(transaction.getId(),
                transaction.getProductId(),
                transaction.getBillId(),
                transaction.getAmount()
        );
    }

    public Function<TransactionDTO, Transaction> mapToNewCollection(){
        return transactionDTO -> new Transaction(transactionDTO.getId(),
                transactionDTO.getProductId(),
                transactionDTO.getBillId(),
                transactionDTO.getAmount()
        );
    }

    public Function<TransactionDTO, Transaction> mapToCollection(){
        return transactionDTO -> new Transaction(transactionDTO.getId(),
                transactionDTO.getProductId(),
                transactionDTO.getBillId(),
                transactionDTO.getAmount()
        );
    }

}
