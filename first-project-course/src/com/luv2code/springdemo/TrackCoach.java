package com.luv2code.springdemo;

public class TrackCoach implements Coach {
    final private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }


    @Override
    public String getDailyPractice() {
        return "Run a hard 5K";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }

    // add an init method
    public void doMyStartUpStuff() {
        System.out.println("TrackCoach: inside method doMyStartUpStuff");
    }

    // add a destroy method
    public void doMyDestroyStuff() {
        System.out.println("TrackCoach: inside method doMyDestroyStuff");
    }
}
