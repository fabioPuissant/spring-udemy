package com.luv2code.springdemo.apps;

import com.luv2code.springdemo.coaches.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        // load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        //
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // Check if these are the same
        var result = (theCoach == alphaCoach);

        //print out the results
        System.out.println("\nPointing to the same object: " + result);

        System.out.println("\nMemory location for theCoach to the same object" + theCoach);
        System.out.println("\nMemory location for alphaCoach to the same object" + alphaCoach);

        context.close();
    }
}
