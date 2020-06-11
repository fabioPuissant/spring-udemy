package com.luv2code.springDemo;

import com.luv2code.springDemo.coaches.Coach;
import com.luv2code.springDemo.coaches.SwimCoach;
import com.luv2code.springDemo.configs.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        // load spring config file
        var context = new AnnotationConfigApplicationContext(SportConfig.class);

        // retrieve bean from the spring container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        // do some methods
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println("Contact: " + theCoach.getEmail());
        System.out.println("Team: " + theCoach.getTeam());

        context.close();
    }
}
