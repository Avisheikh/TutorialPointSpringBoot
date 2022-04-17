package com.example.pagination.IOC;

public class MyApp
{
    public static void main(String[] args) {

        // create the object
        Trainer trainer = new BikeTrainer();

        // use the object
        System.out.println(trainer.getDailyWorkout());
    }
}
