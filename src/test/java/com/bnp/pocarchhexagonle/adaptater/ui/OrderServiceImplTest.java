package com.bnp.pocarchhexagonle.adaptater.ui;

import com.bnp.pocarchhexagonle.application.ui.OrderServiceImpl;
import com.bnp.pocarchhexagonle.domain.model.Customer;
import com.bnp.pocarchhexagonle.domain.model.Order;
import com.bnp.pocarchhexagonle.domain.port.persistance.OrderRepository;
import com.bnp.pocarchhexagonle.shared.dto.CustomerDto;
import com.bnp.pocarchhexagonle.shared.dto.OrderDto;
import com.bnp.pocarchhexagonle.shared.mapper.CustomerMapper;
import com.bnp.pocarchhexagonle.shared.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
  class OrderServiceImplTest {
    @Mock
    private  OrderRepository orderRepository;
    @Mock
    private  OrderMapper orderMapper;
    @Mock
    private  CustomerMapper customerMapper;
    @InjectMocks
    private OrderServiceImpl orderService;

    @Test
    void should_save_order_with_success(){
        final var order = buildOrder("order1",new Date(), new BigDecimal("320.2"));
        final var orderDto  = buildOrderDto("order1",new Date(), new BigDecimal("320.2"));
        //Given
        given(orderRepository.save(order)).willReturn(order);
        given(orderMapper.orderDtoToOrder(orderDto)).willReturn(order);
        given(orderMapper.orderToOrderDto(order)).willReturn(orderDto);
        //When
        final var orderSaved = orderService.save(orderDto);
        //Then
         assertThat(orderSaved).isNotNull();
         assertThat(orderSaved.getId()).isEqualTo("order1");
         assertThat(orderSaved.getAmount()).isEqualTo(new BigDecimal("320.2"));
    }
    @Test
    void should_get_orders_by_customer_with_success(){
        final var orderDto = buildOrderDto("order1",new Date(), new BigDecimal("320.2"));
        final var orderDto2 =buildOrderDto("order2",new Date(), new BigDecimal("26.5"));
        final var order1 = buildOrder("order1",new Date(), new BigDecimal("320.2"));
        final var order2 =buildOrder("order2",new Date(), new BigDecimal("26.5"));
        final var orders = List.of(order1,order2);
        //Given
        given(orderRepository.getOrdersByCustomer(buildCustomer())).willReturn(orders);
        given(orderMapper.orderToOrderDto(any())).willReturn(orderDto ,orderDto2);
        given(customerMapper.customerDtoToCustomer(buildCustomerDto())).willReturn(buildCustomer());
        //When
        final var ordersByCustomer = orderService.getOrdersByCustomer(buildCustomerDto());
        //Then
        assertThat(ordersByCustomer).isNotNull();
        assertThat(ordersByCustomer.size()).isEqualTo(2);
        assertThat(ordersByCustomer.get(0).getId()).isEqualTo("order1");
        assertThat(ordersByCustomer.get(0).getAmount()).isEqualTo(new BigDecimal("320.2"));
        assertThat(ordersByCustomer.get(1).getId()).isEqualTo("order2");
        assertThat(ordersByCustomer.get(1).getAmount()).isEqualTo(new BigDecimal("26.5"));
    }
    private Order buildOrder(final String id , final Date date , final BigDecimal amount ){
      return Order.builder().id(id).amount(amount).date(date).customer(buildCustomer()).build();
    }

    private Customer buildCustomer() {
        return Customer.builder().id("customer1").build();
    }

    private OrderDto buildOrderDto(final String id , final Date date , final BigDecimal amount ){
     return OrderDto.builder().id(id).amount(amount).date(date).customerDto(buildCustomerDto()).build();
    }

    private CustomerDto buildCustomerDto() {
        return CustomerDto.builder().id("customer1").build();
    }
}
