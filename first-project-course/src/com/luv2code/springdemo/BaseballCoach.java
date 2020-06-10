package com.luv2code.springdemo;

public class BaseballCoach implements Coach {

    // define a private field fot the dependency
    final private FortuneService fortuneService;

    // define a constructor for dependency injection
    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyPractice() {
        return "Spend 30 minutes on batting practices";

    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
