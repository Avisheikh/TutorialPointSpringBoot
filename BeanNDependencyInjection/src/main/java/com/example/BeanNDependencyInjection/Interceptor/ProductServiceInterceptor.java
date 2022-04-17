package com.example.BeanNDependencyInjection.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProductServiceInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        long startTime = System.currentTimeMillis();

        System.out.println("Pre Handle Method is Calling.");
        System.out.println("------ LogInterception.preHandle ---");
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Request TimeMilles: " + System.currentTimeMillis());

        request.setAttribute("StartTime", startTime);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object Handler, ModelAndView modelAndView) throws Exception
    {
        System.out.println("\n Post Handle method is calling");
        System.out.println("Request URL: " + request.getRequestURL());

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object Handler, Exception exception) throws Exception
    {
        System.out.println("Request and Response is completed");
        System.out.println("-------LogInterception.afterCompletion");
    }
}
