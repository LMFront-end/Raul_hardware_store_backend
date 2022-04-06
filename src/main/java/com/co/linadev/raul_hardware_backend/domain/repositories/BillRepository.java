package com.co.linadev.raul_hardware_backend.domain.repositories;

import com.co.linadev.raul_hardware_backend.domain.collections.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends ReactiveMongoRepository<Bill, String > {
}
