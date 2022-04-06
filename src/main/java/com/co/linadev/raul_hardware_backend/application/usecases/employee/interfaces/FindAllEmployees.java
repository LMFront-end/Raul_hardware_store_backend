package com.co.linadev.raul_hardware_backend.application.usecases.employee.interfaces;

import com.example.raul_hardware_store.domain.dtos.EmployeeDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface FindAllEmployees {
    Flux<EmployeeDTO> findAll();
}
