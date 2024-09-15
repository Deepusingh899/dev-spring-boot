package com.shreeshaym.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "<h3>Practice Daily with fast bowling for 15 minutes</h3>";
    }

}
