package com.example.pagination.IOC;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp
{
    public static void main(String[] args) {

        HappyFortune happyFortune = new HappyFortune();
        BikeTrainer bikeTrainer2 = new BikeTrainer();
        BikeTrainer bikeTrainer = new BikeTrainer(happyFortune);
        System.out.println(happyFortune.getFortune());
//        System.out.println(bikeTrainer2.getDailyFortune());
        System.out.println(bikeTrainer.getDailyFortune());

        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        // retrieve bean from spring container
        Trainer trainer = context.getBean("myTrainer", Trainer.class);

        // call methods on the bean
        System.out.println(trainer.getDailyWorkout());
        System.out.println(trainer.getDailyFortune());

        // close the context
        context.close();


    }
}
