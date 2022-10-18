package com.bnp.pocarchhexagonle;

import com.bnp.pocarchhexagonle.domain.port.ui.CustomerService;
import com.bnp.pocarchhexagonle.domain.port.ui.OrderService;
import com.bnp.pocarchhexagonle.shared.dto.CustomerDto;
import com.bnp.pocarchhexagonle.shared.dto.OrderDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class PocArchHexagonleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocArchHexagonleApplication.class, args);
    }
    @Bean
    CommandLineRunner start (final CustomerService customerService , final OrderService orderService){
        return args -> {
            customerService.save(new CustomerDto("CUSTOMER25","Mohamed","HEDHILI","hedhili@bnp.com"));
            final var customer = new CustomerDto();
            customer.setId("CUSTOMER25");
            orderService.save(new OrderDto("order1",new BigDecimal(500),new Date(),customer));
            System.out.println(orderService.getOrdersByCustomer(customer));

        };
    }

}
