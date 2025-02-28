package com.learn2code.AOPDemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
    @Override
    public String getFortune() {
        //simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //return a fortune
        return "Expect Heavy Traffic This Morning";


    }

    @Override
    public String getFortune(boolean tripWire) {
        if (tripWire){
            throw new RuntimeException("Major Accident Road is closed");
        }
        //return a fortune
        return getFortune();

    }

}
