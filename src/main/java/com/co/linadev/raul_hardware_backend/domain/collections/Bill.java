package com.co.linadev.raul_hardware_backend.domain.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(value = "bills")
public class Bill {

    @Id
    private final String id;
    private final String employeeId;
    private final String customerId;
    private final String supplierId;
    private final LocalDateTime date;

}
