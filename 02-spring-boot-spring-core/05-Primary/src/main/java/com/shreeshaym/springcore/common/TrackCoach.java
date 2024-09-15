package com.shreeshaym.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Run Hard for 5K !";
    }
}
