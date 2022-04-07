package com.co.linadev.raul_hardware_backend.application.usecases.employee.interfaces;

import com.co.linadev.raul_hardware_backend.domain.dtos.EmployeeDTO;
import reactor.core.publisher.Flux;

import java.util.List;

@FunctionalInterface
public interface FillEmployeeData {
    Flux<EmployeeDTO> fillData(List<EmployeeDTO> employeeDTOList);
}
