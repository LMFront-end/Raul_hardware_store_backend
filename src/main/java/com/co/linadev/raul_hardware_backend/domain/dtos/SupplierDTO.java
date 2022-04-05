package com.co.linadev.raul_hardware_backend.domain.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

    private String id;
    private String name;
    private String identityDocument;

}
