package com.example.BeanNDependencyInjection.BeanAnnotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);

        // Getting the bean
        College college = context.getBean("collegeBean", College.class);
        College college1 = new College();


        //Invoking the method
        college.test();

        college1.test();
    }
}
