package com.luv2code.springDemo;

import com.luv2code.springDemo.coaches.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        // load spring config file
        var context = new ClassPathXmlApplicationContext("applicationContext.xml");

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
