package com.example.BeanNDependencyInjection.BeanAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

public class CollegeConfig
{

   public College collegeBean()
   {
       // returns the College class objecct
       return new College();
   }
}
