package com.luv2code.springdemo;

public class CricketCoach implements Coach {
    private FortuneService fortuneService;
    private String emailAddress;
    private String name;
    private double charge;
    private int age;

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public CricketCoach() {
        System.out.println("CricketCoach: inside no-args constructor ");
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getDailyPractice() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return "Cricket coach: " + fortuneService.getFortune();
    }

    @Override
    public String toString() {
        return "CricketCoach{" +
                "emailAddress='" + emailAddress + '\'' +
                ", name='" + name + '\'' +
                ", charge=" + charge +
                ", age=" + age +
                '}';
    }
}
