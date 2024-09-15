package com.shreeshaym.springcore.config;
import com.shreeshaym.springcore.common.Coach;
import com.shreeshaym.springcore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
