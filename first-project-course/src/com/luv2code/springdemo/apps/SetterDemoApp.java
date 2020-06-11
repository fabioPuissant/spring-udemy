package com.luv2code.springdemo.apps;

import com.luv2code.springdemo.coaches.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        CricketCoach theCoach = context.getBean("myCricketCoach2", CricketCoach.class);

        // call methods on bean
        System.out.println("The coach contact: " + theCoach.toString());
        System.out.println(theCoach.getDailyPractice());
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
