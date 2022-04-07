package com.co.linadev.raul_hardware_backend.infrastructure;


import com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations.*;
import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CustomerRouters {

    @Bean
    public RouterFunction<ServerResponse> createCustomerRouterFunction(CreateCustomerUseCase createCustomerUseCase){
        return route(POST("api/customers/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CustomerDTO.class)
                        .flatMap(createCustomerUseCase::create)
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteCustomerRouterFunction(DeleteCustomerUseCase deleteCustomerUseCase){
        return route(DELETE("api/customers/delete/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(deleteCustomerUseCase
                                        .delete(request.pathVariable("id")), Void.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findAllCustomersRouterFunction(FindAllCustomersUseCase findAllCustomersUseCase){
        return route(GET("api/customers"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findAllCustomersUseCase
                                        .findAll(), CustomerDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findCustomerByIdRouterFunction(FindCustomerByIdUseCase findCustomerByIdUseCase){
        return route(GET("api/customers/find/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findCustomerByIdUseCase
                                        .findById(request.pathVariable("id")), CustomerDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> fillCustomerDataRouterFunction(FillCustomerDataUseCase fillCustomerDataUseCase){
        return route(POST("api/customers/fillData").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(new ParameterizedTypeReference<List<CustomerDTO>>() {})
                        .flatMapMany(fillCustomerDataUseCase::fillData)
                        .collect(Collectors.toList())
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response)));
    }

}
