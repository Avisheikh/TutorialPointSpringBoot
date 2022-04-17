package com.example.pagination.IOC;

public class CyclingTrainer implements Trainer
{

    private Fortune fortune;

    public CyclingTrainer(Fortune fortune)
    {
        this.fortune = fortune;
    }

    @Override
    public String getDailyWorkout()
    {
        return "Spend 30 min to cycle uphill to indrathan";
    }

    @Override
    public String getDailyFortune() {

        // use fortune to get a fortune
        return fortune.getFortune();
    }
}
