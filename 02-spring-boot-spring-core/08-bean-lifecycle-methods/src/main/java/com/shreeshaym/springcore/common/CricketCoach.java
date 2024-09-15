package com.shreeshaym.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In Constructor:- "+getClass().getSimpleName());
    }


    //Define Init Method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff: "+getClass().getSimpleName());
    }

    //Defin Destroy Method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "<h1>Practice Daily with fast bowling for 15 minutes</h1>";
    }

}
