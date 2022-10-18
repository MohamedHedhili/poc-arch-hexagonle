package com.bnp.pocarchhexagonle.controller;

import com.bnp.pocarchhexagonle.domain.port.ui.CustomerService;
import com.bnp.pocarchhexagonle.shared.CommonConstants;
import com.bnp.pocarchhexagonle.shared.dto.CustomerDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = CommonConstants.CUSTOMER_API)
public class CustomerRestController {
    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping(path=CommonConstants.CUSTOMERS)
    public List<CustomerDto> allCustomers (){
        return customerService.getAll();
    }
    @PostMapping(path=CommonConstants.SAVE)
    public CustomerDto save(@RequestBody final CustomerDto customerDto){
        customerDto.setId(UUID.randomUUID().toString());
        return customerService.save(customerDto);
    }
    @GetMapping(path=CommonConstants.CUSTOMERS+CommonConstants.PARAM_ID)
    public CustomerDto getCustomer(@PathVariable final String id){
        return customerService.getCustomer(id);
    }
    @PutMapping (path=CommonConstants.UPDATE)
    public CustomerDto update(@RequestBody final CustomerDto customerDto){
        return customerService.update(customerDto);
    }
}
