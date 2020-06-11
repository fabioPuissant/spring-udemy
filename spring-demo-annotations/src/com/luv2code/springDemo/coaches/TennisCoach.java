package com.luv2code.springDemo.coaches;

import com.luv2code.springDemo.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Primary
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

//    @Autowired
//    public void setFortuneService(FortuneService fortuneService) {
//        this.fortuneService = fortuneService;
//    }
 //   @Autowired
//    public void blalblaFortuneService (FortuneService fortuneService) {
//        System.out.println("Do crazy stuff");
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backend volley";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    // the init method when object is getting construct
    @PostConstruct
    public void init(){
        System.out.println(">> TennisCoach: inside of init -method");
    }

    // the destroy method when class is getting destroyed
    @PreDestroy
    public void destroy() {
        System.out.println(">> TennisCoach: inside of destroy -method");

    }
}
