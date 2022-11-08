package com.bnp.pocarchhexagonle.application.ui;

import com.bnp.pocarchhexagonle.domain.port.persistance.OrderRepository;
import com.bnp.pocarchhexagonle.domain.port.ui.OrderService;
import com.bnp.pocarchhexagonle.shared.dto.CustomerDto;
import com.bnp.pocarchhexagonle.shared.dto.OrderDto;
import com.bnp.pocarchhexagonle.shared.mapper.CustomerMapper;
import com.bnp.pocarchhexagonle.shared.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private final CustomerMapper customerMapper;

    public OrderServiceImpl(final OrderRepository orderRepository, final OrderMapper orderMapper, CustomerMapper customerMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customerMapper = customerMapper;
    }

    @Override
    public OrderDto save(final OrderDto orderDto) {
        final var order = orderMapper.orderDtoToOrder(orderDto);
        final var orderSaved = orderRepository.save(order);
        return orderMapper.orderToOrderDto(orderSaved);
    }

    @Override
    public List<OrderDto> getOrdersByCustomer(final CustomerDto customerDto) {
        final var orders = orderRepository.getOrdersByCustomer(customerMapper.customerDtoToCustomer(customerDto));
        return orders.stream().map(orderMapper::orderToOrderDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrder(final String id) {
        final var order = orderRepository.getOrder(id);
        return orderMapper.orderToOrderDto(order);
    }

    @Override
    public void delete(final String id) {
        orderRepository.delete(id);
    }
}
