package com.example.BeanNDependencyInjection.DependencyInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApplication
{


    public static void main(String[] args)
    {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);


        context.close();

    }


}
