package com.example.pagination.IOC;

public class BikeTrainer implements Trainer
{

    private Fortune fortune;

    public BikeTrainer() {
    }

    public BikeTrainer(Fortune fortune) {
        this.fortune = fortune;
    }

    @Override
    public String getDailyWorkout()
    {
        return "Practise 8 for 30 min";
    }

    @Override
    public String getDailyFortune() {
       return "Bike trainer: " + fortune.getFortune();
    }
}
