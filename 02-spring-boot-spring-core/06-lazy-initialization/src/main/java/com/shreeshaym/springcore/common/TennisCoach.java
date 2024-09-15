package com.shreeshaym.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("In Constructor:- "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "<h1> Spend 30 min for backhand volley practice</h1>";
    }
}
