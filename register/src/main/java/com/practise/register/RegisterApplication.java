package com.practise.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableWebMvc
public class RegisterApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(RegisterApplication.class);
	}


	public static void main(String[] args)
	{
		SpringApplication.run(RegisterApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer()
//	{
//		return new WebMvcConfigurerAdapter()
//		{
//			@Override
//			public void addCorsMappings(CorsRegistry registry)
//			{
//				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
//			}
//		};
//	}

}
