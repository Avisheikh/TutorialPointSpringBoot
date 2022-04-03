package com.example.BeanNDependencyInjection.DependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class MyApplication
{
    //field based on dependency injection
    //@Autowired
    private MessageService messageService;

    //Controller based auto wired
    //@Autowired
    //public MyApplication(MessageService msg)
    //{this.messageService=msg}

    //setter autowired
    public void setMessageService(MessageService messageService)
    {
        this.messageService = messageService;

    }

    public boolean processMessage(String msg, String rec)
    {
        //some message like validation, looging etc
        System.out.println(msg);
        return this.messageService.sendMessage(msg, rec);
    }
}
