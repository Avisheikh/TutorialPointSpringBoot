package com.example.BeanNDependencyInjection.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdminInterceptor implements HandlerInterceptor
{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        System.out.println("\n------ Admin Interceptor pre handle -----");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) throws Exception
    {
        System.out.println("\n ----- AdminInterceptor.postHandle -----");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        System.out.println("\n -----Admin Interceptor.afterCompletion");
    }


}
