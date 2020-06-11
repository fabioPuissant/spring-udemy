package com.luv2code.springdemo.apps;

import com.luv2code.springdemo.coaches.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        // Load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve bean from spring container
        Coach coach = context.getBean("myCricketCoach", Coach.class);

        // Call the methods on the bean
        System.out.println(coach.getDailyPractice());

        // Let's call our new method for fortunes
        System.out.println(coach.getDailyFortune());

        // Close the context
        context.close();
    }
}
