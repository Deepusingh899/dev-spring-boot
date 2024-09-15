package com.shreeshaym.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "<h1>Spend 30 min for batting practice</h1>";
    }
}
