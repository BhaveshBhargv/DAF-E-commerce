package com.DFA.ecommerce.config;


import com.DFA.ecommerce.models.Users;
import com.DFA.ecommerce.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner2(UserRepository repository) {
        return args -> {
            Users admin = new Users(
                    "admin",
                    "admin",
                    "admin",
                    "admin"
            );

            repository.save(admin);

        };
    }
}
