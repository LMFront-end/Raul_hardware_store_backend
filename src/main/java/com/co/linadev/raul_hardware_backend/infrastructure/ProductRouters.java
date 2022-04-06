package com.co.linadev.raul_hardware_backend.infrastructure;

import com.co.linadev.raul_hardware_backend.application.usecases.product.implementations.CreateProductUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.product.implementations.DeleteProductUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.product.implementations.FindAllProductsUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.product.implementations.FindProductByIdUseCase;
import com.co.linadev.raul_hardware_backend.domain.dtos.ProductDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ProductRouters {

    @Bean
    public RouterFunction<ServerResponse> createProductRouter(CreateProductUseCase createProductUseCase){
        return route(POST("api/products/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(createProductUseCase::create)
                        .flatMap(response -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(response))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> deleteProductRouterFunction(DeleteProductUseCase deleteProductUseCase){
        return route(DELETE("api/products/delete/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(deleteProductUseCase
                                        .delete(request.pathVariable("id")), Void.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findAllProductsRouterFunction(FindAllProductsUseCase findAllProductsUseCase){
        return route(GET("api/products"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findAllProductsUseCase
                                        .findAll(), ProductDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findProductByIdRouterFunction(FindProductByIdUseCase findProductByIdUseCase){
        return route(GET("api/products/find/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findProductByIdUseCase
                                        .findById(request.pathVariable("id")), ProductDTO.class))
        );
    }
}
