package com.luv2code.springDemo.services;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    // create an array of strings
    private String[] data = {
           "Fortune one" ,
           "Fortune two" ,
           "Fortune three"
    };

    @Override
    public String getFortune() {
        var randomIndex = new Random().nextInt(data.length);
        return data[randomIndex];
    }
}
