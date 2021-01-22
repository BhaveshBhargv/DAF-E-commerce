package com.DFA.ecommerce.config;

import com.DFA.ecommerce.models.Items;
import com.DFA.ecommerce.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemConfig {

    @Bean
    CommandLineRunner commandLineRunner(ItemRepository repository) {
        return args -> {
            Items item1 = new Items(
                    "Egg",
                    "Poultry",
                    7L,
                    100L
            );
            Items item2 = new Items(
                    "Milk",
                    "Dairy",
                    20L,
                    100L
            );Items item3 = new Items(
                    "Curd",
                    "Dairy",
                    25L,
                    100L
            );
            repository.save(item1);
            repository.save(item2);
            repository.save(item3);
        };
    }
}
