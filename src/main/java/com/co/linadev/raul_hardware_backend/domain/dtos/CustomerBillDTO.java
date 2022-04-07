package com.co.linadev.raul_hardware_backend.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBillDTO {

    private String id;
    private String employeeId;
    private String customerId;
    private LocalDateTime dateTime;

}
