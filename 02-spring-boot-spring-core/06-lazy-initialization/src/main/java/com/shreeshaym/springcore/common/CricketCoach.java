package com.shreeshaym.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In Constructor:- "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "<h1>Practice Daily with fast bowling for 15 minutes</h1>";
    }

}
