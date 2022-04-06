package com.co.linadev.raul_hardware_backend.infrastructure;


import com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations.CreateBillUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations.DeleteBillUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations.FindAllBillsUseCase;
import com.co.linadev.raul_hardware_backend.application.usecases.bill.implementations.FindBillByIdUseCase;
import com.co.linadev.raul_hardware_backend.domain.dtos.BillDTO;
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
    @RouterOperations(@RouterOperation(path = "/api/bills/create"
            , produces = {
            MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.POST, beanClass = CreateBillUseCase.class, beanMethod = "updateEmployee",
            operation = @Operation(operationId = "updateEmployee", responses = {
                    @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = BillDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Bill not found")}, parameters = {
                    @Parameter(in = ParameterIn.PATH, name = "employeeId")}
                    , requestBody = @RequestBody(content = @Content(schema = @Schema(implementation = BillDTO.class))))
    ))
    public RouterFunction<ServerResponse> createBillRouterFunction(CreateBillUseCase createBillUseCase){
        return route(POST("api/bills/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BillDTO.class)
                        .flatMap(createBillUseCase::create)
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
                                        .findAll(), BillDTO.class))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> findBillByIdRouterFunction(FindBillByIdUseCase findBillByIdUseCase){
        return route(GET("api/bills/find/{id}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters
                                .fromPublisher(findBillByIdUseCase
                                        .findById(request.pathVariable("id")), BillDTO.class))
        );
    }

}
