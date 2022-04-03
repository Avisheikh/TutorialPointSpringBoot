package com.example.BeanNDependencyInjection.DependencyInjection;


//Now we will have actual implementation classes to send email and twitter message.

public class EmailService implements MessageService
{
    public boolean sendMessage(String msg, String rec)
    {
        System.out.println("Email sent to " + rec + " with message="+msg);
        return true;
    }
}
