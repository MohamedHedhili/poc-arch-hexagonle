package com.bnp.pocarchhexagonle.infrastructure.repository;

import com.bnp.pocarchhexagonle.infrastructure.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpringDataCustomerRepository extends JpaRepository<CustomerEntity , String> {
}
