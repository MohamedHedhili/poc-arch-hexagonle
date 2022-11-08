package com.bnp.pocarchhexagonle.shared.mapper;

import com.bnp.pocarchhexagonle.domain.model.Customer;
import com.bnp.pocarchhexagonle.infrastructure.entities.CustomerEntity;
import com.bnp.pocarchhexagonle.shared.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer customerDtoToCustomer(final CustomerDto customerDto) ;
    CustomerDto customerToCustomerDto(final  Customer customer);
    CustomerEntity customerToCustomerEntity(final Customer customer);
    Customer customerEntityToCustomer(final CustomerEntity customerEntity);
}
