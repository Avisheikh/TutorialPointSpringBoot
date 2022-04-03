package com.example.BeanNDependencyInjection.DependencyInjection;

public class TwitterService implements MessageService
{
    @Override
    public boolean sendMessage(String msg, String rec)
    {
        System.out.println("Email is sent to "+rec + " with message " + msg);
        return true;
    }
}
