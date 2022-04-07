package com.co.linadev.raul_hardware_backend.application.mappers;


import com.co.linadev.raul_hardware_backend.domain.collections.Bill;
import com.co.linadev.raul_hardware_backend.domain.dtos.CustomerBillDTO;
import com.co.linadev.raul_hardware_backend.domain.dtos.SupplierBillDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Function;

@Component
public class BillMapper {

    public Function<Bill, CustomerBillDTO> mapToCustomerBillDto(){
        return bill -> new CustomerBillDTO(bill.getId(),
                bill.getEmployeeId(),
                bill.getCustomerId(),
                bill.getDate()
        );
    }

    public Function<CustomerBillDTO, Bill> mapToCollectionFromCustomerBill(){
        return billDTO -> new Bill(billDTO.getId(),
                billDTO.getEmployeeId(),
                billDTO.getCustomerId(),
                null,
                LocalDateTime.now()
        );
    }

    public Function<Bill, SupplierBillDTO> mapToSupplierBillDto(){
        return bill -> new SupplierBillDTO(bill.getId(),
                bill.getSupplierId(),
                bill.getDate()
        );
    }

    public Function<SupplierBillDTO, Bill> mapToCollectionFromSupplierBill(){
        return billDTO -> new Bill(billDTO.getId(),
                null,
                null,
                billDTO.getSupplierId(),
                LocalDateTime.now()
        );
    }

}
