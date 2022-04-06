package com.co.linadev.raul_hardware_backend.application.usecases.employee.implementations;


import com.co.linadev.raul_hardware_backend.application.mappers.EmployeeMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.employee.interfaces.FindEmployeeById;
import com.co.linadev.raul_hardware_backend.domain.dtos.EmployeeDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.EmployeeRepository;
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
