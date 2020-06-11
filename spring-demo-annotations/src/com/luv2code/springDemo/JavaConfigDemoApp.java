package com.luv2code.springDemo;

import com.luv2code.springDemo.coaches.Coach;
import com.luv2code.springDemo.configs.SportConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {
        // load spring config file
        var context = new AnnotationConfigApplicationContext(SportConfig.class);

        // retrieve bean from the spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // check if two coaches are the same
        boolean sameResult = (theCoach == alphaCoach);

        // print out the results
        System.out.println("\nPointing to the same object: " + sameResult);

        context.close();
    }
}
