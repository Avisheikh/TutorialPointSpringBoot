package com.example.BeanNDependencyInjection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BeanNDependencyInjectionApplication
{

	Logger logger = LoggerFactory.getLogger(BeanNDependencyInjectionApplication.class);



	@GetMapping("/test/{name}")
	public String helloWold(@PathVariable String name)
	{
		logger.debug(name);
		return "hi "+ name;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(BeanNDependencyInjectionApplication.class, args);
	}

}
