package com.example.BeanNDependencyInjection.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringConfig
{

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }


}
