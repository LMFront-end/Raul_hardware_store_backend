package com.co.linadev.raul_hardware_backend.application.usecases.employee.implementations;

import com.example.raul_hardware_store.application.mappers.EmployeeMapper;
import com.example.raul_hardware_store.application.usecases.employee.interfaces.FindEmployeeById;
import com.example.raul_hardware_store.domain.dtos.EmployeeDTO;
import com.example.raul_hardware_store.domain.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FindEmployeeByIdUseCase implements FindEmployeeById {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public Mono<EmployeeDTO> findById(String id) {
        return employeeRepository.findById(id).map(employeeMapper.mapToDto());
    }
}
