package com.co.linadev.raul_hardware_backend.application.usecases.employee.implementations;

import com.co.linadev.raul_hardware_backend.application.mappers.EmployeeMapper;
import com.co.linadev.raul_hardware_backend.application.usecases.employee.interfaces.FillEmployeeData;
import com.co.linadev.raul_hardware_backend.domain.dtos.EmployeeDTO;
import com.co.linadev.raul_hardware_backend.domain.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FillEmployeeDataUseCase implements FillEmployeeData {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    @Override
    public Flux<EmployeeDTO> fillData(List<EmployeeDTO> employeeDTOList) {
        return employeeRepository.saveAll(employeeDTOList.stream().map(employeeMapper.mapToCollection()).collect(Collectors.toList()))
                .map(employeeMapper.mapToDto());
    }
}
