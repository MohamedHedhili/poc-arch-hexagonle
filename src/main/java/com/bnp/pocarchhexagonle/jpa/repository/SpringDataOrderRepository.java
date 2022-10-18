package com.bnp.pocarchhexagonle.jpa.repository;

import com.bnp.pocarchhexagonle.jpa.entities.CustomerEntity;
import com.bnp.pocarchhexagonle.jpa.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataOrderRepository extends JpaRepository<OrderEntity,String> {
   List<OrderEntity> findByCustomerEntity(final CustomerEntity customerEntity);
}
