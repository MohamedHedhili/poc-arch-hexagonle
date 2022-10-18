package com.bnp.pocarchhexagonle.controller;

import com.bnp.pocarchhexagonle.domain.port.ui.OrderService;
import com.bnp.pocarchhexagonle.shared.CommonConstants;
import com.bnp.pocarchhexagonle.shared.dto.CustomerDto;
import com.bnp.pocarchhexagonle.shared.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping (path = CommonConstants.ORDER_API)
public class OrderRestController {
    private final OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping(path=CommonConstants.ORDERS+CommonConstants.CUSTOMER_ID_PARAM)
    public List<OrderDto> allOrderByCustomer (@PathVariable final String idCustomer){
        final var customerDto = new CustomerDto();
        customerDto.setId(idCustomer);
        return orderService.getOrdersByCustomer(customerDto);
    }
    @PostMapping(path=CommonConstants.SAVE)
    public OrderDto save(@RequestBody final OrderDto orderDto){
        orderDto.setId(UUID.randomUUID().toString());
        return orderService.save(orderDto);
    }
    @GetMapping(path=CommonConstants.ORDERS+CommonConstants.PARAM_ID)
    public OrderDto getOrder(@PathVariable(name = "id") final String id){
        return orderService.getOrder(id);
    }
    @DeleteMapping (path=CommonConstants.DELETE)
    public void delete(@RequestBody final String id){
         orderService.delete(id);
    }
}
