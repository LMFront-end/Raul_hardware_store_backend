package com.co.linadev.raul_hardware_backend.application.mappers;

import com.co.linadev.raul_hardware_backend.domain.collections.Employee;
import com.co.linadev.raul_hardware_backend.domain.dtos.EmployeeDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EmployeeMapper {

    public Function<Employee, EmployeeDTO> mapToDto(){
        return employee -> new EmployeeDTO(employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getAge(),
                employee.getGender(),
                employee.getPhoneNumber(),
                employee.getIdentityDocument()
        );
    }

    public Function<EmployeeDTO, Employee> mapToCollection(){
        return employeeDTO -> new Employee(employeeDTO.getId(),
                employeeDTO.getName(),
                employeeDTO.getEmail(),
                employeeDTO.getAge(),
                employeeDTO.getGender(),
                employeeDTO.getPhoneNumber(),
                employeeDTO.getIdentityDocument()
        );
    }

}
