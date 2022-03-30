package com.example.BeanNDependencyInjection.Interceptor;

import org.aopalliance.intercept.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ProductServiceInterceptorAppConfig extends WebMvcConfigurerAdapter
{
    @Autowired
    ProductServiceInterceptor productServiceInterceptor;

    @Autowired
    OldProductServiceInterceptor oldProductServiceInterceptor;

    @Autowired
    AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        // apply to all URLs.
        registry.addInterceptor(productServiceInterceptor);

        // Old Login url, no longer use
        // use old url interceptor to redirect to a new  URL.
//        registry.addInterceptor(oldProductServiceInterceptor)
//                .excludePathPatterns("/products");
//
//        // This interceptor apply to URLlike /admin/
//        // Exclude /admin/oldLogin
//        registry.addInterceptor(adminInterceptor)
//                .addPathPatterns("/admin/*")
//                .excludePathPatterns("/admin/oldLogin");
    }

}
