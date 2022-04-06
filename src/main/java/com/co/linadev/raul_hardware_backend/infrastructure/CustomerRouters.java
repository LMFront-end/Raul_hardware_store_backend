package com.co.linadev.raul_hardware_backend.infrastructure;


import com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations.CreateCustomerUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations.DeleteCustomerUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations.FindAllCustomersUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.customer.implementations.FindCustomerByIdUseCase;
import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

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

}
