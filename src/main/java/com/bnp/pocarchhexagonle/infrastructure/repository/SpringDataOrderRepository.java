package com.bnp.pocarchhexagonle.infrastructure.repository;

import com.bnp.pocarchhexagonle.infrastructure.entities.CustomerEntity;
import com.bnp.pocarchhexagonle.infrastructure.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataOrderRepository extends JpaRepository<OrderEntity,String> {
   List<OrderEntity> findByCustomerEntity(final CustomerEntity customerEntity);
}
