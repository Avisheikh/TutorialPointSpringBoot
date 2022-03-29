package com.example.BeanNDependencyInjection.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class OldProductServiceInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        System.out.println("\n----- OLd Interceptor.preHandle ----");
        System.out.println("Request URL:" + request.getRequestURL());
        System.out.println("Sorry! This URL is no longer used, Redirecct to /get_products");

        response.sendRedirect(request.getContextPath() + "/get_products");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        // This code will never be run.

        System.out.println("\n ---- old login interceptor post handle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        System.out.println("\n ------- QueryStringInterceptor.afterCompletion-----");
    }
}
