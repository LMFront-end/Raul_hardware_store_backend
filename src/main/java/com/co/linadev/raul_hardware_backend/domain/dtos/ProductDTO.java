package com.co.linadev.raul_hardware_backend.domain.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String id;
    private String supplierId;
    private String name;
    private String description;
    private Double price;
    private Integer stock;
    private Integer minAmount;

}
