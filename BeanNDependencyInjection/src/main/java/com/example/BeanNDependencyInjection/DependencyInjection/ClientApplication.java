package com.example.BeanNDependencyInjection.DependencyInjection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientApplication
{


    public static void main(String[] args)
    {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfig.class);

        MyApplication app = context.getBean(MyApplication.class);

        app.processMessage("Hi pak","dfjslk");

        context.close();

    }


}
