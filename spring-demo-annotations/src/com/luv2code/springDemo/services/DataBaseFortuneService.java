package com.luv2code.springDemo.services;

import org.springframework.stereotype.Component;

@Component
public class DataBaseFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return this.getClass().getName();
    }
}
