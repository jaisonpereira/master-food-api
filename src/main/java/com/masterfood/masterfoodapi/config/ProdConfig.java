package com.masterfood.masterfoodapi.config;

import com.masterfood.masterfoodapi.services.EmailServiceImpl;
import com.wirelabs.service.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "prod")
public class ProdConfig {

    @Bean
    public EmailService emailService() {
        return new EmailServiceImpl();
    }

}
