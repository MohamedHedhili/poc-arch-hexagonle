package com.bnp.pocarchhexagonle.domain.model;

import com.bnp.pocarchhexagonle.domain.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private String id ;
    private Date date ;
    private BigDecimal amount;
    private Customer customer;
}
