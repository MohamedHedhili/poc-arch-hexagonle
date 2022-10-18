package com.bnp.pocarchhexagonle.shared.dto;

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
public class OrderDto {
    private String id ;
    private BigDecimal amount;
    private Date date;
    private CustomerDto customerDto;
}
