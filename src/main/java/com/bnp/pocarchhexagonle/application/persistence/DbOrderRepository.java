package com.bnp.pocarchhexagonle.application.persistence;

import com.bnp.pocarchhexagonle.domain.model.Customer;
import com.bnp.pocarchhexagonle.domain.model.Order;
import com.bnp.pocarchhexagonle.domain.port.persistance.OrderRepository;
import com.bnp.pocarchhexagonle.infrastructure.repository.SpringDataOrderRepository;
import com.bnp.pocarchhexagonle.shared.mapper.CustomerMapper;
import com.bnp.pocarchhexagonle.shared.mapper.OrderMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class DbOrderRepository implements OrderRepository {
    private final SpringDataOrderRepository springDataOrderRepository;
    private final CustomerMapper customerMapper;
    private final OrderMapper orderMapper;

    public DbOrderRepository(final SpringDataOrderRepository springDataOrderRepository, final CustomerMapper customerMapper, final OrderMapper orderMapper) {
        this.springDataOrderRepository = springDataOrderRepository;
        this.customerMapper = customerMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<Order> getOrdersByCustomer(final Customer customer) {
        final var orderEntityList = springDataOrderRepository.findByCustomerEntity(customerMapper.customerToCustomerEntity(customer));

        return orderEntityList.stream().map(orderMapper::orderEntityToOrder).collect(Collectors.toList());
    }

    @Override
    public Order save(final Order order) {
        final var orderEntity = orderMapper.orderToOderEntity(order);
        orderEntity.setId(UUID.randomUUID().toString());
        final var orderSaved = springDataOrderRepository.save(orderEntity);
        return orderMapper.orderEntityToOrder(orderSaved);
    }

    @Override
    public Order getOrder(final String id) {
        final var orderEntity = springDataOrderRepository.findById(id);
        Order order = null;
        if (orderEntity.isPresent())
            order = orderMapper.orderEntityToOrder(orderEntity.get());
        return order;
    }

    @Override
    public void delete(final String id) {
        springDataOrderRepository.deleteById(id);
    }
}
