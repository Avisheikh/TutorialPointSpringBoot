package com.example.BeanNDependencyInjection.configuration;

import com.example.BeanNDependencyInjection.Service.CustomerService;
import com.example.BeanNDependencyInjection.Service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application
{

    /*
    * The mention below configuration is as same as the following xml config
    *
    * <bean id="customerService" class="com.example.BeanNDependencyInjection.Service.CustomerService" />
    * <bean id="orderService" class="com.example.BeanNDependencyInjection.Service.orderService"/>
    *
    * */

//    @Bean
//    public CustomerService customerService()
//    {
//        return new CustomerService();
//    }
//
//
//    @Bean
//    public OrderService orderService()
//    {
//        return new OrderService();
//    }
}
