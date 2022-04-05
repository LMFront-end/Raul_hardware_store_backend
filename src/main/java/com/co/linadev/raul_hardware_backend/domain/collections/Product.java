package com.co.linadev.raul_hardware_backend.domain.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "inventory")
public class Product {

    @Id
    private final String id;
    private final String supplierId;
    private final String name;
    private final String description;
    private final Double price;
    private final Integer stock;
    private final Integer minAmount;

}
