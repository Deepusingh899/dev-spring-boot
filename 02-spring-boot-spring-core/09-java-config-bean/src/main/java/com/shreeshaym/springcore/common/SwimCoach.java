package com.shreeshaym.springcore.common;

public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In Constructor : "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "<h1>Swim 1000 meter as a warm up</h1>";
    }
}
