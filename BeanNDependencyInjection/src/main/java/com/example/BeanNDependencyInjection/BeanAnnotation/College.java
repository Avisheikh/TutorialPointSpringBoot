package com.example.BeanNDependencyInjection.BeanAnnotation;

import org.springframework.stereotype.Component;

@Component("collegeBean")
public class College
{
    public void test()
    {
        System.out.println("test college method");
    }
}
