package com.co.linadev.raul_hardware_backend.application.usecases.employee.implementations;

import com.example.raul_hardware_store.application.mappers.EmployeeMapper;
import com.example.raul_hardware_store.application.usecases.employee.interfaces.FindAllEmployees;
import com.example.raul_hardware_store.domain.dtos.EmployeeDTO;
import com.example.raul_hardware_store.domain.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FindAllEmployeesUseCase implements FindAllEmployees {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public Flux<EmployeeDTO> findAll() {
        return employeeRepository.findAll().map(employeeMapper.mapToDto());
    }
}
