package com.co.linadev.raul_hardware_backend.application.mappers;


import com.co.linadev.raul_hardware_backend.domain.collections.Bill;
import com.co.linadev.raul_hardware_backend.domain.dtos.BillDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.function.Function;

@Component
public class BillMapper {

    public Function<Bill, BillDTO> mapToDto(){
        return bill -> new BillDTO(bill.getId(),
                bill.getEmployeeId(),
                bill.getCustomerId(),
                bill.getDate()
        );
    }

    public Function<BillDTO, Bill> mapToCollection(){
        return billDTO -> new Bill(billDTO.getId(),
                billDTO.getEmployeeId(),
                billDTO.getCustomerId(),
                LocalDateTime.now()
        );
    }

}
