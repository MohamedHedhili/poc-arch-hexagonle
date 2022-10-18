package com.bnp.pocarchhexagonle.domain.port.ui;

import com.bnp.pocarchhexagonle.shared.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto getCustomer(final String id);
    CustomerDto save(final CustomerDto customerDto);
    CustomerDto update (final CustomerDto customerDto);
    List<CustomerDto> getAll();
}
