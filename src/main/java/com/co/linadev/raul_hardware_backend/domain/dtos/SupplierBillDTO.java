package com.co.linadev.raul_hardware_backend.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierBillDTO {

    private String id;
    private String supplierId;
    private LocalDateTime dateTime;
}
