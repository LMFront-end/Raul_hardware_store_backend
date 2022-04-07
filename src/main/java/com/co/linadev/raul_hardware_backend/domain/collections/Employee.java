package com.co.linadev.raul_hardware_backend.domain.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value="employees")
public class Employee {

    @Id
    private final String id;
    private final String name;
    private final String email;
    private final Integer age;
    private final String gender;
    private final String phoneNumber;
    private final String identityDocument;

}
