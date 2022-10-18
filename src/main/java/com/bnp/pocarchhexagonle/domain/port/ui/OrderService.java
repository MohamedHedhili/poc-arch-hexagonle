package com.bnp.pocarchhexagonle.domain.port.ui;

import com.bnp.pocarchhexagonle.shared.dto.CustomerDto;
import com.bnp.pocarchhexagonle.shared.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto save (final OrderDto orderDto);
    List<OrderDto> getOrdersByCustomer(final CustomerDto customerDto);
    OrderDto getOrder(final String id);
    void delete(final String id);
}
