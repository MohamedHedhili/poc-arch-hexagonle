package com.bnp.pocarchhexagonle.domain.port.persistance;

import com.bnp.pocarchhexagonle.domain.model.Customer;
import com.bnp.pocarchhexagonle.domain.model.Order;

import java.util.List;

public interface OrderRepository {
    List<Order> getOrdersByCustomer(final Customer customer);
    Order save(final Order order);
    Order getOrder(final String id);
    void delete(final String id);
}
