package com.bnp.pocarchhexagonle.adaptater.persistence;

import com.bnp.pocarchhexagonle.domain.model.Customer;
import com.bnp.pocarchhexagonle.jpa.entities.CustomerEntity;
import com.bnp.pocarchhexagonle.domain.port.persistance.CustomerRepository;
import com.bnp.pocarchhexagonle.jpa.repository.SpringDataCustomerRepository;
import com.bnp.pocarchhexagonle.shared.mapper.CustomerMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DbCustomerRepository implements CustomerRepository {
    private final SpringDataCustomerRepository springDataCustomerRepository;
    private final CustomerMapper customerMapper;

    public DbCustomerRepository(final SpringDataCustomerRepository springDataCustomerRepository, final CustomerMapper customerMapper) {
        this.springDataCustomerRepository = springDataCustomerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer getCustomer(String id) {
        final var customerEntity = springDataCustomerRepository.findById(id);
        Customer customer = null;
        if (customerEntity.isPresent())
         customer = customerMapper.customerEntityToCustomer(customerEntity.get());
        return customer;
    }

    @Override
    public Customer save(final Customer customer) {
        final var customerEntity = customerMapper.customerToCustomerEntity(customer);
        final var customerSaved =   springDataCustomerRepository.save(customerEntity);
        return customerMapper.customerEntityToCustomer(customerSaved);
    }

    @Override
    public Customer update(Customer customer) {
        final var customerEntity = customerMapper.customerToCustomerEntity(customer);
        final var customerUpdated =   springDataCustomerRepository.save(customerEntity);
        return customerMapper.customerEntityToCustomer(customerUpdated);
    }

    @Override
    public List<Customer> getAll() {
        final List<CustomerEntity> customerEntityList = springDataCustomerRepository.findAll();
        return customerEntityList.stream().map(customerMapper::customerEntityToCustomer).collect(Collectors.toList());
    }
}
