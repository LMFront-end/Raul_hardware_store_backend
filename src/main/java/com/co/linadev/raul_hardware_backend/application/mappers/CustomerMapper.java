package com.co.linadev.raul_hardware_backend.application.mappers;


import com.co.linadev.raul_hardware_backend.domain.collections.Customer;
import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CustomerMapper {

    public Function<Customer, CustomerDTO> mapToDto(){
        return customer -> new CustomerDTO(customer.getId(),
                customer.getName(),
                customer.getPhoneNumber(),
                customer.getIdentityDocument()
        );
    }

    public Function<CustomerDTO, Customer> mapToCollection(){
        return customerDTO -> new Customer(customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getPhoneNumber(),
                customerDTO.getIdentityDocument()
        );
    }

}
