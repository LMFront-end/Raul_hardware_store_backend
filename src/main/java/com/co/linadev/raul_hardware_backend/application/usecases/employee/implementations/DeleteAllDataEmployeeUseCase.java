package com.co.linadev.raul_hardware_backend.application.usecases.employee.implementations;

import com.co.linadev.raul_hardware_backend.application.usecases.employee.interfaces.DeleteAllDataEmployee;
import com.co.linadev.raul_hardware_backend.domain.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DeleteAllDataEmployeeUseCase implements DeleteAllDataEmployee {

    private final EmployeeRepository employeeRepository;


    @Override
    public Mono<Void> deleteAll() {
        return employeeRepository.deleteAll();
    }
}
