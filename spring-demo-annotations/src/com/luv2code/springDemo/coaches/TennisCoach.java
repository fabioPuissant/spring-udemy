package com.luv2code.springDemo.coaches;

import com.luv2code.springDemo.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class TennisCoach implements Coach {
    @Autowired
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
}
