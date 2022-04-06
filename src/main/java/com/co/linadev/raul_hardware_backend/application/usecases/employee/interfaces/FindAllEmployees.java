package com.co.linadev.raul_hardware_backend.application.usecases.employee.interfaces;

import com.co.linadev.raul_hardware_backend.domain.dtos.EmployeeDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindAllEmployees {
    Flux<EmployeeDTO> findAll();
}
