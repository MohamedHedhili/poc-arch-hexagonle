package com.bnp.pocarchhexagonle.adaptater.ui;

import com.bnp.pocarchhexagonle.domain.port.persistance.CustomerRepository;
import com.bnp.pocarchhexagonle.domain.port.ui.CustomerService;
import com.bnp.pocarchhexagonle.shared.dto.CustomerDto;
import com.bnp.pocarchhexagonle.shared.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository ;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(final CustomerRepository customerRepository, final CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDto getCustomer(final String id) {
        final var customer = customerRepository.getCustomer(id);
        return customerMapper.customerToCustomerDto(customer);
    }

    @Override
    public CustomerDto save(final CustomerDto customerDto) {
        final var customer = customerMapper.customerDtoToCustomer(customerDto);
        final var customerSaved = customerRepository.save(customer);
        return customerMapper.customerToCustomerDto(customerSaved);
    }

    @Override
    public CustomerDto update(final CustomerDto customerDto) {
        final var customer = customerMapper.customerDtoToCustomer(customerDto);
        final var customerUpdated = customerRepository.update(customer);
        return customerMapper.customerToCustomerDto(customerUpdated);
    }

    @Override
    public List<CustomerDto> getAll() {
        final var customerList =  customerRepository.getAll();
        return customerList.stream().map(customerMapper::customerToCustomerDto).collect(Collectors.toList());
    }
}
