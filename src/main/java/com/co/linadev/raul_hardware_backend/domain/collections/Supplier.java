package com.co.linadev.raul_hardware_backend.domain.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value="suppliers")
public class Supplier {

    @Id
    private final String id;
    private final String name;
    private final String email;
    private final String country;
    private final String currency;
    private final String identityDocument;

}
