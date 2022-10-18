package com.bnp.pocarchhexagonle.jpa.repository;

import com.bnp.pocarchhexagonle.jpa.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SpringDataCustomerRepository extends JpaRepository<CustomerEntity , String> {
}
