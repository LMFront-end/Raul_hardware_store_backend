package com.co.linadev.raul_hardware_backend.application.usecases.employee.interfaces;


import com.co.linadev.raul_hardware_backend.domain.dtos.EmployeeDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface FindEmployeeById {
    Mono<EmployeeDTO> findById(String id);
}
