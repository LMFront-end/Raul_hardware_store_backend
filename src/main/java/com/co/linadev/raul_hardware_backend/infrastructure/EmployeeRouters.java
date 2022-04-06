package com.co.linadev.raul_hardware_backend.infrastructure;


import com.co.linadev.raul_hardware_backend.application.usecases.employee.implementations.CreateEmployeeUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.employee.implementations.DeleteEmployeeUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.employee.implementations.FindAllEmployeesUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.employee.implementations.FindEmployeeByIdUseCase;
import com.co.linadev.raul_hardware_backend.domain.dtos.EmployeeDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EmployeeRouters {

    @Bean
    public RouterFunction<ServerResponse> createEmployeeRouterFunction(CreateEmployeeUseCase createEmployeeUseCase){
        return route(POST("api/employees/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(EmployeeDTO.class)
                        .flatMap(createEmployeeUseCase::create)
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteEmployeeRouterFunction(DeleteEmployeeUseCase deleteEmployeeUseCase){
        return route(DELETE("api/employees/delete/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(deleteEmployeeUseCase
                                        .delete(request.pathVariable("id")), Void.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findAllEmployeesRouterFunction(FindAllEmployeesUseCase findAllEmployeesUseCase){
        return route(GET("api/employees"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findAllEmployeesUseCase
                                        .findAll(), EmployeeDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findEmployeeByIdRouterFunction(FindEmployeeByIdUseCase findEmployeeByIdUseCase){
        return route(GET("api/employees/find/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findEmployeeByIdUseCase
                                        .findById(request.pathVariable("id")), EmployeeDTO.class))
        );
    }

}
