package com.co.linadev.raul_hardware_backend.infrastructure;


import com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations.CreateSupplierUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations.DeleteSupplierUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations.FindAllSuppliersUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations.FindSupplierByIdUseCase;
import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SupplierRouters {

    @Bean
    public RouterFunction<ServerResponse> createSupplierRouterFunction(CreateSupplierUseCase createSupplierUseCase){
        return route(POST("api/suppliers/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(SupplierDTO.class)
                        .flatMap(createSupplierUseCase::create)
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteSupplierRouterFunction(DeleteSupplierUseCase deleteSupplierUseCase){
        return route(DELETE("api/suppliers/delete/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(deleteSupplierUseCase
                                        .delete(request.pathVariable("id")), Void.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findAllSuppliersRouterFunction(FindAllSuppliersUseCase findAllSuppliersUseCase){
        return route(GET("api/suppliers"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findAllSuppliersUseCase
                                        .findAll(), SupplierDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findSupplierByIdRouterFunction(FindSupplierByIdUseCase findSupplierByIdUseCase){
        return route(GET("api/suppliers/find/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findSupplierByIdUseCase
                                        .findById(request.pathVariable("id")), SupplierDTO.class))
        );
    }

}
