package com.co.linadev.raul_hardware_backend.application.mappers;


import com.co.linadev.raul_hardware_backend.domain.collections.Supplier;
import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class SupplierMapper {

    public Function<Supplier, SupplierDTO> mapToDto(){
        return supplier -> new SupplierDTO(supplier.getId(),
                                            supplier.getName(),
                                            supplier.getIdentityDocument()
        );
    }

    public Function<SupplierDTO, Supplier> mapToCollection(){
        return supplierDTO -> new Supplier(supplierDTO.getId(),
                supplierDTO.getName(),
                supplierDTO.getIdentityDocument()
        );
    }

}
