package com.co.linadev.raul_hardware_backend.infrastructure;


import com.co.linadev.raul_hardware_backend.application.usecases.supplier.implementations.*;
import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierDTO;
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

    @Bean
    public RouterFunction<ServerResponse> fillSupplierDataRouterFunction(FillSupplierDataUseCase fillSupplierDataUseCase){
        return route(POST("api/suppliers/fillData").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(new ParameterizedTypeReference<List<SupplierDTO>>() {})
                        .flatMapMany(fillSupplierDataUseCase::fillData)
                        .collect(Collectors.toList())
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response)));
    }

}
