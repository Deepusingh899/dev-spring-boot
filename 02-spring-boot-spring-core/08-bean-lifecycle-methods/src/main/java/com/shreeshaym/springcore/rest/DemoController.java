package com.shreeshaym.springcore.rest;

import com.shreeshaym.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define a private field for the dependency
    private Coach myCoach;

    //Define the setter for dependency injection
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
        System.out.println("In Constructor:- "+getClass().getSimpleName());
        myCoach=theCoach;
    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
