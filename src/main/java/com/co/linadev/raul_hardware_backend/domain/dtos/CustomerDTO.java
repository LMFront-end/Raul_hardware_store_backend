package com.co.linadev.raul_hardware_backend.domain.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String id;
    private String name;
    private String email;
    private Integer age;
    private String gender;
    private String city;
    private String phoneNumber;
    private String identityDocument;
}
