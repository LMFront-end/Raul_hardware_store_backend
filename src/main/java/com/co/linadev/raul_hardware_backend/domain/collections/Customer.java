package com.co.linadev.raul_hardware_backend.domain.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "customers")
public class Customer {

    @Id
    private final String id;
    private final String name;
    private final String phoneNumber;
    private final String identityDocument;

}
