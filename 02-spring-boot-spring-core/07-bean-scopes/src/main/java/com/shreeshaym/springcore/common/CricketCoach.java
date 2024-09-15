package com.shreeshaym.springcore.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In Constructor:- "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "<h1>Practice Daily with fast bowling for 15 minutes</h1>";
    }

}
