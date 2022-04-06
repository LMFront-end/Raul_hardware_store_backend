package com.co.linadev.raul_hardware_backend.infrastructure;


import com.co.linadev.raul_hardware_backend.application.usecases.transaction.implementations.CreateTransactionUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.transaction.implementations.DeleteTransactionUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.transaction.implementations.FindAllTransactionsUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.transaction.implementations.FindTransactionByIdUseCase;
import com.co.linadev.raul_hardware_backend.domain.dtos.TransactionDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TransactionRouters {

    @Bean
    public RouterFunction<ServerResponse> createTransactionRouterFunction(CreateTransactionUseCase createTransactionUseCase){
        return route(POST("api/transactions/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TransactionDTO.class)
                        .flatMap(createTransactionUseCase::create)
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteTransactionRouterFunction(DeleteTransactionUseCase deleteTransactionUseCase){
        return route(DELETE("api/transactions/delete/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(deleteTransactionUseCase
                                        .delete(request.pathVariable("id")), Void.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findAllTransactionsRouterFunction(FindAllTransactionsUseCase findAllTransactionsUseCase){
        return route(GET("api/transactions"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findAllTransactionsUseCase
                                        .findAll(), TransactionDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findTransactionByIdRouterFunction(FindTransactionByIdUseCase findTransactionByIdUseCase){
        return route(GET("api/transactions/find/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findTransactionByIdUseCase
                                        .findById(request.pathVariable("id")), TransactionDTO.class))
        );
    }

}
