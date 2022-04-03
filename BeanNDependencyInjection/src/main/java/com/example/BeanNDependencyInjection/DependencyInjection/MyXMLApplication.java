package com.example.BeanNDependencyInjection.DependencyInjection;

public class MyXMLApplication
{
    private MessageService messageService;

    //constructor-based dependency injection
//	public MyXMLApplication(MessageService svc) {
//		this.service = svc;
//	}

    //setter-based dependency injection
    public void setMessageService(MessageService messageService)
    {
        this.messageService = messageService;
    }

    public boolean processMessage(String msg, String rec)
    {
        return this.messageService.sendMessage(msg,rec);
    }
}
