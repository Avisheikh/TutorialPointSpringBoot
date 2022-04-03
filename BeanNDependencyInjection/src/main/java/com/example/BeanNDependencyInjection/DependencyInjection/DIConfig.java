package com.example.BeanNDependencyInjection.DependencyInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.example.BeanNDependencyInjection.DependencyInjection"})
public class DIConfig
{

    @Bean
    public MessageService messageService()
    {
        return new EmailService();
    }

}
