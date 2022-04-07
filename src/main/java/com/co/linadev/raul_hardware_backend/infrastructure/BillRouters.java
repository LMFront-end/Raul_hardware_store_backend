package com.co.linadev.raul_hardware_backend.infrastructure;


import com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations.*;
import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerBillDTO;
import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierBillDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BillRouters {

    @Bean
    public RouterFunction<ServerResponse> createCustomerBillRouterFunction(CreateCustomerBillUseCase createBillUseCase){
        return route(POST("api/bills/customer/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CustomerBillDTO.class)
                        .flatMap(createBillUseCase::create)
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> createSupplierBillRouterFunction(CreateSupplierBillUseCase createSupplierBillUseCase){
        return route(POST("api/bills/supplier/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(SupplierBillDTO.class)
                        .flatMap(createSupplierBillUseCase::create)
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteBillRouterFunction(DeleteBillUseCase deleteBillUseCase){
        return route(DELETE("api/bills/delete/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(deleteBillUseCase
                                        .delete(request.pathVariable("id")), Void.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findAllBillsRouterFunction(FindAllBillsUseCase findAllBillsUseCase){
        return route(GET("api/bills"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findAllBillsUseCase
                                        .findAll(), CustomerBillDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findBillByIdRouterFunction(FindBillByIdUseCase findBillByIdUseCase){
        return route(GET("api/bills/find/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findBillByIdUseCase
                                        .findById(request.pathVariable("id")), CustomerBillDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findAllCustomerBillsRouterFunction(FindAllCustomerBillsUseCase findAllCustomerBillsUseCase){
        return route(GET("api/bills/customers/find"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findAllCustomerBillsUseCase
                                        .findAll(), CustomerBillDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findAllSupplierBillsRouterFunction(FindAllSupplierBillsUseCase findAllSupplierBillsUseCase){
        return route(GET("api/bills/suppliers/find"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findAllSupplierBillsUseCase
                                        .findAll(), SupplierBillDTO.class))
        );
    }

}
