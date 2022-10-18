package com.bnp.pocarchhexagonle.shared.mapper;

import com.bnp.pocarchhexagonle.domain.model.Order;
import com.bnp.pocarchhexagonle.jpa.entities.OrderEntity;
import com.bnp.pocarchhexagonle.shared.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "customerDto.id", target = "customer.id")
    @Mapping(source = "customerDto.firstName", target = "customer.firstName")
    @Mapping(source = "customerDto.lastName", target = "customer.lastName")
    @Mapping(source = "customerDto.email", target = "customer.email")
    Order orderDtoToOrder(final OrderDto orderDto) ;
    @Mapping(source = "customer.id", target = "customerDto.id")
    @Mapping(source = "customer.firstName", target = "customerDto.firstName")
    @Mapping(source = "customer.lastName", target = "customerDto.lastName")
    @Mapping(source = "customer.email", target = "customerDto.email")
    OrderDto orderToOrderDto(final  Order order);
    @Mapping(source = "customer.id", target = "customerEntity.id")
    @Mapping(source = "customer.firstName", target = "customerEntity.firstName")
    @Mapping(source = "customer.lastName", target = "customerEntity.lastName")
    @Mapping(source = "customer.email", target = "customerEntity.email")
    OrderEntity orderToOderEntity(final Order order);
    @Mapping(source = "customerEntity.id", target = "customer.id")
    @Mapping(source = "customerEntity.firstName", target = "customer.firstName")
    @Mapping(source = "customerEntity.lastName", target = "customer.lastName")
    @Mapping(source = "customerEntity.email", target = "customer.email")
    Order orderEntityToOrder(final OrderEntity orderEntity);
}
