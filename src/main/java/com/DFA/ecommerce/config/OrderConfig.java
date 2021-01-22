package com.DFA.ecommerce.config;

import com.DFA.ecommerce.models.Orders;
import com.DFA.ecommerce.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    CommandLineRunner commandLineRunner1(OrderRepository repository) {
        return args -> {
            Orders order1 = new Orders(
                    "Eggs",
                    8770546296L,
                    "Bangalore",
                    10L,
                    70L,
                    "Order received",
                    "Poultry"
            );
            Orders order2 = new Orders(
                    "Milk",
                    8770546296L,
                    "Bangalore",
                    5L,
                    100L,
                    "Order received",
                    "Dairy"
            );
            Orders order3 = new Orders(
                    "Curd",
                    8770546296L,
                    "Bangalore",
                    3L,
                    75L,
                    "Order received",
                    "Dairy"
            );
            repository.save(order1);
            repository.save(order2);
            repository.save(order3);
        };
    }
}
