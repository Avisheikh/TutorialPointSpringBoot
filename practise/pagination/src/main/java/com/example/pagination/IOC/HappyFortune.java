package com.example.pagination.IOC;

public class HappyFortune implements Fortune
{
    @Override
    public String getFortune()
    {
        return "Today is my lucky day!";
    }
}
