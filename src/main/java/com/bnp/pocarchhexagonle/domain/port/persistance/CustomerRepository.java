package com.bnp.pocarchhexagonle.domain.port.persistance;

import com.bnp.pocarchhexagonle.domain.model.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer getCustomer(final String id);
    Customer save(final Customer customer);
    Customer update (final Customer customer);
    List<Customer> getAll();
}
